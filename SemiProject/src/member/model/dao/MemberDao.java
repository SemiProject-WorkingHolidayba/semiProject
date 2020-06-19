package member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static common.JDBCTemplate.*;

import member.model.service.MemberService;
import member.model.vo.Member;
import member.model.vo.Report;

public class MemberDao {
	Member m = new Member();
	public Member loginMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member loginUser=null;
		
		String query="SELECT * FROM MEMBER WHERE USERID = ? AND USERPW=? AND STATUS = 'N' AND SANCTION = 'N'";
		
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

	public String findUserPw(Connection conn, String userId, String email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userPw="";
		String query="SELECT USERPW FROM MEMBER WHERE USERiD=? AND EMAIL=? AND STATUS='N'";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, email);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				userPw=rs.getString("userpw");
			}
//			System.out.println(userId);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return userPw;
	}

	public int IdCheck(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String query = "SELECT USERID FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=1;
			}
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		
		return result;
	}

	public int InsertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="INSERT INTO MEMBER VALUES(MEM_NO.NEXTVAL,?,?,?,?,?,?,DEFAULT,DEFAULT,?)";
//		'eunjin2','c1234','권으','970520','flwkdf@skdf.com',2,DEFAULT,DEFAULT,'F'
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPw());
			pstmt.setString(3, member.getUserName());
			pstmt.setDate(4, member.getUserBirth());
			pstmt.setString(5, member.getEmail());
			pstmt.setInt(6, member.getGrade());
			pstmt.setString(7, member.getGender());
			
			result=pstmt.executeUpdate();
//			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public ArrayList<Member> WSelectAllMember(Connection conn, int limit, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		ArrayList<Member> list = new ArrayList<>();
		int startRow = 1+(currentPage-1)*limit;
		int endRow = currentPage*limit;
		
		
		
		  String query ="SELECT * FROM (SELECT ROWNUM RNUM, M.* FROM MEMBER M WHERE GRADE = 2 ORDER BY USERNO DESC) WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
		
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member(
										   rs.getInt(1),
										   rs.getInt("userno"),
										   rs.getString("userid"),
										   rs.getString("userpw"),
										   rs.getString("USERNAME"),
										   rs.getDate("USERBIRTH"),
										   rs.getString("EMAIL"),
										   rs.getInt("grade"),
										   rs.getString("SANCTION"),
										   rs.getString("STATUS"),
										   rs.getString("GENDER"));
				list.add(member);
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

	public int SelectListCount(Connection conn,int grade) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int listCount = 0;
		String query="SELECT COUNT(*) FROM MEMBER WHERE GRADE=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, grade);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return listCount;
	}

	public int SetSanction(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="UPDATE MEMBER SET SANCTION = 'Y' WHERE USERNO= ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			result=pstmt.executeUpdate();
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public ArrayList<Member> NSelectAllMember(Connection conn, int limit, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		ArrayList<Member> list = new ArrayList<>();
		int startRow = 1+(currentPage-1)*limit;
		int endRow = currentPage*limit;
		
		
		
		  String query ="SELECT * FROM (SELECT ROWNUM RNUM, M.* FROM MEMBER M WHERE GRADE = 3 ORDER BY USERNO DESC) WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
		
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member(
										   rs.getInt(1),
										   rs.getInt("userno"),
										   rs.getString("userid"),
										   rs.getString("userpw"),
										   rs.getString("USERNAME"),
										   rs.getDate("USERBIRTH"),
										   rs.getString("EMAIL"),
										   rs.getInt("grade"),
										   rs.getString("SANCTION"),
										   rs.getString("STATUS"),
										   rs.getString("GENDER"));
				list.add(member);
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

	public int NSetSanction(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="UPDATE MEMBER SET SANCTION = 'N' WHERE USERNO= ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			result=pstmt.executeUpdate();
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int ReportListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int listCount = 0;
		String query="SELECT  COUNT(*) FROM REPORT";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		
				
		
		return listCount;
	}

	public ArrayList<Report> ReportList(Connection conn, int limit, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		Report rp = null;
		Report uploaduserinfo=null;
		int startRow = 1+(currentPage-1)*limit;
		int endRow = currentPage*limit;
		ArrayList<Report> rplist = new ArrayList<>();
		int reportno =0;
		int categoryno =0;
		int uploaduserno=0;
		String uploaduser="";
		int boardno = 0;
		String process="";
		String reportuser="";
		
		
		String query="SELECT * FROM (SELECT ROWNUM RNUM, R.REPORTNO, R.BOARDNO, R.PROCESS, R.CATEGORYNO, M.USERID FROM REPORT R JOIN MEMBER M ON (R.USERNO = M.USERNO)) RR WHERE RNUM BETWEEN ? AND ?";
		
		
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				reportno = rs.getInt("reportno");
				boardno = rs.getInt("boardno");
				process = rs.getString("process");
				categoryno = rs.getInt("categoryno");
				switch (categoryno) {
				case 1:
					uploaduserinfo = new TestDao().SelectCommunityUserId(boardno);
					 uploaduserno = uploaduserinfo.getUploaduserno();
					 uploaduser=uploaduserinfo.getUploaduser();
					break;
				case 2:
					uploaduserinfo = new TestDao().SelectCommunityUserId(boardno);
					 uploaduserno = uploaduserinfo.getUploaduserno();
					 uploaduser=uploaduserinfo.getUploaduser();
					break;
				case 3:
					uploaduserinfo = new TestDao().SelectCommunityUserId(boardno);
					 uploaduserno = uploaduserinfo.getUploaduserno();
					 uploaduser=uploaduserinfo.getUploaduser();
					break;
				case 4:
					uploaduserinfo = new TestDao().SelectCommentUserId(boardno);
					 uploaduserno = uploaduserinfo.getUploaduserno();
					 uploaduser=uploaduserinfo.getUploaduser();
					break;
				case 5:
					uploaduserinfo = new TestDao().SelectJobsearchUserId(boardno);
					 uploaduserno = uploaduserinfo.getUploaduserno();
					 uploaduser=uploaduserinfo.getUploaduser();
					break;
				case 6:
					uploaduserinfo= new TestDao().SelectJobreviewUserId(boardno);
					 uploaduserno = uploaduserinfo.getUploaduserno();
					 uploaduser=uploaduserinfo.getUploaduser();
					break;
				case 7:
					uploaduserinfo= new TestDao().SelectHomeUserId(boardno);
					 uploaduserno = uploaduserinfo.getUploaduserno();
					 uploaduser=uploaduserinfo.getUploaduser();
					break;
				case 8:
					uploaduserinfo= new TestDao().SelectHomeReviewUserId(boardno);
					 uploaduserno = uploaduserinfo.getUploaduserno();
					 uploaduser=uploaduserinfo.getUploaduser();
					break;
				default:
					break;
				}
				reportuser = rs.getString("userid");
				
				rp = new Report(reportno, categoryno, uploaduserno, uploaduser, boardno, process, reportuser);
				rplist.add(rp);
			}
			
			System.out.println("reportno:"+reportno+" categoryno:"+categoryno+" uploaduser:"+uploaduser+" boardno:"+boardno+" process:"+process+" reportuser:"+reportuser);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rplist;
		
	}

	public int SelectUserNo(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int userNo = 0;
		String query = "SELECT USERNO FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				userNo = rs.getInt("userno");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userNo;
	}

	public int SetProcess(Connection conn, int reportNo, String val) {
		PreparedStatement pstmt = null;
		int result2 = 0;
		String query = "UPDATE REPORT SET PROCESS = ? WHERE REPORTNO =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, val);
			pstmt.setInt(2, reportNo);
			
			result2= pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return result2;
	}
	public int deleteMember(Connection conn, String userId) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "DELETE FROM MEMBER WHERE USERID=?";	// STATUS를 N으로 함으로써 삭제가되면 이대로 아니면 DELETE문 써주기
			
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
		
		
		
		
	}

	public int updateName(Connection conn, String userName, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET USERNAME=? WHERE USERID =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
		
		
		
	}

	public int updatePwd(Connection conn, String userPw, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET USERPW=? WHERE USERID =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userPw);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
		
	}

	

	public int updateEmail(Connection conn, String email, String userId) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET EMAIL=? WHERE USERID =?";
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, email);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	public int pwdCheck(Connection conn, String userPw, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
		String query = "SELECT COUNT(*) FROM MEMBER WHERE USERPW = ? AND USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userPw);
			pstmt.setString(2, userId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		
		
		return result;
		

	}

	public int gradeCheck(Connection conn, String userId, String grade) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
		String query = "SELECT GRADE = ? FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, grade);
			pstmt.setString(2, userId);
			rs=pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		
		
		return result;
		
	}

	public String selectName(Connection conn, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
	
	
	
	
	
	
	
	
	
	

