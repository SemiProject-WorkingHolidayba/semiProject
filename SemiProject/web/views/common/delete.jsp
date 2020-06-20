<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkingThrough</title>
</head>
<body>
<script>

	alert("신청이 취소되었습니다!");
	document.location.href="<%=request.getContextPath() %>/list.aj";
</script>
</body>
</html>