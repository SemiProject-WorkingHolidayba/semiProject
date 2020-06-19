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

import job.model.service.JobSearchService;
import job.model.vo.JobSearch;
import member.model.vo.Member;

/**
 * Servlet implementation class JJimDeleteServlet
 */
@WebServlet("/delete.jjim")
public class JJimDeleteServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JJimDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      Member loginUser = (Member)session.getAttribute("loginUser");
      int userNo = loginUser.getUserNo();
      String heartNo = request.getParameter("heartNo");
   
      int heartNo2 = Integer.valueOf(heartNo);
      
      int result = new JobSearchService().deleteHeart(userNo,heartNo2);
      System.out.println(result);
      RequestDispatcher view = null;
      if(result >0) {
      
         view = request.getRequestDispatcher("/list.job");
         
      }else {
         view = request.getRequestDispatcher("views/common/errorPage.jsp");
         request.setAttribute("msg", "게시글 조회 실패!!");
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