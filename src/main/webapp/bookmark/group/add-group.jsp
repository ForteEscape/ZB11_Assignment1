<%--
  Created by IntelliJ IDEA.
  User: sehunkim
  Date: 2023-04-26
  Time: 오후 1:27
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
      var bookmarkName = document.getElementById("bookmarkName").value;
      var seqNo = document.getElementById("seqNo").value;

      if (bookmarkName === "" || bookmarkName === null || seqNo === "" || seqNo === null){
        alert("잘못된 형식입니다. 다시 입력해주세요");
        return;
      }

      document.getElementById("groupDeleteForm").submit();
    }
  </script>
</head>
<body>

<h1><%= "북마크 그룹 추가" %></h1>
<a href="/index.jsp">홈</a> |
<a href="/history/show">위치 히스토리 목록</a> |
<a href="/wifi/getData">Open API 와이파이 정보 가져오기</a> |
<a href="/bookmark/items/show">북마크 보기</a> |
<a href="/bookmark/group/show">북마크 그룹 관리</a>
<br>
<br>

<form method="post" action="/bookmark/group/add" id="groupDeleteForm">
  <table>
    <tr>
      <td class="legend">북마크 이름</td>
      <td><input type="text" id="bookmarkName" name="bookmarkName"/></td>
    </tr>

    <tr>
      <td class="legend">순서</td>
      <td><input type="text" id="seqNo" name="seqNo"/></td>
    </tr>

    <tr style="text-align: center">
      <td colspan="2" style="text-align: center"><button type="button" onclick="verify()">추가</button></td>
    </tr>
  </table>
</form>

</body>
</html>
