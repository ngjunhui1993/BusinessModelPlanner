/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.BOSDAO;
import com.app.model.entity.BOSProduct;
import com.app.model.entity.Demographics;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        HttpSession session = request.getSession(true);
        Demographics loggedIn = (Demographics) session.getAttribute("user");
        // System.out.println(loggedIn.getUserid());
        String loggedInUser = loggedIn.getUserid();

        BOSDAO bosDAO = new BOSDAO();
        if (request.getParameter("createProject") != null) {
            String projectName = request.getParameter("projectName");
            String productName = request.getParameter("productName");
            String budget = request.getParameter("budget");
            Double budgetDouble = 0.0;

            if (projectName == null || projectName.equals("") || productName == null || productName.equals("") || budget == null || budget.equals("")) {
                request.setAttribute("errorMsg", "Please do not leave any blanks.");
                RequestDispatcher rd = request.getRequestDispatcher("BlueOceanStrategy.jsp");
                rd.forward(request, response);
                return;
            }

            try {
                budgetDouble = Double.parseDouble(budget);
            } catch (NumberFormatException ex) {
                request.setAttribute("errorMsg", "Budget should be digit.");
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
                if (prodOrServ.equals("typeProduct")) {
                    prodOrServ = "product";
                } else {
                    prodOrServ = "service";
                }
                bosDAO.createProject(loggedInUser, projectName, productID, productName, prodOrServ, budgetDouble);
                session.setAttribute("bosProjectName", projectName);
                response.sendRedirect("BlueOceanStrategyObject.jsp?projectName=" + projectName + "&productID=" + productID + "&productName=" + productName + "&type=" + prodOrServ + "&budget=" + budgetDouble);

            }
        }

        if (request.getParameter("addOperator") != null) {
            String projectName = (String) session.getAttribute("bosProjectName");
            String operatorName = request.getParameter("operatorName");
            String weight = request.getParameter("weight");
            String maxValue = request.getParameter("maxValue");
            String costPerUnit = request.getParameter("costPerUnit");
            int weightInt = 0;
            int maxValueInt = 0;
            int costPerUnitInt = 0;

            if (operatorName == null || operatorName.equals("") || weight == null || weight.equals("") || maxValue == null || maxValue.equals("") || costPerUnit == null || costPerUnit.equals("")) {
                request.setAttribute("errorMsg", "Please do not leave any blanks.");
                RequestDispatcher rd = request.getRequestDispatcher("AddingBosOperator.jsp");
                rd.forward(request, response);
                return;
            }

            //check if operator already exists.
            ArrayList<String> operators = bosDAO.retrieveOperators(projectName, loggedInUser);
            boolean operatorExist = false;
            for (String op : operators) {
                if (op.equals(operatorName)) {
                    operatorExist = true;
                }
            }

            if (operatorExist) {
                request.setAttribute("errorMsg", "Operator exists.");
                RequestDispatcher rd = request.getRequestDispatcher("AddingBosOperator.jsp");
                rd.forward(request, response);
                return;
            }

            try {
                weightInt = Integer.parseInt(weight);
                maxValueInt = Integer.parseInt(maxValue);
                costPerUnitInt = Integer.parseInt(costPerUnit);
            } catch (NumberFormatException ex) {
                request.setAttribute("errorMsg", "Please only input Integer digit for weight, max value and cost per unit increase.");
                RequestDispatcher rd = request.getRequestDispatcher("AddingBosOperator.jsp");
                rd.forward(request, response);
                return;
            }
            
            if(weightInt < 0 || weightInt > 5) {
                request.setAttribute("errorMsg", "Weight should be within 0 to 5.");
                RequestDispatcher rd = request.getRequestDispatcher("AddingBosOperator.jsp");
                rd.forward(request, response);
                return;
            }
            
            if(maxValueInt < costPerUnitInt) {
                request.setAttribute("errorMsg", "Cost per unit value should not be more than max value.");
                RequestDispatcher rd = request.getRequestDispatcher("AddingBosOperator.jsp");
                rd.forward(request, response);
                return;
            }
            
            if(maxValueInt % costPerUnitInt != 0) {
                while(maxValueInt % costPerUnitInt != 0) {
                    costPerUnitInt++;
                }
            }
            
            BOSProduct product = bosDAO.retrieveProjectByUser(projectName, loggedInUser);
            int numOfOperators = 0;
            if (operators != null) {
                numOfOperators = operators.size();
            }
            int operatorID = numOfOperators + 1;
            try {
                bosDAO.createOperator(loggedInUser, projectName, product.getProductID(), operatorID, operatorName, weightInt, maxValueInt, costPerUnitInt, 0, 0, "");
            } catch (Exception ex) {
                request.setAttribute("errorMsg", "Database error. Please try again.");
                RequestDispatcher rd = request.getRequestDispatcher("BlueOceanStrategyObject.jsp");
                rd.forward(request, response);
                return;
            }
            
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
