package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class DeleteReportBoard
 */
@WebServlet("/deletereportboard.me")
public class DeleteReportBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReportBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryNo = Integer.valueOf(request.getParameter("categoryNo"));
		int boardNo = Integer.valueOf(request.getParameter("boardNo"));
		int reportNo = Integer.valueOf(request.getParameter("reportNo"));
		 PrintWriter out = response.getWriter();
		int result = new MemberService().ReportDeleteBoard(categoryNo,boardNo);
		int reuslt2 = new MemberService().SetProcess(reportNo,"BR");
		if(reuslt2 > 0) {
			 
			 out.print("Y");
	 
		 }else { 
			 out.print("N");
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
