<%@page contentType="text/html; charset=UTF-8" language="java"
	import="java.text.*,org.json.JSONObject,org.json.JSONArray,java.util.ArrayList,java.io.PrintWriter"
	import="java.util.HashMap,java.util.List,java.sql.*,java.util.Map,java.io.IOException,java.util.Date,java.util.Calendar"%>
<%

        response.setContentType("text/xml;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");

		String uavpm=request.getParameter("uav_pm");//获取到json字符串
		String uavlon=request.getParameter("uav_lon");
		String uavlat=request.getParameter("uav_lat");
		// System.out.println(uavpm,uavlon,uavlat);
		String deviceid="1";
		//将json数据解析出来
		// JSONObject obj = new JSONObject(json);
        // JSONArray obj2 = obj.getJSONArray("tem_hum");


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
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enuav?user=root&password=admin&useUnicode=true&characterEncoding=UTF-8");
			Statement statement = conn.createStatement();
			System.out.println("连接数据库Ok！！！");
		
			String sql = "insert into data_list(pm25,longitude,latitude,device_id,time) values('"+ uavpm + "','" + uavlon + "','" + uavlat + "','" + deviceid +"','" + nowStr +"')";
			statement.executeUpdate(sql);
			System.out.println("最后构造得到的sql语句是："+sql);
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
