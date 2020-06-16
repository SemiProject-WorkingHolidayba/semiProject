package member.model.service;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import static common.JDBCTemplate.*;

import java.sql.Connection;

public class MemberService {

	public Member loginMember(Member member) {
		Connection conn = getConnetion();
		
		Member loginUser = new MemberDao().loginMember(conn, member);
		
		close(conn);
		return loginUser;
	}

	public String findUserId(String userName, String email) {
		Connection conn = getConnetion();
		
		String userId = new MemberDao().findUserId(conn,userName,email);
			
		close(conn);
		return userId;
	}

}
