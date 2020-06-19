package home.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import home.model.service.HomeService;
import home.model.vo.myHome;
import member.model.vo.Member;

/**
 * Servlet implementation class HomeSearchServlet
 */
@WebServlet("/search.ho")
public class HomeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
	
		int userNo2 = loginUser.getUserNo();
		
		System.out.println(userNo2);
		ArrayList hrlist = new HomeService().searchReservation(userNo2);
		System.out.println(hrlist);
		
		if(hrlist != null) {
			request.setAttribute("hrlist", hrlist);
			request.getRequestDispatcher("views/mypage/Home/wHome.jsp").forward(request, response);
			
			
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
