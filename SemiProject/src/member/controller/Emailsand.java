package member.controller;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

public class Emailsand {

	public static String EmailSandMethod(String email) {
		String host = "smtp.naver.com";
		String user = "cooyong@naver.com"; // 자신의 네이버 계정
		String password = "cc023607300";// 자신의 네이버 패스워드
		
		//이메일 받을 주소
		String to_email = email;
		
		// SMTP 서버 정보를 설정한다.
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		
		// 인증 번호 생성기
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		String AuthenticationKey = temp.toString();
//		System.out.println(AuthenticationKey);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		// email 전송
				try {
					MimeMessage msg = new MimeMessage(session);
					msg.setFrom(new InternetAddress(user, "WT관리자"));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));

					// 메일 제목
					msg.setSubject("[WORKING THROUGH] 이메일 인증번호가 도착 하였습니다 ");
					// 메일 내용
					msg.setText("인증 번호 :" + temp +"\n\n 인증번호를 확인한 후 정확히 입력하여 이메일 인증을 완료해 주세요.");

					Transport.send(msg);
					System.out.println("이메일 전송");

				} catch (Exception e) {
					e.printStackTrace();// TODO: handle exception
				}
					
				
				

		return AuthenticationKey;
	}
}
