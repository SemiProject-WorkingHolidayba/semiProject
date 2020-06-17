package job.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import common.JobFileRenamePolicy;
import job.model.service.JobService;
import job.model.vo.Job;
import member.model.vo.Member;

/**
 * Servlet implementation class jobRegistServlet
 */
@WebServlet("/jobRegist.bo")
public class jobRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 -------------------------------------------------------------

		int maxSize=1024*1024*10;
		RequestDispatcher view=null;

		if (!ServletFileUpload.isMultipartContent(request)) {
			view=request.getRequestDispatcher("views/board/boardError.jsp");
			request.setAttribute("message","formenctype속성사용안됨!");
			view.forward(request,response);
		}

		String root=request.getSession().getServletContext().getRealPath("/");
		String savePath=root+"job_uploadFiles/";
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",new JobFileRenamePolicy());
		Job j=new Job();
		
		HttpSession session=request.getSession();
		 
//		Member loginUser=(Member)session.getAttribute("loginUser"); 
		Member loginUser=new Member(); 
		String writer=loginUser.getUserId();

		
		j.setTitle(multiRequest.getParameter("title"));									// 제목
		j.setCountry(multiRequest.getParameter("nation"));								// 나라
		j.setCoName(multiRequest.getParameter("coname"));								// 회사명
		j.setJobCategory(multiRequest.getParameter("jobCategory"));						// 직종
		j.setPeriod(multiRequest.getParameter("period"));								// 기간
		j.setWorkday(multiRequest.getParameter("workday"));								// 요일선택
		j.setAddress(multiRequest.getParameter("address"));								// 주소
		j.setRecruitment(Integer.valueOf(multiRequest.getParameter("recruitment")));	// 모집인원
		j.setGender(multiRequest.getParameter("gender"));								// 성별
		j.setPay(multiRequest.getParameter("pay"));										// 시급
		j.setAge(multiRequest.getParameter("age"));										// 연령
		j.setDueDate(multiRequest.getParameter("dueDate")); 							// 마감일
		j.setWorktime(multiRequest.getParameterValues("worktime")[0]);	 				// 근무시간
		j.setLogoImg(multiRequest.getOriginalFileName("logoImg"));						// 이미지파일첨부(원본파일명)
		j.setContent(multiRequest.getParameter("content"));		 						// 상세내용
		j.setChangeName(multiRequest.getFilesystemName("logoImg"));						// 바꾼파일명
		
		
		j.setUserId(multiRequest.getParameter("writer"));								// 작성자
		j.setFilePath(savePath);
		
		System.out.println("title : " +(multiRequest.getParameter("title")) );
		System.out.println("nation : "+(multiRequest.getParameter("nation")));
		System.out.println("coname : "+(multiRequest.getParameter("coname")));
		System.out.println("jobCategory : "+(multiRequest.getParameter("jobCategory")));
		System.out.println("period : "+(multiRequest.getParameter("period")));
		System.out.println("workday : "+(multiRequest.getParameter("workday")));
		System.out.println("address : "+(multiRequest.getParameter("address")));
		System.out.println("recruitment : "+(Integer.valueOf(multiRequest.getParameter("recruitment"))));
		System.out.println("gender : "+(multiRequest.getParameter("gender")));
		System.out.println("pay : "+(multiRequest.getParameter("pay")));
		System.out.println("age : "+(multiRequest.getParameter("age")));
		System.out.println("dueDate : "+(multiRequest.getParameter("dueDate")));
		System.out.println("worktime : "+(multiRequest.getParameterValues("worktime")[0]));
		System.out.println("logoImg : "+(multiRequest.getOriginalFileName("logoImg")));
		System.out.println("content : "+(multiRequest.getParameter("content")));
		System.out.println("writer : "+(multiRequest.getParameter("writer")));
		System.out.println("changeName : "+(multiRequest.getFilesystemName("changeName")));
		System.out.println("filePath : "+(multiRequest.getParameter("filePath")));



		int result=new JobService().insertBoard(j);
		
		if(result>0) {
			 response.sendRedirect("jobList.bo?currentPage=1");
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
