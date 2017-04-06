/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.BOSDAO;
import com.app.model.entity.BOSOperator;
import com.app.model.entity.BOSProduct;
import com.app.model.entity.Demographics;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author farkill
 */
@WebServlet(name = "BOSCPageUpdate", urlPatterns = {"/BOSCPageUpdate"})
public class BOSCPageUpdate extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String checkNewProject = request.getParameter("newProject");
            String startNewProject = request.getParameter("startNewProject");
            String projectToLoad = request.getParameter("projectToLoad");
            if(checkNewProject != null){
                request.getSession().setAttribute("BOSCNewProject", "false");
                response.sendRedirect("BOSC.jsp");
                return;
            }
            
            if (startNewProject != null){
                request.getSession().setAttribute("BOSCNewProject", "true");
                request.getSession().setAttribute("currentValue", null);
                request.getSession().setAttribute("operatorList", null);
                response.sendRedirect("BOSC.jsp");
                return;
            }
            
            if (projectToLoad!=null){
                Demographics user = (Demographics)request.getSession().getAttribute("user");
                String username = user.getUserid();
                BOSProduct projectLoaded= BOSDAO.retrieveProjectByUser(projectToLoad, username);
                //Verify that project is on DataBase
                if (projectLoaded!=null){
                    //All operators are in here for the project you are retrieving
                    ArrayList<BOSOperator> operatorList =  BOSDAO.getAllOperators(username,projectToLoad);
                    request.getSession().setAttribute("currentValue", projectLoaded.getOriginalCost());
                    request.getSession().setAttribute("operatorList", operatorList);
                    
                }
                request.getSession().setAttribute("BOSCEditChecker", projectToLoad);
                request.getSession().setAttribute("BOSCNewProject", "false");
                response.sendRedirect("BOSC.jsp");
                return;
            }
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
