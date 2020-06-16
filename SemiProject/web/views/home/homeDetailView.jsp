<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "home.model.vo.*, java.util.ArrayList"%>
<%
	Home home = (Home)request.getAttribute("home");
	String period = home.getPeriod();
	String essentialitem = home.getEssentialitem();
	String wifi = home.getWifi();
	String television = home.getTelevision();
	String heater = home.getHeater();
	String airconditional = home.getAirconditional();
	String livingroom = home.getLivingroom();
	String diningroom = home.getDiningroom();
	String bathroom = home.getBathroom();
	String pet = home.getPet();
	
	ArrayList<Img> flist = (ArrayList<Img>)request.getAttribute("flist");
	ArrayList<Review> rlist = (ArrayList<Review>)request.getAttribute("rlist");
	
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

    <title>Delivery Management System</title>

    <!-- Bootstrap CSS -->
    <link rel="icon" href="../../favicon.ico">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link href="carousel.css" rel="stylesheet">
    <!-- Bootstrap Javascript -->
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    

    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- Custom styles for this template -->
    <style>
    	#content{
	        width: 100%;
	        font-family: 'Noto Sans KR', sans-serif;
      	}
      	
      	#photo{
	        display: grid;
	        width: 100%;
	        grid-template-columns: 35% 20% 20%;
	        grid-template-rows: 38% 38%;
	        margin-top: 3em;
	        margin-left: 12em;
	    }
	     #photo img{
	        width: 100%;
	        height: 100%;
	      }
	
	      .item1 {
	        grid-row-start: 1;
	        grid-row-end: 3;
	      }
	
	      #detail_content{
	        margin-left: 17%;
	      }
	
	      .detail{
	        width: 75%;
	      }
	
	      #middle{
	        margin-top: 3%;
	      }
	      
	      #middle img{
	        width: 1.3em;
	        height: 1.3em;
	      }
	      
	      #registerReview{
	        width: 100%;
	        height: 2.5em;
	        background:gray;
	        color: white;
	        border: none;
	        border-radius: 0.4em;
	      }
	
	      #reservation { 
	        position: absolute; 
	        font-size: 0.9em; 
	        background: #eaeaea;
	        width: 18%;
	        height: 30%;
	        right: 1%;
	        textx-align:center;
	      }
	
	      .reservation_detail tr:last-child {
	         text-align: center;
	       }
	
	      #reservation button{
	        width: 70%;
	        line-height: 2.4em;
	        margin-top: 12%;
	        margin-left:15%
	      }
	
	      #contents td{
	    	padding-bottom:3.5%;
	      }
	
	      .reservation_detail{
	        border-spacing:10px;
	        margin-bottom: 5px;
	      }
	
	      #review{
	        width: 100%;
	      }
	      
	      .starRev{
	        width: 110%;
	      }
	
	      .starR{
	        background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
	        background-size: auto 70%;
	        width: 20px;
	        height: 30px;
	        display: inline-block;
	        text-indent: -9999px;
	        cursor: pointer;
	      }
	
	      .starR.on{background-position:0 0;}
	      
	      #modifyBtn{background:rgb(113, 177, 197); border:none; color:white;}
	      #deleteBtn{background:rgb(113, 177, 197); border:none; color:white;}
    </style>
  </head>
  <body>
    <%@ include file = "../common/menubar.jsp" %>
    <div id ="contents">
		<div id = "photo">
	      <% if(flist.isEmpty()){ System.out.println("아무것도없음");%>
							
			<%} else{%>
				<%for(int i = 0; i < flist.size(); i++) { 
					Img a = flist.get(i);%>
				        <div class = "item<%=i%>"><img src = "<%=request.getContextPath() %>/home_uploadFiles/<%=a.getSaveImg()%>"></div>
				<%} %>
			<%} %>
		</div>

      <div id = "detail_content">
        <div id = "top" >
        	<img style = "width:2%; height:2%; margin-top:-1%" src = "<%=request.getContextPath()%>/images/siren.png" onclick = "location.href = '<%=request.getContextPath()%>/report.ho?hNo=<%=home.gethNo()%>';">
        	<br>
        	<%if(loginUser.getUserNo() == home.getWriterNo()){ %>
        	<button id = "modifyBtn" onclick = "location.href = '<%=request.getContextPath()%>/myHome.ho?hNo=<%=home.gethNo()%>';">수정</button>
        	<button id = "deleteBtn" onclick = "location.href = '<%=request.getContextPath()%>/delete.ho?hNo=<%=home.gethNo()%>';">삭제</button>
        	<%} %>
          <h3><b><%=home.getTitle()%></b></h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <div class = "detail">
            <p><%=home.getContent()%></p>
          </div>
        </div>
        <div id = "middle">
            <div id="reservation" style = "position: absolute">
           
              <table class = "reservation_detail">
                <tr> 
                	<br>
                    <td><b>&nbsp;&nbsp;가격  </b></td>
                    <td style="text-align: center;">
                       <span id = "price" width:38px;><%=home.getFee()%></span>
                    </td>
                </tr>
                <tr>
                  <td><b>&nbsp;&nbsp;개월</b></td>
                  <td style="text-align: center;">
                    <div class="number">
                      <a href="#" id="decreaseQuantity"><img src = "<%=request.getContextPath()%>/images/decrease.png" style="width: 18px; height: 18px;"></a>
                      <input type = "number" id = "numberUpDown" value="1" style = "width:38px;"><span> 개월</span>
                      <a href="#" id="increaseQuantity"><img src = "<%=request.getContextPath()%>/images/increase.png" style="width: 18px; height: 18px;"></a>
                    </div>
                  </td>
                </tr>
                <tr><td></td></tr>

                <tr> 
                  <td style="width:70px;"><b>&nbsp;&nbsp;총 가격</b></td>
                  <td style="text-align: center;">
                     <span id = "totalPrice" width:38px;><%=home.getFee()%></span>
                  </td>
                </tr>
                <tr>
                  <td colspan="3"><button onclick = "location.href ='<%=request.getContextPath()%>/reservation.ho?hNo=<%=home.gethNo()%>'">예약하기</button></td>
                </tr>     
              </table>
          </div>
     
          <table id = "detailContent">
            <tr> 
                <td rowspan="3" style="margin-right:30px"><b>편의시설</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <% if(essentialitem.equals("Y")) { %>
                	<td colspan="2">
                    	<p>필수품목(수건, 침대 시트, 비누, 화장지, 베개)</p>
                	</td>
                <%} %>
            </tr>
            <tr>
                <td colspan="2">
                	<% if(wifi.equals("Y")) { %>
                    	<img src = "<%=request.getContextPath()%>/images/wifi.png"> 무선인터넷 &nbsp;&nbsp;
                	<%} %>
                	<% if(television.equals("Y")) { %>
                    	<img src = "<%=request.getContextPath()%>/images/tv.png"> TV &nbsp;&nbsp;&nbsp;
                	<%} %>
                	<% if(heater.equals("Y")) { %>
                    	<img src = "<%=request.getContextPath()%>/images/heater.png"> 난방 &nbsp;&nbsp;
                	<%} %>
                                        
                </td>
            </tr>
            <tr>
                <td colspan="2">
                	<% if(airconditional.equals("Y")) { %>
                    	<img src = "<%=request.getContextPath()%>/images/aircondition.png"> 에어컨 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                	<%} %>
                </td>
            </tr>
            <tr> 
                <td><b>공용공간</b></td>
                <td colspan="2">
                	<% if(livingroom.equals("Y")) { %>
                    	거실 &nbsp;&nbsp;&nbsp;&nbsp;
                	<%} %>
			        <% if(diningroom.equals("Y")) { %>
                    	주방 &nbsp;&nbsp;&nbsp;&nbsp;
                	<%} %>
                	<% if(bathroom.equals("Y")) { %>
                    	화장실
                	<%} %>   
                </td>
            </tr>
            <tr> 
                <td><b>애완동물</b></td>
                <% if(pet.equals("Y")) { %>
                	<td colspan="2">
                    	<img src = "<%=request.getContextPath()%>/images/pet.png">
                	</td>
                <%}%>
            </tr>
            <tr>
                <td><b>기간</b></td>
                <% if(period.equals("3monthless")) {%>
                	<td colspan="2">3개월 미만</td>
                <%} else if(period.equals("3months")){%>
                	<td colspan="2">3개월 이상</td>
                <%} else if(period.equals("6months")) {%> 
                	<td colspan="2">6개월 이상</td>
                <%} else if(period.equals("9months")) {%>
                	<td colspan="2">9개월 이상</td>
                <%} else {%>
                	<td colspan="2">1년 이상</td>
                <%} %>
                
            </tr>
            
            <tr>
                <td rowspan="2"><b>후기</b></td>
                <td colspan="4">
                    <textarea cols="70" name="reviewContent" id = "reviewContent" rows="5" style="resize: none;"></textarea>
                </td>
            </tr>
            <tr>
              <td>
                <div class="starRev">
                  <span class="starR on">별1</span>
                  <span class="starR">별2</span>
                  <span class="starR">별3</span>
                  <span class="starR">별4</span>
                  <span class="starR">별5</span>
                </div>
              </td>          
               <td width = "120px"><button id = "registerReview">확인</button> </td>

           	</tr>
          </table>
          <div name = "review" id = "review">
          	<% if(rlist.isEmpty()){ %>
			<%} else{%>
					<%for(int i=0; i<rlist.size(); i++) { int score = rlist.get(i).getScore();%>	
						<span style = "padding-right:1.3%; font-weight:bold"><%=rlist.get(i).getUserName() %></span>
						<span style = "padding-right:1.3%; font-size:0.8em"><%=rlist.get(i).getWriteDate() %></span>
						<img style = "width:1.5%; height:1.5%;" src = "<%=request.getContextPath()%>/images/siren.png" onclick = "location.href = '<%=request.getContextPath()%>/reportReview.ho?reviewNo=<%=rlist.get(i).getReviewNo()%>';">
						<br>				
						<span style = "padding-right:1.3%; font-size:0.9em">
							<%for(int j = 0 ; j < score; j++){ %>
								<img src = "<%=request.getContextPath()%>/images/score.png" style = "width:1.5%; height 1.5%">					
							<%} %>
							&nbsp;&nbsp;<%=rlist.get(i).getScore()%>점
						</span>
			            <div style = " width :70%"><%=rlist.get(i).getContent() %></div>
			            <br>
					<%}%>
				<%}%>
        </div>
      </div>
    </div>

    <div id = "footer">
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2017 Delivery Management System &middot; <a href="#">Privacy</a></p>
    </div>
    
    <script>
        $(function(){
          $('#decreaseQuantity').click(function(e){
            e.preventDefault();
            var stat = $('#numberUpDown').val();
            var num = parseInt(stat,10);
            num--;
            if(num<=0){
              alert('더이상 줄일수 없습니다.');
              num =1;
             }
            $('#numberUpDown').val(num);
            $("#totalPrice").text("₩ " + num * 190000)
          });
          
          $('#increaseQuantity').click(function(e){
            e.preventDefault();
            var stat = $('#numberUpDown').val();
            var num = parseInt(stat,10);
            num++;

            if(num>30){
              alert('더이상 늘릴수 없습니다.');
              num=5;
            }
            $('#numberUpDown').val(num);
            $("#totalPrice").text("₩ " + num * 190000)
          });
      });
        
      $('.starRev span').click(function(){
         $(this).parent().children('span').removeClass('on');
         $(this).addClass('on').prevAll('span').addClass('on');
         
         return false;
      });

      $(function() {
        var offset = $("#reservation").offset();
        var topPadding = 300;
        $(window).scroll(function() {
          if ($(window).scrollTop() > offset.top) {
            $("#reservation").stop().animate({
              marginTop: $(window).scrollTop() - offset.top + topPadding
            });
          } else {
            $("#reservation").stop().animate({
              marginTop: 0
            });
          };
        });
      });
      
      </script>
		
	<script>
   	  $(function(){
 			$("#registerReview").click(function(){  
				var userNo = <%=loginUser.getUserNo()%>;
				var hNo = <%=home.gethNo()%>;
				var content = $("#reviewContent").val();
				var score = $('.on').length;
		
				$.ajax({
					url:"<%=request.getContextPath()%>/insertReview.ho",
					type:"post",
					data:{userNo:userNo, hNo:hNo, content:content, score:score},
					success:function(data){
						$replyTable = $("#review");
						$replyTable.html("");	
						
						// 새로 받아온 갱신 된 댓글리스트들을 for문을 통해 다시 table에 추가
						for(var key in data){
							var $span = $("<span>");
							var $writerTd = $("<span>").text(data[key].userName).css("font-weight","bold").css("padding-right","3%");
							var $dateTd = $("<span>").text(data[key].writeDate).css("font-size","0.8em").css("padding-bottom","5%").css("padding-right","1.3%");
							var $scoreTd = .text("   " + data[key].score + "점");
							var $reportTd = $("<img>").attr("src","<%=request.getContextPath()%>/images/siren.png").css("width","1.5%").css("height","1.5%");
							var $contentTd = $("<div>").text(data[key].content);
							var $brTd = $("<br>");
							
							var score = data[key].score;
							
							$span.append($writerTd);
							$span.append($dateTd);
							$span.append($reportTd);

							for(i=0; i < score; i++){
								console.log(score);
								console.log(i);
								$span.append($("<img>").attr("src","<%=request.getContextPath()%>/images/score.png"));
							};
							$span.append($scoreTd);
							$span.append($contentTd);
							$span.append($brTd);
							
							$replyTable.append($span);
						}
						// 댓글 작성 부분 기존 입력값 삭제
						$("#reviewContent").val("");
					},
					error:function(request,status,error){
		               	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		            }
				});
 			});
   	  	});
    </script>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assetsjs/ie10-viewport-bug-workaround.js"></script>
    <!-- <script src="vendor/holder.js"></script> -->

  </body>
</html>