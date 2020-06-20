package community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import community.model.vo.Community;
import community.model.vo.CommunityImg;

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
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String communityno = request.getParameter("communityno");
      
      int communityno2 = Integer.valueOf(communityno);
     
      
      int result = new CommunityService().updateCount(communityno2);
      if(result>0) {
         Community community = new CommunityService().selectCommunity(communityno2);
      
         CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno2);
         
      if(community != null) {
         
         
         request.setAttribute("community", community);
         request.setAttribute("communityimg", communityimg);
         request.setAttribute("communityno2", communityno2);
         
         request.getRequestDispatcher("views/community/DetailView.jsp").forward(request, response);
            
      } else {
         request.setAttribute("msg", "게시글 상세 조회 실패!");
         
      }
   }else {         // 조회수가 증가하지 않았다면
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
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String communityno = request.getParameter("communityno");
      
      int communityno2 = Integer.valueOf(communityno);
     
      
      int result = new CommunityService().updateCount(communityno2);
      if(result>0) {
         Community community = new CommunityService().selectCommunity(communityno2);
      
         CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno2);
         
      if(community != null) {
         
         
         request.setAttribute("community", community);
         request.setAttribute("communityimg", communityimg);
         request.setAttribute("communityno2", communityno2);
         
         request.getRequestDispatcher("views/community/DetailView.jsp").forward(request, response);
            
      } else {
         request.setAttribute("msg", "게시글 상세 조회 실패!");
         
      }
   }else {         // 조회수가 증가하지 않았다면
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
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String communityno = request.getParameter("communityno");
      
      int communityno2 = Integer.valueOf(communityno);
     
      
      int result = new CommunityService().updateCount(communityno2);
      if(result>0) {
         Community community = new CommunityService().selectCommunity(communityno2);
      
         CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno2);
         
      if(community != null) {
         
         
         request.setAttribute("community", community);
         request.setAttribute("communityimg", communityimg);
         request.setAttribute("communityno2", communityno2);
         
         request.getRequestDispatcher("views/community/DetailView.jsp").forward(request, response);
            
      } else {
         request.setAttribute("msg", "게시글 상세 조회 실패!");
         
      }
   }else {         // 조회수가 증가하지 않았다면
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
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String communityno = request.getParameter("communityno");
      
      int communityno2 = Integer.valueOf(communityno);
     
      
      int result = new CommunityService().updateCount(communityno2);
      if(result>0) {
         Community community = new CommunityService().selectCommunity(communityno2);
      
         CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno2);
         
      if(community != null) {
         
         
         request.setAttribute("community", community);
         request.setAttribute("communityimg", communityimg);
         request.setAttribute("communityno2", communityno2);
         
         request.getRequestDispatcher("views/community/DetailView.jsp").forward(request, response);
            
      } else {
         request.setAttribute("msg", "게시글 상세 조회 실패!");
         
      }
   }else {         // 조회수가 증가하지 않았다면
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
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String communityno = request.getParameter("communityno");
      
      int communityno2 = Integer.valueOf(communityno);
     
      
      int result = new CommunityService().updateCount(communityno2);
      if(result>0) {
         Community community = new CommunityService().selectCommunity(communityno2);
      
         CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno2);
         
      if(community != null) {
         
         
         request.setAttribute("community", community);
         request.setAttribute("communityimg", communityimg);
         request.setAttribute("communityno2", communityno2);
         
         request.getRequestDispatcher("views/community/DetailView.jsp").forward(request, response);
            
      } else {
         request.setAttribute("msg", "게시글 상세 조회 실패!");
         
      }
   }else {         // 조회수가 증가하지 않았다면
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
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String communityno = request.getParameter("communityno");
      
      int communityno2 = Integer.valueOf(communityno);
     
      
      int result = new CommunityService().updateCount(communityno2);
      if(result>0) {
         Community community = new CommunityService().selectCommunity(communityno2);
      
         CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno2);
         
      if(community != null) {
         
         
         request.setAttribute("community", community);
         request.setAttribute("communityimg", communityimg);
         request.setAttribute("communityno2", communityno2);
         
         request.getRequestDispatcher("views/community/DetailView.jsp").forward(request, response);
            
      } else {
         request.setAttribute("msg", "게시글 상세 조회 실패!");
         
      }
   }else {         // 조회수가 증가하지 않았다면
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
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String communityno = request.getParameter("communityno");
      
      int communityno2 = Integer.valueOf(communityno);
     
      
      int result = new CommunityService().updateCount(communityno2);
      if(result>0) {
         Community community = new CommunityService().selectCommunity(communityno2);
      
         CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno2);
         
      if(community != null) {
         
         
         request.setAttribute("community", community);
         request.setAttribute("communityimg", communityimg);
         request.setAttribute("communityno2", communityno2);
         
         request.getRequestDispatcher("views/community/DetailView.jsp").forward(request, response);
            
      } else {
         request.setAttribute("msg", "게시글 상세 조회 실패!");
         
      }
   }else {         // 조회수가 증가하지 않았다면
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
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String communityno = request.getParameter("communityno");
      
      int communityno2 = Integer.valueOf(communityno);
     
      
      int result = new CommunityService().updateCount(communityno2);
      if(result>0) {
         Community community = new CommunityService().selectCommunity(communityno2);
      
         CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno2);
         
      if(community != null) {
         
         
         request.setAttribute("community", community);
         request.setAttribute("communityimg", communityimg);
         request.setAttribute("communityno2", communityno2);
         
         request.getRequestDispatcher("views/community/DetailView.jsp").forward(request, response);
            
      } else {
         request.setAttribute("msg", "게시글 상세 조회 실패!");
         
      }
   }else {         // 조회수가 증가하지 않았다면
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
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String communityno = request.getParameter("communityno");
      
      int communityno2 = Integer.valueOf(communityno);
     
      
      int result = new CommunityService().updateCount(communityno2);
      if(result>0) {
         Community community = new CommunityService().selectCommunity(communityno2);
      
         CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno2);
         
      if(community != null) {
         
         
         request.setAttribute("community", community);
         request.setAttribute("communityimg", communityimg);
         request.setAttribute("communityno2", communityno2);
         
         request.getRequestDispatcher("views/community/DetailView.jsp").forward(request, response);
            
      } else {
         request.setAttribute("msg", "게시글 상세 조회 실패!");
         
      }
   }else {         // 조회수가 증가하지 않았다면
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
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String communityno = request.getParameter("communityno");
      
      int communityno2 = Integer.valueOf(communityno);
     
      
      int result = new CommunityService().updateCount(communityno2);
      if(result>0) {
         Community community = new CommunityService().selectCommunity(communityno2);
      
         CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno2);
         
      if(community != null) {
         
         
         request.setAttribute("community", community);
         request.setAttribute("communityimg", communityimg);
         request.setAttribute("communityno2", communityno2);
         
         request.getRequestDispatcher("views/community/DetailView.jsp").forward(request, response);
            
      } else {
         request.setAttribute("msg", "게시글 상세 조회 실패!");
         
      }
   }else {         // 조회수가 증가하지 않았다면
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
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String communityno = request.getParameter("communityno");
      
      int communityno2 = Integer.valueOf(communityno);
     
      
      int result = new CommunityService().updateCount(communityno2);
      if(result>0) {
         Community community = new CommunityService().selectCommunity(communityno2);
      
         CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno2);
         
      if(community != null) {
         
         
         request.setAttribute("community", community);
         request.setAttribute("communityimg", communityimg);
         request.setAttribute("communityno2", communityno2);
         
         request.getRequestDispatcher("views/community/DetailView.jsp").forward(request, response);
            
      } else {
         request.setAttribute("msg", "게시글 상세 조회 실패!");
         
      }
   }else {         // 조회수가 증가하지 않았다면
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
