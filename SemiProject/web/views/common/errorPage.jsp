<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인 실패지롱 ~-->
	<div align="center">
	<h1><%= msg%></h1>
	<a href="<%=request.getContextPath() %>/main.jsp">홈으로</a>
	</div>
</body>
</html>