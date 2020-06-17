<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, member.model.vo.*, home.model.vo.*"%>
<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
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
			<p style="text-align: left;" class="font_style">워홀러 회원
			<div id="selectbar" style="height: 30px"></div>
			<table id="memberTb" border="1">
				<tr>
					<th style="width: 53px ">번호</th>
					<th>회원번호</th>
					<th style="width: 120px">아이디</th>
					<th style="width: 230px">이메일</th>
					<th style="width: 120px">이름</th>	
					<th style="width: 125px">생년월일</th>
					<th>성별</th>
					<th style="width: 100px">제재</th>
					<th style="width: 100px">탈퇴</th>
							
				</tr>
				<%if(!list.isEmpty()){ %>
				 <% 
				 	
				   for(int i=0;i<list.size();i++){
				   String sanction = ((Member)list.get(i)).getSanction();
				   String status = ((Member)list.get(i)).getStatus();
					   %>
					   		<tr id="tb_tr<%=i %>"  >
							<td><%=((Member)list.get(i)).getTableNo()%></td>
					   <%if(sanction.equals("N") && status.equals("N")){ %>
	
							<td><%=((Member)list.get(i)).getUserNo()%></td>
							<td><%=((Member)list.get(i)).getUserId()%></td>
							<td><%=((Member)list.get(i)).getEmail()%></td>			
							<td><%=((Member)list.get(i)).getUserName()%></td>
							<td><%=((Member)list.get(i)).getUserBirth()%></td>
							<td><%=((Member)list.get(i)).getGender()%></td>
							<td><button type="button" onclick="setSanction('tb_tr<%=i%>');">제재하기</button></td>
							<td><p style="margin:0;"></p>
					   <%} else if(sanction.equals("Y")){%>
					   		<td style="color:rgb(223,102,102);"><%=((Member)list.get(i)).getUserNo()%></td>
							<td style="color:rgb(223,102,102);"><%=((Member)list.get(i)).getUserId()%></td>
							<td style="color:rgb(223,102,102);"><%=((Member)list.get(i)).getEmail()%></td>			
							<td style="color:rgb(223,102,102);"><%=((Member)list.get(i)).getUserName()%></td>
							<td style="color:rgb(223,102,102);"><%=((Member)list.get(i)).getUserBirth()%></td>
							<td style="color:rgb(223,102,102);"><%=((Member)list.get(i)).getGender()%></td>
							<td style="color:rgb(223,102,102);"><p id="gr" style="margin:0;" onclick="NsetSanction('tb_tr<%=i%>');">사용불가</td>
					   		<td style="color:rgb(223,102,102);"><p style="margin:0;">─</p></td>
					   <%} else if(status.equals("Y")){ %>
					   		<td style="color:rgb(160,160,160);"><%=((Member)list.get(i)).getUserNo()%></td>
							<td style="color:rgb(160,160,160);"><%=((Member)list.get(i)).getUserId()%></td>
							<td style="color:rgb(160,160,160);"><%=((Member)list.get(i)).getEmail()%></td>			
							<td style="color:rgb(160,160,160);"><%=((Member)list.get(i)).getUserName()%></td>
							<td style="color:rgb(160,160,160);"><%=((Member)list.get(i)).getUserBirth()%></td>
							<td style="color:rgb(160,160,160);"><%=((Member)list.get(i)).getGender()%></td>
							<td style="color:rgb(160,160,160);"><button type="button" disabled >제재하기</button></td>
							<td style="color:rgb(160,160,160);"><p style="margin:0;">탈퇴 회원</p></td>
							
							
					   <%} %>
				<%} %>
				<%} else{ %>
					<tr>
						<td colspan="9">조회결과 없음</td>
					</tr>
				<%} %>
			</table>
			

			
			
			<div id="selectbar" style="height: 30px"></div>
			 <div class="pageingBtn">
				<button onclick="location.href='<%=request.getContextPath()%>/wselectallmember.me?currentPage=1'"><<</button>
				<button onclick="location.href='<%=request.getContextPath()%>/wselectallmember.me?currentPage=<%=currentPage-1%>'"><</button>
				<%for(int i=startPage; i <=endPage ; i++){ %>
					<button onclick="location.href='<%=request.getContextPath()%>/wselectallmember.me?currentPage=<%=i%>'"><%=i %></button>
				<%} %>
				<button onclick="location.href='<%=request.getContextPath()%>/wselectallmember.me?currentPage=<%=currentPage+1%>'">></button>
				<button onclick="location.href='<%=request.getContextPath()%>/wselectallmember.me?currentPage=<%=maxPage%>'">>></button>
			</div> 
			<div id="selectbar" style="height: 30px"></div>
			
			<script>
				function setSanction(trId1){
					var trId = $("#"+trId1);
					var td = trId.children();
					var no = td.eq(0).text();
					var userno = td.eq(1).text();
					var userid= td.eq(2).text();
					var email= td.eq(3).text();
					var username= td.eq(4).text();
					var birth= td.eq(5).text();
					var gender= td.eq(6).text();
					var sanction= td.eq(7).text();
					var status= td.eq(8).text();
				
					var resu = confirm(userid+" 회원을 사용을 정지하시겠습니까?");
					if(resu == true){
						$.ajax({
							url:"<%=request.getContextPath()%>/setsanction.me",
							type:"post",
							data:{userNo:userno},
							success:function(data){
								if(data == "Y"){
									td.eq(1).css("color","rgb(223,102,102)");
									td.eq(2).css("color","rgb(223,102,102)");
									td.eq(3).css("color","rgb(223,102,102)");
									td.eq(4).css("color","rgb(223,102,102)");
									td.eq(5).css("color","rgb(223,102,102)");
									td.eq(6).css("color","rgb(223,102,102)");
									     
									td.eq(7).html("<p id='gr' style='margin:0;'>사용불가").css("color","rgb(223,102,102)");
									td.eq(8).text("─").css("color","rgb(223,102,102)");
								}
							},
							error:function(request,status,error){
			 	                   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			 	           		}
						})
					}else{
						alert("취소하였습니다.");
					}
				}
				
				function NsetSanction(trId1){
					var trId = $("#"+trId1);
					var td = trId.children();
					var no = td.eq(0).text();
					var userno = td.eq(1).text();
					var userid= td.eq(2).text();
					var email= td.eq(3).text();
					var username= td.eq(4).text();
					var birth= td.eq(5).text();
					var gender= td.eq(6).text();
					var sanction= td.eq(7).text();
					var status= td.eq(8).text();
				
					var resu = confirm(userid+" 회원을 정지를 해지하시겠습니까?");
					if(resu == true){
					
						 $.ajax({
							url:"<%=request.getContextPath()%>/nsetsanction.me",
							type:"post",
							data:{userNo:userno},
							success:function(data){
								if(data == "Y"){
										
										td.eq(1).css("color","black");
										td.eq(2).css("color","black");
										td.eq(3).css("color","black");
										td.eq(4).css("color","black");
										td.eq(5).css("color","black");
										td.eq(6).css("color","black");
										td.eq(7).html("<button type='button'>제재하기</button>").css("color","black");
										td.eq(8).text("");
								}
							},
							error:function(request,status,error){
			 	                   alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			 	           		}
						}) 
					}else{
						alert("취소하였습니다.");
					}
				}
				
			</script>
		</div>
	</div>
</body>
</html>