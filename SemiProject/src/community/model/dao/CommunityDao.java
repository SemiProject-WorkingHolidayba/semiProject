package community.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import community.model.vo.Community;
import community.model.vo.Community1;
import community.model.vo.CommunityImg;
import community.model.vo.CommunityMy;


public class CommunityDao {
	
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


