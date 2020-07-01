<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="community.model.vo.*"
   import="java.util.ArrayList"%>

<% Community c = (Community)request.getAttribute("community");
       CommunityImg ci  =(CommunityImg)request.getAttribute("communityimg");
    int cNo = c.getCommunityNo();
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
header {
   width: 100%;
   font-family: 'Noto Sans KR', sans-serif;
   color: black;
}

.menu {
   background: rgb(113, 177, 197);
}

.nav {
   list-style-type: none;
   margin: 0;
   padding: 0;
   text-align: center;
   height: auto;
   padding-top: 55px;
}

.nav li {
   padding: 0 10px 4px;
   line-height: 40px;
   display: inline-block;
}

.nav>li>a {
   display: block;
   font-weight: 600;
   font-size: 14px;
   color: black;
   text-decoration: none;
}

.nav>li:hover>a {
   background: none;
   color: white;
}

.nav li>ul {
   display: none;
}

.nav li:hover>ul {
   width: 500px;
   position: absolute;
   opacity: 1;
   display: block;
   margin: 5px 0 0 0;
   height: 45px;
   text-align: center;
   background: #ADD4D9;
   right: -5px;
}

.nav li:hover>ul li {
   float: left;
   border: rgb(113, 177, 197);
   margin: 0;
   padding: 0;
   display: inline;
}

.nav li:hover>ul>li>a {
   float: left;
   color: black;
   padding: 0 10px 0 0;
   margin: 0;
   line-height: 45px;
   display: block;
   width: 90px;
}

.login_register {
   list-style-type: none;
   padding: 0;
   margin: 0;
   position: absolute;
   top: 1%;
   right: 5%;
}

.login_register li {
   float: left;
   position: relative;
   padding: 0;
   line-height: 40px;
   padding: 0 10px;
}

.login_register li a {
   display: block;
   font-weight: 600;
   font-size: 14px;
   color: black;
   text-decoration: none;
}
#boardWrite{
   color:#ADD4D9;
   font-weight:600;
   font-size:50px;
   text-align:left;
}
td{
   padding:2px;
}
.btnGroup{
   padding-top:2%;
}
.filetd{
padding-top:5px;
}
.form-title{
width:240px;}

select{
height: 25px;}
</style>

</head>
<body>
<%@include file="../common/menubar.jsp"%>
<div id="wrap" style="width: 70%;">
        <div style=" float: left; border-right: 2px solid rgb(113, 177, 197); height: 500px; padding:0 80px;">
        <p style="margin-top: 50%; font-size: 30px; font-weight: 800;color:#ADD4D9">카테고리</p>
         <br> <br> <br>
         <div style="line-height: 250%; font-weight: bold; font-size: 20px;">
            <p style="font-size: 18px; float: left;">
               <a onclick="goNotice();">공지사항</a>
            </p>
            <br>
            <p style="font-size: 18px; float: left;">
               <a onclick="goFree();">자유게시판</a>
            </p>
            <br>
            <p style="font-size: 18px; float: left;">
               <a onclick="goQuestion();">질문게시판</a>
            </p>
            <br>
            <p style="font-size: 18px; float: left;">
               <a onclick="goMarket();">벼룩시장</a>
            </p>
            <br>
         </div>
      </div>
      </div>
<form action ="<%=request.getContextPath()%>/update.bo"  encType="multipart/form-data" method="post">
<input type = "hidden" name = "cno" value = "<%=c.getCommunityNo() %>">
   <table>
      <tr>
      <br>
      <br>
      
         <th><h1 id="boardWrite">게시글 수정</h1></th>
      </tr>
      <tr>
         <td><label for="category">국가</label>
         <select id="category"  name="country">
            <option value="N1">호주</option>
            <option value="N2">일본</option>
            <option value="N3">캐나다</option>
            <option value="N4">뉴질랜드</option>
            <option value="N5">독일</option>
         </select>
         
         <label for="cate">카테고리</label>
         <select name="categoryName" id="cate">
            <option value="C1">공지사항</option>
            <option value="C2">자유게시판</option>
            <option value="C3">질문게시판</option>
            <option value="C4">벼룩시장</option>
         </select></td>
         
      </tr>
      <tr>
         <td colspan="2"><label>제목&nbsp;</label><input type="text" class="form-title" name="title" id="title" value=<%=c.getTitle() %>></td>   
      </tr>
      <tr>
         <td><label for="content">내용</label><br><input type ="text" name = "content" style="width:800px; height:500px; class="form-control" value = <%=c.getContent() %>></td>   
      </tr>
      <tr>
         
         <td class="filetd"><input type="file" id="img" name="img" ></td>
      </tr>
         
      <tr align="center">
         <td class="btnGroup">
         <input type="submit" id="modifyBtn" class="btn btn-info" value="수정하기">
         <input type="button" id="rewriteBtn" class="btn btn-info" value="다시쓰기">
         <input type="button" class="btn btn-info" id="cancelBtn" value="취소">
         </td>
      </tr>
      
   </table>
</form>
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
   <script>
         
   </script>
 <%@ include file="../common/bottom.jsp" %>
</body>
</html>