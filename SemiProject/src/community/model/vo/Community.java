package community.model.vo;

import java.sql.Date;

public class Community {
   private int communityNo;
   private String title;
   private String content;
   private Date writeDate;
   private int viewCount;
   private int report;
   private String country;
   private String categoryName;
   private String userId;

 
   public Community() {
	super();
}
public Community(int communityNo, String title, String content, Date writeDate, int viewCount, int report,
         String country, String categoryName, String userId) {
      super();
      this.communityNo = communityNo;
      this.title = title;
      this.content = content;
      this.writeDate = writeDate;
      this.viewCount = viewCount;
      this.report = report;
      this.country = country;
      this.categoryName = categoryName;
      this.userId = userId;
      
   }
   public int getCommunityNo() {
      return communityNo;
   }
   public void setCommunityNo(int communityNo) {
      this.communityNo = communityNo;
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
   public Date getWriteDate() {
      return writeDate;
   }
   public void setWriteDate(Date writeDate) {
      this.writeDate = writeDate;
   }
   public int getViewCount() {
      return viewCount;
   }
   public void setViewCount(int viewCount) {
      this.viewCount = viewCount;
   }
   public int getReport() {
      return report;
   }
   public void setReport(int report) {
      this.report = report;
   }
   public String getCountry() {
      return country;
   }
   public void setCountry(String country) {
      this.country = country;
   }
   public String getCategoryName() {
      return categoryName;
   }
   public void setCategoryName(String categoryName) {
      this.categoryName = categoryName;
   }
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }

   @Override
   public String toString() {
      return "Community [communityNo=" + communityNo + ", title=" + title + ", content=" + content + ", writeDate="
            + writeDate + ", viewCount=" + viewCount + ", report=" + report + ", country=" + country
            + ", categoryName=" + categoryName + ", userId=" + userId + "]";
   }
   
   

}