/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Export;
import com.app.model.entity.Operator;
import com.app.model.QaDIMDAO;
import com.app.model.entity.Demographics;
import com.app.model.entity.QadimProduct;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.chart.PieChart.Data;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jiaohui.lee.2014
 */
@WebServlet(name = "MainValidation", urlPatterns = {"/MainValidation"})
public class MainValidation extends HttpServlet {

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
            String productName = request.getParameter("productName");
            String userId = request.getParameter("userID");
            String projectName = request.getParameter("projectName");
            //Assigns a product ID to Product (Based on the number of products in the user's DB)
            int size = QaDIMDAO.retrieveNoOfProjects(userId);
            int productId = 0;
            if (size != 0){
                productId = size+1;
            }else{
                productId = 1;
            }
            QaDIMDAO.createQadimProduct(userId, projectName, productId, productName);
            
            int noOfOperators = Integer.parseInt(request.getParameter("numberOfBoxes"));
            ArrayList<Operator> oList = new ArrayList<>();
            for(int i = 1; i <=noOfOperators; i++){
                String operatorName = request.getParameter("operatorName"+i);
                String verb = request.getParameter("verb"+i);
                String generalPhrase = request.getParameter("generalPhrase"+i);
                String specificPhrase = request.getParameter("specificPhrase"+i);
                String dimension = request.getParameter("dimension"+i);
                
                int operatorId = Integer.parseInt(request.getParameter("operatorId"+i));
                Operator operator = new Operator(userId, operatorName, verb, generalPhrase, specificPhrase, dimension, productId, operatorId);
                oList.add(operator);
            }    

               QaDIMDAO.upload(oList);
               Export.Export(oList, productName, productId);
               //request.getRequestDispatcher("FileDownload").forward(request,response);
               response.sendRedirect("index.jsp");
                

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
