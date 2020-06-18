package community.model.vo;

public class CommunityCategory {
	private String categoryNo;
	private String categoryName;
	public CommunityCategory() {
		super();
	}
	public CommunityCategory(String categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "CommunityCategory [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
	
	
	
	
	
}
