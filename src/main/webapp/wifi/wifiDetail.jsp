<%@ page import="com.example.zb11_assignment.wifi.dto.WifiDTO" %><%--
  Created by IntelliJ IDEA.
  User: sehunkim
  Date: 2023-04-24
  Time: 오후 8:05
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
            height: 50px;
        }

        .legend{
            color: white;
            background-color: #04AA6D;
            text-align: center;
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
    </style>
</head>
<body>
<h1><%= "와이파이 정보 구하기" %></h1>
<a href="/index.jsp">홈</a> |
<a href="/history/show">위치 히스토리 목록</a> |
<a href="/wifi/getData">Open API 와이파이 정보 가져오기</a> |
<a href="/bookmark/show">북마크 보기</a> |
<a href="/bookmark/group/show">북마크 그룹 관리</a>
<br>
<br>

<%
    WifiDTO result = (WifiDTO) request.getAttribute("result");
    double dist = Double.parseDouble((String)request.getAttribute("dist"));
%>

<table>
    <tr>
        <td class="legend">거리</td>
        <td><%=dist%></td>
    </tr>

    <tr>
        <td class="legend">관리번호</td>
        <td><%=result.getManageNo()%></td>
    </tr>

    <tr>
        <td class="legend">자치구</td>
        <td><%=result.getManageArea()%></td>
    </tr>

    <tr>
        <td class="legend">와이파이명</td>
        <td><%=result.getWifiName()%></td>
    </tr>

    <tr>
        <td class="legend">도로명주소</td>
        <td><%=result.getAddress()%></td>
    </tr>

    <tr>
        <td class="legend">상세주소</td>
        <td><%=result.getAddressDetail()%></td>
    </tr>

    <tr>
        <td class="legend">설치위치(층)</td>
        <td><%=result.getInstalledFloor()%></td>
    </tr>

    <tr>
        <td class="legend">설치유형</td>
        <td><%=result.getInstallType()%></td>
    </tr>

    <tr>
        <td class="legend">설치기관</td>
        <td><%=result.getInstallOrg()%></td>
    </tr>

    <tr>
        <td class="legend">서비스구분</td>
        <td><%=result.getServiceSeparator()%></td>
    </tr>

    <tr>
        <td class="legend">망종류</td>
        <td><%=result.getNetworkType()%></td>
    </tr>

    <tr>
        <td class="legend">설치년도</td>
        <td><%=result.getInstalledYear()%></td>
    </tr>

    <tr>
        <td class="legend">실내외구분</td>
        <td><%=result.getInoutDoor()%></td>
    </tr>

    <tr>
        <td class="legend">WIFI접속환경</td>
        <td><%=result.getConnectEnvironment()%></td>
    </tr>

    <tr>
        <td class="legend">X좌표</td>
        <td><%=result.getLat()%></td>
    </tr>

    <tr>
        <td class="legend">Y좌표</td>
        <td><%=result.getLnt()%></td>
    </tr>

    <tr>
        <td class="legend">작업일자</td>
        <td><%=result.getWorkDateTime()%></td>
    </tr>
</table>

</body>
</html>
