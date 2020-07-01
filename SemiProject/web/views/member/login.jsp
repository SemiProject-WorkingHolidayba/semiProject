<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = "";
	msg=(String)request.getAttribute("erorrMsg");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkingThrough</title>
<link rel="icon" href="images/semi.ico">
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
     width: 447px;
     height: 52px;
     border-radius:5px; 
     /* 클릭시 검정태두리가 나타나는데 그거 없애줌*/
     outline: 0;  
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
     width: 447px;
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
     font-weight: 1000; 
     font-size: 25px; 
     border: none; 
     background-color:rgb(202, 202, 202);
     cursor:pointer;
 }

</style>
</head>
<body>
	<div id="warp">
		<img id="logoimg" src="<%=request.getContextPath()%>/images/logo2.png" onclick="location.href='<%=request.getContextPath() %>/main.jsp'">
		<br><br>	
		<form  method="post" action="<%=request.getContextPath()%>/login.me" onsubmit="return loginf()">
		<div class="center_div">
           
            <br>                    
            <input type="text" name="userId" id="userId" class="log" placeholder=" 아이디를 입력해주세요."> <br>    
                        
        </div>
		
		<div class="center_div">
		    
		    <br>   
		    <input type="password" name="userPw" id="userPw" class="log"  placeholder=" 비밀번호를 입력해주세요.">
		    <p id="ero_msg">
		    <%if(msg!=null){%>
		    	아이디/비밀번호가 일치하지 않습니다.
		    <%}else{ %>
		    	&nbsp;
		    <%} %>
		     </p>              
		</div>
		<br clear="both">
		 
		<input id="log_btn" type="submit" value="로그인">
		
		</form>
		
		<br>
		<br>
		<br>
		
		<div class="center_div" style="border-top:1px solid rgb(202,202,202); padding: 10px; ">			
			<div class="menup" onclick="location.href='findid.jsp'">아이디 찾기</div>
			<div class="menup" style="border-left: 1.5px solid rgb(202, 202, 202); border-right: 1.5px solid rgb(202, 202, 202);" onclick="location.href='findpw.jsp'">비밀번호 찾기</div>
			<div class="menup" onclick="location.href='join.jsp'">회원가입</div>
		</div>
		
	</div>

	<script>
		
		function loginf(){
			var userId =$('#userId').val();
			
			if($('#userId').val().trim().length == 0){
				alert("아이디를 입력해 주세요");
				return false;
			}
			if($('#userPw').val().trim().length == 0){
				alert("비밀번호를 입력해 주세요");
				return false;
			}
			return true;
		}
		
		
		
	</script>
	
	
</body>
</html>