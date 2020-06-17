package job.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import job.model.dao.JobSearchDao;
import job.model.vo.JobSearch;
public class JobSearchService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = new JobSearchDao().getListCount(conn);
		
		
		close(conn);
		
		return listCount;
		
		
	}

	public ArrayList selectList(int currentPage, int limit) {
		Connection conn = getConnection();
		
		ArrayList list = new JobSearchDao().selectList(conn, currentPage, limit);
		
		close(conn);
		
		return list;
		
	
	}

	public JobSearch selectJobSearch(int jobNo2, int heartNo2) {
		Connection conn = getConnection();
		
		JobSearch jsearch = new JobSearchDao().selectJobSearch(conn, jobNo2, heartNo2);
		
		close(conn);
		
		return jsearch;
		
	}

	public ArrayList deleteHeart(int userNo, int heartNo) {
		Connection conn = getConnection();
		
		ArrayList list = new JobSearchDao().deleteHeart(conn,userNo, heartNo);
		
		
		close(conn);
		
		return list;
	}

	public int getAListCount() {
		Connection conn = getConnection();
		
		int AlistCount = new JobSearchDao().getAListCount(conn);
		
		
		close(conn);
		
		return AlistCount;
		

	}

	public ArrayList selectListA(int currentPage, int limit) {

		
		Connection conn = getConnection();
		
		ArrayList list = new JobSearchDao().selectListA(conn, currentPage, limit);
		
		close(conn);
		
		return list;
		

	}

	public JobSearch selectApplication(int jobNo2, int userNo2) {
		Connection conn = getConnection();
		
		JobSearch jsearch = new JobSearchDao().selectApplication(conn, jobNo2, userNo2);
		
		close(conn);
		
		return jsearch;
	}

	public ArrayList<JobSearch> deleteA(int jobApplyNo2) {
		Connection conn = getConnection();
		
		ArrayList list = new JobSearchDao().deleteA(conn,jobApplyNo2);
		
		
		close(conn);
		
		return list;
	}

	public int getJaListCount() {
		Connection conn = getConnection();
		
		int jalistCount = new JobSearchDao().getJaListCount(conn);
		
		close(conn);
		
		return jalistCount;
		
	}

	public ArrayList selectListJa(int currentPage, int limit) {
		
		Connection conn = getConnection();
		
		ArrayList list = new JobSearchDao().selectListJa(conn, currentPage, limit);
		
		close(conn);
		
		return list;
		
		
		
		
	}

}
