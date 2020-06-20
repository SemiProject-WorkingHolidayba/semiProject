package job.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import job.model.dao.JobDao;
import job.model.vo.Heart;
import job.model.vo.Job;
import static common.JDBCTemplate.*;

public class JobService {

	public int insertBoard(Job j, int writer) {
		Connection conn=getConnection();
		
		int result=new JobDao().registJob(conn,j,writer);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int getListCount() {
		Connection conn=getConnection();
		
		int listCount=new JobDao().getListCount(conn);
		
		close(conn);
		return listCount;
	}

	public ArrayList selectList(int currentPage, int limit) {
		Connection conn= getConnection();
		
		ArrayList list=new JobDao().selectList(conn, currentPage, limit);
		System.out.println("JobService list값 : " + list);
		
		close(conn);
		return list;
	}

	public Job selectJobList(int jno2) {
		Connection conn=getConnection();
		
		Job j=new JobDao().selectJobList(conn, jno2);
		
		close(conn);
		
		return j;
	}

	public int updateJobBoard(Job j) {
		Connection conn=getConnection();
		
		int result=new JobDao().updateJob(conn,j);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int deleteJob(int jobNo) {
		Connection conn=getConnection();
		
		int result=new JobDao().deleteJob(conn,jobNo);
		System.out.println("서비스에서 리절트: "+result);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public Job saveJobData(int jobNo) {
		Connection conn=getConnection();
		
		Job j=new JobDao().savaJobData(conn,jobNo);
				
		close(conn);
		return j;
	}

	public int jobJJim(Heart h) {
		Connection conn=getConnection();
		
		int result=new JobDao().jobJJim(conn,h);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public ArrayList selectHlist(int userNo) {
		Connection conn=getConnection();
		
		ArrayList hlist=new JobDao().selectHlist(conn,userNo);
		
		
		close(conn);
		return hlist;
	}

	
}
