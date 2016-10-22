/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.ConnectionManager;
import com.app.model.entity.Demographics;
import com.app.model.DemographicsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Register", urlPatterns = {"/Register"})
/**
 *Login controller process login username and password and redirects users to relevant page.
 * 
 */
public class Register extends HttpServlet {  

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
            String register = request.getParameter("submit");
            
            if(register == null){
                response.sendRedirect("index.jsp");
                return;
            }
            //retrieve the name sent from the form
           String name = request.getParameter("name").trim();
           //retrieve the email id sent from the form
           String email = request.getParameter("email").trim();
           //retrieve the password sent from the form
           String password = request.getParameter("password").trim();
           DemographicsDAO demoDAO = new DemographicsDAO();
           if(email=="" || password == "" || name == ""){
               request.setAttribute("errorMsg", "Please do not leave any fields blank");
               RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
               rd.forward(request, response);
               return;
            }else if(demoDAO.userExist(email)){
               request.setAttribute("errorMsg", "The email had been registered. Please use another email address!");
               RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
               rd.forward(request, response);
               return;
            }else if(email.indexOf('@')==-1){
               request.setAttribute("errorMsg", "The email address entered is invalid. Please Enter a valid email address!");
               RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
               rd.forward(request, response);
               return;
            }
           
            Connection conn = null ;
            PreparedStatement pstmt = null ;
            ResultSet rs = null ;
            String statement = null ;
            System.out.println("there is no problem with the validations it is with the connection manager and sql");
            try{
                conn = ConnectionManager.getConnection();
                System.out.println("There is no problem with connection Manager");
                
                pstmt = conn.prepareStatement("INSERT INTO demographics (name, password, email) VALUES (?, ?, ?)");
                pstmt.setString(1 , name);
                pstmt.setString(2 , password);
                pstmt.setString(3 , email);
                pstmt.executeUpdate();
                
               request.setAttribute("successMsg", "Congratulation! Your account has been created!");
               RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
               rd.forward(request, response);
               return;
                    
            }catch(Exception e){
                System.out.println("There is an error while adding new user");
                e.printStackTrace();
            }finally{
                ConnectionManager.close(conn , pstmt , rs);
                
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
