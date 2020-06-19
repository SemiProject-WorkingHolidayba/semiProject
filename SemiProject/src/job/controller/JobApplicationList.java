package job.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.model.service.JobSearchService;
import job.model.vo.Pagination;
import member.model.vo.Member;

/**
 * Servlet implementation class JobApplicationList
 */
@WebServlet("/list.aj")
public class JobApplicationList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobApplicationList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobSearchService jService = new JobSearchService();
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		int userNo = loginUser.getUserNo();
		int AlistCount = jService.getAListCount(userNo);
		
		int currentPage;	// 현재 페이지를 표시 할 변수
		int limit;			// 한 페이지에 게시글이 몇 개가 보여질 것인지
		int maxPage;		// 전체 페이지에서 가장 마지막 페이지
		int startPage;		// 한번에 표시될 페이지가 시작 할 페이지
		int endPage;		// 한번에 표시될 페이지가 끝나는 페이지
		
		currentPage = 1;
		
		// 하지만 페이지 전환시 전달받은 현재 페이지가 있을 시 해당 페이지를 currentPage로 적용
		if(request.getParameter("currentPage")!=null)
		{		
			currentPage = Integer.valueOf(request.getParameter("currentPage"));
			// 현재페이지와 전체 게시글 수로 여러가지 연산 처리를 하기 위해서 int형으로 받아준다.
		}
		
		// limit
		limit = 10;
		
		/*
		 * maxPage - 총 페이지수
		 * 목록 수가 123개이면 페이지 수는 총 13페이지임
		 * 짜투리 목록이 최소 1개일 때, 1page로 처리하기 위해 0.9를 더함
		 */
		maxPage = (int)((double)AlistCount/limit + 0.9);

		/*
		 * startPage - 현재 페이지에 보여질 시작 페이지 수
		 * 아래쪽에 페이지 수가 10개씩 보여지게 할 경우
		 * 1, 11, 21, 31, ...  /// 1, 6, 11,16
		 */
		startPage = (((int)((double)currentPage/limit + 0.9))-1)*limit +1;
		
		/*
		 * endPage - 현재 페이지에서 보여질 마지막 페이지 수
		 * 아래쪽에 페이지 수가 10개씩 보여지게 할 경우
		 * 10, 20, 30, 40, ...
		 */
		endPage = startPage + limit - 1;
		
		/*
		 * 하지만!! 마지막 페이지(endPage) 수가 총 페이지(maxPage) 수보다 클 경우
		 * maxPage가 13페이지고 endPage가 20페이지면
		 * endPage도 13페이지가 되어야 한다.
		 */
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		Pagination pn = new Pagination(currentPage, AlistCount, limit, maxPage, startPage, endPage);
		
		// 1_2. 화면에 뿌려줄 신청한 구직 테이블 리스트 조회하기
		ArrayList list = jService.selectListA(currentPage, limit,userNo);	
//		System.out.println(AlistCount);
//		System.out.println(list);
		RequestDispatcher view = null;
		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("pn", pn);
			view = request.getRequestDispatcher("views/mypage/Work/wWork.jsp");
		}else {
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "게시글 조회 실패!!");
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
