package common.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import common.model.dao.NletterListDao;
import community.model.dao.CommunityDao;

public class NletterListService {

	public static int getListCount(int userNo) {
		Connection conn = getConnection();
		
		int listCount = new NletterListDao().getListCount(conn,userNo);
		
		
		close(conn);
		
		return listCount;
	}

	public ArrayList selectList(int currentPage, int limit, int userNo) {
		Connection conn = getConnection();
		
		ArrayList list = new NletterListDao().selectList(conn, currentPage, limit, userNo);
		
		close(conn);
		
		return list;
		
		
		
		
		
		
	}

}
