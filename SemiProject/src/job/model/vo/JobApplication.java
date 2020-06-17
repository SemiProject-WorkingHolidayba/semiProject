package job.model.vo;

import java.sql.Date;

public class JobApplication {

	private int jobNo;			// 구직 글번호
	private String job;			// 직종
	private String period;		// 기간
	private String logoImg;		// 로고사진
	private int recruitment;	// 모집인원
	private String gender;		// 성별
	private String age;			// 연령
	private String address;		// 주소
	private String pay;			// 급여
	private Date dueDate;		// 마감일
	private Date workTime;		// 근무시간
	private String workDay;		// 근무요일
	private String title;		// 제목
	private String content;		// 내용
	private int jobReport;		// 신고
	private Date writeDate;		// 작성날짜
	private String countryNo;	// 나라번호
	private int userNo;			// 회원번호
	private String changeName; // ?
	private String country;	// 나라이름
	private int heartNo;	//찜번호
	private int jobApplyNo ;	// 구직신청번호
	private Date jobApplyDate;	// 구직 신청 날짜
	private String userName;
	private String email;
	private String typeNo;
	public JobApplication() {
		super();
	}
	
	public JobApplication(int jobNo, String job, String period, String logoImg, int recruitment, String gender,
			String age, String address, String pay, Date dueDate, Date workTime, String workDay, String title,
			String content, int jobReport, Date writeDate, String countryNo, int userNo, String changeName,
			String country, int heartNo, int jobApplyNo, Date jobApplyDate, String userName, String email,
			String typeNo) {
		super();
		this.jobNo = jobNo;
		this.job = job;
		this.period = period;
		this.logoImg = logoImg;
		this.recruitment = recruitment;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.pay = pay;
		this.dueDate = dueDate;
		this.workTime = workTime;
		this.workDay = workDay;
		this.title = title;
		this.content = content;
		this.jobReport = jobReport;
		this.writeDate = writeDate;
		this.countryNo = countryNo;
		this.userNo = userNo;
		this.changeName = changeName;
		this.country = country;
		this.heartNo = heartNo;
		this.jobApplyNo = jobApplyNo;
		this.jobApplyDate = jobApplyDate;
		this.userName = userName;
		this.email = email;
		this.typeNo = typeNo;
	}

	public String getTypeNo() {
		return typeNo;
	}

	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
	}

	public int getJobNo() {
		return jobNo;
	}
	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
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
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getWorkTime() {
		return workTime;
	}
	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}
	public String getWorkDay() {
		return workDay;
	}
	public void setWorkDay(String workDay) {
		this.workDay = workDay;
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
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getCountryNo() {
		return countryNo;
	}
	public void setCountryNo(String countryNo) {
		this.countryNo = countryNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getHeartNo() {
		return heartNo;
	}
	public void setHeartNo(int heartNo) {
		this.heartNo = heartNo;
	}
	public int getJobApplyNo() {
		return jobApplyNo;
	}
	public void setJobApplyNo(int jobApplyNo) {
		this.jobApplyNo = jobApplyNo;
	}
	public Date getJobApplyDate() {
		return jobApplyDate;
	}
	public void setJobApplyDate(Date jobApplyDate) {
		this.jobApplyDate = jobApplyDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "JobApplication [jobNo=" + jobNo + ", job=" + job + ", period=" + period + ", logoImg=" + logoImg
				+ ", recruitment=" + recruitment + ", gender=" + gender + ", age=" + age + ", address=" + address
				+ ", pay=" + pay + ", dueDate=" + dueDate + ", workTime=" + workTime + ", workDay=" + workDay
				+ ", title=" + title + ", content=" + content + ", jobReport=" + jobReport + ", writeDate=" + writeDate
				+ ", countryNo=" + countryNo + ", userNo=" + userNo + ", changeName=" + changeName + ", country="
				+ country + ", heartNo=" + heartNo + ", jobApplyNo=" + jobApplyNo + ", jobApplyDate=" + jobApplyDate
				+ ", userName=" + userName + ", email=" + email + ", typeNo=" + typeNo + "]";
	}

	
}
