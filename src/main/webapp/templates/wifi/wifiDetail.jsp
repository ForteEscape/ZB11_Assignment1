<%@ page import="com.example.zb11_assignment.wifi.dto.WifiDTO" %>
<%@ page import="com.example.zb11_assignment.bookmark.dto.BookMarkGroupDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: sehunkim
  Date: 2023-04-24
  Time: 오후 8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <link href="http://localhost:8080/static/css/tableVertical.css" rel="stylesheet" type="text/css">
    <script defer src="http://localhost:8080/static/js/wifiDetail.js" type="text/javascript"></script>
</head>
<body>
<h1><%= "와이파이 정보 구하기" %></h1>
<a href="/index.jsp">홈</a> |
<a href="/history/show">위치 히스토리 목록</a> |
<a href="/wifi/getData">Open API 와이파이 정보 가져오기</a> |
<a href="/bookmark/items/show">북마크 보기</a> |
<a href="/bookmark/group/show">북마크 그룹 관리</a>
<br>
<br>

<%
    WifiDTO result = (WifiDTO) request.getAttribute("result");
    List<BookMarkGroupDTO> bookMarkGroup = (ArrayList<BookMarkGroupDTO>) request.getAttribute("bookMarkGroup");
    String dist = (String)request.getAttribute("dist");
%>

<form method="post" action="/bookmark/items/add" id="bookmarkItemForm">
    <select name="bookmark" id="bookmark">
        <option class="option" value="None">북마크 그룹 이름 선택</option>
        <% for(BookMarkGroupDTO element: bookMarkGroup){%>
            <option class="option" value="<%=element.getID()%>"><%=element.getGroupName()%></option>
        <%}%>
    </select>

    <input type="hidden" name="wifiName" value="<%=result.getWifiName()%>"/>
    <input type="hidden" name="mngNo" value="<%=result.getManageNo()%>"/>
    <button type="button" onclick="verify()">북마크 추가하기</button>
</form>

<table>
    <tr>
        <td class="legend" id="dist">거리(Km)</td>
        <td><%=dist%></td>
    </tr>

    <tr>
        <td class="legend" id="magNum">관리번호</td>
        <td><%=result.getManageNo()%></td>
    </tr>

    <tr>
        <td class="legend" id="magArea">자치구</td>
        <td><%=result.getManageArea()%></td>
    </tr>

    <tr>
        <td class="legend" id="wifiName">와이파이명</td>
        <td><a href="#"><%=result.getWifiName()%></a></td>
    </tr>

    <tr>
        <td class="legend" id="address">도로명주소</td>
        <td><%=result.getAddress()%></td>
    </tr>

    <tr>
        <td class="legend" id="address2">상세주소</td>
        <td><%=result.getAddressDetail()%></td>
    </tr>

    <tr>
        <td class="legend" id="installFloor">설치위치(층)</td>
        <td><%=result.getInstalledFloor()%></td>
    </tr>

    <tr>
        <td class="legend" id="installType">설치유형</td>
        <td><%=result.getInstallType()%></td>
    </tr>

    <tr>
        <td class="legend" id="installOrg">설치기관</td>
        <td><%=result.getInstallOrg()%></td>
    </tr>

    <tr>
        <td class="legend" id="serviceType">서비스구분</td>
        <td><%=result.getServiceSeparator()%></td>
    </tr>

    <tr>
        <td class="legend" id="networkType">망종류</td>
        <td><%=result.getNetworkType()%></td>
    </tr>

    <tr>
        <td class="legend" id="installYear">설치년도</td>
        <td><%=result.getInstalledYear()%></td>
    </tr>

    <tr>
        <td class="legend" id="inoutDoor">실내외구분</td>
        <td><%=result.getInoutDoor()%></td>
    </tr>

    <tr>
        <td class="legend" id="connectEnv">WIFI접속환경</td>
        <td><%=result.getConnectEnvironment()%></td>
    </tr>

    <tr>
        <td class="legend" id="lnt">X좌표</td>
        <td><%=result.getLat()%></td>
    </tr>

    <tr>
        <td class="legend" id="lat">Y좌표</td>
        <td><%=result.getLnt()%></td>
    </tr>

    <tr>
        <td class="legend" id="workDate">작업일자</td>
        <td><%=result.getWorkDateTime()%></td>
    </tr>
</table>

</body>
</html>
