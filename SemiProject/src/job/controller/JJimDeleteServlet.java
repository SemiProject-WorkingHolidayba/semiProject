package job.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.model.service.JobSearchService;
import job.model.vo.JobSearch;

/**
 * Servlet implementation class JJimDeleteServlet
 */
@WebServlet("/delete.jjim")
public class JJimDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JJimDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNo = request.getParameter("userNo");
		String heartNo = request.getParameter("heartNo");
		int userNo2 = Integer.valueOf(userNo);
		int heartNo2 = Integer.valueOf(heartNo);
		
		ArrayList<JobSearch> jlist = new JobSearchService().deleteHeart(userNo2,heartNo2);
		RequestDispatcher view = null;
		
			request.setAttribute("jlist",jlist);
			view = request.getRequestDispatcher("/mypage/Work/JJIM.jsp");
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
