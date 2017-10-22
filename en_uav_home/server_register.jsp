<%@page contentType="text/html; charset=UTF-8" language="java"
	import="java.text.*,org.json.JSONObject,java.util.ArrayList,java.io.PrintWriter"
	import="java.util.HashMap,java.util.List,java.sql.*,java.util.Map,java.io.IOException"%>
<%

	response.setContentType("text/xml;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	response.setHeader("Cache-Control", "no-cache");
	String username=request.getParameter("user_name");
	String ps0=request.getParameter("password_0");
	String ps1=request.getParameter("password_1");
	System.out.println("获得的参数是：username="+username+",ps0="+ps0+",ps1="+ps1);
	//开始查询数据库
	List jsonList = new ArrayList();
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException classnotfoundexception) {
		classnotfoundexception.printStackTrace();
	}
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest?user=root&password=admin&useUnicode=true&characterEncoding=UTF-8");
		Statement statement = conn.createStatement();
		System.out.println("连接数据库Ok！！！");
		//构造sql语句，查找是否有相同用户名
		String sql="select * from user where username='"+username+"'";
		System.out.println("构造出来的sql语句是："+sql);
		ResultSet rs = statement.executeQuery(sql);
		System.out.println("123");
		while (rs.next()) {
			Map map = new HashMap();
			map.put("username",rs.getString("username"));
			map.put("password",rs.getString("password"));
			jsonList.add(map);
		}
		if(jsonList.size()==0)
		{
		String sql0="insert into user(username,password) values('"+username+"','"+ps0+"')";
	    statement.executeUpdate(sql0);
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
	if(jsonList.size()==0){
	
	json.put("result_msg","ok");	//该用户名没有被注册
	json.put("result_code",0);	//返回0表示正常，不等于0就表示有错误产生，错误代码
	}
	else{
	json.put("result_msg","error"); //该用户名已经被注册
	json.put("result_code",-1);	//返回0表示正常，不等于0就表示有错误产生，错误代码
	}
	
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
%>
