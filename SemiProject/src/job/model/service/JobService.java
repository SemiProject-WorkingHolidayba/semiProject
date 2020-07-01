package job.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import job.model.dao.JobDao;
import job.model.vo.Heart;
import job.model.vo.Job;
import job.model.vo.JobApply;
import job.model.vo.JobReview;

import static common.JDBCTemplate.*;

public class JobService {

   public int insertBoard(Job j, int userNo) {
      Connection conn=getConnection();
      
      int result=new JobDao().registJob(conn,j,userNo);
      
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

   public int updateJobBoard(Job j, int jobNo, int userNo) {
      Connection conn=getConnection();
      
      int result=new JobDao().updateJob(conn,j,jobNo, userNo);
      
      
      System.out.println("서비스에서 리절트 : "+result);
      
      if(result>0) {
         commit(conn);
      }else {
         rollback(conn);
      }
      
      close(conn);
      return result;
   }

   public int deleteJob(int jobNo,int userNo) {
         Connection conn=getConnection();
         
         int result=new JobDao().deleteJob(conn,jobNo,userNo);
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

   public int deleteHeart(int jobNo) {
      Connection conn=getConnection();
      
      int result=new JobDao().deleteHeart(conn,jobNo);
      System.out.println("서비스에서 딜리트하트 : "+result);
      
      if(result>0) {
         commit(conn);
      }else {
         rollback(conn);
      }
      
      close(conn);
      return result;
   }

   public Heart selectHeart(int jobNo, int userNo) {
      Connection conn=getConnection();
      
      Heart h=new JobDao().selectHeart(conn,jobNo, userNo);
            
      close(conn);
      return h;
   }

   public int deleteDetailHeart(int jobNo, int userNo) {
      Connection conn=getConnection();
      
      int result=new JobDao().deleteHeart(conn,jobNo,userNo);
      System.out.println("서비스에서 딜리트하트 : "+result);
      
      if(result>0) {
         commit(conn);
      }else {
         rollback(conn);
      }
      
      close(conn);
      return result;
   }

   public int jobDetailJJim(int jobNo, int userNo) {
      Connection conn=getConnection();
      
      int result=new JobDao().jobDetailJJim(conn,jobNo,userNo);
      System.out.println("서비스에서 딜리트하트 : "+result);
      
      if(result>0) {
         commit(conn);
      }else {
         rollback(conn);
      }
      
      close(conn);
      return result;
   }

   public int insertJobApply(JobApply j, int userNo, int jobNo) {
      Connection conn=getConnection();
      
      int result=new JobDao().insertJobApply(conn,j,userNo,jobNo);
      
      if(result>0) {
         commit(conn);
      }else {
         rollback(conn);
      }
      
      close(conn);
      return result;
   }

   public int getSearchListCount(String[] nationArr, String[] jobCategoryArr, String[] termArr, String[] weekArr) {
      Connection conn=getConnection();
      
      int listCount=new JobDao().getSearchListCount(conn,nationArr,jobCategoryArr,termArr, weekArr);
      
      close(conn);
      return listCount;
   }

   public ArrayList searchSelectList(int currentPage, int limit, String[] nationArr, String[] jobCategoryArr,
         String[] termArr, String[] weekArr) {
      Connection conn= getConnection();
      
      ArrayList list=new JobDao().searchSelectList(conn, currentPage, limit,nationArr,jobCategoryArr,termArr,weekArr);
      
      close(conn);
      return list;
   }

   public int jobReport(int jobNo, int writer) {
      Connection conn=getConnection();
      
      int result=new JobDao().jobReport(conn, jobNo, writer);
      
      if(result>0) {
         commit(conn);
      }else {
         rollback(conn);
      }
      
      close(conn);
      return result;
   }

   public Job selectUserNo(int jobNo, String userId) {
      Connection conn=getConnection();
      
      Job j=new JobDao().selectUserNo(conn, jobNo, userId);
      
      close(conn);
      
      return j;
   }

   public void insertReview(JobReview r) {
      Connection conn = getConnection();
      
      JobDao jDao = new JobDao();
      
      int result = jDao.insertReply(conn,r);
      
      
      ArrayList<JobReview> rlist = new ArrayList<>();
      if(result > 0 ) {
         commit(conn);
         rlist = jDao.selectReplyList(conn, r.getReviewNo());
         
      }else {
         rollback(conn);
         
      }
      
   }

public int selectJobNo(int boardno) {
	Connection conn = getConnection();
	
	int jobNo = new JobDao().selectJobNo(conn, boardno);
	
	
	close(conn);
	return jobNo;
}

   
}