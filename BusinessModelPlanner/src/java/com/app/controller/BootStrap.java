/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.MainFileDAO;
import java.io.IOException;
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
import com.app.model.UploadResult;

/**
 *
 * @author jiaohui.lee.2014
 */
@WebServlet(name = "BootStrap", urlPatterns = {"/BootStrap"})
public class BootStrap extends HttpServlet {

    final static String customerAcquisition = "customer_acquisition.csv";
    final static String customerRelations = "customer_relations.csv";
    final static String channelStrategy= "channel_strategy.csv";
    final static String valueProposition = "value_proposition.csv";
    final static String keyActivities = "key_activities.csv";
    final static String keyResources = "key_resources.csv";
    final static String keyPartnerships = "key_partnerships.csv";
    final static String costManagement = "cost_management.csv";
    final static String revenues = "revenues.csv";
    
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
        boolean hasCA = false;
        boolean hasCR = false;
        boolean hasCS = false;
        boolean hasVP = false;
        boolean hasKA = false;
        boolean hasKR = false;
        boolean hasKP = false;
        boolean hasCM = false;
        boolean hasR = false;
        int validFileSize = 0;
        int fileSize = 0;
        TreeSet<UploadResult> uploadResult = new TreeSet<>();
        // retrieves all the uploaded files from the mainFileUpload Servlet
        HashMap<String, ArrayList<String[]>> fileContents = (HashMap<String, ArrayList<String[]>>) request.getAttribute("uploadFile");
        Set keys = fileContents.keySet();
        String errorMsg = "Unknown File: <br>";
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            String currentFileName = (String) iter.next();
            switch (currentFileName) {
                case customerAcquisition:
                    hasCA = true;
                    validFileSize++;
                    fileSize++;
                    break;
                case customerRelations:
                    hasCR = true;
                    validFileSize++;
                    fileSize++;
                    break;
                case channelStrategy:
                    hasCS = true;
                    validFileSize++;
                    fileSize++;
                    break;
                case valueProposition:
                    hasVP = true;
                    validFileSize++;
                    fileSize++;
                    break;
                case keyActivities:
                    hasKA = true;
                    validFileSize++;
                    fileSize++;
                    break;
                case keyResources:
                    hasKR = true;
                    validFileSize++;
                    fileSize++;
                    break;
                case keyPartnerships:
                    hasKP = true;
                    validFileSize++;
                    fileSize++;
                    break;
                case costManagement:
                    hasCM = true;
                    validFileSize++;
                    fileSize++;
                    break;
                case revenues:
                    hasR = true;
                    validFileSize++;
                    fileSize++;
                    break;
                // When the file name of the csv file does not correspond to any know file name
                default:
                    fileSize++;
                    errorMsg += "\"" + currentFileName + "\" <br>"; 
            }
        }
        if (hasCA && hasCR && hasCS && hasVP && hasKA && hasKR && hasKP && hasCM && hasR) {
            // If all files are available
            if(fileSize == validFileSize) {
                errorMsg = "";
            }
            MainFileDAO.deleteCA();
            MainFileDAO.deleteCR();
            MainFileDAO.deleteCS();
            MainFileDAO.deleteVP();
            MainFileDAO.deleteKA();
            MainFileDAO.deleteKR();
            MainFileDAO.deleteKP();
            MainFileDAO.deleteCM();
            MainFileDAO.deleteR();
            
            UploadResult caResults = UploadValidationManager.validateCA(fileContents.get(customerAcquisition));
            HashMap<String, String[]> caValidData = caResults.getValidDataList();
            // Set the number of successful uploads
            caResults.setNumSuccessful(MainFileDAO.upload(caValidData, "customer_acquisition"));
            uploadResult.add(caResults);

            UploadResult crResults = UploadValidationManager.validateCR(fileContents.get(customerRelations));
            HashMap<String, String[]> courseValidData = crResults.getValidDataList();
            // Set the number of successful uploads
            crResults.setNumSuccessful(MainFileDAO.upload(courseValidData, "customer_relations"));
            uploadResult.add(crResults);

            UploadResult csResults = UploadValidationManager.validateCS(fileContents.get(channelStrategy));
            HashMap<String, String[]> sectionValidData = csResults.getValidDataList();
            // Set the number of successful uploads
            csResults.setNumSuccessful(MainFileDAO.upload(sectionValidData, "channel_strategy"));
            uploadResult.add(csResults);

            UploadResult vpResults = UploadValidationManager.validateVP(fileContents.get(valueProposition));
            HashMap<String, String[]> prerequisiteValidData = vpResults.getValidDataList();
            // Set the number of successful uploads
            vpResults.setNumSuccessful(MainFileDAO.upload(prerequisiteValidData, "value_proposition"));
            uploadResult.add(vpResults);

            UploadResult kaResults = UploadValidationManager.validateKA(fileContents.get(keyActivities));
            HashMap<String, String[]> courseCompletedValidData = kaResults.getValidDataList();
            // Set the number of successful uploads
            kaResults.setNumSuccessful(MainFileDAO.upload(courseCompletedValidData, "key_activities"));
            uploadResult.add(kaResults);

            UploadResult krResults = UploadValidationManager.validateKR(fileContents.get(keyResources));
            HashMap<String, String[]> krValidData = krResults.getValidDataList();
            // Set the number of successful uploads
            // add any bids that was overidden into total successful bids
            krResults.setNumSuccessful(MainFileDAO.upload(krValidData, "key_resources"));
            uploadResult.add(krResults);
            
            UploadResult kpResults = UploadValidationManager.validateKP(fileContents.get(keyPartnerships));
            HashMap<String, String[]> kpValidData = kpResults.getValidDataList();
            // Set the number of successful uploads
            // add any bids that was overidden into total successful bids
            kpResults.setNumSuccessful(MainFileDAO.upload(kpValidData, "key_partnerships"));
            uploadResult.add(kpResults);
            
            UploadResult cmResults = UploadValidationManager.validateCM(fileContents.get(costManagement));
            HashMap<String, String[]> cmValidData = cmResults.getValidDataList();
            // Set the number of successful uploads
            // add any bids that was overidden into total successful bids
            cmResults.setNumSuccessful(MainFileDAO.upload(cmValidData, "cost_management"));
            uploadResult.add(cmResults);
            
            UploadResult rResults = UploadValidationManager.validateR(fileContents.get(revenues));
            HashMap<String, String[]> rValidData = rResults.getValidDataList();
            // Set the number of successful uploads
            // add any bids that was overidden into total successful bids
            rResults.setNumSuccessful(MainFileDAO.upload(rValidData, "revenues"));
            uploadResult.add(rResults);
            
        }
        // Redirects back to admin.jsp with the error message
        if (validFileSize < 9 || validFileSize > 9) {
            errorMsg = "Please upload a valid zipped file containing all of the necessary CSV files";
            request.setAttribute("uploadError", errorMsg);
            RequestDispatcher view = request.getRequestDispatcher("Bootstrap.jsp");
            view.forward(request, response);
        } else {
            // Redirects back to admin.jsp with the bootstrap result
            if (!errorMsg.isEmpty()) {
                request.setAttribute("unknownFiles", errorMsg);
            }
            request.setAttribute("result", uploadResult);
            RequestDispatcher view = request.getRequestDispatcher("Bootstrap.jsp");
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

