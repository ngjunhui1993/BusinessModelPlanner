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

        String projectName = (String) request.getSession().getAttribute("projectName");
        Demographics user = (Demographics)request.getSession().getAttribute("user");
        String userid = user.getUserid();
        String productName = (String)request.getParameter("saveProductName");
        
        // ----------- Validation for Save/Load/ Existing Project on DataBase ----------
        //if existing project have been loaded, the editcheck will be == projectName
        String editCheck = (String)request.getSession().getAttribute("editCheck");
        //Check if project is currently in the database
        QadimProduct projectChecker = QaDIMDAO.retrieveProject(projectName);
        
        ArrayList<Operator> validOperatorsList = new ArrayList<>();
        int productid = 0;
        
        //if no, create new project
        if (projectChecker == null){
            Operator validOperator = null;
            String validName ="";
            String validComment ="";

            productid = QaDIMDAO.retrieveNoOfProjects(userid);
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
            //if no, replace the current values on the database
        }else{
            productid = projectChecker.getProductID();
            Operator validOperator = null;
            String validName ="";
            String validComment ="";

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
        }
        // ----------------------- If User is starting a NEW Project -----------------------
        if(editCheck == null && projectChecker == null||!(editCheck.equals(projectName))&& projectChecker == null){
            // ----------------------- Saving onto Database -----------------------
            QaDIMDAO.createQadimProduct(userid , projectName , productid , productName);
            QaDIMDAO.upload(validOperatorsList);
            // ----------------------- Creation of Excel -----------------------
            Excel.Export(userid, validOperatorsList, projectName, productName, productid);
            
        // ----------------------- If User is editting on existing Project  -----------------------
        }else{
            // ----------------------- Saving onto Database -----------------------
            QaDIMDAO.deleteProject(productid, userid);
            QaDIMDAO.deleteOperators(productid, userid);
            QaDIMDAO.createQadimProduct(userid , projectName , productid , productName);
            QaDIMDAO.upload(validOperatorsList);
            // ----------------------- Creation of Excel -----------------------
            Excel.delete(userid, projectName);
            Excel.Export(userid, validOperatorsList, projectName, productName, productid);
        }
        // Saving the project onto the session to recognise that it has been saved.
        request.getSession().setAttribute("editCheck", projectName);
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
