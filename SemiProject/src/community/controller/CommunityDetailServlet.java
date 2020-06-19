package community.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import community.model.vo.CommunityMy;



/**
 * Servlet implementation class CommunityDetailServlet
 */
@WebServlet("/detail.ca")
public class CommunityDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					String communityNo = request.getParameter("communityNo");
					int communityNo2 = Integer.valueOf(communityNo);
					String categoryNo = request.getParameter("categoryNo");
					int categoryNo2 = Integer.valueOf(categoryNo);
				
					CommunityMy community = new CommunityService().selectcCommunity(communityNo2, categoryNo2);
					
					
					if(community != null) {
						request.setAttribute("community", community);
						request.getRequestDispatcher("views/Community/민환이의.jsp").forward(request, response);
						// 글 상세 페이지로 전환
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
