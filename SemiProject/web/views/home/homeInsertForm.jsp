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
    <link href="carousel.css" rel="stylesheet">
    <!-- Bootstrap Javascript -->
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>

    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- Custom styles for this template -->
    <style>
       #contents ul{
           position: relative;
           left: 20%;
           margin-top: 4%;
           margin-bottom:2%
       }

       #contents form{
           position: relative;
           left: 25%;
           bottom: 10%;
       }

        #contents td{
            width: 6em;
            height: 4em;
        }

       #contents input{
            padding: 0.8em 0.8em 0.8em 0.8em;
            border: 1px solid rgb(165, 165, 165);
            border-radius: 0.8em;
            font-size: 0.8em;
       }

       table tr:last-child {
         text-align: center;
       }

      .country_option input[type="radio"]{
          display:none;
      }

      .country_option input[type="radio"] + span{
          display:inline-block;
          background:none;
          border:1px solid #dfdfdf;    
          border-radius: 0.4em;
          width: 80px;
          text-align:center;
          height:2.7em;
          line-height:2.7em;
          font-weight:500;
          cursor:pointer;
          margin-right: 0.8em;
          font-size: 0.9em;
      }

      .country_option input[type="radio"]:checked + span{
          border:1px solid #23a3a7;
          background:#23a3a7;
          color:#fff;
      }

      .home_option input[type="radio"]{
          display:none;
      }

      .home_option input[type="radio"] + span{
        display:inline-block;
        background:none;
        border:1px solid #dfdfdf;    
        border-radius: 0.4em;
        width: 80px;
        text-align:center;
        height:2.7em;
        line-height:2.7em;
        font-size: 0.9em;
        font-weight:500;
        cursor:pointer;
        margin-right: 0.8em;
        left: 50%;
      }

      .home_option input[type="radio"]:checked + span{
          border:1px solid #23a3a7;
          background:#23a3a7;
          color:#fff;
      }

      .term_option input[type="radio"]{
          display:none;
      }

      .term_option input[type="radio"] + span{
        display:inline-block;
        background:none;
        border:1px solid #dfdfdf;    
        border-radius: 0.4em;
        width: 80px;
        text-align:center;
        height:2.7em;
        line-height:2.7em;
        font-size: 0.9em;
        font-weight:500;
        cursor:pointer;
        margin-right: 0.8em;
      }

      .term_option input[type="radio"]:checked + span{
          border:1px solid #23a3a7;
          background:#23a3a7;
          color:#fff;
      }

      #submit{
          width: 12%;
          line-height: 2.5em;
          background: rgb(182, 182, 182);
          border: none;
          text-align: center;
          margin: 4% 0;
          color: white;
      }

    </style>
  </head>
  <body>
  	<%@ include file = "../common/menubar.jsp" %>
    <div id = "contents">
        <ul><li><h3><b>집 등록</b></h3></li></ul>
        <form id = "registerForm" action = "<%=request.getContextPath()%>/insert.ho" enctype="multipart/form-data" method = "post">
            <table>
                <tr>
                    <td><b>제목</b></td>
                    <td><input name="title" id = "title" type="text" size = "100" placeholder = "제목을 입력하세요" required></td>
                </tr>
                <tr>
                    <td><b>나라</b></td>
                    <td>
                        <label class="country_option"><input type="radio" name = "country" value="호주"><span>호주</span></label>
                        <label class="country_option"><input type="radio" name = "country" value="일본"><span>일본</span></label>
                        <label class="country_option"><input type="radio" name = "country" value="캐나다"><span>캐나다</span></label>
                        <label class="country_option"><input type="radio" name = "country" value="뉴질랜드"><span>뉴질랜드</span></label>
                        <label class="country_option"><input type="radio" name = "country" value="독일"><span>독일</span></label>
                    </td>
                </tr>
                <tr> 
                    <td><b>집 종류</b></td>
                    <td>
                        <label class="home_option"><input type="radio" name = "home" value="sharehouse"><span>쉐어하우스</span></label>
                        <label class="home_option"><input type="radio" name = "home" value="dormitory"><span>기숙사</span></label>
                        <label class="home_option"><input type="radio" name = "home" value="homestay"><span>홈스테이</span></label>
                        <label class="home_option"><input type="radio" name = "home" value="oneroom"><span>원룸</span></label>
                        <label class="home_option"><input type="radio" name = "home" value="apartment"><span>아파트</span></label>
                    </td>
                </tr>
                <tr>
                    <td><b>기간</b></td>
                    <td>
                        <label class="term_option"><input type="radio" name = "period" value="3개월미만"><span>3개월 미만</span></label>
                        <label class="term_option"><input type="radio" name = "period" value="3개월이상"><span>3개월 이상</span></label>
                        <label class="term_option"><input type="radio" name = "period" value="6개월이상"><span>6개월 이상</span></label>
                        <label class="term_option"><input type="radio" name = "period" value="9개월이상"><span>9개월 이상</span></label>
                        <label class="term_option"><input type="radio" name = "period" value="1년이상"><span>1년 이상</span></label>
                    </td>
                </tr>
                <tr> 
                    <td><b>주소</b></td>
                    <td><input type = text" size = "100" id = "address" placeholder="집 주소를 입력하세요" name = "address" data-validation="required" data-validation-error-msg="주소를 입력해주세요."></td>
                </tr>
                <tr> 
                    <td rowspan="3"><b>편의시설</b></td>
                    <td>
                        <input type = "checkbox" name = "facilities" value = "essentialitem"> 필수품목(수건, 침대 시트, 비누, 화장지, 베개)
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type = "checkbox" name = "facilities" value = "wifi"> 무선인터넷 &nbsp;&nbsp;&nbsp;
                        <input type = "checkbox" name = "facilities" value = "tv"> TV &nbsp;&nbsp;&nbsp;
                        <input type = "checkbox" name = "facilities" value = "heater"> 난방
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type = "checkbox" name = "facilities" value = "aircondition"> 에어컨
                    </td>
                </tr>
                <tr> 
                    <td><b>공용공간</b></td>
                    <td>
                        <input type = "checkbox" name = "share" value = "livingroom"> 거실 &nbsp;&nbsp;&nbsp;
                        <input type = "checkbox" name = "share" value = "diningroom"> 주방 &nbsp;&nbsp;&nbsp;
                        <input type = "checkbox" name = "share" value = "bathroom"> 화장실
                    </td>
                </tr>
                <tr> 
                    <td><b>애완동물</b></td>
                    <td>
                        <input type = "radio" name = "pet" value = "Y"> 유 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type = "radio" name = "pet" value = "N"> 무
                    </td>
                </tr>
                <tr>
                    <td><b>요금</b></td>
                    <td><input type = "number" id = "fee" name = "fee" placeholder = "요금을 입력해주세요" data-validation="required" data-validation-error-msg="요금을 입력해주세요."></td>
                </tr>
                <tr> 
                    <td><b>대표사진</b></td>
                    <td><input type = "file" name = "photo1" id = "photo1"></td>
                </tr>
                <tr> 
                    <td rowspan = "4"><b>상세사진</b></td>
                    <td>
	                    <input type = "file" name = "photo2" id = "photo2">
                    </td>
                </tr>
                <tr>
                	<td><input type = "file" name = "photo3" id = "photo3"></td>
                </tr>
                <tr>
                	<td><input type = "file" name = "photo4" id = "photo4"></td>
                </tr>
                <tr>
                	<td><input type = "file" name = "photo5" id = "photo5"></td>
                </tr>
                <tr>
                    <td><b>상세내용</b></td>
                    <td colspan="2">
                        <textarea cols="80" id = "detail" name="detail" rows="8" style="resize: none;"></textarea>
                    </td>
                </tr>
                <tr>
                  <td colspan="3">
                    <button id = "submit" type="submit" disabled = "true">등록하기</button>
                  </td>
              </tr>
            </table>
        </form>
    </div>

    <div id = "footer">
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2017 Delivery Management System &middot; <a href="#">Privacy</a></p>
    </div>
    
     <!-- 유효성 검사 -->
    <script>
      $(function(){
        $("#registerForm").on('input',function(){
          if($("#title").val() == '' || $("#fee").val() == '' || $("#address").val() == '' || $('input:radio[name=country]').is(':checked') == false
            || $('input:radio[name=home]').is(':checked') == false || $('input:radio[name=period]').is(':checked') == false || $("#photo").val() == ''){
            $("#submit").attr("disabled",true);
          } else{
            $("#submit").attr("disabled",false).attr("cursor","pointer").css("background","rgb(113, 177, 197)"),css("color","black");
          }
        });
      });
      
     
    </script>

    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assetsjs/ie10-viewport-bug-workaround.js"></script>
    <!-- <script src="vendor/holder.js"></script> -->
  </body>
</html>