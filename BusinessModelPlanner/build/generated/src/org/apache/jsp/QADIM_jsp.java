package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class QADIM_jsp extends org.apache.jasper.runtime.HttpJspBase
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


    String productName = request.getParameter("productName");
    String projectName = request.getParameter("projectName");
    if(productName != null){
        session.setAttribute("productName",productName);
    }
    if(projectName != null){
        session.setAttribute("projectName",projectName);
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--[if lt IE 7 ]><html class=\"ie ie6\" lang=\"en\"> <![endif]-->\n");
      out.write("<!--[if IE 7 ]><html class=\"ie ie7\" lang=\"en\"> <![endif]-->\n");
      out.write("<!--[if IE 8 ]><html class=\"ie ie8\" lang=\"en\"> <![endif]-->\n");
      out.write("<!--[if (gte IE 9)|!(IE)]><!-->\n");
      out.write("<html lang=\"en\">\n");
      out.write("<!--<![endif]-->\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <!--[if IE]>\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("        <![endif]-->\n");
      out.write("    <title>Happy6Friends - FYP</title>\n");
      out.write("    <!--REQUIRED STYLE SHEETS-->\n");
      out.write("    <!-- BOOTSTRAP CORE STYLE CSS -->\n");
      out.write("    <link href=\"resources/css/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("    <!-- FONTAWESOME STYLE CSS -->\n");
      out.write("    <link href=\"resources/css/font-awesome.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <!--ANIMATED FONTAWESOME STYLE CSS -->\n");
      out.write("    <link href=\"assets/css/font-awesome-animation.css\" rel=\"stylesheet\" />\n");
      out.write("    <!-- VEGAS STYLE CSS -->\n");
      out.write("    <link href=\"resources/scripts/vegas/jquery.vegas.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <!-- SIDE MENU STYLE CSS -->\n");
      out.write("    <link href=\"resources/css/component.css\" rel=\"stylesheet\" />\n");
      out.write("    <!-- CUSTOM STYLE CSS -->\n");
      out.write("    <link href=\"resources/css/indexStyle.css\" rel=\"stylesheet\" />\n");
      out.write("    <!-- GOOGLE FONT -->\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>\n");
      out.write("    <!-- QADIM CSS -->\n");
      out.write("    <link href='resources/css/QADIM.css' rel='stylesheet' type='text/css'>\n");
      out.write("    <!-- LIGHTBOX CSS -->\n");
      out.write("    <link href=\"resources/css/lightbox-form.css\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("</head>\n");
      out.write("<body class=\"cbp-spmenu-push\">\n");
      out.write("\n");
      out.write("    <!-- MAIN HEADING-->\n");
      out.write("    <div class=\"for-full-back color-bg-one topbar\" id=\"main-sec\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row text-center\">\n");
      out.write("                <div class=\"col-md-8 col-md-offset-2 \">\n");
      out.write("                    <h1 class=\"pad-adjust\"><i class=\"fa fa-plus faa-pulse animated\"></i>FYP</h1>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!--END MAIN HEADING-->\n");
      out.write("    <!--LEFT SLIDE MENU-->\n");
      out.write("    <nav class=\"cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left\" id=\"cbp-spmenu-s1\">\n");
      out.write("        <h3>Models</h3>\n");
      out.write("        <a href=\"#\">Select Model:</a>\n");
      out.write("        <a href=\"#QADIM.jsp\"></i>QADIM</a>\n");
      out.write("        <a href=\"#price-sec\"></i>Blue Ocean Strategy</a>\n");
      out.write("        <a href=\"#services-sec\"></i>Business Model Canvas</a>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <div class=\"row\" id=\"icon-left\">\n");
      out.write("        <div class=\"col-md-12\">\n");
      out.write("            <i id=\"showLeftPush\" class=\"fa fa-bars fa-4x faa-horizontal animated\"></i>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!--END LEFT SLIDE MENU-->\n");
      out.write("\n");
      out.write("    <!--RIGHT SLIDE MENU-->\n");
      out.write("    <nav class=\"cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right\" id=\"cbp-spmenu-s2\">\n");
      out.write("        <h3>SOCIAL</h3>\n");
      out.write("        <a href=\"#\">MY SOCIAL PRESENCE</a>\n");
      out.write("        <a href=\"#\"><i class=\"fa fa-facebook fa-3x\"></i>Facebook</a>\n");
      out.write("        <a href=\"#\"><i class=\"fa fa-twitter fa-3x\"></i>Twitter</a>\n");
      out.write("        <a href=\"#\"><i class=\"fa fa-linkedin fa-3x\"></i>Linked In</a>\n");
      out.write("        <a href=\"#\"><i class=\"fa fa-google-plus fa-3x\"></i>Google Plus</a>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <div class=\"row\" id=\"icon-right\">\n");
      out.write("        <div class=\"col-md-12\">\n");
      out.write("            <i id=\"showRightPush\" class=\"fa fa-cog fa-4x \"></i>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!--END RIGHT SLIDE MENU-->\n");
      out.write("\n");
      out.write("    <!--ABOUT SECTION-->\n");
      out.write("    <section class=\"for-full-back color-white bodyStart\" id=\"about-models\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row text-center g-pad-bottom\">\n");
      out.write("                <div class=\"col-md-8 col-md-offset-2 \">\n");
      out.write("                    <h3>QADIM - Quick and Dirty Innovation Model</h3>\n");
      out.write("                    <h4>\n");
      out.write("                        Quick and Dirty Innovation Model\n");
      out.write("                    </h4>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("    <!--END ABOUT SECTION-->\n");
      out.write("    <div class=\"shadowing\" id=\"shadowing\"></div>\n");
      out.write("    <div class=\"box\" id=\"step1\">\n");
      out.write("      <span class=\"boxtitle\" >QADIM: Step 1</span>\n");
      out.write("      <form method=\"GET\" action=\"#\" target=\"_parent\">\n");
      out.write("\n");
      out.write("        <p>What is your Project Name?\n");
      out.write("          <input type=\"text\" name=\"projectName\" maxlength=\"60\" size=\"60\">\n");
      out.write("          Please Enter Product Name\n");
      out.write("          <input type=\"text\" name=\"productName\" maxlength=\"60\" size=\"60\">\n");
      out.write("        </p>\n");
      out.write("        <p> \n");
      out.write("          <input type=\"submit\" name=\"submit\">\n");
      out.write("          <input type=\"button\" name=\"cancel\" value=\"Cancel\" onClick=\"closebox()\">\n");
      out.write("        </p>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("        <div class=\"shadowing\" id=\"shadowing\"></div>\n");
      out.write("    <div class=\"box\" id=\"editProduct\">\n");
      out.write("      <span class=\"boxtitle\" >QADIM: Edit Product Name</span>\n");
      out.write("      <form method=\"GET\" action=\"#\" target=\"_parent\">\n");
      out.write("\n");
      out.write("        <p>\n");
      out.write("          Please Enter Product Name\n");
      out.write("          <input type=\"text\" name=\"productName\" maxlength=\"60\" size=\"60\" value=\"");
      out.print((String) request.getSession().getAttribute("productName"));
      out.write("\">\n");
      out.write("        </p>\n");
      out.write("        <p> \n");
      out.write("          <input type=\"submit\" name=\"submit\">\n");
      out.write("          <input type=\"button\" name=\"cancel\" value=\"Cancel\" onClick=\"closebox()\">\n");
      out.write("        </p>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <!-- QADIM BODY SECTION-->\n");
      out.write("    <section>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row g-pad-bottom QADIM-Body\">\n");
      out.write("                \n");
      out.write("                ");
 
                if (session.getAttribute("productName") != null){
                
      out.write("\n");
      out.write("                <h3>");
      out.print( session.getAttribute("projectName"));
      out.write("</h3>\n");
      out.write("                <table class=\"QADIM-Table\">\n");
      out.write("                    <tr>\n");
      out.write("                      <td></td>\n");
      out.write("                      <td></td>\n");
      out.write("                      <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                      <td></td>\n");
      out.write("                      <td><button class=\"productBtn\" onClick=\"openEditProductBox(1)\">\n");
      out.write("                          ");
      out.print(session.getAttribute("productName"));
      out.write("\n");
      out.write("                        </button>\n");
      out.write("                      </td>\n");
      out.write("                      <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                      <td></td>\n");
      out.write("                      <td></td>\n");
      out.write("                      <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                ");
 } else{ 
      out.write("\n");
      out.write("\n");
      out.write("                    <button class=\"QADIMStartButton\" onClick=\"openStep1Box(1)\">Click Here To Begin</button>\n");
      out.write("\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("    <!-- END QADIM BODY SECTION-->\n");
      out.write("\n");
      out.write("    <!--FOOTER SECTION -->\n");
      out.write("    <div class=\"for-full-back color-bg-one\" id=\"footer\">\n");
      out.write("        2014 www.yourdomain.com | All Right Reserved | Terms | Policies | Licenses \n");
      out.write("         \n");
      out.write("    </div>\n");
      out.write("    <!-- END FOOTER SECTION -->\n");
      out.write("\n");
      out.write("    <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->\n");
      out.write("    <!-- CORE JQUERY  -->\n");
      out.write("    <script src=\"resources/js/jquery-1.10.2.js\"></script>\n");
      out.write("    <!-- BOOTSTRAP CORE SCRIPT   -->\n");
      out.write("    <script src=\"resources/js/bootstrap.js\"></script>\n");
      out.write("    <!-- SIDE MENU SCRIPTS -->\n");
      out.write("    <script src=\"resources/js/modernizr.custom.js\"></script>\n");
      out.write("    <script src=\"resources/js/classie.js\"></script>\n");
      out.write("    <!-- VEGAS SLIDESHOW SCRIPTS -->\n");
      out.write("    <script src=\"resources/js/jquery.vegas.min.js\"></script>\n");
      out.write("    <!-- CUSTOM SCRIPTS -->\n");
      out.write("    <script src=\"resources/js/custom.js\"></script>\n");
      out.write("    <!-- LIGHTBOX SCRIPTS -->\n");
      out.write("    <script src=\"resources/js/lightbox-form.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
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
