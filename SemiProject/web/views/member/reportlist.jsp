
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, member.model.vo.*, home.model.vo.Pagination"%>

<%
	ArrayList<Report> rplist = (ArrayList<Report>)request.getAttribute("rplist");
 	Pagination pn = (Pagination)request.getAttribute("pn");
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
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
  #warp{
        width: 1200px;
    }
    #leftmenu{
    	float:left;
    	width:250px;
    	height:800px;
    	border-right: 2px solid rgb(113, 177, 197);
    	text-align: center;
    }
    #leftmenu ul{
    	text-align: left;
    	padding-left: 75px;
    	line-height: 55px;
    }
    #leftmenu li{
    	font-size:15px;
    	font-weight: 700;
    	cursor:pointer;
    }
    .font_style{
    	font-size: 25px;
    	font-weight: 900;
    }
    #content{
    	float:left;
    	width:950px;
    	height:800px;
    	padding:120px 0 0 80px;
    }
    #memberTb th{
    	text-align: center;
    	font-size: 16px;
    	height: 30px;
     	
    }
     #memberTb td{
     	height: 45px;
     	
     }
    #table-div{
    	width: 980px;
    }
    #memberTb{
    	width: 980px;
    	
    }
    .pageingBtn button{
    	width: 40px;
    	height: 40px;
    }
    #modal-tb{
	width: 350px;
	margin-left:auto;
	margin-right: auto;
	
	}
	#modal-tb th{
	width:80px;
		text-align: right;
		font-size:15px;
		padding:3px 5px 3px 3px;
		border-bottom: 1px solid gray;
		
	}
	#modal-tb td{
		padding-left: 5px;
		font-size:15px;
		padding:5px;
		text-align: left;
		border-bottom: 1px solid gray;
	}
</style>
</head>
<body>
	<%@include file="../common/menubar.jsp"%>
	<div id="warp">
		<div id="leftmenu">
			<div style="height: 120px;"></div>
			<div class="font_style" onclick="location.href='views/member/test.jsp'">회원 관리</div>
			<div style="height: 50px;"></div>
			<ul>
			<li><div onclick="location.href='<%=request.getContextPath()%>/wselectallmember.me'">워홀러 회원조회</div></li>
			<li><div onclick="location.href='<%=request.getContextPath()%>/nselectallmember.me'">현지인 회원조회</div></li>
			<li><div onclick="location.href='<%=request.getContextPath()%>/reportlist.me'">신고내역</div></li>
			</ul>
		</div>
		
		<div id="content">
			<p style="text-align: left;" class="font_style">신고 내역
			<div id="selectbar" style="height: 30px"></div>
			<div id="table-div">
			<table id="memberTb" border="1">
				<tr>
				
					<th>번호</th>
					<th >게시자</th>
					<th style="width: 120px">카테고리</th>
					<th style="width: 120px">글 확인</th>	
					<th style="width: 230px">처리</th>
					<th>신고자</th>
					
							
				</tr>
				<%if(!rplist.isEmpty()){ %>
					<%
					 for(int i=0;i<rplist.size();i++){
						 String categoryname = "";
						 switch(((member.model.vo.Report)rplist.get(i)).getCategoryno()){
						 case 1: categoryname= "자유게시판"; break;
						 case 2: categoryname= "질문게시판"; break;
						 case 3: categoryname= "벼룩시장"; break;
						 case 4: categoryname= "댓글"; break;
						 case 5: categoryname= "구직글"; break;
						 case 6: categoryname= "구직리뷰"; break;
						 case 7: categoryname= "집 게시글"; break;
						 case 8: categoryname= "집 리뷰"; break;
						 
						 default: break;
						 }
						 
						 String process = ((Report)rplist.get(i)).getProcess();
					%>
					<tr id="rp_tb_tr<%=i%>">
					<td><%=i+1%></td>
					<td><%=((Report)rplist.get(i)).getUploaduser() %></td>
					<td><%=categoryname %></td>
					<td><button>글 확인</button></td>
					 <td><%if(process==null){%>
					 							 		
						 		<button onclick="setSanction('rp_tb_tr<%=i%>','<%=((Report)rplist.get(i)).getUploaduserno()%>','<%=((Report)rplist.get(i)).getReportno()%>','<%=((Report)rplist.get(i)).getCategoryno()%>','<%=((Report)rplist.get(i)).getBoardno() %>');">사용자 정지</button>
					 		
						 		<button onclick="deleteBoard('rp_tb_tr<%=i%>','<%=((Report)rplist.get(i)).getCategoryno()%>','<%=((Report)rplist.get(i)).getBoardno() %>','<%=((Report)rplist.get(i)).getReportno()%>');">게시글 삭제</button>
					 		
					 	<%}else if(process.equals("UR")){ %>
					 			
					 			<span style="color:red; font-weight: 800; margin:0 7px;">사용자 정지</span>					 			
					 			<span style="color:red; font-weight: 800; margin:0 7px;">게시글 삭제</span>
					 		
					 	<%}else if(process.equals("BR")){ %>
					 		
					 			<button onclick="setSanction('rp_tb_tr<%=i%>','<%=((Report)rplist.get(i)).getUploaduserno()%>','<%=((Report)rplist.get(i)).getReportno()%>','<%=((Report)rplist.get(i)).getCategoryno()%>','<%=((Report)rplist.get(i)).getBoardno() %>');">사용자 정지</button>
					 						 		
					 			<span style="color:red; font-weight: 800; margin:0 7px;">게시글 삭제</span>
					 		
					 	<%}%>
					 </td>
					
					<td><%=((Report)rplist.get(i)).getReportuser() %></td>
					</tr>
					<%} %>
				<%} else{ %>
					<tr>
						<td colspan="9">조회결과 없음</td>
					</tr>
				<%} %>
			</table>
			
			<div id="selectbar" style="height: 30px"></div>
			 <div class="pageingBtn">
				<button onclick="location.href='<%=request.getContextPath()%>/reportlist.me?currentPage=1'"><<</button>
				<button onclick="location.href='<%=request.getContextPath()%>/reportlist.me?currentPage=<%=currentPage-1%>'"><</button>
				<%for(int i=startPage; i <=endPage ; i++){ %>
					<button onclick="location.href='<%=request.getContextPath()%>/reportlist.me?currentPage=<%=i%>'"><%=i %></button>
				<%} %>
				<button onclick="location.href='<%=request.getContextPath()%>/reportlist.me?currentPage=<%=currentPage+1%>'">></button>
				<button onclick="location.href='<%=request.getContextPath()%>/reportlist.me?currentPage=<%=maxPage%>'">>></button>
			</div> 
			<div id="selectbar" style="height: 30px"></div>
			
			
			
		</div>
	</div>
	</div>
	<script>
	
		 function setSanction(trId,uploaduserno,reportno,categoryno,boardno){
			var trId = $("#"+trId);
			var td = trId.children();
			
			var userId = td.eq(1).text();
			var process=td.eq(4).text();
			
			
			var resu = confirm(userId+"회원이 정지되고 게시물이 삭제됩니다.");
		
		 	if(resu == true){
		 		
				  $.ajax({
					url:"<%=request.getContextPath()%>/reportsetsanction.me",
					type:"post",
					data:{reportNo:reportno, 
						  userNo:uploaduserno,
						  categoryNo:categoryno,
						  boardNo:boardno,						
					},
					success:function(data){
						if(data == "Y"){
							
							alert("제재완료");
							td.eq(4).html("<span style='color:red; font-weight: 800; margin:0 7px;''>사용자 정지</span><span style='color:red; font-weight: 800; margin:0 7px;''>게시글 삭제</span>");
							
							
						}else{
							alert("실패");
						}
					},
					error:function(request,status,error){
	 	                   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	 	           		}
				}) 
			}
			
			
		}
		function deleteBoard(trId,categoryno,boardno,reportno){
			var trId = $("#"+trId);
			var td = trId.children();
			
			var userId = td.eq(1).text();
			
			
			var resu = confirm(userId+"회원의 글을 삭제하겠습니까?");
			if(resu == true){
				 $.ajax({
						url:"<%=request.getContextPath()%>/deletereportboard.me",
						type:"post",
						data:{categoryNo:categoryno,
							  boardNo:boardno,
							  reportNo:reportno},
						success:function(data){
							if(data == "Y"){
								alert("삭제완료");
								td.eq(4).html("<button>사용자 정지</button><span style='color:red; font-weight: 800; margin:0 7px;''>게시글 삭제</span>");
							}else{
								alert("실패");
							}
						},
						error:function(request,status,error){
		 	                   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		 	           		}
					})  
					
			}
		}
		
		
	</script>

		
	
</body>
</html>