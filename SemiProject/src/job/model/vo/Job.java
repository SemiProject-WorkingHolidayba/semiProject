package job.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Job implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2817120053313317814L;
	private int jobNo;					// 구직글번호
	private String jobCategory;			// 직종
	private String period;				// 기간
	private String logoImg;				// 로고사진
	private int recruitment;			// 모집인원
	private String gender;				// 성별
	private String age;					// 연령
	private String address;				// 주소
	private String pay;					// 급여
	private String dueDate;				// 마감일
	private String worktime;				// 근무시간
	private String workday;				// 근무요일
	private String title;				// 제목
	private String content;				// 상세내용
	private int jobReport;				// 신고
	private Date wirteDate;				// 작성날짜
	private String country;			// 나라번호
	private String userId;				// 작성자(회원번호)
	private String changeName;			// 로고사진 파일이름변경
	private String filePath;			// 파일 저장위치
	private String coName;				// 회사명
	
	public Job() {
		super();
	}

	public Job(int jobNo, String jobCategory, String period, String logoImg, int recruitment, String gender, String age,
			String address, String pay, String dueDate, String worktime, String workday, String title, String content,
			int jobReport, Date wirteDate, String country, String userId, String changeName, String filePath,
			String coName) {
		super();
		this.jobNo = jobNo;
		this.jobCategory = jobCategory;
		this.period = period;
		this.logoImg = logoImg;
		this.recruitment = recruitment;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.pay = pay;
		this.dueDate = dueDate;
		this.worktime = worktime;
		this.workday = workday;
		this.title = title;
		this.content = content;
		this.jobReport = jobReport;
		this.wirteDate = wirteDate;
		this.country = country;
		this.userId = userId;
		this.changeName = changeName;
		this.filePath = filePath;
		this.coName = coName;
	}
	
	
	public Job(int jobNo, String jobCategory, String period, String logoImg, String dueDate, String worktime,
			String workday, String title, String content, int jobReport, Date wirteDate, String country, String userId,
			String changeName, String filePath, String coName) {
		super();
		this.jobNo = jobNo;
		this.jobCategory = jobCategory;
		this.period = period;
		this.logoImg = logoImg;
		this.dueDate = dueDate;
		this.worktime = worktime;
		this.workday = workday;
		this.title = title;
		this.content = content;
		this.jobReport = jobReport;
		this.wirteDate = wirteDate;
		this.country = country;
		this.userId = userId;
		this.changeName = changeName;
		this.filePath = filePath;
		this.coName = coName;
	}

	public int getJobNo() {
		return jobNo;
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getLogoImg() {
		return logoImg;
	}

	public void setLogoImg(String logoImg) {
		this.logoImg = logoImg;
	}

	public int getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(int recruitment) {
		this.recruitment = recruitment;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getWorktime() {
		return worktime;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	public String getWorkday() {
		return workday;
	}

	public void setWorkday(String workday) {
		this.workday = workday;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getJobReport() {
		return jobReport;
	}

	public void setJobReport(int jobReport) {
		this.jobReport = jobReport;
	}

	public Date getWirteDate() {
		return wirteDate;
	}

	public void setWirteDate(Date wirteDate) {
		this.wirteDate = wirteDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getCoName() {
		return coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Job [jobNo=" + jobNo + ", jobCategory=" + jobCategory + ", period=" + period + ", logoImg=" + logoImg
				+ ", recruitment=" + recruitment + ", gender=" + gender + ", age=" + age + ", address=" + address
				+ ", pay=" + pay + ", dueDate=" + dueDate + ", worktime=" + worktime + ", workday=" + workday
				+ ", title=" + title + ", content=" + content + ", jobReport=" + jobReport + ", wirteDate=" + wirteDate
				+ ", country=" + country + ", userId=" + userId + ", changeName=" + changeName + ", filePath="
				+ filePath + ", coName=" + coName + "]";
	}

}
