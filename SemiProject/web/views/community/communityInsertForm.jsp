<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
   <style>
      header{
        width: 100%;
        font-family: 'Noto Sans KR', sans-serif;
        color: black;
      }

      .menu {
        background:rgb(113, 177, 197);
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

      .nav > li > a {
        display: block;
        font-weight: 600;
        font-size: 14px;
        color: black;
        text-decoration: none;
      }

      .nav > li:hover > a{
        background: none;
        color: white;
      }

      .nav li > ul {
        display: none;      
      }

      .nav li:hover > ul {
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
    
      .nav li:hover > ul li {
        float: left;
        border:  rgb(113, 177, 197);
        margin: 0;
        padding: 0;
        display: inline;
      }

      .nav li:hover > ul > li > a{
        float: left;
        color: black;
        padding: 0 10px 0 0;
        margin: 0;
        line-height: 45px;
        display: block;
        width: 90px;
      }

      .login_register{
        list-style-type: none;
        padding: 0;
        margin: 0;
        position: absolute;
        top: 1%;
        right: 5%;
      }

      .login_register li{
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

    </style>
  </head>
  <body>
  <%@include file = "../common/menubar.jsp" %>
 
    <div id="wrap" style="width:70%;">
      <div style=" float: left; border-right: 2px solid rgb(113, 177, 197); height: 500px; padding:0 80px;">
          <p style="margin-top: 20%; font-size: 30px; font-weight: 800;color:#ADD4D9";>회원관리</p>
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
          </div>
      </div>
     
        <h1 Style="color:#ADD4D9; font-weight:600; font-size:50px;">게시글 작성 </b> </h1>
    



<form action="<%=request.getContextPath() %>/insert.bo" method="post" encType="multipart/form-data">
    <table>
      
      <label for ="category">국가</label>
      
 
        <select name="countryNo"style="margin-right:45%;" id ="countryNo" size ="1" >
          <option value="N0"selected>=== 선택 ===</option>
          <option value="N1" >뉴질랜드</option>
          <option value="N2">독일</option>
          <option value="N3">일본</option>
          <option value="N4">호주</option>
          <option value="N5">캐나다</option>
        </select>
       
        
        
       
      
          <label for="cate" >카테고리</label> 
         
              <select name="categoryNo",id="categoryNo">
                <option value="C0"selected>=== 선택 ===</option>
                <option value="C1" >공지사항</option>
                <option value="C2">자유게시판</option>
                <option value="C3">질문게시판</option>
                <option value="C4">벼룩시장</option>
              </select>
           
      
          </table> 
         
        </div> 
<div style="width:70%; float:left;"> <Br><Br>
  <label for ="title"><b>제목</b></label>
  <input type=text class="form-title" rows="1" name = "title" id = "title"></input><Br><br>


<label for="content"><b>내용</b></label>
<textarea class="form-control" rows="10" name="content" id="content"></textarea>

</table>

		<input type ="file" id = "img" name = "img">
 


<br><br>
  <div style="width:300px;margin-left: 36%;"> 
  <input type="submit" class="btn btn-info" value="등록하기" >&nbsp;&nbsp;
  <input type="reset" class="btn btn-info"  value="다시쓰기">&nbsp;&nbsp;
  <input type="button" class="btn btn-info"  value="취소" id="cancelBtn" >
  </div>

</div>

</form> 
</body>
</html>
