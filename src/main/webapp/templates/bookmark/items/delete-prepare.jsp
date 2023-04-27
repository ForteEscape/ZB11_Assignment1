<%@ page import="com.example.zb11_assignment.bookmark.dto.BookMarkResultDTO" %><%--
  Created by IntelliJ IDEA.
  User: sehunkim
  Date: 2023-04-26
  Time: 오후 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>

  <link href="http://localhost:8080/static/css/tableVertical.css" rel="stylesheet" type="text/css">
  <script defer src="http://localhost:8080/static/js/items_delete-prepare.js" type="text/javascript"></script>
</head>
<body>

<h1><%= "북마크 삭제" %></h1>
<a href="/index.jsp">홈</a> |
<a href="/history/show">위치 히스토리 목록</a> |
<a href="/wifi/getData">Open API 와이파이 정보 가져오기</a> |
<a href="/bookmark/items/show">북마크 보기</a> |
<a href="/bookmark/group/show">북마크 그룹 관리</a>
<br>
<br>

<p>북마크를 삭제하시겠습니까?</p>

<% BookMarkResultDTO result = (BookMarkResultDTO) request.getAttribute("itemData"); %>

<table>
  <tr>
    <td class="legend">북마크 이름</td>
    <td><%=result.getBookmarkName()%></td>
  </tr>

  <tr>
    <td class="legend">와이파이명</td>
    <td><%=result.getWifiName()%></td>
  </tr>

  <tr>
    <td class="legend">등록일자</td>
    <td><%=result.getRegistrationDate()%></td>
  </tr>

  <tr>
    <td colspan="2" style="text-align: center">
      <a href="/bookmark/items/show">돌아가기</a> |
      <input type="button" value="삭제" onclick="del('<%=result.getID()%>');" >
    </td>
  </tr>
</table>

</body>
</html>
