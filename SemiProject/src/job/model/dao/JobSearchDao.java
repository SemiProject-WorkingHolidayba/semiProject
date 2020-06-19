package job.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import job.model.vo.JobApplicator;
import job.model.vo.JobSearch;

public class JobSearchDao {

   public int getListCount(Connection conn,int userNo) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      String query = "SELECT COUNT(*) FROM HLIST WHERE USERNO=? ";
      
      int result = 0;
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, userNo);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            result = rs.getInt(1);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rs);
      }
      
      return result;
   
   }

   public ArrayList selectList(Connection conn, int currentPage, int limit, int userNo) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      ArrayList list = new ArrayList();
      
      int startRow = (currentPage-1) * limit + 1;
      int endRow = currentPage * limit;
      
      
      String query = " SELECT * FROM (SELECT J.* FROM JHLIST J WHERE (RNUM BETWEEN ? AND ?) AND USERNO = ?)";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1,startRow);
         pstmt.setInt(2, endRow);
         pstmt.setInt(3, userNo);
         rs = pstmt.executeQuery();
         
         while(rs.next()){
            JobSearch j = new JobSearch(rs.getInt("jobNo"),
                  rs.getString("period"),
                  rs.getDate("dueDate"),
                  rs.getDate("workTime"),
                  rs.getString("title"),
                  rs.getInt("userNo"),
                  rs.getString("country"),
                  rs.getInt("heartNo")
                  );
            list.add(j);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rs);
      }
      
      return list;
      
      
      
   }

   public JobSearch selectJobSearch(Connection conn, int jobNo2, int heartNo2) {
         PreparedStatement pstmt = null;
         ResultSet rs = null;
      
         String query = "SELECT J.*" + 
               "FROM JLIST J " + 
               "JOIN HLIST H ON J.JOBNO = H.JOBNO" + 
               "WHERE H.HEARTNO = ? AND J.JOBNO =?";
         
         JobSearch jsearch =null;
         
         try {
            pstmt =conn.prepareStatement(query);
            pstmt.setInt(1, heartNo2);
            pstmt.setInt(2, jobNo2);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                jsearch = new JobSearch(rs.getInt("jobNo"),
                                    rs.getString("job"),
                                    rs.getString("period"),
                                    rs.getString("logoImg"),
                                    rs.getInt("recruitment"),
                                    rs.getString("gender"),   
                                    rs.getString("age"),
                                    rs.getString("address"),
                                    rs.getString("pay"),
                                    rs.getDate("dueDate"),
                                    rs.getDate("workTime"),
                                    rs.getString("workDay"),
                                    rs.getString("title"),
                                    rs.getString("content"),
                                    rs.getInt("jobReport"),
                                    rs.getDate("writeDate"),
                                    rs.getString("countryNo"),
                                    rs.getInt("userNo"),
                                    rs.getString("changename"),
                                    rs.getString("country"),
                                    rs.getInt("heartNo"),
                                    rs.getInt("jobApplyNo"),
                                    rs.getDate("jobApplyDate"),
                                    rs.getString("typeNo"),
                                    rs.getString("filePath"),
                                    rs.getString("coName"));
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }finally {
            close(pstmt);
            close(rs);
         }
      
            return jsearch;
   }

   public int deleteHeart(Connection conn, int userNo, int heartNo2) {
      PreparedStatement pstmt = null;
      
      int result =0;
      
      
      String query = "DELETE FROM HEART WHERE HEARTNO = ? AND  USERNO=?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1,heartNo2);
         pstmt.setInt(2, userNo);
         
         
         result = pstmt.executeUpdate();
         
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         
      }
      
      return result;
      

   }

   public int getAListCount(Connection conn, int userNo) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      String query = "SELECT COUNT(*) FROM ALIST WHERE USERNO=? ";
      
      int result = 0;
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1,userNo);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            result = rs.getInt(1);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rs);
      }
      
      return result;
      
   }

   public ArrayList selectListA(Connection conn, int currentPage, int limit, int userNo) {

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      ArrayList list = new ArrayList();
      
      int startRow = (currentPage-1) * limit + 1;
      int endRow = currentPage * limit;
      
      
      String query = "SELECT * FROM (SELECT A.* FROM ALIST A WHERE USERNO=?) WHERE RNUM BETWEEN ? AND ?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, userNo);
         pstmt.setInt(2,startRow);
         pstmt.setInt(3, endRow);
         
         rs = pstmt.executeQuery();
         
         while(rs.next()){
            JobSearch j = new JobSearch(rs.getInt("jobNo"),
                                 rs.getString("job"),
                                 rs.getString("period"),
                                 rs.getString("logoImg"),
                                 rs.getInt("recruitment"),
                                 rs.getString("gender"),   
                                 rs.getString("age"),
                                 rs.getString("address"),
                                 rs.getString("pay"),
                                 rs.getDate("dueDate"),
                                 rs.getDate("workTime"),
                                 rs.getString("workDay"),
                                 rs.getString("title"),
                                 rs.getString("content"),
                                 rs.getInt("jobReport"),
                                 rs.getDate("writeDate"),
                                 rs.getString("countryNo"),
                                 rs.getInt("userNo"),
                                 rs.getString("changename"),
                                 rs.getString("country"),
                                 
                                 rs.getInt("jobApplyNo"),
                                 rs.getDate("jobApplyDate"),
                                 rs.getString("typeNo"),
                                 rs.getString("filePath"),
                                 rs.getString("coName"));
            list.add(j);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rs);
      }
      
      return list;
      
   
   }

   public JobSearch selectApplication(Connection conn, int jobNo2, int userNo2) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
   
      String query = "SELECT * FROM ALIST WHERE USERNO =? AND JOBNO = ?";
      
      JobSearch jsearch = null;
      
      try {
         pstmt =conn.prepareStatement(query);
         pstmt.setInt(1, userNo2);
         pstmt.setInt(2, jobNo2);
         
         rs = pstmt.executeQuery();
         
         if(rs.next()){
             jsearch = new JobSearch(rs.getInt("jobNo"),
                                 rs.getString("job"),
                                 rs.getString("period"),
                                 rs.getString("logoImg"),
                                 rs.getInt("recruitment"),
                                 rs.getString("gender"),   
                                 rs.getString("age"),
                                 rs.getString("address"),
                                 rs.getString("pay"),
                                 rs.getDate("dueDate"),
                                 rs.getDate("workTime"),
                                 rs.getString("workDay"),
                                 rs.getString("title"),
                                 rs.getString("content"),
                                 rs.getInt("jobReport"),
                                 rs.getDate("writeDate"),
                                 rs.getString("countryNo"),
                                 rs.getInt("userNo"),
                                 rs.getString("changename"),
                                 rs.getString("country"),
                                 rs.getInt("heartNo"),
                                 rs.getInt("jobApplyNo"),
                                 rs.getDate("jobApplyDate"),
                                 rs.getString("typeNo"),
                                 rs.getString("filePath"),
                                 rs.getString("coName"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstmt);
         close(rs);
      }
   
         return jsearch;
   }

   public int deleteA(Connection conn, int jobApplyNo2, int userNo) {
      PreparedStatement pstmt = null;
   
      
      int result = 0;
      
      String query = " DELETE FROM (SELECT * FROM JOBAPPLICATION J JOIN JOBSEARCH R ON (J.JOBNO = R.JOBNO)  WHERE J.JOBAPPLYNO = ? AND J.USERNO= ?)";
      
      
         try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,jobApplyNo2);
            pstmt.setInt(2, userNo);
            result = pstmt.executeUpdate();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
         
      
   
   
      
      return result;
   
   
   
   }

   public int getJaListCount(Connection conn,int userNo) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      String query = "SELECT COUNT(*) FROM ARESERVATIONLIST WHERE J=? ";
      
      int result = 0;
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, userNo);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            result = rs.getInt(1);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rs);
      }
      
      return result;
      
   }

   public ArrayList selectListJa(Connection conn, int currentPage, int limit,int userNo) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      ArrayList list = new ArrayList();
      
      int startRow = (currentPage-1) * limit + 1;
      int endRow = currentPage * limit;
      
      
      String query = " SELECT * FROM (SELECT A.* FROM ARESERVATIONLIST A WHERE RNUM BETWEEN ? AND ? AND J=?)";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1,startRow);
         pstmt.setInt(2, endRow);
         pstmt.setInt(3, userNo);
         rs = pstmt.executeQuery();
         
         while(rs.next()){
            JobApplicator j = new JobApplicator(rs.getInt("jobApplyNo"),
                                 rs.getString("title"),
                                 rs.getString("userName"),                              
                                 rs.getString("period"),
                                 rs.getString("email"));
            list.add(j);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rs);
      }
      
      return list;
   }

}