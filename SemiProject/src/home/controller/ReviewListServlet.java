package home.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.model.service.HomeService;
import home.model.vo.Pagination;
import home.model.vo.Review;

/**
 * Servlet implementation class ReviewListServlet
 */
@WebServlet("/listReview.ho")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HomeService hService = new HomeService();
		
		int hNo = Integer.valueOf(request.getParameter("hNo"));
		
		
		int listCount = hService.getRListCount();
		
		int currentPage;	// 현재 페이지를 표시 할 변수 기본값 1
		int limit;			// 한 페이지에 게시글이 몇 개가 보여질 것인지
		int maxPage;		// 전체 페이지에서 가장 마지막 페이지
		int startPage;		// 한번에 표시될 페이지가 시작 할 페이지
		int endPage;		// 한번에 표시될 페이지가 끝나는 페이지
		int pageLimit;
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.valueOf(request.getParameter("currentPage"));
		}
		
		limit = 10;

		maxPage = (int)((double)listCount/limit + 0.9);
		
		startPage = (((int)((double)currentPage/limit + 0.9))-1)*limit + 1;

		endPage = startPage + limit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		Pagination pn = new Pagination(currentPage,listCount,limit,maxPage,startPage,endPage);
		
//		ArrayList<Review> rlist = hService.selectRList(currentPage, limit);
		
//		RequestDispatcher view = null;
//		
//		if(rlist != null) {
//			view = request.getRequestDispatcher("views/home/homeListView.jsp");
//			request.setAttribute("rlist", rlist);
//		} else {
//			System.out.println("게시글 조회 실패");
//		}
//		
//		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
