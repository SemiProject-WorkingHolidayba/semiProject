<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="job.model.vo.*, java.util.ArrayList"%>
<%
	Pagination pn = (Pagination)request.getAttribute("pn");
	ArrayList list = (ArrayList)request.getAttribute("list");
	
	int listCount = pn.getListCount();
	int currentPage = pn.getCurrentPage();
	int maxPage = pn.getMaxPage();
	int startPage = pn.getStartPage();
	int endPage = pn.getEndPage();
%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Delivery Management System</title>

  <!-- Bootstrap CSS -->
  <link rel="icon" href="../../favicon.ico">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
  <link href="../carousel/carousel.css" rel="stylesheet">
  <!-- Bootstrap Javascript -->
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  <!-- <script src="http://googledrive.com/host/0B-QKv6rUoIcGeHd6VV9JczlHUjg"></script> -->

  <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

  <!-- Custom styles for this template -->


  <style>
   

    #nation {
      border: 0.5px solid rgb(176, 171, 171);
      border-top-left-radius: 0.5em;
      border-top-right-radius: 0.5em;
      border-bottom-left-radius: 0.5em;
      border-bottom-right-radius: 0.5em;
      padding-left: 0;
      width: 480px;
      height: 50px;
      margin-bottom: 10px;

    }

    #nation>li {
      /* border:0.5px solid black; */
      /* display: inline-block; */
      float: left;
      width: 16.6667%;
      padding: 15px;
      padding-left: 0;
      padding-right: 0;
      margin-left: 0;
      margin-right: 0;
      border-top-left-radius: 0.5em;
      border-top-right-radius: 0.5em;
      border-bottom-left-radius: 0.5em;
      border-bottom-right-radius: 0.5em;
    }

    #nation>li:hover {
      background: rgb(165, 165, 165);
    }

    #zxc>ul>li :hover {
      border-bottom-left-radius: 0.5em !important;
      border-bottom-right-radius: 0.5em !important;
      border-top-left-radius: 0.5em !important;
      border-top-right-radius: 0.5em !important;
      transition: 0s;
    }

    
    /* .container {
      padding: 5px;
    } */

    .menu {
      background: rgb(113, 177, 197);
    }

    .area {
      /* background: lightgray; */
      /* border: 1px solid black; */
      /* height: auto; */
      display: inline-block;
      /* width: 30%; */
      text-align: left;
    }

    .infor>li>a {
      color: black;

    }

    .z1 {
      z-index: 1000;

    }

    .z2 {
      z-index: 100;

    }

  


    #nara {
      background: rgb(143, 199, 207) !important;
    }

    .depth2_menu>li {
      list-style-type: none;
      padding-top: 20px;
      font-weight: 700;
      font-size: 15px;
    }

    .depth2_menu a {
      color: gray !important;
    }

    #home td {
      font-size: 20px;
      border: 1px solid black;
    }

    .mainChoice {
      text-align: center;
      background: lightgray;
      width: 200px;
      height: 40px;
    }

    .table tr {
      height: 40px;
    }

    .mainChoice>th {
      text-align: center;
      font-size: 15px;
      border:1px solid black !important;
    }
    nav{
      text-align: center;
    }
    tbody >tr>td,th{
     text-align: center;
      font-size: 15px;
      padding-top:12px !important;
    }

  </style>

</head>
<!-- NAVBAR
================================================== -->

<body>

  <%@ include file="/views/common/menubar.jsp" %>



  <div class="area" id="wrap" align="left"
    style="width:160px; height: 900px; margin: 0; padding: 0; border-right: 1px solid lightgray; ">

    <nav class="side_menu" style="text-align:left !important; " >

      <ul class="depth2_menu" style="margin-top: 80%;">
        <li class="depth2_list"><a class="depth2_anchor"
            href="<%=request.getContextPath() %>/views/mypage/PIU/NpersonalIU.jsp"
            target="_self">개인정보수정</a>

        </li>
<<<<<<< HEAD
        <li class="depth2_list actived"><a class="depth2_anchor" href="<%=request.getContextPath() %>/list.home"
            target="_self">집 예약자 내역</a>
        </li>
        <li class="depth2_list"><a class="depth2_anchor" href="<%=request.getContextPath() %>/list.ja" target="_self">구직 신청자
            내역</a>


        </li>
        <li class="depth2_list"><a class="depth2_anchor" href="<%=request.getContextPath() %>/views/mypage/Letter/nLetter.jsp" target="_self">내가 쓴 글</a>


       

      </ul>


    </nav>
  </div>

  <div id="wrap" class=" area " style="position:absolute; margin-left: 5%;" ; align="center">

    <h1 style="font-weight: 900;">구직 신청자 내역</h1>

    <form style="margin-top: 100px; margin-left: 50px;  " >

      <table class="table table-hover table-bordered">
        <thead>
          <tr class="mainChoice" style="background: lightgray;">
            <th scope="col" style="width: 100px;">구직 신청 번호</th>
            <th scope="col" style="width: 300px;">글 제목</th>
            <th scope="col" style="width: 100px;">구직자 명</th>
            <th scope="col" style="width: 300px;">근무 기간</th>
            <th scope="col" style="width: 200px;">구직자 이메일</th>

          </tr>
        </thead>
        <tbody>
         <%if(list.isEmpty()){ %>
                	<tr>
                		<td colspan="5">구직 신청자가 없습니다!.</td>
                	</tr>
                	<%}else{ %>
                	<%for(int i=0; i<list.size(); i++){ %>
			          <tr>			            
						<td><%=((JobApplicator)list.get(i)).getJobApplyNo() %></td>
			            <td><%=((JobApplicator)list.get(i)).getTitle() %></td>
			            <td><%=((JobApplicator)list.get(i)).getUserName() %></td>
			            <td><%=((JobApplicator)list.get(i)).getPeriod() %></td>
			            <td><%=((JobApplicator)list.get(i)).getEmail() %></td>
			          </tr>
         			<%} %>
         	<%} %>
        

        </tbody>
      </table>
     <div class="pagingArea" align="center">
			<!-- 맨 처음으로(<<) -->
			<button onclick="location.href='<%=request.getContextPath() %>/list.ja?currentPage=1'"> << </button>
			<!-- 이전 페이지로(<) -->
			<button type="button"  onclick="location.href='<%=request.getContextPath() %>/list.ja?currentPage=<%=currentPage-1 %>'"> < </button>
			<!-- 10개의 페이지 목록 -->
			<% for(int p = startPage ; p <= endPage ; p ++) {%>
				<%if(p == currentPage) {%>
					<button disabled><%=p %></button>
				<%}else{ %>
					<button type="button" onclick="location.href='<%=request.getContextPath() %>/list.ja?currentPage=<%=p %>'"><%=p %></button>
				<%} %>
			<% } %>
			
			<!-- 다음 페이지로(>) -->
			<button type="button" onclick="location.href='<%=request.getContextPath() %>/list.ja?currentPage=<%=currentPage+1 %>'"> > </button>
			<!-- 맨 끝으로(>>) -->
			<button type="button" onclick="location.href='<%=request.getContextPath() %>/list.ja?currentPage=<%=maxPage %>'"> >> </button>
=======
        <li class="depth2_list actived"><a class="depth2_anchor" href="<%=request.getContextPath() %>/views/mypage/Home/nHome.jsp"
            target="_self">집 예약자 내역</a>
        </li>
        <li class="depth2_list"><a class="depth2_anchor" href="<%=request.getContextPath() %>/views/mypage/Work/nWork.jsp" target="_self">구직 신청자
            내역</a>


        </li>
        <li class="depth2_list"><a class="depth2_anchor" href="<%=request.getContextPath() %>/views/mypage/Letter/nLetter.jsp" target="_self">내가 쓴 글</a>


       

      </ul>


    </nav>
  </div>

  <div id="wrap" class=" area " style="position:absolute; margin-left: 5%;" ; align="center">

    <h1 style="font-weight: 900;">구직 신청자 내역</h1>

    <form style="margin-top: 100px; margin-left: 50px;  " >

      <table class="table table-hover table-bordered">
        <thead>
          <tr class="mainChoice" style="background: lightgray;">
            <th scope="col" style="width: 100px;">구직 신청 번호</th>
            <th scope="col" style="width: 300px;">글 제목</th>
            <th scope="col" style="width: 100px;">구직자 명</th>
            <th scope="col" style="width: 300px;">근무 기간</th>
            <th scope="col" style="width: 200px;">구직자 이메일</th>

          </tr>
        </thead>
        <tbody>
         <%if(list.isEmpty()){ %>
                	<tr>
                		<td colspan="5">구직 신청자가 없습니다!.</td>
                	</tr>
                	<%}else{ %>
                	<%for(int i=0; i<list.size(); i++){ %>
			          <tr>			            
						<td><%=((JobApplicator)list.get(i)).getJobApplyNo() %></td>
			            <td><%=((JobApplicator)list.get(i)).getTitle() %></td>
			            <td><%=((JobApplicator)list.get(i)).getUserName() %></td>
			            <td><%=((JobApplicator)list.get(i)).getPeriod() %></td>
			            <td><%=((JobApplicator)list.get(i)).getEmail() %></td>
			          </tr>
         			<%} %>
         	<%} %>
        

        </tbody>
      </table>
     <div class="pagingArea" align="center">
			<!-- 맨 처음으로(<<) -->
			<button onclick="location.href='<%=request.getContextPath() %>/list.ja?currentPage=1'"> << </button>
			<!-- 이전 페이지로(<) -->
			<button onclick="location.href='<%=request.getContextPath() %>/list.ja?currentPage=<%=currentPage-1 %>'"> < </button>
			<!-- 10개의 페이지 목록 -->
			<% for(int p = startPage ; p <= endPage ; p ++) {%>
				<%if(p == currentPage) {%>
					<button disabled><%=p %></button>
				<%}else{ %>
					<button onclick="location.href='<%=request.getContextPath() %>/list.ja?currentPage=<%=p %>'"><%=p %></button>
				<%} %>
			<% } %>
			
			<!-- 다음 페이지로(>) -->
			<button onclick="location.href='<%=request.getContextPath() %>/list.ja?currentPage=<%=currentPage+1 %>'"> > </button>
			<!-- 맨 끝으로(>>) -->
			<button onclick="location.href='<%=request.getContextPath() %>/list.ja?currentPage=<%=maxPage %>'"> >> </button>
>>>>>>> refs/remotes/origin/Eunjin
		</div>
    </form>


  </div>





  <!-- Marketing messaging and featurettes
    ================================================== -->
  <!-- Wrap the rest of the page in another container to center all the content. -->




  <!-- Bootstrap core JavaScript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="../../assets/js/docs.min.js"></script>
  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <script src="../../assetsjs/ie10-viewport-bug-workaround.js"></script>
  <!-- <script src="vendor/holder.js"></script> -->

</body>

</html>