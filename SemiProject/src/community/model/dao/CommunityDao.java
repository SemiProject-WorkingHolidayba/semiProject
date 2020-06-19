package community.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import community.model.vo.CommunityMy;


public class CommunityDao {

	public CommunityMy selectcCommunity(Connection conn, int communityNo2, int categoryNo2) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String query = "SELECT * " + 
				"FROM MYCLIST" + 
				"WHERE COMMUNITYNO = ? AND CATEGORYNO = ?";
		
		CommunityMy community =null;
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, communityNo2);
			pstmt.setInt(2, categoryNo2);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				 community = new CommunityMy(rs.getInt("communityNo"),
											rs.getString("title"),
											rs.getString("content"),
											rs.getDate("writeDate"),
											rs.getInt("viewCount"),
											rs.getInt("report"),	
											rs.getString("countryNo"),
											rs.getString("categoryNo"),
											rs.getInt("userNo"),
											rs.getString("categoryName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
	
			return community;
	}

	public int getcListCount(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT COUNT(*) FROM MYCLIST WHERE USERNO=?";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
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

	public ArrayList selectcList(Connection conn, int currentPage, int limit, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList list = new ArrayList();
		
		int startRow = (currentPage-1) * limit + 1;
		int endRow = currentPage * limit;
		System.out.println(endRow);
		
		String query = "SELECT C.* FROM MYCLIST C WHERE (RNUM BETWEEN ? AND ? ) AND USERNO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, userNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				CommunityMy community = new CommunityMy(rs.getInt("communityNo"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getDate("writeDate"),
						rs.getInt("viewCount"),
						rs.getInt("report"),	
						rs.getString("countryNo"),
						rs.getString("categoryNo"),
						rs.getInt("userNo"),
						rs.getString("categoryName"));
				list.add(community);
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

