package member.controller;

import static member.controller.Emailsand.EmailSandMethod;

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
 * Servlet implementation class FindIdServlet
 */
@WebServlet("/findid.me")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("서블릿옴");
		
		String userName=request.getParameter("userName");
		String email=request.getParameter("email");
		
		String userId = new MemberService().findUserId(userName, email);
		Member FindUser = new Member(userId,userName,email);
		
		HttpSession session = request.getSession();
		session.setAttribute("FindUser", FindUser);
		
		PrintWriter out = response.getWriter();
		String num="";
		if(userId != "") {
			num=EmailSandMethod(email);
			out.print(num);
		}else {
			out.print("No");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
