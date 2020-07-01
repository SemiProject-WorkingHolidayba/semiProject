package community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;

/**
 * Servlet implementation class CommunityDeleteServelet
 */
@WebServlet("/delete.bo")
public class CommunityDeleteServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String communityno =request.getParameter("communityno");
      String categoryname= request.getParameter("categoryName");
   int result = new CommunityService().deleteCommunity(communityno);
   System.out.println("servlet" + result);
    RequestDispatcher view = null;
     if(result>0) {
        view = request.getRequestDispatcher("/list.bo?categoryName=공지사항");
        view.forward(request, response);
      
   }else {
      request.setAttribute("msg", "실패");
      
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