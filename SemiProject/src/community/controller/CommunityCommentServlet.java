package community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import community.model.service.CommunityService;
import community.model.vo.Comment;

/**
 * Servlet implementation class CommunityReplyServlet
 */
@WebServlet("/comment.bo")
public class CommunityCommentServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   public CommunityCommentServlet() {
      
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int userno = Integer.valueOf(request.getParameter("userno"));
      int communityno = Integer.valueOf(request.getParameter("communityno"));
      String content = request.getParameter("content");
      Comment c = new Comment(content, communityno, userno);
      
      ArrayList<Comment> colist = new CommunityService().insertComment(c);
      System.out.println(colist);
      response.setContentType("application/json");
      new Gson().toJson(colist,response.getWriter());
      
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}