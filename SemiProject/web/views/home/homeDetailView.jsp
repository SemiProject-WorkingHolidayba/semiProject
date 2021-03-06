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
	
	int minP;
	int maxP;
	
	switch(period){
		case "3개월미만" : minP = 1; maxP = 3; break;
		case "3개월이상" : minP = 3; maxP = 6;break;
		case "6개월이상" : minP = 6; maxP = 9;break;
		case "9개월이상" : minP = 9; maxP = 12;break;
		case "1년이상" : minP = 12; break;
	}
	
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

    <title>WorkingThrough</title>

    <!-- Bootstrap CSS -->
    <link rel="icon" href="images/semi.ico">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link href="carousel.css" rel="stylesheet">
    <!-- Bootstrap Javascript -->
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    
    <link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
	<link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">
	<link rel="stylesheet" href="path/to/swiper.min.css">
	
	<script src="https://unpkg.com/swiper/js/swiper.js"></script>
	<script src="https://unpkg.com/swiper/js/swiper.min.js"></script>

    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- Custom styles for this template -->
    <style>
    	#contents{
	        width: 100%;
	        font-family: 'Noto Sans KR', sans-serif;
      	}
      	
      	#photo{
	        display: grid;
	        width: 100%;
	        grid-template-columns: 35% 20% 20%;
	        grid-template-rows: 38% 38%;
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
	      
	    .clickable {cursor: pointer;}
		.hover {text-decoration: underline;}
		.odd{ background: #FFC;}
		.even{ background: #FF9;}
		
		#myImg {

		    cursor: pointer;
		    transition: 0.3s;
		}
		
		#myImg:hover {opacity: 0.7;}
		
		/* The Modal (background) */
		.modal {
		    display: none; /* Hidden by default */
		    position: fixed; /* Stay in place */
		    z-index: 1; /* Sit on top */
		    padding-top: 100px; /* Location of the box */
		    left: 0;
		    top: 0;
		    width: 100%; /* Full width */
		    height: 100%; /* Full height */
		    overflow: auto; /* Enable scroll if needed */
		    background-color: rgb(0,0,0); /* Fallback color */
		    background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
		}
		
		/* Modal Content (Image) */
		.modal-content {
		    margin: auto;
		    display: block;
		    width: 80%;
		    max-width: 700px;
		}
		
		/* Caption of Modal Image (Image Text) - Same Width as the Image */
		#caption {
		    margin: auto;
		    display: block;
		    width: 80%;
		    max-width: 700px;
		    text-align: center;
		    color: #ccc;
		    padding: 10px 0;
		    height: 150px;
		}
		
		/* Add Animation - Zoom in the Modal */
		.modal-content, #caption {
		    -webkit-animation-name: zoom;
		    -webkit-animation-duration: 0.6s;
		    animation-name: zoom;
		    animation-duration: 0.6s;
		}
		
		@-webkit-keyframes zoom {
		    from {-webkit-transform:scale(0)}
		    to {-webkit-transform:scale(1)}
		}
		
		@keyframes zoom {
		    from {transform:scale(0)}
		    to {transform:scale(1)}
		}
		
		/* The Close Button */
		.close {
		    position: absolute;
		    top: 15px;
		    right: 35px;
		    color: white;
		    font-size: 40px;
		    font-weight: bold;
		    transition: 0.3s;
		}
		
		.close:hover,
		.close:focus {
		    color: white;
		    text-decoration: none;
		    cursor: pointer;
		}
		
		/* 100% Image Width on Smaller Screens */
		@media only screen and (max-width: 700px){
		    .modal-content {
		        width: 100%;
		    }
		}
		
		.swiper-container {
	      width: 100%;
	      height: 300px;
	      margin-left: auto;
	      margin-right: auto;
	    }
	
	    .swiper-slide {
	      background-size: cover;
	      background-position: center;
	    }
	
	    .gallery-top {
	      height: 80%;
	      width: 100%;
	    }
	
	    .gallery-thumbs {
	      height: 20%;
	      box-sizing: border-box;
	      padding: 10px 0;
	    }
	
	    .gallery-thumbs .swiper-slide {
	      height: 100%;
	      opacity: 0.4;
	    }
	
	    .gallery-thumbs .swiper-slide-thumb-active {
	      opacity: 1;
	    }
	    
	     #map {

        height: 400px;  /* The height is 400 pixels */

        width: 100%;  /* The width is the width of the web page */

       }

    </style>
  </head>
  <body>
   <%@ include file = "../common/menubar.jsp" %>

    <div id ="contents">
    	<br><br><br><br>
		<div id = "photo">
	      <% if(flist.isEmpty()){ System.out.println("아무것도없음");%>
							
			<%} else{%>
				<%for(int i = 0; i < flist.size(); i++) { 
					Img a = flist.get(i);%>
				        <div class = "item<%=i%>"><img id="myImg" src = "<%=request.getContextPath() %>/home_uploadFiles/<%=a.getSaveImg()%>" onclick = "imageModal()"></div>
				<%} %>
				<!-- The Modal -->
				<div id="myModal" class="modal">
				
				  <!-- The Close Button -->
				  <span class="close" onclick="document.getElementById('myModal').style.display='none'">X</span>
				
				  <!-- Modal Content (The Image) -->
				  <img class="modal-content" id="img01">
				
				  <!-- Modal Caption (Image Text) -->
				  <div id="caption"></div>
				</div>
			<%} %>
		</div>
				
      <div id = "detail_content">
        <div id = "top" >
        	<img style = "width:2%; height:2%; margin-top:-1%" src = "<%=request.getContextPath()%>/images/siren.png" onclick = "reportHome();">
        	<br>
        	<%if(loginUser.getUserNo() == home.getWriterNo()){ %>
        	<button id = "modifyBtn" onclick = "modifyHome();">수정</button>
        	<button id = "deleteBtn" onclick = "deleteHome();">삭제</button>
        	<%} %>
          <h3><b><%=home.getTitle()%></b></h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <div class = "detail">
            <p><%=home.getContent()%></p>
            <p><%=home.getAddress()%></p>
            
		    <div id="map"></div>
		    
		    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
			<script type="text/javascript">
			
			function codeAddress() {

				   var geocoder = new google.maps.Geocoder();
				   
				    var address = <%=home.getAddress()%>;


				    geocoder.geocode( { 'address': address}, function(results, status) {

				      if (status == google.maps.GeocoderStatus.OK) {

				        //alert(results[0].geometry.location.lat());

				        //alert(results[0].geometry.location.lng());

				        document.getElementById("lat").value = results[0].geometry.location.lat();

				        document.getElementById("lng").value = results[0].geometry.location.lng();

				      } else {

				        alert("Geocode was not successful for the following reason: " + status);

				      }

				    });

			</script>
					
		    <script>
				function initMap() {
				  var uluru = {lat: -25.344, lng: 131.036};
				  var map = new google.maps.Map(document.getElementById('map'), {zoom: 4, center: uluru});
				  var marker = new google.maps.Marker({position: uluru, map: map});
				}
			</script>
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
                  <td colspan="3"><button onclick = "reservationHome();">예약하기</button></td>
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
                <% if(period.equals("3개월미만")) {%>
                	<td colspan="2">3개월 미만</td>
                <%} else if(period.equals("3개월이상")){%>
                	<td colspan="2">3개월 이상</td>
                <%} else if(period.equals("6개월이상")) {%> 
                	<td colspan="2">6개월 이상</td>
                <%} else if(period.equals("9개월이상")) {%>
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
          <div name = "review" id = "review" class = "review paginated">
          	<% if(rlist.isEmpty()){ %>
			<%} else{%>
				<%for(int i=0; i<rlist.size(); i++) { int score = rlist.get(i).getScore(); int rWriter = rlist.get(i).getUserNo();%>
					<span class = "writerName" style = "padding-right:1.3%; font-weight:bold"><%=rlist.get(i).getUserName() %></span>
					<span style = "padding-right:1.3%; font-size:0.8em"><%=rlist.get(i).getWriteDate() %></span>
					<img id = "siren" style = "width:1.5%; height:1.5%; margin-right:3%" src = "<%=request.getContextPath()%>/images/siren.png" onclick = "reportReview(<%=rlist.get(i).getReviewNo()%>);">
					<%if(rWriter == loginUser.getUserNo()) {%>
					<img style = "width:1.5%; height:1.5%; margin-right:0.5%;" src = "<%=request.getContextPath()%>/images/update.png" onclick = "location.href = '<%=request.getContextPath()%>/reportReview.ho?reviewNo=<%=rlist.get(i).getReviewNo()%>';">
					<img id = "delete" style = "width:1.5%; height:1.5%;" src = "<%=request.getContextPath()%>/images/delete.png" onclick = "deleteReview(<%=rlist.get(i).getReviewNo()%>,<%=rlist.get(i).getHouseNo()%>);">
					<%} %>
					<br>
					<%for(int j = 0 ; j < score; j++){ %>
						<img src = "<%=request.getContextPath()%>/images/score.png" style = "width:1.5%; height:1.5%">					
					<%} %>
					&nbsp;&nbsp;<%=rlist.get(i).getScore()%>점
					<br>
		            <div style = " width :70%"><%=rlist.get(i).getContent() %></div>
		            <br>
				<%}%>
			<%}%>
       	</div>
      </div>
    </div>

    <div id = "footer" style="margin-bottom: 0;">
      <%@include file="/views/common/bottom.jsp"%>
   </div>
    
    <script>
        $(function(){
        	var price = <%=home.getFee()%>
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
            $("#totalPrice").text(num * price)
          });
          
          $('#increaseQuantity').click(function(e){
            e.preventDefault();
            var stat = $('#numberUpDown').val();
            var num = parseInt(stat,10);
            num++;

            if(num>20){
              alert('더이상 늘릴수 없습니다.');
              num=5;
            }
            $('#numberUpDown').val(num);
            $("#totalPrice").text(num * price)
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
      
      function imageModal(){
    	  $("#myImg").each(function(index){
    		var modal = document.getElementById('myModal');

   	    	var img = document.getElementById('myImg');
   	    	var modalImg = document.getElementById("img01");
   	    	var captionText = document.getElementById("caption");
   	    	img.onclick = function(){
   	    		console.log(this.src);
   	    	    modal.style.display = "block";
   	    	    modalImg.src = this.src;
   	    	    modalImg.alt = this.alt;
   	    	    captionText.innerHTML = this.alt;
   	    	}
   	    	var span = document.getElementsByClassName("close")[0];
   	  	});  
    	   	
      }
      
      
      </script>
		
	<script>
		function reportHome(){
			result = window.confirm("신고하시겠습니까? ");
			
			if(result == true){	
			 location.href = '<%=request.getContextPath()%>/report.ho?hNo=<%=home.gethNo()%>';
			}
		}
		
		function reportReview(rNo){
			$("#siren").each(function(index){
				result = window.confirm("신고하시겠습니까? ");
				if(result == true){	
					 location.href = '<%=request.getContextPath()%>/reportReview.ho?reviewNo='+rNo;
				}
			});
		}
		
		
		function modifyHome(){
			result = window.confirm("수정하시겠습니까? ");
			
			if(result == true){	
				location.href = '<%=request.getContextPath()%>/myHome.ho?hNo=<%=home.gethNo()%>';
			}
		}
		
		function deleteHome(){
			result = window.confirm("삭제하시겠습니까? ");
			if(result == true){	
				location.href = '<%=request.getContextPath()%>/delete.ho?hNo=<%=home.gethNo()%>';
			}
		}
		
		function deleteReview(rNo,hNo){
			$("#delete").each(function(index){
				result = window.confirm("삭제하시겠습니까? ");
				if(result == true){	
					 location.href = '<%=request.getContextPath()%>/deleteReview.ho?reviewNo='+rNo+'&houseNo='+hNo;
				}
			});
		}
		
		function reservationHome(){
			result = window.confirm("예약하시겠습니까? ");
			if(result == true){	
				location.href ='<%=request.getContextPath()%>/reservation.ho?hNo=<%=home.gethNo()%>';
			}
		}
		
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
					
					for(var key in data){
						var $span = $("<span>");
						var $writerTd = $("<span>").text(data[key].userName).css("font-weight","bold").css("padding-right","3%");
						var $dateTd = $("<span>").text(data[key].writeDate).css("font-size","0.8em").css("padding-bottom","5%").css("padding-right","1.3%");
						var $reportTd = $("<img>").attr("src","<%=request.getContextPath()%>/images/siren.png").css("width","1.5%").css("height","1.5%").css("margin-right","3%");					
						var $contentTd = $("<div>").text(data[key].content);

						var score = data[key].score;
						
						$span.append($writerTd);
						$span.append($dateTd);
						$span.append($reportTd);
						
						if(userNo == data[key].userNo){
							$span.append($("<img>").attr("src","<%=request.getContextPath()%>/images/update.png").css("width","1.5%").css("height","1.5%").css("margin-right","0.5%"));
							$span.append($("<img>").attr("src","<%=request.getContextPath()%>/images/delete.png").css("width","1.5%").css("height","1.5%"));
						}
						$span.append("<br>");
			
						for(i=0; i < score; i++){
							$span.append($("<img>").attr("src","<%=request.getContextPath()%>/images/score.png").css("width","1.5%").css("height","1.5%"));
						};
						$span.append("&nbsp;&nbsp;"+data[key].score+"점");
						$span.append("<br>");
						$span.append($contentTd);
						$span.append("<br>");
						
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
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCgzp_Q42ooVecdqVZ34_3OBrwky_bSbik&callback=initMap">

    </script>

  </body>
</html>