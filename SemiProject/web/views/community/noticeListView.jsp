<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="community.model.vo.*, java.util.ArrayList ,member.model.vo.*"%>
<%
ArrayList list = (ArrayList)request.getAttribute("list");   
Pagination pn = (Pagination)request.getAttribute("pn");
   

   int listCount = pn.getListCount();
   int currentPage = pn.getCurrentPage();
   int maxPage = pn.getMaxPage();
   int startPage = pn.getStartPage();
   int endPage = pn.getEndPage();

%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 
    </head>
 <body>
 <%@ include file="../common/menubar.jsp" %>
  <div id="wrap">
        <div style=" float: left; border-right: 2px solid rgb(113, 177, 197); height: 500px; padding:0 80px;">
        <p style="margin-top: 50%; font-size: 30px; font-weight: 800;color:#ADD4D9">카테고리</p>
        <br>
        <br>
        <br>
        <div style="line-height: 250%; font-weight:bold; font-size: 20px;">
            <p style="font-size: 18px; float: left; "><a onclick ="goNotice('공지사항');">공지사항</a></p><br>
            <p  style="font-size: 18px; float: left;"><a onclick ="goFree('자유게시판');">자유게시판</a></p><br>
            <p  style="font-size: 18px; float: left;"><a onclick ="goQuestion('질문게시판');">질문게시판</a></p><br>
            <p style="font-size: 18px; float: left;"><a onclick ="goMarket('벼룩시장');">벼룩시장</a></p><br>   
        </div>
    </div>
   <script>
   function goFree(category){
      
   location.href="<%=request.getContextPath() %>/free.bo?categoryName="+category;
   }
   function goNotice(category){
    
      location.href="<%=request.getContextPath() %>/list.bo?categoryName="+category;
      }
  function goQuestion(category){
      
      location.href="<%=request.getContextPath() %>/question.bo?categoryName="+category;
      }
  function goMarket(category){
      
      location.href="<%=request.getContextPath() %>/market.bo?categoryName="+category;
      }
   </script>
   <br>
   <br>
      <h1 Style="color:#ADD4D9; font-weight:600; font-size:50px;">공지사항 </b> </h1>
  
  <div id="wrap">
  <table class ="table table-hover" id="listArea" style="width:70%">
    <tr>
    <th><span>국가</span></th>

    <th><span>글 제목</span></th>
    <th><span>작성자</span></th>
    <th><span >작성일</span></th>
    <th><span>조회 수</span></th>
    
    </tr>




    <%if(list.isEmpty()){ %>
    <tr>
    <td colspan="6">조회된 리스트가 없습니다.</td>
    </tr>
    <%}else{ %>
    <%for(int i=0; i<list.size(); i++){ %>

       <tr style = "cursor: pointer;">
          <input type="hidden" value="<%= ((Community)list.get(i)).getCommunityNo()%>">
       <td><%=((Community)list.get(i)).getCountry() %></td>
       <td><%=((Community)list.get(i)).getTitle()%>   
       
       <%if(((Community)list.get(i)).getViewCount() >20) {%>
       <img src = "<%=request.getContextPath() %>/hot.png" style= "width:60px; height:30px;"></td>
       
       <%} %>
       </td>
       <td><%=((Community)list.get(i)).getUserId() %></td>
       <td><%=((Community)list.get(i)).getWriteDate() %></td>
       
       <td><%=((Community)list.get(i)).getViewCount() %></td>
        </tr>
       
       <%} %>
       <%} %>    
   
    </table>
    
  </div>

  <%if(loginUser.getGrade() ==1){ %>
  <img src = "<%=request.getContextPath() %>/write.png" style= "width:60px; height:30px; margin-left:1000px; margin-top:40px; position:absolute; cursor:pointer;" onclick="location.href='views/community/communityInsertForm.jsp'   ">
      <%} else {%>
  <img src = "<%=request.getContextPath() %>/write.png" style= "width:60px; height:30px; margin-left:1000px; margin-top:50px; position:absolute; cursor:pointer;" onclick="alert1();">
         
         <script>
      
         function alert1() {
         alert ('관리자만 등록가능합니다');   
      }
      
   
      
         </script>
         
         
         
         <% }%>
  <form action ="<%=request.getContextPath()%>/search.bo">
  <div class ="center-block" style=width:200px>

  <select name="selectbox" id = "category" style = "margin-bottom:20px; height:30px; ">
      <option value="none">=== 구분 ===</option>
      <option value="title" >글제목</option>
      <option value="tcontent">제목+내용</option>
      <option value="content">글 내용</option>
      <option value="nation">국가</option>

      
    </select>
 
     <input type="search" class="pull-left"  style= "height:30px;"name = "searchbox">
  </div> 
  <a class = "btn btn-info"style= "height:30px;" onclick = "search();" >검색</a>
  </form>
<script>
function search(){
      
      location.href="<%=request.getContextPath() %>/search.bo";
      }
</script>
</div> 
</div >
      <!-- 페이징 처리 시작! -->
      <div class="pagingArea" style="margin-left: 550px; margin-top:30px;">
         <!-- 맨 처음으로(<<) -->
         <button onclick="location.href='<%=request.getContextPath() %>/list.bo?currentPage=<%=currentPage=1 %>&categoryName=공지사항'"> << </button>
         <!-- 이전 페이지로(<) -->
         <button onclick="location.href='<%=request.getContextPath() %>/list.bo?currentPage=<%=currentPage-1 %>&categoryName=공지사항'"> < </button>
         <!-- 10개의 페이지 목록 -->
         <% for(int p = startPage ; p <= endPage ; p ++) {%>
            <%if(p == currentPage) {%>
               <button disabled><%=p %></button>
            <%}else{ %>
               <button onclick="location.href='<%=request.getContextPath() %>/list.bo?currentPage=<%=p %>&categoryName=공지사항'"><%=p %></button>
            <%} %>
         <% } %>
         
         <!-- 다음 페이지로(>) -->
         <button onclick="location.href='<%=request.getContextPath() %>/list.bo?currentPage=<%=currentPage+1 %>&categoryName=공지사항'"> > </button>
         <!-- 맨 끝으로(>>) -->
         <button onclick="location.href='<%=request.getContextPath() %>/list.bo?currentPage=<%=maxPage %>&categoryName=공지사항'"> >> </button>
      </div>
  <script>
   // 게시판 상세보기 기능을 만들어 보자
   $(function(){
      $("#listArea td").click(function(){
         var communityno = $(this).parent().children("input").val();
         

         location.href="<%=request.getContextPath()%>/Detail.bo?communityno=" + communityno + "&categoryName=공지사항";
      
      });
   })
   </script>
  


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    


    <!-- Bootstrap core JavaScript-->

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assetsjs/ie10-viewport-bug-workaround.js"></script>
    <!-- <script src="vendor/holder.js"></script> -->
     <%@ include file="../common/bottom.jsp" %>
  </body>
</html>