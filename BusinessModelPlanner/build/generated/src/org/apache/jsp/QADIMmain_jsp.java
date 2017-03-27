package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class QADIMmain_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <!--CSS FOR TOOLTIPS-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/qadim/qadimTooltip.css\" />\n");
      out.write("        <!--CSS FOR CURRENT PAGE-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/qadim/qadimForm.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/qadim/qadimformComponent.css\" />\n");
      out.write("        <!--CSS FOR LOADING PROJECT-->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/qadim/qadim-cs-select.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/qadim/qadim-cs-skin-elastic.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <CENTER>\n");
      out.write("        <!--EXPLANATION-->\n");
      out.write("        <div id=\"maincontent\">\n");
      out.write("            <div class=\"tooltipcontent\">\n");
      out.write("                <div class=\"dummy dummy-text\">\n");
      out.write("                    <br><br><br>\n");
      out.write("                    <span class=\"tooltip tooltip-effect-3\">\n");
      out.write("                        <span class=\"tooltip-item\" style=\"font-size:1.8em\">QaDIM</span>\n");
      out.write("                        <span class=\"tooltip-content clearfix\">\n");
      out.write("                            <span class=\"tooltip-text\" style=\"padding-left:15px\">\n");
      out.write("                                An innovation framework, also known as the THE QUICK AND DIRTY INNOVATION MODEL.<br>\n");
      out.write("                            </span></span></span> enable \n");
      out.write("                    users to <b><u>identify incremental innovation opportunities</u></b> for \n");
      out.write("                    existing or new products or services. You can start by either <b>creating a new project</b> or <b>load your existing project</b>\n");
      out.write("                    below\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <br><br>\n");
      out.write("            <!--END OF EXPLANATION-->          \n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <!--LOAD NEW PROJECT//NAV TO QADIMnewProjectForm-->\n");
      out.write("                        <a href='QADIMnewProject.jsp'><h1>CREATE NEW PROJECT</h1></a>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <!--LOAD EXISTING PROJECT-->\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <section>\n");
      out.write("                                <select class=\"cs-select cs-skin-elastic\">\n");
      out.write("                                    <option value=\"\" disabled selected>Load Existing Project</option>\n");
      out.write("                                    <option value=\"france\" >France</option>\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </section>\n");
      out.write("                        </div><!-- /container -->\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("    </CENTER>\n");
      out.write("    <!--SCRIPT FOR DROPDOWN-->\n");
      out.write("    <script src=\"resources/js/qadim/qadimClassie.js\"></script>\n");
      out.write("    <script src=\"resources/js/qadim/qadimFormSelectFx.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        (function () {\n");
      out.write("            [].slice.call(document.querySelectorAll('select.cs-select')).forEach(function (el) {\n");
      out.write("                new SelectFx(el);\n");
      out.write("            });\n");
      out.write("        })();\n");
      out.write("    </script>\n");
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
