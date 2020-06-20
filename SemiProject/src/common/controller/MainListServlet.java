package common.controller;

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

/**
 * Servlet implementation class MainListServlet
 */
@WebServlet("/mainList.c")
public class MainListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("메인서블릿 실행됨");
		
		HomeService hService = new HomeService();
		
		ArrayList<Home> list = new ArrayList<Home>();
		ArrayList<Img> flist = new ArrayList<Img>();
		
		list = hService.selectList();
		flist = hService.selectImgList();
		
		RequestDispatcher view = null;
		
		if(list != null) {
			view = request.getRequestDispatcher("views/home/homeListView.jsp");
			request.setAttribute("list", list);
			request.setAttribute("flist", flist);
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
