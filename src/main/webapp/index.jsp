<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.zb11_assignment.wifi.externals.WifiTotalData" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>와이파이 정보 구하기</title>

    <link href="http://localhost:8080/static/css/tableHorizontal.css" rel="stylesheet" type="text/css">
    <script defer src="http://localhost:8080/static/js/index.js" type="text/javascript"></script>
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

<form method="post" action="/wifi/calcLocation" id="locationForm">
    LAT: <input type="text" name="LAT" placeholder="0.0" id="LAT"/>
    , LNT : <input type="text" name="LNT" placeholder="0.0" id="LNT"/>
    <button type="button" onclick="getLocation()">내 위치 가져오기</button>
    <button type="button" onclick="verify()"> 근처 WIFI 정보 보기</button>
</form>

<br>
<table>

    <thead>
    <tr>
        <th>거리(Km)</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>
        <th>상세주소</th>
        <th>설치위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>WiFi 접속환경</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>
    </thead>

    <%
        List<WifiTotalData> result = (ArrayList<WifiTotalData>)request.getAttribute("result");

        if (result == null){ %>
            <tr>
                <td colspan="17"><p class="notice">위치 정보를 입력한 후에 조회해 주세요</p></td>
            </tr>
        <%}else{%>
            <%for (WifiTotalData element: result){%>
            <tr>
                <td> <%= element.getDistance() %></td>
                <td> <%= element.getWifiData().getManageNo()%></td>
                <td> <%= element.getWifiData().getManageArea()%></td>
                <td><a href="/wifi/detail?manageNo=<%=element.getWifiData().getManageNo()%>&&distance=<%=element.getDistance()%>"/>
                    <%= element.getWifiData().getWifiName()%>
                </td>
                <td> <%= element.getWifiData().getAddress()%></td>
                <td> <%= element.getWifiData().getAddressDetail()%></td>
                <td> <%= element.getWifiData().getInstalledFloor()%></td>
                <td> <%= element.getWifiData().getInstallType()%></td>
                <td> <%= element.getWifiData().getInstallOrg()%></td>
                <td> <%= element.getWifiData().getServiceSeparator()%></td>
                <td> <%= element.getWifiData().getNetworkType()%></td>
                <td> <%= element.getWifiData().getInstalledYear()%></td>
                <td> <%= element.getWifiData().getInoutDoor()%></td>
                <td> <%= element.getWifiData().getConnectEnvironment()%></td>
                <td> <%= element.getWifiData().getLat()%></td>
                <td> <%= element.getWifiData().getLnt()%></td>
                <td> <%= element.getWifiData().getWorkDateTime()%></td>
            </tr>
            <%}%>
        <%}%>
</table>

</body>
</html>