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
 * Servlet implementation class UpdateMemberEmailServlet
 */
@WebServlet("/updateEmail.me")
public class UpdateMemberEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberEmailServlet() {
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
		
	
		String email = request.getParameter("email");
	
		String userId = loginUser.getUserId();

	
		int resultEmail = new MemberService().updateEmail(email,userId);
		PrintWriter out = response.getWriter();
		 
		 if(resultEmail > 0  ) {
			 loginUser = new MemberService().loginMember(loginUser);
			 session.setAttribute("loginUser",loginUser);
//			 request.setAttribute("email", email);
//			 session.setAttribute("userName", userName);
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
