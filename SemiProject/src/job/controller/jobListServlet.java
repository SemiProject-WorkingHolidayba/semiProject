package job.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.model.service.JobService;
import job.model.vo.Heart;
import job.model.vo.JobPagination;
import member.model.vo.Member;

/**
 * Servlet implementation class jobListViewServlet
 */
@WebServlet("/jobList.bo")
public class jobListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobService jService=new JobService();
		
		// 1-1. 게시판 리스트 총 갯수 구하기
		int listCount=jService.getListCount();
//		System.out.println(listCount);
		System.out.println("서블릿 listCount : " + listCount);
		
//		----------------- 페이징 처리 추가 ----------------------
		int currentPage;	// 현재 페이지를 표시할 변수
		int limit;			// 한 페이지에 게시글이 몇개가 보여질 것인지
		int maxPage;		// 전체 페이지에서 가장 마지막 페이지
		int startPage;		// 한번에 표시될 페이지가 시작 할 페이지
		int endPage;		// 한번에 표시될 페이지가 끝나는 페이지
		
		// 기본적으로 게시판은 1페이지부터 시작
		currentPage=1;
		// 하지만 페이지 전환시 전달받은 현재 페이지가 있을 시 해당 페이지를 currentPage로 적용
		if(request.getParameter("currentPage")!=null) {
			currentPage=Integer.valueOf(request.getParameter("currentPage"));
			// 현재 페이지와 전체 게시글 수로 연산 처리를 하기 위해서 int형으로 받아줘야함.
		}

		limit=9;

		maxPage=(int)((double)listCount/limit+0.9);

		startPage=(((int)((double)currentPage/limit+0.9))-1)*limit+1;
		
		endPage=startPage+limit;
		
		if(maxPage<endPage) {
			endPage=maxPage;
		}
		JobPagination pn=new JobPagination(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		// 1-2. 화면에 뿌려줄 게시판 리스트 조회하기
		ArrayList list=jService.selectList(currentPage, limit);
		
		//--------------------------------------------------------------------
		HttpSession session=request.getSession();
		Member loginUser=(Member)session.getAttribute("loginUser");
		
		int userNo=loginUser.getUserNo();
		int grade=loginUser.getGrade();
		
		ArrayList hlist=jService.selectHlist(userNo);
		System.out.println("서블릿에서 hlist: "+hlist);
		
		/*
		 * Heart h=new Heart(); int[] hArr=new int[hlist.size()]; for(int i=0;
		 * i<hlist.size();i++){ hArr[i]= ((Heart) hlist.get(i)).getJobNo(); }
		 * System.out.println("hArr : " + hArr[0]);
		 */
		
		RequestDispatcher view=null;
		if(list!=null) {
			request.setAttribute("list", list);
			request.setAttribute("hlist", hlist);
			request.setAttribute("pn", pn);
			request.setAttribute("grade", grade);
			view=request.getRequestDispatcher("views/job/jobBoardListView.jsp");
		}else{
			view=request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "게시글 조회 실패");
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
