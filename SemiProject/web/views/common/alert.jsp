<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>

	alert("비밀번호가 수정되었습니다. 다시 로그인 해주세요 !");
	document.location.href="<%=request.getContextPath() %>/sessionclear.me";
</script>
	</body>
</html>