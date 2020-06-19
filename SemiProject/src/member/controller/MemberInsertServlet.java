package member.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/insert.me")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		java.util.Date d = null;
		try {
			d = new SimpleDateFormat("yyMMdd").parse(request.getParameter("birth"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date userBrith = new Date(d.getTime());
		String email = request.getParameter("email");
		int grade = Integer.valueOf( request.getParameter("grade"));
		String gender = request.getParameter("gender");
		
		Member member = new Member(userId,userPw, userName,userBrith,  email, grade, gender);
		
		int result = new MemberService().InsertMember(member);
		
		RequestDispatcher view = null;
		if(result > 0) {
			System.out.println("회원가입 성공");
			request.setAttribute("userId", userId);
			view = request.getRequestDispatcher("views/member/succjoin.jsp");
		}else {
			System.out.println("회원가입 실패");
			request.setAttribute("errorMsg", "회원가입실패");
			view = request.getRequestDispatcher("views/member/join.jsp");
			
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
