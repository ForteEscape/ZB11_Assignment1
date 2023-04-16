<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.zb11_assignment.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

</head>
<body>
<script>
    function success(position){
        document.getElementById("LNT").value = position.coords.longitude;
        document.getElementById("LAT").value = position.coords.latitude;
    }

    function error(){
        console.log("error detected");
    }

    function getLocation(){
        navigator.geolocation.getCurrentPosition(success, error);
    }
</script >

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

    th{
        height: 50px;
        color: white;
        background-color: #04AA6D;
        border: 1px solid #f2f2f2;
    }
</style>

<%!
    public double getDist(double lat1, double lnt1, double lat2, double lnt2){
        double theta = lnt1 - lnt2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) +
                Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        return dist * 1.609344;
    }

    public double deg2rad(double deg){
        return deg * Math.PI / 180.0;
    }

    public double rad2deg(double rad){
        return rad * 180 / Math.PI;
    }
%>

<h1><%= "와이파이 정보 구하기" %></h1>
<a href="/ZB11_assignment_war_exploded/index.jsp">홈</a> |
<a href="/ZB11_assignment_war_exploded/history.jsp">위치 히스토리 목록</a> |
<a href="hello-servlet">Open API 와이파이 정보 가져오기</a>
<br>
<br>

<form method="get" action="">
    LAT: <input type="text" name="LAT" placeholder="0.0" id="LAT"/>
    , LNT : <input type="text" name="LNT" placeholder="0.0" id="LNT"/>
    <button type="button" onclick="getLocation()">내 위치 가져오기</button>
    <button type="submit"> 근처 WIFI 정보 보기</button>
</form>

<%
    String lat = request.getParameter("LAT");
    String lnt = request.getParameter("LNT");
    int uid = -1;
%>
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

    <% if(lat == null || lnt == null){ %>
    <tr>
        <td colspan="17"><p class="notice">위치 정보를 입력한 후에 조회해 주세요</p></td>
    </tr>
    <%} else {
        PriorityQueue<WifiTotalData> pq = new PriorityQueue<>();
        WifiDBManager wifiDBManager = new WifiDBManager();
        HistoryDBManager historyDBManager = new HistoryDBManager();
        historyDBManager.init();
        wifiDBManager.init();
        Connection connection = null;

        try {
            String connectUrl = "jdbc:mariadb://localhost:3306/zb11_assignment1";
            String user = "root";
            String password = "kk2924140";

            connection = DriverManager.getConnection(connectUrl, user, password);
            List<Wifi> wifiData = wifiDBManager.read(connection);

            if (uid == -1){
                uid = historyDBManager.getCurrentUid(connection);
            }

            double lntData = Double.parseDouble(lnt);
            double latData = Double.parseDouble(lat);

            System.out.println("uid : " + uid);
            java.sql.Timestamp dateTime = java.sql.Timestamp.valueOf(java.time.LocalDateTime.now());
            StringTokenizer st = new StringTokenizer(dateTime.toString());
            String date = st.nextToken() + "T" + st.nextToken();

            History history = new History(++uid, latData, lntData, date);
            System.out.println(date);
            System.out.println(latData + " " + lntData);

            historyDBManager.insert(connection, history);

            for(Wifi element: wifiData){
                double distance = getDist(latData, lntData, element.getLat(), element.getLnt());
                distance = (Math.round(distance * 10000.0)) / 10000.0;

                pq.offer(new WifiTotalData(distance, element));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (connection != null && !connection.isClosed()){
                    connection.close();
                }
                System.out.println("connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } %>

        <%for(int i = 0; i < 20; i++){%>
            <%if (pq.isEmpty()){%>
        <tr>
            <td colspan="17"><p class="notice"> 데이터가 없습니다. </p></td>
        </tr>
            <% break; }%>
            <%WifiTotalData element = pq.poll();%>
        <tr>
            <td> <%= element.getDistance() %></td>
            <td> <%= element.getWifiData().getManageNo()%></td>
            <td> <%= element.getWifiData().getManageArea()%></td>
            <td> <%= element.getWifiData().getWifiName()%></td>
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
            <td> <%= element.getWifiData().getLnt()%></td>
            <td> <%= element.getWifiData().getLat()%></td>
            <td> <%= element.getWifiData().getWorkDateTime()%></td>
        </tr>
        <%}%>
    <%}%>
</table>

</body>
</html>