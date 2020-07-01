package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

   @Override
   public File rename(File originFile) {
      long currentTime = System.currentTimeMillis();
      // 사용중인 컴퓨터의 현재 시간을 long형으로 바꿔줌
      
      SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
      int ranNum = (int)(Math.random()*100000);
      
      // 확장자 명 가져오기
      String name = originFile.getName();   // 사용자가 올린 원본 파일명
      String ext = null;   // 확장자 담는 변수

      int dot = name.lastIndexOf(".");   
      
      if(dot != -1) {
         // dot 포함해서 확장자 추출(ext)
         ext = name.substring(dot);
      }else {
         // 확장자가 없는 경우
         ext = "";
      }
      
      // 새로운 이름으로 SimpleDateFormat, 랜덤 수, ext(확장자)를 사용
      String fileName = ft.format(new Date(currentTime)) + ranNum + ext;
      File newfile = new File(originFile.getParent(), fileName);
      
      return newfile;
   }

}





