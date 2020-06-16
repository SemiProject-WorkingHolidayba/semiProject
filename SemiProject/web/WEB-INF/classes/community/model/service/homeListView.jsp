<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="home.model.vo.*, java.util.ArrayList"%>

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
                width: 40%;
                padding-right: 1em;
            }
            .li-img img {
                display: block;
                width: 100%;
                height: auto;
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

            #page_btn{
                border: none;
                padding: 0.5%;
            }

            
        </style>
    </head>

    <body>
    	<%@ include file = "../common/menubar.jsp" %>
        <div id = "content">
            <form class = "category">
                <table class = "home_reservation_category">
                    <tr>
                        <td><b>나라</b></td>
                        <td>
                            <label class="country_option"><input type="checkbox"" name = "cp_item" value="australia"><span>호주</span></label>
                            <label class="country_option"><input type="checkbox"" name = "cp_item" value="japan"><span>일본</span></label>
                            <label class="country_option"><input type="checkbox"" name = "cp_item" value="canada"><span>캐나다</span></label>
                            <label class="country_option"><input type="checkbox"" name = "cp_item" value="newzealand"><span>뉴질랜드</span></label>
                            <label class="country_option"><input type="checkbox"" name = "cp_item" value="germany"><span>독일</span></label>
                        </td>
                    </tr>
                    <tr> 
                        <td><b>집 종류</b></td>
                        <td>
                            <label class="home_option"><input type="checkbox"" name = "cp_item2" value="sharehouse"><span>쉐어하우스</span></label>
                            <label class="home_option"><input type="checkbox"" name = "cp_item2" value="dormitory"><span>기숙사</span></label>
                            <label class="home_option"><input type="checkbox"" name = "cp_item2" value="homestay"><span>홈스테이</span></label>
                            <label class="home_option"><input type="checkbox"" name = "cp_item2" value="oneroom"><span>원룸</span></label>
                            <label class="home_option"><input type="checkbox"" name = "cp_item2" value="apartment"><span>아파트</span></label>
                        </td>
                    </tr>
                    <tr id = "term">
                        <td><b>기간</b></td>
                        <td>
                            <label class="term_option"><input type="checkbox"" name = "cp_item3" value="3monthless"><span>3개월 미만</span></label>
                            <label class="term_option"><input type="checkbox"" name = "cp_item3" value="3months"><span>3개월 이상</span></label>
                            <label class="term_option"><input type="checkbox"" name = "cp_item3" value="6months"><span>6개월 이상</span></label>
                            <label class="term_option"><input type="checkbox"" name = "cp_item3" value="9month"><span>9개월 이상</span></label>
                            <label class="term_option"><input type="checkbox"" name = "cp_item3" value="1year"><span>1년 이상</span></label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><button class = "search" type = "submit">검색</button></td>
                    </tr>
                </table>
                
                <p class = "alert">카테고리를 선택해주세요.</p>
            </form>

            <div id="home" class="home">
	            
                <ul class="list img-list">
                    <li>
                        <a href="#" class="inner">
                            <div class="li-img">
                                <img src="../../images/home.jpg" alt = "Image Alt Text" />
                            </div>
                            <div class="li-text">
                                <h4 class="li-head">Title of Content</h4>
                                <p class="li-sub">Summary of content</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="inner">
                            <div class="li-img">
                                <img src="../../images/home.jpg" alt="Image Alt Text" />
                            </div>
                            <div class="li-text">
                                <h4 class="li-head">Title of More Content</h4>
                                <p class="li-sub">Summary of more content</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="inner">
                            <div class="li-img">
                                <img src="../../images/home.jpg" alt="Image Alt Text" />
                            </div>
                            <div class="li-text">
                                <h4 class="li-head">Title of Content</h4>
                                <p class="li-sub">Summary of content</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="inner">
                            <div class="li-img">
                                <img src="../../images/home.jpg" alt="Image Alt Text" />
                            </div>
                            <div class="li-text">
                                <h4 class="li-head">Title of More Content</h4>
                                <p class="li-sub">Summary of more content</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="inner">
                            <div class="li-img">
                                <img src="../../images/home.jpg" alt="Image Alt Text" />
                            </div>
                            <div class="li-text">
                                <h4 class="li-head">Title of Content</h4>
                                <p class="li-sub">Summary of content</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="inner">
                            <div class="li-img">
                                <img src="../../images/home.jpg" alt="Image Alt Text" />
                            </div>
                            <div class="li-text">
                                <h4 class="li-head">Title of More Content</h4>
                                <p class="li-sub">Summary of more content</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="inner">
                            <div class="li-img">
                                <img src="../../images/home.jpg" alt="Image Alt Text" />
                            </div>
                            <div class="li-text">
                                <h4 class="li-head">Title of More Content</h4>
                                <p class="li-sub">Summary of more content</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="inner">
                            <div class="li-img">
                                <img src="../../images/home.jpg" alt="Image Alt Text" />
                            </div>
                            <div class="li-text">
                                <h4 class="li-head">Title of Content</h4>
                                <p class="li-sub">Summary of content</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="inner">
                            <div class="li-img">
                                <img src="../../images/home.jpg" alt="Image Alt Text" />
                            </div>
                            <div class="li-text">
                                <h4 class="li-head">Title of More Content</h4>
                                <p class="li-sub">Summary of more content</p>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>

            <button id = "page_btn"><</button>
            <button id = "page_btn">1</button>
            <button id = "page_btn">2</button>
            <button id = "page_btn">3</button>
            <button id = "page_btn">4</button>
            <button id = "page_btn">5</button>
            <button id = "page_btn">></button>
        </div>        
            
        <div id = "footer">
            <p class="pull-right"><a href="#">Back to top</a></p>
            <p>&copy; 2017 Delivery Management System &middot; <a href="#">Privacy</a></p>
        </div>
        <!-- FOOTER -->
       
        <script>
            $(".search").click(function(){
                $(".alert").addClass("show");
            })
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