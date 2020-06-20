<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    	 html,
	    body{
	    	width: 100%;
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
            list-style: none;
            font-weight: 600;
            font-size: 1.05em;
        }

        #nation>li {
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
	      height: 400px;
	
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

<<<<<<< HEAD
=======
        }

>>>>>>> refs/remotes/origin/eunjin1
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
          <div class="z2">
            <div id='nationSelect' align='center' style="margin-bottom: 50px;">
              <ul id='nation'>
                <li>전체</li>
                <li>호주</li>
                <li>뉴질랜드</li>
                <li>캐나다</li>
                <li>독일</li>
                <li>일본</li>
              </ul>
            </div>
          </div>
        
          <div class="container" align="center">
            <!-- Example row of columns -->
            <div class="row">
              <div class="col-md-4">
                <a href = "#">
                    <img src="images/country/Australia/Coala.jpg" width="300px" height="300px">
                    <p style="width: 300px; height: 200px;">Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                </a>
              </div>
              <div class="col-md-4">
                <a href = "#">
                    <img src="images/country/Australia/Coala.jpg" width="300px" height="300px">
                    <p style="width: 300px; height: 200px;">Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                </a>
              </div>
              <div class="col-md-4">
                <a href = "#">
                    <img src="images/country/Australia/Coala.jpg" width="300px" height="300px">
                    <p style="width: 300px; height: 200px;">Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                </a>
              </div>
              <div class="col-md-4">
                <a href = "#">
                    <img src="images/country/Australia/Coala.jpg" width="300px" height="300px">
                    <p style="width: 300px; height: 200px;">Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                </a>
              </div>
              <div class="col-md-4">
                <a href = "#">
                    <img src="images/country/Australia/Coala.jpg" width="300px" height="300px">
                    <p style="width: 300px; height: 200px;">Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                </a>
              </div>
              <div class="col-md-4">
                <a href = "#">
                    <img src="images/country/Australia/Coala.jpg" width="300px" height="300px">
                    <p style="width: 300px; height: 200px;">Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                </a>
              </div>
        
            </div>
        
            <hr>
        
          </div> <!-- /container -->

          <div class="container1 z2" id="information" align="center">
            <div id="area1" class="notice">
                <h3 class = "title">공지사항<small><a href="http://www.naver.com" class = "more">+더보기</a></small></h3>
                <ul class="infor">
                  <li><a href="http://www.naver.com">가나다라마바사가나다라마바사가나다라마바사</a></li>
                  <li><a href="http://www.naver.com">가나다라마바사가나다라마바사가나다라마바사</a></li>
                  <li><a href="http://www.naver.com">가나다라마바사가나다라마바사가나다라마바사</a></li>
                  <li><a href="http://www.naver.com">가나다라마바사가나다라마바사가나다라마바사</a></li>
                  <li><a href="http://www.naver.com">가나다라마바사가나다라마바사가나다라마바사</a></li>
               
                </ul>
            </div>
            <div id="area1" class="safe_information">
              <h3 class = "title">안전정보 <small><a href="http://www.naver.com" class = "more">+더보기</a></small></h3>
              <ul class="infor">
                <li><a href="http://www.naver.com">가나다라마바사가나다라마바사가나다라마바사</a></li>
                <li><a href="http://www.naver.com">가나다라마바사가나다라마바사가나다라마바사</a></li>
                <li><a href="http://www.naver.com">가나다라마바사가나다라마바사가나다라마바사</a></li>
                <li><a href="http://www.naver.com">가나다라마바사가나다라마바사가나다라마바사</a></li>
                <li><a href="http://www.naver.com">가나다라마바사가나다라마바사가나다라마바사</a></li>
               
              </ul>
            </div>
          </div>
    </div>
	<br>
	<br>
	<br>
	<br>
    <div id = "footer">
      <p class="pull-right"><a href="#">Back to top</a></p>
      <hr>
      <p>&copy; 2017 Delivery Management System &middot; <a href="#">Privacy</a></p>
    </div>
<<<<<<< HEAD
    <script>
=======
      <script>
      	$(document).ready(function(){
      		$.ajax({
				url:"<%=request.getContextPath()%>/test.test",
				type:"post",
				data:{userNo:userno},
				success:function(data){
					if(data == "Y"){
						alert("성공");
					}
				},
				error:function(request,status,error){
 	                   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
 	           		}
			})
      	})
      	 
>>>>>>> refs/remotes/origin/eunjin1
          $('.carousel').carousel({ interval: 2000 });
          
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