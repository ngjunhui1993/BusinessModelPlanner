/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.BOSDAO;
import com.app.model.entity.Demographics;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebServlet(name = "BOSUpdate", urlPatterns = {"/BOSUpdate"})
public class BOSUpdate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        BOSDAO bosDAO = new BOSDAO();
        String projectName = request.getParameter("projectName");
        String productName = request.getParameter("productName");
        HttpSession session = request.getSession(true);
        Demographics loggedIn = (Demographics) session.getAttribute("user");
       // System.out.println(loggedIn.getUserid());
        String loggedInUser = loggedIn.getUserid();

        if (projectName == null || projectName.equals("") || productName == null || productName.equals("")) {
            request.setAttribute("errorMsg", "Please do not leave any blanks.");
            RequestDispatcher rd = request.getRequestDispatcher("BlueOceanStrategy.jsp");
            rd.forward(request, response);
            return;
        }

//if project name exists, prompt user to input another name.
        if (bosDAO.retrieveProjectByUser(projectName, loggedInUser) != null) {
            request.setAttribute("errorMsg", "Project already exists. Enter new project name.");
            RequestDispatcher rd = request.getRequestDispatcher("BlueOceanStrategy.jsp");
            rd.forward(request, response);
            return;
        } else {
            int noOfProj = bosDAO.retrieveNoOfProjects(loggedInUser);
            int productID = noOfProj + 1;
            String prodOrServ = request.getParameter("type");
            if(prodOrServ.equals("typeProduct")) {
                prodOrServ = "product";
            } else {
                prodOrServ = "service";
            }
            bosDAO.createProject(loggedInUser, projectName, productID, productName, prodOrServ);
            response.sendRedirect("BlueOceanStrategyObject.jsp");
            
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
