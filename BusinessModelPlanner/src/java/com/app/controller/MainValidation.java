/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Operator;
import com.app.model.QaDIMDAO;
import com.northconcepts.datapipeline.core.DataReader;
import com.northconcepts.datapipeline.core.Record;
import com.northconcepts.datapipeline.core.RecordList;
import com.northconcepts.datapipeline.memory.MemoryReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.chart.PieChart.Data;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jiaohui.lee.2014
 */
@WebServlet(name = "MainValidation", urlPatterns = {"/MainValidation"})
public class MainValidation extends HttpServlet {

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
            int noOfOperators = Integer.parseInt(request.getParameter("numberOfBoxes"));
            ArrayList<Operator> oList = new ArrayList<>();
            for(int i = 1; i <=noOfOperators; i++){
                String operatorName = request.getParameter("operatorName"+i);
                String verb = request.getParameter("verb"+i);
                String generalPhrase = request.getParameter("generalPhrase"+i);
                String specificPhrase = request.getParameter("specificPhrase"+i);
                String dimension = request.getParameter("dimension"+i);
                
                int productId = Integer.parseInt(request.getParameter("productId"));
                int operatorId = Integer.parseInt(request.getParameter("operatorId"+i));
                Operator operator = new Operator(operatorName, verb, generalPhrase, specificPhrase, dimension, productId, operatorId);
                oList.add(operator);
            }    

                QaDIMDAO.upload(oList);
                
                Record record = new Record();
                RecordList rList = new RecordList();
                for(Operator o: oList){
                    record.setField("operatorName", o.getOperatorName());
                    record.setField("verb", o.getOperatorName());
                    record.setField("generalPhrase", o.getOperatorName());
                    record.setField("specificPhrase", o.getOperatorName());
                    record.setField("dimension", o.getOperatorName());
                    record.setField("productId", o.getOperatorName());
                    record.setField("operatorId", o.getOperatorName());                   
                    rList.add(record);
                }
                
                //create csv.file
                //get location and csv file and implement WriteToANewExcelFile()
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
