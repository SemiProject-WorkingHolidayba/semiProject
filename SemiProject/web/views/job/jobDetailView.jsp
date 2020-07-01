<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="job.model.vo.Job, job.model.vo.Heart, java.util.ArrayList, java.util.Date, java.util.Calendar, java.text.SimpleDateFormat"%>
<% 
Job j = (Job)request.getAttribute("job"); 
Heart h = (Heart)request.getAttribute("h");

// 디데이 계산
Calendar cal = Calendar.getInstance();

int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH) + 1;
int day = cal.get(Calendar.DAY_OF_MONTH);

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String today = sdf.format(cal.getTime());

String dueDate=j.getDueDate();
String[] strArr = dueDate.split(" ");

Date FirstDate = sdf.parse(today);
Date SecondDate = sdf.parse(strArr[0]);

long calDate = FirstDate.getTime() - SecondDate.getTime(); 
long calDateDays = calDate / ( 24*60*60*1000); 

calDateDays = Math.abs(calDateDays);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
      hr{
        border:1px solid black;
      }

      h3{
          font-weight: bolder;
      }

      #infoFrame{
          margin-left:20%;
          margin-right: 20%;
          /* border:1px solid black; */
      }

       #likeBtn{
          background:white;
          border:0.5px solid gray;
          border-top-left-radius: 0.5em;
          border-top-right-radius: 0.5em;
          border-bottom-left-radius: 0.5em;
          border-bottom-right-radius: 0.5em;
      }
      
      #cancelLikeBtn{
          background:rgb(113, 177, 197);
          border:0.5px solid gray;
          border-top-left-radius: 0.5em;
          border-top-right-radius: 0.5em;
          border-bottom-left-radius: 0.5em;
          border-bottom-right-radius: 0.5em;
      }

      #reportBtn{
          background:white;
          border:0.5px solid gray;
          border-top-left-radius: 0.5em;
          border-top-right-radius: 0.5em;
          border-bottom-left-radius: 0.5em;
          border-bottom-right-radius: 0.5em;
      }

      /* #jobTitle{
          margin-left:1%;
      } */

      #infoFrame div{
        margin-left:1%;
        margin-bottom: 2%;
      }

      #infoFrame div div{
          /* display: inline-block; */
          float: right;
          /* border:1px solid black; */
          /* margin:3% 1%; */
          margin-top: 3%;
          margin-bottom:0;
          margin-left: 1%;
          margin-right: 1%;
      }

      #logo{
          	max-width:60%;
          	width:176px;
      		height:146px;
      }


      .simpleInfo{
          width:12%;
          margin-top:3% !important;
      }

      /* .simpleInfo div{
          padding:25%;
          border:none;
          border-radius: 50%;
          background:rgb(113, 177, 197);
      } */

      .jobContent{
          width:99%;
      }
      
      .jobContent td{
        padding:1% 0%;
      }

      #applyBtn{
          width:20%;
          padding:1% 0%;
          border:1px solid lightgray;
          border-bottom-left-radius: 0.3em;
          border-bottom-right-radius: 0.3em;
          border-top-right-radius: 0.3em;
          border-top-left-radius: 0.3em;
      }
      
      #updateBtn{
          width:20%;
          padding:1% 0%;
          border:1px solid lightgray;
          border-bottom-left-radius: 0.3em;
          border-bottom-right-radius: 0.3em;
          border-top-right-radius: 0.3em;
          border-top-left-radius: 0.3em;
          margin-right:1%;
      }
       #deleteBtn{
          width:20%;
          padding:1% 0%;
          border:1px solid lightgray;
          border-bottom-left-radius: 0.3em;
          border-bottom-right-radius: 0.3em;
          border-top-right-radius: 0.3em;
          border-top-left-radius: 0.3em;
      }
      
      #backBtn{
      	width:20%;
          padding:1% 0%;
          border:1px solid lightgray;
          border-bottom-left-radius: 0.3em;
          border-bottom-right-radius: 0.3em;
          border-top-right-radius: 0.3em;
          border-top-left-radius: 0.3em;
          margin-right:1%;
      }

      #resumeFile{
          border:1px solid black;
          width:50%;
          margin-left:25% !important;
          border-bottom-left-radius: 0.7em;
          border-bottom-right-radius: 0.7em;
          border-top-left-radius: 0.7em;
          border-top-right-radius: 0.7em;
      }

      h5{
          margin-top:3%;
          margin-left:1%;
      }
      h6{
          text-align: center;
          
      }
</style>
</head>
<body>
	<%@ include file="../../views/common/menubar.jsp" %>
<br><br><br><br>
    <div id='infoFrame'>
        <div align=right style='margin-top:2%;'>
        <%if(h != null){ %>
           <button id='cancelLikeBtn' onclick="location.href='<%=request.getContextPath() %>/jdDelete.bo?jobno=<%=j.getJobNo()%>'">♡찜하기</button>
            <%}else{ %>
            <button id='likeBtn' onclick="location.href='<%=request.getContextPath() %>/JJim.bo?jobno=<%=j.getJobNo()%>'">♡찜하기</button>
            
            <%} %>
            <button id='reportBtn' onclick="location.href='<%=request.getContextPath() %>/jobReprot.bo?jobno=<%=j.getJobNo()%>&userId=<%=j.getUserId() %>'">신고하기</button>
        </div>
		
	<script>
         // 찜하기
         $('#likeBtn').click(function(){
            $(this).css("background","rgb(113, 177, 197)");
            
            
         });
         
         $('#cancelLikeBtn').click(function(){
            $(this).css("background","white");
         }); 
         
         $('#reportBtn').click(function(){
              var bool = confirm("신고하시겠습니까?");
              if(bool){
            	  alert("신고가 완료되었습니다.");
              }
          }); 
      </script>

        <hr>
        <div id='jobTitle'>
            <p><%=j.getCoName() %></p>
            <p><h4 style='font-weight: bolder;'><%=j.getTitle() %> </h4></p>
        </div>
        <div>
            <span>
                <img id='logo' src='<%=request.getContextPath() %>/job_uploadFiles/<%=j.getChangeName() %>'>
            </span>
            <div class='simpleInfo'>
                <div style='border-radius: 50%; border:1px rgb(113, 177, 197); background:rgb(113, 177, 197);
                padding:25%; margin:9% 9%;'>
                    <p align='center'>마감</p>
                </div>
                <%

                %>
                <%-- <p align='center'>마감 14일전   <%=j.getDueDate() %></p> --%>
                <p align='center'>마감 <%=calDateDays %>일전</p>
            </div>
            <div class='simpleInfo'>
              <img src='<%=request.getContextPath() %>/images/jobImg/time.PNG' style='max-width: 80%; margin:5% 3%; margin-left: 10%;'>
              <p align='center'><%=j.getWorktime1() %> ~ <%=j.getWorktime2() %></p>
          </div>
            <div class='simpleInfo'>
              <img src='<%=request.getContextPath() %>/images/jobImg/calender.PNG' style='max-width: 90%; margin:6% 0%; margin-left: 5%;'>
              <p align='center'><%=j.getWorkday() %></p>
          </div>
            <div class='simpleInfo'>
              <div style='border-radius: 50%; border:1px rgb(113, 177, 197); background:rgb(113, 177, 197);
              padding:25%; margin:9% 9%;'>
                  <p align='center'>
                  <%if(j.getPeriod().equals("3개월 미만")){ %>
                  		단기
                  <%}else if(j.getPeriod().equals("3개월 이상")){ %>
                  		단기
                  <%}else if(j.getPeriod().equals("6개월 이상")){ %>
                  		장기
                  <%}else if(j.getPeriod().equals("9개월 이상")){ %>
                  		장기
                  <%}else if(j.getPeriod().equals("1년 이상")){ %>
                  		장기
                  <%} %>
                  </p>
              </div>
              <p align='center'><%=j.getPeriod() %></p>
          </div>
            <div class='simpleInfo'>
              <div style='border-radius: 50%; border:1px rgb(113, 177, 197); background:rgb(113, 177, 197);
                          padding:25%; margin:9% 9%;'>
                  <p align='center'>시급</p>
              </div>
              <p align='center'><%=j.getPay() %></p>
          </div>
        </div>

        <hr>

        <div>
            <h3>모집조건</h3>
            <table class='jobContent'>
                <tr>
                    <td style='width:15%;'>마감일</td>
                    <td><%=strArr[0] %></td>
                </tr>
                <tr>
                    <td>인원</td>
                    <td>
                    	<%=j.getRecruitment() %>
                    </td>
                </tr>
                <tr>
                    <td>성별</td>
                    <td>
                    	<%-- <%=j.getGender() %> --%>
                     	<%if(j.getGender().contentEquals("M")){ %>
                  		<p>남자</p>
                  <%}else if(j.getGender().contentEquals("W")){ %>
                  		<p>여자</p>
                  <%}else if(j.getGender().contentEquals("N")){ %>
                  		<p>무관</p>
                  <%} %>
                    </td>
                </tr>
                <tr>
                    <td>연령</td>
                    <td><%=j.getAge() %></td>
                </tr>
            </table>
        </div>
        <hr>
        <div>
            <h3>근무조건</h3>
            <table class='jobContent'>
                <tr>
                    <td style='width:15%;'>급여</td>
                    <td><%=j.getPay() %></td>
                </tr>
                <tr>
                    <td>근무기간</td>
                    <td><%=j.getPeriod() %></td>
                </tr>
                <tr>
                    <td>근무요일</td>
                    <td><%=j.getWorkday() %></td>
                </tr>
                <tr>
                    <td>근무시간</td>
                    <td><%=j.getWorktime1() %> ~ <%=j.getWorktime2() %></td>
                </tr>
                <tr>
                    <td>업직종</td>
                    <td><%=j.getJobCategory() %></td>
                </tr>
            </table>
        </div>
        <hr>
        <div>
            <h3>상세내용</h3>
            <table class='jobContent'>
                <tr>
                    <td><%=j.getContent() %></td>
                </tr>
                
            </table>
        </div>
        <hr>
        <div>
            <h3>근무지역</h3>
            <table class='jobContent'>
                <tr>
                    <td style='width:15%;'>주소</td>
                    <td><%=j.getAddress() %></td>
                </tr>
            </table>
        </div>

        <hr>
       <% if(!loginUser.getUserId().equals(j.getUserId())){ %>
        <form action='<%=request.getContextPath() %>/jobApply.bo?jobno=<%=j.getJobNo()%>' method='post' encType='multipart/form-data'>
           <div align='center'>
              <button type='button' id='backBtn' onclick="location.href='<%=request.getContextPath() %>/jobList.bo'">메뉴로 돌아가기</button>
               <button id='applyBtn' type='submit'>지원하기</button>
           </div>
           <div id='resumeFile'>
               <h5>이력서 첨부</h5>
               <input type='file' id='resume' name='resumeFile'>
               <h6 style="color:red;">이력서를 파일로 첨부하여야 지원이 진행됩니다.</h6>
               <input type='text' id="file_name" style="display:none;">
           </div>
        </form>           
        <%}else if(loginUser.getUserId().equals(j.getUserId())){ %>
           <div align='center'>
               <button id='updateBtn' onclick="location.href='<%=request.getContextPath() %>/jobData.bo?jobno=<%=j.getJobNo()%>'">수정하기</button>
               <button id='deleteBtn' onclick="location.href='<%=request.getContextPath() %>/deleteJob.bo?jobno=<%=j.getJobNo()%>'">삭제하기</button>
           </div>
           <div style='display:none;'>
              <input type='file'>
           </div>
        <%} %>
    <hr>
    </div>
    
    <div class="replyArea">
      <div class="replyWriterArea">
         <table align="center">
            <tr>
               <td style="margin-left:auto;margin-right:auto;">리뷰 작성</td>
               <td><textArea rows="2" cols="80" id="replyContent"></textArea></td>
               <td>
                  <button id="addReply">댓글등록</button>
               </td>
            </tr>
         </table>
      </div>
   </div>
   
   <hr>
   <div>
      <table>
      <%--    <%for(int i=0;i<rlist.length;i++){ %>
            
         <%} %> --%>
         <tr>
         
         </tr>
         
      </table>
   </div>
   
   

   <script type="text/javascript">
         $(document).ready(function() {
            $("#applyBtn").attr("disabled",true);
            $('input[type=file]').change(function(e){
               $(this).parent().find("#file_name").val(e.target.files[0].name);
               $('#applyBtn').attr("disabled",false);
           });
         });
         

        $(function(){
           $("#addReply").click(function(){
              var writer = <%=loginUser.getUserNo()%>;
              var jobNo = <%=j.getJobNo() %>;
              var content=$("#replyContent").val();
              
              $.ajax({
                 url:"<%=request.getContextPath()%>/insertReview.bo",
                 type:"post",
                 data:{writer:writer, content:content, jobNo:jobNo},
                 success:function(data){
                    alert("리뷰가 등록되었습니다.")
                 },
                 error:function(request,status,error){
                     alert("리뷰등록에 실패하였습니다.");
                     alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                 }
              })
              
              // InsertReplyServlet 만들러 가자
           })
        })
        
         
   </script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="assetsjs/ie10-viewport-bug-workaround.js"></script>
    <!-- <script src="vendor/holder.js"></script> -->
  </body>
</html>