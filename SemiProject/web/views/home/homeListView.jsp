<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="home.model.vo.*, java.util.ArrayList"%>
<%
	Pagination pn = (Pagination)request.getAttribute("pn");
	ArrayList<Home> list = (ArrayList<Home>)request.getAttribute("list");
	ArrayList<Img> flist = (ArrayList<Img>)request.getAttribute("flist");
	
	int listCount = pn.getListCount();
	int currentPage = pn.getCurrentPage();
	int maxPage = pn.getMaxPage();
	int startPage = pn.getStartPage();
	int endPage = pn.getEndPage();
%>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <style>
            .home_reservation_category{
                position: relative;
                margin: 0 auto;
                border: 1px solid rgb(113, 177, 197);
                border-radius: 5px;
                margin-top: 4em;
                margin-bottom: 2em;
            }

            .home_reservation_category td{
                padding: 1.2em 2.5em;
            }

            .country_option input[type="checkbox"]{
                display:none;
            }

            .country_option input[type="checkbox"] + span{
                display:inline-block;
                background:none;
                border:1px solid #dfdfdf;    
                border-radius: 0.4em;
                width: 80px;
                text-align:center;
                height:2.7em;
                line-height:2.7em;
                font-weight:500;
                cursor:pointer;
                margin-right: 0.8em;
                font-size: 0.9em;
            }

            .country_option input[type="checkbox"]:checked + span{
                border:1px solid #23a3a7;
                background:#23a3a7;
                color:#fff;
            }

            .home_option input[type="checkbox"]{
                display:none;
            }

            .home_option input[type="checkbox"] + span{
                display:inline-block;
                background:none;
                border:1px solid #dfdfdf;    
                border-radius: 0.4em;
                width: 80px;
                text-align:center;
                height:2.7em;
                line-height:2.7em;
                font-size: 0.9em;
                font-weight:500;
                cursor:pointer;
                margin-right: 0.8em;
                left: 50%;
            }

            .home_option input[type="checkbox"]:checked + span{
                border:1px solid #23a3a7;
                background:#23a3a7;
                color:#fff;
            }

            .term_option input[type="checkbox"]{
                display:none;
            }

            .term_option input[type="checkbox"] + span{
                display:inline-block;
                background:none;
                border:1px solid #dfdfdf;    
                border-radius: 0.4em;
                width: 80px;
                text-align:center;
                height:2.7em;
                line-height:2.7em;
                font-size: 0.9em;
                font-weight:500;
                cursor:pointer;
                margin-right: 0.8em;
            }

            .term_option input[type="checkbox"]:checked + span{
                border:1px solid #23a3a7;
                background:#23a3a7;
                color:#fff;
            }

            .search{
                margin-left: -5%;
                background-color: white;
                border: none;
                color: #3d3d3d;
                line-height: 15%;
                font-size: 1em;
                cursor: pointer;
                border: 1px solid #cecece;
                border-radius: 5px;
                line-height: 2.5em;
                width: 6em;
            }

            .home{
                margin: 0 auto;
            }

            .home a{
                color: black;
            }

            .list li {
                border-bottom: 1px solid #ccc;
                display: table;
                border-collapse: collapse;
                width: 100%;
            }
            
            .inner {
                display: table-row;
                overflow: hidden;
            }
            .li-img {
                display: table-cell;
                vertical-align: middle;
                width: 45%;
                padding-right: 1em;
            }
            .li-img img {
                display: block;
                width : 100%;
                height : 150px; 
            }
            .li-text {
                display: table-cell;
                vertical-align: middle;
                width: 60%;
            }
            .li-head {
                margin: 0;
            }
            .li-sub {
                margin: 0;
            }

            @media all and (min-width: 40em) {
                .list {
                    padding: 0.5em;
                    max-width: 70em;
                    margin: 0 auto;
                    overflow: hidden;
                }
                .list li {
                    padding: 0.5em;
                    display: block;
                    width: 50%;
                    float: left;
                    background: none;
                    border: 0;
                }
                .inner {
                    display: block;
                }
                .li-img, .li-text, .inner {
                    display: block;
                    width: auto;
                    padding: 0;
                }
                .li-text {
                    padding: 0.5em 0;
                }
            }

            @media all and (min-width: 60em) {
                .list li {
                    width: 33.33333333%;
                }
            }

            .alert{
                color: red;
                display: none;
            }

            .show{
                display: inline;
            }
            
            #register_btn{
                width: 8%;
                line-height: 2.5em;
                background: rgb(113, 177, 197);
                border: none;
                color: white;
                font-size: 1em;
                margin-right:-73%;
                margin-top:1%;
            }

            #page_btn{
                border: none;
                padding: 0.5%;
            }
			
			
        </style>
    </head>

    <body>
    	<%@ include file = "../common/menubar.jsp" %>
        <div id = "content">
            <form action = "<%=request.getContextPath()%>/list.ho" class = "category">
                <table class = "home_reservation_category">
                    <tr>
                        <td><b>나라</b></td>
                        <td>
                            <label class="country_option"><input type="checkbox"" name = "country" value="N1"><span>호주</span></label>
                            <label class="country_option"><input type="checkbox"" name = "country" value="N2"><span>일본</span></label>
                            <label class="country_option"><input type="checkbox"" name = "country" value="N3"><span>캐나다</span></label>
                            <label class="country_option"><input type="checkbox"" name = "country" value="N4"><span>뉴질랜드</span></label>
                            <label class="country_option"><input type="checkbox"" name = "country" value="N5"><span>독일</span></label>
                        </td>
                    </tr>
                    <tr> 
                        <td><b>집 종류</b></td>
                        <td>
                            <label class="home_option"><input type="checkbox"" name = "home" value="sharehouse"><span>쉐어하우스</span></label>
                            <label class="home_option"><input type="checkbox"" name = "home" value="dormitory"><span>기숙사</span></label>
                            <label class="home_option"><input type="checkbox"" name = "home" value="homestay"><span>홈스테이</span></label>
                            <label class="home_option"><input type="checkbox"" name = "home" value="oneroom"><span>원룸</span></label>
                            <label class="home_option"><input type="checkbox"" name = "home" value="apartment"><span>아파트</span></label>
                        </td>
                    </tr>
                    <tr id = "term">
                        <td><b>기간</b></td>
                        <td>

                            <label class="term_option"><input type="checkbox"" name = "period" value="3개월미만"><span>3개월 미만</span></label>
                            <label class="term_option"><input type="checkbox"" name = "period" value="3개월이상"><span>3개월 이상</span></label>
                            <label class="term_option"><input type="checkbox"" name = "period" value="6개월이상"><span>6개월 이상</span></label>
                            <label class="term_option"><input type="checkbox"" name = "period" value="9개월이상"><span>9개월 이상</span></label>
                            <label class="term_option"><input type="checkbox"" name = "period" value="1년이상"><span>1년 이상</span></label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><button class = "search" type = "submit">검색</button></td>
                    </tr>
                </table>
            </form>

            <div id="home" class="home">
            	<ul class="list img-list">
		            <% if(list.isEmpty()){ System.out.println("아무것도없음");%>
						
					<%} else{%>
						<%for(int i = 0; i < list.size(); i++) { 
							Home h = list.get(i);%>
							<input type = "hidden" value = "<%=(list.get(i)).gethNo()%>">
							<li>
		                        <a href="#" class="inner">
		                            <div class="li-img">
										<%for(int j = 0; j < flist.size(); j++) {
											Img a = flist.get(j);%>
				                            	<%if(h.gethNo() == a.getHouseNo()) { %> <!-- 한 게시글의 대표 이미지  -->
													<img src = "<%=request.getContextPath() %>/home_uploadFiles/<%=a.getImg()%>" width = "200px" height = "150px" alt = "Image Alt Text" >
												<%} %>
										<%} %>
		                            </div>
		                            <div class="li-text">
		                                <h4 class="li-head"><%=(list.get(i)).getTitle() %></h4>
		                                <p class="li-sub"><%=(list.get(i)).getContent() %></p>
		                            </div>
		                        </a>
                    		</li>
						<%} %>
					<%} %>
                </ul>
            </div>
            
            <%if(loginUser != null) {%>
            	<%if(loginUser.getGrade() == 3) { %>
            	<button id = "register_btn" onclick = "registerHome();">등록하기</button>
				<%}%>
            
            <%} %>
            
            <div id = "page_btn">
            	<button onclick = "location.href ='<%=request.getContextPath()%>/list.ho?currentPage=<%=1%>'"> << </button>
				<button onclick = "location.href ='<%=request.getContextPath()%>/list.ho?currentPage=<%=currentPage-1%>'"> < </button>
				<% for(int p = startPage; p <= endPage; p++) {%>
					<%if(p == currentPage) { %>
						<button disabled><%=p%></button>
					<%} else{ %>
						<button onclick = "location.href ='<%=request.getContextPath()%>/list.ho?currentPage=<%=p%>'"><%=p%></button>
					<%} %>
				<%} %>
			                

				<button onclick = "location.href ='<%=request.getContextPath()%>/list.ho?currentPage=<%=currentPage+1%>'"> > </button>
				<button onclick = "location.href ='<%=request.getContextPath()%>/list.ho?currentPage=<%=maxPage%>'"> >> </button>
            </div>
        </div>        
            
        <div id = "footer">
            <p class="pull-right"><a href="#">Back to top</a></p>
            <p>&copy; 2017 Delivery Management System &middot; <a href="#">Privacy</a></p>
        </div>
        <!-- FOOTER -->
       
        <script>
            $(".search").click(function(){
                $(".alert").addClass("show");
            });
            
            $(function(){
				$(".home li").click(function(){
					var hNo = $(this).prev().val();
					
					<% if(loginUser != null) {%>
						location.href = "<%=request.getContextPath()%>/detail.ho?hNo=" + hNo;
					<%} else{%>
						alert("로그인 해야만 상세보기가 가능합니다.");
					<%}%>
				});
			});
            
            function registerHome(){
            	location.href = 'views/home/homeInsertForm.jsp';
            }
            
        </script>
        
        
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