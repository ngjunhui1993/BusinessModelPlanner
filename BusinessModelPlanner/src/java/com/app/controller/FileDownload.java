/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.entity.Demographics;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jiaohui.lee.2014
 */
@WebServlet(name = "FileDownload", urlPatterns = {"/FileDownload"})
public class FileDownload extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FileDownload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FileDownload at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try {
            PrintWriter out = response.getWriter();
            // System.out.println(System.getenv("OPENSHIFT_DATA_DIR"));
            Demographics user = (Demographics) request.getSession().getAttribute("user");
            String userid = user.getUserid();
            String fileName = userid + ".xls";
            String filePath = "C:\\Users\\jiaohui.lee.2014\\Desktop\\Excel\\";// tells the server where to find
           String pathdir = new String(System.getenv("OPENSHIFT_DATA_DIR"));

            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            // jh add some stuff here. If it is connected to openshift, use pathdir, else use fileName
            FileInputStream fi = null;
            //if((System.getenv("OPENSHIFT_DATA_DIR")+"Excel") ==null){
            fi = new FileInputStream(pathdir + fileName);

            //}else{
            //     fi= new FileInputStream(pathdir+fileName);
            //}
            int i;
            while ((i = fi.read()) != -1) {
                out.write(i);
            }
            out.close();
            fi.close();
        } catch (Exception e) {
            request.setAttribute("errorMsg", "Please save your project first before downloading.");
            RequestDispatcher rd = request.getRequestDispatcher("QADIM.jsp");
            rd.forward(request, response);
            return;
        }
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
