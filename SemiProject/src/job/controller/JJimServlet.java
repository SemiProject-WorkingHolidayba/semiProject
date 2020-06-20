package job.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.model.service.JobService;
import job.model.vo.Heart;
import member.model.vo.Member;

/**
 * Servlet implementation class JJimServlet
 */
@WebServlet("/JJim.bo")
public class JJimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JJimServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int jobNo = Integer.valueOf(request.getParameter("jobno"));
		
		HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		int userNo = Integer.valueOf(loginUser.getUserNo());
		
		Heart h = new Heart();
		h.setJobNo(jobNo);
		h.setUserNo(userNo);
		
		int result = new JobService().jobJJim(h);
		
		if(result>0) {
			response.sendRedirect("views/job/jobDetail.bo?jobNo="+jobNo);
		}else {
			request.setAttribute("msg", "게시판 조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
