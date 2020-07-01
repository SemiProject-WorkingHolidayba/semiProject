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
import community.model.vo.Pagination;

/**
 * Servlet implementation class CommunityQuestionSearchServlet
 */
@WebServlet("/questionSearch.bo")
public class CommunityQuestionSearchServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityQuestionSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
CommunityService cService = new CommunityService();
String category = request.getParameter("categoryName");
      //게시판 리스트 총 개수
      int listCount = cService.getListCount(category);
      
      int currentPage;//현재 페이지를 표시할 변수
      int limit; //한 페이지에 게시글이 몇개가 보여짌것인지
      int maxPage; //전체 페이지에서 가장 마지막 페이지
      int startPage; //한번에 표시될 페이지가 시작 할 페이지
      int endPage; //한번에 표시될 페이지가 끝나는 페이지
      
      // 1페이지부터 시작
      currentPage =1;
      //페이지 전환
      if(request.getParameter("currentPage") !=null) {
         currentPage = Integer.valueOf(request.getParameter("currentPage"));
         
      }
      //limit
      limit = 10;
      maxPage = (int)((double)listCount/limit +0.9);
      
      startPage = (((int)((double)currentPage/limit+0.9))-1) *limit +1;
      
      endPage = startPage +limit -1;
      
      if(maxPage < endPage) {
         endPage = maxPage;
      }
      Pagination pn = new Pagination(currentPage, listCount, limit, maxPage, startPage, endPage );
      String selectbox= request.getParameter("selectbox");
      String searchbox= request.getParameter("searchbox");
      
      ArrayList<Community> list = cService.questionSearchList(selectbox,searchbox,category);
      RequestDispatcher view = null;

      view = request.getRequestDispatcher("views/community/questionListView.jsp");
       request.setAttribute("list", list);
       request.setAttribute("pn", pn);
       

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