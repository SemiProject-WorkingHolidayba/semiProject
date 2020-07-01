package safeInfo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import community.model.vo.Comment;
import community.model.vo.Community1;
import community.model.vo.CommunityImg;
import safeInfo.model.service.SafeService;
import safeInfo.model.vo.Safe;

/**
 * Servlet implementation class SafeDetailServlet
 */
@WebServlet("/detail.si")
public class SafeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SafeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sNo = Integer.valueOf(request.getParameter("sNo"));
	
			
		int result = new SafeService().updateCount(sNo);
			
		if(result>0) {
			Safe s = new SafeService().selectCommunity(sNo);
		
			if(s != null) {

				request.setAttribute("safeinfo", s);
				request.setAttribute("sNo", sNo);			
				request.getRequestDispatcher("views/safeInfo/safeDetailView.jsp").forward(request, response);
					
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
