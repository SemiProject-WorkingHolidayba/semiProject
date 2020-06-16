package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jrockit.jfr.RequestDelegate;

import home.model.vo.Pagination;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class WorkingMemberServlet
 */
@WebServlet("/wselectallmember.me")
public class WSelectAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WSelectAllMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
	
		int listCount = new MemberService().SelectListCount(2);
		
		currentPage =1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.valueOf(request.getParameter("currentPage"));
		}
		
		limit = 10;
		maxPage = (int)((double)listCount/limit+0.9);
		startPage = (((int)((double)currentPage/limit+0.9))-1)*limit+1;
		endPage=startPage +limit -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		Pagination pn = new Pagination(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<Member> list = new MemberService().WSelectAllMember(limit,currentPage);
		
		
		
		RequestDispatcher view = null;
		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("pn", pn);
			view = request.getRequestDispatcher("views/member/workingmemberlist.jsp");
			
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
