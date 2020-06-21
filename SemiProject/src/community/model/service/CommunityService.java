package community.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import community.model.dao.CommunityDao;
import community.model.vo.Comment;
import community.model.vo.Community;
import community.model.vo.Community1;
import community.model.vo.CommunityImg;

import community.model.vo.CommunityMy;

import home.model.dao.HomeDao;




public class CommunityService {
	
	

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

		   public ArrayList<Comment> insertComment(Comment c) {
		      Connection conn =getConnection();
		      
		      CommunityDao cDao = new CommunityDao();
		      int result = cDao.insertComment(conn,c);

		      ArrayList<Comment> colist =new ArrayList<>();
		      if(result >0) {
		         commit(conn);
		      colist=   cDao.selectCommentList(conn,c.getCommunityNo());
		      }else {
		         rollback(conn);
		      }
		      return colist;
		   }

		   public ArrayList<Comment> selectCommentList(int communityno2) {
		Connection conn = getConnection();
		      
		      ArrayList<Comment> colist = new CommunityDao().selectCommentList(conn,communityno2);
		      
		      close(conn);
		      
		      return colist;
		   }

		   public Community1 selectCommunity1(int communityno2) {
		   Connection conn = getConnection();
		      
		      Community1 community1 = new CommunityDao().selectCommunity1(conn, communityno2);
		            
		      close(conn);
		      
		      return community1;
		   
		   }

		   public int reportCommunity(int communityno) {
		      Connection conn = getConnection();
		      CommunityDao cDao= new CommunityDao();
		      
		      int result = cDao.reportCommunity(conn,communityno);
		      
		      if(result >0) {
		         commit(conn);
		         
		      }else {
		         rollback(conn);
		      }
		      close(conn);
		      
		      return result;
		   }

		   public ArrayList<Community> searchList(String selectbox, String searchbox) {
		      Connection conn =getConnection();
		      ArrayList list = new CommunityDao().searchList(conn, selectbox, searchbox);
		      close(conn);
		      
		      return list;
		   }

		   

		   public int deleteComment(int commentNo) {
		Connection conn = getConnection();
		      
		      int result = new CommunityDao().deleteComment(conn, commentNo);
		      
		      if(result > 0) {
		         commit(conn);
		      } else {
		         rollback(conn);
		      }
		      
		      close(conn);
		      
		      return result;

		   }



}



