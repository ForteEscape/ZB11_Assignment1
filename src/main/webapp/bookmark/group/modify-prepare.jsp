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
                alert("잘못된 입력입니다. 다시 입력해주세요");
                return;
            }

            alert("북마크 그룹 정보를 수정했습니다.");
            document.getElementById("modifyForm").submit();
        }
    </script>
</head>
<body>

<h1><%= "북마크 그룹 수정" %></h1>
<a href="/index.jsp">홈</a> |
<a href="/history/show">위치 히스토리 목록</a> |
<a href="/wifi/getData">Open API 와이파이 정보 가져오기</a> |
<a href="/bookmark/items/show">북마크 보기</a> |
<a href="/bookmark/group/show">북마크 그룹 관리</a>
<br>
<br>

<% BookMarkGroupDTO result = (BookMarkGroupDTO) request.getAttribute("bookmarkInfo"); %>

<form action="/bookmark/group/modify" method="post" id="modifyForm">
    <table>
        <tr>
            <td class="legend">북마크 이름</td>
            <td><input type="text" name="bookmarkName" id="bookmarkName" value="<%=result.getGroupName()%>"/></td>
        </tr>

        <tr>
            <td class="legend">순서</td>
            <td><input type="text" name="seqNo" id="seqNo" value="<%=result.getSeqNo()%>"/></td>
        </tr>

        <tr>
            <td colspan="2" style="text-align: center">
                <a href="/bookmark/group/show">돌아가기</a> |
                <input type="hidden" name="id" value="<%=result.getID()%>"/>
                <button type="button" onclick="verify()">수정</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
