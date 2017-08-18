<%@page contentType="text/html; charset=UTF-8" language="java"
	import="java.text.*,org.json.JSONObject,java.util.ArrayList,java.io.PrintWriter"
	import="java.util.HashMap,java.util.List,java.sql.*,java.util.Map,java.io.IOException,java.util.Date,java.util.Calendar"%>
<%

response.setContentType("text/xml;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");
		
		String name=request.getParameter("name");
		
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
			String sql="select * from tem_hum";
			System.out.println("构造出来的sql语句是："+sql);
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("123");
			while (rs.next()) {
				Map map = new HashMap();
				map.put("tem",rs.getFloat("tem"));
				map.put("hum",rs.getFloat("hum"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dataStr = sdf.format(rs.getDate("realtime"));
                map.put("dateStr", dataStr);
				jsonList.add(map);
			}
			System.out.println("最后构造得到的json数组是："+jsonList);
			statement.close();
			conn.close();
			System.out.println("数据库关闭了！！！");
		} catch (SQLException sqlexception) {
			sqlexception.printStackTrace();
		}
		//////////数据库查询完毕，得到了json数组jsonList//////////
		//下面开始构建返回的json
		JSONObject json=new JSONObject();
		json.put("record_list",jsonList);
		
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

