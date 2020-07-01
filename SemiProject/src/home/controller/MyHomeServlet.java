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

/**
 * Servlet implementation class MyHomeServlet
 */
@WebServlet("/myHome.ho")
public class MyHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int hNo = Integer.valueOf(request.getParameter("hNo"));
		
		Home home = new HomeService().selectHome(hNo);
		ArrayList<Img> flist = new HomeService().selectImgList(hNo);

		RequestDispatcher view = null;
		
		if(home != null) {
			view = request.getRequestDispatcher("views/home/myHomeView.jsp");
			request.setAttribute("home", home);
			request.setAttribute("flist", flist);
		} else {
			view = request.getRequestDispatcher("views/common/errorpage.jsp");
			request.setAttribute("msg", "내 정보 조회에 실패했습니다.");
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
