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

        String projectName = (String) request.getParameter("saveQADIMProjectName");
        String op1Name = (String) request.getParameter("opName1");
        String op1Comment = (String) request.getParameter("opComment1");

        String op2Name = (String) request.getParameter("opName2");
        String op2Comment = (String) request.getParameter("opComment2");

        String op3Name = (String) request.getParameter("opName3");
        String op3Comment = (String) request.getParameter("opComment3");

        String op4Name = (String) request.getParameter("opName4");
        String op4Comment = (String) request.getParameter("opComment4");

        String op5Name = (String) request.getParameter("opName5");
        String op5Comment = (String) request.getParameter("opComment5");

        String op6Name = (String) request.getParameter("opName6");
        String op6Comment = (String) request.getParameter("opComment6");

        String op7Name = (String) request.getParameter("opName7");
        String op7Comment = (String) request.getParameter("opComment7");

        String op8Name = (String) request.getParameter("opName8");
        String op8Comment = (String) request.getParameter("opComment8");

        // trim away unnecessary trailing and leading spaces if any
        op1Name.trim();
        op2Name.trim();
        op3Name.trim();
        op4Name.trim();
        op5Name.trim();
        op6Name.trim();
        op7Name.trim();
        op8Name.trim();
        projectName.trim();
        // testing only, can remove the SOprintln
        System.out.println(projectName);
        System.out.println(op1Name);
        System.out.println(op1Comment);
        System.out.println(op2Name);
        System.out.println(op2Comment);
        System.out.println(op3Name);
        System.out.println(op3Comment);
        System.out.println(op4Name);
        System.out.println(op4Comment);
        System.out.println(op5Name);
        System.out.println(op5Comment);
        System.out.println(op6Name);
        System.out.println(op6Comment);
        System.out.println(op7Name);
        System.out.println(op7Comment);
        System.out.println(op8Name);
        System.out.println(op8Comment);

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
