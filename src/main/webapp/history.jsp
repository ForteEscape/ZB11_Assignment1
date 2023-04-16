<%@ page import="com.example.zb11_assignment.HistoryDBManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.zb11_assignment.History" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: sehunkim
  Date: 2023-04-16
  Time: 오전 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script>
        function del(idx){
            location.href="historyDelete.jsp?idx=" + idx;
        }
    </script>

    <style>
        table{
            width: 100%;
            border-collapse: collapse;
            border:  1px solid #f2f2f2;
        }

        td{
            border: 1px solid #f2f2f2;
        }

        tr:nth-child(even){
            background-color: #f2f2f2;
        }

        th{
            height: 50px;
            color: white;
            background-color: #04AA6D;
            border: 1px solid #f2f2f2;
        }

        .btn{
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>위치 히스토리 목록</h1>
    <a href="/ZB11_assignment_war_exploded/index.jsp">홈</a> |
    <a href="/ZB11_assignment_war_exploded/history.jsp">위치 히스토리 목록</a> |
    <a href="hello-servlet">Open API 와이파이 정보 가져오기</a>
    <br>
    <br>

    <%
        HistoryDBManager historyDBManager = new HistoryDBManager();
        historyDBManager.init();

        Connection connection = null;
        List<History> historyList = null;

        String connectUrl = "jdbc:mariadb://localhost:3306/zb11_assignment1";
        String user = "root";
        String password = "kk2924140";

        try{
            connection = DriverManager.getConnection(connectUrl, user, password);
            historyList = historyDBManager.read(connection);
        } catch (SQLException e){
            e.printStackTrace();
        }
    %>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>X좌표</th>
            <th>Y좌표</th>
            <th>조회일자</th>
            <th>비고</th>
        </tr>
        </thead>

        <%
            if(historyList != null){
                for(History element: historyList){%>
                    <tr>
                        <td> <%= element.getUid() %></td>
                        <td> <%= element.getLat() %></td>
                        <td> <%= element.getLnt() %></td>
                        <td> <%= element.getDate() %></td>
                        <td class="btn"><input type="button" value="삭제" onclick="del('<%=element.getUid()%>');" ></td>
                    </tr>
                <%}
            }%>
    </table>
</body>
</html>
