/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import au.com.bytecode.opencsv.CSVReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jiaohui.lee.2014
 */
@WebServlet(name = "MainFileUpload", urlPatterns = {"/MainFileUpload"})
@MultipartConfig
public class MainFileUpload extends HttpServlet {

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
        // HashMap for storing the individual contents of the CSV File in the zipped folder
        HashMap<String, ArrayList<String[]>> fileContent = new HashMap<String, ArrayList<String[]>>();
        // For retrieving the File object submitted by the user
        Part filepart = request.getPart("upfile");
        InputStream is = filepart.getInputStream();


        boolean hasContents = false;
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(is, "UTF-8"), ',', '"');
            ArrayList<String[]> currentCSVFile = (ArrayList<String[]>) reader.readAll();
            String fileName = filepart.getSubmittedFileName().substring(filepart.getSubmittedFileName().lastIndexOf('\\') + 1);
            fileContent.put(fileName, currentCSVFile);
            hasContents = true;
        } catch (Throwable e) {
            
        }
        is.close();
        // Redirects back to the admin page with the error message
        if (!hasContents) {
            request.setAttribute("uploadError", "Please upload a valid file");
            RequestDispatcher view = request.getRequestDispatcher("admin.jsp");
            view.forward(request, response);
        } else {
            request.setAttribute("uploadFile", fileContent);
            // redirects to bootstrap servlet
            RequestDispatcher view = request.getRequestDispatcher("BootStrap");
            view.forward(request, response);
            
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
