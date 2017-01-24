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
            /* TODO output your page here. You may use following sample code. */
            Demographics user = (Demographics)request.getSession().getAttribute("user");
            String userid = user.getUserid();
            String projectName = request.getParameter("projectList");
            request.getSession().setAttribute("projectName", projectName);
            QadimProduct project=QaDIMDAO.retrieveProject(projectName);
            String productName = project.getProductName();
            request.getSession().setAttribute("productName", productName);
            int productId = project.getProductID();
            ArrayList<Operator> oList = QaDIMDAO.retrieveOperators(productId, userid);
            
            ArrayList<String> operator1 = new ArrayList<String>();
            ArrayList<String> operator2 = new ArrayList<String>();
            ArrayList<String> operator3 = new ArrayList<String>();
            ArrayList<String> operator4 = new ArrayList<String>();
            
            int noOfOperator = oList.size();
            
            String OperatorName = null;
            String comments = null;
            String comOperatorName = null;
            String comComments = null;

            for (int i=0; i <noOfOperator; i++){
                if(i%2==0){
                    OperatorName = oList.get(i).getOperatorName();
                    comments = oList.get(i).getComments();
                }else{
                    comOperatorName = oList.get(i).getOperatorName();
                    comComments = oList.get(i).getComments();
                    if(i == 1){
                        operator1.add(OperatorName);
                        operator1.add(comOperatorName);
                        operator1.add(comments);
                        operator1.add(comComments);
                        request.getSession().setAttribute("operator1", operator1);
                    }else if (i ==3){
                        operator2.add(OperatorName);
                        operator2.add(comOperatorName);
                        operator2.add(comments);
                        operator2.add(comComments);
                        request.getSession().setAttribute("operator2", operator2);
                    }else if (i == 5){
                        operator3.add(OperatorName);
                        operator3.add(comOperatorName);
                        operator3.add(comments);
                        operator3.add(comComments);
                        request.getSession().setAttribute("operator3", operator3);
                    }else if(i== 7){
                        operator4.add(OperatorName);
                        operator4.add(comOperatorName);
                        operator4.add(comments);
                        operator4.add(comComments);
                        request.getSession().setAttribute("operator4", operator4);
                    }
                }
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
