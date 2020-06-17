package job.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import job.model.vo.JobApplicator;
import job.model.vo.JobSearch;

public class JobSearchDao {

	public int getListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT COUNT(*) FROM HLIST ";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
	
	}

	public ArrayList selectList(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList list = new ArrayList();
		
		int startRow = (currentPage-1) * limit + 1;
		int endRow = currentPage * limit;
		
		
		String query = "SELECT * FROM (SELECT J.* FROM JLIST J) WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				JobSearch j = new JobSearch(rs.getInt("jobNo"),
											rs.getString("job"),
											rs.getString("period"),
											rs.getString("logoImg"),
											rs.getInt("recruitment"),
											rs.getString("gender"),	
											rs.getString("age"),
											rs.getString("address"),
											rs.getString("pay"),
											rs.getDate("dueDate"),
											rs.getDate("workTime"),
											rs.getString("workDay"),
											rs.getString("title"),
											rs.getString("content"),
											rs.getInt("jobReport"),
											rs.getDate("writeDate"),
											rs.getString("countryNo"),
											rs.getInt("userNo"),
											rs.getString("changename"),
											rs.getString("country"),
											rs.getInt("heartNo"),
											rs.getInt("jobApplyNo"),
											rs.getDate("jobApplyDate"),
											rs.getString("jobTypeNo"),
											rs.getString("filePath"),
											rs.getString("coName")
											);
				list.add(j);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
		
		
		
	}

	public JobSearch selectJobSearch(Connection conn, int jobNo2, int heartNo2) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			String query = "SELECT J.*" + 
					"FROM JLIST J " + 
					"JOIN HLIST H ON J.JOBNO = H.JOBNO" + 
					"WHERE H.HEARTNO = ? AND J.JOBNO =?";
			
			JobSearch jsearch =null;
			
			try {
				pstmt =conn.prepareStatement(query);
				pstmt.setInt(1, heartNo2);
				pstmt.setInt(2, jobNo2);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					 jsearch = new JobSearch(rs.getInt("jobNo"),
												rs.getString("job"),
												rs.getString("period"),
												rs.getString("logoImg"),
												rs.getInt("recruitment"),
												rs.getString("gender"),	
												rs.getString("age"),
												rs.getString("address"),
												rs.getString("pay"),
												rs.getDate("dueDate"),
												rs.getDate("workTime"),
												rs.getString("workDay"),
												rs.getString("title"),
												rs.getString("content"),
												rs.getInt("jobReport"),
												rs.getDate("writeDate"),
												rs.getString("countryNo"),
												rs.getInt("userNo"),
												rs.getString("changename"),
												rs.getString("country"),
												rs.getInt("heartNo"),
												rs.getInt("jobApplyNo"),
												rs.getDate("jobApplyDate"),
												rs.getString("jobTypeNo"),
												rs.getString("filePath"),
												rs.getString("coName"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rs);
			}
		
				return jsearch;
	}

	public ArrayList deleteHeart(Connection conn, int userNo, int heartNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList list = new ArrayList();
		
		
		String query = "DELETE FROM (SELECT * FROM HEART H JOIN JOBSEARCH J ON (J.USERNO = H.USERNO) AND (J.JOBNO = H.JOBNO)" + 
				"WHERE HEARTNO = ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,heartNo);
		
			
			rs = pstmt.executeQuery();
			JobSearch j = null;
			while(rs.next()) {
				 j = new JobSearch(rs.getInt("jobNo"),
											rs.getString("job"),
											rs.getString("period"),
											rs.getString("logoImg"),
											rs.getInt("recruitment"),
											rs.getString("gender"),	
											rs.getString("age"),
											rs.getString("address"),
											rs.getString("pay"),
											rs.getDate("dueDate"),
											rs.getDate("workTime"),
											rs.getString("workDay"),
											rs.getString("title"),
											rs.getString("content"),
											rs.getInt("jobReport"),
											rs.getDate("writeDate"),
											rs.getString("countryNo"),
											rs.getInt("userNo"),
											rs.getString("changename"),
											rs.getString("country"),
											rs.getInt("heartNo"),
											rs.getInt("jobApplyNo"),
											rs.getDate("jobApplyDate"),
											rs.getString("jobTypeNo"),
											rs.getString("filePath"),
											rs.getString("coName"));
				 list.add(j);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
		

	}

	public int getAListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT COUNT(*) FROM ALIST ";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
		
	}

	public ArrayList selectListA(Connection conn, int currentPage, int limit) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList list = new ArrayList();
		
		int startRow = (currentPage-1) * limit + 1;
		int endRow = currentPage * limit;
		
		
		String query = "SELECT * FROM (SELECT A.* FROM ALIST A) WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				JobSearch j = new JobSearch(rs.getInt("jobNo"),
											rs.getString("job"),
											rs.getString("period"),
											rs.getString("logoImg"),
											rs.getInt("recruitment"),
											rs.getString("gender"),	
											rs.getString("age"),
											rs.getString("address"),
											rs.getString("pay"),
											rs.getDate("dueDate"),
											rs.getDate("workTime"),
											rs.getString("workDay"),
											rs.getString("title"),
											rs.getString("content"),
											rs.getInt("jobReport"),
											rs.getDate("writeDate"),
											rs.getString("countryNo"),
											rs.getInt("userNo"),
											rs.getString("changename"),
											rs.getString("country"),
											rs.getInt("heartNo"),
											rs.getInt("jobApplyNo"),
											rs.getDate("jobApplyDate"),
											rs.getString("jobTypeNo"),
											rs.getString("filePath"),
											rs.getString("coName"));
				list.add(j);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
		
	
	}

	public JobSearch selectApplication(Connection conn, int jobNo2, int userNo2) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String query = "SELECT * FROM ALIST WHERE USERNO =? AND JOBNO = ?";
		
		JobSearch jsearch = null;
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, userNo2);
			pstmt.setInt(2, jobNo2);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				 jsearch = new JobSearch(rs.getInt("jobNo"),
											rs.getString("job"),
											rs.getString("period"),
											rs.getString("logoImg"),
											rs.getInt("recruitment"),
											rs.getString("gender"),	
											rs.getString("age"),
											rs.getString("address"),
											rs.getString("pay"),
											rs.getDate("dueDate"),
											rs.getDate("workTime"),
											rs.getString("workDay"),
											rs.getString("title"),
											rs.getString("content"),
											rs.getInt("jobReport"),
											rs.getDate("writeDate"),
											rs.getString("countryNo"),
											rs.getInt("userNo"),
											rs.getString("changename"),
											rs.getString("country"),
											rs.getInt("heartNo"),
											rs.getInt("jobApplyNo"),
											rs.getDate("jobApplyDate"),
											rs.getString("jobTypeNo"),
											rs.getString("filePath"),
											rs.getString("coName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
	
			return jsearch;
	}

	public ArrayList deleteA(Connection conn, int jobApplyNo2) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList list = new ArrayList();
		
		
		String query = "DELETE FROM (SELECT * FROM JOBAPPLICATION J JOIN JOBSEARCH R ON (J.JOBNO = R.JOBNO) AND (J.USERNO = R.USERNO)" + 
				"WHERE JOBAPPLYNO = ? )";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,jobApplyNo2);
		
			
			rs = pstmt.executeQuery();
			JobSearch j = null;
			while(rs.next()) {
				 j = new JobSearch(rs.getInt("jobNo"),
											rs.getString("job"),
											rs.getString("period"),
											rs.getString("logoImg"),
											rs.getInt("recruitment"),
											rs.getString("gender"),	
											rs.getString("age"),
											rs.getString("address"),
											rs.getString("pay"),
											rs.getDate("dueDate"),
											rs.getDate("workTime"),
											rs.getString("workDay"),
											rs.getString("title"),
											rs.getString("content"),
											rs.getInt("jobReport"),
											rs.getDate("writeDate"),
											rs.getString("countryNo"),
											rs.getInt("userNo"),
											rs.getString("changename"),
											rs.getString("country"),
											rs.getInt("heartNo"),
											rs.getInt("jobApplyNo"),
											rs.getDate("jobApplyDate"),
											rs.getString("jobTypeNo"),
											rs.getString("filePath"),
											rs.getString("coName")
											);
				 list.add(j);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	
	
	
	}

	public int getJaListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT COUNT(*) FROM ARESERVATIONLIST ";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return result;
		
	}

	public ArrayList selectListJa(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList list = new ArrayList();
		
		int startRow = (currentPage-1) * limit + 1;
		int endRow = currentPage * limit;
		
		
		String query = "SELECT * FROM (SELECT A.* FROM ARESERVATIONLIST A) WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				JobApplicator j = new JobApplicator(rs.getInt("jobApplyNo"),
											rs.getString("title"),
											rs.getString("userName"),										
											rs.getString("period"),
											rs.getString("email"));
				list.add(j);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}

}
