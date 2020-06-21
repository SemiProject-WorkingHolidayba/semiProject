<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="community.model.vo.*, java.util.ArrayList ,member.model.vo.*"%>
<%
	Pagination pn = (Pagination)request.getAttribute("pn");
	ArrayList list = (ArrayList)request.getAttribute("list");

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

    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    </head>
 <body>
 <%@ include file="../common/menubar.jsp" %>
  <div id="wrap">
    <div style=" float: left; border-right: 2px solid rgb(113, 177, 197); height: 500px; padding:0 80px;">
        <p style="margin-top: 20%z; font-size: 30px; font-weight: 800;color:#ADD4D9";>회원관리</p>
        <br>
        <br>
        <br>
        <div style="line-height: 250%; font-weight:bold; font-size: 20px;">
            <p style="font-size: 18px; float: left; "><a onclick ="goNotice();">공지사항</a></p><br>
            <p  style="font-size: 18px; float: left;"><a onclick ="goFree();">자유게시판</a></p><br>
            <p  style="font-size: 18px; float: left;"><a onclick ="goQuestion();">질문게시판</a></p><br>
            <p style="font-size: 18px; float: left;"><a onclick ="goMarket();">벼룩시장</a></p><br>
        </div>
    </div>
   <script>
   function goFree(){
	   
   location.href="<%=request.getContextPath() %>/free.bo";
   }
   function goNotice(){
	   
	   location.href="<%=request.getContextPath() %>/list.bo";
	   }
  function goQuestion(){
	   
	   location.href="<%=request.getContextPath() %>/question.bo";
	   }
  function goMarket(){
	   
	   location.href="<%=request.getContextPath() %>/market.bo";
	   }
   </script>
      <h1 Style="color:#ADD4D9; font-weight:600; font-size:50px;">질문게시판 </b> </h1>
  
  <div id="wrap">
  <table class ="table table-hover" id="listArea" style="width:80%">
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
    	<%if((i<5)){ %>
    	<img src = "<%=request.getContextPath() %>/new.png" style= "width:60px; height:30px;">
    	<%} %>
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
   <a href="https://icon-library.net/icon/new-icon-gif-20.html"></a>
    </table>
  </div>
  <button onclick="location.href='views/community/communityInsertForm.jsp'" class = "btn btn-info" style = "margin-left:1700px;">작성하기</button>
  <form action ="<%=request.getContextPath()%>/search.bo">
  <div class ="center-block" style=width:200px>
 <a href="https://icon-library.net/icon/new-icon-gif-20.html"></a>
    <select name="language">
      <option value="none"selected>=== 구분 ===</option>
      <option value="newzilland" >글번호</option>
      <option value="german">글 제목</option>
      <option value="japan">작성자</option>

      
    </select>
    


    <select name="language">
      <option value="none"selected>=== 국가 ===</option>
      <option value="newzilland" >뉴질랜드</option>
      <option value="german">독일</option>
      <option value="japan">일본</option>
      <option value="austrailia">호주</option>
      <option value="canada">캐나다</option>
    </select>
 

    <input type="search" class="pull-left">
  </div> 
  <a class = "btn btn-info" onclick = "search();" >검색</a>
  </form>


		


</div> 
</div >
		<!-- 페이징 처리 시작! -->
		<div class="pagingArea" align="center">
			<!-- 맨 처음으로(<<) -->
			<button onclick="location.href='<%=request.getContextPath() %>/list.bo?currentPage=1'"> << </button>
			<!-- 이전 페이지로(<) -->
			<button onclick="location.href='<%=request.getContextPath() %>/list.bo?currentPage=<%=currentPage-1 %>'"> < </button>
			<!-- 10개의 페이지 목록 -->
			<% for(int p = startPage ; p <= endPage ; p ++) {%>
				<%if(p == currentPage) {%>
					<button disabled><%=p %></button>
				<%}else{ %>
					<button onclick="location.href='<%=request.getContextPath() %>/list.bo?currentPage=<%=p %>'"><%=p %></button>
				<%} %>
			<% } %>
			
			<!-- 다음 페이지로(>) -->
			<button onclick="location.href='<%=request.getContextPath() %>/list.bo?currentPage=<%=currentPage+1 %>'"> > </button>
			<!-- 맨 끝으로(>>) -->
			<button onclick="location.href='<%=request.getContextPath() %>/list.bo?currentPage=<%=maxPage %>'"> >> </button>
		</div>
  <script>
	// 게시판 상세보기 기능을 만들어 보자
	$(function(){
		$("#listArea td").click(function(){
			var communityno = $(this).parent().children("input").val();
			alert(communityno);

			location.href="<%=request.getContextPath()%>/Detail.bo?communityno=" + communityno;
		
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
    
  </body>
</html>