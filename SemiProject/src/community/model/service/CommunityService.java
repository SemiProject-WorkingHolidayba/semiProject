package community.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import community.model.dao.CommunityDao;
import community.model.vo.Community;
<<<<<<< HEAD
import community.model.vo.CommunityMy;
=======
import community.model.vo.Community1;
import community.model.vo.CommunityImg;
import community.model.vo.CommunityMy;
import community.model.vo.Reply;
>>>>>>> refs/remotes/origin/kimsung


public class CommunityService {
<<<<<<< HEAD
=======

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
>>>>>>> refs/remotes/origin/kimsung
	
<<<<<<< HEAD
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
	                           
=======
	
	
	}
	 public int getListCount() {
	      Connection conn = getConnection();
	      
	      int listCount = new CommunityDao().getListCount(conn);
	      
	      close(conn);
	      return listCount;
	   }

	   public ArrayList selectList(int currentPage, int limit) {
	      Connection conn = getConnection();
	      ArrayList list = new CommunityDao().selectList(conn,currentPage,limit);
	      close(conn);
	      return list;
	   }

	   public ArrayList selectList1(int currentPage, int limit) {
	      Connection conn =getConnection();
	      ArrayList list = new CommunityDao().selectList1(conn, currentPage, limit);
	      close(conn);
	      
	      return list;
	   }
	   public ArrayList selectList2(int currentPage, int limit) {
	      Connection conn =getConnection();
	      ArrayList list = new CommunityDao().selectList2(conn, currentPage, limit);
	      close(conn);
	      
	      return list;
	   }
	   

	   public ArrayList selectList3(int currentPage, int limit) {
	      Connection conn =getConnection();
	      ArrayList list = new CommunityDao().selectList3(conn, currentPage, limit);
	      close(conn);
	      
	      return list;
	   }

	   public int insertCommunity(Community1 c, ArrayList<CommunityImg> fileList) {
	      Connection conn = getConnection();
	      
	      int result = new CommunityDao().insertCommunity(conn,c);
	      int result1 = new CommunityDao().insertCommunityImg(conn, fileList);
	      System.out.println(result);
	      System.out.println(result1);
	      
	      if(result>0 && result1 >0) {
	         commit(conn);
	         result =1;
	      }else {
	         rollback(conn);
	         result =0;
	      }
	      close(conn);
	      
	      return result;
	   }
	/* --------------------------------------------------------------------------------------------------------------*/
	   public int updateCount(int communityno) {
	      Connection conn = getConnection();
	      
	      int result = new CommunityDao().updateCount(conn,communityno);
	      
	      if(result>0) {
	         commit(conn);
	      }else {
	         rollback(conn);
	      }
	      close(conn);
	      return result;
	   }

	   public Community selectCommunity(int communityno2) {
	   Connection conn = getConnection();
	      
	      Community community = new CommunityDao().selectCommunity(conn, communityno2);
	            
	      close(conn);
	      
	      return community;
	      
	   }

	   public ArrayList<Reply> selectReplyList(int communityno) {
	      // TODO Auto-generated method stub
	      return null;
	   }


	   public int updateCommunity(Community1 c, ArrayList<CommunityImg> fileList) {
	Connection conn = getConnection();
	      
	      int result = new CommunityDao().updateCommunity(conn,c);
	      
	      int result1 = new CommunityDao().updateCommunityImg(conn, fileList);
	      System.out.println("result :"+result);
	      System.out.println("result1 :"+result1);
	      if(result>0 && result1 >0) {
	         commit(conn);
	         result =1;
	         
	      }else {
	         rollback(conn);
	         result =0;
	      }
	      close(conn);
	      
	      return result;
	   
	   }
	   
	   public CommunityImg selectCommunityImg(int communityno2) {
	Connection conn = getConnection();
	      
	      CommunityImg communityimg = new CommunityDao().selectCommunityImg(conn, communityno2);
	      ;
	            
	      close(conn);
	      
	      return communityimg;
	   }

	   
	   public Community modifyCommunity(int communityno) {
	   
	      
	   Connection conn = getConnection();
	   Community community  = new CommunityDao().modifyCommunity(conn, communityno);
	   
	   System.out.println("service: " + community);
	   
	   close(conn);
	   
	   return community;
	   }

	   

	   

	   public ArrayList<CommunityImg> modifyImgList(int communityno) {
	Connection conn = getConnection();
	      
	      ArrayList list = null;
	      
	      
	      CommunityDao cDao = new CommunityDao();
	      
	      list = cDao.modifyImgList(conn, communityno);
	      close(conn);
	      
	      return list;
	   }

	   public int deleteCommunity(String communityno) {
	   Connection conn = getConnection();
	   
	   int result=  new CommunityDao().deleteCommunity(conn,communityno);
	   System.out.println("service" + result);
	   if(result >0) {
	      commit(conn);
	   }else {
	      rollback(conn);
	   }
	   
	   
	   
	   close(conn);
	      return result;
	   }

>>>>>>> refs/remotes/origin/kimsung

	         
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

