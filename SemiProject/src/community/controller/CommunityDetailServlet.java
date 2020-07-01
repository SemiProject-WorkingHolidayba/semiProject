package community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import community.model.vo.Comment;
import community.model.vo.Community;
import community.model.vo.Community1;
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
      String communityno = request.getParameter("communityno");
      String categoryName = request.getParameter("categoryName");
      
      int communityno2 = Integer.valueOf(communityno);

      
      int result = new CommunityService().updateCount(communityno2);
      
      if(result>0) {
         Community community = new CommunityService().selectCommunity(communityno2);
         Community1 community1 = new CommunityService().selectCommunity1(communityno2);
         CommunityImg communityimg = new CommunityService().selectCommunityImg(communityno2);
         ArrayList<Comment> colist = new CommunityService().selectCommentList(communityno2);
   
      if(community != null) {
         
         
         request.setAttribute("community", community);
         request.setAttribute("community1", community1);
         request.setAttribute("communityimg", communityimg);
         request.setAttribute("communityno2", communityno2);
         request.setAttribute("categoryName", categoryName);
         
         request.setAttribute("colist", colist);
         System.out.println("communityno2" +communityno2);
         
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