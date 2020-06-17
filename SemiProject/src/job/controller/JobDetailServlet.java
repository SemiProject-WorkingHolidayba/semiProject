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
 * Servlet implementation class JobDetailServlet
 */
@WebServlet("/detail.job")
public class JobDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 오류가 생긴다면 heartno를 추가하던지 해야될듯 jsp에
			String jobNo = request.getParameter("jobNo");
			int jobNo2 = Integer.valueOf(jobNo);
			String heartNo = request.getParameter("heartNo");
			int heartNo2 = Integer.valueOf(heartNo);
			String userNo = request.getParameter("userNo");
			int userNo2 = Integer.valueOf(userNo);
		
			JobSearch jobsearch = new JobSearchService().selectJobSearch(jobNo2, heartNo2);
			JobSearch jobsearchA = new JobSearchService().selectApplication(jobNo2,userNo2);
			
		
			if(jobsearch != null) {
				request.setAttribute("jobsearch", jobsearch);
				request.getRequestDispatcher("views/JobSearch/도짱의.jsp").forward(request, response);
				
				
			}else {
				request.setAttribute("msg", "게시글이 존재하지 않습니다.!");
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");

				view.forward(request, response);
			}
			
			if(jobsearchA != null) {
				request.setAttribute("jobsearch", jobsearchA);
				request.getRequestDispatcher("views/JobSearch/도짱의.jsp").forward(request, response);
				
				
			}else {
				request.setAttribute("msg", "게시글이 존재하지 않습니다.!");
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");

				view.forward(request, response);
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
