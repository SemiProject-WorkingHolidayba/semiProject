package job.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.model.service.JobService;
import job.model.vo.JobPagination;
import member.model.vo.Member;

/**
 * Servlet implementation class searchJobServlet
 */
@WebServlet("/searchJob.bo")
public class searchJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchJobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] nationArr=request.getParameterValues("nation");
	      String[] jobCategoryArr=request.getParameterValues("jobCategory");
	      String[] termArr=request.getParameterValues("term");
	      String[] weekArr=request.getParameterValues("week");
	      
	      System.out.println("검색결과 정보");
	      System.out.println(Arrays.toString(nationArr));
	      System.out.println(Arrays.toString(jobCategoryArr));
	      System.out.println(Arrays.toString(termArr));
	      System.out.println(Arrays.toString(weekArr));
	      
	      int searchListCount=new JobService().getSearchListCount(nationArr,jobCategoryArr,termArr,weekArr);
	      
//	      ----------------- 페이징 처리 추가 ----------------------
	      int currentPage;   // 현재 페이지를 표시할 변수
	      int limit;         // 한 페이지에 게시글이 몇개가 보여질 것인지
	      int maxPage;      // 전체 페이지에서 가장 마지막 페이지
	      int startPage;      // 한번에 표시될 페이지가 시작 할 페이지
	      int endPage;      // 한번에 표시될 페이지가 끝나는 페이지
	      
	      // 기본적으로 게시판은 1페이지부터 시작
	      currentPage=1;
	      // 하지만 페이지 전환시 전달받은 현재 페이지가 있을 시 해당 페이지를 currentPage로 적용
	      if(request.getParameter("currentPage")!=null) {
	         currentPage=Integer.valueOf(request.getParameter("currentPage"));
	         // 현재 페이지와 전체 게시글 수로 연산 처리를 하기 위해서 int형으로 받아줘야함.
	      }
	      
	      // limit
	      limit=9;
	      
	      /*
	       * maxpage-총 페이지수
	       * 목록 수가 123개이면 페이지 수는 총 13페이지임
	       * 짜투리 목록이 최소1개일때, 1page로 처리하기 위해 0.9를 더함
	       */
	      maxPage=(int)((double)searchListCount/limit+0.9);
	   
	      startPage=(((int)((double)currentPage/limit+0.9))-1)*limit+1;
	      
	      endPage=startPage+limit;
	      
	      if(maxPage<endPage) {
	         endPage=maxPage;
	      }
	      JobPagination pn=new JobPagination(currentPage, searchListCount, limit, maxPage, startPage, endPage);
	      
	      // 1-2. 화면에 뿌려줄 게시판 리스트 조회하기
	      ArrayList list=new JobService().searchSelectList(currentPage, limit,nationArr,jobCategoryArr,termArr,weekArr);
	      
	      //--------------------------------------------------------------------
	      HttpSession session=request.getSession();
	      Member loginUser=(Member)session.getAttribute("loginUser");
	      
	      int userNo=loginUser.getUserNo();
	      int grade=loginUser.getGrade();
	      
	      ArrayList hlist=new JobService().selectHlist(userNo);
	      System.out.println("서블릿에서 hlist: "+hlist);
	      
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
