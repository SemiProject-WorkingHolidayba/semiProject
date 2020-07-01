<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
   <style>
      
      #wrap td{
            width: 5em;
            height: 4em;
        }

    </style>
  </head>
  <body>
  <%@include file = "../common/menubar.jsp" %>
  <br><br><br><br><br>
	  <h1 style="color:#CECECE; font-weight:600; font-size:30px; padding-left:10%;">안전정보</h1>

	<div id = "wrap">
		<form action="<%=request.getContextPath() %>/insert.si" method="post" encType="multipart/form-data">
		    <table style = "margin:0 auto;">
		    <tr>
		    	<td><label for ="category">국가</label></td>
		    	<td><select name="countryNo" style="margin-right:45%;" id ="countryNo" size ="1" >
		          <option value="N0"selected>=== 선택 ===</option>
		          <option value="N4" >뉴질랜드</option>
		          <option value="N5">독일</option>
		          <option value="N2">일본</option>
		          <option value="N1">호주</option>
		          <option value="N3">캐나다</option>
		        </select></td>
		    </tr>
		    <tr>
		    	<td><label for ="title"><b>제목</b></label></td>
			  <td><input type=text class="form-title" rows="1" name = "title" id = "title" size = "100"></input><Br><br>
		    	</td>
		    </tr>
		    <tr>
		    <td><label for="content"><b>내용</b></label></td>
		    <td><textarea class="form-control" rows="10" name="content" id="content"></textarea>

			</td>
		    </tr>
		    <tr>
		    <td><label for="content"><b>파일첨부</b></label>
		    </td>
		    <td><input type ="file" id = "img" name = "img">
		    </td>
		    </tr>
		     </table>
			
			<br><br>
			  <div style="width:300px;margin-left: 36%;"> 
			  <input type="submit" class="btn btn-info" style = "margin-left:50%; background:#cecece; border:none;"value="등록하기" >&nbsp;&nbsp;
			  </div>
			  <br><br>
	</form> 
</div>
</body>
</html>
