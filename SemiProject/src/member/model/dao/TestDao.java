package member.model.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.vo.Report;


public class TestDao {

	public Report SelectCommunityUserId(int boardno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Report uploaduserinfo=null;
		String query="SELECT USERNO,USERID FROM MEMBER WHERE USERNO = ( SELECT USERNO FROM COMMUNITY WHERE COMMUNITYNO = ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				uploaduserinfo = new Report(rs.getInt("userno"),rs.getString("userid"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return uploaduserinfo;
	}

	public Report  SelectCommentUserId(int boardno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Report uploaduserinfo=null;
		
		String query="SELECT USERNO,USERID FROM MEMBER WHERE USERNO = ( SELECT USERNO FROM COMMENTS WHERE COMMENTNO = ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				uploaduserinfo = new Report(rs.getInt("userno"),rs.getString("userid"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return uploaduserinfo;
	}

	public  Report  SelectJobsearchUserId(int boardno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Report uploaduserinfo=null;
		String query="SELECT USERNO,USERID FROM MEMBER WHERE USERNO = ( SELECT USERNO FROM JOBSEARCH WHERE JOBNO = ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				uploaduserinfo = new Report(rs.getInt("userno"),rs.getString("userid"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return uploaduserinfo;
	}

	public Report SelectJobreviewUserId(int boardno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Report uploaduserinfo=null;
		String query="SELECT USERNO,USERID FROM MEMBER WHERE USERNO = ( SELECT USERNO FROM JOBREVIEW WHERE REVIEWNO =?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				uploaduserinfo = new Report(rs.getInt("userno"),rs.getString("userid"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return uploaduserinfo;
	}

	public Report SelectHomeUserId(int boardno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Report uploaduserinfo=null;
		String query="SELECT USERNO,USERID FROM MEMBER WHERE USERNO = ( SELECT USERNO FROM HOME WHERE HOUSENO =? )";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				uploaduserinfo = new Report(rs.getInt("userno"),rs.getString("userid"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return uploaduserinfo;
	}

	public Report SelectHomeReviewUserId(int boardno) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Report uploaduserinfo=null;
		String query="SELECT USERNO,USERID FROM MEMBER WHERE USERNO = ( SELECT USERNO FROM HOMEREVIEW WHERE REVIEWNO =? )";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				uploaduserinfo = new Report(rs.getInt("userno"),rs.getString("userid"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return uploaduserinfo;
	}

	public int ReportDeleteBoard(Connection conn, int categoryNo, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="";
		switch (categoryNo) {
		case 1: 
		case 2:
		case 3:
			query = "DELETE FROM COMMUNITY WHERE COMMUNITYNO = ?";
			break;
		case 4:
			query = "DELETE FROM COMMENTS WHERE COMMENTNO = ?";
			break;
		case 5:
			query = "DELETE FROM JOBSEARCH WHERE JOBNO = ?";
			break;
		case 6:
			query = "DELETE FROM JOBREVIEW WHERE REVIEWNO = ?";
			break;
		case 7:
			query = "DELETE FROM HOME WHERE HOUSENO = ?";
			break;
		case 8:
			query = "DELETE FROM HOMEREVIEW WHERE REVIEWNO=?";
			break;
		default:
			break;
		}
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
