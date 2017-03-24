package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import com.app.model.CanvasDAO;

public final class BMCTest2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("        \n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        \n");
      out.write("        <BR><BR>\n");
      out.write("        <form action=\"CanvasController\">\n");
      out.write("         <h3>Key Partners</h3>\n");
      out.write("                                                        <span>SHORT DESCRIPTION</span>\n");
      out.write("                                                        <!--SEARCH OPTIONS-->\n");
      out.write("                                                        \n");
      out.write("                                                        ");

                                                            ArrayList<String> traits = cDAO.retrieveTraitsByDriver("key_partnerships");
                                                            out.println(traits.size());
                                                        
      out.write("\n");
      out.write("                                                        <DIV>\n");
      out.write("                                                            \n");
      out.write("                                                                <div class=\"multiselect\">\n");
      out.write("                                                                    <div class=\"selectBox\" onclick=\"checkBoxValues()\">\n");
      out.write("                                                                        <select>\n");
      out.write("                                                                            <option>Select an option</option>\n");
      out.write("                                                                        </select>\n");
      out.write("                                                                        <div class=\"overSelect\"></div>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                    <div id=\"checkboxes\">\n");
      out.write("                                                                        <!--LOAD DATA HERE-->\n");
      out.write("                                                                        ");

                                                                            int count = 1;
                                                                            for(String trait : traits) {
                                                                                out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        
      out.write("\n");
      out.write("                                                                   <!--     <label for=\"one\">\n");
      out.write("                                                                            <input type=\"checkbox\" id=\"one\" />First checkbox</label>\n");
      out.write("                                                                        <label for=\"two\">\n");
      out.write("                                                                            <input type=\"checkbox\" id=\"two\" />Second checkbox</label>\n");
      out.write("                                                                        <label for=\"three\">\n");
      out.write("                                                                            <input type=\"checkbox\" id=\"three\" />Third checkbox</label>-->\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                            \n");
      out.write("                                                        </DIV>\n");
      out.write("                                                                   <h3>Key Activities</h3>\n");
      out.write("                                                        <span>SHORT DESCRIPTION</span>\n");
      out.write("                                                        <!--SEARCH OPTIONS-->\n");
      out.write("                                                         ");

                                                            cDAO = new CanvasDAO();
                                                            traits = cDAO.retrieveTraitsByDriver("key_activities");
                                                            out.println(traits.size());
                                                        
      out.write("\n");
      out.write("                                                        <DIV>\n");
      out.write("                                                            \n");
      out.write("                                                                <div class=\"multiselect\">\n");
      out.write("                                                                    <div class=\"selectBox\" onclick=\"checkBoxValues()\">\n");
      out.write("                                                                        <select>\n");
      out.write("                                                                            <option>Select an option</option>\n");
      out.write("                                                                        </select>\n");
      out.write("                                                                        <div class=\"overSelect\"></div>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                    <div id=\"checkboxes\">\n");
      out.write("                                                                        <!--LOAD DATA HERE-->\n");
      out.write("                                                                        ");

                                                                            count = 1;
                                                                            for(String trait : traits) {
                                                                                out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'/>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        
      out.write("\n");
      out.write("                                                                   <!--     <label for=\"one\">\n");
      out.write("                                                                            <input type=\"checkbox\" id=\"one\" />First checkbox</label>\n");
      out.write("                                                                        <label for=\"two\">\n");
      out.write("                                                                            <input type=\"checkbox\" id=\"two\" />Second checkbox</label>\n");
      out.write("                                                                        <label for=\"three\">\n");
      out.write("                                                                            <input type=\"checkbox\" id=\"three\" />Third checkbox</label>-->\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                            \n");
      out.write("                                                        </DIV>\n");
      out.write("                                                                   \n");
      out.write("                                                                    <h3>Key Resources</h3>\n");
      out.write("                                                        <span>SHORT DESCRIPTION</span>\n");
      out.write("                                                        <!--SEARCH OPTIONS-->\n");
      out.write("                                                        ");

                                                            cDAO = new CanvasDAO();
                                                            traits = cDAO.retrieveTraitsByDriver("key_resources");
                                                            out.println(traits.size());
                                                        
      out.write("\n");
      out.write("                                                        <DIV>\n");
      out.write("                                                            \n");
      out.write("                                                                <div class=\"multiselect\">\n");
      out.write("                                                                    <div class=\"selectBox\" onclick=\"checkBoxValues()\">\n");
      out.write("                                                                        <select>\n");
      out.write("                                                                            <option>Select an option</option>\n");
      out.write("                                                                        </select>\n");
      out.write("                                                                        <div class=\"overSelect\"></div>\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                    <div id=\"checkboxes\">\n");
      out.write("                                                                        <!--LOAD DATA HERE-->\n");
      out.write("                                                                        ");

                                                                            count = 1;
                                                                            for(String trait : traits) {
                                                                                out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'/>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        
      out.write("\n");
      out.write("                                                                   <!--     <label for=\"one\">\n");
      out.write("                                                                            <input type=\"checkbox\" id=\"one\" />First checkbox</label>\n");
      out.write("                                                                        <label for=\"two\">\n");
      out.write("                                                                            <input type=\"checkbox\" id=\"two\" />Second checkbox</label>\n");
      out.write("                                                                        <label for=\"three\">\n");
      out.write("                                                                            <input type=\"checkbox\" id=\"three\" />Third checkbox</label>-->\n");
      out.write("                                                                    </div>\n");
      out.write("                                                                </div>\n");
      out.write("                                                            \n");
      out.write("                                                        </DIV>\n");
      out.write("                                                                      <input type=\"submit\" value=\"submit\" name=\"traitsSearch\">\n");
      out.write("    </form>\n");
      out.write("                                            \n");
      out.write("                                                                \n");
      out.write("                                                                   <BR><BR>\n");
      out.write("                                                                   ");

                                                                   if(request.getAttribute("traitsSelected")!=null) {
                                                                    String[] tr = (String[])request.getAttribute("traitsSelected");
                                                                    for(String t : tr) {
                                                                        out.println(t);
                                                                    } 
                                                                   }else {
                                                                            out.println("nothing");
                                                                            }
                                                                    
                                                                   


      out.write("\n");
      out.write("    \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
