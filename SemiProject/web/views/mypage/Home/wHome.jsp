<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="home.model.vo.Home, java.util.ArrayList"%>
<%
Home home = (Home)request.getAttribute("home");
/* ArrayList list = (ArrayList)request.getAttribute("list");
String type = ((Home)list.get(0)).getType();
String period =((Home)list.get(0)).getPeriod();
String title = ((Home)list.get(0)).getTitle();
String fee = ((Home)list.get(0)).getFee();
String address = ((Home)list.get(0)).getAddress();
String essentialItem = ((Home)list.get(0)).getEssentialItem();
String wifi = ((Home)list.get(0)).getWifi();
String television = ((Home)list.get(0)).getTelevision();
String heater =((Home)list.get(0)).getHeater();
String airConditional = ((Home)list.get(0)).getAirConditional();
String livingroom = ((Home)list.get(0)).getLivingroom();
String bathroom = ((Home)list.get(0)).getBathroom();
String pet = ((Home)list.get(0)).getPet();
String userName = ((Home)list.get(0)).getUserName();
String email =((Home)list.get(0)).getEmail(); */

String type = home.getType();
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
String email =home.getEmail();
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
        <li class="depth2_list actived"><a class="depth2_anchor" href="<%=request.getContextPath() %>/" target="_self">집 예약 내역</a>
        </li>
        <li class="depth2_list"><a class="depth2_anchor" href="<%=request.getContextPath() %>/views/mypage/Work/wWork.jsp" target="_self">구직 신청
            내역</a>


        </li>
        <li class="depth2_list"><a class="depth2_anchor" href="<%=request.getContextPath() %>/views/mypage/Letter/wLetter.jsp" target="_self">내가 쓴 글</a>


        </li>
        <li class="depth2_list"><a class="depth2_anchor" href="<%=request.getContextPath() %>/views/mypage/Work/JJIM.jsp" target="_self">찜 목록</a>


        </li>

      </ul>

    </nav>
  </div>
    

    <div id="wrap" class="area" style="position:absolute; margin-left: 5%;"; align="center">
   
        <h1 style="font-weight: 900;">집 예약 내역</h1>
   
      <form style="margin-top: 100px; margin-left: 280px; " >

        <table align="center" id="home">
        <%if(home == null){ %>
         <tr>
            <td class="mainChoice">글 제목</td>
            <td class="content1" rowspan="10" >X 예약 내역이 없습니다.<br> 좋은 집들이 많으니 어서 예약하세요!!</td>
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
          <%}else{ %>
          <tr>
            <td class="mainChoice">글 제목</td>
            <td class="content"><%=title %></td>
          </tr>
          <tr>
            <td class="mainChoice">집 종류</td>
            <td class="content"><%=type %></td>
          </tr>
          <tr>
            <td class="mainChoice">입주 기간</td>
            <td class="content"><%=period %></td>
          </tr>
          <tr>
            <td class="mainChoice">월세</td>
            <td class="content"><%=fee %></td>
          </tr>
          <tr>
            <td class="mainChoice">건물주 이름</td>
            <td class="content"><%=userName %></td>
          </tr>
          <tr>
            <td class="mainChoice">건물주 이메일</td>
            <td class="content"><%=email %></td>
          </tr>
          <tr>
            <td class="mainChoice">건물 주소</td>
            <td class="content"><%=address %></td>
          </tr>
          <tr>
            <td class="mainChoice">편의 시설</td>
            <td class="content">
            
            <%if(essentialItem.charAt(0)=='Y'){ %>
            	essentialItem = "수건, 침대, 식탁  ";
            <%}else{ %>
            	essentialItem = "";
            <%} %>
            
            <%if(wifi.charAt(0)=='Y'){ %>
            	wifi = "wifi ";
            <%}else{ %>
            	wifi = "";
            <%} %>

            <%if(television.charAt(0)=='Y'){ %>
            	television = "TV ";
            <%}else{ %>
            	television = "";
            <%} %>
            
            <%if(heater.charAt(0)=='Y'){ %>
            	heater = "난방 ";
            <%}else{ %>
            	heater = "";
            <%} %>
            
             <%if(airConditional.charAt(0)=='Y'){ %>
            	airConditional = "공기청정기 ";
            <%}else{ %>
            	airConditional = "";
            <%} %>
            </td>
          </tr>
          <tr>
            <td class="mainChoice">공용 공간</td>
            <td class="content">
             <%if(livingroom.charAt(0)=='Y'){ %>
            	livingroom = "거실 ";
            <%}else{ %>
            	livingroom = "";
            <%} %>
            
             <%if(bathroom.charAt(0)=='Y'){ %>
            	bathroom = "화장실 ";
            <%}else{ %>
            	bathroom = "";
            <%} %>
            
            </td>
          </tr>
          <tr>
            <td class="mainChoice">애완동물</td>
            <td class="content">
             <%if(pet.charAt(0)=='Y'){ %>
            	pet = "O";
            <%}else{ %>
            	pet = "--";
            <%} %>
            </td>
          </tr>
          
          <%} %>
        </table>
      </form>
      <br><br>
      
      <button id="homeless" style="width:150px; height:35px; margin-left: 83%;" >예약 취소</button>
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