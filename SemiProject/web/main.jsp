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

    <title>Delivery Management System</title>

    <!-- Bootstrap CSS -->
    <link rel="icon" href="../../favicon.ico">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link href="<%=request.getContextPath()%>/carousel.css" rel="stylesheet">
    <!-- Bootstrap Javascript -->
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script>

    <script src="<%=request.getContextPath()%>/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- Custom styles for this template -->
    <style>
	    body{
	    	width: auto;
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
	.item img{
		width: 960px;
		height: 530px;
	}
	
    </style>
  </head>
  <body>
    <%@include file="views/common/menubar.jsp"%>
    <div id = "content">
        <div id="myCarousel" class="carousel slide z2" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
              <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
              <li data-target="#myCarousel" data-slide-to="1"></li>
              <li data-target="#myCarousel" data-slide-to="2"></li>
              <li data-target="#myCarousel" data-slide-to="3"></li>
              <li data-target="#myCarousel" data-slide-to="4"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="item active">
                <img src="images/country/Australia/OpheraHouse.jpg" alt="First slide">
                <div class="container">
                  <div class="carousel-caption">
                    <h1>호주</h1>
                    <h1>오페라하우스</h1>
                    <hr />
                  </div>
                </div>
                
              </div>
              <div class="item">
                <img src="images/country/Japan/Sakura.jpg" alt="Second slide">
                <div class="container">
                  <div class="carousel-caption">
                    <h1>일본</h1>
                    <h1>벚꽃 성</h1>
                    <hr />
                  </div>
                </div>
              </div>
              <div class="item">
                <img src="images/country/Canada/AgeAgara.jpg" alt="Third slide">
                <div class="container">
                  <div class="carousel-caption">
                    <h1>캐나다</h1>
                    <h1>나이아가라 폭포</h1>
                    <hr />
                  </div>
                </div>
              </div>
              <div class="item">
                <img src="images/country/Germany/Fruit.jpg" alt="Third slide">
                <div class="container">
                  <div class="carousel-caption">
                    <h1>독일</h1>
                    <h1>프랑크 프루트</h1>
                    <hr />
                  </div>
                </div>
              </div>
              <div class="item">
                <img src="images/country/Newzealand/gotohell.jpg" alt="Third slide">
                <div class="container">
                  <div class="carousel-caption">
                    <h1>뉴질랜드</h1>
                    <h1>지옥에나 가라</h1>
                    <hr />
                  </div>
                </div>
              </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
              <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
              <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div><!-- /.carousel -->
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
                  <li><a href="http://www.naver.com">하이하이</a></li>
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
    
    <script>
    	$('.carousel').carousel({ interval: 2000 });
    </script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="<%=request.getContextPath()%>/assets/js/ie10-viewport-bug-workaround.js"></script>
    <!-- <script src="vendor/holder.js"></script> -->
  </body>
</html>