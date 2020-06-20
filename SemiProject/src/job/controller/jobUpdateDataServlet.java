package job.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.model.service.JobService;
import job.model.vo.Job;

/**
 * Servlet implementation class jobUpdateDataServlet
 */
@WebServlet("/jobData.bo")
public class jobUpdateDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobUpdateDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int jobNo = Integer.valueOf(request.getParameter("jobno"));
		System.out.println("실행은 되냐 : " +jobNo);
		Job j = new JobService().saveJobData(jobNo);
		System.out.println("서비스 갔다오고 : "+j.getDueDate());
		
		RequestDispatcher view=null;
		if(j!=null) {
			view=request.getRequestDispatcher("views/job/jobUpdateView.jsp");
			request.setAttribute("j", j);
		}else {
			request.setAttribute("msg", "게시판 조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
