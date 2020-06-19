package community.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import community.model.vo.Community;
import job.model.vo.JobSearch;

public class CommunityDao {

	public Community selectCommunity(Connection conn, int communityNo2, int categoryNo2) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String query = "SELECT * " + 
				"FROM CLIST" + 
				"WHERE COMMUNITYNO = ? AND CATEGORYNO = ?";
		
		Community community =null;
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, communityNo2);
			pstmt.setInt(2, categoryNo2);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				 community = new Community(rs.getInt("communityNo"),
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

	public int getListCount(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT COUNT(*) FROM CLIST WHERE USERNO=?";
		
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

	public ArrayList selectList(Connection conn, int currentPage, int limit, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList list = new ArrayList();
		
		int startRow = (currentPage-1) * limit + 1;
		int endRow = currentPage * limit;
		System.out.println(endRow);
		
		String query = "SELECT C.* FROM CLIST C WHERE (RNUM BETWEEN ? AND ? ) AND USERNO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, userNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
			Community community = new Community(rs.getInt("communityNo"),
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

