<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String error = (String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WorkingThrough</title>
<link rel="icon" href="images/semi.ico">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
    body{
        width: 1400px;
    }
    #warp{
        text-align: center;
        margin-top: 8em;
    }
 
    #logoimg{
        width: 542px;
        height: 95px;
    }
    
    .log{   
        border:1px solid rgb(202, 202, 202) ;                
        padding-left: 8px;
        font-size: 16px;
        width: 447px;
        height: 52px;
        border-radius:5px; 
        /* 클릭시 검정태두리가 나타나는데 그거 없애줌*/
        outline: 0; 
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
    .ero_msg{
        float: left; 
        padding-left: 5px; 
        font-size: 13px; 
        margin:0;
        color: red;
        visibility:hidden;
        /* visibility는 hidden은 공간을 차지하면서 안보이고
           unset은 보이게함
         */
    }
    #log_btn{
        font-weight: 1000; 
        font-size: 25px; 
        border: none; 
        background-color:rgb(202, 202, 202);

        width: 447px;
        height: 52px;
        border-radius:5px; 
        /* 클릭시 검정태두리가 나타나는데 그거 없애줌*/
        outline: 0; 
    }
    /* 말풍선 모양 */
    .arrow_box {
    position: relative;
    
    }
    .arrow_box:after, .arrow_box:before {
        left: 100%;
        top: 50%;
        border: solid transparent;
        content: " ";
        height: 0;
        width: 0;
        position: absolute;
        pointer-events: none;
    }

    .arrow_box:after {
        border-color: rgba(136, 183, 213, 0);
        border-left-color:rgb(219, 219, 219);
        border-width: 8px;
        margin-top: -8px;
    }
    .arrow_box:before {
        border-color: rgba(194, 225, 245, 0);
        border-left-color: rgb(219, 219, 219);
        border-width: 14px;
        margin-top: -14px;
    }
    #filebox{
        width: 440px; 
        border:1px solid rgb(202, 202, 202); 
        padding: 15px 5px 3px; 
        line-height:100%; 
        margin:0; 
        display: none;
    } 
    #typeEx{
        float: left; 
        visibility:hidden;
        width: 21%;  
        border: 1px solid rgb(202,202,202); 
        background-color: rgb(219, 219, 219); 
        color: rgb(80,80,80); 
        font-size: 80%; 
        font-weight: 900; 
        padding: 1%; ; 
        border-radius:4%; 
        margin-right: 18px; 
    }
    .birth{
    	float: left; 
    	width: 130px; 
    	height: 52px; 
    	border-radius:5px; 
    	outline: 0; 
    	font-size: 18px; 
    	margin-left: 1.5em; 
    	padding-left: 10px; 
    	border-color: rgb(202, 202, 202);
		
    }
    .label_style{
    	float: left; 
    	font-size: 18px; 
    	font-weight: 900;
    }
    .check_img{
    	position: absolute; 
    	z-index: 100; 
    	width: 30px; 
    	right: 0; 
    	top: 0.8em;
    }
    
    #CF_Btn{
    	border-radius:5px;
    	background-color:rgb(202, 202, 202); 
    	border: 1px solid rgb(202, 202, 202)
    	;  
    	height: 52px; 
    	margin-top:2px; 
    	margin-left:15px";
    	outline: 0; 
    }
    #email{
    	float:left;
    	width:360px;
    
    }   
    #userId{
    	position: relative; 
    	z-index: 10;
    }
    #CF_Check_Btn{
    	height: 30px; 
    	background-color:rgb(202, 202, 202); 
    	border: 1px solid rgb(202, 202, 202); 
    	margin-top:2px; 
    	margin-left:5px; 
    	border-radius:5px;
    	outline: 0; 
    }
    #CF_Num{
    	float: left;
    	height: 30px; 
    	width: 300px;
    }
    #certification{
	    display:none; 
	    border:1px solid rgb(219,219,219);
	    
	    padding: 15px;
	    border-radius:5px;
    }
</style>
</head>
<body>
 <div id="warp">

	<img id="logoimg" src="<%=request.getContextPath()%>/images/logo2.png"  onclick="location.href='<%=request.getContextPath() %>/main.jsp'">
		<br><br>
 	 <form method="POST" action="<%=request.getContextPath()%>/insert.me" >
 	 	<div class="center_div">
			<label class="label_style">아이디</label>
			<br>
			<div style="height:8px;"></div>    
			<div style="position: relative;">        
				<input type="text" name="userId" id="userId" class="log" placeholder=" 아이디를 입력해주세요."  required> 
				<img class="check_img" id="check_img_id" >
				<p class="ero_msg" id="ero_msg_id">※4~10자의 영문 소문자, 숫자만 가능합니다</p>
				
			</div>
			<br>
			<div style="height:8px;"></div>
						
			<label class="label_style">비밀번호</label>
			<br>   <div style="height:8px;"></div>
			<input type="password" name="userPw" id="userPw" class="log"  placeholder=" 비밀번호를 입력해주세요." required>
			<p class="ero_msg" id="ero_msg_pw">※4~20자의 영문 소문자, 숫자만 가능합니다</p>             
			<br>
			<div style="height:8px;"></div>
			
			<label class="label_style">비밀번호 확인</label>
			<br>   <div style="height:8px;"></div>
			<div style="position: relative;">   
			<input type="password" name="userPw2" id="userPw2" class="log"  placeholder=" 비밀번호를 확인해주세요." required readonly>
			<img class="check_img" id="check_img_pw">
			</div>
			<br>
			
			
			<label class="label_style">이름</label>
			<br>  <div style="height:8px;"></div> 
			<input type="text" name="userName" id="userName" class="log"  placeholder=" 이름를 입력해주세요." >
			  <br> <br>
			  
			<label class="label_style">생년월일</label><br>
			<div style="height:8px;"></div>
			<input maring-top:50px" type="text" name="birth" id="birth" class="log"  placeholder=" 생년월일 입력(6자)">
			
			<br><br>
			 <label style="float: left; font-size: 18px; font-weight: 900; width: 100px; text-align: left;">성별</label>
			<div style="float: left;">                        
			   <input style=" margin-left: 100px;" type="radio" id="male" name="gender" value="M" checked>&nbsp;<label for="male">남자</label>
			   <input style=" margin-left: 110px;" type="radio" id="female" name="gender" value="F">&nbsp;<label for="female">여자</label>
			   
			</div>  

			<br><br>
			<label class="label_style">이메일</label>
            <br>   <div style="height:8px;"></div>
            <input type="email" name="email" id="email" class="log"  placeholder=" 이메일을 입력해주세요." required>    
            <button type="button" style="outline: 0; margin-left: 5px;" id="CF_Btn">인증번호</button><br>
            <div style="height:8px;"></div>
            <p class="ero_msg" id="msg_em">
            <div style="height:11px;"></div>
            <div id="certification" style="">
				<input type="text" name="CF_Num"  class="log" id="CF_Num" placeholder="인증번호를 입력해주세요">
				<button type="button" id="CF_Check_Btn">인증번호 확인</button>
			</div>
			
			
			<div style="float: right;">
	             <div id="userType" style="float: left; width: 608px">   
		             <div id="typeEx" class="arrow_box">
		                        워킹홀리데이를 하려는 사용자는 워홀러에 체크하시고,<br>현지의 집매물이나 구직정보를 등록하려는 사용자는 현지인에 체크해주세요.
		            </div>   
		                    <br><br>   <div style="height:9px;"></div>      
	             		<label class="label_style" style="width: 100px;">사용자 분류</label>
                        <input style=" margin-left: 100px;" type="radio" id="grade2" name="grade" value="2" checked>&nbsp;<label for="grade2">워홀러</label>
                        <input style=" margin-left: 100px;" type="radio" id="grade3" name="grade" value="3" >&nbsp;<label for="grade3">현지인</label>
                  </div>
            </div>
		</div>
		<br>
		<br>
		<input  id="log_btn" type="submit" value="회원가입">
		<br><br><br><br><br><br><br><br><br><br>
		
		
 	 </form>
 	<script>
 	$(function(){
 		var error = "<%=error%>";
 		if(error == "회원가입실패"){
 			alert("회원가입 실패");
 		}
  		var emailsend;
 		

 	 	/* 아이디 정규 표현식 밎 중복 검사 */ 	 	
 	 	$("#userId").change(function(){
 	 		var IregExp=/^[a-z0-9]{4,10}$/;
 	 		if(!IregExp.test($(this).val())){
 	 			$("#check_img_id").attr("src","<%=request.getContextPath()%>/images/checkRed.png"); 	 		
 	 			$("#ero_msg_id").html("※4~20자의 영문 소문자, 숫자만 가능합니다").css("color","red");
 	 			
 	 		}else{
 	 			$.ajax({
 	 				url:"<%=request.getContextPath()%>/idcheck.me",
 	 				type:"post",
 	 				data: {userId:$(this).val()},
 	 				success:function(data){
 	 					if(data == "N"){
 	 						$("#check_img_id").attr("src","<%=request.getContextPath()%>/images/checkGreen.png");
	 	 					$("#ero_msg_id").html("사용 가능한 아이디 입니다.").css("color","green");
 	 					}
 	 					else{
 	 						$("#check_img_id").attr("src","<%=request.getContextPath()%>/images/checkRed.png"); 	 		
 	 		 	 			$("#ero_msg_id").html("※4~20자의 영문 소문자, 숫자만 가능합니다").css("color","red");
 	 					}
 	 				},
 	 				error:function(request,status,error){
 	                   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
 	           		}
 	 				
 	 			})
 	 			
 	 			
 	 			
 	 		}
 	 	}).focus(function(){
 	 		if($("#userId").val().trim().length == 0){
 	 			$("#ero_msg_id").css("visibility","unset");
 	 			
 	 		}
 	 	})
 	 	
 	 	/* 비밀번호 정규 표현식 밎 비밀번호 확인 */
 	 	$("#userPw").change(function(){
 	 		var PregExp=/^[a-z0-9]{4,20}$/;
 	 		
 	 		if(!PregExp.test($(this).val())){ 	 			
 	 			$("#ero_msg_pw").html("※4~20자의 영문 소문자, 숫자만 가능합니다").css("color","red");
 	 			
 	 			
 	 		}else{ 	 			
 	 			$("#ero_msg_pw").html("사용 가능한 비밀번호 입니다.").css("color","green");
 	 			$("#userPw2").attr("readonly",false);
 	 			
 	 		}
 	 		
 	 	}).focus(function(){
 	 		if($("#userPw").val().trim().length == 0){
 	 			$("#ero_msg_pw").css("visibility","unset");
 	 			
 	 		}
 	 	})
 	 	$("#userPw2").change(function(){
 	 		if($("#userPw").val() == $("#userPw2").val()){
 	 			$("#ero_msg_pw").css("visibility","hidden")
 	 			$("#check_img_pw").attr("src","<%=request.getContextPath()%>/images/checkGreen.png");
 	 			
 	 		}else{
 	 			$("#check_img_pw").attr("src","<%=request.getContextPath()%>/images/checkRed.png"); 
 	 			$("#userPw2").focus();
 	 			
 	 		}
 	 	})

 	 	
 	 	/* 이메일 정규 표현식 밎 이메일 인증 */
 	 	 $("#CF_Btn").click(function(){
 	 		var email = $("#email");
 	 		var EregExp=/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
 	 
 	 		if(email.val().trim().length==0){
 	 			alert("이메일을 입력해 주세요");
 	 			email.focus();
 	 		}else if(!EregExp.test(email.val())){
 	 			alert("형식에 맞지않습니다.");
 	 			
 	 		}else{
 	 			alert(email.val()+"으로 인증번호를 발송하였습니다.");
 	 			$("#certification").css("display","block");
 	 			
 	 			$.ajax({
 	 				url:"<%=request.getContextPath()%>/insertemail.me" ,
 	 				type:"post",
 	 				data:{email:email.val()},
 	 				success:function(data){
 	 					
 	 					emailsend = data;
 	 				},
 	 				error:function(request,status,error){
 	                   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
 	           		}
 	 				
 	 			})
 	 			
 	 			
 	 		}
 	 	 })
 	 	 $("#CF_Check_Btn").click(function(){
 	 		 	
 	 		 if($("#CF_Num").val() == emailsend){
 	 			 alert("인증이 완료되었습니다.")
 	 			$("#msg_em").html("인증 성공").css({"color":"green","visibility":"unset"});
 	 			$("#certification").css("display","none");
 	 			$("#email").attr("readonly",true);
 	 			$("#CF_Btn").attr("disabled","disabled")
 	 		 }else{
 	 			 alert("인증번호가 맞지않습니다.");
 	 			$("#CF_Num").test();
 	 		 }
 	 	 })
 	 	 
 	 	 $("#userType").mouseover(function(){
 	         $("#typeEx").css("visibility","unset");
 	     })
 	     $("#userType").mouseout(function(){
 	     	$("#typeEx").css("visibility","hidden");
 	     })
 	     
  	 	/* 이름 정규 표현식 */  	 	
  	 	$("#userName").change(function(){
  	 		var NregExp=/^[가-힣]{2,6}$/;
  	 		
  	 		if(!NregExp.test($(this).val())){
  	 			alert("이름을 정확히 입력해 주세요");
  	 		}
  	 		
  	 	})
  	 	$("#birth").change(function(){
  	 		var NregExp=/([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))$/

  	 		
  	 		if(!NregExp.test($(this.val()))){
  	 			alert("생년월일을 정확히 입력해 주세요");
  	 		}
  	 		
  	 	})
  	 	
 	})
 	
 	
 	
 	</script>
 
 </div>

</body>
</html>