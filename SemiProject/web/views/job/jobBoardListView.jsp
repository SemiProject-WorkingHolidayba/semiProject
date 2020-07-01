<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="job.model.vo.*, java.util.ArrayList"%>
<%
   JobPagination pn = (JobPagination)request.getAttribute("pn");
   ArrayList<Job> list=(ArrayList<Job>)request.getAttribute("list");
   ArrayList<Heart> hlist=(ArrayList<Heart>)request.getAttribute("hlist");
   int grade=(int)request.getAttribute("grade");
   
    int listCount = pn.getListCount();
   int currentPage = pn.getCurrentPage();
   int maxPage = pn.getMaxPage();
   int startPage = pn.getStartPage();
   int endPage = pn.getEndPage();

   int[] hArr=new int[hlist.size()];
   for(int i=0; i<hlist.size();i++){
      hArr[i]= hlist.get(i).getJobNo();
   }
   
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
      width:10%;
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
   <br><br><br><br>
<script>
   function selectCategory() {
      var form = document.searchJob;
      
      var nation=null;
      var jobCategory=null;
      var term=null;
      var week=null;
      
      var searchVal;   // 선택된 라디오버튼의 값(value)를 담을 변수
      var find = false; //* 채크되어있는 라디오버튼을 찾았는지 구분하는 변수
      
      nation=form.nation;
      jobCategory=form.jobCategory;
       term=form.term;
       week=form.week;
    
       var url="<%=request.getContextPath()%>/searchJob.bo?";
    
      var nSize = nation.length; // 라디오버튼 수
      
       for (var i=0; i<nSize; i++) {
          if (nation[i].checked == true) { // 만약 체크되어있는 라디오 버튼을 찾았을 경우
             searchVal = nation[i].value;
            find = true; // *구분을 찾았다는걸로(true)로 변환
            console.log(searchVal);      
            url+="nation="+searchVal;
            }
        
          if(find==true){
             url+="&";
             }
           find=false;
           }
    
      var jSize = jobCategory.length;
      for (var i=0; i<jSize; i++) {
         if (jobCategory[i].checked == true) {
            searchVal = jobCategory[i].value;
            find = true;
            console.log(searchVal);      
            url+="jobCategory="+searchVal;
            }
           
           if(find==true){
             url+="&";
              }
           find=false;
           }
    
    var tSize = term.length;
    for (var i=0; i<tSize; i++) {
          if (term[i].checked == true) {
            searchVal = term[i].value;
            find = true;
            console.log(searchVal);      
            url+="term="+searchVal;
           }
           
           if(find==true){
              url+="&";
           }
           find=false;
           
      }
    
    var wSize = week.length;
    for (var i=0; i<wSize; i++) {
          if (week[i].checked == true) {
            searchVal = week[i].value;
            find = true;
            console.log(searchVal);      
            url+="week="+searchVal;
           }
           
          if(find==true){
              url+="&";
           }
           find=false;
           
      }
   
   url=url.slice(0,-1);
   console.log("url = "+url);

   if(url=="<%=request.getContextPath()%>/searchJob.bo?"){
      alert("검색할 카테고리를 선택해주세요.");
      }else{
         location.href=url;
      }
   }
</script>
   
   <div id='category'>
    <form action="" method="post" name='searchJob'>
      <fieldset>
        <table>
          <tr>
            <td style='width: 10%;'><div style='margin-bottom: 25%;'>나라</div></td>
            <td>
              <div style='margin-bottom: 3%;'>
              <input type="checkbox" id='aus' class='nation' name='nation' value='N1'>
              <label for='aus' style='margin-left:1%;'>호주</label>
              <input type="checkbox" id='nz' class='nation' name='nation' value='N4'>
              <label for='nz'>뉴질랜드</label>
              <input type="checkbox" id='cnd' class='nation' name='nation' value='N3'>
              <label for='cnd'>캐나다</label>
              <input type="checkbox" id='gm' class='nation' name='nation' value='N5'>
              <label for='gm'>독일</label>
              <input type="checkbox" id='jp' class='nation' name='nation' value='N2'>
              <label for='jp'>일본</label>
            </div>
            </td>
          </tr>
          <tr>
            <td style='margin-right: 5%; vertical-align:top;'><div style='margin-top:20%'>직종</div></td>
            <td>
            <div style='margin-top: 3%;'>
              <input type='checkbox' id='jobCategory1' class='jobCategory' name='jobCategory' value='외식·음료'>
              <label for='jobCategory1' style='margin-left:1%;'>외식·음료</label>
              <input type='checkbox' id='jobCategory2' class='jobCategory' name='jobCategory' value='유통·판매'>
              <label for='jobCategory2'>유통·판매</label>
              <input type='checkbox' id='jobCategory3' class='jobCategory' name='jobCategory' value='문화·여가 생활'>
              <label for='jobCategory3'>문화·여가 생활</label>
              <input type='checkbox' id='jobCategory4' class='jobCategory' name='jobCategory' value='서비스'>
              <label for='jobCategory4'>서비스</label>
              <input type='checkbox' id='jobCategory5' class='jobCategory' name='jobCategory' value='사무직'>
              <label for='jobCategory5'>사무직</label>
              <input type='checkbox' id='jobCategory6' class='jobCategory' name='jobCategory' value='고객상담·리서치·영업'>
              <label for='jobCategory6'>고객상담·리서치·영업</label>
              <input type='checkbox' id='jobCategory7' class='jobCategory' name='jobCategory' value='생산·건설·노무'>
              <label for='jobCategory7'>생산·건설·노무</label>
              <input type='checkbox' id='jobCategory8' class='jobCategory' name='jobCategory' value='IT·컴퓨터'>
              <label for='jobCategory8'>IT·컴퓨터</label>
              <input type='checkbox' id='jobCategory9' class='jobCategory' name='jobCategory' value='교육·강사'>
              <label for='jobCategory9'>교육·강사</label>
              <input type='checkbox' id='jobCategory10' class='jobCategory' name='jobCategory' value='디자인'>
              <label for='jobCategory10'>디자인</label>
              <input type='checkbox' id='jobCategory11' class='jobCategory' name='jobCategory' value='미디어'>
              <label for='jobCategory11'>미디어</label>
              <input type='checkbox' id='jobCategory12' class='jobCategory' name='jobCategory' value='운전·배달'>
              <label for='jobCategory12'>운전·배달</label>
              <input type='checkbox' id='jobCategory13' class='jobCategory' name='jobCategory' value='병원·간호·연구'>
              <label for='jobCategory13'>병원·간호·연구</label>
              <input type='checkbox' id='jobCategory14' class='jobCategory' name='jobCategory' value='기타'>
              <label for='jobCategory14'>기타</label>
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
        <button id='searchJob' type="button" align='center' onclick="selectCategory();">검색</button>
      </fieldset>
    </form>
  </div>
  <div style='clear: both;'></div>
 

  <!-- 직업 게시판-->
  <div id='postFrame'>
    <table id='#listArea'>
       
          <%if(list.isEmpty()){%>
          <tr>조회된 게시글이 없습니다.</tr>
       <%}else{int f =0; %>
          <%for(int i=0;i<list.size();i++){ %>
          <%Job j=list.get(i); %>
               <tr class="jpost">
                 <div class='jobPost'>
                      <td>
                         <input type="hidden" id='jobNo' value="<%=((Job)list.get(i)).getJobNo() %>">
                        <img src="<%=request.getContextPath() %>/job_uploadFiles/<%=j.getChangeName() %>" id='jobLogo'>
                        <p><%=((Job)list.get(i)).getCoName() %><br>
                             <%=((Job)list.get(i)).getTitle() %><br>
                             <%
                             for(int h=f; h<hlist.size();h++){
                                int hAr = hlist.get(h).getJobNo();
                                
                             
                             %>
                             
                                <%if(((Job)list.get(i)).getJobNo()==hAr) {%>
                                   <img class='like' src='<%=request.getContextPath() %>/images/jobImg/heart-icon_red.png' align='right'>
                                <%   f++; break;
                                }else if(((Job)list.get(i)).getJobNo()!=hAr) {%>
                                   <img class='like' align='right'>
                                <%   break;
                                } %>
                                <!-- jobNo가 다르면 white 한개만 해줘야되는데 여러개나옴 -->
                                
                             <%} %>
                             
                        </p>
                      </td>
                 </div>
               </tr>
            <%} %>
         <%} %>  
   
    </table>
    
    <div align='right'>
      <button id='registBtn'>작성하기</button>
    </div>
    
  </div>

   <script>
   $(function(){
      $(".jpost td").click(function(){
         var jno = $(this).children($('input')).val();
         location.href="<%=request.getContextPath()%>/jobDetail.bo?jobNo="+jno;
      });
   })
   
   $('#registBtn').click(function(){
      if(<%=grade %>!=3){
         alert("워홀러는 구인 게시물을 작성할 수 없습니다.");
      }else{
         location.href='views/job/jobRegistView.jsp'
      }
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