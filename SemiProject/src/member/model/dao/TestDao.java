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
			query = "UPDATE COMMUNITY SET STATUS = 'Y' WHERE COMMUNITYNO = ?";
			break;
		case 4:
			query = "UPDATE COMMENTS SET STATUS = 'Y' WHERE COMMENTNO = ?";
			break;
		case 5:
			query = "UPDATE JOBSEARCH SET STATUS = 'Y' WHERE JOBNO = ?";
			break;
		case 6:
			query = "UPDATE JOBREVIEW SET STATUS = 'Y' WHERE REVIEWNO = ?";
			break;
		case 7:
			query = "UPDATE HOME SET WHERE STATUS = 'Y' HOUSENO = ?";
			break;
		case 8:
			query = "UPDATE HOMEREVIEW SET STATUS = 'Y' WHERE REVIEWNO=?";
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
