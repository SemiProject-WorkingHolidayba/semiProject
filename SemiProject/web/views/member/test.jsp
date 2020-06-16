<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link href="carousel.css" rel="stylesheet">
    <!-- Bootstrap Javascript -->
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<style>
tr{
	cursor:pointer;
	
}
.center_div{
    /*
        div 안에 div를 가운데 정렬 할 수 있는 방법
        넓이는 사용자가 원하는 만큼 설정
        display를 block으러 설정
        margin을 0 auto로 설정
    */
    width: auto;
    display: block;
    margin: 0 auto;
}
#modal-body{
	text-align: center;
}
#modal-tb{
	width: 350px;
	
}
#modal-tb th{
	text-align: right;
	font-size:15px;
	padding:3px;
	
}
#modal-tb td{
	padding-left: 5px;
	font-size:15px;
	padding:3px;
}
</style>

</head>
<body>

<button onclick="location.href='<%=request.getContextPath()%>/wselectallmember.me'">워홀러 회원 관리</button>
<button onclick="location.href='<%=request.getContextPath()%>/nselectallmember.me'">현지인 회원 관리</button>
<button onclick="location.href='<%=request.getContextPath()%>/reportlist.me'">신고내역</button>
<table>
	<tr id="tb_tr" border="1" data-toggle="modal" href="#registarModal">
		
		<th>회원번호</th>
		<th style="width: 120px">아이디</th>
		<th style="width: 230px">이메일</th>
		<th style="width: 120px">이름</th>	
		<th style="width: 125px">생년월일</th>
		<th>성별</th>
		<th style="width: 100px">제재</th>
		<th style="width: 100px">탈퇴</th>
		<th><button href="#registarModal">정보보기</button></th>
	</tr>
</table>
<button data-toggle="modal" href="#registarModal">모달</button>

<div class="modal fade" id="registarModal" tabindex="-1" role="dialog" aria-lablelledby="modal" aria-hidden="true">
	<div class="modal-dialog" >
		<div class="modal-content">
			 <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
              aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="myModalLabel">상세 정보</h4>
        </div>
			<div class="modal-body">
				
					<table id="modal-tb" >
						<tr>
							<th>번  &nbsp; 호:
							<td id="td_no"></td>
						</tr>
						<tr>
							<th>회원번호:
							<td id="td_userno"></td>
						</tr>
						<tr>
							<th>아 이 디:
							<td id="td_userid"></td>
						</tr>
						<tr>
							<th>이 메 일:
							<td id="td_email"></td>
						</tr>
						<tr>
							<th>이   름:
							<td id="td_username"></td>
						</tr>
						<tr>
							<th>생년월일:
							<td id="td_birth"></td>
						</tr>
						<tr>
							<th>성   별:
							<td id="td_gender"></td>
						</tr>
						<tr>
							<th>제재:
							<td id="td_sanction"></td>
						</tr>
						<tr>
							<th>탈퇴:
							<td id="td_status"></td>
						</tr>
						
					</table>
			
			</div>
		</div>
		
	</div>
</div>



<script>
	$(function(){
		$("#tb_tr").click(function(){
			var td = $(this).children();
			var no = td.eq(0).text();
			var userno = td.eq(1).text();
			var userid= td.eq(2).text();
			var email= td.eq(3).text();
			var username= td.eq(4).text();
			var birth= td.eq(5).text();
			var gender= td.eq(6).text();
			var sanction= td.eq(7).text();
			var status= td.eq(8).text();
			
			$("#td_no").text(no);
			$("#td_userno").text(userno);
			$("#td_userid").text(userid);
			$("#td_email").text(email);
			$("#td_username").text(username);
			$("#td_birth").text(birth);
			$("#td_gender").text(gender);
			$("#td_sanction").text(sanction);
			$("#td_status").text(status);
			
			
			
			/* alert($(this).text()); */
			 console.log("클릭한 Row의 모든 데이터 : "+no+"\n"+userno+"\n"+userid+"\n"+email+"\n"+username+"\n"+birth+"\n"+gender+"\n"+sanction+"\n"+status);
		})
	})

</script>
</body>
</html>