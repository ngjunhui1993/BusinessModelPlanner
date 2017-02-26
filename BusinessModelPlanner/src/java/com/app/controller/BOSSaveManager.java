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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jiaohui.lee.2014
 */
@WebServlet(name = "BOSSaveManager", urlPatterns = {"/BOSSaveManager"})
public class BOSSaveManager extends HttpServlet {

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
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            String[] factorList = request.getParameterValues("savedFactors"); //Need to split to operator_id && product_id
            String[] gridList = request.getParameterValues("savedGrids");
            String[] originalValueList = request.getParameterValues("dotA");
            String[] newValueList = request.getParameterValues("dotB");
            String projectName = request.getParameter("projectName");
            String[] weightList = request.getParameterValues("weight");
            String[] maxValue = request.getParameterValues("max_value");
            String[] perUnitValueList = request.getParameterValues("per_unit_value");
            
            String errorMsg = "";
            String successMsg = "";
            boolean saveComplete = false;
            
            Demographics user = (Demographics)request.getSession().getAttribute("user");
            String userid = user.getName();
            int size = BOSDAO.retrieveNoOfProjects(userid);
            BOSProduct projectExist = BOSDAO.retrieveProjectByUser(projectName, userid);
            
            int productId = 0;
            if (size != 0) {
                productId = size + 1;
            } else {
                productId = 1;
            }

            BOSDAO.createProject(userid, projectName, productId);

            //May not be necessary
            //String originalProductName = request.getParameter("originalProductName");
            ArrayList<BOSOperator> operatorList = new ArrayList<>();
            for (String factorName : factorList){
                int factorid = 0;
                factorid++;
                for(String grid : gridList){
                    int gridNumber = Integer.parseInt(grid);
                    for(String weight: weightList){
                        int weightNumber = Integer.parseInt(weight);
                        for (String perUnitValue :perUnitValueList){
                            int perUnitValueNumber = Integer.parseInt(perUnitValue);
                            for (String o : originalValueList){
                                int originalValue = Integer.parseInt(o);
                                for (String n : newValueList){
                                    int newValue = Integer.parseInt(n);
                                    if (projectExist == null){
                                        BOSDAO.createOperator(userid, projectName, factorid, factorName,weightNumber,gridNumber,perUnitValueNumber,originalValue,newValue);
                                        successMsg = "Save Complete";
                                    }else if (projectExist!=null){
                                        boolean checkOperatorExist = BOSDAO.checkOperatorExist(userid, projectName, factorid, factorName,weightNumber,gridNumber,perUnitValueNumber,originalValue,newValue);
                                        successMsg = "Save Complete";
                                        if(checkOperatorExist){
                                            BOSDAO.editOperator(userid, projectName, factorid, factorName,weightNumber,gridNumber,perUnitValueNumber,originalValue,newValue);
                                            successMsg = "Save Complete";
                                        }else{
                                            BOSDAO.createOperator(userid, projectName, factorid, factorName,weightNumber,gridNumber,perUnitValueNumber,originalValue,newValue);
                                            successMsg = "Save Complete";
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                saveComplete = true;
            }
            
            if (!saveComplete){
                errorMsg = "Save function was interuptted";
            }
            
            String toReturn ="";
            if (errorMsg!=null){
                toReturn = errorMsg;
            }else if(successMsg!=null){
                toReturn = successMsg;
            }
            request.setAttribute("toReturn", toReturn);
            request.getRequestDispatcher("BOSC.jsp").forward(request,response);
            
            
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
