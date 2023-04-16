<%@ page import="com.example.zb11_assignment.HistoryDBManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.zb11_assignment.History" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: sehunkim
  Date: 2023-04-16
  Time: 오전 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");
    int idx = Integer.parseInt(request.getParameter("idx"));

    HistoryDBManager historyDBManager = new HistoryDBManager();
    historyDBManager.init();

    Connection connection = null;

    String connectUrl = "jdbc:mariadb://localhost:3306/zb11_assignment1";
    String user = "root";
    String password = "kk2924140";
    int res = 0;

    try{
        connection = DriverManager.getConnection(connectUrl, user, password);
        res = historyDBManager.delete(connection, idx);
    } catch (SQLException e){
        e.printStackTrace();
    } finally {
        try{
            if (connection != null && ! connection.isClosed()){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    if (res != 0){
        response.sendRedirect("/ZB11_assignment_war_exploded/history.jsp");
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
