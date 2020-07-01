<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkingThrough</title>
<link rel="icon" href="images/semi.ico">
<style>
	#contents{
     	text-align: center;
 	}
	 .confirm{
	     width:700px;
	     display: block;
	     margin: 0 auto;
	 }
	
	 .goBtn{
		width: 150px;
	    border: none; 
	    background:lightgray;
	    height: 50px;
	    border-radius:8px; 
	    font-size: 18px; 
	 }
</style>
</head>
<body>
	<%@ include file = "../common/menubar.jsp" %>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<div id="contents">
	<div class="confirm">
		<br><br>
		<div style="font-size:28px; color:black; font-weight:700;"><p><%=msg %></p>
		<br>
		<button class = "goBtn" onclick="location.href='main.jsp'">홈으로</button>
		<button class = "goBtn" onclick="location.href='views/mypage/PIU/personalIU.jsp'">마이페이지</button>
	</div>

</div>
<br><br><br><br><br><br><br><br><br>
	<div id = "footer" style="margin-bottom: 0;">
      <%@include file="/views/common/bottom.jsp"%>
   </div>
</body>
</html>