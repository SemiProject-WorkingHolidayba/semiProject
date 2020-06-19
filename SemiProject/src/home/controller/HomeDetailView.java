package home.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.model.service.HomeService;
import home.model.vo.myHome;

/**
 * Servlet implementation class HomeDetailView
 */
@WebServlet("/detail.home")
public class HomeDetailView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeDetailView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 오류가 생긴다면 heartno를 추가하던지 해야될듯 jsp에
		String houseNo = request.getParameter("houseNo");
		int houseNo2 = Integer.valueOf(houseNo);
		String userNo = request.getParameter("userNo");
		int userNo2 = Integer.valueOf(userNo);

		myHome home  = new HomeService().mselectHome(houseNo2, userNo2);
		
	
		if(home != null) {
			request.setAttribute("home", home);
			request.getRequestDispatcher("views/Home/민지의.jsp").forward(request, response);
			
			
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
