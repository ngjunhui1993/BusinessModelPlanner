/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.ConnectionManager;
import com.app.model.Cryptography;
import com.app.model.entity.Demographics;
import com.app.model.DemographicsDAO;
import com.app.model.Encryption;
import com.app.model.Email;
import com.nimbusds.jose.JOSEException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
/**
 * Login controller process login username and password and redirects users to
 * relevant page.
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

            if (register == null) {
                response.sendRedirect("index.jsp");
                return;
            }

            if (request.getParameter("name") == null || request.getParameter("email") == null || request.getParameter("password") == null) {
                request.setAttribute("errorMsg", "Please do not leave any fields blank");
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
                return;
            } 

            //retrieve the name sent from the form
            String name = request.getParameter("name").trim();
            //retrieve the email id sent from the form
            final String email = request.getParameter("email").trim();
            //retrieve the password sent from the form
            String password = request.getParameter("password").trim();
            //retrieve the user type from the form
            String type = request.getParameter("type");
            //String type = "student";
            //retrieve confirmed password from form.
            String confirmPassword = request.getParameter("confirmPassword");

            DemographicsDAO demoDAO = new DemographicsDAO();
            if (email == "" || password == "" || name == "") {
                request.setAttribute("errorMsg", "Please do not leave any fields blank");
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
                return;
            }
            if (demoDAO.userExist(email)) {
                request.setAttribute("errorMsg", "The email had been registered. Please use another email address!");
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
                return;
            }
            if (!validEmail(email)) {
                request.setAttribute("errorMsg", "The email address entered is invalid. Please enter a valid email address!");
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
                return;
            }
            if (password.length() < 8) {
                request.setAttribute("errorMsg", "Please enter a password with at least 8 characters");
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
                return;
            }

            if (!password.equals(confirmPassword)) {
                request.setAttribute("errorMsg", "The passwords don't match. Please try again.");
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
                return;
            }

            Encryption encryption = new Encryption();
            String userid = email;
            String encryptedPassword = encryption.SHA1(password);
            Cryptography cryptography = new Cryptography();
            String sharedSecret = cryptography.generateRandString(32);
            String success = "";
            try {
                final String activationCode = cryptography.generateAccessToken(email.toLowerCase(), sharedSecret);

                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // Email activationCode to user to activate account
                        String content = "Please click on the following link to activate your account! \n"
                                + "http://fypbmpt-junhui.rhcloud.com/BusinessModelPlanner/ActivationServlet?email=" + email.toLowerCase() + "&activationCode=" + activationCode;
                        //String content = "http://localhost:8084/Fitnexx6Server/ActivationServlet?email=" + email.toLowerCase() + "&activationCode=" + activationCode;
                        Email mail = new Email();
                        mail.sendMail(email, "", "Account Activation", content); 
                    }
                });
                t1.start();

                success = demoDAO.register(name, encryptedPassword, email, userid, type, sharedSecret, false);
            } catch (JOSEException ex) {
                request.setAttribute("errorMsg", "Unable to send activation email. Please try again.");
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
                return;
            }
            //check if there were any exceptions thrown during the method, register, in the demoDAO.
            if (success == null || success.equals("")) {
                request.setAttribute("errorMsg", "An error has occured in the database.");
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
                return;
            }
            request.setAttribute("successMsg", success);
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }
    }

    public boolean validEmail(String email) {
        String emailPattern
                = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
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
