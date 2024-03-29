<%@ page import="java.util.*" %>
<%@ page import="com.example.zb11_assignment.history.dto.HistoryDTO" %>
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
    <title>와이파이 정보 구하기</title>

    <link href="http://localhost:8080/static/css/tableHorizontal.css" rel="stylesheet" type="text/css">
    <script defer src="http://localhost:8080/static/js/history.js" type="text/javascript"></script>
</head>
<body>
    <h1>위치 히스토리 목록</h1>
    <a href="/index.jsp">홈</a> |
    <a href="/history/show">위치 히스토리 목록</a> |
    <a href="/wifi/getData">Open API 와이파이 정보 가져오기</a> |
    <a href="/bookmark/items/show">북마크 보기</a> |
    <a href="/bookmark/group/show">북마크 그룹 관리</a>
    <br>
    <br>

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
            List<HistoryDTO> result = (ArrayList<HistoryDTO>)request.getAttribute("result");
            if(result != null){
                for(HistoryDTO element: result){%>
                    <tr>
                        <td> <%= element.getUid() %></td>
                        <td> <%= element.getLnt() %></td>
                        <td> <%= element.getLat() %></td>
                        <td> <%= element.getDate() %></td>
                        <td class="notice"><input type="button" value="삭제" onclick="del('<%=element.getUid()%>');" ></td>
                    </tr>
                <%}
            }%>
    </table>
</body>
</html>
