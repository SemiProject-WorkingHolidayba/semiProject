<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="community.model.vo.*, java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>WorkingThrough</title>

    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <style>
    	#register_btn{
    		position:relative;
    		
    	}
    </style>
 </head>
 <body>
	 <%@ include file="../common/menubar.jsp" %>
	  <h1 style="color:#ADD4D9; font-weight:600; font-size:40px; text-align:left;">안전정보</h1>
	  
	  <div id="wrap">
		  <table class ="table table-hover" id="listArea" style="width:80%; text-align:center; margin:0 auto;">
		    <tr>
		    <th><span>국가</span></th>
		    <th><span>글 번호</span></th>
		    <th><span>글 제목</span></th>
		    <th><span>작성자</span></th>
		    <th><span >작성일</span></th>
		    <th><span>조회 수</span></th>
		    </tr>
		    <tr>
		    <td colspan="6">조회된 리스트가 없습니다.</td>
		    </tr>
		    	<tr style = "cursor: pointer;">
			    	<input type="hidden" value="">
			    	<td></td>
			    	<td></td>
			    	<td></td>
			    	<td></td>
			    	<td></td>
			    	<td></td>
		    	 </tr>
		    </table>
		    <div class ="center-block" style=width:200px>
				<button onclick="location.href='views/safeInfo/safeInsertForm.jsp'" id = "register_btn">작성하기</button>
			</div> 
	  </div>

		<!-- 페이징 처리 시작! -->
		<%-- <div class="pagingArea" align="center">
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
		</div> --%>
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

    <!-- Bootstrap core JavaScript-->

    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assetsjs/ie10-viewport-bug-workaround.js"></script>
    <!-- <script src="vendor/holder.js"></script> -->
    
  </body>
</html>