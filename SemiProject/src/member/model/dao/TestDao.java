package member.model.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.vo.Report;


public class TestDao {



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
