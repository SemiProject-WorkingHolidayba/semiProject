package job.model.vo;

import java.io.Serializable;

public class Heart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -644535883193737813L;
	private int heartNo;
	private int jobNo;
	private int userNo;
	
	
	
	public Heart() {
		super();
	}
	public Heart(int heartNo, int jobNo, int userNo) {
		super();
		this.heartNo = heartNo;
		this.jobNo = jobNo;
		this.userNo = userNo;
	}
	public int getHeartNo() {
		return heartNo;
	}
	public void setHeartNo(int heartNo) {
		this.heartNo = heartNo;
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
	@Override
	public String toString() {
		return "Heart [heartNo=" + heartNo + ", jobNo=" + jobNo + ", userNo=" + userNo + "]";
	}
	
	
}
