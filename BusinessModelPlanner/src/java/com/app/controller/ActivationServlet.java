/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Cryptography;
import com.app.model.DemographicsDAO;
import com.app.model.Email;
import com.app.model.entity.Demographics;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ActivationServlet", urlPatterns = {"/ActivationServlet"})
public class ActivationServlet extends HttpServlet {

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
        String message = null;
        final String email = request.getParameter("email");
        String activationCode = request.getParameter("activationCode");

        if (email != null && !email.isEmpty() && activationCode != null && !activationCode.isEmpty()) {
            try {
                DemographicsDAO uDAO = new DemographicsDAO();
                Demographics user = uDAO.retrieveByUsername(email);
                String sharedSecret = user.getSharedSecret();
                
                Cryptography cryptography = new Cryptography();
                
                if (email.toLowerCase().equals(cryptography.verifyAccessToken(activationCode, sharedSecret))) {
                    uDAO.activateAccount(email);
                    message = "You have activated your account. You can now login and use the app";
                } else {
                    sharedSecret = Cryptography.generateRandString(32); // Generate a random String of length 32
                    final String newActivationCode = Cryptography.generateAccessToken(email.toLowerCase(), sharedSecret);
                    uDAO.updateUserSS(email, sharedSecret);

                    // Setting up and sending of email takes alot of time, so do in separate thread
                    // to not keep user waiting for response. Good idea?
                   
                    Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // Email activationCode to user to activate account
                        String content = "Please click on the following link to activate your account! \n"
                                + "http://fypbmpt-junhui.rhcloud.com/BusinessModelPlanner/ActivationServlet?email=" + email.toLowerCase() + "&activationCode=" + newActivationCode;
                        //String content = "http://localhost:8084/Fitnexx6Server/ActivationServlet?email=" + email.toLowerCase() + "&activationCode=" + activationCode;
                        Email mail = new Email();
                        mail.sendMail(email, "", "Account Activation", content); 
                    }
                });
                t1.start();

                    message = "Your credentials are incorrect. Please activate your account through the email that we have just sent again";
                }
            } catch (Exception e) {
                message = "An error has occured. Please try again later";
            }
        }

        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        response.sendRedirect("activated.jsp");
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
