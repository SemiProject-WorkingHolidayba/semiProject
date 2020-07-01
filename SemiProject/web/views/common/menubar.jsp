<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.*"%>
<%
   Member loginUser = (Member)session.getAttribute("loginUser");
%> 
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <title>WorkignThrough</title>

    <!-- Bootstrap CSS -->
    <link rel="icon" href="images/semi.ico">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="carousel.css">
    
    <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
   <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">
   <link rel="stylesheet" href="path/to/swiper.min.css">
   
   <script src="https://unpkg.com/swiper/js/swiper.js"></script>
   <script src="https://unpkg.com/swiper/js/swiper.min.js"></script>

    <!-- Bootstrap Javascript -->
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script>

    <script src="assets/js/ie-emulation-modes-warning.js"></script>

    <!-- Custom styles for this template -->
    <style>
        
       body{
          width: 1250px;
          
       }
      
         #nation {
            border: 0.5px solid rgb(176, 171, 171);
            border-radius: 0.5em;
            padding-left: 0;
            width: 600px;
            height: 50px;
            margin-bottom: 10px;
            list-style: none;
            font-weight: 600;
            font-size: 1.05em;
        }

        #nation>li {
            float: left;
            width: 16.655%;
            padding: 14px;
            padding-left: 0;
            padding-right: 0;
            margin-left: 0;
            margin-right: 0;
            border-radius: 0.5em;
        }

        #nation>li:hover {
            background: rgb(165, 165, 165);
            color: white;
        }

        .nav>li>a {
            color: black;
        }

        .container{
            padding: 1%;
        }

        .notice{
            width: 40%;
            margin-right: 15%;
            background: white;
            height: auto;
            display: inline-block;
            text-align: left;
        }

        .safe_information{
            width: 40%;
            background: white;
            height: auto;
            display: inline-block;
            text-align: left;
            margin-right: 1%;

        }

        .more{
            margin-left: 55%;
        }

        .title{
            margin-left: 3%;
            margin-bottom: 4%;
        }
    
        .infor >li > a{
            color: black;
        }

        #information{
            width: 75%;
            margin: 0 auto;
        }

        #information li{
            margin: 2%;
        }

        .container a{

            color: black;

            }
      .item{
         width: 960px;
         height: 530px;
         text-align: center;
      }
      
      .swiper-container {
         width: 100%;
         height: 600px;
   
       }
       
       .swiper-slide img{
          width:100%;
       }
   
       .swiper-slide {
         text-align: center;
         font-size: 18px;
         background: #fff;
   
         /* Center slide text vertically */
         display: -webkit-box;
         display: -ms-flexbox;
         display: -webkit-flex;
         display: flex;
         -webkit-box-pack: center;
         -ms-flex-pack: center;
         -webkit-justify-content: center;
         justify-content: center;
         -webkit-box-align: center;
         -ms-flex-align: center;
         -webkit-align-items: center;
         align-items: center;
       }
       
       .swiper-slid img{
          width:100%;
          height:100%;
          position:relative
          }
 .menu {
       position: fixed;
   
     z-index: 1000;
     padding:0;
     margin:0;
   background:white;
   justify-content: space-between;

    
     
  }

 .navbar-brand{
      width: 12.9%; 
      height: 20%; 
      padding: 0px;
      margin:0
  }

  .navbar-brand img{ 
      width: 100%; 
      height: 100% ; 
  }

  .nav {
      padding: 0;
      list-style-type: none;  
      text-align: center;
      margin-top:1%;
     
  }

  .nav > li {
      margin:0;
      padding: 0;
      display: inline;
      padding-bottom: 5em;
      padding-left: 50px;
      font-size: 14px;
  }

  .nav > li > a {
      display: inline-block;
      font-weight: 600;
      font-size: 14px;
      color: black;
      text-decoration: none;
  }

  .nav > li:hover > a{
      background: none;
      border: 1px solid rgb(143,199,207);
      border-radius:5px; 
  }

  .nav li > ul {
       display: none; 
       
  }

  .nav li:hover ul {
      width: 500px;
      position: absolute;
      background:rgba(143,199,207,0.7);
      margin-top:3%;
      opacity: 1;
      display: block;
      border-radius:5px;
     /*  margin-top: 4%; */
      height: 3em;
      text-align: center;
      right: 0;
      z-index: 1000;
      
  }

  .nav li:hover > ul > li {
      float: left;
      margin: 0;
      padding: 0;
      display: block;
     
      margin-right: 3%;
      height: 3em;
      width:6em;
  }
   

  .nav li:hover > ul > li > a{
      color: black;
      margin: 0;
      line-height: 3em;
      display: block;
      text-decoration:none;
      
      
  }
.progress-container {
  width: 100%;
  height: 4px;
  background: #ccc;
}

.progress-bar {
  height: 4px;
  background:rgb(91,173,185);
  width: 0%;
  transition: all .3s ease;
}
#loginbut button{
margin-right: 2em; 
font-size:12px;
border:0;  
outline:0; 
background:none;
}
    </style>
  </head>
  <body>
   
   <div class="menu" style="width: 1250px; height: auto;">
     <img style="margin:0; padding:0; float:left;" src="<%=request.getContextPath()%>/images/testlogo.png" onclick="location.href='<%=request.getContextPath() %>/main.jsp'"></img>
           <div id="menubar" style="float:left; height:54px; width:750px; ">
            <ul class="nav" >
             <li><a href="<%=request.getContextPath()%>/list.si">안전정보</a></li>
             <li><a href="<%=request.getContextPath()%>/list.ho">집 예약</a></li>
        
               <%if(loginUser != null){ %>
          <li><a  onclick ="goFindJob();" style="cursor:pointer";>구직정보</a>
          
          <%} else{%>
           <li><a  onclick ="goFindJob1();"  style="cursor:pointer";>구직정보</a>
          <% }%>
          <script>
          function goFindJob(){
            location.href = "<%=request.getContextPath()%>/jobList.bo";
         }
          function goFindJob1(){
              alert('로그인 후 이용 가능한 항목입니다');
           }
          </script>
          
          
          
          
          
          
          
          <%if(loginUser != null){ %>
          <li><a  onclick ="goCommunity();" style="cursor:pointer";>커뮤니티</a>
          
          <%} else{%>
           <li><a  onclick ="goCommunity1();"  style="cursor:pointer";>커뮤니티</a>
          <% }%>
          <script>
          function goCommunity(){
            location.href = "<%=request.getContextPath()%>/list.bo?categoryName=공지사항";
         }
          function goCommunity1(){
              alert('로그인 후 이용 가능한 항목입니다');
           }
          </script>
          
               <ul id="nara">
                 <li><a href="<%=request.getContextPath() %>/list.bo?categoryName=공지사항">공지사항</a></li>
                 <li><a href="<%=request.getContextPath() %>/list.bo?categoryName=자유게시판">자유게시판</a></li>
                 <li><a href="<%=request.getContextPath() %>/list.bo?categoryName=질문게시판">질문게시판</a></li>
                 <li><a href="<%=request.getContextPath() %>/list.bo?categoryName=벼룩시장">벼룩시장</a></li>
                  </ul>
                </li>
              </ul>
           
             </div>
      <div id="loginbut" style="text-align:right; width:auto; height:54px; padding-top:1.2em; ">
            <%if(loginUser == null){ %>
            <button onclick="location.href='<%=request.getContextPath() %>/views/member/login.jsp'" >로그인</button>
            <button onclick="location.href='<%=request.getContextPath() %>/views/member/join.jsp'">회원가입</button>
            <%}else{ %>
               <%if(loginUser.getGrade() == 2){ %>
            <button onclick="location.href='<%=request.getContextPath() %>/views/mypage/PIU/personalIU.jsp'">마이페이지</button>
               <%}else if(loginUser.getGrade() == 3){ %>
               <button onclick="location.href='<%=request.getContextPath() %>/views/mypage/PIU/NpersonalIU.jsp'">마이페이지</button>
               <%}else{ %>
               <button onclick="location.href='<%=request.getContextPath() %>/wselectallmember.me'">회원관리</button>
               <%} %>
            <button onclick="location.href='<%=request.getContextPath() %>/sessionclear.me'">로그아웃</button>
            
            <%} %>
      </div>
        <div class="progress-container">
    <div class="progress-bar" id="myBar"></div>
  </div>
      </div>
   
    
    
  <script>
       var swiper = new Swiper('.swiper-container', {
           spaceBetween: 30,
           centeredSlides: true,
           autoplay: {
             delay: 2000,
             disableOnInteraction: false,
           },
           pagination: {
             el: '.swiper-pagination',
             clickable: true,
           },
           navigation: {
             nextEl: '.swiper-button-next',
             prevEl: '.swiper-button-prev',
           },
         });
    </script>
</body>
</html>