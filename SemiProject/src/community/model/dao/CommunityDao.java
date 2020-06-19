package community.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import community.model.vo.Community;
import community.model.vo.Community1;
import community.model.vo.CommunityImg;
public class CommunityDao {

	public int getListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		
		String query = "SELECT COUNT(*) FROM COMMUNITY";
		
		int result = 0;
		
		try {
			pstmt= conn.prepareStatement(query);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
	
		
		return result;
	}

	public ArrayList selectList(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		ArrayList list = new ArrayList();
		int startRow = (currentPage-1) * limit +1;
		int endRow = currentPage*limit;
		
		System.out.println("startRow : " +startRow + ", endRow :" + endRow);
		String query ="SELECT * FROM CLIST WHERE RNUM BETWEEN ? AND ? AND (CATEGORYNAME='공지사항')";
		
		//************************** 바로위 수정 요망****************************>
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Community c = new Community(rs.getInt("communityno"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getDate("writedate"),
						rs.getInt("viewcount"),
						rs.getInt("report"),
						rs.getString("country"),
						rs.getString("categoryname"),
						rs.getString("userid"));

				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
	

		return list;
	}
//자유게시판 
	public ArrayList selectList1(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		ArrayList list = new ArrayList();
		int startRow = (currentPage-1) * limit +1;
		int endRow = currentPage*limit;
		
		System.out.println("startRow : " +startRow + ", endRow :" + endRow);
		String query ="SELECT * FROM CLIST WHERE RNUM BETWEEN ? AND ? AND (CATEGORYNAME='자유게시판')";
		
		//************************** 바로위 수정 요망****************************>
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
		
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Community c = new Community(rs.getInt("communityno"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getDate("writedate"),
						rs.getInt("viewcount"),
						rs.getInt("report"),
						rs.getString("country"),
						rs.getString("categoryname"),
						rs.getString("userid"));

				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
	

		return list;
	}
	public ArrayList selectList2(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		ArrayList list = new ArrayList();
		int startRow = (currentPage-1) * limit +1;
		int endRow = currentPage*limit;
		
		System.out.println("startRow : " +startRow + ", endRow :" + endRow);
		String query ="SELECT * FROM CLIST WHERE RNUM BETWEEN ? AND ? AND (CATEGORYNAME='질문게시판')";
		
		//************************** 바로위 수정 요망****************************>
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
		
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Community c = new Community(rs.getInt("communityno"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getDate("writedate"),
						rs.getInt("viewcount"),
						rs.getInt("report"),
						rs.getString("country"),
						rs.getString("categoryname"),
						rs.getString("userid"));

				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
	

		return list;
	}
	
	
	public ArrayList selectList3(Connection conn, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		ArrayList list = new ArrayList();
		int startRow = (currentPage-1) * limit +1;
		int endRow = currentPage*limit;
		
		System.out.println("startRow : " +startRow + ", endRow :" + endRow);
		String query ="SELECT * FROM CLIST WHERE RNUM BETWEEN ? AND ? AND (CATEGORYNAME='벼룩시장')";
		
		//************************** 바로위 수정 요망****************************>
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2, endRow);
		
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Community c = new Community(rs.getInt("communityno"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getDate("writedate"),
						rs.getInt("viewcount"),
						rs.getInt("report"),
						rs.getString("country"),
						rs.getString("categoryname"),
						rs.getString("userid"));

				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
	

		return list;
	}
	
	


	
	public int insertCommunity(Connection conn, Community1 c) {
		PreparedStatement pstmt = null;
		int result= 0;
		
		String query ="INSERT INTO COMMUNITY VALUES(SEQ_COMMUNITYNO.NEXTVAL,?,?,SYSDATE,0,0,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,c.getTitle());
			pstmt.setString(2,c.getContent());
			pstmt.setString(3,c.getCountryNo());
			pstmt.setString(4,c.getCategoryNo());
			pstmt.setInt(5, c.getUserNo());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertCommunityImg(Connection conn, ArrayList<CommunityImg> fileList) {
		PreparedStatement pstmt = null;
		int result= 0;
		
		String query = "INSERT INTO CommunityImg VALUES(SEQ_IMGNO.NEXTVAL, SEQ_COMMUNITYNO.CURRVAL,?,?,?,SYSDATE)";
		try {
		for(int i = 0 ; i <fileList.size();i++) {
			CommunityImg ci = fileList.get(i);
			
				
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, ci.getOriginName());
				pstmt.setString(2, ci.getChangeName());
				pstmt.setString(3, ci.getFilePath());
		
				
				
				result = pstmt.executeUpdate();
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		
	}
		return result;
}

	
	public int updateCount(Connection conn, int communityno2) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE COMMUNITY SET VIEWCOUNT = VIEWCOUNT+1 WHERE COMMUNITYNO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, communityno2);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Community selectCommunity(Connection conn, int communityno) {
		
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		Community community =null;
		String query ="SELECT * FROM CLIST WHERE COMMUNITYNO=?";
		
		//************************** 바로위 수정 요망****************************>
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, communityno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				community = new Community(rs.getInt("communityno"),
											rs.getString("title"),
											rs.getString("content"),
											rs.getDate("writedate"),
											rs.getInt("viewcount"),
											rs.getInt("report"),
											rs.getString("country"),
											rs.getString("categoryname"),
											rs.getString("userid"));
									

			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
	

		return community;
	}

	public int updateCommunity(Connection conn, Community1 c) {
		PreparedStatement pstmt = null;
		int result= 0;
		
		String query ="UPDATE COMMUNITY SET Title = ?, Content=?,WRITEDATE = SYSDATE,viewcount = 0,report = 0,CountryNO=?,CategoryNo=? where communityno=?"; 
				
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,c.getTitle());
			pstmt.setString(2,c.getContent());
			pstmt.setString(3,c.getCountryNo());
			pstmt.setString(4,c.getCategoryNo());
			pstmt.setInt(5, c.getCommunityNo());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int updateCommunityImg(Connection conn, ArrayList<CommunityImg> fileList) {
		PreparedStatement pstmt = null;
		int result= 0;
		
		String query = "UPDATE COMMUNITYIMG SET ORIGINNAME =? ,CHANGENAME=? ,FILEPATH = ? ,IMGNO=? WHERE CommunityNo=? ";
		try {
		for(int i = 0 ; i <fileList.size();i++) {
			CommunityImg ci = fileList.get(i);
			
				
				pstmt = conn.prepareStatement(query);
			
				pstmt.setString(1, ci.getOriginName());
				pstmt.setString(2, ci.getChangeName());
				pstmt.setString(3, ci.getFilePath());
				pstmt.setInt(4, ci.getImgNo());
				pstmt.setInt(5, ci.getCommunityNo());
				
				result = pstmt.executeUpdate();
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		
	}
		return result;
	}

	public CommunityImg selectCommunityImg(Connection conn, int communityno) {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		CommunityImg communityimg =null;
		String query ="SELECT * FROM COMMUNITYIMG WHERE COMMUNITYNO=?";
		
		//************************** 바로위 수정 요망****************************>
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, communityno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				communityimg = new CommunityImg(rs.getInt("imgno"),
											rs.getInt("communityno"),
											rs.getString("originname"),
											rs.getString("changename"),
											rs.getString("filepath"),
											rs.getDate("uploaddate"));
											
									

			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return communityimg;
	}
	}

