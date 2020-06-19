package community.model.service;


import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import community.model.dao.CommunityDao;
import community.model.vo.CommunityMy;


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

}
