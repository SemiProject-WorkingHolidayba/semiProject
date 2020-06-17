<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="job.model.vo.*, java.util.ArrayList"%>
<%
	JobPagination pn = (JobPagination)request.getAttribute("pn");
	ArrayList<Job> list=(ArrayList<Job>)request.getAttribute("list");
	
 	int listCount = pn.getListCount();
	int currentPage = pn.getCurrentPage();
	int maxPage = pn.getMaxPage();
	int startPage = pn.getStartPage();
	int endPage = pn.getEndPage();

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#category {
      margin-left: 25%;
      margin-right: 25%;
      padding-left: 7%;
      padding-right: 2%;
      border: 2px solid rgb(149, 199, 214);
      border-top-left-radius: 0.5em;
      border-top-right-radius: 0.5em;
      border-bottom-left-radius: 0.5em;
      border-bottom-right-radius: 0.5em;

      width: 50%;
      /* height: 50%; */
      margin-top: 3%;
      display: inline-block;
    }

    #category table {
      margin-top: 3%;
    }

    #category ul {
      margin: 0;
      padding: 0;
      list-style-type: none;
    }

    #category ul li {
      margin-top: 2%;
      margin-bottom: 2%;
      width: auto;
      height: auto;
    }

    /* 체크박스 디자인 */
    #category input {
      display: none;
      margin: 1%;
    }

    #category input+label {
      display: inline-block;
      margin: 1%;
      padding:1% 3%;
      background: #f5f5f5;
      border: 1px solid #ccc;
      border-bottom-left-radius: 0.7em;
      border-bottom-right-radius: 0.7em;
      border-top-right-radius: 0.7em;
      border-top-left-radius: 0.7em;
      font-size: 13px;
      width: auto;
      text-align: center;
    }

    #category input:checked+label {
      background-image: none;
      background: #3598dc;
      color: #fff;
    }

    #searchJob {
      background: #ADD4D9;
      border: 0.5px solid lightgray;
      border-bottom-left-radius: 0.7em;
      border-bottom-right-radius: 0.7em;
      border-top-right-radius: 0.7em;
      border-top-left-radius: 0.7em;
      margin-top: 2%;
      margin-bottom: 2%;
      margin-left: 43%;
      margin-right: 43%;
      padding:1% 4%;
    }

    /* 게시물 css */
    #postFrame {
      /* border:1px solid black; */
      margin-left: 15%;
      margin-right: 15%;
      margin-top: 3%;
      padding-left: 1%;
      padding-right: 1%;
    }

    .jobPost {
      margin-left: 2%;
      margin-right: 2%;
      margin-top: 2%;
      margin-bottom: 2%;
      padding: 0;
      width: 300px;
      height: auto;
    }

    #jobLogo {
      margin-bottom: 5%;
      width: 100%;
      height: 275px !important;
    }

    .like {
      width: 20%;
      height: 20%;
      margin-right: 2%;
      margin-bottom: 2%;
    }

    /* 페이지 */
    #pageBtn {
      margin-top: 2%;
    }

    #pageBtn>button {
      background: white;
      border: none;
    }

    .jpost {
      display: inline-block;
      margin-top:2%;
      margin-left: 3%;
      border-bottom:0.7px solid gray;
      border-top:0.7px  solid gray;
      box-shadow:3px 3px 3px lightgray;
      width:29%;
      height:400px;
    }
    
     #registBtn{
      margin-top: 3%;
      margin-bottom: 3%;
      width:8%;
      line-height: 2.5em;
      background: rgb(113, 177, 197);
      border:none;
      color:white;
      padding-right: 1%;
      padding-left:1%;
      font-size:1em;
    }
    
    table{
    	margin-right:0;
    }
  </style>


</head>
<body>
	<%@ include file="../../views/common/menubar.jsp" %>
	
	<div id='category'>
    <form method="GET">
      <fieldset>
        <table>
          <tr>
            <td style='width: 10%;'><div style='margin-bottom: 25%;'>나라</div></td>
            <td>
              <div style='margin-bottom: 3%;'>
              <input type="checkbox" id='aus' class='nation' name='nation' value='호주'>
              <label for='aus' style='margin-left:1%;'>호주</label>
              <input type="checkbox" id='nz' class='nation' name='nation' value='뉴질랜드'>
              <label for='nz'>뉴질랜드</label>
              <input type="checkbox" id='cnd' class='nation' name='nation' value='캐나다'>
              <label for='cnd'>캐나다</label>
              <input type="checkbox" id='gm' class='nation' name='nation' value='독일'>
              <label for='gm'>독일</label>
              <input type="checkbox" id='jp' class='nation' name='nation' value='일본'>
              <label for='jp'>일본</label>
            </div>
            </td>
          </tr>
          <tr>
            <td style='margin-right: 5%; vertical-align:top;'><div style='margin-top:20%'>직종</div></td>
            <td>
            <div style='margin-top: 3%;'>
              <input type='checkbox' id='jobCategori1' class='jobCategori' name='jobCategori' value='외식·음료'>
              <label for='jobCategori1' style='margin-left:1%;'>외식·음료</label>
              <input type='checkbox' id='jobCategori2' class='jobCategori' name='jobCategori' value='유통·판매'>
              <label for='jobCategori2'>유통·판매</label>
              <input type='checkbox' id='jobCategori3' class='jobCategori' name='jobCategori' value='문화·여가 생활'>
              <label for='jobCategori3'>문화·여가 생활</label>
              <input type='checkbox' id='jobCategori4' class='jobCategori' name='jobCategori' value='서비스'>
              <label for='jobCategori4'>서비스</label>
              <input type='checkbox' id='jobCategori5' class='jobCategori' name='jobCategori' value='사무직'>
              <label for='jobCategori5'>사무직</label>
              <input type='checkbox' id='jobCategori6' class='jobCategori' name='jobCategori' value='고객상담·리서치·영업'>
              <label for='jobCategori6'>고객상담·리서치·영업</label>
              <input type='checkbox' id='jobCategori7' class='jobCategori' name='jobCategori' value='생산·건설·노무'>
              <label for='jobCategori7'>생산·건설·노무</label>
              <input type='checkbox' id='jobCategori8' class='jobCategori' name='jobCategori' value='IT·컴퓨터'>
              <label for='jobCategori8'>IT·컴퓨터</label>
              <input type='checkbox' id='jobCategori9' class='jobCategori' name='jobCategori' value='교육·강사'>
              <label for='jobCategori9'>교육·강사</label>
              <input type='checkbox' id='jobCategori10' class='jobCategori' name='jobCategori' value='디자인'>
              <label for='jobCategori10'>디자인</label>
              <input type='checkbox' id='jobCategori11' class='jobCategori' name='jobCategori' value='미디어'>
              <label for='jobCategori11'>미디어</label>
              <input type='checkbox' id='jobCategori12' class='jobCategori' name='jobCategori' value='운전·배달'>
              <label for='jobCategori12'>운전·배달</label>
              <input type='checkbox' id='jobCategori13' class='jobCategori' name='jobCategori' value='병원·간호·연구'>
              <label for='jobCategori13'>병원·간호·연구</label>
              <input type='checkbox' id='jobCategori14' class='jobCategori' name='jobCategori' value='기타'>
              <label for='jobCategori14'>기타</label>
            </div>
            </td>
          </tr>
          <tr>
            <td style='margin-right: 5%; vertical-align:top;'><div style='margin-top:50%'>기간</div></td>
            <td>
              <div style='margin-top: 3%;'>
              <input type='checkbox' id='term1' class='term' name='term' value='3개월 미만'>
              <label for='term1' style='margin-left:1%;'>3개월 미만</label>
              <input type='checkbox' id='term2' class='term' name='term' value='3개월 이상'>
              <label for='term2'>3개월 이상</label>
              <input type='checkbox' id='term3' class='term' name='term' value='6개월 이상'>
              <label for='term3'>6개월 이상</label>
              <input type='checkbox' id='term4' class='term' name='term' value='9개월 이상'>
              <label for='term4'>9개월 이상</label>
              <input type='checkbox' id='term5' class='term' name='term' value='1년 이상'>
              <label for='term5'>1년 이상</label><br>

              <input type='checkbox' id='week1' class='week' name='week' value='주중'>
              <label for='week1' style='margin-left:1%;'>주중</label>
              <input type='checkbox' id='week2' class='week' name='week' value='주말'>
              <label for='week2'>주말</label>
              </div>
            </td>
          </tr>
        </table>
        <button id='searchJob' type="submit" align='center' onclick="selectCategory();">검색</button>
      </fieldset>
    </form>
  </div>
  <div style='clear: both;'></div>

  <!-- 직업 게시판-->
  <div id='postFrame'>
    <table id='#listArea'>
    	
     	  <%if(list.isEmpty()){%>
    		<tr>조회된 게시글이 없습니다.</tr>
    	<%}else{ %>
    		<%for(int i=0;i<list.size();i++){ %>
    		<%Job j=list.get(i); %>
      			<tr class="jpost">
        			<div class='jobPost'>
          				<td>
          					<input type="hidden" id='jobNo' value="<%=((Job)list.get(i)).getJobNo() %>">
            				<img src="<%=request.getContextPath() %>/job_uploadFiles/<%=j.getChangeName() %>" id='jobLogo'>
            				<p><%=((Job)list.get(i)).getCoName() %><br>
             			 		<%=((Job)list.get(i)).getTitle() %><br>
           						<img class='like' src='<%=request.getContextPath() %>/images/jobImg/heart-icon_white.png' align='right'>
         					</p>
          				</td>
        			</div>
      			</tr>
      		<%} %>
      	<%} %>  
	
    </table>
    
    <div align='right'>
      <button id='registBtn' onclick="location.href='views/job/jobRegistView.jsp'">작성하기</button>
    </div>
    
  </div>

	<script>
	$(function(){
		$(".jpost td").click(function(){
			var jno = $(this).children($('input')).val();
			alert(jno);
			location.href="<%=request.getContextPath()%>/jobDetail.bo?jobNo="+jno;
		});
	})
	</script>
	

  <!-- 페이지 -->
    <div id='pageBtn' align='center'>
			<!-- 맨 처음으로(<<) -->
			<button onclick="location.href='<%=request.getContextPath() %>/jobList.bo?currentPage=1'"> << </button>
			<!-- 이전 페이지로(<) -->
			<button onclick="location.href='<%=request.getContextPath() %>/jobList.bo?currentPage=<%=currentPage-1 %>'"> < </button>
			<!-- 10개의 페이지 목록 -->
			<% for(int p = startPage ; p <= endPage ; p ++) {%>
				<%if(p == currentPage) {%>
					<button disabled><%=p %></button>
				<%}else{ %>
					<button onclick="location.href='<%=request.getContextPath() %>/jobList.bo?currentPage=<%=p %>'"><%=p %></button>
				<%} %>
			<% } %>
			
			<!-- 다음 페이지로(>) -->
			<button onclick="location.href='<%=request.getContextPath() %>/jobList.bo?currentPage=<%=currentPage+1 %>'"> > </button>
			<!-- 맨 끝으로(>>) -->
			<button onclick="location.href='<%=request.getContextPath() %>/jobList.bo?currentPage=<%=maxPage %>'"> >> </button>
  </div> 

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="assets/js/docs.min.js"></script>
  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <script src="assetsjs/ie10-viewport-bug-workaround.js"></script>
  <!-- <script src="vendor/holder.js"></script> -->
</body>

</html>