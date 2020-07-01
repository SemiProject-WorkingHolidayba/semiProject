package job.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.model.service.JobService;
import job.model.vo.Job;
import member.model.vo.Member;

/**
 * Servlet implementation class jobReportServlet
 */
@WebServlet("/jobReprot.bo")
public class jobReportServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String jno=request.getParameter("jobno");
      int jobNo=Integer.valueOf(jno);
      
      String userId=request.getParameter("userId");
      Job j=new JobService().selectUserNo(jobNo,userId);
      
      j.setUserId(request.getParameter("userid"));
      int writer=j.getUserNo();
      
      
      int rResult= new JobService().jobReport(jobNo, writer);
      
      if(rResult>0) {
         response.sendRedirect(request.getContextPath()+"/jobDetail.bo?jobNo="+jobNo);
      }else {
          request.setAttribute("msg", "게시판 조회 실패");
          request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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