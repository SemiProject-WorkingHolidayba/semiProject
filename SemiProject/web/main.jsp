<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="home.model.vo.*, java.util.ArrayList, safeInfo.model.vo.*, community.model.vo.*"%>
<%

	ArrayList<Home> Homelist = (ArrayList<Home>)session.getAttribute("Homelist");
	ArrayList<Img> Imglist = (ArrayList<Img>)session.getAttribute("Imglist");
	ArrayList<Safe> Safelist = (ArrayList<Safe>)session.getAttribute("Safelist");
	ArrayList<Community> Commulist = (ArrayList<Community>)session.getAttribute("Commulist");
	int sNo;
	int cNo;
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

    <title>WorkingThrough</title>

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
            height: 400px;
            text-align: center;
            
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

        .container_div{
           
           float:left;
         width: 270px;
         height: 360px;
         border:1px solid rgb(200,200,200);
         box-shadow: 5px 5px 5px rgb(219,219,219);
            margin-left:1em;
         }
         .li-img{
            width: 270px;
         }
         .li-text{
              display: table-cell;
                vertical-align: middle;
                width: 90%;
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
      font-size: 16px;
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

#text{
word-break:break-all; 

}

    </style>
  </head>
  <body>
   
  <%@include file="views/common/menubar.jsp"%>
   
    <div id = "content">
       <div class="swiper-container">
          <!-- Additional required wrapper -->
          <div class="swiper-wrapper">
              <!-- Slides -->
              <div class="swiper-slide">
                 <img src="images/country/Australia/ophera.jpg" alt="First slide">
                  <div class="carousel-caption">
                       <h1>호주</h1>
                       <h1>오페라하우스</h1>
                       <hr />
                     </div>
              </div>
              <div class="swiper-slide">
                 <img src="images/country/Japan/himeji.jpg" alt="Second slide">
                 <div class="carousel-caption">
                       <h1>일본</h1>
                       <h1>히메지 성</h1>
                       <hr />
                     </div>
              </div>
              <div class="swiper-slide">
                 <img src="images/country/Canada/niagaraFalls.jpg" alt="Third slide">
                 <div class="carousel-caption">
                       <h1>캐나다</h1>
                       <h1>나이아가라 폭포</h1>
                       <hr />
                   </div>
              </div>
              <div class="swiper-slide">
                 <img src="images/country/Germany/Frankfurt.jpg" alt="Third slide">
                 <div class="carousel-caption">
                       <h1>독일</h1>
                       <h1>프랑크 프루트</h1>
                       <hr />
                     </div>
              </div>
              <div class="swiper-slide">
                 <img src="images/country/Newzealand/auckland.jpg" alt="Third slide">
                 <div class="carousel-caption">
                       <h1>뉴질랜드</h1>
                       <h1>오클랜드</h1>
                       <hr />
                     </div>
              </div>
          </div>
          <!-- If we need pagination -->
          <div class="swiper-pagination swiper-pagination-white"></div>
      
          <!-- If we need navigation buttons -->
          <div class="swiper-button-prev swiper-button-white"></div>
          <div class="swiper-button-next swiper-button-white"></div>
      
          <!-- If we need scrollbar -->
          <div class="swiper-scrollbar"></div>
      </div>
        <br>
        <br>


        <br><br><br>
          <div class="container" align="center" style=" width:1200px; margin-left:50px; margin-right:50px; text-align: center;">
               <%for(int i=0; i<4; i++){ 
                  if(i<Homelist.size()){
                  Home h = Homelist.get(i);%>
                     
                    <input type = "hidden" id="gethNo" value = "<%=(Homelist.get(i)).gethNo()%>">
               		<div class="container_div">
                              <a href="#" class="inner">
                                  <div class="li-img">
                              <%for(int j = 0; j < Imglist.size(); j++) {
                                 Img a = Imglist.get(j);%>
                                 <input type = "hidden" value = "<%=(Homelist.get(i)).gethNo()%>">
                                           <%if(h.gethNo() == a.getHouseNo()) { %> <!-- 한 게시글의 대표 이미지  -->
                                       <img src = "<%=request.getContextPath() %>/home_uploadFiles/<%=a.getImg()%>" width = "250px" height = "260px" alt = "Image Alt Text" >
                                    <%} %>
                              <%} %>
                                  </div>
                                  <div class="li-text" style="text-align: center;">
                                      <h4 class="li-head"><%=(Homelist.get(i)).getTitle() %></h4>
                                      <p style=" margin-left:5px;width:250px;height:60px; display: -webkit-box; -webkit-box-orient: vertical; -webkit-line-clamp: 3; overflow: hidden;""><%=(Homelist.get(i)).getContent() %>555555555555555555
                                    
                                      </p>
                                  </div>
                              </a>
                          
                  </div>
                  
               <%} else{%>
                  <div class="container_div" style="text-overflow:ellipsis;">
                  <br>
                  <p> 게시글이 없습니다. </p>
                               
                  </div>
               <%} 
               }%>        
              
           
        
          </div> <!-- /container -->
      <br>
      <br>
      <br>
      
   <br>
   <br>
   
   <br>
          <div class="container1 z2" id="information" align="center" style="width: 1100px">
            <div id="area1" class="notice" style="width:450px; height:250px; border:1px solid rgb(200,200,200); padding-left:10px; 
         ">
                <h3 class = "title">공지사항<small><a href="<%=request.getContextPath()%>/list.bo" class = "more">+더보기</a></small></h3>
                <ul class="infor" style="margin-left:5px;">
                  <%for(int i = 0 ; i < 5; i++) { cNo = (Commulist.get(i)).getCommunityNo();%>
             		<input type = "hidden" value = "<%=(Commulist.get(i)).getCommunityNo()%>">
                	<li class = "commu" style = "cursor:point;" onclick = "location.href = '<%=request.getContextPath()%>/Detail.bo?communityno=<%=cNo%>';"><%=(Commulist.get(i)).getTitle()%></a></li>
                <%} %>  
                </ul>                
            </div>
            <div id="area1" class="safe_information" style="width:450px;height:250px; border:1px solid rgb(200,200,200); padding-left:10px; 
         ">
              <h3 class = "title">안전정보 <small><a href="<%=request.getContextPath()%>/list.si" class = "more">+더보기</a></small></h3>
              <ul class="infor" style="margin-left:5px;">
             	<%for(int i = 0 ; i < 5; i++) { sNo = (Safelist.get(i)).getSafeNo();%>
             	<input type = "hidden" value = "<%=(Safelist.get(i)).getSafeNo()%>">
                	<li class = "safe" style = "cursor:point;" onclick = "location.href = '<%=request.getContextPath()%>/detail.si?sNo=<%=sNo%>';"><%=(Safelist.get(i)).getTitle()%></a></li>
                <%} %>               
              </ul>
            </div>
          </div>
    </div>
   <br>
   <br>
   <br>
   
   <br>
   <br>
	<div id = "footer" style="margin-bottom: 0;">
      <%@include file="views/common/bottom.jsp"%>
   </div>
    <script>
          $(window).scroll(function() {

             var wins = $(this).scrollTop();
             var hei = $('#content').outerHeight();
             var hei2 = $(window).outerHeight();
             var height = hei - hei2;
             var bar = (wins / height) * 100;

             $('#myBar').css('width', bar + '%');

           });
          $('#carousel').carousel({ interval: 2000 });
          
        
          $(function(){
            $(".container_div").click(function(){
            
               var hNo = $(this).prev().val();
               
               if(hNo != ""){
                location.href = "<%=request.getContextPath()%>/detail.ho?hNo=" + hNo; 
               }else{
                  alert("게시글이 없습니다.");
               }
            });
            
            $(".safe").click(function(){
            	var sNo = $(this).prev().val();
                
                if(sNo != ""){
                 location.href = "<%=request.getContextPath()%>/detail.si?sNo=" + sNo; 
                }else{
                   alert("게시글이 없습니다.");
                }
            })
         });
          
    </script>
    
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
   

   <script src="path/to/swiper.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="assets/js/ie10-viewport-bug-workaround.js"></script>
    <!-- <script src="vendor/holder.js"></script> -->
   
  </body>
</html>