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
import home.model.vo.Home;
import home.model.vo.Img;
import home.model.vo.Pagination;

/**
 * Servlet implementation class HomeListServlet
 */
@WebServlet("/list.ho")
public class HomeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HomeService hService = new HomeService();
		
		String country = request.getParameter("country");
		String home = request.getParameter("home");
		String period = request.getParameter("period");
		
		int listCount;
		
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
		
		limit = 12;
		pageLimit = 10;
		
		
		ArrayList<Home> list = new ArrayList<Home>();
		ArrayList<Img> flist = new ArrayList<Img>();
		
		if(country == null && home == null && period == null) {			
			 list = hService.selectList(currentPage, limit);
			 flist = hService.selectImgList(currentPage, limit);
			 listCount = hService.getListCount();
			 
			 maxPage = (int)((double)listCount/limit + 1);
			 startPage = (((int)((double)currentPage/pageLimit + 0.9))-1)*limit + 1;
			 endPage = startPage + pageLimit - 1;
			 
			 if(maxPage < endPage) {
				endPage = maxPage;
			 }
				
		} else{
			list = hService.selectList2(currentPage, limit, country, home, period);
			flist = hService.selectImgList2(currentPage, limit, country, home, period);
			listCount = hService.getListCount2(country, home, period);
			
			maxPage = (int)((double)listCount/limit + 1);
			startPage = (((int)((double)currentPage/pageLimit + 0.9))-1)*limit + 1;
			endPage = startPage + pageLimit - 1;
			
			if(maxPage < endPage) {
				endPage = maxPage;
			}
		}
		
		Pagination pn = new Pagination(currentPage,listCount,limit,maxPage,startPage,endPage);
		
		RequestDispatcher view = null;
		
		if(list != null) {
			view = request.getRequestDispatcher("views/home/homeListView.jsp");
			request.setAttribute("list", list);
			request.setAttribute("flist", flist);
			request.setAttribute("pn", pn);
		} else {
			System.out.println("게시글 조회 실패");
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
