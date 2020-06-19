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
 * Servlet implementation class JobApplicationDeleteServlet
 */
@WebServlet("/delete.job")
public class JobApplicationDeleteServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobApplicationDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("여기");
      JobSearchService jService = new JobSearchService();
      HttpSession session = request.getSession();
      Member loginUser = (Member)session.getAttribute("loginUser");
      int userNo = loginUser.getUserNo();
      
      String jobApplyNo = request.getParameter("jobApplyNo");
   
      int jobApplyNo2 = Integer.valueOf(jobApplyNo);
      System.out.println(jobApplyNo);
      int result = new JobSearchService().deleteA(jobApplyNo2,userNo);
      System.out.println(result);
      RequestDispatcher view = null;
      if(result >0) {
         view = request.getRequestDispatcher("/list.aj");
      }else {
         view = request.getRequestDispatcher("/views/common/errorPage.jsp");
      }
      view.forward(request,response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}