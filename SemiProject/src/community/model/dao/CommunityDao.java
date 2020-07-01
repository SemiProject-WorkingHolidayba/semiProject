package community.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import community.model.vo.Comment;
import community.model.vo.Community;
import community.model.vo.Community1;
import community.model.vo.CommunityImg;
import community.model.vo.CommunityMy;
import community.model.vo.Report;
public class CommunityDao {

   public CommunityMy selectcCommunity(Connection conn, int communityNo2, int categoryNo2) {

      PreparedStatement pstmt = null;
      ResultSet rs = null;
   
      String query = "SELECT * " + 
            "FROM MYCLIST" + 
            "WHERE COMMUNITYNO = ? AND CATEGORYNO = ?";
      
      CommunityMy community =null;
      
      try {
         pstmt =conn.prepareStatement(query);
         pstmt.setInt(1, communityNo2);
         pstmt.setInt(2, categoryNo2);
         
         rs = pstmt.executeQuery();
         
         if(rs.next()){
             community = new CommunityMy(rs.getInt("communityNo"),
                                 rs.getString("title"),
                                 rs.getString("content"),
                                 rs.getDate("writeDate"),
                                 rs.getInt("viewCount"),
                                 rs.getInt("report"),   
                                 rs.getString("countryNo"),
                                 rs.getString("categoryNo"),
                                 rs.getInt("userNo"),
                                 rs.getString("categoryName"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstmt);
         close(rs);
      }
   
         return community;
   }

   public int getcListCount(Connection conn, int userNo) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      String query = "SELECT COUNT(*) FROM MYCLIST WHERE USERNO=?";
      
      int result = 0;
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1, userNo);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            result = rs.getInt(1);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rs);
      }
      
      return result;

   }

   public ArrayList selectcList(Connection conn, int currentPage, int limit, int userNo) {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      ArrayList list = new ArrayList();
      
      int startRow = (currentPage-1) * limit + 1;
      int endRow = currentPage * limit;

      String query = "SELECT C.* FROM MYCLIST C WHERE (RNUM BETWEEN ? AND ? ) AND USERNO=?";
      
      try {
         pstmt = conn.prepareStatement(query);
         pstmt.setInt(1,startRow);
         pstmt.setInt(2, endRow);
         pstmt.setInt(3, userNo);
         rs = pstmt.executeQuery();
         
         while(rs.next()){
            CommunityMy community = new CommunityMy(rs.getInt("communityNo"),
                  rs.getString("title"),
                  rs.getString("content"),
                  rs.getDate("writeDate"),
                  rs.getInt("viewCount"),
                  rs.getInt("report"),   
                  rs.getString("countryNo"),
                  rs.getString("categoryNo"),
                  rs.getInt("userNo"),
                  rs.getString("categoryName"));
            list.add(community);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
         close(rs);
      }
      
      return list;
      
   }
   public int getListCount(Connection conn, String category) {
         PreparedStatement pstmt = null;
         ResultSet rs  = null;
         
         String query = "SELECT COUNT(*) FROM(SELECT * FROM CLIST WHERE CATEGORYNAME = ?)";
         
         int result = 0;
         
         try {
            pstmt= conn.prepareStatement(query);
           pstmt.setString(1, category);
            rs= pstmt.executeQuery();
            if(rs.next()) {
               result = rs.getInt(1);
               }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } finally {
            close(pstmt);
            close(rs);
         }
      
         
         return result;
      }

   public ArrayList selectList(Connection conn, int currentPage, int limit, String category) {
         PreparedStatement pstmt = null;
         ResultSet rs= null;
         
         ArrayList list = new ArrayList();
         int startRow = (currentPage-1) * limit +1;
         int endRow = currentPage*limit;
         
         String query ="SELECT * FROM(SELECT ROWNUM R, A.* FROM(SELECT * FROM CLIST WHERE CATEGORYNAME = ?)A)B WHERE R BETWEEN ? AND ? AND STATUS ='N'";
         
         //************************** 바로위 수정 요망****************************>
         try {
            pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1,category);
            pstmt.setInt(2,startRow);
            pstmt.setInt(3, endRow);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
               Community c =new Community(rs.getInt("communityno"),
                     rs.getString("title"),
                     rs.getString("content"),
                     rs.getDate("writedate"),
                     rs.getInt("viewcount"),
                     rs.getInt("report"),
                     rs.getString("country"),
                     rs.getString("categoryname"),
                     rs.getString("userid"),
                     rs.getString("status"));

               list.add(c);
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }finally {
            close(pstmt);
            close(rs);
         }
      

         return list;
      }

   

      
      public int insertCommunity(Connection conn, Community1 c) {
            PreparedStatement pstmt = null;
            int result= 0;
            
            String query ="INSERT INTO COMMUNITY VALUES(SEQ_COMMUNITYNO.NEXTVAL,?,?,SYSDATE,0,0,?,?,?,DEFAULT,DEFAULT)";
            
            try {
               pstmt = conn.prepareStatement(query);
               pstmt.setString(1,c.getTitle());
               pstmt.setString(2,c.getContent());
               pstmt.setString(3,c.getCountryNo());
               pstmt.setString(4,c.getCategoryNo());
               pstmt.setInt(5, c.getUserNo());
         
               
               
               
               result = pstmt.executeUpdate();   
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
               
            }finally {
               close(pstmt);
            }
            return result;
         }

      
      public int insertCommunityImg(Connection conn, ArrayList<CommunityImg> fileList) {
            PreparedStatement pstmt = null;
            int result= 0;
            
            String query = "INSERT INTO CommunityImg VALUES(SEQ_IMGNO.NEXTVAL, SEQ_COMMUNITYNO.CURRVAL,?,?,?,SYSDATE)";
            try {
            for(int i = 0 ; i <fileList.size();i++) {
               CommunityImg ci = fileList.get(i);
               
                  
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, ci.getOriginName());
                  pstmt.setString(2, ci.getChangeName());
                  pstmt.setString(3, ci.getFilePath());
            
                  
                  
                  result = pstmt.executeUpdate();
               
            }
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }finally {
               close(pstmt);
            
         }
            return result;
      }

      
      public int updateCount(Connection conn, int communityno2) {
            PreparedStatement pstmt = null;
            int result = 0;
            
            String query = "UPDATE COMMUNITY SET VIEWCOUNT = VIEWCOUNT+1 WHERE COMMUNITYNO = ?";
            
            try {
               pstmt = conn.prepareStatement(query);
               pstmt.setInt(1, communityno2);
               result = pstmt.executeUpdate();
               
            } catch (SQLException e) {
               e.printStackTrace();
            }finally {
               close(pstmt);
            }
            
            return result;
         }


      public Community selectCommunity(Connection conn, int communityno) { /* 게시판 리스트 뿌려줌 */
            
            PreparedStatement pstmt = null;
            ResultSet rs= null;
            Community community =null;
            String query ="SELECT * FROM CLIST WHERE COMMUNITYNO=?";
            
            //************************** 바로위 수정 요망****************************>
            try {
               pstmt = conn.prepareStatement(query);
               pstmt.setInt(1, communityno);
               
               rs = pstmt.executeQuery();
               
               if(rs.next()) {
                  community = new Community(rs.getInt("communityno"),
                                       rs.getString("title"),
                                       rs.getString("content"),
                                       rs.getDate("writedate"),
                                       rs.getInt("viewcount"),
                                       rs.getInt("report"),
                                       rs.getString("country"),
                                       rs.getString("categoryname"),
                                       rs.getString("userid"),
                                       rs.getString("status"));
                                 

               
               }
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }finally {
               close(pstmt);
               close(rs);
            }
         

            return community;
         }

      public int updateCommunity(Connection conn, Community1 c) {
            PreparedStatement pstmt = null;
            int result= 0;
            
            String query ="UPDATE COMMUNITY SET Title = ?, Content=?,WRITEDATE = SYSDATE,viewcount = 0,report = 0,CountryNO=?,CategoryNo=? where communityno=?"; 
                  
            
            try {
               pstmt = conn.prepareStatement(query);
               
               pstmt.setString(1,c.getTitle());
               pstmt.setString(2,c.getContent());
               pstmt.setString(3,c.getCountryNo());
               pstmt.setString(4,c.getCategoryNo());
               pstmt.setInt(5, c.getCommunityNo());
               
               
               result = pstmt.executeUpdate();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
               
            }finally {
               close(pstmt);
            }
            return result;
            
         }


      public int updateCommunityImg(Connection conn, ArrayList<CommunityImg> fileList) {
            PreparedStatement pstmt = null;
            int result= 0;
            
            String query = "UPDATE COMMUNITYIMG SET ORIGINNAME =? ,CHANGENAME=? ,FILEPATH = ? ,IMGNO=? WHERE CommunityNo=? ";
            try {
            for(int i = 0 ; i <fileList.size();i++) {
               CommunityImg ci = fileList.get(i);
               
                  
                  pstmt = conn.prepareStatement(query);
               
                  pstmt.setString(1, ci.getOriginName());
                  pstmt.setString(2, ci.getChangeName());
                  pstmt.setString(3, ci.getFilePath());
                  pstmt.setInt(4, ci.getImgNo());
                  pstmt.setInt(5, ci.getCommunityNo());
                  
                  result = pstmt.executeUpdate();
               
            }
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }finally {
               close(pstmt);
            
         }
            return result;
         }


      public CommunityImg selectCommunityImg(Connection conn, int communityno) {
            PreparedStatement pstmt = null;
            ResultSet rs= null;
            CommunityImg communityimg =null;
            String query ="SELECT * FROM COMMUNITYIMG WHERE COMMUNITYNO=?";
            
            //************************** 바로위 수정 요망****************************>
            try {
               pstmt = conn.prepareStatement(query);
               pstmt.setInt(1, communityno);
               
               rs = pstmt.executeQuery();
               
               if(rs.next()) {
                  communityimg = new CommunityImg(rs.getInt("imgno"),
                                       rs.getInt("communityno"),
                                       rs.getString("originname"),
                                       rs.getString("changename"),
                                       rs.getString("filepath"),
                                       rs.getDate("uploaddate"));
                                       
                                 

               
               }
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }finally {
               close(pstmt);
               close(rs);
            }
            return communityimg;
         }


      public Community modifyCommunity(Connection conn, int communityno) {
            PreparedStatement pstmt = null;
            ResultSet rs= null;
            Community community =null;
            String query ="SELECT * FROM CLIST WHERE COMMUNITYNO=?";
            
            //************************** 바로위 수정 요망****************************>
            try {
               pstmt = conn.prepareStatement(query);
               pstmt.setInt(1, communityno);
               
               rs = pstmt.executeQuery();
               
               if(rs.next()) {
                  community = new Community(rs.getInt("communityno"),
                                       rs.getString("title"),
                                       rs.getString("content"),
                                       rs.getDate("writedate"),
                                       rs.getInt("viewcount"),
                                       rs.getInt("report"),
                                       rs.getString("country"),
                                       rs.getString("categoryname"),
                                       rs.getString("userid"),
                                       rs.getString("status"));
                                 

               
               }
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }finally {
               close(pstmt);
               close(rs);
            }
         

            return community;
         }


      public int modifyCommunityImg(Connection conn, ArrayList<CommunityImg> fileList) {
            PreparedStatement pstmt = null;
            int result= 0;
            
            String query = "INSERT INTO CommunityImg VALUES(SEQ_IMGNO.NEXTVAL, SEQ_COMMUNITYNO.CURRVAL,?,?,?,SYSDATE)";
            try {
            for(int i = 0 ; i <fileList.size();i++) {
               CommunityImg ci = fileList.get(i);
               
                  
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, ci.getOriginName());
                  pstmt.setString(2, ci.getChangeName());
                  pstmt.setString(3, ci.getFilePath());
            
                  
                  
                  result = pstmt.executeUpdate();
               
            }
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }finally {
               close(pstmt);
            
         }
            return result;
         }


      public ArrayList modifyImgList(Connection conn, int communityno) {
            PreparedStatement pstmt = null;
            ResultSet rs= null;
            CommunityImg communityimg =null;
            ArrayList list  = new ArrayList();
            String query ="SELECT * FROM COMMUNITYIMG WHERE COMMUNITYNO=?";
            
            //************************** 바로위 수정 요망****************************>
            try {
               pstmt = conn.prepareStatement(query);
               pstmt.setInt(1, communityno);
               
               rs = pstmt.executeQuery();
               
               while(rs.next()) {
                  communityimg = new CommunityImg(rs.getInt("imgno"),
                                       rs.getInt("communityno"),
                                       rs.getString("originname"),
                                       rs.getString("changename"),
                                       rs.getString("filepath"),
                                       rs.getDate("uploaddate"));
                                       
                                 

               
               }
               
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }finally {
               close(pstmt);
               close(rs);
            }
            return list;
            
         }


      public int deleteCommunity(Connection conn, String communityno) {
            PreparedStatement pstmt = null;
            int result= 0;
            String query = "UPDATE COMMUNITY SET STATUS = 'Y' WHERE COMMUNITYNO =?" ;
            
            try {
               pstmt= conn.prepareStatement(query);
               pstmt.setString(1, communityno);
               
               result= pstmt.executeUpdate();
            } catch (SQLException e) {
            
               e.printStackTrace();
            }finally {
               close(pstmt);
               
            }
            
            
            return result;
         }
      
      public int insertComment(Connection conn, Comment c) {
            PreparedStatement pstmt = null;
            int result =0;
            
            String query = "INSERT INTO COMMENTS VALUES(SEQ_COMMUNITYCOMMENT.NEXTVAL,?,SYSDATE,0,?,?,'N')";
               try {
                     pstmt = conn.prepareStatement(query);
                     pstmt.setString(1,c.getContent());
                     pstmt.setInt(2, c.getCommunityNo());
                     pstmt.setInt(3,c.getUserNo());
                     
                     result = pstmt.executeUpdate();
                  } catch (SQLException e) {
                     e.printStackTrace();
                  } finally {
                     close(pstmt);
                  }
                  
                  return result;
               }

         public ArrayList<Comment> selectCommentList(Connection conn, int communityno2) {
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            
            ArrayList<Comment> colist = new ArrayList<Comment>();
            String query = "SELECT * FROM COLIST WHERE COMMUNITYNO = ?";
            
            try {
               pstmt= conn.prepareStatement(query);
               pstmt.setInt(1, communityno2);
               rs = pstmt.executeQuery();
               
            while(rs.next()) {
               colist.add(new Comment(rs.getInt("commentno"),
                              rs.getString("content"),
                              rs.getDate("writedate"),
                              rs.getInt("report"),
                              rs.getInt("communityno"),
                              rs.getInt("userno"),
                              rs.getString("username")));         
            
            }
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }finally {
               close(pstmt);
               close(rs);
            }
            
            
            
            return colist;
         }

         public Community1 selectCommunity1(Connection conn, int communityno2) {
            PreparedStatement pstmt = null;
            ResultSet rs= null;
            Community1 community1 =null;
            String query ="SELECT * FROM COMMUNITY WHERE COMMUNITYNO=?";
            
            //************************** 바로위 수정 요망****************************>
            try {
               pstmt = conn.prepareStatement(query);
               pstmt.setInt(1, communityno2);
               
               rs = pstmt.executeQuery();
               
               if(rs.next()) {
                  community1 = new Community1(rs.getInt("communityno"),
                                       rs.getString("title"),
                                       rs.getString("content"),
                                       rs.getDate("writedate"),
                                       rs.getInt("viewcount"),
                                       rs.getInt("report"),
                                       rs.getString("countryno"),
                                       rs.getString("categoryno"),
                                       rs.getInt("userno"),
                                       rs.getString("status"),
                                       rs.getString("typeno"));
                                 

               
               }
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }finally {
               close(pstmt);
               close(rs);
            }
         

            return community1;
      }

         public int reportCommunity(Connection conn, int communityno) {
            
            PreparedStatement pstmt = null;
            PreparedStatement pstmt2 = null;
            PreparedStatement pstmt3 = null;
            
            ResultSet rs = null;
            ResultSet rs2 = null;
            
            Community1 community1 = new Community1();
            
            String category = "";
            
            int result = 0;
            
            String reportCate = "";
            
            String checkQuery = "SELECT CATEGORYNO FROM COMMUNITY WHERE COMMUNITYNO = ?";
            
            String query = "UPDATE COMMUNITY SET REPORT = COMMUNITY.REPORT + 1 WHERE COMMUNITYNO = ?";
            String query2 = "SELECT COMMUNITYNO, USERNO FROM COMMUNITY WHERE REPORT = 5";
            
            try {
               pstmt3 = conn.prepareStatement(checkQuery);
               pstmt3.setInt(1, communityno);
               rs2=pstmt3.executeQuery();
               while(rs2.next()) {
                  category = rs2.getString(1);
               }
               
               switch(category) {
                  case "C2" : reportCate = "1"; break;
                  case "C3" : reportCate = "2"; break;
                  case "C4" : reportCate = "3"; break;
               }
               
               pstmt = conn.prepareStatement(query);
               
               pstmt.setInt(1, communityno);

               result = pstmt.executeUpdate();
               
               pstmt2 = conn.prepareStatement(query2);
               rs = pstmt2.executeQuery();
               
               while(rs.next()) {
                  
                  Report report = new Report(rs.getInt("communityno"),reportCate,rs.getInt("userno"));
                  if(rs.getInt(1) == communityno) {
                     insertCommunityReport(conn, report);
                  }
               }

            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               close(pstmt);
            }
            
            
            return result;
         }

         private int insertCommunityReport(Connection conn, Report report) {
            
      PreparedStatement pstmt = null;

            
            int result = 0;
            
            String query = "INSERT INTO REPORT V LUES(SEQ_REPORT.NEXTVAL,?,DEFAULT,?,?)";
            
            try {
                  pstmt = conn.prepareStatement(query);
                  pstmt.setInt(1, report.getBoardNo());
                  pstmt.setString(2,report.getCategoryNo());
                  pstmt.setInt(3, report.getUserNo());
               
                  result += pstmt.executeUpdate();

            }catch (SQLException e) {
               e.printStackTrace();
            } finally {
               close(pstmt);
            }
            return result;
            
         }



         public int deleteComment(Connection conn, int commentNo) {
            PreparedStatement pstmt = null;
            int result = 0;
            
            String query = "DELETE FROM COMMENTS WHERE COMMENTNO = ?";
            
            try {
               pstmt = conn.prepareStatement(query);
               
               pstmt.setInt(1, commentNo);
               
               result = pstmt.executeUpdate();
            } catch (SQLException e) {
               e.printStackTrace();
            } finally {
               close(pstmt);
            }
            
            return result;
         }
         
         public ArrayList searchList(Connection conn, String selectbox, String searchbox) {
            //글 검색 기능
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            
            ArrayList list = new ArrayList();
            
            try {
               //제목으로 검색
               
               if(selectbox.equals("title")) {
                  String query ="SELECT * FROM CLIST WHERE TITLE LIKE ? AND CATEGORYNAME ='공지사항' AND STATUS = 'N'";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
                  
                  
                  //제목+내용으로 검색   
               }else if(selectbox.equals("tcontent")) {
                  String query ="SELECT * FROM  CLIST WHERE CONTENT LIKE ? OR TITLE LIKE ? AND CATEGORYNAME ='공지사항' AND STATUS ='N'";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
                  pstmt.setString(2, "%"+searchbox+"%");
                  
                  
                  //작성자
               }else if(selectbox.equals("content")) {
                  String query="SELECT * FROM CLIST WHERE CONTENT LIKE ? AND CATEGORYNAME ='공지사항' AND  STATUS = 'N'   ";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
               }else if(selectbox.equals("nation")) {
                  String query = "SELECT * FROM CLIST WHERE COUNTRY LIKE ? AND CATEGORYNAME ='공지사항' AND STATUS ='N'";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
               }
               
               rs = pstmt.executeQuery();
               while(rs.next()) {
                  Community c = new Community(rs.getInt("communityno"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDate("writedate"),
                        rs.getInt("viewcount"),
                        rs.getInt("report"),
                        rs.getString("country"),
                        rs.getString("categoryname"),
                        rs.getString("userid"),
                        rs.getString("status"));
                  list.add(c);
               }
            }catch(SQLException e) {
               e.printStackTrace();
            }finally {
               close(pstmt);
               close(rs);
            }
            return list;
            
         }

      public ArrayList freeSearchList(Connection conn, String selectbox, String searchbox) {
   
          //글 검색 기능
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            
            ArrayList list = new ArrayList();
            
            try {
               //제목으로 검색
               if(selectbox.equals("title")) {
                  String query ="SELECT * FROM CLIST WHERE TITLE LIKE ? AND CATEGORYNAME ='자유게시판' AND STATUS = 'N'";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
                  
                  
                  //제목+내용으로 검색   
               }else if(selectbox.equals("tcontent")) {
                  String query ="SELECT * FROM  CLIST WHERE CONTENT LIKE ?  TITLE LIKE ? AND CATEGORYNAME ='자유게시판' AND STATUS ='N'";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
                  pstmt.setString(2, "%"+searchbox+"%");
                  
                  
                  //작성자
               }else if(selectbox.equals("content")) {
                  String query="SELECT * FROM CLIST WHERE CONTENT LIKE ? AND CATEGORYNAME ='자유게시판' AND  STATUS = 'N'   ";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
               }else if(selectbox.equals("nation")) {
                  String query = "SELECT * FROM CLIST WHERE COUNTRY LIKE ? AND CATEGORYNAME ='자유게시판' AND STATUS ='N'";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
               }
               
               rs = pstmt.executeQuery();
               while(rs.next()) {
                  Community c = new Community(rs.getInt("communityno"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDate("writedate"),
                        rs.getInt("viewcount"),
                        rs.getInt("report"),
                        rs.getString("country"),
                        rs.getString("categoryname"),
                        rs.getString("userid"),
                        rs.getString("status"));
                  list.add(c);
               }
            }catch(SQLException e) {
               e.printStackTrace();
            }finally {
               close(pstmt);
               close(rs);
            }
            return list;
            
         }

      public ArrayList questionSearchList(Connection conn, String selectbox, String searchbox, String category) {
           PreparedStatement pstmt = null;
            ResultSet rs = null;
            
            ArrayList list = new ArrayList();
            
            try {
               //제목으로 검색
               if(selectbox.equals("title")) {
                  String query ="SELECT * FROM CLIST WHERE TITLE LIKE ? AND CATEGORYNAME ='질문게시판' AND STATUS = 'N'";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
                  
                  
                  //제목+내용으로 검색   
               }else if(selectbox.equals("tcontent")) {
                  String query ="SELECT * FROM  CLIST WHERE CONTENT LIKE ?  TITLE LIKE ? AND CATEGORYNAME ='질문게시판' AND STATUS ='N'";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
                  pstmt.setString(2, "%"+searchbox+"%");
                  
                  
                  //작성자
               }else if(selectbox.equals("content")) {
                  String query="SELECT * FROM CLIST WHERE CONTENT LIKE ? AND CATEGORYNAME ='질문게시판' AND  STATUS = 'N'   ";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
               }else if(selectbox.equals("nation")) {
                  String query = "SELECT * FROM CLIST WHERE COUNTRY LIKE ? AND CATEGORYNAME ='질문게시판' AND STATUS ='N'";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
               }
               
               rs = pstmt.executeQuery();
               while(rs.next()) {
                  Community c = new Community(rs.getInt("communityno"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDate("writedate"),
                        rs.getInt("viewcount"),
                        rs.getInt("report"),
                        rs.getString("country"),
                        rs.getString("categoryname"),
                        rs.getString("userid"),
                        rs.getString("status"));
                  list.add(c);
               }
            }catch(SQLException e) {
               e.printStackTrace();
            }finally {
               close(pstmt);
               close(rs);
            }
            return list;
            
      }

      public ArrayList marketSearchList(Connection conn, String selectbox, String searchbox, String category) {
          PreparedStatement pstmt = null;
            ResultSet rs = null;
            
            ArrayList list = new ArrayList();
            
            try {
               //제목으로 검색
               if(selectbox.equals("title")) {
                  String query ="SELECT * FROM CLIST WHERE TITLE LIKE ? AND CATEGORYNAME ='벼룩시장' AND STATUS = 'N'";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
                  
                  
                  //제목+내용으로 검색   
               }else if(selectbox.equals("tcontent")) {
                     String query ="SELECT * FROM  CLIST WHERE CONTENT LIKE ?  TITLE LIKE ? AND CATEGORYNAME ='벼룩시장' AND STATUS ='N'";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
                  pstmt.setString(2, "%"+searchbox+"%");
                  
                  
                  //작성자
               }else if(selectbox.equals("content")) {
                  String query="SELECT * FROM CLIST WHERE CONTENT LIKE ? AND CATEGORYNAME ='벼룩시장' AND  STATUS = 'N'   ";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
               }else if(selectbox.equals("nation")) {
                  String query = "SELECT * FROM CLIST WHERE COUNTRY LIKE ? AND CATEGORYNAME ='벼룩시장' AND STATUS ='N'";
                  pstmt = conn.prepareStatement(query);
                  pstmt.setString(1, "%"+searchbox+"%");
               }
               
               rs = pstmt.executeQuery();
               while(rs.next()) {
                  Community c = new Community(rs.getInt("communityno"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDate("writedate"),
                        rs.getInt("viewcount"),
                        rs.getInt("report"),
                        rs.getString("country"),
                        rs.getString("categoryname"),
                        rs.getString("userid"),
                        rs.getString("status"));
                  list.add(c);
               }
            }catch(SQLException e) {
               e.printStackTrace();
            }finally {
               close(pstmt);
               close(rs);
            }
            return list;
      }

   
}
