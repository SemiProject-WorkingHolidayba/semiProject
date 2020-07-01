package job.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import job.model.vo.Heart;
import job.model.vo.Job;
import job.model.vo.JobApply;
import job.model.vo.JobReview;

public class JobDao {

   public int registJob(Connection conn, Job j, int userNo) {
      PreparedStatement pstmt=null;
      int result=0;
      
      String query="INSERT INTO JOBSEARCH VALUES(SEQ_JOBNO.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,0,SYSDATE,?,?,?,?,?,DEFAULT,'J',?)";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setString(1, j.getJobCategory());
         pstmt.setString(2, j.getPeriod());
         pstmt.setString(3, j.getLogoImg());
         pstmt.setInt(4, j.getRecruitment());
         pstmt.setString(5, j.getGender());
         pstmt.setString(6, j.getAge());
         pstmt.setString(7, j.getAddress());
         pstmt.setString(8, j.getPay());
         pstmt.setString(9, j.getDueDate());
         pstmt.setString(10, j.getWorktime1());
         pstmt.setString(11, j.getWorkday());
         pstmt.setString(12, j.getTitle());
         pstmt.setString(13, j.getContent());
         pstmt.setString(14, j.getCountry());
         pstmt.setInt(15, userNo);
         pstmt.setString(16, j.getChangeName());
         pstmt.setString(17, j.getFilePath());
         pstmt.setString(18, j.getCoName());
         pstmt.setString(19, j.getWorktime2());
         
         result=pstmt.executeUpdate();
//         System.out.println("나 dao result야 " + result);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      
      return result;
   }

   public int getListCount(Connection conn) {
      PreparedStatement pstmt=null;
      ResultSet rset=null;
      int result=0;
      
      String query="SELECT COUNT(*) FROM JOBSEARCH WHERE STATUS='N'";
      
      try {
         pstmt=conn.prepareStatement(query);

         rset=pstmt.executeQuery();
         
         if(rset.next()) {
            result=rset.getInt(1);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rset);
      }
      return result;
   }

   public ArrayList selectList(Connection conn, int currentPage, int limit) {
      PreparedStatement pstmt=null;
      ResultSet rset=null;
      
      ArrayList list=new ArrayList();
      
      int startRow=(currentPage-1)*limit+1;
      int endRow=currentPage*limit;
      
      System.out.println("startRow : " + startRow + ", endRow : " + endRow);
      
      String query="SELECT * FROM (SELECT ROWNUM RNUM1, J.* FROM JSLIST J where j.status='N') WHERE RNUM1 BETWEEN ? AND ?";
//      String query="SELECT * FROM JSLIST WHERE RNUM BETWEEN ? AND ?";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setInt(1, startRow);
         pstmt.setInt(2, endRow);
         
         rset=pstmt.executeQuery();
         
         while(rset.next()) {
            Job j=new Job(
                           rset.getInt("jobno"),
                           rset.getString("job"),
                           rset.getString("period"),
                           rset.getString("logoimg"),
                           rset.getInt("recruitment"),
                           rset.getString("gender"),
                           rset.getString("age"),
                           rset.getString("address"),
                           rset.getString("pay"),
                           rset.getString("duedate"),
                           rset.getString("worktime1"),
                           rset.getString("worktime2"),
                           rset.getString("workday"),
                           rset.getString("title"),
                           rset.getString("content"),
                           rset.getInt("jobreport"),
                           rset.getDate("writedate"),
                           rset.getString("country"),
                           rset.getString("userid"),
                           rset.getString("changename"),
                           rset.getString("filepath"),
                           rset.getString("coname"),
                           rset.getString("status"),
                           rset.getString("typeno")
                           
            		);
            list.add(j);
         }
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rset);
      }
      return list;
   }

   public Job selectJobList(Connection conn, int jno2) {
      PreparedStatement pstmt=null;
      ResultSet rset = null;
   
      Job j =null;
      
      String query = "SELECT * FROM JSLIST WHERE JOBNO=? AND STATUS='N'";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, jno2);
         
         rset = pstmt.executeQuery();
         while(rset.next()) {
            j = new Job(
                  rset.getInt("jobno"),
                  rset.getString("job"),
                  rset.getString("period"),
                  rset.getString("logoimg"),
                  rset.getInt("recruitment"),
                  rset.getString("gender"),
                  rset.getString("age"),
                  rset.getString("address"),
                  rset.getString("pay"),
                  rset.getString("duedate"),
                  rset.getString("worktime1"),
                  rset.getString("worktime2"),
                  rset.getString("workday"),
                  rset.getString("title"),
                  rset.getString("content"),
                  rset.getInt("jobreport"),
                  rset.getDate("writedate"),
                  rset.getString("country"),
                  rset.getString("userid"),
                  rset.getString("changename"),
                  rset.getString("filepath"),
                  rset.getString("coname")
                  );
         }
         System.out.println("list dao : "+j);
         
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rset);
      }
      
      return j;
   }
      

   public int updateJob(Connection conn, Job j, int jobNo, int userNo) {
      PreparedStatement pstmt=null;
      int result=0;
      
      String query="UPDATE JOBSEARCH SET JOB=?,PERIOD=?,LOGOIMG=?,RECRUITMENT=?,GENDER=?,AGE=?,ADDRESS=?,PAY=?,DUEDATE=?,WORKTIME1=?,WORKDAY=?,TITLE=?,CONTENT=?,JOBREPORT=?,WRITEDATE=SYSDATE,COUNTRYNO=?,USERNO=?,CHANGENAME=?,FILEPATH=?,CONAME=?,STATUS='N',TYPENO='J',WORKTIME2=?\r\n" + 
            "WHERE JOBNO=? AND USERNO=?";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setString(1, j.getJobCategory());      // job
         pstmt.setString(2, j.getPeriod());         // period
         pstmt.setString(3, j.getLogoImg());         // logoimg
         pstmt.setInt(4, j.getRecruitment());      // recruitment
         pstmt.setString(5, j.getGender());         //gender
         pstmt.setString(6, j.getAge());            //age
         pstmt.setString(7, j.getAddress());         // address
         pstmt.setString(8, j.getPay());            // pay
         pstmt.setString(9, j.getDueDate());         //duedate
         pstmt.setString(10, j.getWorktime1());      //worktime
         pstmt.setString(11, j.getWorkday());      //workday
         pstmt.setString(12, j.getTitle());         //title
         pstmt.setString(13, j.getContent());      //content
         pstmt.setInt(14, j.getJobReport());         //jobreport
         pstmt.setString(15, j.getCountry());      //countryno
         pstmt.setInt(16, userNo);         //userno
         pstmt.setString(17, j.getChangeName());      //changename
         pstmt.setString(18, j.getFilePath());      //filepath
         pstmt.setString(19, j.getCoName());         //coname
         pstmt.setString(20, j.getWorktime2());      //worktime
         pstmt.setInt(21, jobNo);            //userNo
         pstmt.setInt(22, userNo);
         
                           
         
         result=pstmt.executeUpdate();
         System.out.println("DAo에서 리절트 : "+result);
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      
      return result;
   }

   public int deleteJob(Connection conn, int jobNo,int userNo) {
         PreparedStatement pstmt=null;
         int result=0;
         
         String query="UPDATE JOBSEARCH SET STATUS='Y' WHERE JOBNO=? AND USERNO =?";
         
         try {
            pstmt=conn.prepareStatement(query);
            pstmt.setInt(1, jobNo);
            pstmt.setInt(2, userNo);
            
            result=pstmt.executeUpdate();
            
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } finally {
            close(pstmt);
         }
         
         return result;
      }

   public Job savaJobData(Connection conn, int jobNo) {
      PreparedStatement pstmt=null;
      ResultSet rset=null;
      Job j = null;
      
      String query = "SELECT * FROM JSLIST WHERE JOBNO=? AND STATUS='N'";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, jobNo);
         
         rset = pstmt.executeQuery();
         if(rset.next()) {
            j = new Job(
                  rset.getInt("jobno"),
                  rset.getString("job"),
                  rset.getString("period"),
                  rset.getString("logoimg"),
                  rset.getInt("recruitment"),
                  rset.getString("gender"),
                  rset.getString("age"),
                  rset.getString("address"),
                  rset.getString("pay"),
                  rset.getString("duedate"),
                  rset.getString("worktime1"),
                  rset.getString("worktime2"),
                  rset.getString("workday"),
                  rset.getString("title"),
                  rset.getString("content"),
                  rset.getInt("jobreport"),
                  rset.getDate("writedate"),
                  rset.getString("country"),
                  rset.getString("userid"),
                  rset.getString("changename"),
                  rset.getString("filepath"),
                  rset.getString("coname"));
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rset);
      }
      
      return j;
   }

   public int jobJJim(Connection conn, Heart h) {
      PreparedStatement pstmt=null;
      int result=0;
      
      String query="INSERT INTO HEART VALUES(SEQ_HEART.NEXTVAL,?,?)";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setInt(1, h.getJobNo());
         pstmt.setInt(2, h.getUserNo());
         
         result=pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      
      return result;
   }

   public ArrayList selectHlist(Connection conn, int userNo) {
	   PreparedStatement pstmt=null;
	      ResultSet rset=null;
	      
	      ArrayList hlist=new ArrayList();
	      
	      String query="SELECT * FROM HEART WHERE USERNO=?";
	      
	      try {
	         pstmt=conn.prepareStatement(query);
	         pstmt.setInt(1, userNo);
	         
	         rset=pstmt.executeQuery();
	         while(rset.next()) {
	            Heart h=new Heart(
	                     rset.getInt("heartno"),
	                     rset.getInt("jobno"),
	                     rset.getInt("userno")
	                  );
	            hlist.add(h);
	            System.out.println("HEART리스트 : "+hlist);
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	         close(rset);
	      }
	      
	      return hlist;
   }

   public int deleteHeart(Connection conn, int jobNo) {
      PreparedStatement pstmt=null;
      int result=0;
      
      String query="DELETE FROM HEART WHERE JOBNO=?";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setInt(1, jobNo);
         
         result=pstmt.executeUpdate();
         System.out.println("Dao에서 딜리트하트 : "+result);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      
      return result;
   }

   public Heart selectHeart(Connection conn, int jobNo, int userNo) {
      PreparedStatement pstmt=null;
      ResultSet rset=null;
      Heart h=null;
      
      
      String query="SELECT * FROM HEART WHERE JOBNO=? AND USERNO=?";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setInt(1, jobNo);
         pstmt.setInt(2, userNo);
         
         rset=pstmt.executeQuery();
         
         if(rset.next()) {
             h=new Heart(
                  rset.getInt("heartno"),
                  rset.getInt("jobno"),
                  rset.getInt("userno")      
                  );
         }
            
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rset);
      }
      
      return h;
   }

   public int deleteHeart(Connection conn, int jobNo, int userNo) {
      PreparedStatement pstmt=null;
      int result=0;
      
      String query="DELETE FROM HEART WHERE JOBNO=? AND USERNO=?";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setInt(1, jobNo);
         pstmt.setInt(2, userNo);
         
         result=pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      
      return result;
   }

   public int jobDetailJJim(Connection conn, int jobNo, int userNo) {
      PreparedStatement pstmt=null;
      int result=0;
      
      String query="INSERT INTO HEART VALUES(SEQ_HEART.NEXTVAL,?,?)";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setInt(1, jobNo);
         pstmt.setInt(2, userNo);
         
         result=pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return result;
   }

   public int insertJobApply(Connection conn, JobApply j, int userNo, int jobNo) {
      PreparedStatement pstmt=null;
      int result=0;
      
      String query="INSERT INTO JOBAPPLICATION VALUES(SEQ_JOBAPPLYNO.NEXTVAL,?,?,SYSDATE,?,?,?)";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setInt(1, jobNo);
         pstmt.setInt(2, userNo);
         pstmt.setString(3, j.getResumeFile());
         pstmt.setString(4, j.getChangeName());
         pstmt.setString(5, j.getFilePath());
         
         result=pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      
      return result;
   }

   public int getSearchListCount(Connection conn, String[] nationArr, String[] jobCategoryArr, String[] termArr, String[] weekArr) {
	   PreparedStatement pstmt=null;
	      ResultSet rset=null;
	      int result=0;
	      
	      String query="SELECT COUNT(*) FROM JOBSEARCH WHERE STATUS='N' ";
	      String and= " AND ";
	      
	      if(nationArr!=null) {
	         if(nationArr.length==1) {
	            query+="COUNTRYNO in(?)"+and;
	         }else if(nationArr.length==2) {
	            query+="COUNTRYNO in(?,?)"+and;
	         }else if(nationArr.length==3) {
	            query+="COUNTRYNO in(?,?,?)"+and;
	         }else if(nationArr.length==4) {
	            query+="COUNTRYNO in(?,?,?,?)"+and;
	         }
	      }
	      
	      if(jobCategoryArr!=null) {
	      
	         if(jobCategoryArr.length==1) {
	            query+="JOB in(?)"+and;
	         }else if(jobCategoryArr.length==2) {
	            query+="JOB in(?,?)"+and;
	         }else if(jobCategoryArr.length==3) {
	            query+="JOB in(?,?,?)"+and;
	         }else if(jobCategoryArr.length==4) {
	            query+="JOB in(?,?,?,?)"+and;
	         }else if(jobCategoryArr.length==5) {
	            query+="JOB in(?,?,?,?,?)"+and;
	         }else if(jobCategoryArr.length==6) {
	            query+="JOB in(?,?,?,?,?,?)"+and;
	         }else if(jobCategoryArr.length==7) {
	            query+="JOB in(?,?,?,?,?,?,?)"+and;
	         }else if(jobCategoryArr.length==8) {
	            query+="JOB in(?,?,?,?,?,?,?,?)"+and;
	         }else if(jobCategoryArr.length==9) {
	            query+="JOB in(?,?,?,?,?,?,?,?,?)"+and;
	         }else if(jobCategoryArr.length==10) {
	            query+="JOB in(?,?,?,?,?,?,?,?,?,?)"+and;
	         }else if(jobCategoryArr.length==11) {
	            query+="JOB in(?,?,?,?,?,?,?,?,?,?,?)"+and;
	         }else if(jobCategoryArr.length==12) {
	            query+="JOB in(?,?,?,?,?,?,?,?,?,?,?,?)"+and;
	         }else if(jobCategoryArr.length==13) {
	            query+="JOB in(?,?,?,?,?,?,?,?,?,?,?,?,?)"+and;
	         }else if(jobCategoryArr.length==14) {
	            query+="JOB in(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"+and;
	         }
	      }
	      
	      if(termArr!=null) {
	         if(termArr.length==1) {
	            query+="PERIOD in(?)"+and;
	         }else if(termArr.length==2) {
	            query+="PERIOD in(?,?)"+and;
	         }else if(termArr.length==3) {
	            query+="PERIOD in(?,?,?)"+and;
	         }else if(termArr.length==4) {
	            query+="PERIOD in(?,?,?,?)"+and;
	         }
	      }
	      
	      if(weekArr!=null) {
	         if(weekArr.length==1) {
	            query+="WORKDAY in(?)"+and;
	         }else if(weekArr.length==2) {
	            query+="WORKDAY in(?,?)"+and;
	         }
	      }
	      query=query.substring(0,query.length()-5);
	      
	      System.out.println("서치 쿼리 카운트: "+query);
	      
	      int nArr=0;
	      int jArr=0;
	      int tArr=0;
	      int wArr=0;
	      
	      
	      try {
	         pstmt=conn.prepareStatement(query);
	         if(nationArr!=null) {
	            if(nationArr.length!=0) {
	               for(int i=0; i<nationArr.length;i++) {
	                  pstmt.setString(i+1, nationArr[i]);
	               }
	               nArr=nationArr.length;
	            }
	         }
	         
	         if(jobCategoryArr!=null) {
	            if(jobCategoryArr.length!=0) {
	               for(int i=0; i<jobCategoryArr.length;i++) {
	                  pstmt.setString(i+1+nArr, jobCategoryArr[i]);
	               }
	               jArr=jobCategoryArr.length;
	            }
	         }
	         
	         if(termArr!=null) {
	            if(termArr.length!=0) {
	               for(int i=0; i<termArr.length;i++) {
	                  pstmt.setString(i+1+nArr+jArr, termArr[i]);
	               }
	               tArr=termArr.length;
	            }
	         }
	         
	         if(weekArr!=null) {
	            if(weekArr.length!=0) {
	               for(int i=0; i<weekArr.length;i++) {
	                  pstmt.setString(i+1+nArr+jArr+tArr, weekArr[i]);
	               }
	               wArr=weekArr.length;
	            }
	         }
	         

	         rset=pstmt.executeQuery();
	         
	         if(rset.next()) {
	            result=rset.getInt(1);
	         }
	         System.out.println("Dao에서 서치 카운트: "+result);
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	         close(rset);
	      }
	      return result;
	   }

   public ArrayList searchSelectList(Connection conn, int currentPage, int limit, String[] nationArr,
	         String[] jobCategoryArr, String[] termArr, String[] weekArr) {

	      PreparedStatement pstmt=null;
	      ResultSet rset=null;
	      
	      ArrayList list=new ArrayList();
	      
	      int startRow=(currentPage-1)*limit+1;
	      int endRow=currentPage*limit;
	      
//	      String query="SELECT * FROM (SELECT ROWNUM RNUM1, J.* FROM JSLIST J) JS JOIN COUNTRY C ON(C.COUNTRY =JS.COUNTRY) WHERE RNUM1 BETWEEN ? AND ? AND ";
	      String query="SELECT * FROM (SELECT ROWNUM RNUM1, J.* FROM JSLIST J JOIN COUNTRY C ON(C.COUNTRY=J.COUNTRY) WHERE STATUS='N' AND ";
	      String end_query=") WHERE RNUM1 BETWEEN ? AND ?";
	      String and=" AND ";

	      int nArr=0;
	      int jArr=0;
	      int tArr=0;
	      int wArr=0;
	      
	      if(nationArr!=null) {
	      if(nationArr.length==1) {
	         query+="C.COUNTRYNO in(?)";
	      }else if(nationArr.length==2) {
	         query+="C.COUNTRYNO in(?,?)";
	      }else if(nationArr.length==3) {
	         query+="C.COUNTRYNO in(?,?,?)";
	      }else if(nationArr.length==4) {
	         query+="C.COUNTRYNO in(?,?,?,?)";
	      }
	      }
	      
	      if(jobCategoryArr!=null && nationArr!=null) {
	      if(jobCategoryArr.length==1) {
	         query+=and+"JOB in(?)";
	      }else if(jobCategoryArr.length==2) {
	         query+=and+"JOB in(?,?)";
	      }else if(jobCategoryArr.length==3) {
	         query+=and+"JOB in(?,?,?)";
	      }else if(jobCategoryArr.length==4) {
	         query+=and+"JOB in(?,?,?,?)";
	      }else if(jobCategoryArr.length==5) {
	         query+=and+"JOB in(?,?,?,?,?)";
	      }else if(jobCategoryArr.length==6) {
	         query+=and+"JOB in(?,?,?,?,?,?)";
	      }else if(jobCategoryArr.length==7) {
	         query+=and+"JOB in(?,?,?,?,?,?,?)";
	      }else if(jobCategoryArr.length==8) {
	         query+=and+"JOB in(?,?,?,?,?,?,?,?)";
	      }else if(jobCategoryArr.length==9) {
	         query+=and+"JOB in(?,?,?,?,?,?,?,?,?)";
	      }else if(jobCategoryArr.length==10) {
	         query+=and+"JOB in(?,?,?,?,?,?,?,?,?,?)";
	      }else if(jobCategoryArr.length==11) {
	         query+=and+"JOB in(?,?,?,?,?,?,?,?,?,?,?)";
	      }else if(jobCategoryArr.length==12) {
	         query+=and+"JOB in(?,?,?,?,?,?,?,?,?,?,?,?)";
	      }else if(jobCategoryArr.length==13) {
	         query+=and+"JOB in(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	      }else if(jobCategoryArr.length==14) {
	         query+=and+"JOB in(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	      }
	      }else if(nationArr==null&&jobCategoryArr!=null) {
	    	  if(jobCategoryArr.length==1) {
	 	         query+="JOB in(?)";
	 	      }else if(jobCategoryArr.length==2) {
	 	         query+="JOB in(?,?)";
	 	      }else if(jobCategoryArr.length==3) {
	 	         query+="JOB in(?,?,?)";
	 	      }else if(jobCategoryArr.length==4) {
	 	         query+="JOB in(?,?,?,?)";
	 	      }else if(jobCategoryArr.length==5) {
	 	         query+="JOB in(?,?,?,?,?)";
	 	      }else if(jobCategoryArr.length==6) {
	 	         query+="JOB in(?,?,?,?,?,?)";
	 	      }else if(jobCategoryArr.length==7) {
	 	         query+="JOB in(?,?,?,?,?,?,?)";
	 	      }else if(jobCategoryArr.length==8) {
	 	         query+="JOB in(?,?,?,?,?,?,?,?)";
	 	      }else if(jobCategoryArr.length==9) {
	 	         query+="JOB in(?,?,?,?,?,?,?,?,?)";
	 	      }else if(jobCategoryArr.length==10) {
	 	         query+="JOB in(?,?,?,?,?,?,?,?,?,?)";
	 	      }else if(jobCategoryArr.length==11) {
	 	         query+="JOB in(?,?,?,?,?,?,?,?,?,?,?)";
	 	      }else if(jobCategoryArr.length==12) {
	 	         query+="JOB in(?,?,?,?,?,?,?,?,?,?,?,?)";
	 	      }else if(jobCategoryArr.length==13) {
	 	         query+="JOB in(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	 	      }else if(jobCategoryArr.length==14) {
	 	         query+="JOB in(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	 	      }
	      }
	      
	      if(termArr!=null&&(nationArr!=null || jobCategoryArr!=null)) {
		      if(termArr.length==1) {
		         query+=and+"PERIOD in(?)";
		      }else if(termArr.length==2) {
		         query+=and+"PERIOD in(?,?)";
		      }else if(termArr.length==3) {
		         query+=and+"PERIOD in(?,?,?)";
		      }else if(termArr.length==4) {
		         query+=and+"PERIOD in(?,?,?,?)";
		      }
	      }else if(termArr!=null&&(nationArr==null && jobCategoryArr==null)) {
	    	  if(termArr.length==1) {
	 	         query+="PERIOD in(?)";
	 	      }else if(termArr.length==2) {
	 	         query+="PERIOD in(?,?)";
	 	      }else if(termArr.length==3) {
	 	         query+="PERIOD in(?,?,?)";
	 	      }else if(termArr.length==4) {
	 	         query+="PERIOD in(?,?,?,?)";
	 	      }  
	      }
	      
	      if(weekArr!=null&&(nationArr!=null || jobCategoryArr!=null || termArr!=null)) {
		      if(weekArr.length==1) {
		         query+=and+"WORKDAY in(?)";
		      }else if(weekArr.length==2) {
		         query+=and+"WORKDAY in(?,?)";
		      }   
	      }else if(weekArr!=null&&(nationArr==null && jobCategoryArr==null && termArr==null)) {
	    	  if(weekArr.length==1) {
			         query+="WORKDAY in(?)";
			      }else if(weekArr.length==2) {
			         query+="WORKDAY in(?,?)";
			      }  
	      }
	      
	      query+=end_query;
//	      query=query.substring(0,query.length()-5);
	      System.out.println("dao에서 리스트쿼리 : "+query);
	      
	      try {
	         
	         pstmt=conn.prepareStatement(query);
	         
	         if(nationArr!=null) {
	         if(nationArr.length!=0) {
	            for(int i=0; i<nationArr.length;i++) {
	               pstmt.setString(i+1, nationArr[i]);
	            }
	            nArr=nationArr.length;
	         	}
	         }
	         
	         if(jobCategoryArr!=null) {
	         if(jobCategoryArr.length!=0) {
	            for(int i=0; i<jobCategoryArr.length;i++) {
	               pstmt.setString(i+1+nArr, jobCategoryArr[i]);
	            }
	            jArr=jobCategoryArr.length;
	         	}
	         }
	         
	         if(termArr!=null) {
	         if(termArr.length!=0) {
	            for(int i=0; i<termArr.length;i++) {
	               pstmt.setString(i+1+nArr+jArr, termArr[i]);
	            }
	            tArr=termArr.length;
	         	}
	         }
	         
	         if(weekArr!=null) {
	         if(weekArr.length!=0) {
	            for(int i=0; i<weekArr.length;i++) {
	               pstmt.setString(i+1+nArr+jArr+tArr, weekArr[i]);
	            }
	            wArr=weekArr.length;
	         	}
	         }
	         
	         pstmt.setInt(1+nArr+jArr+tArr+wArr, startRow);
	         pstmt.setInt(2+nArr+jArr+tArr+wArr, endRow);
	         
	         rset=pstmt.executeQuery();
	         
	         while(rset.next()) {
	            Job j=new Job(
	                           rset.getInt("jobno"),
	                           rset.getString("job"),
	                           rset.getString("period"),
	                           rset.getString("logoimg"),
	                           rset.getInt("recruitment"),
	                           rset.getString("gender"),
	                           rset.getString("age"),
	                           rset.getString("address"),
	                           rset.getString("pay"),
	                           rset.getString("duedate"),
	                           rset.getString("worktime1"),
	                           rset.getString("worktime2"),
	                           rset.getString("workday"),
	                           rset.getString("title"),
	                           rset.getString("content"),
	                           rset.getInt("jobreport"),
	                           rset.getDate("writedate"),
	                           rset.getString("country"),
	                           rset.getString("userid"),
	                           rset.getString("changename"),
	                           rset.getString("filepath"),
	                           rset.getString("coname"));
	            list.add(j);
	         }
	         System.out.println("검색결과 리스트 : "+list);
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	         close(rset);
	      }
	      return list;
	   }

   public int jobReport(Connection conn, int jobNo, int writer) {
      PreparedStatement pstmt=null;
      int result=0;
      
      String query="INSERT INTO REPORT VALUES(SEQ_REPORT.NEXTVAL, ?,DEFAULT,'5',?,'N')";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setInt(1, jobNo);
         pstmt.setInt(2,writer);
         
         result=pstmt.executeUpdate();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      return result;
   }

   public Job selectUserNo(Connection conn, int jobNo, String userId) {
      PreparedStatement pstmt=null;
      ResultSet rset= null;
      Job j=null;
      
      
      String query="SELECT J.USERNO FROM JOBSEARCH J JOIN MEMBER M ON(J.USERNO=M.USERNO) WHERE J.JOBNO=? AND M.USERID=?";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setInt(1, jobNo);
         pstmt.setString(2, userId);
         
         rset=pstmt.executeQuery();
         
         while(rset.next()) {
            j=new Job(
                  rset.getInt("userNo")
                  );
         }
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return j;
   }

   public int insertReply(Connection conn, JobReview r) {
      PreparedStatement pstmt = null;
      int result = 0;
      
      String query = "INSERT INTO JOBREVIEW VALUES(SEQ_REVIEWNO.NEXTVAL,?,SYSDATE,0,?,0,?,DEFAULT)";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, r.getContent());
         pstmt.setInt(2, r.getJobNo());
         pstmt.setInt(3, r.getUserNo());
         
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
      
      return result;
   }

   public ArrayList<JobReview> selectReplyList(Connection conn, int reviewNo) {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      ArrayList<JobReview> rlist = new ArrayList<JobReview>();
      
      String query = "SELECT * FROM JOBREVIEW WHERE REVIEWNO=?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, reviewNo);
         
         rset = pstmt.executeQuery();
         
         while(rset.next()) {
            rlist.add(new JobReview(rset.getInt("reviewno"),
                           rset.getString("content"),
                           rset.getString("writedate"),
                           rset.getInt("report"),
                           rset.getInt("jobno"),
                           rset.getInt("score"),
                           rset.getInt("userno")));
         }
         System.out.println("댓글 달기 후 게시글에 달린 댓글 : " + rlist);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      
      return rlist;
   }

public int selectJobNo(Connection conn, int boardno) {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int jobNo = 0;
	String query="SELECT JOBNO FROM JOBREVIEW WHERE REVIEWNO = ?";
	
	try {
		pstmt=conn.prepareStatement(query);
		pstmt.setInt(1, boardno);
		
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			jobNo = rs.getInt("JOBNO");
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
        close(pstmt);
        close(rs);
     }
	
	
	
	
	
	
	
	return jobNo;
}
}