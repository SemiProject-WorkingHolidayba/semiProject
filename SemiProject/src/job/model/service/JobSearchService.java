package job.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import job.model.dao.JobSearchDao;
import job.model.vo.JobSearch;

public class JobSearchService {

   public int getListCount(int userNo) {
      Connection conn = getConnection();
      
      int listCount = new JobSearchDao().getListCount(conn,userNo);
      
      
      close(conn);
      
      return listCount;
      
      
   }

   public ArrayList selectList(int currentPage, int limit, int userNo) {
      Connection conn = getConnection();
      
      ArrayList list = new JobSearchDao().selectList(conn, currentPage, limit,userNo);
      
      close(conn);
      
      return list;
      
   
   }

   public JobSearch selectJobSearch(int jobNo2, int heartNo2) {
      Connection conn = getConnection();
      
      JobSearch jsearch = new JobSearchDao().selectJobSearch(conn, jobNo2, heartNo2);
      
      close(conn);
      
      return jsearch;
      
   }

   public int deleteHeart(int userNo, int heartNo2) {
      Connection conn = getConnection();
      
      int result = new JobSearchDao().deleteHeart(conn,userNo, heartNo2);
      
      
      close(conn);
      
      return result;
   }

   public int getAListCount(int userNo) {
      Connection conn = getConnection();
      
      int AlistCount = new JobSearchDao().getAListCount(conn,userNo);
      
      
      close(conn);
      
      return AlistCount;
      

   }

   public ArrayList selectListA(int currentPage, int limit, int userNo) {

      
      Connection conn = getConnection();
      
      ArrayList list = new JobSearchDao().selectListA(conn, currentPage, limit, userNo);
      
      close(conn);
      
      return list;
      

   }

   public JobSearch selectApplication(int jobNo2, int userNo2) {
      Connection conn = getConnection();
      
      JobSearch jsearch = new JobSearchDao().selectApplication(conn, jobNo2, userNo2);
      
      close(conn);
      
      return jsearch;
   }

   public int deleteA(int jobApplyNo2, int userNo) {
      Connection conn = getConnection();
      
      int result = new JobSearchDao().deleteA(conn,jobApplyNo2, userNo);
      
      
      close(conn);
      
      return result;
   }

   public int getJaListCount(int userNo) {
      Connection conn = getConnection();
      
      int jalistCount = new JobSearchDao().getJaListCount(conn,userNo);
      
      close(conn);
      
      return jalistCount;
      
   }

   public ArrayList selectListJa(int currentPage, int limit,int userNo) {
      
      Connection conn = getConnection();
      
      ArrayList list = new JobSearchDao().selectListJa(conn, currentPage, limit,userNo);
      
      close(conn);
      
      return list;
      
      
      
      
   }

}