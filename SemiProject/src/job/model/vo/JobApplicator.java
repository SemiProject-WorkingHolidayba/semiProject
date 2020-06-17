package job.model.vo;

public class JobApplicator {
	private int jobApplyNo;
    private String title;
    private String userName;
    private String period;
    private String email;
	public JobApplicator() {
		super();
	}
	public JobApplicator(int jobApplyNo, String title, String userName, String period, String email) {
		super();
		this.jobApplyNo = jobApplyNo;
		this.title = title;
		this.userName = userName;
		this.period = period;
		this.email = email;
	}
	public int getJobApplyNo() {
		return jobApplyNo;
	}
	public void setJobApplyNo(int jobApplyNo) {
		this.jobApplyNo = jobApplyNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "JobApplicator [jobApplyNo=" + jobApplyNo + ", title=" + title + ", userName=" + userName + ", period="
				+ period + ", email=" + email + "]";
	}
    
    
    
}
