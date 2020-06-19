package home.model.vo;

public class Report {
	private int reportNo;
	private int boardNo;
	private String process;
	private String categoryNo;
	private int userNo;
	
	public Report() {}

	public Report(int reportNo, int boardNo, String process, String categoryNo, int userNo) {
		this.reportNo = reportNo;
		this.boardNo = boardNo;
		this.process = process;
		this.categoryNo = categoryNo;
		this.userNo = userNo;
	}
	
	
	
	

	public Report(int boardNo, String categoryNo, int userNo) {
		this.boardNo = boardNo;
		this.categoryNo = categoryNo;
		this.userNo = userNo;
	}

	public Report(int boardNo, int userNo) {
		this.boardNo = boardNo;
		this.userNo = userNo;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", boardNo=" + boardNo + ", process=" + process + ", categoryNo="
				+ categoryNo + ", userNo=" + userNo + "]";
	}
	
}

