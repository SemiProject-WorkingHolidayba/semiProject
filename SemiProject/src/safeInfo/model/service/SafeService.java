package safeInfo.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import community.model.dao.CommunityDao;
import community.model.vo.Community;
import safeInfo.model.dao.SafeDao;
import safeInfo.model.vo.Safe;

public class SafeService {

	public int insertSafe(Safe s) {
		Connection conn = getConnection();
	      
	      int result = new SafeDao().insertSafe(conn,s);
	      
	      if(result>0) {
	         commit(conn);
	      }else {
	         rollback(conn);
	      }
	      close(conn);
	      
	      return result;
	}

	public int getListCount() {
		Connection conn = getConnection();
	      
      int listCount = new SafeDao().getListCount(conn);
      
      close(conn);
      return listCount;
	}

	public ArrayList<Safe> selectList(int currentPage, int limit) {
		 Connection conn = getConnection();
	      ArrayList list = new SafeDao().selectList(conn,currentPage,limit);
	      close(conn);
	      return list;
	}

	public int updateCount(int sNo) {
		Connection conn = getConnection();
	      
	      int result = new SafeDao().updateCount(conn,sNo);
	      
	      if(result>0) {
	         commit(conn);
	      }else {
	         rollback(conn);
	      }
	      close(conn);
	      return result;
	}

	public Safe selectCommunity(int sNo) {
		Connection conn = getConnection();
	      
	      Safe s = new SafeDao().selectSafe(conn, sNo);
	            
	      close(conn);
	      
	      return s;
	}

}
