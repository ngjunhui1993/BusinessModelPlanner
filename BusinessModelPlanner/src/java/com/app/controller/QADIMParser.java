/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Excel;
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
 * @author junhui.ng.2014
 */
@WebServlet(name = "QADIMParser", urlPatterns = {"/QADIMParser"})
public class QADIMParser extends HttpServlet {

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

        String projectName = (String) request.getParameter("saveQADIMProjectName");
        Demographics user = (Demographics)request.getSession().getAttribute("user");
        String userid = user.getUserid();
        String productName = (String) request.getSession().getAttribute("productName");
        
        //if exisiting project have been loaded, the editcheck will be == projectName
        String editCheck = (String)request.getSession().getAttribute("editCheck");
        
            ArrayList<Operator> validOperatorsList = new ArrayList<>();
            Operator validOperator = null;
            String validName ="";
            String validComment ="";

            int productid = QaDIMDAO.retrieveNoOfProjects(userid);
            productid++;

            int validOperatorId = 1;
            //retrieve all the items and checks if they are empty
            for(int i = 1; i <= 8; i++){
                validName = (String)request.getParameter("opName"+i);
                validComment = (String)request.getParameter("opComment"+i);
                if(validName!=null && validComment!=null){
                    validOperator = new Operator (userid, validName.trim(), productid , validOperatorId, validComment.trim());
                    validOperatorsList.add(validOperator); 
                    validOperatorId++;
                }
            }
        // ----------------------- If User is starting a NEW Project -----------------------
        if(!(editCheck.equals(projectName))){
        
            // ----------------------- Saving onto Database -----------------------
            QaDIMDAO.createQadimProduct(userid , projectName , productid , productName);
            QaDIMDAO.upload(validOperatorsList);
            // ----------------------- Creation of Excel -----------------------
            Excel.Export(userid, validOperatorsList, projectName, productName, productid);
            
        // ----------------------- If User is editting on existing Project  -----------------------
        }else{
            // ----------------------- Saving onto Database -----------------------
            QaDIMDAO.deleteOperators(productid, userid);
            QaDIMDAO.upload(validOperatorsList);
            Excel.delete(userid, projectName);
            Excel.Export(userid, validOperatorsList, projectName, productName, productid);
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
