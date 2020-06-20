package job.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import job.model.vo.Heart;
import job.model.vo.Job;

public class JobDao {

	public int registJob(Connection conn, Job j, int writer) {
		PreparedStatement pstmt=null;
		int result=0;
		
		String query="INSERT INTO JOBSEARCH VALUES(SEQ_JOBNO.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,0,SYSDATE,?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, j.getJobCategory());
			pstmt.setString(2, j.getPeriod());
			pstmt.setString(3, j.getLogoImg());
			pstmt.setInt(4, j.getRecruitment());
			pstmt.setString(5, j.getGender());
			pstmt.setString(6, j.getAge());
			pstmt.setString(7, j.getAddress());
			pstmt.setString(8, j.getPay());
			pstmt.setString(9, j.getDueDate());
			pstmt.setString(10, j.getWorktime());
			pstmt.setString(11, j.getWorkday());
			pstmt.setString(12, j.getTitle());
			pstmt.setString(13, j.getContent());
			pstmt.setString(14, j.getCountry());
			pstmt.setInt(15, writer);
			pstmt.setString(16, j.getChangeName());
			pstmt.setString(17, j.getFilePath());
			pstmt.setString(18, j.getCoName());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int getListCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		int result=0;
		
		String query="SELECT COUNT(*) FROM JOBSEARCH";
		
		try {
			pstmt=conn.prepareStatement(query);

			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				result=rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return result;
	}

	public ArrayList selectList(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		ArrayList list=new ArrayList();
		
		int startRow=(currentPage-1)*limit+1;
		int endRow=currentPage*limit;
		
		System.out.println("startRow : " + startRow + ", endRow : " + endRow);
		
		String query="SELECT * FROM (SELECT ROWNUM RNUM1, J.* FROM JSLIST J) WHERE RNUM1 BETWEEN ? AND ?";
//		String query="SELECT * FROM JSLIST WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				Job j=new Job(
									rset.getInt("jobno"),
									rset.getString("job"),
									rset.getString("period"),
									rset.getString("logoimg"),
									rset.getInt("recruitment"),
									rset.getString("gender"),
									rset.getString("age"),
									rset.getString("address"),
									rset.getString("pay"),
									rset.getString("duedate"),
									rset.getString("worktime"),
									rset.getString("workday"),
									rset.getString("title"),
									rset.getString("content"),
									rset.getInt("jobreport"),
									rset.getDate("writedate"),
									rset.getString("country"),
									rset.getString("userid"),
									rset.getString("changename"),
									rset.getString("filepath"),
									rset.getString("coname"));
				list.add(j);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}

	public Job selectJobList(Connection conn, int jno2) {
		PreparedStatement pstmt=null;
		ResultSet rset = null;
	
		Job j =null;
		
		String query = "SELECT * FROM JSLIST WHERE JOBNO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, jno2);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				j = new Job(
						rset.getInt("jobno"),
						rset.getString("job"),
						rset.getString("period"),
						rset.getString("logoimg"),
						rset.getInt("recruitment"),
						rset.getString("gender"),
						rset.getString("age"),
						rset.getString("address"),
						rset.getString("pay"),
						rset.getString("duedate"),
						rset.getString("worktime"),
						rset.getString("workday"),
						rset.getString("title"),
						rset.getString("content"),
						rset.getInt("jobreport"),
						rset.getDate("writedate"),
						rset.getString("country"),
						rset.getString("userid"),
						rset.getString("changename"),
						rset.getString("filepath"),
						rset.getString("coname")
						);
			}
			System.out.println("list dao : "+j);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return j;
	}
		

	public int updateJob(Connection conn, Job j) {
		PreparedStatement pstmt=null;
		int result=0;
		
		String query="UPDATE JOBSEARCH SET JOB=?,PERIOD=?,LOGOIMG=?,RECRUITMENT=?,GENDER=?,AGE=?,ADDRESS=?,PAY=?,DUEDATE=?,WORKTIME=?,WORKDAY=?,TITLE=?,CONTENT=?,JOBREPORT=?,WRITEDATE=SYSDATE,COUNTRYNO=?,USERNO=?,CHANGENAME=?,FILEPATH=?,CONAME=?\r\n" + 
				"WHERE JOBNO=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, j.getJobCategory());		// job
			pstmt.setString(2, j.getPeriod());			// period
			pstmt.setString(3, j.getLogoImg());			// logoimg
			pstmt.setInt(4, j.getRecruitment());		// recruitment
			pstmt.setString(5, j.getGender());			//gender
			pstmt.setString(6, j.getAge());				//age
			pstmt.setString(7, j.getAddress());			// address
			pstmt.setString(8, j.getPay());				// pay
			pstmt.setString(9, j.getDueDate());			//duedate
			pstmt.setString(10, j.getWorktime());		//worktime
			pstmt.setString(11, j.getWorkday());		//workday
			pstmt.setString(12, j.getTitle());			//title
			pstmt.setString(13, j.getContent());		//content
			pstmt.setInt(14, j.getJobReport());			//jobreport
			pstmt.setString(15, j.getCountry());		//countryno
			pstmt.setString(16, j.getUserId());			//userno
			pstmt.setString(17, j.getChangeName());		//changename
			pstmt.setString(18, j.getFilePath());		//filepath
			pstmt.setString(19, j.getCoName());			//coname
			pstmt.setInt(20, j.getJobNo());				//jobno
									
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteJob(Connection conn, int jobNo) {
		PreparedStatement pstmt=null;
		int result=0;
		
		String query="DELETE FROM JOBSEARCH WHERE JOBNO=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, jobNo);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Job savaJobData(Connection conn, int jobNo) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Job j = null;
		
		String query = "SELECT * FROM JSLIST WHERE JOBNO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, jobNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				j = new Job(
						rset.getInt("jobno"),
						rset.getString("job"),
						rset.getString("period"),
						rset.getString("logoimg"),
						rset.getInt("recruitment"),
						rset.getString("gender"),
						rset.getString("age"),
						rset.getString("address"),
						rset.getString("pay"),
						rset.getString("duedate"),
						rset.getString("worktime"),
						rset.getString("workday"),
						rset.getString("title"),
						rset.getString("content"),
						rset.getInt("jobreport"),
						rset.getDate("writedate"),
						rset.getString("country"),
						rset.getString("userid"),
						rset.getString("changename"),
						rset.getString("filepath"),
						rset.getString("coname"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return j;
	}

	public int jobJJim(Connection conn, Heart h) {
		PreparedStatement pstmt=null;
		int result=0;
		
		String query="INSERT INTO HEART VALUES(SEQ_HEART.NEXTVAL,?,?)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, h.getJobNo());
			pstmt.setInt(2, h.getUserNo());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList selectHlist(Connection conn, int userNo) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		ArrayList hlist=new ArrayList();
		
		String query="SELECT * FROM HEART WHERE USERNO=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Heart h=new Heart(
							rset.getInt("heartno"),
							rset.getInt("jobno"),
							rset.getInt("userno")
						);
				hlist.add(h);
				System.out.println("HEART리스트 : "+hlist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return hlist;
	}
	
	

}