package common.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import common.model.dao.NletterListDao;
import community.model.dao.CommunityDao;

public class NletterListService {

	public static int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new NletterListDao().getListCount(conn);
		
		
		close(conn);
		
		return listCount;
	}

}
