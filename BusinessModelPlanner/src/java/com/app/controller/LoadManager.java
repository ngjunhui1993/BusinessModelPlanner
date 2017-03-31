/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.QaDIMDAO;
import com.app.model.entity.Demographics;
import com.app.model.entity.Operator;
import com.app.model.entity.QadimProduct;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jiaohui.lee.2014
 */
@WebServlet(name = "LoadManager", urlPatterns = {"/LoadManager"})
public class LoadManager extends HttpServlet {

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
            Demographics user = (Demographics)request.getSession().getAttribute("user");
            String userid = user.getUserid();
            String projecttoLoad = request.getParameter("toLoadQadim");
            
            // ------------- Sets editCheck to check if project is loaded but not newly created -------------
            request.getSession().setAttribute("editCheck", projecttoLoad);
            
            
            // ------------- Retrieve from Database -------------
            QadimProduct project=QaDIMDAO.retrieveProject(projecttoLoad);
            String productName = project.getProductName();
            String projectName = project.getProjectName();
            request.getSession().setAttribute("productName", productName);
            request.getSession().setAttribute("projectName", projectName);
            int productId = project.getProductID();
            ArrayList<Operator> oList = QaDIMDAO.retrieveOperators(productId, userid);
            
            int noOfOperator = oList.size();
            
            String operatorName = null;
            String operatorComments = null;
            Operator currentOperator = null;
            
            //---------- Unpacks all the operators retrieved from database ----------
            for(int i = 0; i< noOfOperator; i++){
                currentOperator = oList.get(i);
                operatorName = currentOperator.getOperatorName();
                operatorComments = currentOperator.getComments();
                int numbering = 1;
                //---------- Sets all the operators back to the same naming convention for UI ----------
                request.getSession().setAttribute("opName"+numbering,operatorName);
                request.getSession().setAttribute("opComment"+numbering,operatorComments);
            }

            response.sendRedirect("QADIM.jsp");
            return;
            //request.getRequestDispatcher("QADIM.jsp").forward(request,response);
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
