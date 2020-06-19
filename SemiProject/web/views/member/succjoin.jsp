<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("userId");
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
 .log_btn{
	 width: 225px;
	    font-size: 25px; 
	    border: none; 
	    background-color:rgb(202, 202, 202);
		
	    height: 52px;
	    border-radius:5px; 
	    outline: 0; 
 }
</style>
</head>
<body>
<div id="warp">
	<img id="logoimg" src="<%=request.getContextPath()%>/images/logo2.png" onclick="location.href='main.jsp'">
		<br>
	
	<div class="center_div">
		<p style=" font-weight: 1000; font-size: 25px; color:rgb(127,127,127); margin:10px ">회원가입 성공
		<div class="center_div" style="border-top:2px solid rgb(202,202,202); padding: 10px; width:470px;">	
		
		</div>
		<div class="center_div" style="width: 460px; height: 180px; border:1px solid rgb(51,51,51); border-radius:16px; ">
			<br><br>
			<div style="font-size:33px; color:black; font-weight:1000;"><%=userId %> 님</div><p> 회원가입 성공하셨습니다.</p>
		</div>
		
		<br><br>
		<button class="log_btn" onclick="location.href='main.jsp'">홈으로</button>
		<button class="log_btn" onclick="location.href='views/member/login.jsp'">로그인</button>
		
		
	</div>
	<br><br><br><br><br><br>
</div>



</body>
</html>