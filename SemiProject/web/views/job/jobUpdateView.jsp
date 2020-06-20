<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="job.model.vo.Job, java.util.Date, java.util.Calendar, java.text.SimpleDateFormat" %>
<%
	Job j=(Job)request.getAttribute("j");

	int jobNo=j.getJobNo();
	String job= j.getJobCategory();
	String period= j.getPeriod();
	String logoImg=j.getLogoImg();
	int recruitment=j.getRecruitment();
	String gender=j.getGender();
	String age=j.getAge();
	String address=j.getAddress();
	String pay=j.getPay();
	String dueDate=j.getDueDate();
	String worktime=j.getWorktime();
	String workday=j.getWorkday();
	String title=j.getTitle();
	String content=j.getContent();
	int jobReport=j.getJobReport();
	String country=j.getCountry();
	String coName=j.getCoName();

	
	// dueDate -> sql Date형 변환
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	String[] strArr = dueDate.split(" ");

	Date dDate = sdf.parse(strArr[0]);
	java.sql.Date sqlDueDate = new java.sql.Date(dDate.getTime());
	
	// radio checked 속성
	String[] cCheckArr= new String[5];
	
	if(country.equals("호주")){
		cCheckArr[0]="checked";
	}else if(country.equals("일본")){
		cCheckArr[1]="checked";
	}else if(country.equals("캐나다")){
		cCheckArr[2]="checked";
	}else if(country.equals("뉴질랜드")){
		cCheckArr[3]="checked";
	}else if(country.equals("독일")){
		cCheckArr[4]="checked";
	}
	
	String[] jCheckArr=new String[14];
	
	if(job .equals("외식·음료")){
		jCheckArr[0]="checked";
    }else if(job.equals("유통·판매")){
    	jCheckArr[1]="checked";
    }else if(job.equals("문화·여가생활")){
    	jCheckArr[2]="checked";
    }else if(job.equals("서비스")){
    	jCheckArr[3]="checked";
    }else if(job.equals("사무직")){
    	jCheckArr[4]="checked";
    }else if(job.equals("고객상담·리서치·영업")){
    	jCheckArr[5]="checked";
    }else if(job.equals("생산·건설·노무")){
    	jCheckArr[6]="checked";
    }else if(job.equals("IT·컴퓨터")){
    	jCheckArr[7]="checked";
	}else if(job.equals("교육·강사")){
		jCheckArr[8]="checked";
    }else if(job.equals("디자인")){
    	jCheckArr[9]="checked";
    }else if(job.equals("미디어")){
    	jCheckArr[10]="checked";
	}else if(job.equals("운전·배달")){
		jCheckArr[11]="checked";
    }else if(job.equals("병원·간호·연구")){
    	jCheckArr[12]="checked";
    }else if(job.equals("기타")){
    	jCheckArr[13]="checked";
	}
	
	String[] pCheckArr=new String[5];
	
	if(period.equals("3개월 미만")){
		pCheckArr[0]="checked";
    }else if(period.equals("3개월 이상")){
    	pCheckArr[1]="checked";
    }else if(period.equals("6개월 이상")){
    	pCheckArr[2]="checked";
    }else if(period.equals("9개월 이상")){
    	pCheckArr[3]="checked";
    }else if(period.equals("1년 이상")){
    	pCheckArr[4]="checked";
    }
	
	String[] wCheckArr=new String[2];
	
	if(workday.equals("주중")){
		wCheckArr[0]="checked";
    }else if(workday.equals("주말")){
    	wCheckArr[1]="checked";
    }
	
	String[] gCheckArr=new String[3];
	
	if(gender.equals("M")){
		gCheckArr[0]="checked";
    }else if(gender.equals("W")){
    	gCheckArr[1]="checked";
    }else if(gender.equals("N")){
    	gCheckArr[2]="checked";
    }
    	
%>

    
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
        <form action='<%=request.getContextPath() %>/jobUpdate.bo' method='post' encType='multipart/form-data'>
        <table>
            <tr>
                <td style='width:10%;'>제목</td>
                <td><input id='title' type="text" name='title' value='<%=title %>'></td>
            </tr>
            <tr>
                <td>나라</td>
                <td>
                    <div id='nation' class='select'>
                        <input type='radio' id='aus' name='nation' value='N1' <%=cCheckArr[0] %>><label for='aus'>호주</label>
                        <input type='radio' id='jp' name='nation' value='N2' <%=cCheckArr[1] %>><label for='jp' >일본</label>
                        <input type='radio' id='cnd' name='nation' value='N3' <%=cCheckArr[2] %>><label for='cnd'>캐나다</label>
                        <input type='radio' id='nz' name='nation' value='N4' <%=cCheckArr[3] %>><label for='nz'>뉴질랜드</label>
                        <input type='radio' id='gm' name='nation' value='N5' <%=cCheckArr[4] %>><label for='gm'>독일</label>
                        
                    </div>
                </td>
            </tr>
            <tr>
            	<td style='vertical-align: top;'><div style='margin-top:20%;'>기업명</div></td>
            	<td>
            		<input id='coname' type='text' name='coname' value="<%=coName %>">
            	</td>
            </tr>
            <tr>
                <td style='vertical-align: top;'><div style='margin-top:20%;'>직종</div></td>
                <td>
                    <div id='category' class='select'>
                        <input type='radio' id='c1' name='jobCategory' value='외식·음료' <%=jCheckArr[0] %>><label for='c1'> 외식·음료</label>
                        <input type='radio' id='c2' name='jobCategory' value='유통·판매' <%=jCheckArr[1] %>><label for='c2'>유통·판매</label>
                        <input type='radio' id='c3' name='jobCategory' value='문화·여가생활' <%=jCheckArr[2] %>><label for='c3'>문화·여가생활</label>
                        <input type='radio' id='c4' name='jobCategory' value='서비스' <%=jCheckArr[3] %>><label for='c4'>서비스</label>
                        <input type='radio' id='c5' name='jobCategory' value='사무직' <%=jCheckArr[4] %>><label for='c5'>사무직</label>
                        <input type='radio' id='c6' name='jobCategory' value='고객상담·리서치·영업' <%=jCheckArr[5] %>><label for='c6'>고객상담·리서치·영업</label>
                        <input type='radio' id='c7' name='jobCategory' value='생산·건설·노무' <%=jCheckArr[6] %>><label for='c7'>생산·건설·노무</label>
                        <input type='radio' id='c8' name='jobCategory' value='IT·컴퓨터' <%=jCheckArr[7] %>><label for='c8'>IT·컴퓨터</label>
                        <input type='radio' id='c9' name='jobCategory' value='교육·강사' <%=jCheckArr[8] %>><label for='c9'>교육·강사</label>
                        <input type='radio' id='c10' name='jobCategory' value='디자인' <%=jCheckArr[9] %>><label for='c10'>디자인</label>
                        <input type='radio' id='c11' name='jobCategory' value='미디어' <%=jCheckArr[10] %>><label for='c11'>미디어</label>
                        <input type='radio' id='c12' name='jobCategory' value='운전·배달' <%=jCheckArr[11] %>><label for='c12'>운전·배달</label>
                        <input type='radio' id='c13' name='jobCategory' value='병원·간호·연구' <%=jCheckArr[12] %>><label for='c13'>병원·간호·연구</label>
                        <input type='radio' id='c14' name='jobCategory' value='기타' <%=jCheckArr[13] %>><label for='c14'>기타</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td style='vertical-align: top;'><div style='margin-top:20%;'>기간</div></td>
                <td>
                    <div id='term' class='select'>
                        <input type='radio' id='term1' name='period' value='3개월 미만' <%=pCheckArr[0] %>><label for='term1'>3개월 미만</label>
                        <input type='radio' id='term2' name='period' value='3개월 이상' <%=pCheckArr[1] %>><label for='term2'>3개월 이상</label>
                        <input type='radio' id='term3' name='period' value='6개월 이상' <%=pCheckArr[2] %>><label for='term3'>6개월 이상</label>
                        <input type='radio' id='term4' name='period' value='9개월 이상' <%=pCheckArr[3] %>><label for='term4'>9개월 이상</label>
                        <input type='radio' id='term5' name='period' value='1년 이상' <%=pCheckArr[4] %>><label for='term5'>1년 이상</label>
                        <br>
                        <input type='radio' id='week1' name='workday' value='주중' <%=wCheckArr[0] %>><label for='week1'>주중</label>
                        <input type='radio' id='week2' name='workday' value='주말' <%=wCheckArr[1] %>><label for='week2'>주말</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>주소</td>
                <td><input id='address' type="text" name="address" value="<%=address %>"></td>
            </tr>
            <tr>
                <td>모집인원</td>
                <td><input id='num' type='number' name="recruitment" value='<%=recruitment %>'></td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <div id='gender'>
                        <label><input type='radio' name='gender' value='M' <%=gCheckArr[0] %>>남</label>
                        <label><input type='radio' name='gender' value='W' <%=gCheckArr[1] %>>여</label>
                        <label><input type='radio' name='gender' value='N' <%=gCheckArr[2] %>>무관</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>시급</td>
                <td><input type="text" name='pay' value="<%=pay %>"></td>
            </tr>
            <tr>
                <td>연령</td>
                <td>
                    <div id='age'>
                        <!-- <label><input type='radio' name='age' value='N'>무관</label> -->
                        <!-- <label><input type='radio' name='age' value='직접입력'>직접입력</label> -->
                        <input type='number' name='age' value="<%=age %>">세 이상
                    </div>
                </td>
            </tr>
            <tr>
                <td>마감일</td>
                <td><input type='date' name='dueDate' value='<%=sqlDueDate %>'></td>
                <script>
<%--                 $("input[type=date]").val(<%=strArr[0] %>); --%>

                </script>
            </tr>
            <tr>
                <td>근무시간</td>
                <td>
                    <input type='time' name='worktime' value='<%=worktime %>'>
                    ~
                    <input type='time' name='worktime'>
                </td>
            </tr>
            <tr>
                <td>사진등록</td>
                <td><input type='file' name='logoImg' value='<%=logoImg%>'></td>
                <script>
                $("input[type=file]").val(<%=logoImg %>);
/*                 input type="file"은 html 스펙에서 보안 때문에 value를 바꿀 수 없는 read only 입니다. */


                </script>
            </tr>
            <tr>
                <td>상세내용</td>
                <td>
                    <textarea rows='5' name='content' style='resize:none;'><%=content %></textarea>
                </td>
            </tr>
            <div style="display:none">
            	<input type='text' value='<%=jobReport %>'>
            </div>
        </table>
        <div align='center'>
            <button id='registBtn' type='submit'>수정하기</button>
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