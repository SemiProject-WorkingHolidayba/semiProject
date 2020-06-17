<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	  #registFrame{
          margin-left:25%;
          margin-right: 25%;
      }

      h3{
          margin-left: 2%;
      }

      table{
        margin-left: 2%;
        margin-top: 3%;
      }

      input, textarea{
        margin-left: 1%;
        margin-bottom:2% !important;
        margin-top:2% !important;
      }


      #category, #nation{
        margin-bottom: 1%;
      }

      #registBtn{
          width:20%;
          padding:1% 0%;
          border:1px solid lightgray;
          border-bottom-left-radius: 0.3em;
          border-bottom-right-radius: 0.3em;
          border-top-right-radius: 0.3em;
          border-top-left-radius: 0.3em;
          margin-bottom: 5%;
      }

      .select input{
            display:none;
            margin:1%;
        }

        .select label{
            display: inline-block;
            margin:1%;
            padding:1% 1%;
            background:#f5f5f5;
            border:1px solid #ccc;
            width:auto;
            text-align: center;
        }

         .select input:checked + label{
            background-image:none;
            background-color:#3598dc !important;
            color:#fff;
        }
        
        #title{
            width:70%;
        }
        
        #coname{
            width:70%;
        }
        
        #address{
            width:100%;
        }
        
        

        #num{
            width:10%;
        }

        #gender label{
            margin:0% 1%;
        }
        #age label{
            margin:0% 1%;
        }
        #age input[type='number']{
            width:12%;
        }
        textarea{
            width:100%;
            height: auto;
        }
</style>

</head>
<body>
	<%@include file="../../views/common/menubar.jsp" %>

    <div id='registFrame'>
        <h3>· 구직 등록</h3>
        <form action='<%=request.getContextPath() %>/jobRegist.bo' method='post' encType='multipart/form-data'>
        <table>
            <tr>
                <td style='width:10%;'>제목</td>
                <td><input id='title' type="text" name='title' placeholder="내용을 입력해주세요."></td>
            </tr>
            <tr>
                <td>나라</td>
                <td>
                    <div id='nation' class='select'>
                        <input type='radio' id='aus' name='nation' value='N1'><label for='aus'>호주</label>
                        <input type='radio' id='nz' name='nation' value='N4'><label for='nz'>뉴질랜드</label>
                        <input type='radio' id='cnd' name='nation' value='N3'><label for='cnd'>캐나다</label>
                        <input type='radio' id='gm' name='nation' value='N5'><label for='gm'>독일</label>
                        <input type='radio' id='jp' name='nation' value='N2'><label for='jp'>일본</label>
                    </div>
                </td>
            </tr>
            <tr>
            	<td style='vertical-align: top;'><div style='margin-top:20%;'>기업명</div></td>
            	<td>
            		<input id='coname' type='text' name='coname' placeholder="내용을 입력해주세요.">
            	</td>
            </tr>
            <tr>
                <td style='vertical-align: top;'><div style='margin-top:20%;'>직종</div></td>
                <td>
                    <div id='category' class='select'>
                        <input type='radio' id='c1' name='jobCategory' value='외식·음료'><label for='c1'> 외식·음료</label>
                        <input type='radio' id='c2' name='jobCategory' value='유통·판매'><label for='c2'>유통·판매</label>
                        <input type='radio' id='c3' name='jobCategory' value='문화·여가생활'><label for='c3'>문화·여가생활</label>
                        <input type='radio' id='c4' name='jobCategory' value='서비스'><label for='c4'>서비스</label>
                        <input type='radio' id='c5' name='jobCategory' value='사무직'><label for='c5'>사무직</label>
                        <input type='radio' id='c6' name='jobCategory' value='고객상담·리서치·영업'><label for='c6'>고객상담·리서치·영업</label>
                        <input type='radio' id='c7' name='jobCategory' value='생산·건설·노무'><label for='c7'>생산·건설·노무</label>
                        <input type='radio' id='c8' name='jobCategory' value='IT·컴퓨터'><label for='c8'>IT·컴퓨터</label>
                        <input type='radio' id='c9' name='jobCategory' value='교육·강사'><label for='c9'>교육·강사</label>
                        <input type='radio' id='c10' name='jobCategory' value='디자인'><label for='c10'>디자인</label>
                        <input type='radio' id='c11' name='jobCategory' value='미디어'><label for='c11'>미디어</label>
                        <input type='radio' id='c12' name='jobCategory' value='운전·배달'><label for='c12'>운전·배달</label>
                        <input type='radio' id='c13' name='jobCategory' value='병원·간호·연구'><label for='c13'>병원·간호·연구</label>
                        <input type='radio' id='c14' name='jobCategory' value='기타'><label for='c14'>기타</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td style='vertical-align: top;'><div style='margin-top:20%;'>기간</div></td>
                <td>
                    <div id='term' class='select'>
                        <input type='radio' id='term1' name='period' value='3개월 미만'><label for='term1'>3개월 미만</label>
                        <input type='radio' id='term2' name='period' value='3개월 이상'><label for='term2'>3개월 이상</label>
                        <input type='radio' id='term3' name='period' value='6개월 이상'><label for='term3'>6개월 이상</label>
                        <input type='radio' id='term4' name='period' value='9개월 이상'><label for='term4'>9개월 이상</label>
                        <input type='radio' id='term5' name='period' value='1년 이상'><label for='term5'>1년 이상</label>
                        <br>
                        <input type='radio' id='week1' name='workday' value='주중'><label for='week1'>주중</label>
                        <input type='radio' id='week2' name='workday' value='주말'><label for='week2'>주말</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input id='address' type="text" name="address" placeholder="내용을 입력해주세요."></td>
            </tr>
            <tr>
                <td>모집인원</td>
                <td><input id='num' type='number' name="recruitment" value='0'></td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <div id='gender'>
                        <label><input type='radio' name='gender' value='M'>남</label>
                        <label><input type='radio' name='gender' value='W'>여</label>
                        <label><input type='radio' name='gender' value='N'>무관</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>시급</td>
                <td><input type="text" name='pay' placeholder="내용을 입력해주세요."></td>
            </tr>
            <tr>
                <td>연령</td>
                <td>
                    <div id='age'>
                        <!-- <label><input type='radio' name='age' value='N'>무관</label> -->
                        <!-- <label><input type='radio' name='age' value='직접입력'>직접입력</label> -->
                        <input type='number' name='age' placeholder="직접입력">세 이상
                    </div>
                </td>
            </tr>
            <tr>
                <td>마감일</td>
                <td><input type='date' name='dueDate'></td>
            </tr>
            <tr>
                <td>근무시간</td>
                <td>
                    <input type='time' name='worktime'>
                    ~
                    <input type='time' name='worktime'>
                </td>
            </tr>
            <tr>
                <td>사진등록</td>
                <td><input type='file' name='logoImg'></td>
            </tr>
            <tr>
                <td>상세내용</td>
                <td>
                    <textarea rows='5' name='content' style='resize:none;'>
학력 : 
<br>우대 : 
<br>고용형태 : </textarea>
                </td>
            </tr>
        </table>
        <div align='center'>
            <button id='registBtn' type='submit'>등록하기</button>
        </div>
        </form>
    </div>  


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="assetsjs/ie10-viewport-bug-workaround.js"></script>
    <!-- <script src="vendor/holder.js"></script> -->
  </body>
</html>