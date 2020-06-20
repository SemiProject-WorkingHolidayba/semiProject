package home.controller;

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

import home.model.service.HomeService;
import home.model.vo.Home;
import home.model.vo.Img;
import member.model.vo.Member;

/**
 * Servlet implementation class HomeInsertServlet
 */
@WebServlet("/insert.ho")
public class HomeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int maxSize = 1024 * 1024 * 10;
		
		String root = "C:\\semiProject\\SemiProject\\web\\";
		String savePath = root + "home_uploadFiles/";
		
		System.out.println(root);
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		HttpSession session = request.getSession();
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		String title = multiRequest.getParameter("title");
		String country = multiRequest.getParameter("country");
		String home = multiRequest.getParameter("home");
		String period = multiRequest.getParameter("period");
		String address = multiRequest.getParameter("address");
		String facilities[] = multiRequest.getParameterValues("facilities");
		String share[] = multiRequest.getParameterValues("share");
		String pet = multiRequest.getParameter("pet");
		int fee = Integer.valueOf(multiRequest.getParameter("fee"));
		String detail = multiRequest.getParameter("detail");
		int userNo = Integer.valueOf(loginUser.getUserNo());

		ArrayList<String> saveFiles = new ArrayList<>();
		ArrayList<String> originFiles = new ArrayList<>();
		
		Enumeration<String> files = multiRequest.getFileNames();

		while(files.hasMoreElements()) {
			String name = files.nextElement();
			
			if(multiRequest.getFilesystemName(name) != null) {
				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));
			}
		}
		
		
		Home h = new Home();
		h.setTitle(title);
		switch(country) {
			case "호주" : h.setCountryNo("N1"); break;
			case "일본" : h.setCountryNo("N2"); break;
			case "캐나다" : h.setCountryNo("N3"); break;
			case "뉴질랜드" : h.setCountryNo("N4"); break;
			case "독일" : h.setCountryNo("N5"); break;
			default : break;
		}
		
		h.setType(home);
		h.setPeriod(period);
		h.setAddress(address);
		h.setEssentialitem("N");
		h.setWifi("N");
		h.setTelevision("N");
		h.setHeater("N");
		h.setAirconditional("N");
		h.setLivingroom("N");
		h.setDiningroom("N");
		h.setBathroom("N");
		
		for(int i = 0; i < facilities.length; i++) {
			switch(facilities[i]) {
				case "essentialitem" : h.setEssentialitem("Y"); break;
				case "wifi" : h.setWifi("Y"); break;
				case "tv" : h.setTelevision("Y"); break;
				case "heater" : h.setHeater("Y"); break;
				case "aircondition" : h.setAirconditional("Y");break;
				default : break;
			}
		}
		
		for(int i = 0; i < share.length; i++) {
			switch(share[i]) {
				case "livingroom" : h.setLivingroom("Y"); break;
				case "diningroom" : h.setDiningroom("Y"); break;
				case "bathroom" : h.setBathroom("Y"); break;
				default : break;
			}
		}
		
		h.setPet(pet);
		h.setFee(fee);
		h.setContent(detail);
		h.setWriterNo(userNo);
		
		ArrayList<Img> fileList = new ArrayList<Img>();
		
		for(int i = originFiles.size()-1; i>=0; i--) {
			Img at = new Img();
			at.setImg(originFiles.get(i));
			at.setSaveImg(saveFiles.get(i));
			
			if(i == originFiles.size()-1) {	// 대표이미지
				at.setFileLevel(0);
			} else {
				at.setFileLevel(1);
			}
			
			fileList.add(at);
			
		}
		
		int result = new HomeService().insertHome(h,fileList);
		
		if(result > 0) {
			response.sendRedirect("list.ho?currentPage=1");
		} else {
			System.out.println("게시글 등록 실패");
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
