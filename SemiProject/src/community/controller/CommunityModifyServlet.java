package community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import community.model.vo.Community;
import community.model.vo.CommunityImg;

/**
 * Servlet implementation class MyHomeServlet
 */
@WebServlet("/modify.bo")
public class CommunityModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int communityno = Integer.valueOf(request.getParameter("communityno"));
		System.out.println(communityno);
		
		Community community = new CommunityService().modifyCommunity(communityno);
		
		
		ArrayList<CommunityImg> flist = new CommunityService().modifyImgList(communityno);
		System.out.println("마이페이지 뿌려주기 직전 내 정보 : " + communityno);
		
		RequestDispatcher view = null;
		
		if(community != null) {
			view = request.getRequestDispatcher("views/community/communityUpdateForm.jsp");
			request.setAttribute("community",community);
			request.setAttribute("flist", flist);
			
		} else {
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
