/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.BOSDAO;
import com.app.model.Excel;
import com.app.model.QaDIMDAO;
import com.app.model.entity.BOSOperator;
import com.app.model.entity.BOSProduct;
import com.app.model.entity.Demographics;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

/**
 *
 * @author junhui.ng.2014
 */
public class BOSCParser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // this servlet will take all the values that is being parsed from BOSC to BOSCparser via AJAX
    // the values for the weights, factors , pricepoints, grids , greendot , bluedots are stored in a json string.
    // the json string will be manipulated to convert everything into arraylist<String>.
    // the json string for weights and grids are different from the others, handled differently, but results still the same
    // 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Demographics user = (Demographics) request.getSession().getAttribute("user");
        String userId = user.getUserid();
      // String weight = (String)request.getParameter("weight1");
       String projectName = (String)request.getParameter("projectName");
       
       String BOSCEditChecker = (String)request.getSession().getAttribute("BOSCEditChecker");

       //----------- Validation of Project ----------
       BOSProduct projectChecker = BOSDAO.retrieveProjectByUser(projectName, userId);
        Double savedCurrent = Double.parseDouble((String)request.getParameter("savedCurrent"));
        Double savedNewValue = Double.parseDouble((String)request.getParameter("savedNewValue"));
        Integer boxCount = Integer.parseInt((String)request.getParameter("boxCounter"));
        // below are the arrays captured from bosc.jsp
        String blueDots = request.getParameter("blueDots");
        String greenDots = request.getParameter("greenDots");
        String factors = request.getParameter("factors");
        String weights = request.getParameter("weights");
        String pricePoints = request.getParameter("pricePoints");
        String grids = request.getParameter("grids");



         ArrayList<String> blueArray = getBlueArray(blueDots);
         ArrayList<String> greenArray = getGreenArray(greenDots);
         ArrayList<String> factorsArray = getFactorsArray(factors);

         ArrayList<String> weightsArray = getWeightsArray(weights);
         ArrayList<String> pricePointsArray = getPricePointsArray(pricePoints);
         ArrayList<String> gridsArray = getGridsArray(grids);

           // all data is properly put into array.
           // time to send to dao.
             /*

             ArrayList<String> factors ,
                                         ArrayList<String> grids , 
                                         ArrayList<String> greenDots , 
                                         ArrayList<String> blueDots , 
                                         ArrayList<String> pricePoints , 
                                         ArrayList<String> weights , 
                                         String projectName , 
                                         String userID , 
                                         String currentValue , 
                                         String newValue,
                                         int column 
                                         int productID
             */
         
        int productID = 0;

        if(projectChecker==null){
            //----------- Assigns a Unique productid to the project ----------
            int tempProductid = BOSDAO.checkForNextValidProductId(userId);
            if (tempProductid == 0){
                tempProductid = 1;
            }
            productID = tempProductid;
            productID++;
            
           boolean save = BOSDAO.saveProjectOperators(factorsArray,gridsArray , greenArray , blueArray , pricePointsArray  , weightsArray,
                   projectName , userId  ,boxCount , productID );

           boolean saveProj= BOSDAO.saveProject(userId ,  projectName ,  productID,  savedCurrent ,  savedNewValue );

           // ------------ Creation of Excel ----------
             BOSProduct project = BOSDAO.retrieveProjectByUser(projectName, userId);
             int prodid = project.getProductID();
             ArrayList<BOSOperator> operatorList = BOSDAO.getAllOperators(userId, projectName);
             Excel.BOSExport (userId, operatorList, project);
             
        // ---------- If project exist in database & was loaded ----------
       }else if (projectChecker!=null && BOSCEditChecker.equals(projectName)){
           BOSProduct project = BOSDAO.retrieveProjectByUser(projectName, userId);
             int prodid = project.getProductID();
           BOSDAO.deleteProject(projectName, userId, prodid);
           BOSDAO.deleteOperator(projectName, userId, prodid);
           boolean save = BOSDAO.saveProjectOperators(factorsArray,gridsArray , greenArray , blueArray , pricePointsArray  , weightsArray,
                   projectName , userId  ,boxCount , prodid );

           boolean saveProj= BOSDAO.saveProject(userId ,  projectName ,  prodid,  savedCurrent ,  savedNewValue );
           // ------------ Creation of Excel ----------
             ArrayList<BOSOperator> operatorList = BOSDAO.getAllOperators(userId, projectName);
             Excel.BOSDelete(userId, projectName);
             Excel.BOSExport (userId, operatorList, project);
       }
       request.getSession().setAttribute("BOSCEditChecker", projectName);
       
       //String weightVar = (String)request.getParameter("currentWeight");
       //System.out.println(weightVar + " got from the getParameter(currentWeight)");
       //String[] jsonFormatData = request.getParameterValues("data");
      // System.out.println(jasonFormatData[0] + " got from the jsonFormatData data");
       
       
    }
    // i need a method to convert json strings into array again. ["5","4"]
    public ArrayList<String> getBlueArray(String jsonBlueDots){
     //   jsonBlueDots = jsonBlueDots.substring(1,jsonBlueDots.length()-1);
        ArrayList<String> output = new ArrayList<>() ;
        JSONArray jsonArray = new JSONArray(jsonBlueDots);
        for(int i = 0 ; i <jsonArray.length() ; i ++){
            output.add(jsonArray.getString(i));
        }
        
        return output ;
    }
    public ArrayList<String> getGreenArray(String jsonGreenDots){
     //   jsonBlueDots = jsonBlueDots.substring(1,jsonBlueDots.length()-1);
        ArrayList<String> output = new ArrayList<>() ;
        JSONArray jsonArray = new JSONArray(jsonGreenDots);
        for(int i = 0 ; i <jsonArray.length() ; i ++){
            output.add(jsonArray.getString(i));
        }
       
        return output ;
    }
    
    public ArrayList<String> getFactorsArray(String jsonFactors){
     //   jsonBlueDots = jsonBlueDots.substring(1,jsonBlueDots.length()-1);
        ArrayList<String> output = new ArrayList<>() ;
        JSONArray jsonArray = new JSONArray(jsonFactors);
        for(int i = 0 ; i <jsonArray.length() ; i ++){
            output.add(jsonArray.getString(i));
        }
       
        return output ;
    }
    public ArrayList<String> getPricePointsArray(String jsonPricePoints){
     //   jsonBlueDots = jsonBlueDots.substring(1,jsonBlueDots.length()-1);
        ArrayList<String> output = new ArrayList<>() ;
        JSONArray jsonArray = new JSONArray(jsonPricePoints);
        for(int i = 0 ; i <jsonArray.length() ; i ++){
            output.add(jsonArray.getString(i));
        }
        
        return output ;
    }
    // [1,1] it looks like this, which is different form the usual ["1","1"]. json fails here.
    
    public ArrayList<String> getWeightsArray(String jsonWeights){
     //   jsonBlueDots = jsonBlueDots.substring(1,jsonBlueDots.length()-1);
        ArrayList<String> output = new ArrayList<>() ;
        jsonWeights = jsonWeights.replace(",","");
        jsonWeights = jsonWeights.substring(1,jsonWeights.length()-1).trim();
        for(int i = 0 ; i <jsonWeights.length() ; i ++){
            output.add(jsonWeights.charAt(i)+ "");
            
        }
        
        return output ;
    }
    
    
    
    public ArrayList<String> getGridsArray(String jsonGrids){
     //   jsonBlueDots = jsonBlueDots.substring(1,jsonBlueDots.length()-1);
       ArrayList<String> output = new ArrayList<>() ;
        jsonGrids = jsonGrids.replace(",","");
        jsonGrids = jsonGrids.substring(1,jsonGrids.length()-1).trim();
        for(int i = 0 ; i <jsonGrids.length() ; i ++){
            output.add(jsonGrids.charAt(i)+ "");
            
        }
        
        return output ;
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
