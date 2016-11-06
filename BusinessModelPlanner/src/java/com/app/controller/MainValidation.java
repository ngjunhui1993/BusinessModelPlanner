/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Excel;
import com.app.model.entity.Operator;
import com.app.model.QaDIMDAO;
import com.app.model.entity.Demographics;
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
            ArrayList<String> operator1 = (ArrayList<String>) request.getSession().getAttribute("operator1");
            ArrayList<String> operator2 = (ArrayList<String>) request.getSession().getAttribute("operator2");
            ArrayList<String> operator3 = (ArrayList<String>) request.getSession().getAttribute("operator3");
            ArrayList<String> operator4 = (ArrayList<String>) request.getSession().getAttribute("operator4");

            String productName = (String) request.getSession().getAttribute("productName");
            String projectName = (String) request.getSession().getAttribute("projectName");
            Demographics user = (Demographics) request.getSession().getAttribute("user");
            String userId = user.getUserid();
            int size = QaDIMDAO.retrieveNoOfProjects(userId);
            int productId = 0;
            if (size != 0) {
                productId = size + 1;
            } else {
                productId = 1;
            }

            String save = request.getParameter("Save");
            boolean savefunction = false;
            boolean projectExists = false;
            //Checks which button was clicked
            if (save != null && save.equals("Save")) {
                savefunction = true;
                System.out.println("Test");
            } else if (save != null && save.equals("New / Load Project")) {
                request.getSession().setAttribute("productName", null);
                request.getSession().setAttribute("projectName", null);
                request.getSession().setAttribute("operator1", null);
                request.getSession().setAttribute("operator2", null);
                request.getSession().setAttribute("operator3", null);
                request.getSession().setAttribute("operator4", null);
                System.out.println("LOL");
                response.sendRedirect("QADIM.jsp");
                return;
            }
            if (savefunction) {
                //check if project is an existing project user is editing
                if (QaDIMDAO.retrieveProject(projectName) != null) {
                    QadimProduct product = QaDIMDAO.retrieveProject(projectName);
                    if (product.getProductName().equals(productName)) {
                        projectExists = true;
                        productId = product.getProductID();
                    }
                }

                ArrayList<Operator> oList = new ArrayList<>();

                if (operator1 != null) {
                    String operatorName = operator1.get(0);
                    String comOperatorName = operator1.get(1);
                    String verb = operator1.get(2);
                    String comVerb = operator1.get(3);
                    String generalPhrase = operator1.get(4);
                    String comGeneralPhrase = operator1.get(5);
                    String specificPhrase = operator1.get(6);
                    String comSpecificPhrase = operator1.get(7);
                    String dimension = operator1.get(8);
                    String comDimension = operator1.get(9);
                    int operatorid = 1;
                    int operatorid2 = 2;
                    Operator operatorOne = new Operator(userId, operatorName, verb, generalPhrase, specificPhrase, dimension, productId, operatorid);
                    Operator operatorTwo = new Operator(userId, comOperatorName, comVerb, comGeneralPhrase, comSpecificPhrase, comDimension, productId, operatorid2);
                    oList.add(operatorOne);
                    oList.add(operatorTwo);
                }
                if (operator2 != null) {
                    String operatorName2 = operator2.get(0);
                    String comOperatorName2 = operator2.get(1);
                    String verb2 = operator2.get(2);
                    String comVerb2 = operator2.get(3);
                    String generalPhrase2 = operator2.get(4);
                    String comGeneralPhrase2 = operator2.get(5);
                    String specificPhrase2 = operator2.get(6);
                    String comSpecificPhrase2 = operator2.get(7);
                    String dimension2 = operator2.get(8);
                    String comDimension2 = operator2.get(9);
                    int operatorid3 = 3;
                    int operatorid4 = 4;
                    Operator operatorThree = new Operator(userId, operatorName2, verb2, generalPhrase2, specificPhrase2, dimension2, productId, operatorid3);
                    Operator operatorFour = new Operator(userId, comOperatorName2, comVerb2, comGeneralPhrase2, comSpecificPhrase2, comDimension2, productId, operatorid4);
                    oList.add(operatorThree);
                    oList.add(operatorFour);
                }
                if (operator3 != null) {
                    String operatorName3 = operator3.get(0);
                    String comOperatorName3 = operator3.get(1);
                    String verb3 = operator3.get(2);
                    String comVerb3 = operator3.get(3);
                    String generalPhrase3 = operator3.get(4);
                    String comGeneralPhrase3 = operator3.get(5);
                    String specificPhrase3 = operator3.get(6);
                    String comSpecificPhrase3 = operator3.get(7);
                    String dimension3 = operator3.get(8);
                    String comDimension3 = operator3.get(9);
                    int operatorid5 = 5;
                    int operatorid6 = 6;
                    Operator operatorFive = new Operator(userId, operatorName3, verb3, generalPhrase3, specificPhrase3, dimension3, productId, operatorid5);
                    Operator operatorSix = new Operator(userId, comOperatorName3, comVerb3, comGeneralPhrase3, comSpecificPhrase3, comDimension3, productId, operatorid6);
                    oList.add(operatorFive);
                    oList.add(operatorSix);
                }
                if (operator4 != null) {
                    String operatorName4 = operator4.get(0);
                    String comOperatorName4 = operator4.get(1);
                    String verb4 = operator4.get(2);
                    String comVerb4 = operator4.get(3);
                    String generalPhrase4 = operator4.get(4);
                    String comGeneralPhrase4 = operator4.get(5);
                    String specificPhrase4 = operator4.get(6);
                    String comSpecificPhrase4 = operator4.get(7);
                    String dimension4 = operator4.get(8);
                    String comDimension4 = operator4.get(9);
                    int operatorid7 = 7;
                    int operatorid8 = 8;
                    Operator operatorSeven = new Operator(userId, operatorName4, verb4, generalPhrase4, specificPhrase4, dimension4, productId, operatorid7);
                    Operator operatorEight = new Operator(userId, comOperatorName4, comVerb4, comGeneralPhrase4, comSpecificPhrase4, comDimension4, productId, operatorid8);
                    oList.add(operatorSeven);
                    oList.add(operatorEight);
                }
                if (!projectExists) {
                    QaDIMDAO.createQadimProduct(userId, projectName, productId, productName);
                    QaDIMDAO.upload(oList);
                    Excel.Export(userId, oList, projectName, productName, productId);
                } else {
                    ArrayList<Operator> currentOperators = QaDIMDAO.retrieveOperators(productId, userId);
                    int sizeOfCurrentOperators = currentOperators.size();
                    if(sizeOfCurrentOperators == 8 && sizeOfCurrentOperators == oList.size()) {
                        QaDIMDAO.update(oList, userId);
                        Excel.Export(userId, oList, projectName, productName, productId);
                    } else{
                        QaDIMDAO.deleteOperators(productId, userId);
                        QaDIMDAO.upload(oList);
                        Excel.delete(userId, projectName);
                        Excel.Export(userId, oList, projectName, productName, productId);
                    } 
                        
                }
                response.sendRedirect("index.jsp");

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
