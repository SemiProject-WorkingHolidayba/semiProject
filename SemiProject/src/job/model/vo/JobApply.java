package job.model.vo;

public class JobApply {
	private int jobApplyNo;
	private int jobNo;
	private int userNo;
	private String jobApplyDate;
	private String resumeFile;
	private String changeName;
	private String filePath;
	
	public JobApply() {
		super();
	}

	public JobApply(int jobApplyNo, int jobNo, int userNo, String jobApplyDate, String resumeFile, String changeName,
			String filePath) {
		super();
		this.jobApplyNo = jobApplyNo;
		this.jobNo = jobNo;
		this.userNo = userNo;
		this.jobApplyDate = jobApplyDate;
		this.resumeFile = resumeFile;
		this.changeName = changeName;
		this.filePath = filePath;
	}

	public int getJobApplyNo() {
		return jobApplyNo;
	}

	public void setJobApplyNo(int jobApplyNo) {
		this.jobApplyNo = jobApplyNo;
	}

	public int getJobNo() {
		return jobNo;
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getJobApplyDate() {
		return jobApplyDate;
	}

	public void setJobApplyDate(String jobApplyDate) {
		this.jobApplyDate = jobApplyDate;
	}

	public String getResumeFile() {
		return resumeFile;
	}

	public void setResumeFile(String resumeFile) {
		this.resumeFile = resumeFile;
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

	@Override
	public String toString() {
		return "JobApply [jobApplyNo=" + jobApplyNo + ", jobNo=" + jobNo + ", userNo=" + userNo + ", jobApplyDate="
				+ jobApplyDate + ", resumeFile=" + resumeFile + ", changeName=" + changeName + ", filePath=" + filePath
				+ "]";
	}
	
	
}
	
	
	
