package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.model.service.CommunityService;
import home.model.service.HomeService;
import job.model.service.JobService;

/**
 * Servlet implementation class BoardSelectServlet
 */
@WebServlet("/boardselectservlet.me")
public class BoardSelectServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      int categoryno = Integer.valueOf((String) request.getParameter("categoryno"));
      int boardno = Integer.valueOf((String) request.getParameter("boardno"));
      
      System.out.println("categoryno:"+categoryno+" boardno:"+boardno);
      RequestDispatcher view = null;
      if(categoryno == 8) {
         int HouseNo = new HomeService().selectHouseNo(boardno);
         System.out.println("HouseNo"+HouseNo);
         view = request.getRequestDispatcher("/detail.ho?hNo="+HouseNo);
         
      }
      if(categoryno == 4) {
         int CommunityNo = new CommunityService().selectCommunityNo(boardno);
         System.out.println("CommunityNo"+CommunityNo);
         view = request.getRequestDispatcher("/Detail.bo?communityno="+CommunityNo);
      }
      if(categoryno == 6) {
    	 int jobNo = new JobService().selectJobNo(boardno);
    	 System.out.println("JobNo"+jobNo);
    	 view = request.getRequestDispatcher("/jobDetail.bo?jobNo="+jobNo);
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
