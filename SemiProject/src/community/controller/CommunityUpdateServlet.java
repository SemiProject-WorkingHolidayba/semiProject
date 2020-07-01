package community.controller;

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

import common.MyFileRenamePolicy;
import community.model.service.CommunityService;
import community.model.vo.Community1;
import community.model.vo.CommunityImg;
import member.model.vo.Member;

/**
 * Servlet implementation class CommunityInsertServlet
 */
@WebServlet("/update.bo")
public class CommunityUpdateServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityUpdateServlet() {
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
      System.out.println("root : "+root);
      String savePath =root + "community_uploadFiles/";
      
      MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
      int cNo = Integer.valueOf(multiRequest.getParameter("cno"));

      HttpSession session = request.getSession();
   
      Member loginUser= (Member)session.getAttribute("loginUser");
      
      String title = multiRequest.getParameter("title");
   

//      int communityNo=Integer.valueOf(multiRequest.getParameter("communityNo"));
      
      String content = multiRequest.getParameter("content");
   
   
      String country=multiRequest.getParameter("country");
      String category = multiRequest.getParameter("categoryName");
      
       int userNo=loginUser.getUserNo();
//      String userId = Integer.valueOf(loginUser.getUserNo()).toString(
       ArrayList<String> saveFiles = new ArrayList<>();
       
       ArrayList<String> originFiles = new ArrayList();
       
       Enumeration<String> files = multiRequest.getFileNames();
         while(files.hasMoreElements()) {
            
            // 전송 순서 역순으로 파일을 가져온다.
            String name = files.nextElement();
            
            if(multiRequest.getFilesystemName(name) != null) {
               // getFilesystemName() - 변화된 파일명(rename된 파일명)을 가져옴
               saveFiles.add(multiRequest.getFilesystemName(name));
               // getOriginalFileName() - 실제 사용자가 업로드 했던 파일 명
               originFiles.add(multiRequest.getOriginalFileName(name));
            }
         }
         
         System.out.println("save" + saveFiles);
         System.out.println("origin" + originFiles);
      Community1 c = new Community1();
   
      c.setCommunityNo(cNo);
      c.setTitle(title);
      c.setContent(content);
      c.setCountryNo(country);
      c.setCategoryNo(category);
      c.setUserNo(userNo);
   
      
      
      
      
      ArrayList<CommunityImg> fileList = new ArrayList<CommunityImg>();
      //전송 순서를 역순으로 파일이 list에 저장되었기 때문에 반복문을 통해 다시 역순을 수행

      for(int i = originFiles.size()-1 ; i >= 0; i--) {
            CommunityImg ci = new CommunityImg();
            ci.setCommunityNo(c.getCommunityNo());
            ci.setFilePath(savePath);
            ci.setOriginName(originFiles.get(i));
            ci.setChangeName(saveFiles.get(i));
      //   ci.setCommunityNo(communityNo);
            fileList.add(ci);
         }
      
      
      System.out.println("servlet : " + c);
      System.out.println("servlet : " + fileList);
            int result = new CommunityService().updateCommunity(c,fileList);
               
               if(result>0) {
                  response.sendRedirect("list.bo?currentPage=1");// 나 list.bo로 갈껀데 currentPage=1 이거 들고 가! 라고 하는 것
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