package common.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NletterListDao {

	public int getListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT COUNT(*) FROM CLIST ";
		
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

}
