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
            //Retrieve projectname, productname, productdescription from QADIMnewProject.jsp
            String projectName = request.getParameter("projectName");       
            String productName = request.getParameter("productName");
            //Retrieve current userid from the session
            HttpSession session = request.getSession(true);
            Demographics loggedIn = (Demographics) session.getAttribute("user");
            String loggedInUserID = loggedIn.getUserid();  
            
            
            //-------------------- Start of Validation for New Project --------------------
            
            //Check if objects from QADIMNewProject.jsp is valid
                //PS: Destination of errormsgs unclear
            if(projectName == null || productName == null ){
                request.setAttribute("errorMsg", "Empty field(s).");
                RequestDispatcher rd = request.getRequestDispatcher("QADIMnewProject.jsp");
                rd.forward(request, response);
                return;
            //prevents nullpointerexception  
                //PS: Destination of errormsgs unclear
            }else if(projectName.trim().equals("")|| productName.trim().equals("")){
                request.setAttribute("errorMsg", "Empty field(s).");
                RequestDispatcher rd = request.getRequestDispatcher("QADIMnewProject.jsp");
                rd.forward(request, response);
                return;
            }
            
            if(request.getParameter("submitProjNameChange") == null) {
                //if project name exists, prompt user to input another name.
                    //PS: Destination of errormsgs unclear
                if (QaDIMDAO.retrieveProjectByUser(projectName, loggedInUserID) != null) {
                    request.setAttribute("errorMsg", "Project already exists. Enter new project name.");
                    RequestDispatcher rd = request.getRequestDispatcher("QADIMnewProject.jsp");
                    rd.forward(request, response);
                    return;
                }else{
                    request.getSession().setAttribute("projectName", projectName);
                    request.getSession().setAttribute("productName", productName);
                    
                    // ----------- Clear session of any possible operators in the sesssion ----------
                    String operatorName = "";
                    String operatorComments = "";
                    for(int i = 0; i < 8; i++){
                        int numbering = i+1;
                        //---------- Sets all the operators back to the same naming convention for UI ----------
                        request.getSession().setAttribute("opName"+numbering,operatorName);
                        request.getSession().setAttribute("opComment"+numbering,operatorComments);
                    }
                    response.sendRedirect("QADIM.jsp");
                        return;
                }
            //-------------------- End of Validation for newly created Projects --------------------
            
            //When user accesses a current project and changes the projectName
            
            }else{   
                    String newProjName = request.getParameter("newProjectName");
                    if(newProjName == null || newProjName.equals("")) {
                    request.setAttribute("errorMsg", "Please key in your desired new name for project.");
                    RequestDispatcher rd = request.getRequestDispatcher("QADIM.jsp");
                    rd.forward(request, response);
                    return;
                    }
                QaDIMDAO.editProjectName(projectName, loggedInUserID, newProjName);
                request.getSession().setAttribute("projectName", newProjName);
                response.sendRedirect("QADIM.jsp");
            }

            /*
            String operator1 = request.getParameter("operator1");
            String operator2 = request.getParameter("operator2");
            String operator3 = request.getParameter("operator3");
            String operator4 = request.getParameter("operator4");

            String addOperatorCheck = request.getParameter("addOperatorCheck");
            String submit = request.getParameter("submit");
            //Delete Function
            if (submit != null && submit.equals("Delete")) {
                if (operator1 != null) {
                    request.getSession().setAttribute("operator1", null);
                } else if (operator2 != null) {
                    request.getSession().setAttribute("operator2", null);
                } else if (operator3 != null) {
                    request.getSession().setAttribute("operator3", null);
                } else if (operator4 != null) {
                    request.getSession().setAttribute("operator4", null);
                }
                response.sendRedirect("QADIM.jsp");
                return;
            }
            if (projectName != null && productName != null) {
                request.getSession().setAttribute("projectName", projectName);
                request.getSession().setAttribute("productName", productName);
                response.sendRedirect("QADIM.jsp");
                return;
            } else if (productName != null) {
                request.getSession().setAttribute("productName", productName);
                response.sendRedirect("QADIM.jsp");
                return;
            }
            //Takes Operators & puts them into an Arraylist<String> to store to respective operator1/2/3/4
            if (addOperatorCheck != null) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(operatorName);
                list.add(comOperatorName);
                list.add(comments);
                list.add(comComments);
                for (int i = 1; i <= 4; i++) {
                    String operatorNum = "operator" + i;
                    if (request.getSession().getAttribute(operatorNum) == null) {
                        request.getSession().setAttribute(operatorNum, list);
                        break;
                    }
                }
            } else if (operator1 != null) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(operatorName);
                list.add(comOperatorName);
                list.add(comments);
                list.add(comComments);
                request.getSession().setAttribute("operator1", list);
            } else if (operator2 != null) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(operatorName);
                list.add(comOperatorName);
                list.add(comments);
                list.add(comComments);
                request.getSession().setAttribute("operator2", list);
            } else if (operator3 != null) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(operatorName);
                list.add(comOperatorName);
                list.add(comments);
                list.add(comComments);
                request.getSession().setAttribute("operator3", list);
            } else if (operator4 != null) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(operatorName);
                list.add(comOperatorName);
                list.add(comments);
                list.add(comComments);
                request.getSession().setAttribute("operator4", list);
            }

            response.sendRedirect("QADIM.jsp");
            return;*/
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
