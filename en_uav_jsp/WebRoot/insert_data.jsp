<%@page contentType="text/html; charset=UTF-8" language="java"
	import="java.text.*,org.json.JSONObject,org.json.JSONArray,java.util.ArrayList,java.io.PrintWriter"
	import="java.util.HashMap,java.util.List,java.sql.*,java.util.Map,java.io.IOException,java.util.Date,java.util.Calendar"%>
<%

        response.setContentType("text/xml;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");
		
		String json=request.getParameter("json");//获取到json字符串
		//将json数据解析出来
		JSONObject obj = new JSONObject(json);  
        JSONArray obj2 = obj.getJSONArray("tem_hum"); 
		
		
		//获取当天在内的五天以前的0点格式字符串（用于数据库查询
        Calendar  cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -4);        //获取当天在内的五天以前的日期时间
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");    //设定日期格式
        String fiveDaysAgoStr = sdf1.format(cal.getTime());    //将五天前的日期时间按指定格式转换成字符串
                
        //获取当前时间并将其转换成指定格式的字符串（用于数据库查询
        Date now = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowStr = sdf2.format(now);
        //System.out.println(nowStr);
		
		//开始处理数据库
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
			for (int i = 0; i < obj2.length(); i++) {
				JSONObject temp = new JSONObject(obj2.getString(i)); 
				System.out.println(temp.getString("tem"));  
				System.out.println(temp.getString("hum"));
				String sql = "insert into tem_hum(tem,hum,realtime) values('"
						+ temp.getString("tem") + "','" + temp.getString("hum") + "','" + nowStr + "')";
				statement.executeUpdate(sql);
			}
			//System.out.println("最后构造得到的json数组是："+jsonList);
			statement.close();
			conn.close();
			System.out.println("数据库关闭了！！！");
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}
		//////////数据库查询完毕，得到了json数组jsonList//////////
		//下面开始构建返回的json
		JSONObject json1=new JSONObject();
		json1.put("status","ok");
		response.setContentType("text/html; charset=UTF-8");
		try {
			response.getWriter().write(json1.toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("返回结果给调用页面了。");
%>

