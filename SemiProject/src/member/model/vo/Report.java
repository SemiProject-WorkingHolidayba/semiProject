package member.model.vo;

public class Report {
	
	private int reportno;
	private int categoryno;
	private int uploaduserno;
	private String uploaduser;
	private int boardno;
	private String process;
	private String reportuser;
	
	
	public Report() {
	}
	
	

	public Report(int upliaduserno, String uploaduser) {
		this.uploaduserno = upliaduserno;
		this.uploaduser = uploaduser;
	}


	



	public Report(int userno, int boardno) {
		super();
		this.uploaduserno = userno;
		this.boardno = boardno;
	}



	public Report(int reportno, int categoryno, String uploaduser, int boardno, String process, String reportuser) {
		this.reportno = reportno;
		this.categoryno = categoryno;
		this.uploaduser = uploaduser;
		this.boardno = boardno;
		this.process = process;
		this.reportuser = reportuser;
	}



	




	public Report(int reportno, int categoryno, int uploaduserno, String uploaduser, int boardno, String process,
			String reportuser) {
		this.reportno = reportno;
		this.categoryno = categoryno;
		this.uploaduserno = uploaduserno;
		this.uploaduser = uploaduser;
		this.boardno = boardno;
		this.process = process;
		this.reportuser = reportuser;
	}



	


	public int getUploaduserno() {
		return uploaduserno;
	}



	public void setUploaduserno(int uploaduserno) {
		this.uploaduserno = uploaduserno;
	}



	public int getReportno() {
		return reportno;
	}



	public void setReportno(int reportno) {
		this.reportno = reportno;
	}



	public int getCategoryno() {
		return categoryno;
	}



	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}



	public String getUploaduser() {
		return uploaduser;
	}



	public void setUploaduser(String uploaduser) {
		this.uploaduser = uploaduser;
	}



	public int getBoardno() {
		return boardno;
	}



	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}



	public String getProcess() {
		return process;
	}



	public void setProcess(String process) {
		this.process = process;
	}



	public String getReportuser() {
		return reportuser;
	}



	public void setReportuser(String reportuser) {
		this.reportuser = reportuser;
	}



	@Override
	public String toString() {
		return "Report [reportno=" + reportno + ", categoryno=" + categoryno + ", uploaduserno=" + uploaduserno
				+ ", uploaduser=" + uploaduser + ", boardno=" + boardno + ", process=" + process + ", reportuser="
				+ reportuser + "]";
	}



	
	
	
}