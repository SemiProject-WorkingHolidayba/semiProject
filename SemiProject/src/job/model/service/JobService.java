package job.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import job.model.dao.JobDao;
import job.model.vo.Job;
import static common.JDBCTemplate.*;

public class JobService {

	public int insertBoard(Job j) {
		Connection conn=getConnection();
		
		int result=new JobDao().registJob(conn,j);
		
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
		
		Job j=new JobDao().selecJobList(conn, jno2);
		
		close(conn);
		
		return j;
	}

}
