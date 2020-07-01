<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="safeInfo.model.vo.*, java.util.ArrayList" %>
<% Safe s = (Safe)request.getAttribute("safeinfo");%>  
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<title>WorkingThrough</title>
 <style>
	
	 
	 .tableArea table  {
	 	border:1px solid black;
	    text-align:center;
	    width:70%;
	    margin-left:20%;
	   }
	   
	   .tableArea table  td {
	   	border:1px solid black;
	   	padding:1%;
	   }

   </style>
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
   </head>
   <body>
 	<%@ include file="../common/menubar.jsp" %>
	<br><br><br><br><br>
    <h1 style="color:#CECECE; font-weight:600; font-size:30px; padding-left:10%;">안전정보</h1>
    <br><br>
    <div class= "wrap">
		<div class = "tableArea" >
		   <table>  
		      <tr>   
		         <td><%=s.getTitle() %></td>
		         <td style = "width:5%;"><%=s.getWriteDate() %></td>
			     <td style = "width:5%;"><%=s.getViewCount() %></td>
		      </tr>
	
		      <tr align="center">
		       	<td style ="border-bottom:none;" colspan = "3"><img src = "<%=request.getContextPath() %>/safe_uploadFiles/<%=s.getImg()%>"width="300px" height="300px"></td>
		      </tr>
		      <tr>
		      	<td colspan = "3" style= " border-top : none;"><%=s.getContent() %></td>
		      </tr>
		   
		      </table>
		      </div>
		  <br>
      </div>
  
     </body>
</html>