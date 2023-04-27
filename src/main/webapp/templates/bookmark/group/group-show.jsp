<%@ page import="java.util.List" %>
<%@ page import="com.example.zb11_assignment.bookmark.dto.BookMarkGroupDTO" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: sehunkim
  Date: 2023-04-26
  Time: 오전 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>

  <link href="http://localhost:8080/static/css/tableHorizontal.css" rel="stylesheet" type="text/css">
  <script defer src="http://localhost:8080/static/js/group-show.js" type="text/javascript"></script>
</head>
<body>

<%
  List<BookMarkGroupDTO> result = (ArrayList<BookMarkGroupDTO>)request.getAttribute("bookMarkGroup");
%>

<h1>북마크 그룹 목록</h1>
<a href="/index.jsp">홈</a> |
<a href="/history/show">위치 히스토리 목록</a> |
<a href="/wifi/getData">Open API 와이파이 정보 가져오기</a> |
<a href="/bookmark/items/show">북마크 보기</a> |
<a href="/bookmark/group/show">북마크 그룹 관리</a>

<br>
<br>
<button type="button" onclick="movePage()">북마크 그룹 이름 추가</button>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>북마크 이름</th>
    <th>순서</th>
    <th>등록일자</th>
    <th>수정일자</th>
    <th>비고</th>
  </tr>
  </thead>

  <% if(result == null || result.isEmpty()){ %>
    <tr>
      <td colspan="6"><p class="notice">데이터가 없습니다.</p></td>
    </tr>
  <%} else {
      for(BookMarkGroupDTO element: result){ %>
        <tr>
          <td><%=element.getID()%></td>
          <td><%=element.getGroupName()%></td>
          <td><%=element.getSeqNo()%></td>
          <td><%=element.getRegistrationDate()%></td>
          <td><%=element.getModifyDate()%></td>
          <td>
            <a href="/bookmark/group/modifyPrepare?id=<%=element.getID()%>">수정</a>
            <a href="/bookmark/group/deletePrepare?id=<%=element.getID()%>">삭제</a>
          </td>
        </tr>
    <%}%>
  <%}%>

</table>

</body>
</html>
