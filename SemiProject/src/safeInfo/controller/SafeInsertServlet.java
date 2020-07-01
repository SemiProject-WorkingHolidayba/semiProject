package safeInfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.model.vo.Member;
import safeInfo.model.service.SafeService;
import safeInfo.model.vo.Safe;

/**
 * Servlet implementation class SafeInsertServlet
 */
@WebServlet("/insert.si")
public class SafeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SafeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int maxSize = 1024 * 1024 * 10;
		String root = request.getSession().getServletContext().getRealPath("/");
		System.out.println(root);
		String savePath =root + "safe_uploadFiles/";
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		String title = multiRequest.getParameter("title");
		
		String content = multiRequest.getParameter("content");
		
		String country=multiRequest.getParameter("countryNo");
		
		HttpSession session = request.getSession();
	
		Member loginUser= (Member)session.getAttribute("loginUser");
		
		 int userNo=loginUser.getUserNo();

		Safe s  = new Safe();
		
		s.setTitle(title);
		s.setContent(content);
		s.setCountryNo(country);
		s.setImg(multiRequest.getFilesystemName("img"));
		
		System.out.println(s);

		int result = new SafeService().insertSafe(s);
		   
	      if(result>0) {
	         response.sendRedirect("list.si?currentPage=1");
	      }else {
	         request.setAttribute("msg", "게시판 조회 실패");
	        
	         
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
