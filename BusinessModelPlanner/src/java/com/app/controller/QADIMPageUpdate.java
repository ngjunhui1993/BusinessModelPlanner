/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.QaDIMDAO;
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


@WebServlet(name = "QADIMPageUpdate", urlPatterns = {"/QADIMPageUpdate"})
public class QADIMPageUpdate extends HttpServlet {

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
            QaDIMDAO qadimDAO = new QaDIMDAO();
            //Retrieve operator & complimentary operator
            String projectName = request.getParameter("projectName");
            HttpSession session = request.getSession(true);
            Demographics loggedIn = (Demographics)session.getAttribute("user");
            String loggedInUserID = loggedIn.getUserid();
            //if project name exists, prompt user to input another name.
            if(qadimDAO.retrieveProjectByUser(projectName, loggedInUserID) != null) {
                request.setAttribute("errorMsg", "Project already exists. Enter new project name.");
                RequestDispatcher rd = request.getRequestDispatcher("QADIM.jsp");
                rd.forward(request, response);
                return;
            }
                
            String productName = request.getParameter("productName");
            String operatorName = request.getParameter("operatorName");
            String comOperatorName = request.getParameter("comOperatorName");
            String verb = request.getParameter("verb");
            String comVerb = request.getParameter("comVerb");
            String generalPhrase = request.getParameter("generalPhrase");
            String comGeneralPhrase = request.getParameter("comGeneralPhrase");
            String specificPhrase = request.getParameter("specificPhrase");
            String comSpecificPhrase = request.getParameter("comSpecificPhrase");
            String dimension = request.getParameter("dimension");
            String comDimension = request.getParameter("comDimension");
            String operator1 = request.getParameter("operator1");
            String operator2 = request.getParameter("operator2");
            String operator3 = request.getParameter("operator3");
            String operator4 = request.getParameter("operator4");
            
            String addOperatorCheck = request.getParameter("addOperatorCheck");
            String submit = request.getParameter("submit");
            //Delete Function
            if (submit != null && submit.equals("Delete")){
                if(operator1 != null){
                    request.getSession().setAttribute("operator1", null);
                }else if(operator2 != null){
                    request.getSession().setAttribute("operator2", null);
                }else if(operator3 != null){
                    request.getSession().setAttribute("operator3", null);
                }else if(operator4 != null){
                    request.getSession().setAttribute("operator4", null);
                }
                response.sendRedirect("QADIM.jsp");
                return;
            }
            if(projectName != null && productName != null){
                request.getSession().setAttribute("projectName", projectName);
                request.getSession().setAttribute("productName", productName);
                response.sendRedirect("QADIM.jsp");
                return;
            }else if(productName != null){
                request.getSession().setAttribute("productName", productName);
                response.sendRedirect("QADIM.jsp");
                return;
            }
            //Takes Operators & puts them into an Arraylist<String> to store to respective operator1/2/3/4
            if(addOperatorCheck != null){
                ArrayList<String> list = new ArrayList<String>();
                list.add(operatorName);
                list.add(comOperatorName);
                list.add(verb);
                list.add(comVerb);
                list.add(generalPhrase);
                list.add(comGeneralPhrase);
                list.add(specificPhrase);
                list.add(comSpecificPhrase);
                list.add(dimension);
                list.add(comDimension);
                for (int i = 1; i <= 4; i++){
                    String operatorNum = "operator"+i;
                    if(request.getSession().getAttribute(operatorNum)==null){
                        request.getSession().setAttribute(operatorNum, list);
                        break;
                    }
                }
            }else if(operator1 != null){
                ArrayList<String> list = new ArrayList<String>();
                list.add(operatorName);
                list.add(comOperatorName);
                list.add(verb);
                list.add(comVerb);
                list.add(generalPhrase);
                list.add(comGeneralPhrase);
                list.add(specificPhrase);
                list.add(comSpecificPhrase);
                list.add(dimension);
                list.add(comDimension);
                request.getSession().setAttribute("operator1", list);
            }else if(operator2 != null){
                ArrayList<String> list = new ArrayList<String>();
                list.add(operatorName);
                list.add(comOperatorName);
                list.add(verb);
                list.add(comVerb);
                list.add(generalPhrase);
                list.add(comGeneralPhrase);
                list.add(specificPhrase);
                list.add(comSpecificPhrase);
                list.add(dimension);
                list.add(comDimension);
                request.getSession().setAttribute("operator2", list);
            }else if(operator3 != null){
                ArrayList<String> list = new ArrayList<String>();
                list.add(operatorName);
                list.add(comOperatorName);
                list.add(verb);
                list.add(comVerb);
                list.add(generalPhrase);
                list.add(comGeneralPhrase);
                list.add(specificPhrase);
                list.add(comSpecificPhrase);
                list.add(dimension);
                list.add(comDimension);
                request.getSession().setAttribute("operator3", list);
            }else if(operator4 != null){
                ArrayList<String> list = new ArrayList<String>();
                list.add(operatorName);
                list.add(comOperatorName);
                list.add(verb);
                list.add(comVerb);
                list.add(generalPhrase);
                list.add(comGeneralPhrase);
                list.add(specificPhrase);
                list.add(comSpecificPhrase);
                list.add(dimension);
                list.add(comDimension);
                request.getSession().setAttribute("operator4", list);
            }
            
            response.sendRedirect("QADIM.jsp");
            return;
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
