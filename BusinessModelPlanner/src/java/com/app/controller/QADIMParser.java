/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
        
        String projectName = (String)request.getParameter("saveQADIMProjectName");
        String savedItem1 = (String)request.getParameter("savedItem1");
        String savedItem2 = (String)request.getParameter("savedItem2");
        String savedItem3 = (String)request.getParameter("savedItem3");
        String savedItem4 = (String)request.getParameter("savedItem4");
        String savedItem5 = (String)request.getParameter("savedItem5");
        String savedItem6 = (String)request.getParameter("savedItem6");
        String savedItem7 = (String)request.getParameter("savedItem7");
        String savedItem8 = (String)request.getParameter("savedItem8");
        // trim away unnecessary trailing and leading spaces if any
        savedItem1.trim();
        savedItem2.trim();
        savedItem3.trim();
        savedItem4.trim();
        savedItem5.trim();
        savedItem6.trim();
        savedItem7.trim();
        savedItem8.trim();
        
        projectName.replace("<h1>" ,"");
        projectName.replace("</h1>" ,"");
        // ok for the weird h1 tags, karen is to replace with div style, i will not care bout them first.
        projectName.trim();
        // testing only, can remove the SOprintln
        System.out.println(projectName);
        // here we need to call dao to save.
        // handing this to backend.
        // probably the load will remain the same, store in session object. karen will take out the values and play around
        // not sure if session can pass to js page, if cannot then maybe gotta remove the js page, or use json ajax
        //
        
        
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
