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
 * Servlet implementation class JobApplicationDeleteServlet
 */
@WebServlet("/delete.job")
public class JobApplicationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobApplicationDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jobApplyNo = request.getParameter("jobApplyNo");
	
		int jobApplyNo2 = Integer.valueOf(jobApplyNo);
		
		ArrayList<JobSearch> Alist = new JobSearchService().deleteA(jobApplyNo2);
		RequestDispatcher view = null;
		
			request.setAttribute("Alist",Alist);
			view = request.getRequestDispatcher("/mypage/Work/wWork.jsp");
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
