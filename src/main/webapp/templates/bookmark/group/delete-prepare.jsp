<%@ page import="com.example.zb11_assignment.bookmark.dto.BookMarkGroupDTO" %><%--
  Created by IntelliJ IDEA.
  User: sehunkim
  Date: 2023-04-26
  Time: 오전 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link href="http://localhost:8080/static/css/tableVertical.css" rel="stylesheet" type="text/css">
    <script defer src="http://localhost:8080/static/js/group_delete-prepare.js" type="text/javascript"></script>
</head>
<body>

<% BookMarkGroupDTO result = (BookMarkGroupDTO) request.getAttribute("bookmarkInfo"); %>

<h1><%= "북마크 그룹 삭제" %></h1>
<a href="/index.jsp">홈</a> |
<a href="/history/show">위치 히스토리 목록</a> |
<a href="/wifi/getData">Open API 와이파이 정보 가져오기</a> |
<a href="/bookmark/items/show">북마크 보기</a> |
<a href="/bookmark/group/show">북마크 그룹 관리</a>
<br>
<br>

<p>북마크 그룹 이름을 삭제하시겠습니까?</p>

<table>
    <tr>
        <td class="legend">북마크 이름</td>
        <td><input type="text" value="<%=result.getGroupName()%>"/></td>
    </tr>

    <tr>
        <td class="legend">순서</td>
        <td><input type="text" value="<%=result.getSeqNo()%>"/></td>
    </tr>

    <tr>
        <td colspan="2" style="text-align: center">
            <a href="/bookmark/group/show">돌아가기</a> |
            <input type="button" value="삭제" onclick="del('<%=request.getAttribute("id")%>');" >
        </td>
    </tr>
</table>

</body>
</html>
