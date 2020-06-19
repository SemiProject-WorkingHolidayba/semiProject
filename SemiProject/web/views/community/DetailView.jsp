<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="community.model.vo.*"  import = "java.util.ArrayList" %>
    <% Community c = (Community)request.getAttribute("community");
    	CommunityImg ci  =(CommunityImg)request.getAttribute("communityimg");
    
 %>  
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
 .tableArea table  {
      border:5px solid #ADD4D9;
      width:1200px;
     
      margin-left:auto;
      margin-right:auto;
   }
   .tableArea table  td {
   border: 5px solid #ADD4D9;
   
   }
    #content {
      height:230px;
   }
   #title {
   width:30%;
   }
    .replyArea {
      width:800px;
      /* height:300px; */
      color:white;
      background:black;
      margin-left:auto;
      margin-right:auto;
   }
   .foot{
     margin-left:auto;
     text-align:center;

   }
   </style>
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
    
   
      <h1 Style="color:#ADD4D9; font-weight:600; font-size:50px;">상세 글보기 </b></h1>
  
 <div class = "tableArea" >
	<table >
		
		<tr>	
		<td colspan="6" ><%=c.getTitle() %></td>
		
		
		
		<tr>
		<td><%=c.getCountry() %></td>	
		<td><%=c.getUserId() %></td>
		
		<td><%=c.getWriteDate() %></td>
		<td><%=c.getViewCount() %></td>
	
					

		</tr>
		<tr>
    <td style = border-right : none;><img src = "<%=request.getContextPath() %>/community_uploadFiles/<%=ci.getChangeName()%>"width="900px" height="400px"></td>
		<td style= " border-left : none; width:900px;"><p id ="content"> <%=c.getContent() %> </p></td>
		</tr>
		
		
		</table>
		</div>
    <div id ="foot">
   				<button onclick="location.href='views/community/communityUpdateForm.jsp'">수정하기</button>
			<!-- boardInsertForm.jsp 만들러 가자! -->
		</div>
		</div>
	<div id="fileArea">
					<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="LoadImg(this,1)">
					<input type="file" id="thumbnailImg2" name="thumbnailImg2" onchange="LoadImg(this,2)">
					<input type="file" id="thumbnailImg3" name="thumbnailImg3" onchange="LoadImg(this,3)">
				</div>
				
				<script>
				//input type=file 태그 누른 효과 나게 하기
					$(function(){
						$("#fileArea").hide();
						
						$("#titleImgArea").click(function(){
							$("#thumbnailImg1").click();
						});
						
						$("#contentImgArea1").click(function(){
							$("#thumbnailImg2").click();
						});
						
						$("#contentImgArea2").click(function(){
							$("#thumbnailImg3").click();
						});
						
					})
				//file을 선택하면 이미지를 미리보기 할 수 있게 하는 코드 구현
					function LoadImg(value, num){
						if(value.files && value.files[0]){
							var reader = new FileReader();
							
							reader.onload = function(e){
								switch(num){
									case 1:
										$("#titleImg").attr("src",e.target.result);
									break;
									case 2:
										$("#contentImg1").attr("src",e.target.result);
									break;
									case 3:
										$("#contentImg2").attr("src",e.target.result);
									break;
								}
							}
							reader.readAsDataURL(value.files[0]);
						}
					}
				</script>
				
	
	
		<!-- 페이징 처리 시작! -->
	
    
  </body>
</html>