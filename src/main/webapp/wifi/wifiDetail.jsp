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
    <title>Title</title>

    <style>
        table{
            width: 100%;
            border-collapse: collapse;
            border:  1px solid #f2f2f2;
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

    <script>
        function verify(){
            var selectOption = document.getElementById("bookmark");
            var selectOptionValue = selectOption.options[selectOption.selectedIndex].value;

            if(selectOptionValue === "None"){
                alert("북마크를 선택해야 추가할 수 있습니다.");
                return;
            }

            alert("북마크 정보를 추가하였습니다.");

            document.getElementById("bookmarkItemForm").submit();
        }
    </script>
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
    double dist = Double.parseDouble((String)request.getAttribute("dist"));
%>

<!-- wifi detail controller 단에서 bookmark group데이터를 가져와야함 -->
<form method="post" action="/bookmark/items/add" id="bookmarkItemForm">
    <select name="bookmark" id="bookmark">
        <option value="None">북마크 그룹 이름 선택</option>
        <% for(BookMarkGroupDTO element: bookMarkGroup){%>
            <option value="<%=element.getID()%>"><%=element.getGroupName()%></option>
        <%}%>
    </select>

    <input type="hidden" name="wifiName" value="<%=result.getWifiName()%>"/>
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
        <td><%=result.getWifiName()%></td>
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
        <td class="legend" id="lat">X좌표</td>
        <td><%=result.getLat()%></td>
    </tr>

    <tr>
        <td class="legend" id="lnt">Y좌표</td>
        <td><%=result.getLnt()%></td>
    </tr>

    <tr>
        <td class="legend" id="workDate">작업일자</td>
        <td><%=result.getWorkDateTime()%></td>
    </tr>
</table>

</body>
</html>
