package org.apache.jsp.show_005fmap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class show_005fback_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\" />\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("    <title>Track</title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        html{height:100%}\r\n");
      out.write("        body{height:100%;margin:0px;padding:0px}\r\n");
      out.write("        #controller{width:100%; border-bottom:3px outset; height:30px; filter:alpha(Opacity=100); -moz-opacity:1; opacity:1; z-index:10000; background-color:lightblue;}\r\n");
      out.write("        #Container{height:100%}\r\n");
      out.write("    </style>\r\n");
      out.write("   <script src=\"../script/jquery-1.8.3.min.js\" ></script>\r\n");
      out.write("<script src=\"../script/track_back.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://api.map.baidu.com/api?v=2.0&ak=B7d71c582e960e8bc1eae517183b5f77\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body  >\r\n");
      out.write("\r\n");
      out.write("<div id=\"controller\" align=\"center\">\r\n");
      out.write("    æ¶é´ï¼<input type=\"text\" style=\"color:#429812;\" id=\"gps_time_from\" value=\"2015-09-19\"/>å°\r\n");
      out.write("    <input type=\"text\" style=\"color:#429812;\" id=\"gps_time_to\" value=\"2015-09-21\"/>\r\n");
      out.write("    è¶ééå¶\r\n");
      out.write("    <input type=\"text\" style=\"color:#429812;\" id=\"chaosuxianzhi\" value=\"60\"/>\r\n");
      out.write("    <!-- <input type=\"text\" class=\"\" id=\"device_id\" value=\"381215032027883\"/>-->\r\n");
      out.write("    <input type=\"button\" class=\"\" id=\"\" value=\"æ¥è¯¢\" onclick=\"Map.addline();\"/>\r\n");
      out.write("    <input id=\"follow\" type=\"checkbox\"><span style=\"font-size:12px;\">ç»é¢è·é</span></input>\r\n");
      out.write("    <input id=\"play\" type=\"button\" value=\"æ­æ¾\" onclick=\"play();\" disabled />\r\n");
      out.write("    <input id=\"pause\" type=\"button\" value=\"æå\" onclick=\"pause();\" disabled />\r\n");
      out.write("    <input id=\"reset\" type=\"button\" value=\"éç½®\" onclick=\"reset()\" disabled />\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"body-nest\" id=\"Footable1\" >\r\n");
      out.write("\r\n");
      out.write("è¶éç»è®¡\r\n");
      out.write("    <table class=\"table-striped footable-res footable metro-blue\" data-page-size=\"6\" width=\"1200\" border=\"1\" cellspacing=\"0\">\r\n");
      out.write("        <thead>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>\r\n");
      out.write("                è®¾å¤ID\r\n");
      out.write("            </th>\r\n");
      out.write("\r\n");
      out.write("            <th>\r\n");
      out.write("                ç»åº¦\r\n");
      out.write("            </th>\r\n");
      out.write("            <th>\r\n");
      out.write("                çº¬åº¦\r\n");
      out.write("            </th>\r\n");
      out.write("            <th>\r\n");
      out.write("                éåº¦\r\n");
      out.write("            </th>\r\n");
      out.write("\r\n");
      out.write("            <th>\r\n");
      out.write("                æ¶é´\r\n");
      out.write("            </th>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </thead >\r\n");
      out.write("        <tbody id=\"tbody1\">\r\n");
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("        <tfoot>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td colspan=\"6\">\r\n");
      out.write("                <div class=\"pagination pagination-centered\"></div>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </tfoot>\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"body-nest\" id=\"Footable\" >\r\n");
      out.write("\r\n");
      out.write("éç¨ç»è®¡\r\n");
      out.write("    <table class=\"table-striped footable-res footable metro-blue\" data-page-size=\"6\" width=\"1200\" border=\"1\" cellspacing=\"0\">\r\n");
      out.write("        <thead>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>\r\n");
      out.write("                è®¾å¤ID\r\n");
      out.write("            </th>\r\n");
      out.write("\r\n");
      out.write("            <th>\r\n");
      out.write("                åèè¡é©¶å¬éæ°(Km)\r\n");
      out.write("            </th>\r\n");
      out.write("            <th>\r\n");
      out.write("                åèæ²¹è(å)\r\n");
      out.write("            </th>\r\n");
      out.write("            <th>\r\n");
      out.write("               æ¶é´\r\n");
      out.write("            </th>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </thead >\r\n");
      out.write("        <tbody id=\"tbody\">\r\n");
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("        <tfoot>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td colspan=\"6\">\r\n");
      out.write("                <div class=\"pagination pagination-centered\"></div>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        </tfoot>\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"container\" style=\"width:100%;height:100%;\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
