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
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
