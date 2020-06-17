<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.*"%>
    
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>    
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script src="https://code.jquery.com/jquery-latest.js"></script> 
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<title>Delivery Management System</title>

<!-- Bootstrap CSS -->
<link rel="icon" href="../../favicon.ico">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link href="../carousel/carousel.css" rel="stylesheet">
<!-- Bootstrap Javascript -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<!-- <script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script> -->

<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
<style>
   header{
      width: 1400px;
      font-family: 'Noto Sans KR', sans-serif;
      color: black;
      text-align: center;
  }


  #content{
      font-family: 'Noto Sans KR', sans-serif;
      text-align: center;
  }

  .menu {
      background:rgb(113, 177, 197);
      text-align: center;
      margin: 0 auto;
  }

  .navbar-brand{
      width: 12.9%; 
      height: 20%; 
      padding: 0px;
  }

  .navbar-brand img{ 
      width: 100%; 
      height: 100% ; 
  }

  .nav {
      margin: 0;
      padding: 0;
      list-style-type: none;  
      text-align: center;
      padding-top: 7%;
      margin: 0 auto;
      height: auto;
  }

  .nav > li {
      margin:0;
      padding: 0;
      display: inline;
      padding-bottom: 5em;
      padding-left: 0;
  }

  .nav > li > a {
      display: inline-block;
      font-weight: 600;
      font-size: 100%;
      color: black;
      text-decoration: none;
  }

  .nav > li:hover > a{
      background: none;
      color: white;
  }

  .nav li > ul {
      display: none;      
  }

  .nav li:hover ul {
      width: 480%;
      position: absolute;
      opacity: 1;
      display: block;
      margin-top: 4.5%;
      height: 3em;
      text-align: center;
      background: #ADD4D9;
      right: 0;
  }

  .nav li:hover > ul > li {
      float: left;
      border: rgb(113, 177, 197);
      margin: 0;
      padding: 0;
      display: block;
      margin-right: 10%;
      height: 3em;
  }

  .nav li:hover > ul > li > a{
      color: black;
      margin: 0;
      line-height: 3em;
      display: block;
  }

  .login_register{
      list-style-type: none;
      padding: 0;
      margin: 0;
      position: absolute;
      top: 2%;
      right: 4%;
  }

  .login_register li{
      float: left;
      position: relative;
      line-height: 3em;
      padding-left: 1em;
      padding-right: 1em;
  }

  .login_register li a {
      display: block;
      font-weight: 600;
      font-size: 95%;
      color: black;
      text-decoration: none;
  }

  #footer{
      margin-top: 10%;
  }
</style>
</head>
<body>
<header>
    <div class="container2">
      <div class="logo">
        <a class="navbar-brand" href="#"><img src="<%=request.getContextPath()%>/images/semi.png"></img></a>
      </div>
      <div class="menu">
        <ul class="nav">
          <li class="active"><a href="#">소개</a></li>
          <li><a href="#">안전정보</a></li>
          <li><a href="#" onclick = "goHome();">집 예약</a></li>
          <li><a href="#">구직 정보</a></li>
          <li><a  onclick ="goCommunity();">커뮤니티</a>
            <ul id="nara">
              <li><a href="http://www.naver.com">뉴질랜드</a></li>
              <li><a href="http://www.naver.com">독일</a></li>
              <li><a href="http://www.naver.com">일본</a></li>
              <li><a href="http://www.naver.com">캐나다</a></li>
              <li><a href="http://www.naver.com">호주</a></li>
            </ul>
          </li>
        </ul>
    </div>
    <ul class="login_register" >
    	<%if(loginUser == null){ %>
        <li><a href="<%=request.getContextPath() %>/views/member/login.jsp">로그인</a></li>
        <li><a href="<%=request.getContextPath() %>/views/member/join.jsp">회원가입</a></li>
        <%} else{ %>
        	<%if(loginUser.getGrade() == 2){ %>
	        <li><a href="<%=request.getContextPath() %>/views/member/#.jsp">마이페이지</a></li>
        	<%} else if(loginUser.getGrade() == 3){ %>
        		<li><a href="<%=request.getContextPath() %>/views/member/#.jsp">마이페이지</a></li>
        	<%} else{ %>
        	<li><a href="<%=request.getContextPath()%>/wselectallmember.me">회원관리</a></li>
        	 <%} %>
	        <li><a href="<%=request.getContextPath()%>/sessionclear.me">로그아웃</a></li>
	       
        <%} %>
       
    </ul>
    </div>
</header>
<script>
	function goHome(){
		location.href = "<%=request.getContextPath()%>/list.ho";
	}
	function goCommunity(){
		location.href = "<%=request.getContextPath()%>/list.bo";
	}
</script>
</body>
</html>