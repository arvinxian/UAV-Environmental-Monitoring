package org.apache.jsp.show_005fmap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import org.json.JSONObject;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.sql.*;
import java.util.Map;
import java.io.IOException;

public final class gps_005ftrack_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	//说明：本例子需要引入json.jar包和jdbc包，拷贝到Tomcat的common/lib下重启Tomcat或者应用的WEB-INF/lib下
	String deviceId=request.getParameter("device_id");
	String gpsTimeFrom=request.getParameter("gps_time_from");
	String gpsTimeTo=request.getParameter("gps_time_to");
	String action=request.getParameter("action");
	String sql="";
	System.out.println("获得的参数是：action="+action+",device_id="+deviceId+",gps_time_from="+gpsTimeFrom+",gps_time_to="+gpsTimeTo);
	//开始查询数据库
	List jsonList = new ArrayList();
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException classnotfoundexception) {
		classnotfoundexception.printStackTrace();
	}
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=ylx&password=ylx&useUnicode=true&characterEncoding=UTF-8");
		Statement statement = conn.createStatement();
		System.out.println("连接数据库Ok！！！");
		//构造sql语句，根据传递过来的查询条件参数，目前是deviceId和gpsTime
		sql="select * from gps_history where gpstime>'"+gpsTimeFrom+"' and recvtime<'"+gpsTimeTo+"'and deviceId like '%"+deviceId+"%' order by gpstime";
	
		System.out.println("构造出来的sql语句是："+sql);
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			Map map = new HashMap();
			map.put("device_id",rs.getString("deviceId"));
			map.put("gps_time",rs.getString("gpstime"));
			map.put("recv_time",rs.getString("recvtime"));
			map.put("longitude",rs.getString("longitude"));
			map.put("latitude",rs.getString("latitude"));
			jsonList.add(map);
		}
		statement.close();
		conn.close();
		System.out.println("数据库关闭了！！！");
	} catch (SQLException sqlexception) {
		sqlexception.printStackTrace();
	}
	//////////数据库查询完毕，得到了json数组jsonList//////////
	//下面开始构建返回的json
	JSONObject json=new JSONObject();
	json.put("aaData",jsonList);
	json.put("action",action);
	json.put("result_msg","ok");	//如果发生错误就设置成"error"等
	json.put("result_code",0);	//返回0表示正常，不等于0就表示有错误产生，错误代码
	json.put("device_id",deviceId);
	json.put("gps_time_from",gpsTimeFrom);
	json.put("gps_time_to",gpsTimeTo);
	json.put("sql",sql);
	json.put("help","请在请求url里带上device_id,gps_time_from和gps_time_to三个参数才能有查询结果<input type=button value=示范 onclick=window.location.href='gps_track_help.jsp'>");
	System.out.println("最后构造得到的json是："+json.toString());
	response.setContentType("text/html; charset=UTF-8");
	try {
		response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("返回结果给调用页面了。");

      out.write('\r');
      out.write('\n');
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
