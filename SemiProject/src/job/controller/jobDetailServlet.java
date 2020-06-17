package job.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.model.service.JobService;
import job.model.vo.Job;

/**
 * Servlet implementation class jobDetailServlet
 */
@WebServlet("/jobDetail.bo")
public class jobDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jno = request.getParameter("jobNo");
		System.out.println("jno : "+jno);
		int jno2 = Integer.valueOf(jno);
		System.out.println("jno2 : " +jno2);
		
		// 조회수 증가를 위한 update 작업		
//		int result = new JobService().updateCount(bid2);
//		
//		if(result>0) {	// 조회수가 증가 했다면
			Job j = new JobService().selectJobList(jno2);
//			
//	//		System.out.println("내가 누른 게시글 정보 : " + board);
//			
			if(j != null) {
				request.setAttribute("job", j);
				request.getRequestDispatcher("views/job/jobDetailView.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "게시글 상세 조회 실패!");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
//		}else {			// 조회수가 증가하지 않았다면
//			request.setAttribute("msg", "게시글 조회수 증가 실패!");
//			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//		}
		
//	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}