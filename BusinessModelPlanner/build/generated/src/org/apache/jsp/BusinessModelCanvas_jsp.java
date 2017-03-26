package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Scanner;
import com.app.model.entity.CanvasCompany;
import java.util.ArrayList;
import com.app.model.CanvasDAO;

public final class BusinessModelCanvas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jsp");
  }

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        ");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <!--[if IE]>\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("    <title>SIMHA - Business Model Planner Tool</title>\r\n");
      out.write("    <!--REQUIRED STYLE SHEETS-->\r\n");
      out.write("    <!-- BOOTSTRAP CORE STYLE CSS -->\r\n");
      out.write("    <link href=\"resources/css/bootstrap.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- FONTAWESOME STYLE CSS -->\r\n");
      out.write("    <link href=\"resources/css/font-awesome.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!--ANIMATED FONTAWESOME STYLE CSS -->\r\n");
      out.write("    <link href=\"assets/css/font-awesome-animation.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- VEGAS STYLE CSS -->\r\n");
      out.write("    <link href=\"resources/scripts/vegas/jquery.vegas.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- SIDE MENU STYLE CSS -->\r\n");
      out.write("    <link href=\"resources/css/component.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- CUSTOM STYLE CSS -->\r\n");
      out.write("    <link href=\"resources/css/indexStyle.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <!-- GOOGLE FONT -->\r\n");
      out.write("    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>\r\n");
      out.write("    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"cbp-spmenu-push\">\r\n");
      out.write("    <!-- MAIN HEADING-->\r\n");
      out.write("    <div class=\"for-full-back color-bg-one topbar\" id=\"main-sec\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row text-center\">\r\n");
      out.write("                <div class=\"col-md-8 col-md-offset-2 \">\r\n");
      out.write("                    <h1 class=\"pad-adjust\"><a href=\"index.jsp\"><img class=\"webapplogo\" src=\"resources/image/webapplogo.png\" alt=\"SIMHA\"></a></h1>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--END MAIN HEADING-->\r\n");
      out.write("\r\n");
      out.write("    <!--LEFT SLIDE MENU-->\r\n");
      out.write("    <nav class=\"cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left\" id=\"cbp-spmenu-s1\">\r\n");
      out.write("        <h3>Models</h3>\r\n");
      out.write("        <a href=\"#\">Select Model:</a>\r\n");
      out.write("        <a href=\"QADIM.jsp\"></i>QADIM</a>\r\n");
      out.write("        <a href=\"BOSC.jsp\"></i>Blue Ocean Strategy</a>\r\n");
      out.write("        <a href=\"#services-sec\"></i>Business Model Canvas</a>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"row\" id=\"icon-left\">\r\n");
      out.write("        <div class=\"col-md-12\">\r\n");
      out.write("            <i id=\"showLeftPush\" class=\"fa fa-bars fa-4x faa-horizontal animated\"></i>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--END LEFT SLIDE MENU-->\r\n");
      out.write("\r\n");
      out.write("    <!--RIGHT SLIDE MENU-->\r\n");
      out.write("    <nav class=\"cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right\" id=\"cbp-spmenu-s2\">\r\n");
      out.write("        <h3>Settings</h3>\r\n");
      out.write("        <a href=\"#\">Profile Options :</a>\r\n");
      out.write("        <a href=\"Logout\"><i class=\"fa fa-sign-out fa-2x\"></i>Log Out</a>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"row\" id=\"icon-right\">\r\n");
      out.write("        <div class=\"col-md-12\">\r\n");
      out.write("            <i id=\"showRightPush\" class=\"fa fa-cog fa-4x \"></i>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!--END RIGHT SLIDE MENU-->\r\n");
      out.write("\r\n");
      out.write("    <!--BODY-->\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Business Model Canvas</title>\r\n");
      out.write("        <!--CSS FOR INDEX-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/bmc/bmc-component.css\" />\r\n");
      out.write("        <!--CSS FOR TOOLTIPS-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/tooltips.css\" />\r\n");
      out.write("        <!--CSS FOR COMPANY SEARCH-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"resources/css/bmc/bmc-searchcom-style.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"resources/css/bmc/bmc-searchcom-listnav.css\"> \r\n");
      out.write("        <!--CSS FOR COMPANY AUTOFILL-->\r\n");
      out.write("        <!--CSS FOR DRIVERS SEARCH-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/bmc/bmc-searchdrivers-component.css\" />\r\n");
      out.write("        <!--CSS FOR DRIVERS SEARCH SELECT SCRIPTS-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"resources/css/bmc/bmc-searchdrivers-valuedropdownlist.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\t\r\n");
      out.write("            <div class=\"tooltipcontent\">\r\n");
      out.write("                <div class=\"dummy dummy-text\">\r\n");
      out.write("\r\n");
      out.write("                    <span class=\"tooltip-item\" style=\"font-size:1.8em\">BUSINESS MODEL BUFFET</span><br>\r\n");
      out.write("\r\n");
      out.write("                    allows users to source through an existing list of\r\n");
      out.write("                    implementation choices across all 9 value drivers, and generate the closest matching company that fits your selection.\r\n");
      out.write("                    You can also generate all the value drivers pertaining to a specific company, and gather inspiration for your own business model.\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"bl-main\" class=\"bl-main\">\r\n");
      out.write("                <!--SECTION FOR SEARCH COMPANIES-->\r\n");
      out.write("                <section>\r\n");
      out.write("                    <div class=\"bl-box\">\r\n");
      out.write("                        <h2 class=\"bl-icon bl-icon-about\">Search by Companies</h2>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!--CONTENT-->\r\n");
      out.write("                    <div class=\"bl-content\">\r\n");
      out.write("                        <!--Auto Search Function-->\r\n");
      out.write("                        <br><br>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <ul id=\"demoFour\" class=\"demoFourClass\">\r\n");
      out.write("                                ");
                                        CanvasDAO canvasDAO = new CanvasDAO();
                                    ArrayList<String> companyList = canvasDAO.retrieveAllCompanies();
                                    for (String name : companyList) {
                                
      out.write("\r\n");
      out.write("                                <li><a href='BMC_Results.jsp?companyName=");
      out.print(name);
      out.write('\'');
      out.write('>');
      out.print(name);
      out.write("</a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                ");


                                    }
                                
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!--CLOSE BUTTON-->\r\n");
      out.write("                    <span class=\"bl-icon bl-icon-close\"></span>\r\n");
      out.write("                </section>\r\n");
      out.write("                <!--SECTION CLOSED-->\r\n");
      out.write("\r\n");
      out.write("                <!--SECTION FOR SEARCH BY DRIVERS-->\r\n");
      out.write("                <section id=\"bl-work-section\">\r\n");
      out.write("                    <div class=\"bl-box\">\r\n");
      out.write("                        <h2 class=\"bl-icon bl-icon-works\">Search by Drivers</h2>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"bl-content\">\r\n");
      out.write("                        <form action=\"CanvasController\">\r\n");
      out.write("                            <h2>SEARCH BY DRIVERS</h2>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <div class=\"container demo-3\">\r\n");
      out.write("                                    <ul class=\"grid cs-style-4\">\r\n");
      out.write("                                        <!--KEY PARTNERS-->\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                            <figure>\r\n");
      out.write("                                                <div><img src=\"resources/image/keypartners.jpg\" alt=\"keypartners\"></div>\r\n");
      out.write("                                                <figcaption>\r\n");
      out.write("\r\n");
      out.write("                                                    <h3>Key Partners</h3>\r\n");
      out.write("                                                    <span>SHORT DESCRIPTION</span>\r\n");
      out.write("                                                    <!--SEARCH OPTIONS-->\r\n");
      out.write("                                                    ");

                                                        CanvasDAO cDAO = new CanvasDAO();
                                                        ArrayList<String> traits = cDAO.retrieveTraitsByDriver("key_partnerships");
                                                        //      out.println(traits.size());
                                                    
      out.write("\r\n");
      out.write("                                                    <DIV>\r\n");
      out.write("                                                        <div class=\"multiselect\">\r\n");
      out.write("                                                            <div class=\"selectBox\" onclick=\"keyPartners()\">\r\n");
      out.write("                                                                <select>\r\n");
      out.write("                                                                    <option>Select an option</option>\r\n");
      out.write("                                                                </select>\r\n");
      out.write("                                                                <div class=\"overSelect\"></div>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"checkboxes\" id=\"keyPartners\">\r\n");
      out.write("                                                                <!--LOAD DATA HERE-->\r\n");
      out.write("                                                                ");

                                                                    int count = 1;
                                                                    for (String trait : traits) {
                                                                        out.println("<label for='" + count + "'><input type='checkbox' id='" + count + "' name=allTheTraits value='" + trait + "'>" + trait + "</label>");
                                                                        count++;
                                                                    }
                                                                
      out.write("\r\n");
      out.write("                                                            \r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </DIV>\r\n");
      out.write("\r\n");
      out.write("                                                </figcaption>\r\n");
      out.write("                                            </figure>\r\n");
      out.write("                                        </li>\r\n");
      out.write("\r\n");
      out.write("                                        <!--KEY ACTIVITIES-->\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                            <figure>\r\n");
      out.write("                                                <div><img src=\"resources/image/keyactivities.jpg\" alt=\"img06\"></div>\r\n");
      out.write("                                                <figcaption>\r\n");
      out.write("                                                    <h3>Key Activities</h3>\r\n");
      out.write("                                                    <span>SHORT DESCRIPTION</span>\r\n");
      out.write("                                                    <!--SEARCH OPTIONS-->\r\n");
      out.write("                                                    ");

                                                        traits = cDAO.retrieveTraitsByDriver("key_activities");
                                                        //      out.println(traits.size());
                                                    
      out.write("\r\n");
      out.write("                                                    <DIV>\r\n");
      out.write("                                                        <div class=\"multiselect\">\r\n");
      out.write("                                                            <div class=\"selectBox\" onclick=\"keyactivities()\">\r\n");
      out.write("                                                                <select>\r\n");
      out.write("                                                                    <option>Select an option</option>\r\n");
      out.write("                                                                </select>\r\n");
      out.write("                                                                <div class=\"overSelect\"></div>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"checkboxes\" id=\"keyactivities\">\r\n");
      out.write("                                                                <!--LOAD DATA HERE-->\r\n");
      out.write("                                                                ");

                                                                    count = 1;
                                                                    for (String trait : traits) {
                                                                        out.println("<label for='" + count + "'><input type='checkbox' id='" + count + "' name=allTheTraits value='" + trait + "'>" + trait + "</label>");
                                                                        count++;
                                                                    }
                                                                
      out.write("\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </DIV>\r\n");
      out.write("                                                </figcaption>\r\n");
      out.write("                                            </figure>\r\n");
      out.write("                                        </li>\r\n");
      out.write("\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                            <figure>\r\n");
      out.write("                                                <div><img src=\"resources/image/keyresources.jpg\" alt=\"img02\"></div>\r\n");
      out.write("                                                <figcaption>\r\n");
      out.write("                                                    <h3>Key Resources</h3>\r\n");
      out.write("                                                    <span>SHORT DESCRIPTION</span>\r\n");
      out.write("                                                    <!--SEARCH OPTIONS-->\r\n");
      out.write("                                                    ");

                                                        traits = cDAO.retrieveTraitsByDriver("key_resources");
                                                        //      out.println(traits.size());
                                                    
      out.write("\r\n");
      out.write("                                                    <DIV>\r\n");
      out.write("                                                        <div class=\"multiselect\">\r\n");
      out.write("                                                            <div class=\"selectBox\" onclick=\"keyresources()\">\r\n");
      out.write("                                                                <select>\r\n");
      out.write("                                                                    <option>Select an option</option>\r\n");
      out.write("                                                                </select>\r\n");
      out.write("                                                                <div class=\"overSelect\"></div>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"checkboxes\" id=\"keyresources\">\r\n");
      out.write("                                                                <!--LOAD DATA HERE-->\r\n");
      out.write("                                                                ");

                                                                    count = 1;
                                                                    for (String trait : traits) {
                                                                        out.println("<label for='" + count + "'><input type='checkbox' id='" + count + "' name=allTheTraits value='" + trait + "'>" + trait + "</label>");
                                                                        count++;
                                                                    }
                                                                
      out.write("\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </DIV>\r\n");
      out.write("                                                </figcaption>\r\n");
      out.write("                                            </figure>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                            <figure>\r\n");
      out.write("                                                <div><img src=\"resources/image/valueproposition.jpg\" alt=\"img04\"></div>\r\n");
      out.write("                                                <figcaption>\r\n");
      out.write("                                                    <h3>Value Proposition</h3>\r\n");
      out.write("                                                    <span>SHORT DESCRIPTION</span>\r\n");
      out.write("                                                    <!--SEARCH OPTIONS-->\r\n");
      out.write("                                                    ");

                                                        traits = cDAO.retrieveTraitsByDriver("value_proposition");
                                                        //      out.println(traits.size());
                                                    
      out.write("\r\n");
      out.write("                                                    <DIV>\r\n");
      out.write("                                                        <div class=\"multiselect\">\r\n");
      out.write("                                                            <div class=\"selectBox\" onclick=\"valueproposition()\">\r\n");
      out.write("                                                                <select>\r\n");
      out.write("                                                                    <option>Select an option</option>\r\n");
      out.write("                                                                </select>\r\n");
      out.write("                                                                <div class=\"overSelect\"></div>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"checkboxes\" id=\"valueproposition\">\r\n");
      out.write("                                                                <!--LOAD DATA HERE-->\r\n");
      out.write("                                                                ");

                                                                    count = 1;
                                                                    for (String trait : traits) {
                                                                        out.println("<label for='" + count + "'><input type='checkbox' id='" + count + "' name=allTheTraits value='" + trait + "'>" + trait + "</label>");
                                                                        count++;
                                                                    }
                                                                
      out.write("\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </DIV>\r\n");
      out.write("                                                </figcaption>\r\n");
      out.write("                                            </figure>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                            <figure>\r\n");
      out.write("                                                <div><img src=\"resources/image/customersegments.jpg\" alt=\"img01\"></div>\r\n");
      out.write("                                                <figcaption>\r\n");
      out.write("                                                    <h3>Customer Segments</h3>\r\n");
      out.write("                                                    <span>SHORT DESCRIPTION</span>\r\n");
      out.write("                                                    <!--SEARCH OPTIONS-->\r\n");
      out.write("                                                    ");

                                                        traits = cDAO.retrieveTraitsByDriver("customer_acquisition");
                                                        //      out.println(traits.size());
                                                    
      out.write("\r\n");
      out.write("                                                    <div class=\"multiselect\">\r\n");
      out.write("                                                        <div class=\"selectBox\" onclick=\"customersegments()\">\r\n");
      out.write("                                                            <select>\r\n");
      out.write("                                                                <option>Select an option</option>\r\n");
      out.write("                                                            </select>\r\n");
      out.write("                                                            <div class=\"overSelect\"></div>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                        <div class=\"checkboxes\" id=\"customersegments\">\r\n");
      out.write("                                                            <!--LOAD DATA HERE-->\r\n");
      out.write("                                                            ");

                                                                    count = 1;
                                                                    for (String trait : traits) {
                                                                        out.println("<label for='" + count + "'><input type='checkbox' id='" + count + "' name=allTheTraits value='" + trait + "'>" + trait + "</label>");
                                                                        count++;
                                                                    }
                                                                
      out.write("\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </figcaption>\r\n");
      out.write("                                            </figure>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                            <figure>\r\n");
      out.write("                                                <div><img src=\"resources/image/customerrelationship.jpg\" alt=\"img03\"></div>\r\n");
      out.write("                                                <figcaption>\r\n");
      out.write("                                                    <h3>Customer Relationship</h3>\r\n");
      out.write("                                                    <span>SHORT DESCRIPTION</span>\r\n");
      out.write("                                                    <!--SEARCH OPTIONS-->\r\n");
      out.write("                                                    ");

                                                        traits = cDAO.retrieveTraitsByDriver("customer_relations");
                                                        //      out.println(traits.size());
                                                    
      out.write("\r\n");
      out.write("                                                    <DIV>\r\n");
      out.write("                                                        <div class=\"multiselect\">\r\n");
      out.write("                                                            <div class=\"selectBox\" onclick=\"customerrelationship()\">\r\n");
      out.write("                                                                <select>\r\n");
      out.write("                                                                    <option>Select an option</option>\r\n");
      out.write("                                                                </select>\r\n");
      out.write("                                                                <div class=\"overSelect\"></div>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"checkboxes\" id=\"customerrelationship\">\r\n");
      out.write("                                                                <!--LOAD DATA HERE-->\r\n");
      out.write("                                                                ");

                                                                    count = 1;
                                                                    for (String trait : traits) {
                                                                        out.println("<label for='" + count + "'><input type='checkbox' id='" + count + "' name=allTheTraits value='" + trait + "'>" + trait + "</label>");
                                                                        count++;
                                                                    }
                                                                
      out.write("\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </DIV>\r\n");
      out.write("                                                </figcaption>\r\n");
      out.write("                                            </figure>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                            <figure>\r\n");
      out.write("                                                <div><img src=\"resources/image/channels.jpg\" alt=\"img03\"></div>\r\n");
      out.write("                                                <figcaption>\r\n");
      out.write("                                                    <h3>Channels</h3>\r\n");
      out.write("                                                    <span>SHORT DESCRIPTION</span>\r\n");
      out.write("                                                    <!--SEARCH OPTIONS-->\r\n");
      out.write("                                                    ");

                                                        traits = cDAO.retrieveTraitsByDriver("channel_strategy");
                                                        //      out.println(traits.size());
                                                    
      out.write("\r\n");
      out.write("                                                    <DIV>\r\n");
      out.write("                                                        <div class=\"multiselect\">\r\n");
      out.write("                                                            <div class=\"selectBox\" onclick=\"channels()\">\r\n");
      out.write("                                                                <select>\r\n");
      out.write("                                                                    <option>Select an option</option>\r\n");
      out.write("                                                                </select>\r\n");
      out.write("                                                                <div class=\"overSelect\"></div>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"checkboxes\" id=\"channels\">\r\n");
      out.write("                                                                <!--LOAD DATA HERE-->\r\n");
      out.write("                                                                ");

                                                                    count = 1;
                                                                    for (String trait : traits) {
                                                                        out.println("<label for='" + count + "'><input type='checkbox' id='" + count + "' name=allTheTraits value='" + trait + "'>" + trait + "</label>");
                                                                        count++;
                                                                    }
                                                                
      out.write("\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </DIV>\r\n");
      out.write("                                                </figcaption>\r\n");
      out.write("                                            </figure>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                            <figure>\r\n");
      out.write("                                                <div><img src=\"resources/image/coststructure.jpg\" alt=\"img03\"></div>\r\n");
      out.write("                                                <figcaption>\r\n");
      out.write("                                                    <h3>Cost Structure</h3>\r\n");
      out.write("                                                    <span>SHORT DESCRIPTION</span>\r\n");
      out.write("                                                    <!--SEARCH OPTIONS-->\r\n");
      out.write("                                                    ");

                                                        traits = cDAO.retrieveTraitsByDriver("cost_management");
                                                        //      out.println(traits.size());
                                                    
      out.write("\r\n");
      out.write("                                                    <DIV>\r\n");
      out.write("                                                        <div class=\"multiselect\">\r\n");
      out.write("                                                            <div class=\"selectBox\" onclick=\"coststructure()\">\r\n");
      out.write("                                                                <select>\r\n");
      out.write("                                                                    <option>Select an option</option>\r\n");
      out.write("                                                                </select>\r\n");
      out.write("                                                                <div class=\"overSelect\"></div>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"checkboxes\" id=\"coststructure\">\r\n");
      out.write("                                                                <!--LOAD DATA HERE-->\r\n");
      out.write("                                                                ");

                                                                    count = 1;
                                                                    for (String trait : traits) {
                                                                        out.println("<label for='" + count + "'><input type='checkbox' id='" + count + "' name=allTheTraits value='" + trait + "'>" + trait + "</label>");
                                                                        count++;
                                                                    }
                                                                
      out.write("\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </DIV>\r\n");
      out.write("                                                </figcaption>\r\n");
      out.write("                                            </figure>\r\n");
      out.write("                                        </li>\r\n");
      out.write("                                        <li>\r\n");
      out.write("                                            <figure>\r\n");
      out.write("                                                <div><img src=\"resources/image/revenuestreams.jpg\" alt=\"img03\"></div>\r\n");
      out.write("                                                <figcaption>\r\n");
      out.write("                                                    <h3>Revenue Streams</h3>\r\n");
      out.write("                                                    <span>SHORT DESCRIPTION</span>\r\n");
      out.write("                                                    <!--SEARCH OPTIONS-->\r\n");
      out.write("                                                    ");

                                                        traits = cDAO.retrieveTraitsByDriver("revenues");
                                                        //      out.println(traits.size());
                                                    
      out.write("\r\n");
      out.write("                                                    <DIV>\r\n");
      out.write("                                                        <div class=\"multiselect\">\r\n");
      out.write("                                                            <div class=\"selectBox\" onclick=\"revenuestreams()\">\r\n");
      out.write("                                                                <select>\r\n");
      out.write("                                                                    <option>Select an option</option>\r\n");
      out.write("                                                                </select>\r\n");
      out.write("                                                                <div class=\"overSelect\"></div>\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                            <div class=\"checkboxes\" id=\"revenuestreams\">\r\n");
      out.write("                                                                <!--LOAD DATA HERE-->\r\n");
      out.write("                                                                ");

                                                                    count = 1;
                                                                    for (String trait : traits) {
                                                                        out.println("<label for='" + count + "'><input type='checkbox' id='" + count + "' name=allTheTraits value='" + trait + "'>" + trait + "</label>");
                                                                        count++;
                                                                    }
                                                                
      out.write("\r\n");
      out.write("                                                            </div>\r\n");
      out.write("                                                        </div>\r\n");
      out.write("                                                    </DIV>\r\n");
      out.write("                                                </figcaption>\r\n");
      out.write("                                            </figure>\r\n");
      out.write("                                        </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    </ul>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <input type=\"submit\" value=\"submit\" name=\"traitsSearch\">\r\n");
      out.write("                        </form>\r\n");
      out.write("                        <span class=\"bl-icon bl-icon-close\"></span>\r\n");
      out.write("                </section>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- SCRIPT FOR MAIN INDEX -->\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"resources/js/bmc/bmc-modernizr.custom.js\"></script>\r\n");
      out.write("        <script src=\"resources/js/bmc/bmc-boxlayout.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("                                                                $(function () {\r\n");
      out.write("                                                                    Boxlayout.init();\r\n");
      out.write("                                                                });\r\n");
      out.write("        </SCRIPT>                                                                                                                \r\n");
      out.write("\r\n");
      out.write("        <!--SCRIPT FOR COMPANY SEARCH-->\r\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("        <script src=\"resources/js/bmc/bmc-searchcom-listnav.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("                                                                $(function () {\r\n");
      out.write("                                                                    $('#demoFour').listnav({\r\n");
      out.write("                                                                        includeAll: true,\r\n");
      out.write("                                                                        includeNums: true,\r\n");
      out.write("                                                                        showCounts: false,\r\n");
      out.write("                                                                        allText: 'All Companies',\r\n");
      out.write("                                                                        onClick: function (letter) {\r\n");
      out.write("                                                                            $(\".myLastClicked\").text(letter.toUpperCase());\r\n");
      out.write("                                                                        }\r\n");
      out.write("                                                                    });\r\n");
      out.write("                                                                });\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!--SCRIPT FOR COMPANY SEARCH AUTOFILL-->\r\n");
      out.write("\r\n");
      out.write("        <!--SCRIPT FOR DRIVERS SEARCH-->\r\n");
      out.write("        <script src=\"resources/js/bmc/bmc-searchdrivers-dropdown.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
