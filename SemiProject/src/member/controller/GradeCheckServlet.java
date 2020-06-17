package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class GradeCheckServlet
 */
@WebServlet("/grade.check")
public class GradeCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userId = request.getParameter("userId");
		String grade = request.getParameter("grade");
		
		int result = new MemberService().gradeCheck(userId,grade);
		if(result == 2) {
			request.setAttribute(userId,userId );
			request.setAttribute(grade, grade);
			request.getRequestDispatcher("views/mypage/PIU/personalIU.jsp").forward(request, response); // 워홀러 마이페이지 개인정보수정으로
		}else if(result == 3) {
			request.setAttribute(userId,userId );
			request.setAttribute(grade, grade);
			request.getRequestDispatcher("views/mypage/PIU/NpersonalIU.jsp").forward(request, response); // 현지인 마이페이지 개인정보수정으로
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
