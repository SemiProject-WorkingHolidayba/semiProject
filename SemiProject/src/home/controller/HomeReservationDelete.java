package home.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;

import home.model.service.HomeService;
import home.model.vo.myHome;
import member.model.vo.Member;

/**
 * Servlet implementation class HomeReservationDelete
 */
@WebServlet("/delete.home")
public class HomeReservationDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeReservationDelete() {
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
		
		
		int userNo = loginUser.getUserNo();
		
		ArrayList hrlist = new HomeService().mdeletehome(userNo);
		
		RequestDispatcher view = null;
		if(hrlist != null) {
			request.setAttribute("hrlist",hrlist);
			view = request.getRequestDispatcher("/mypage/Home/wHome.jsp");
		}else {
			view = request.getRequestDispatcher("/views/common/errorpage");
		
		}
		view.forward(request, response);
=======

import home.model.service.HomeService;
import home.model.vo.myHome;

/**
 * Servlet implementation class HomeReservationDelete
 */
@WebServlet("/delete.home")
public class HomeReservationDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeReservationDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reservationNo = request.getParameter("reservationNo");
		int  reservationNo2 = Integer.valueOf(reservationNo);
		
		ArrayList<myHome> homelist = new HomeService().mdeletehome(reservationNo2);
		RequestDispatcher view = null;
		if(homelist == null) {
			request.setAttribute("homelist",homelist);
			view = request.getRequestDispatcher("/mypage/Home/wHome.jsp");
			view.forward(request, response);
	}
>>>>>>> refs/remotes/origin/Eunjin
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
