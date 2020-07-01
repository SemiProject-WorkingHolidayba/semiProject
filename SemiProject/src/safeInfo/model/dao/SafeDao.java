package safeInfo.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import community.model.vo.Community;
import safeInfo.model.vo.Safe;

public class SafeDao {

	public int insertSafe(Connection conn, Safe s) {
		 PreparedStatement pstmt = null;
	      int result= 0;
	      
	      String query ="INSERT INTO SAFETYINFO VALUES(SEQ_SAFE.NEXTVAL,?,?,0,SYSDATE,?,?)";
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1,s.getTitle());
	         pstmt.setString(2,s.getContent());
	         pstmt.setString(3,s.getImg());
	         pstmt.setString(4,s.getCountryNo());
	   
	         result = pstmt.executeUpdate();   
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	         
	      }finally {
	         close(pstmt);
	      }
	      return result;
	}

	public int getListCount(Connection conn) {
		PreparedStatement pstmt = null;
	      ResultSet rs  = null;
	      
	      String query = "SELECT COUNT(*) FROM SAFETYINFO";
	      
	      int result = 0;
	      
	      try {
	         pstmt= conn.prepareStatement(query);
	         rs= pstmt.executeQuery();
	         if(rs.next()) {
	            result = rs.getInt(1);
	            }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	         close(rs);
	      }
	   
	      
	      return result;
	}

	public ArrayList selectList(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
	      ResultSet rs= null;
	      
	      ArrayList list = new ArrayList();
	      int startRow = (currentPage-1) * limit +1;
	      int endRow = currentPage*limit;
	      
	      String query ="SELECT ROWNUM, S.* FROM SAFETYINFO S WHERE ROWNUM BETWEEN ? AND ? ORDER BY ROWNUM DESC";
	      
	      //************************** 바로위 수정 요망****************************>
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1,startRow);
	         pstmt.setInt(2, endRow);
	         
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            Safe s =new Safe(rs.getInt("safetyinfono"),
	                  rs.getString("title"),
	                  rs.getString("content"),
	                  rs.getInt("viewcount"),
	                  rs.getDate("writedate"),
	                  rs.getString("img"),
	                  rs.getString("countryno"));

	            list.add(s);
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	         close(rs);
	      }
	   

	      return list;
	}

	public int updateCount(Connection conn, int sNo) {
		PreparedStatement pstmt = null;
	      int result = 0;
	      
	      String query = "UPDATE SAFETYINFO SET VIEWCOUNT = VIEWCOUNT+1 WHERE SAFETYINFONO = ?";
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, sNo);
	         result = pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	      }
	      
	      return result;
	}

	public Safe selectSafe(Connection conn, int sNo) {
		PreparedStatement pstmt = null;
	      ResultSet rs= null;
	      Safe s =null;
	      String query ="SELECT * FROM SAFETYINFO WHERE SAFETYINFONO=?";
	    
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, sNo);
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            s = new Safe(rs.getInt("safetyinfono"),
                             rs.getString("title"),
                             rs.getString("content"),
                             rs.getInt("viewcount"),
                             rs.getDate("writedate"),
                             rs.getString("img"),
                             rs.getString("countryno"));
	         
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	         close(rs);
	      }
	   

	      return s;
	}

}
