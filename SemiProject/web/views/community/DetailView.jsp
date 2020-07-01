 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="community.model.vo.*, java.util.ArrayList"%>
<%
    Community c = (Community)request.getAttribute("community");
       Community1 c1 = (Community1)request.getAttribute("community1");
    CommunityImg ci  =(CommunityImg)request.getAttribute("communityimg");
        ArrayList<Comment> colist = (ArrayList<Comment>)request.getAttribute("colist");
        
        String categoryName = request.getParameter("categoryName");

          
    %>   

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
 
 .tableArea table  {
      border:5px solid #ADD4D9;
      width:800px;
     height:600px;
      margin-left:300px;
      margin-right:auto;
      position:absolute;
            border-bottom:none;
   }
   .tableArea table  td {
   border: 3px solid #ADD4D9;
      border-bottom:none;   
   
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
      color:black;
    
      margin-left:300px;
      border:5px solid #ADD4D9;
      border-top:none;
      margin-top:580px;
      position:absolute;
   }
   .foot{
     margin-left:auto;
     text-align:center;

   }
   #replySelectArea td {
   border: 3px solid #ADD4D9;
   
   }
   </style>
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    </head>
 <body>
 <%@ include file="../common/menubar.jsp" %>
  <div id="wrap">
    <div style=" float: left; border-right: 2px solid rgb(113, 177, 197); height: 500px; padding:0 80px;">
        <p style="margin-top: 50%; font-size: 30px; font-weight: 800;color:#ADD4D9";>카테고리</p>
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

    
    <div class= "wrap">
    <Br>
    <br>
   
      <h1 Style="color:#ADD4D9; font-weight:600; font-size:50px;"><b>상세 글보기 </b></h1>
 
<form>
<div class = "tableArea" style =" margin-right :500px; text-align:center ; "   >
   <table  style="font-size: 22px;" >
      
      <tr>   
         <td colspan="10" style = "font-size:30px;" ><%=c.getTitle() %></td>
      </tr>
      <tr>

      <td colspan="3"><%=c.getCountry() %></td>   
      <td colspan="3"><%=c.getUserId() %></td>
      
      <td colspan="3"><%=c.getWriteDate() %></td>
      <td colspan="1"><%=c.getViewCount() %></td>
      </tr>
      <tr align="center">
      
       <td colspan="3" style ="border-right:0; "><img src = "<%=request.getContextPath() %>/community_uploadFiles/<%=ci.getChangeName()%>"width="300px" height="300px"></td>
      <td colspan="7" style= " border-left : none; width:900px; overflow:scroll;"><p id ="content"> <%=c.getContent() %> </p></td>
      
      
      </tr>
   
      
      <tr align="center">
               <td colspan="10">
               <%if(loginUser.getUserNo() == c1.getUserNo()) {%>
               <input type ="button" id="modifyBtn" value="수정하기 " class = "btn btn-info">
            <input type="button" id= "delBtn" value="삭제하기" class = "btn btn-info" >
      <%} %>
      <img src = "<%=request.getContextPath() %>/report.png" style= " cursor:pointer; width:60px; height:30px;" onclick= "reportCommunity();"></td>
      </tr>
      </table>
      </div>
</form>
   
            <script>
      function reportCommunity(){
         result = window.confirm("신고하시겠습니까? ");
         
         if(result == true){   
          location.href = '<%=request.getContextPath()%>/report.bo?communityno=<%=c.getCommunityNo()%>';
         }
      }
            
         
    </script>

  <br>
 

  <div class = "replyArea" >
         <div class ="replyWriterArea" align="center">
         <table>
         <tr style= "margin-left : 300px;">
         <td ><img src = "<%=request.getContextPath() %>/reply.png" style= "width:70px; height:50px;"></td>
         <td><textArea rows="3" cols="80" id = "replyContent"></textArea></td>
         <td></td>
         <td>
            <img src = "<%=request.getContextPath() %>/write.png" style= "width:60px; height:30px;cursor:pointer;"  id= "addReply" >
            
            </td>
            </tr>
            </table>
            </div>
            <!-- 1.불러온 댓글 리스트 보여주기 -->
            <div id ="replySelectArea">
               <table id ="replySelectTable" style=" border:5px solid #ADD4D9;" align="center" >
                  <%if(colist.isEmpty()){ %>
                     <tr><td colspan="3">댓글이 없습니다</td></tr>                  
                  <%}else{ %>
                     <%for(int i=0 ; i<colist.size() ; i++){ %>
                     <tr>
                        <td width="100px"><%=colist.get(i).getUserName()%></td>
                        <td width="400px"><%=colist.get(i).getContent() %></td>
                        <td width ="200px"><%=colist.get(i).getWriteDate()%>
                           <%if(loginUser.getUserNo() == c1.getUserNo()) {%>
               <img id = "delete" style = " cursor:pointer; width:30px; height:15px;" src = "<%=request.getContextPath()%>/delete.png" onclick = "location.href = '<%=request.getContextPath()%>/deleteComment.bo?commentNo=<%=colist.get(i).getCommentNo()%>'"></td>
                     </tr>
                     <%} %>
                  <%} %>
                  <%} %>
               </table>
      
            </div>
      </div>
      
      </div>
   
      <script> //댓글ㄷ ㅡㅇ록 버튼을 누르고 실행할 ajax코드 작성하기
      $(function(){
            $("#addReply").click(function(){
               var userno = <%=loginUser.getUserNo()%>;
               var communityno = <%=c.getCommunityNo()%>;
               var content=$("#replyContent").val();
               
               $.ajax({
                  url:"<%=request.getContextPath()%>/comment.bo",
                  type:"post",
                  data:{userno:userno, content:content, communityno:communityno},
                  success:function(data){
                     $replyTable = $("#replySelectTable");
                     $replyTable.html("");   // 기존의 댓글을 삭제
                     
                     // 새로 받아온 갱신 된 댓글리스트들을 for 문을 통해 다시 table에 추가
                     for(var key in data){
                        var $tr = $("<tr>");
                        var $writerTd = $("<td>").text(data[key].userName).css("width","100px");
                        var $contentTd = $("<td>").text(data[key].content).css("width","400px");
                        var $dateTd = $("<td>").text(data[key].writeDate).css("width","100px");
                        
                        $tr.append($writerTd);
                        $tr.append($contentTd);
                        $tr.append($dateTd);
                        $replyTable.append($tr);
                     
                     }
                     // 댓글 작성 부분 기존 입력값 삭제
                     $("#replyContent").text("");
                  },
                  error:function(request,status,error){
                            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                        }
                  
               })
               // InsertReplyServlet 만들러 가자
            })
         })

      </script>
  <script>
$(function(){
   $("#delBtn").click(function(){
      location.href='<%=request.getContextPath()%>/delete.bo?communityno=<%=c.getCommunityNo() %>&categoryName=<%=categoryName%>';
   })   
})

$(function(){
   $("#modifyBtn").click(function(){
      location.href='<%=request.getContextPath()%>/modify.bo?communityno=<%=c.getCommunityNo() %>';
   })
})

</script>
  
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
   <br>
   <br>
   <br>
   <br>
   <br>
     <br>
   <br>
   <br>
   <br>
   <br>
     <br>
   <br>
   <br>
   <br>
   <br>
     <br>
   <br>
   <br>
   <br>
   <br>
     <br>
   <br>
   <br>
   <br>
   <br>
     <br>
   <br>
   <br>
   <br>
   <br>
     <br>
   <br>
   <br>
   <br>
   <br>
     <br>
 <Br>
 <br>
 <br>
 <br>
 <br>
 
   
 <div style="margin-left:170px;"> <%@ include file="../common/bottom.jsp" %> </div>
     </body>
</html>