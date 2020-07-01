package community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;

/**
 * Servlet implementation class CommunityReportServlet
 */
@WebServlet("/report.bo")
public class CommunityReportServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int communityno = Integer.valueOf(request.getParameter("communityno"));
      
      int result = new CommunityService().reportCommunity(communityno);
      System.out.println("repport:" +result);
      if(result>0) {
         response.sendRedirect("Detail.bo?communityno="+communityno);
      } else {
         System.out.println("게시글 신고 실패");
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