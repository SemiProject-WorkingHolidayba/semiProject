package job.controller;

import java.io.IOException;

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
import job.model.vo.JobApply;
import member.model.vo.Member;

/**
 * Servlet implementation class jobApplicationServlet
 */
@WebServlet("/jobApply.bo")
public class jobApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobApplicationServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jno = request.getParameter("jobno");
		int jobNo = Integer.valueOf(jno);
				
		int maxSize=1024*1024*10;
		RequestDispatcher view=null;

		if (!ServletFileUpload.isMultipartContent(request)) {
			view=request.getRequestDispatcher("views/board/boardError.jsp");
			request.setAttribute("message","formenctype속성사용안됨!");
			view.forward(request,response);
		}

		String root=request.getSession().getServletContext().getRealPath("/");
		String savePath=root+"job_resumeFiles/";
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",new JobFileRenamePolicy());
		JobApply j=new JobApply();
		
		HttpSession session=request.getSession();
		 
		Member loginUser=(Member)session.getAttribute("loginUser"); 
		int userNo=loginUser.getUserNo();

		j.setJobNo(jobNo);																// jobNo
		j.setUserNo(userNo); 															// userNo
		j.setJobApplyDate(multiRequest.getParameter("jobapplydate"));					// 지원시간
		j.setResumeFile(multiRequest.getOriginalFileName("resumeFile"));				// 이미지파일첨부(원본파일명)
		j.setChangeName(multiRequest.getFilesystemName("resumeFile"));					// 바꾼파일명
		j.setFilePath(savePath);														// 저장경로
		
		int result=new JobService().insertJobApply(j,userNo,jobNo);
		
		if(result>0) {
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
