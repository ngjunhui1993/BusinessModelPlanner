<%-- 
    Document   : testDisplay
    Created on : 20 Mar, 2017, 12:20:14 AM
    Author     : Dell
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.CanvasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        
        <%
            CanvasDAO cDAO = new CanvasDAO();
         //   ArrayList<String> companyList = cDAO.retrieveAllCompanies();
         HashMap<String, ArrayList<String>> all = cDAO.retrieveAll();
         out.println(all.size() + "<BR>");
         Iterator iter = all.entrySet().iterator();
         
         HashMap<String, ArrayList<String>> allAll = new HashMap<String, ArrayList<String>>();
         
         while(iter.hasNext()) {
             Map.Entry pair = (Map.Entry)iter.next();
             out.println(pair.getKey() + ", " + pair.getValue() + "<BR>");
             allAll.put((String)pair.getKey(), (ArrayList<String>)pair.getValue());
             iter.remove();
         }
         
        out.println("<BR><BR>");
        
        ArrayList<String> selectedTraits = new ArrayList<String>();
        selectedTraits.add("Offer toys and Happy Meals to attract children");
        selectedTraits.add("Lower manufacturing costs");
        selectedTraits.add("Align inventory with production – Kanban ");
        selectedTraits.add("Design and build assembly line to reduce change over time ");
        selectedTraits.add("Remove intermediaries");
        selectedTraits.add("Offer cheaper prices resulting from removing intermediaries");
        selectedTraits.add("Get customer to discover the product – Street marketing");
        selectedTraits.add("Reduce channel costs ");
        selectedTraits.add("Just in time inventory ");
        selectedTraits.add("Charge for upgrades ");
        selectedTraits.add("Optimally match partners with specific tasks ");
        
        HashMap<String, Integer> resultsSelected = cDAO.resultsFromAllTraitsSelected(selectedTraits, allAll);
    //    out.println(resultsSelected.size());
    
        HashMap<String, Integer> nearestResult = cDAO.nearestSearchFromResults(resultsSelected);
        out.println(nearestResult.size() + "<BR>");
        
        Iterator iter2 = nearestResult.entrySet().iterator();
        while(iter2.hasNext()) {
            Map.Entry pair = (Map.Entry)iter2.next();
            out.println((String)pair.getKey() + ", " + (Integer)pair.getValue());
             iter2.remove();
         }
      //  String key = "K-12 programme";
     //  ArrayList<String> traits = allAll.get("K-12 programme");
        /* if(traits == null) {
            out.println("null leh");
            out.println(all.containsKey("K-12 programme"));
        } else {
            out.println(traits.get(0));
        } */
        
       /* HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
        for (String trait : selectedTraits) {
            ArrayList<String> companiesWithTrait = allAll.get(trait); //null pointer here. may be data doesn't tally.
            if (companiesWithTrait != null || !companiesWithTrait.isEmpty()) {

                for (String company : companiesWithTrait) {
                    if (resultMap.containsKey(company)) {
                        int count = resultMap.get(company);
                        count++;
                        resultMap.put(company, count);
                    } else {
                        resultMap.put(company, 1);
                    }
                }
            }
        }*/
        %>
        
        <BR><BR>
        <form action="CanvasController">
         <h3>Key Partners</h3>
                                                        <span>SHORT DESCRIPTION</span>
                                                        <!--SEARCH OPTIONS-->
                                                        
                                                        <%
                                                            ArrayList<String> traits = cDAO.retrieveTraitsByDriver("key_partnerships");
                                                            out.println(traits.size());
                                                        %>
                                                        <DIV>
                                                            
                                                                <div class="multiselect">
                                                                    <div class="selectBox" onclick="checkBoxValues()">
                                                                        <select>
                                                                            <option>Select an option</option>
                                                                        </select>
                                                                        <div class="overSelect"></div>
                                                                    </div>
                                                                    <div id="checkboxes">
                                                                        <!--LOAD DATA HERE-->
                                                                        <%
                                                                            int count = 1;
                                                                            for(String trait : traits) {
                                                                                out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        %>
                                                                   <!--     <label for="one">
                                                                            <input type="checkbox" id="one" />First checkbox</label>
                                                                        <label for="two">
                                                                            <input type="checkbox" id="two" />Second checkbox</label>
                                                                        <label for="three">
                                                                            <input type="checkbox" id="three" />Third checkbox</label>-->
                                                                    </div>
                                                                </div>
                                                            
                                                        </DIV>
                                                                   <h3>Key Activities</h3>
                                                        <span>SHORT DESCRIPTION</span>
                                                        <!--SEARCH OPTIONS-->
                                                         <%
                                                            cDAO = new CanvasDAO();
                                                            traits = cDAO.retrieveTraitsByDriver("key_activities");
                                                            out.println(traits.size());
                                                        %>
                                                        <DIV>
                                                            
                                                                <div class="multiselect">
                                                                    <div class="selectBox" onclick="checkBoxValues()">
                                                                        <select>
                                                                            <option>Select an option</option>
                                                                        </select>
                                                                        <div class="overSelect"></div>
                                                                    </div>
                                                                    <div id="checkboxes">
                                                                        <!--LOAD DATA HERE-->
                                                                        <%
                                                                            count = 1;
                                                                            for(String trait : traits) {
                                                                                out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'/>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        %>
                                                                   <!--     <label for="one">
                                                                            <input type="checkbox" id="one" />First checkbox</label>
                                                                        <label for="two">
                                                                            <input type="checkbox" id="two" />Second checkbox</label>
                                                                        <label for="three">
                                                                            <input type="checkbox" id="three" />Third checkbox</label>-->
                                                                    </div>
                                                                </div>
                                                            
                                                        </DIV>
                                                                   
                                                                    <h3>Key Resources</h3>
                                                        <span>SHORT DESCRIPTION</span>
                                                        <!--SEARCH OPTIONS-->
                                                        <%
                                                            cDAO = new CanvasDAO();
                                                            traits = cDAO.retrieveTraitsByDriver("key_resources");
                                                            out.println(traits.size());
                                                        %>
                                                        <DIV>
                                                            
                                                                <div class="multiselect">
                                                                    <div class="selectBox" onclick="checkBoxValues()">
                                                                        <select>
                                                                            <option>Select an option</option>
                                                                        </select>
                                                                        <div class="overSelect"></div>
                                                                    </div>
                                                                    <div id="checkboxes">
                                                                        <!--LOAD DATA HERE-->
                                                                        <%
                                                                            count = 1;
                                                                            for(String trait : traits) {
                                                                                out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'/>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        %>
                                                                   <!--     <label for="one">
                                                                            <input type="checkbox" id="one" />First checkbox</label>
                                                                        <label for="two">
                                                                            <input type="checkbox" id="two" />Second checkbox</label>
                                                                        <label for="three">
                                                                            <input type="checkbox" id="three" />Third checkbox</label>-->
                                                                    </div>
                                                                </div>
                                                            
                                                        </DIV>
                                                                      <input type="submit" value="submit" name="traitsSearch">
    </form>
                                            
                                                                
                                                                   <BR><BR>
                                                                   <%
                                                                   if(request.getAttribute("traitsSelected")!=null) {
                                                                    String[] tr = (String[])request.getAttribute("traitsSelected");
                                                                    for(String t : tr) {
                                                                        out.println(t);
                                                                    } 
                                                                   }else {
                                                                            out.println("nothing");
                                                                            }
                                                                    
                                                                   

%>
    
</html>
