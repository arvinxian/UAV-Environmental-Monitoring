<%@page contentType="text/html; charset=UTF-8"
    import="java.sql.*,java.io.*"%>
<html>
        <%
            String id = request.getParameter("id");
            request.setCharacterEncoding("UTF-8");
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException classnotfoundexception) {
                classnotfoundexception.printStackTrace();
            }
            try {
                Connection conn = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/mytest?user=root&password=admin&useUnicode=true&characterEncoding=UTF-8");
                Statement statement = conn.createStatement();
                out.println("Connect Database Ok！！！<br>");
                String sql = "delete from tem_hum where id="+id;
                statement.executeUpdate(sql);
                out.println(sql);
                statement.close();
                conn.close();
                out.println("Database Closed！！！<br>");
        %>
删除成功！请返回。
<input type="button" name="listBtn" value="返回数据列表" onclick="window.location='show_data.jsp'">
        <%
            } catch (SQLException sqlexception) {
                sqlexception.printStackTrace();
        %>
出现错误，请看log提示！请返回。
<input type="button" name="listBtn" value="返回数据列表" onclick="window.location='show_data.jsp'">
        <%
            }
        %>
</html>
