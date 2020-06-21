<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <% String msg = (String)request.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<script>
	<%= msg %>
	alert(msg+ "이수한빢빢이");
	document.location.href ="<%=request.getContextPath()%>/main.jsp"
	</script>
</body>
</html>