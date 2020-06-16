<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<form action="#" method="post" >
<label>이름:</label><input type="text" name="userName" id="userName"><br>
<lable>이메일:</lable><input type="email" name="email" id="email">
<button type="button" onclick="Btn();">인증번호 받기</button><br>
<input type="text" name="CertificationNum" id="CertificationNum" placeholder="인증번호를 입력해주세요" readonly>

</form>

<script>
	
	function Btn(){
		var userName = $("#userName");
		var email = $("#email");
		$.ajax({
			url:"<%=request.getContextPath()%>/findid.me",
			type:"post",
			data:{userName:userName.val(), email:email.val()},
			success:function(data){
				if(data=="Yes"){
					alert("이메일을 확인하여 인증번호를 입력해 주세요");
					$("#CertificationNum").attr("readonly",false);
				}else{
					alert("정보없음");
					$("#CertificationNum").attr("readonly",true);
				}
			},
			
			error:function(request,status,error){
                   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
			
		});
		
	}

</script>


</body>
</html>