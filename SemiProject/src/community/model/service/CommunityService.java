package community.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import community.model.dao.CommunityDao;
import community.model.vo.Community;
import community.model.vo.Community1;
import community.model.vo.CommunityImg;
import community.model.vo.Reply;

public class CommunityService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new CommunityDao().getListCount(conn);
		
		close(conn);
		return listCount;
	}
	public int insertCommunity(Community1 c) {
		Connection conn = getConnection();
		
		int result = new CommunityDao().insertCommunity(conn, c);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
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

	public Community selectCommunity(int communityno) {
	Connection conn = getConnection();
		
		Community community = new CommunityDao().selectCommunity(conn, communityno);
				
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
	
		if(result>0 && result1 >0) {
			commit(conn);
			result =1;
			
		}else {
			rollback(conn);
			result =0;
		}
		close(conn);
		System.out.println("result :"+result);
		System.out.println("result1 :"+result1);
		return result;
	
	}
	
	public CommunityImg selectCommunityImg(int communityno) {
Connection conn = getConnection();
		
		CommunityImg communityimg = new CommunityDao().selectCommunityImg(conn, communityno);
		System.out.println("serice"+communityimg);
				
		close(conn);
		
		return communityimg;
	}

	





}