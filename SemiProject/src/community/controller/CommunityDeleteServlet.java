package community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;

/**
 * Servlet implementation class CommunityDeleteServelet
 */
@WebServlet("/delete.bo")
public class CommunityDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String communityno =request.getParameter("communityno");
		
	int result = new CommunityService().deleteCommunity(communityno);
	System.out.println("servlet" + result);
	if(result>0) {
		
		request.getRequestDispatcher("views/common/main.jsp").forward(request,response);
		request.setAttribute("msg", "성공 ");
		
	}else {
		request.setAttribute("msg", "실패");
		request.getRequestDispatcher("views/commmon/errorPage.jsp").forward(request,response);
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
