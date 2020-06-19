package home.model.vo;

import java.io.Serializable;

public class Img implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2461465987543150568L;
	private int imgNo;
	private int houseNo;
	private String img;
	private String saveImg;
	private int fileLevel;
	
	public Img() {}

	public Img(int imgNo, int houseNo, String img, String saveImg, int fileLevel) {
		this.imgNo = imgNo;
		this.houseNo = houseNo;
		this.img = img;
		this.saveImg = saveImg;
		this.fileLevel = fileLevel;
	}

	public int getImgNo() {
		return imgNo;
	}

	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSaveImg() {
		return saveImg;
	}

	public void setSaveImg(String saveImg) {
		this.saveImg = saveImg;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Img [imgNo=" + imgNo + ", houseNo=" + houseNo + ", img=" + img + ", saveImg=" + saveImg + ", fileLevel="
				+ fileLevel + "]";
	}

	

	
	
}
