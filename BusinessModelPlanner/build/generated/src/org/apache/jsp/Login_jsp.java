package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');

   /* if (session.getAttribute("user") == "admin") {
        response.sendRedirect("admin.jsp");
        return;
    }else if(session.getAttribute("user") != null){
        response.sendRedirect("mainMenu.jsp");
        return;

    }
    */
    

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>SIMHA - Business Model Planner Tool</title>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("         <link rel=\"stylesheet\" href=\"resources/css/style.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"login-page\">\r\n");
      out.write("            <div class=\"companylogo\">\r\n");
      out.write("                <img class=\"webapplogo\" src=\"resources/image/SIMHA.png\" alt=\"SIMHA\">\r\n");
      out.write("            </div><br>\r\n");
      out.write("            <div class=\"form\">\r\n");
      out.write("              <form class=\"register-form\" method=\"post\" action=\"Register\">\r\n");
      out.write("                <input type=\"text\" placeholder=\"name (your first and last name)\" name=\"name\"/>\r\n");
      out.write("                <input type=\"password\" placeholder=\"password (at least 8 alphanumeric characters)\" name=\"password\"/>\r\n");
      out.write("                <input type=\"password\" placeholder=\"confirm your password\" name=\"confirmPassword\"/>\r\n");
      out.write("                <input type=\"text\" placeholder=\"email address\" name=\"email\"/>\r\n");
      out.write("                <!--Please Change the Front End-->\r\n");
      out.write("                Type: <select name=\"type\">\r\n");
      out.write("                    <option value=\"administrator\">Administrator</option>\r\n");
      out.write("                    <option value=\"student\">Student</option>   \r\n");
      out.write("                    <option value=\"corporate\">Corporate</option>  \r\n");
      out.write("                </select> \r\n");
      out.write("                <input class=\"btn\" type=\"submit\" id=\"register\" value=\"Register »\" name=\"submit\">\r\n");
      out.write("                <p class=\"message\">Already registered? <a href=\"#\">Sign In</a></p>\r\n");
      out.write("              </form>\r\n");
      out.write("                \r\n");
      out.write("              <form class=\"login-form\" method=\"post\" action=\"Login\">\r\n");
      out.write("                <input type=\"text\" placeholder=\"email address\" name=\"username\"/>\r\n");
      out.write("                <input type=\"password\" placeholder=\"password\" name=\"password\"/>\r\n");
      out.write("                <input class=\"btn\" type=\"submit\" id=\"login\" value=\"Login »\" name=\"submit\">\r\n");
      out.write("                <p class=\"message\">\r\n");
      out.write("                ");

    
                    String error = (String) request.getAttribute("errorMsg");

                    if (error != null) {
                        out.println("<font color='red'>" + error + "</br><br> </font>");
                    }

    
                    String success = (String) request.getAttribute("successMsg");

                    if (success != null) {
                        out.println("<font color='green'>" + success + "</br><br> </font>");
                    }

                
      out.write("\r\n");
      out.write("                <br/>\r\n");
      out.write("                    Not registered? <a href=\"#\">Create an account</a></p>\r\n");
      out.write("              </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"resources/js/index.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
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
