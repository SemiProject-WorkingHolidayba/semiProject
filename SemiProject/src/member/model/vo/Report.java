package member.model.vo;

public class Report {
	
	private int reportno;
	private int boardno;
	private String process;
	private int categoryno;
	private String userid;
	private int userno;
	public Report() {
		super();
	}
	public Report(int reportno, int boardno, String process, int categoryno, String userid, int userno) {
		super();
		this.reportno = reportno;
		this.boardno = boardno;
		this.process = process;
		this.categoryno = categoryno;
		this.userid = userid;
		this.userno = userno;
	}
	public int getReportno() {
		return reportno;
	}
	public void setReportno(int reportno) {
		this.reportno = reportno;
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
	public int getCategoryno() {
		return categoryno;
	}
	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	@Override
	public String toString() {
		return "Report [reportno=" + reportno + ", boardno=" + boardno + ", process=" + process + ", categoryno="
				+ categoryno + ", userid=" + userid + ", userno=" + userno + "]";
	}
	
	
	
	
	
}