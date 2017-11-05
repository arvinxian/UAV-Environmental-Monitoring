<%@page contentType="text/html; charset=UTF-8" language="java"
	import="java.text.*,org.json.JSONObject,java.util.ArrayList,java.io.PrintWriter"
	import="java.util.HashMap,java.util.List,java.sql.*,java.util.Map,java.io.IOException"%>
<%

	response.setContentType("text/xml;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	response.setHeader("Cache-Control", "no-cache");
	String username=request.getParameter("user_name");
	request.getSession().setAttribute("users",username);
	String ps=request.getParameter("password");
	String realpassword="";
	System.out.println("���õĲ����ǣ�username="+username+",ps="+ps);
	//��ʼ��ѯ���ݿ�
	List jsonList = new ArrayList();
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException classnotfoundexception) {
		classnotfoundexception.printStackTrace();
	}
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enuav?user=root&password=admin&useUnicode=true&characterEncoding=UTF-8");
		Statement statement = conn.createStatement();
		System.out.println("�������ݿ�Ok������");
		//����sql���䣬�����Ƿ�����ͬ�û���
		String sql="select * from user_list where username='"+username+"'";
		System.out.println("����������sql�����ǣ�"+sql);
		ResultSet rs = statement.executeQuery(sql);
		System.out.println("123");
		while (rs.next()) {
			Map map = new HashMap();
			map.put("username",rs.getString("username"));
			map.put("password",rs.getString("password"));
      realpassword=rs.getString("password");
			jsonList.add(map);
		}
		statement.close();
		conn.close();
		System.out.println("���ݿ��ر��ˣ�����");
	} catch (SQLException sqlexception) {
		sqlexception.printStackTrace();
	}
	//////////���ݿ���ѯ���ϣ��õ���json����jsonList//////////
	//���濪ʼ�������ص�json
	JSONObject json=new JSONObject();
	if(jsonList.size()==0){
	json.put("result_msg","error1");	//���û���û�б�ע��
	json.put("result_code",-1);	//����0��ʾ������������0�ͱ�ʾ�д�����������������
	}
	else{
		json.put("result_msg","ok");
		json.put("result_code",0);
		json.put("real_password",realpassword);
	}


	System.out.println("���������õ���json�ǣ�"+json.toString());
	response.setContentType("text/html; charset=UTF-8");
	try {
		response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("���ؽ���������ҳ���ˡ�");
%>
