package common.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import common.model.vo.NletterList;

public class NletterListDao {

	public int getListCount(Connection conn,int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "SELECT COUNT(*) FROM(\r\n" + 
				"             SELECT ROWNUM RNUM,JOBNO,L.TYPENAME,TITLE,WRITEDATE \r\n" + 
				"				 FROM JOBSEARCH J  \r\n" + 
				"				JOIN LETTERTYPE L ON L.TYPENO=J.TYPENO\r\n" + 
				"				 WHERE USERNO=? \r\n" + 
				"             UNION \r\n" + 
				"				 SELECT ROWNUM RNUM, HOUSENO,L.TYPENAME,TITLE,WRITEDATE \r\n" + 
				"				 FROM HOME H\r\n" + 
				"             JOIN LETTERTYPE L ON L.TYPENO=H.TYPENO \r\n" + 
				"				 WHERE USERNO=? \r\n" + 
				"				 UNION \r\n" + 
				"				 SELECT ROWNUM RNUM,COMMUNITYNO,L.TYPENAME,TITLE,WRITEDATE  \r\n" + 
				"				FROM COMMUNITY C\r\n" + 
				"				JOIN LETTERTYPE L ON L.TYPENO=C.TYPENO \r\n" + 
				"				WHERE USERNO=?\r\n" + 
				"				 ORDER BY WRITEDATE)";
		
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, userNo);
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
		System.out.println("내가 endRow :" +endRow+"내가 SRow :" +startRow );
		
		String query = " select * from(select rownum rr, ff.* from(SELECT RNUM, JOBNO , TYPENAME, TITLE, WRITEDATE FROM(                  \r\n" + 
				" SELECT ROWNUM RNUM,JOBNO,L.TYPENAME,TITLE,WRITEDATE\r\n" + 
				" FROM JOBSEARCH J \r\n" + 
				" JOIN LETTERTYPE L ON L.TYPENO=J.TYPENO\r\n" + 
				" WHERE USERNO=?\r\n" + 
				" UNION\r\n" + 
				" SELECT ROWNUM RNUM, HOUSENO,L.TYPENAME,TITLE,WRITEDATE\r\n" + 
				" FROM HOME H\r\n" + 
				" JOIN LETTERTYPE L ON L.TYPENO=H.TYPENO\r\n" + 
				" WHERE USERNO=?\r\n" + 
				" UNION\r\n" + 
				" SELECT ROWNUM RNUM,COMMUNITYNO,L.TYPENAME,TITLE,WRITEDATE \r\n" + 
				" FROM COMMUNITY C\r\n" + 
				"JOIN LETTERTYPE L ON L.TYPENO=C.TYPENO\r\n" + 
				"WHERE USERNO=?\r\n" + 
				" ORDER BY WRITEDATE desc) ) ff)\r\n" + 
				" WHERE rr BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, userNo);
			pstmt.setInt(4,startRow);
			pstmt.setInt(5, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
			NletterList nletter = new NletterList(
						rs.getInt("jobNo"),
						rs.getString("typeName"),
						rs.getString("title"),
						rs.getDate("writeDate"));
			
			
				list.add(nletter);
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
