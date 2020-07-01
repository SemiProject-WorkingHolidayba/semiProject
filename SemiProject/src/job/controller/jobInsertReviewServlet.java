package job.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.model.service.JobService;
import job.model.vo.JobReview;
import member.model.vo.Member;

/**
 * Servlet implementation class jobInsertReviewServlet
 */
@WebServlet("/insertReview.bo")
public class jobInsertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobInsertReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int writer = Integer.valueOf(request.getParameter("writer"));
		int jobNo = Integer.valueOf(request.getParameter("jobNo"));
		String content = request.getParameter("content");
		
		
		
		JobReview r = new JobReview(content, jobNo, writer);
		
		new JobService().insertReview(r);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
