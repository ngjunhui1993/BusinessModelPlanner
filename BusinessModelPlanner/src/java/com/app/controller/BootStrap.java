/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import au.com.bytecode.opencsv.CSVReader;
import com.app.model.MainFileDAO;
import com.app.model.UploadResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jiaohui.lee.2014
 */
@WebServlet(name = "BootStrap", urlPatterns = {"/BootStrap"})
public class BootStrap extends HttpServlet {

    final static String COMPANYDATA_FILENAME = "data.csv";
    
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
        boolean hasData = false;
        int validFileSize = 0;
        int fileSize = 0;
        TreeSet<UploadResult> uploadResult = new TreeSet<UploadResult>();
        // retrieves all the uploaded file from the main form
        HashMap<String, ArrayList<String[]>> fileContent = (HashMap<String, ArrayList<String[]>>) request.getAttribute("uploadFile");
        Set keys = fileContent.keySet();
        String errorMsg = "Unknown File: <br>";
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            String currentFileName = (String) iter.next();
            switch (currentFileName) {
                case COMPANYDATA_FILENAME:
                    hasData = true;
                    validFileSize++;
                    fileSize++;
                    break;
                // When the file name of the csv file does not correspond to any know file name
                default:
                    fileSize++;
                    errorMsg += "\"" + currentFileName + "\" <br>"; 
            }
        }
        if (hasData) {
            // If valid file is available
            if(fileSize == validFileSize) {
                errorMsg = "";
            }
            /*Add DAO to connect with database. 
            Deletes data from the database.*/
            MainFileDAO.deleteAll();
            
            UploadResult dataResults = UploadValidationManager.validateData(fileContent.get(COMPANYDATA_FILENAME));
            HashMap<String, String[]> studentValidData = dataResults.getValidDataList();
            // Set the number of successful uploads
            dataResults.setNumSuccessful(MainFileDAO.upload(studentValidData));
            uploadResult.add(dataResults);

            // Redirects back to admin.jsp with the bootstrap result
            if (!errorMsg.isEmpty()) {
                request.setAttribute("unknownFiles", errorMsg);
            }
            request.setAttribute("result", uploadResult);
            RequestDispatcher view = request.getRequestDispatcher("Admin.jsp");
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

