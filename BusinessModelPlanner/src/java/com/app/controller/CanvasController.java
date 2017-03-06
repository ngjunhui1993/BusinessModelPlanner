/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.CanvasDAO;
import com.app.model.entity.CanvasCompany;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "CanvasController", urlPatterns = {"/CanvasController"})
public class CanvasController extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        CanvasDAO canvasDAO = new CanvasDAO();
        
        if(request.getParameter("searchCompany") != null) {
            String companyName = request.getParameter("companiesSearched");
            
            if(companyName == null || companyName.equals("") || companyName.equals("[]")) {
                request.setAttribute("errorMsg", "Please do not leave any blanks.");
                RequestDispatcher rd = request.getRequestDispatcher("BMC_SearchByCompanies.jsp");
                rd.forward(request, response);
                return;
            }
            
            companyName = companyName.substring(2, companyName.length()-2);
            String[] splitCompanyNames = companyName.split("\",\"");
            request.setAttribute("companiesSearched", splitCompanyNames);
            RequestDispatcher rd = request.getRequestDispatcher("BMC_Results_2.jsp");
            rd.forward(request, response);
            return;
            
    /*        ArrayList<CanvasCompany> companies = (ArrayList<CanvasCompany>)canvasDAO.retrieveCompanyDetailsByName(companyName);
                request.setAttribute("companySearched", companies);
                RequestDispatcher rd = request.getRequestDispatcher("BusinessModelCanvas.jsp");
                rd.forward(request, response);
                return;*/
        }
        
        if(request.getParameter("searchByTraits")!=null) {
            String keyPartners = request.getParameter("keyPartners");
            String keyActivities = request.getParameter("keyActivities");
            String keyResources = request.getParameter("keyResources");
            String valueProposition = request.getParameter("valueProposition");
            String customerSegments = request.getParameter("customerSegments");
            String customerRelationship = request.getParameter("customerRelationship");
            String channels = request.getParameter("channels");
            String costStructure = request.getParameter("costStructure");
            String revenue = request.getParameter("revenue");
            
            ArrayList<String> allTraits = new ArrayList<String>();
            
            //need to edit the split again. may have errors. need to edit the excel file of data first.
            
            if(keyPartners != null && !keyPartners.equals("") && keyPartners.length()!=3) {
                keyPartners = keyPartners.substring(4,keyPartners.length()-3);
                String[] splitTraits = keyPartners.split("\",\\s+\"");
                
                if(splitTraits!=null && splitTraits.length!=0) {
                    for(String trait : splitTraits) {
                        allTraits.add(trait);
                    }
                }
            }
            
            if(keyActivities != null && !keyActivities.equals("") && keyActivities.length()!=3) {
                keyActivities = keyActivities.substring(4,keyActivities.length()-2);
                String[] splitTraits = keyActivities.split("\",\\s+\"");
                
                if(splitTraits!=null && splitTraits.length!=0) {
                    for(String trait : splitTraits) {
                        allTraits.add(trait);
                    }
                }
            }
            
            if(keyResources != null && !keyResources.equals("") && keyResources.length()!=3) {
                keyResources = keyResources.substring(4,keyResources.length()-3);
                String[] splitTraits = keyResources.split("\",\\s+\"");
                
                if(splitTraits!=null && splitTraits.length!=0) {
                    for(String trait : splitTraits) {
                        allTraits.add(trait);
                    }
                }
            }
            
            if(valueProposition != null && !valueProposition.equals("") && valueProposition.length()!=3) {
                valueProposition = valueProposition.substring(4,valueProposition.length()-2);
                String[] splitTraits = valueProposition.split("\",\\s+\"");
                
                if(splitTraits!=null && splitTraits.length!=0) {
                    for(String trait : splitTraits) {
                        allTraits.add(trait);
                    }
                }
            }
            
           if(customerSegments != null && !customerSegments.equals("") && customerSegments.length()!=3) {
                customerSegments = customerSegments.substring(4,customerSegments.length()-2);
                String[] splitTraits = customerSegments.split("\",\\s+\"");
                
                if(splitTraits!=null && splitTraits.length!=0) {
                    for(String trait : splitTraits) {
                        allTraits.add(trait);
                    }
                }
            }
           
            if(customerRelationship != null && !customerRelationship.equals("") && customerRelationship.length()!=3) {
                customerRelationship = customerRelationship.substring(4,customerRelationship.length()-2);
                String[] splitTraits = customerRelationship.split("\",\\s+\"");
                
                if(splitTraits!=null && splitTraits.length!=0) {
                    for(String trait : splitTraits) {
                        allTraits.add(trait);
                    }
                }
            }
            
            if(channels != null && !channels.equals("") && channels.length()!=3) {
                channels = channels.substring(4,channels.length()-2);
                String[] splitTraits = channels.split("\",\\s+\"");
                
                if(splitTraits!=null && splitTraits.length!=0) {
                    for(String trait : splitTraits) {
                        allTraits.add(trait);
                    }
                }
            }
            
            if(costStructure != null && !costStructure.equals("") && costStructure.length()!=3) {
                costStructure = costStructure.substring(4,costStructure.length()-2);
                String[] splitTraits = costStructure.split("\",\\s+\"");
                
                if(splitTraits!=null && splitTraits.length!=0) {
                    for(String trait : splitTraits) {
                        allTraits.add(trait);
                    }
                }
            }
            
            if(revenue != null && !revenue.equals("") && revenue.length()!=3) {
                revenue = revenue.substring(4,revenue.length()-2);
                String[] splitTraits = revenue.split("\",\\s+\"");
                
                if(splitTraits!=null && splitTraits.length!=0) {
                    for(String trait : splitTraits) {
                        allTraits.add(trait);
                    }
                }
            } 
    /*        
            HashMap<String, ArrayList<String>> allData = canvasDAO.retrieveAll();
            
           request.setAttribute("allData", allData);
                RequestDispatcher rd = request.getRequestDispatcher("BusinessModelCanvas.jsp");
                rd.forward(request, response);
                return;
            
            
            HashMap<String, Integer> countTraits = canvasDAO.resultsFromAllTraitsSelected(allTraits, allData);
            HashMap<String, Integer> nearestCompanies = canvasDAO.nearestSearchFromResults(countTraits);
            
*/
            
            /*
            request.setAttribute("nearestCompanies", nearestCompanies);
                RequestDispatcher rd = request.getRequestDispatcher("BusinessModelCanvas.jsp");
                rd.forward(request, response);
                return;
            
            */
            /*
            request.setAttribute("traits", allTraits);
                RequestDispatcher rd = request.getRequestDispatcher("BusinessModelCanvas.jsp");
                rd.forward(request, response);
                return; */
            
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
