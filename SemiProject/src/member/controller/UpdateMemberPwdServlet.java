package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberPwdServlet
 */
@WebServlet("/updatePwd.me")
public class UpdateMemberPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
	
		String userPw = request.getParameter("userPw");
		String userId = loginUser.getUserId();

		System.out.println(userPw);

		System.out.println(userId);
		int resultPwd = new MemberService().updatePwd(userPw,userId);
		System.out.println(resultPwd);
		
		PrintWriter out = response.getWriter();
		
		 if(resultPwd > 0) {
			 loginUser = new MemberService().loginMember(loginUser);
			 session.setAttribute("loginUser",loginUser);

			 out.print("Y");
		 }else {
		
			 out.print("N");
		 }
		
		 out.flush();
		 out.close();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
