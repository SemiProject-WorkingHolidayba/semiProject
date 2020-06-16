package member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static common.JDBCTemplate.*;

import member.model.vo.Member;

public class MemberDao {

	public Member loginMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member loginUser=null;
		
		String query="SELECT * FROM MEMBER WHERE USERID = ? AND USERPW=? AND STATUS = 'N'";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPw());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				loginUser = new Member(rs.getInt("userno"),
									   rs.getString("userid"),
									   rs.getString("userpw"),
									   rs.getString("USERNAME"),
									   rs.getDate("USERBIRTH"),
									   rs.getString("PHONE"),
									   rs.getString("EMAIL"),
									   rs.getInt("grade"),
									   rs.getString("SANCTION"),
									   rs.getString("STATUS"),
									   rs.getString("GENDER"));
				
				
			}
			
//			System.out.println(loginUser);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return loginUser;
	}

	public String findUserId(Connection conn, String userName, String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userId="";
		String query="SELECT USERID FROM MEMBER WHERE USERNAME=? AND EMAIL=? AND STATUS='N'";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, email);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				userId=rs.getString("userid");
			}
//			System.out.println(userId);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return userId;

	}

}
