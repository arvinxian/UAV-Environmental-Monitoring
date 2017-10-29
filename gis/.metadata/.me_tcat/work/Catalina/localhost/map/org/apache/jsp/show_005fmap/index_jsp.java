package org.apache.jsp.show_005fmap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/show_map/../frame/frame_top_header.jsp");
    _jspx_dependants.add("/show_map/../frame/frame_main_header.jsp");
    _jspx_dependants.add("/show_map/../frame/frame_swiper_container.jsp");
  }

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
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>æ äººæºç¯å¢çæµ</title>\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/bootstrap.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/font-awesome.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/animate.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/templatemo-misc.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/templatemo-style.css\">\r\n");
      out.write("        <script src=\"../js/vendor/modernizr-2.6.1-respond-1.1.0.min.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <section id=\"pageloader\">\r\n");
      out.write("            <div class=\"loader-item fa fa-spin colored-border\"></div>\r\n");
      out.write("        </section> <!-- /#pageloader -->\r\n");
      out.write("        <header class=\"site-header container-fluid\">\r\n");
      out.write("           ");
      out.write(" <div class=\"top-header\">\r\n");
      out.write("                <div class=\"logo col-md-6 col-sm-6\">\r\n");
      out.write("                    <h1><a href=\"index.jsp\"><em>æ äººæº</em>ç¯å¢çæµ</a></h1>\r\n");
      out.write("                    <span>by PYXå°ç»</span>\r\n");
      out.write("                </div> <!-- /.logo -->\r\n");
      out.write("            </div> <!-- /.top-header -->\r\n");
      out.write("\r\n");
      out.write("            ");
      out.write("<div class=\"main-header\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"main-header-left col-md-3 col-sm-6 col-xs-8\">\r\n");
      out.write("                        <a id=\"search-icon\" class=\"btn-left fa fa-search\" href=\"#search-overlay\"></a>\r\n");
      out.write("                        <div id=\"search-overlay\">\r\n");
      out.write("                            <a href=\"#search-overlay\" class=\"close-search\"><i class=\"fa fa-times-circle\"></i></a>\r\n");
      out.write("                            <div class=\"search-form-holder\">\r\n");
      out.write("                                <h2>Type keywords and hit enter</h2>\r\n");
      out.write("                                <form id=\"search-form\" action=\"#\">\r\n");
      out.write("                                    <input type=\"search\" name=\"s\" placeholder=\"\" autocomplete=\"off\" />\r\n");
      out.write("                                </form>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div><!-- #search-overlay -->\r\n");
      out.write("                        <a href=\"#\" class=\"btn-left arrow-left fa fa-angle-left\"></a>\r\n");
      out.write("                        <a href=\"#\" class=\"btn-left arrow-right fa fa-angle-right\"></a>\r\n");
      out.write("                    </div> <!-- /.main-header-left -->\r\n");
      out.write("                    <div class=\"menu-wrapper col-md-9 col-sm-6 col-xs-4\">\r\n");
      out.write("                        <a href=\"#\" class=\"toggle-menu visible-sm visible-xs\"><i class=\"fa fa-bars\"></i></a>\r\n");
      out.write("                        <ul class=\"sf-menu hidden-xs hidden-sm\">\r\n");
      out.write("                            <li class=\"active\"><a href=\"index.jsp\">é¦é¡µ</a></li>\r\n");
      out.write("                            <li><a href=\"services.jsp\">æ äººæºå°å¾æ°æ®</a></li>\r\n");
      out.write("                            <li><a href=\"#\">ç°åºè§é¢</a>\r\n");
      out.write("                                <ul>\r\n");
      out.write("                                    <li><a href=\"projects-2.html\">Two Columns</a></li>\r\n");
      out.write("                                    <li><a href=\"projects-3.html\">Three Columns</a></li>\r\n");
      out.write("                                    <li><a href=\"project-details.html\">Project Single</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li><a href=\"#\">åææ¥å</a>\r\n");
      out.write("                                <ul>\r\n");
      out.write("                                    <li><a href=\"blog.html\">Blog Masonry</a></li>\r\n");
      out.write("                                    <li><a href=\"blog-single.html\">Post Single</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li><a href=\"#\">å³äº</a>\r\n");
      out.write("                                <ul>\r\n");
      out.write("                                    <li><a href=\"our-team.html\">Our Team</a></li>\r\n");
      out.write("                                    <li><a href=\"archives.html\">Archives</a></li>\r\n");
      out.write("                                    <li><a href=\"grids.html\">Columns</a></li>\r\n");
      out.write("                                    <li><a href=\"404.html\">404 Page</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li><a href=\"contact.html\">Contact</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div> <!-- /.menu-wrapper -->\r\n");
      out.write("                </div> <!-- /.row -->\r\n");
      out.write("            </div> <!-- /.main-header -->");
      out.write("\r\n");
      out.write("              </header> <!-- /.site-header -->\r\n");
      out.write("        ");
      out.write("<div class=\"swiper-container\">\r\n");
      out.write("            <div class=\"swiper-wrapper\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"swiper-slide\" style=\"background-image: url(../images/slide1.jpg);\">\r\n");
      out.write("                    <div class=\"overlay-s\"></div>\r\n");
      out.write("                    <div class=\"slider-caption\">\r\n");
      out.write("                        <div class=\"inner-content\">\r\n");
      out.write("                            <h2>è§£ä½ æå¤çç¯å¢</h2>\r\n");
      out.write("                            <p>åç¡®å°ç¥éæ¸©åº¦ãæ¹¿åº¦åpm25å¼ï¼éè¿è¿ç¨æ äººæºçä¿¡æ¯ï¼ææ¡ç°åºçä¸æ¯«ã</p>\r\n");
      out.write("                            <a href=\"#\" class=\"main-btn white\">View Projects</a>\r\n");
      out.write("                        </div> <!-- /.inner-content -->\r\n");
      out.write("                    </div> <!-- /.slider-caption -->\r\n");
      out.write("                </div> <!-- /.swier-slide -->\r\n");
      out.write("\r\n");
      out.write("                <div class=\"swiper-slide\" style=\"background-image: url(../images/slide2.jpg);\">\r\n");
      out.write("                    <div class=\"overlay-s\"></div>\r\n");
      out.write("                    <div class=\"slider-caption\">\r\n");
      out.write("                        <div class=\"inner-content\">\r\n");
      out.write("                            <h2>Hotel and Residence Concept in Montenegro</h2>\r\n");
      out.write("                            <p>We come with new fresh and unique ideas.</p>\r\n");
      out.write("                            <a href=\"#\" class=\"main-btn white\">View Projects</a>\r\n");
      out.write("                        </div> <!-- /.inner-content -->\r\n");
      out.write("                    </div> <!-- /.slider-caption -->\r\n");
      out.write("                </div> <!-- /.swier-slide -->\r\n");
      out.write("\r\n");
      out.write("                <div class=\"swiper-slide\" style=\"background-image: url(../images/slide3.jpg);\">\r\n");
      out.write("                    <div class=\"overlay-s\"></div>\r\n");
      out.write("                    <div class=\"slider-caption\">\r\n");
      out.write("                        <div class=\"inner-content\">\r\n");
      out.write("                            <h2>Natural 3d Architecture Design</h2>\r\n");
      out.write("                            <p>Natural concrete is a material which is calm and clean.</p>\r\n");
      out.write("                            <a href=\"#\" class=\"main-btn white\">View Projects</a>\r\n");
      out.write("                            \r\n");
      out.write("                        </div> <!-- /.inner-content -->\r\n");
      out.write("                    </div> <!-- /.slider-caption -->\r\n");
      out.write("                </div> <!-- /.swier-slide -->\r\n");
      out.write("\r\n");
      out.write("            </div> <!-- /.swiper-wrapper -->\r\n");
      out.write("        </div> <!-- /.swiper-container -->\r\n");
      out.write("\r\n");
      out.write("        <script src=\"../js/vendor/jquery-1.11.0.min.js\"></script>\r\n");
      out.write("        <script>window.jQuery || document.write('<script src=\"../js/vendor/jquery-1.11.0.min.js\"><\\/script>')</script>\r\n");
      out.write("        <script src=\"../js/plugins.js\"></script>\r\n");
      out.write("        <script src=\"../js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Preloader -->\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            //<![CDATA[\r\n");
      out.write("            $(window).load(function() { // makes sure the whole site is loaded\r\n");
      out.write("                $('.loader-item').fadeOut(); // will first fade out the loading animation\r\n");
      out.write("                    $('#pageloader').delay(350).fadeOut('slow'); // will fade out the white DIV that covers the website.\r\n");
      out.write("                $('body').delay(350).css({'overflow-y':'visible'});\r\n");
      out.write("            })\r\n");
      out.write("            //]]>\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
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
