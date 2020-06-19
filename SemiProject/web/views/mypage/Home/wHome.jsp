<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="home.model.vo.myHome, java.util.ArrayList"%>
<%

myHome home = (myHome)request.getAttribute("home");
 ArrayList hrlist = (ArrayList)request.getAttribute("hrlist");


/* String type = home.getType();
String period =home.getPeriod();
String title = home.getTitle();
String fee = home.getFee();
String address = home.getAddress();
String essentialItem = home.getEssentialItem();
String wifi = home.getWifi();
String television = home.getTelevision();
String heater =home.getHeater();
String airConditional = home.getAirConditional();
String livingroom = home.getLivingroom();
String bathroom = home.getBathroom();
String pet = home.getPet();
String userName = home.getUserName();
String email =home.getEmail(); */
%>    
    
    
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

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

  <!-- Custom styles for this template -->


  <style>
  
nav{
      text-align: center;
    }
    #nation {
      border: 0.5px solid rgb(176, 171, 171);
      border-top-left-radius: 0.5em;
      border-top-right-radius: 0.5em;
      border-bottom-left-radius: 0.5em;
      border-bottom-right-radius: 0.5em;
      padding-left: 0;
      width: 480px;
      height: 50px;
      margin-bottom: 10px;

    }

    #nation>li {
      /* border:0.5px solid black; */
      /* display: inline-block; */
      float: left;
      width: 16.6667%;
      padding: 15px;
      padding-left: 0;
      padding-right: 0;
      margin-left: 0;
      margin-right: 0;
      border-top-left-radius: 0.5em;
      border-top-right-radius: 0.5em;
      border-bottom-left-radius: 0.5em;
      border-bottom-right-radius: 0.5em;
    }

    #nation>li:hover {
      background: rgb(165, 165, 165);
    }

    #zxc>ul>li :hover {
      border-bottom-left-radius: 0.5em !important;
      border-bottom-right-radius: 0.5em !important;
      border-top-left-radius: 0.5em !important;
      border-top-right-radius: 0.5em !important;
      transition: 0s;
    }

  

    /* .container {
      padding: 5px;
    } */

    .menu {
      background: rgb(113, 177, 197);
    }

    .area {
      /* background: lightgray; */
      /* border: 1px solid black; */
      /* height: auto; */
      display: inline-block;
      /* width: 30%; */
      text-align: left;
    }

    .infor>li>a {
      color: black;

    }

    .z1 {
      z-index: 1000;

    }

    .z2 {
      z-index: 100;

    }



    #nara {
      background: rgb(143, 199, 207) !important;
    }

    .depth2_menu>li {
      list-style-type: none;
      padding-top: 20px;
      font-weight: 700;
      font-size: 15px;
    }
    .depth2_menu a{
    color: gray !important;
   }
    #home td{
      font-size: 20px;
      border: 1px solid black;
    }
    .mainChoice{
      text-align: center;
      background: lightgray;
      width: 200px;
      height: 40px;
    }
    .content{
      padding-left:5px;
      width:500px;
    }
     .content1{
      padding-left:5px;
      width:400px;
      color: red;
      border: 1px solid black;
    }
  </style>

</head>
<!-- NAVBAR
================================================== -->

<body>

 
	<%@ include file="/views/common/menubar.jsp" %>
	
	


 <div style="position:static;">
 <div class="area side z2"
    style="width: 160px; height: 900px; margin: 0; padding: 0; border-right: 1px solid lightgray; ">

    <nav class="side_menu" style="margin-top:80%">

      <ul class="depth2_menu">
        <li class="depth2_list"><a class="depth2_anchor" href="<%=request.getContextPath() %>/views/mypage/PIU/personalIU.jsp" target="_self">개인정보수정</a>

        </li>
        <li class="depth2_list actived"><a class="depth2_anchor" href="<%=request.getContextPath() %>/search.ho" target="_self">집 예약 내역</a>
        </li>
        <li class="depth2_list"><a class="depth2_anchor" href="<%=request.getContextPath() %>/list.aj" target="_self">구직 신청
            내역</a>


        </li>
        <li class="depth2_list"><a class="depth2_anchor" href="<%=request.getContextPath() %>/list.c" target="_self">내가 쓴 글</a>


        </li>
        <li class="depth2_list"><a class="depth2_anchor" href="<%=request.getContextPath() %>/list.job" target="_self">찜 목록</a>


        </li>

      </ul>

    </nav>
  </div>
    

    <div id="wrap" class="area" style="position:absolute; margin-left: 5%;"; align="center">
   
        <h1 style="font-weight: 900;">집 예약 내역</h1>
   
      <form style="margin-top: 100px; margin-left: 280px; " >

        <%if(hrlist.isEmpty()){ %> 
        <table align="center" id="home">
         <tr>
            <td class="mainChoice">글 제목</td>
            <td class="content1" rowspan="10" >&nbsp;&nbsp;X 예약 내역이 없습니다.<br>&nbsp; 좋은 집들이 많으니 어서 예약하세요!!</td>
          </tr>
          <tr>
            <td class="mainChoice">집 종류</td>
          </tr>
          <tr>
            <td class="mainChoice">입주 기간</td>
          </tr>
          <tr>
            <td class="mainChoice">월세</td>
          </tr>
          <tr>
            <td class="mainChoice">건물주 이름</td>
          </tr>
          <tr>
            <td class="mainChoice">건물주 이메일</td>
          </tr>
          <tr>
            <td class="mainChoice">건물 주소</td>
          </tr>
          <tr>
            <td class="mainChoice">편의 시설</td>
          </tr>
          <tr>
            <td class="mainChoice">공용 공간</td>
          </tr>
          <tr>
            <td class="mainChoice">애완동물</td>
          </tr>
          </table>
          <br><br>
          
           <%}else{ %> 
           <table align="center" id="home">
          <tr>
            <td class="mainChoice">글 제목</td>
            <td class="content">&nbsp;&nbsp;<%=((myHome)hrlist.get(0)).getTitle() %></td>
          </tr>
          <tr>
            <td class="mainChoice">집 종류</td>
            <td class="content">&nbsp;&nbsp;<%=((myHome)hrlist.get(0)).getType() %></td>
          </tr>
          <tr>
            <td class="mainChoice">입주 기간</td>
            <td class="content">&nbsp;&nbsp;<%=((myHome)hrlist.get(0)).getPeriod() %></td>
          </tr>
          <tr>
            <td class="mainChoice">월세</td>
            <td class="content">&nbsp;&nbsp;<%=((myHome)hrlist.get(0)).getFee() %></td>
          </tr>
          <tr>
            <td class="mainChoice">건물주 이름</td>
            <td class="content">&nbsp;&nbsp;<%=((myHome)hrlist.get(0)).getUserName() %></td>
          </tr>
          <tr>
            <td class="mainChoice">건물주 이메일</td>
            <td class="content">&nbsp;&nbsp;<%=((myHome)hrlist.get(0)).getEmail() %></td>
          </tr>
          <tr>
            <td class="mainChoice">건물 주소</td>
            <td class="content">&nbsp;&nbsp;<%=((myHome)hrlist.get(0)).getAddress() %></td>
          </tr>
          <tr>
            <td class="mainChoice">편의 시설</td>
            <td class="content">
            
            <%if(((myHome)hrlist.get(0)).getEssentialItem().charAt(0)=='Y'){ %>
            	&nbsp;&nbsp;수건 침대 식탁 
            <%}else{ %>
            	" "
            <%} %>
            
            <%if(((myHome)hrlist.get(0)).getWifi().charAt(0)=='Y'){ %>
            &nbsp;wifi 
            <%}else{ %>
            	 " "
            <%} %>

            <%if(((myHome)hrlist.get(0)).getTelevision().charAt(0)=='Y'){ %>
            &nbsp;TV 
            <%}else{ %>
            	 " "
            <%} %>
            <%if(((myHome)hrlist.get(0)).getHeater().charAt(0)=='Y'){ %>
            &nbsp;난방 
            <%}else{ %>
             " "
            <%} %>
            
             <%if(((myHome)hrlist.get(0)).getAirConditional().charAt(0)=='Y'){ %>
            &nbsp;공기청정기 
            <%}else{ %>
            	" "
            <%} %>
            </td>
          </tr>
          <tr>
            <td class="mainChoice">공용 공간</td>
            <td class="content">
             <%if(((myHome)hrlist.get(0)).getLivingroom().charAt(0)=='Y'){ %>
            &nbsp;&nbsp;	거실 
            <%}else{ %>
            	 " "
            <%} %>
            
             <%if(((myHome)hrlist.get(0)).getBathroom().charAt(0)=='Y'){ %>
            	화장실 
            <%}else{ %>
            	 " "
            <%} %>
            
            </td>
          </tr>
          <tr>
            <td class="mainChoice">애완동물</td>
            <td class="content">
             <%if(((myHome)hrlist.get(0)).getPet().charAt(0)=='Y'){ %>
           &nbsp;&nbsp; 	O
            <%}else{ %>
            &nbsp;&nbsp;	"--"
            <%} %>
            </td>
          </tr>
        </table><br><br>
           <button id="homeless" style="width:150px; height:35px; margin-left: 83%;" >예약 취소</button>
           <%} %> 
      </form>
      <br><br>
      
     
    </div>

    <script>
      $(function() {
        $("#homeless").click(function(){ 
        var result = confirm("예약을 취소 하시겠습니까?");
          if(result){
        	  location.href="<%=request.getContextPath()%>/delete.home";
          }
      })
      
      $("#home .content").click(function(){
			location.href="<%=request.getContextPath()%>/detail.home";
	});
    })



    </script>



  <!-- Marketing messaging and featurettes
    ================================================== -->
  <!-- Wrap the rest of the page in another container to center all the content. -->




  <!-- Bootstrap core JavaScript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="../../assets/js/docs.min.js"></script>
  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <script src="../../assetsjs/ie10-viewport-bug-workaround.js"></script>
  <!-- <script src="vendor/holder.js"></script> -->

</body>

</html>