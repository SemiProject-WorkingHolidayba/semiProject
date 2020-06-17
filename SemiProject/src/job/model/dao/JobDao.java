package job.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import job.model.vo.Job;

public class JobDao {

//	public int registJob(Connection conn, Job j, ArrayList<Job> fileList) {
	public int registJob(Connection conn, Job j) {
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
			pstmt.setString(15, j.getUserId());
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

	public Job selecJobList(Connection conn, int jno2) {
		PreparedStatement pstmt=null;
		ResultSet rset = null;
		Job j = null;
		
		String query = "SELECT * FROM JSLIST WHERE JOBNO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, jno2);
			
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
	
	

}
