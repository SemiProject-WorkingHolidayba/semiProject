<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
 #warp{
     text-align: center;
     margin-top: 7em;
 }

 #logoimg{
     width: 542px;
     height: 95px;
 }
 input{
 	float:left;
     width: 447px;
     height: 52px;
     border-radius:5px; 
     /* 클릭시 검정태두리가 나타나는데 그거 없애줌*/
     outline: 0;  
     margin-left: 168px
 }
 .log{   
     border:1px solid rgb(202, 202, 202) ;                
     padding-left: 15px;
     font-size: 16px;
 }
 .center_div{
     /*
         div 안에 div를 가운데 정렬 할 수 있는 방법
         넓이는 사용자가 원하는 만큼 설정
         display를 block으러 설정
         margin을 0 auto로 설정
     */
     width:800px;
     display: block;
     margin: 0 auto;
 }
 .menup{
     float: left;
     width: 33%;
     cursor:pointer;
 }
 #ero_msg{
     float: left; 
     padding-left: 5px; 
     font-size: 13px; 
     
     color: red;
     visibility:unset;
     /* visibility는 hidden은 공간을 차지하면서 안보이고
        unset은 보이게함
      */
 }
 #log_btn{
	 width: 447px;
     height: 55px;
     font-weight: 1000; 
     font-size: 25px; 
     border: none; 
     background-color:rgb(202, 202, 202);
 }
</style>
</head>
<body>
<div id="warp">
	<img id="logoimg" src="<%=request.getContextPath()%>/images/logo2.png" onclick="location.href='main.jsp'">
		<br>
	<form action="idcomplete.jsp" method="post" onsubmit="return keyCheck();">
	<div class="center_div">
		<p style=" font-weight: 1000; font-size: 25px; color:rgb(127,127,127); margin:10px ">아이디 찾기
		<div class="center_div" style="border-top:2px solid rgb(202,202,202); padding: 10px; width:470px;">	</div>
		
		<input type="text" name="userName" id="userName" class="log" placeholder="이름을 입력해 주세요">
		<br><br><br>
		<input type="email" name="email" id="email" class="log" placeholder="이메일을 입력해 주세요">	
		<br><br><br>
		
		<input style="width:340px; margin-right:10px;  border-radius:5px;" type="text" name="CertificationNum"  class="log" id="CertificationNum" placeholder="인증번호를 입력해주세요" readonly>
		<button style="float:left; border-radius:5px;  background-color:rgb(202, 202, 202); border: none;  height: 52px;" type="button"  onclick="Btn();">인증번호 받기</button>
		<br><br><br><br>
		
		<input id="log_btn" type="submit" value="입력완료" >
		</form>
	
		<br><br><br><br>
		<div class="center_div" style="border-top:1px solid rgb(202,202,202); padding: 10px; width:470px;">			
				<div class="menup" onclick="location.href='findid.jsp'">아이디 찾기</div>
				<div class="menup" style="border-left: 1.5px solid rgb(202, 202, 202); border-right: 1.5px solid rgb(202, 202, 202);" onclick="location.href='findpw.jsp'" >비밀번호 찾기</div>
				<div class="menup" onclick="location.href='join.html'">회원가입</div>
		</div>
	</div>
	<br><br><br><br><br><br>
</div>
<script>
	//이름과 이메일이 데이터베이스에 있는 정보와 맞는지 확인하고
	//맞다면 이메일 인증번호를 보냄
	var randomKey;
	function Btn(){
		var userName = $("#userName");
		var email = $("#email");
		
		if(userName.val().trim().length == 0){
			alert("이름을 입력해 주세요");
			userName.focus();
		} else if(email.val().trim().length == 0){
			alert("이메일을 입력해 주세요");
			email.focus();
		}else{
			$.ajax({
				url:"<%=request.getContextPath()%>/findid.me",
				type:"post",
				data:{userName:userName.val(), email:email.val()},
				success:function(data){
					if(data=="No"){
						alert("입력하신 정보와 일치하는 정보가 없습니다.\n다시한번 확인한 후 인증번호 받기 버튼을 눌러주세요");
						$("#CertificationNum").attr("readonly",true);
					}else{	
						randomKey = data;
						alert(data);
						$("#CertificationNum").attr("readonly",false);
					}
				},
				
				error:function(request,status,error){
	                   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	            }
				
			});
		}
		
	}

	function keyCheck(){
		var inputKey= $("#CertificationNum");
		if(inputKey.val() == randomKey){
			alert("인증 성공")
		}else{
			alert("인증번호가 다릅니다")
		}
	}
</script>


</body>
</html>