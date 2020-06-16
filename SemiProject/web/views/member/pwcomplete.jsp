<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
 	Member FindUser = (Member)session.getAttribute("FindUser");
 	String UserId = FindUser.getUserId();
 	String UserPw = FindUser.getUserName();
 %>
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
	
	#log_btn{
	    font-weight: 1000; 
	    font-size: 25px; 
	    border: none; 
	    background-color:rgb(202, 202, 202);
		width: 447px;
	    height: 52px;
	    border-radius:5px; 
	    outline: 0; 
	}
	p{
		font-size: 15px;
    	font-weight: 400;
		color:rgb(27,27,27);
		margin:5px;
	}
</style>
</head>
<body>

<div id="warp">
	<input type="hidden" name="nowView" vlaue="findId">
	<img id="logoimg" src="<%=request.getContextPath()%>/images/logo2.png" onclick="location.href='main.jsp'">
		<br>
	
	<div class="center_div">
		<p style=" font-weight: 1000; font-size: 25px; color:rgb(127,127,127); margin:10px ">비밀번호 찾기
		<div class="center_div" style="border-top:2px solid rgb(202,202,202); padding: 10px; width:470px;">	</div>
		
		<div class="center_div" style="width: 460px; height: 180px; border:1px solid rgb(51,51,51); border-radius:16px; ">
			<br><br>
			<p><%=UserId %>님의 비밀번호는<br>			
			<div style="font-size:33px; color:black; font-weight:1000;"><%=UserPw %></div><p> 입니다.</p>
		</div>
		<br><br>
		<button id="log_btn"  onclick="FindidFinish();">확인 완료</button>
       
	</div>
	<br><br><br><br>
	<div class="center_div" style="border-top:1px solid rgb(202,202,202); padding: 10px; width:470px;">			
			<div class="menup" onclick="location.href='findid.jsp'">아이디 찾기</div>
			<div class="menup" style="border-left: 1.5px solid rgb(202, 202, 202); border-right: 1.5px solid rgb(202, 202, 202); ">비밀번호 찾기</div>
			<div class="menup" onclick="location.href='join.html'">회원가입</div>
	</div>
	<br><br>
	<script>
		function FindidFinish(){
			location.href="<%=request.getContextPath()%>/sessionclear.me?nowView=N2";
		}
	</script>
</body>
</html>