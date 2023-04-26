<%@ page import="com.example.zb11_assignment.bookmark.dto.BookMarkDTO" %>
<%@ page import="com.example.zb11_assignment.bookmark.dto.BookMarkResultDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: sehunkim
  Date: 2023-04-26
  Time: 오전 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        table{
            width: 100%;
            border-collapse: collapse;
            border:  1px solid #f2f2f2;
        }

        .notice{
            text-align: center;
        }

        td{
            border: 1px solid #f2f2f2;
        }

        tr:nth-child(even){
            background-color: #f2f2f2;
        }

        tr:hover{
            background-color: lightslategray;
        }

        th{
            height: 50px;
            color: white;
            background-color: #04AA6D;
            border: 1px solid #f2f2f2;
        }
    </style>
</head>

<body>

<h1>북마크 목록</h1>
<a href="/index.jsp">홈</a> |
<a href="/history/show">위치 히스토리 목록</a> |
<a href="/wifi/getData">Open API 와이파이 정보 가져오기</a> |
<a href="/bookmark/items/show">북마크 보기</a> |
<a href="/bookmark/group/show">북마크 그룹 관리</a>
<br>
<br>

<% List<BookMarkResultDTO> result = (ArrayList<BookMarkResultDTO>) request.getAttribute("itemData"); %>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>북마크 이름</th>
        <th>와이파이명</th>
        <th>등록일자</th>
        <th>비고</th>
    </tr>
    </thead>

    <% if(result == null || result.isEmpty()){ %>
    <tr>
        <td colspan="6"><p class="notice">데이터가 없습니다.</p></td>
    </tr>
    <%} else {
        for(BookMarkResultDTO element: result){ %>
    <tr>
        <td><%=element.getID()%></td>
        <td><%=element.getBookmarkName()%></td>
        <td><%=element.getWifiName()%></td>
        <td><%=element.getRegistrationDate()%></td>
        <td>
            <a href="/bookmark/items/deletePrepare?id=<%=element.getID()%>">삭제</a>
        </td>
    </tr>
    <%}%>
    <%}%>

</table>

</body>
</html>
