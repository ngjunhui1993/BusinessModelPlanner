/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.QaDIMDAO;
import com.app.model.entity.Demographics;
import com.app.model.entity.Operator;
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
@WebServlet(name = "QADIMManager", urlPatterns = {"/QADIMManager"})
public class QADIMManager extends HttpServlet {

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
            Boolean delete = false;
            Boolean edit = false;
            
            if(request.getParameter("delete")!=null){
                delete = true;
            }
            if(request.getParameter("edit")!=null){
                edit = true;
            }
            Demographics userId = (Demographics)request.getSession().getAttribute("user");
            String project = request.getParameter("project");
            String errorMsg = "";
            
            if(project!=null){
                if (delete){
                    int productId = QaDIMDAO.retrieveProject(project).getProductID();
                    QaDIMDAO.deleteProject(productId, userId);
                }
                else if(edit){
                    ArrayList<Operator> operators = QaDIMDAO.retrieveOperators(Integer.parseInt(project), userId);
                    ArrayList<Operator> toUpload = null;
                    for (int i =1; i<=operators.size();i++){
                        Operator operator = null;
                        String operatorName = request.getParameter("operatorName"+i);
                        String verb = request.getParameter("verb"+i);
                        String generalPhrase = request.getParameter("generalPhrase"+i);
                        String specificPhrase = request.getParameter("specificPhrase"+i);
                        String dimension = request.getParameter("dimension"+i);
                        int operatorId = i;
                        operator = new Operator(userId, operatorName, verb, generalPhrase, specificPhrase, dimension,Integer.parseInt(edit), operatorId);
                        toUpload.add(operator);
                        QaDIMDAO.update(toUpload);
                    }
                }
            }
                errorMsg="Please Select a Project";
                request.getReqestDispatcher("")
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
