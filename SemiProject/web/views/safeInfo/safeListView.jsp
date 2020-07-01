<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="safeInfo.model.vo.*, java.util.ArrayList"%>
<%
	Pagination pn = (Pagination)request.getAttribute("pn");
	ArrayList list = (ArrayList)request.getAttribute("list");

	int listCount = pn.getListCount();
	int currentPage = pn.getCurrentPage();
	int maxPage = pn.getMaxPage();
	int startPage = pn.getStartPage();
	int endPage = pn.getEndPage();
	
	String country="";

%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>WorkingThrough</title>

    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <style>
    	#register_btn{
    		position:fixed;
    		margin-left:25%;
    	}
    </style>
 </head>
 <body>
	 <%@ include file="../common/menubar.jsp" %>
	 <br><br><br><br><br>
	  <h1 style="color:#CECECE; font-weight:600; font-size:30px; padding-left:10%;">안전정보</h1>
	  <br><br>
	  <div id="wrap">
		  <table class ="table table-hover" id="listArea" style="width:80%; margin:0 auto;">
		    <tr>
		    <th><span>국가</span></th>
		    <th><span>글 번호</span></th>
		    <th><span>글 제목</span></th>
		    <th><span>작성자</span></th>
		    <th><span >작성일</span></th>
		    <th><span>조회 수</span></th>
		    </tr>
		    <tr>
		    <%if(list.isEmpty()){ %>
		    <td colspan="6">조회된 리스트가 없습니다.</td>
		    </tr>
		    <%}else{ %>
			    <%for(int i=0; i<list.size(); i++){ %>
			    	<tr style = "cursor: pointer;">
				    	<input type="hidden" value="<%=((Safe)list.get(i)).getSafeNo()%>">
				    	<%
				    		country = ((Safe)list.get(i)).getCountryNo();
				        	switch(country) {
				    	    	case "N1" : country = "호주"; break;
				    	    	case "N2" : country = "일본"; break;
				    	    	case "N3" : country = "캐나다"; break;
				    	    	case "N4" : country = "뉴질랜드"; break;
				    	    	case "N5" : country = "독일"; break;

				    	} %>
				    	<td><%=country %></td>
				    	<td><%=((Safe)list.get(i)).getSafeNo()%></td>
				    	<td><%=((Safe)list.get(i)).getTitle()%> </td>
				    	<td>관리자</td>
				    	<td><%=((Safe)list.get(i)).getWriteDate() %></td>
				    	<td><%=((Safe)list.get(i)).getViewCount() %></td>
			    	 </tr>
			   	<%} %>
		   	<%} %>
		    </table>
			
	  </div>

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
			
			 <%if(loginUser != null) {%>
            	<%if(loginUser.getGrade() == 1) { %>
            	<button onclick="location.href='<%=request.getContextPath()%>/views/safeInfo/safeInsertForm.jsp';" id = "register_btn">등록하기</button>
				<%}%>
            
            <%} %>
			
		</div>
  		<script>
		// 게시판 상세보기 기능을 만들어 보자
		$(function(){
			$("#listArea td").click(function(){
				var sNo = $(this).parent().children("input").val();
				location.href="<%=request.getContextPath()%>/detail.si?sNo=" + sNo;
			});
		})
	</script>

    <!-- Bootstrap core JavaScript-->

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assetsjs/ie10-viewport-bug-workaround.js"></script>
    <!-- <script src="vendor/holder.js"></script> -->
    
  </body>
</html>