package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import community.model.service.CommunityService;
import community.model.vo.Community;
import home.model.service.HomeService;
import home.model.vo.Home;
import home.model.vo.Img;
import safeInfo.model.service.SafeService;
import safeInfo.model.vo.Safe;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test.test")
public class Test extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      HomeService hService = new HomeService();
      SafeService sService = new SafeService();
      CommunityService cService = new CommunityService();
      
      int currentPage = 1;
      int limit=10000;
      System.out.println("서블릿옴");
      ArrayList<Home> Homelist = hService.selectList(currentPage, limit);
      ArrayList<Img> Imglist = hService.selectImgList(currentPage, limit);
      ArrayList<Safe> Safelist = sService.selectList(currentPage, limit);
      ArrayList<Community> Commulist = cService.selectList(currentPage, limit, "공지사항");
      
      System.out.println( Homelist);
      System.out.println( Imglist);
      System.out.println(Commulist);
      
      HttpSession session = request.getSession();
      if( Homelist != null) {
         
         session.setAttribute("Homelist", Homelist);
         session.setAttribute("Imglist", Imglist);
         session.setAttribute("Safelist", Safelist);
         session.setAttribute("Commulist", Commulist);
         response.sendRedirect("main.jsp");
         
      } else {
         RequestDispatcher view = request.getRequestDispatcher("views/member/login.jsp");
         view.forward(request, response);
         System.out.println("게시글 조회 실패");
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