package community.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import community.model.dao.CommunityDao;
import community.model.vo.Community;
import community.model.vo.CommunityMy;


public class CommunityService {
	
	public Community selectCommunity(Connection conn, int communityno) { /* 게시판 리스트 뿌려줌 */
	      
	      PreparedStatement pstmt = null;
	      ResultSet rs= null;
	      Community community =null;
	      String query ="SELECT * FROM CLIST WHERE COMMUNITYNO=?";
	      
	      //************************** 바로위 수정 요망****************************>
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, communityno);
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            community = new Community(rs.getInt("communityno"),
	                                 rs.getString("title"),
	                                 rs.getString("content"),
	                                 rs.getDate("writedate"),
	                                 rs.getInt("viewcount"),
	                                 rs.getInt("report"),
	                                 rs.getString("country"),
	                                 rs.getString("categoryname"),
	                                 rs.getString("userid"));
	                           

	         
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	         close(rs);
	      }
	   

	      return community;
	   }

	public CommunityMy selectcCommunity(int communityNo2, int categoryNo2) {

	      Connection conn = getConnection();
	      
	      CommunityMy community = new CommunityDao().selectcCommunity(conn, communityNo2, categoryNo2);
	      
	      close(conn);
	      return community;
	   }

	   public static int getcListCount(int userNo) {
	      Connection conn = getConnection();
	      
	      int listCount = new CommunityDao().getcListCount(conn, userNo);
	      
	      
	      close(conn);
	      
	      return listCount;
	   }

	   public static ArrayList selectcList(int currentPage, int limit,int userNo) {
	      Connection conn = getConnection();
	      
	      ArrayList list = new CommunityDao().selectcList(conn, currentPage, limit, userNo);
	      
	      close(conn);
	      
	      return list;
	   
	   
	   
	   }


}

