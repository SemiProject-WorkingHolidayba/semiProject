package community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import community.model.vo.Community;
import community.model.vo.CommunityImg;
import community.model.vo.Reply;
import oracle.jdbc.OracleConnection.CommitOption;

/**
 * Servlet implementation class CommunityDetailServlet
 */
@WebServlet("/Detail.bo")
public class CommunityDetailServlet extends HttpServlet {
	
       
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
		int communityno =  Integer.valueOf(request.getParameter("communityno"));
		
		
		
		int result = new CommunityService().updateCount(communityno);
		if(result>0) {
			Community community = new CommunityService().selectCommunity(communityno);
		
			CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno);
			
		if(community != null) {
			System.out.println(community);
			System.out.println(communityimg);
			
			request.setAttribute("community", community);
			request.setAttribute("communityimg", communityimg);
			
			
			request.getRequestDispatcher("views/community/DetailView.jsp").forward(request, response);
				
		} else {
			request.setAttribute("msg", "게시글 상세 조회 실패!");
			
		}
	}else {			// 조회수가 증가하지 않았다면
		request.setAttribute("msg", "게시글 조회수 증가 실패!");
		
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
