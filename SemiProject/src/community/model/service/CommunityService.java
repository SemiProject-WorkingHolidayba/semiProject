package community.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import community.model.dao.CommunityDao;
import community.model.vo.Community;
import job.model.dao.JobSearchDao;
import job.model.vo.JobSearch;

public class CommunityService {

	public Community selectCommunity(int communityNo2, int categoryNo2) {

		Connection conn = getConnection();
		
		Community community = new CommunityDao().selectCommunity(conn, communityNo2, categoryNo2);
		
		close(conn);
		return community;
	}

	public static int getListCount(int userNo) {
		Connection conn = getConnection();
		
		int listCount = new CommunityDao().getListCount(conn, userNo);
		
		
		close(conn);
		
		return listCount;
	}

	public static ArrayList selectList(int currentPage, int limit,int userNo) {
		Connection conn = getConnection();
		
		ArrayList list = new CommunityDao().selectList(conn, currentPage, limit, userNo);
		
		close(conn);
		
		return list;
	
	
	
	}

}
