CREATE TABLE Member (            
   userNo   NUMBER   NOT NULL ,  
   userId   VARCHAR(10)   NOT NULL ,  
   userPw   VARCHAR(20)   NOT NULL ,  
   userName   VARCHAR(20)   NOT NULL ,  
   userBirth   DATE   NOT NULL  , 
   phone   VARCHAR(20)   NOT NULL  , 
   email   VARCHAR(30)   NOT NULL ,  
   grade   NUMBER   NOT NULL   ,
   sanction   VARCHAR2(1)   DEFAULT 'N' NOT NULL ,
   status   VARCHAR2(1)   DEFAULT 'N' NOT NULL   ,
   gender   VARCHAR2(1)   NOT NULL   
   );         
            
CREATE TABLE Community (            
   communityNo   NUMBER   NOT NULL ,  
   title   VARCHAR(100)   NOT NULL  , 
   content   VARCHAR2(4000)   NULL   ,
   writeDate   DATE   DEFAULT SYSDATE NOT NULL ,
   viewCount   NUMBER   NOT NULL   ,
   report   NUMBER     DEFAULT NULL NULL ,
   countryNo   VARCHAR(5)   NOT NULL   ,
   categoryNo   VARCHAR(5)   NOT NULL ,  
   userNo   NUMBER   NOT NULL   
   );         
            
CREATE TABLE Comments (            
   commentNo   NUMBER   NOT NULL   ,
   content   VARCHAR2(1000)   NOT NULL   ,
   writeDate   DATE  DEFAULT SYSDATE NOT NULL   ,
   report   NUMBER   DEFAULT NULL NULL   ,
   communityNo   NUMBER   NOT NULL   ,
   userNo   NUMBER   NOT NULL   
   );         
            
CREATE TABLE JobSearch (            
   jobNo   NUMBER   NOT NULL ,  
   job   VARCHAR(50)   NOT NULL   ,
   period   VARCHAR(10)   NOT NULL   ,
   logoImg   VARCHAR(1000)   NULL   ,
   recruitment   NUMBER   NOT NULL   ,
   gender   VARCHAR2(1)   NOT NULL   ,
   age   VARCHAR(10)   NOT NULL   ,
   address   VARCHAR(100)   NOT NULL ,  
   pay   VARCHAR(50)   NOT NULL   ,
   dueDate   DATE   NOT NULL   ,
   workTime   DATE   NOT NULL   ,
   workDay   VARCHAR(10)   NOT NULL ,  
   title   VARCHAR(100)   NOT NULL   ,
   content   VARCHAR2(4000)   NULL   ,
   jobReport   NUMBER   DEFAULT NULL  NULL  ,
   writeDate   DATE   DEFAULT SYSDATE  NOT NULL  ,
   countryNo   VARCHAR(5)   NOT NULL   ,
   userNo   NUMBER   NOT NULL   
   );         
            
CREATE TABLE Home (            
   houseNo   NUMBER   NOT NULL   ,
   type   VARCHAR(50)   NOT NULL   ,
   period   VARCHAR(10)   NOT NULL   ,
   fee   VARCHAR(50)   NOT NULL   ,
   title   VARCHAR(100)   NOT NULL   ,
   content   VARCHAR2(4000)   NOT NULL  , 
   report   NUMBER  DEFAULT NULL NULL   ,
   address   VARCHAR2(1000)   NOT NULL   ,
   writeDate   DATE  DEFAULT SYSDATE NOT NULL   ,
   countryNo   VARCHAR(5)   NOT NULL   ,
   userNo   NUMBER   NOT NULL   
   );         
            
CREATE TABLE HomeReview (            
   reviewNo   NUMBER   NOT NULL   ,
   img   VARCHAR2(1000)   NULL   ,
   content   VARCHAR2(1000)   NOT NULL   ,
   writeDate   DATE    DEFAULT SYSDATE NOT NULL  ,
   report   NUMBER   DEFAULT NULL NULL  ,
   houseNo   NUMBER   NOT NULL   ,
   score   NUMBER   NULL   ,
   userNo   NUMBER   NOT NULL   
   );         
            
CREATE TABLE SafetyInfo (            
   safetyInfoNo   NUMBER   NOT NULL   ,
   title   VARCHAR(100)   NOT NULL   ,
   content   VARCHAR2(4000)   NULL   ,
   viewCount   NUMBER   NOT NULL   ,
   writeDate   DATE   DEFAULT SYSDATE NOT NULL   ,
   Img   VARCHAR2(1000)   NULL   ,
   countryNo   VARCHAR(5)   NOT NULL   
   );         
            
CREATE TABLE HomeEtc (            
   houseNo   NUMBER   NOT NULL   ,
   essentialItem   VARCHAR2(1)   NOT NULL   ,
   wifi   VARCHAR2(1)   NOT NULL   ,
   television   VARCHAR2(1)   NOT NULL   ,
   heater   VARCHAR2(1)   NOT NULL   ,
   airconditional   VARCHAR2(1)   NOT NULL   ,
   livingroom   VARCHAR2(1)   NOT NULL   ,
   diningroom   VARCHAR2(1)   NOT NULL   ,
   bathroom   VARCHAR2(1)   NOT NULL   ,
   pet   VARCHAR2(1)   NOT NULL   
   );         
            
CREATE TABLE Heart (            
   heartNo   NUMBER   NOT NULL   ,
   jobNo   NUMBER   NOT NULL   ,
   userNo   NUMBER   NOT NULL   
   );         
            
CREATE TABLE HomeReservation (            
   reservationNo   NUMBER   NOT NULL,   
   houseNo   NUMBER   NOT NULL   ,
   userNo   NUMBER   NOT NULL   
   );         
            
CREATE TABLE JobApplication (            
   jobApplyNo   NUMBER   NOT NULL   ,
   jobNo   NUMBER   NOT NULL   ,
   userNo   NUMBER   NOT NULL   
   );         
            
CREATE TABLE Report (            
   reportNo   NUMBER   NOT NULL   ,
   boardNo   NUMBER   NOT NULL   ,
   process   VARCHAR(20)   DEFAULT NULL NULL   ,
   categoryNo   VARCHAR(5)   NOT NULL   ,
   userNo   NUMBER   NOT NULL   
   );         
            
CREATE TABLE JobReview (            
   reviewNo   NUMBER   NOT NULL   ,
   content   VARCHAR2(4000)   NULL   ,
   writeDate   DATE DEFAULT SYSDATE  NOT NULL   ,
   report   NUMBER   NULL   ,
   jobNo   NUMBER   NOT NULL   ,
   score   NUMBER   NULL   ,
   userNo   NUMBER   NOT NULL   
   );         
            
CREATE TABLE HomePhoto (            
   imgNo   NUMBER   NOT NULL,   
   houseNo   NUMBER   NOT NULL   ,
   img   VARCHAR2(1000)   NOT NULL   
   );         
            
CREATE TABLE CommunityPhoto (            
   imgNo   NUMBER   NOT NULL   ,
   communityNo   NUMBER   NOT NULL   ,
   img   VARCHAR2(1000)   NULL   
   );         
            
CREATE TABLE Country (            
   countryNo   VARCHAR(5)   NOT NULL   ,
   country   VARCHAR(20)   NOT NULL   
   );         
            
CREATE TABLE ReportCategory (            
   categoryNo   VARCHAR(5)   NOT NULL   ,
   categoryName   VARCHAR(20)   NOT NULL   
   );         
            
CREATE TABLE CommunityCategory (            
   categoryNo   VARCHAR(5)   NOT NULL ,
   categoryName   VARCHAR(20)   NOT NULL  
   );         
            
CREATE TABLE Resume (            
   jobApplyNo   NUMBER   NOT NULL   ,
   resumeImg   VARCHAR2(1000)   NOT NULL   
   );         
            
ALTER TABLE Member ADD CONSTRAINT PK_MEMBER PRIMARY KEY (            
   userNo         
   );         
            
ALTER TABLE Community ADD CONSTRAINT PK_COMMUNITY PRIMARY KEY (            
   communityNo         
   );         
            
ALTER TABLE Comments ADD CONSTRAINT PK_COMMENT PRIMARY KEY (            
   commentNo         
   );         
            
ALTER TABLE JobSearch ADD CONSTRAINT PK_JOBSEARCH PRIMARY KEY (            
   jobNo         
   );         
            
ALTER TABLE Home ADD CONSTRAINT PK_HOME PRIMARY KEY (            
   houseNo         
   );         
            
ALTER TABLE HomeReview ADD CONSTRAINT PK_HOMEREVIEW PRIMARY KEY (            
   reviewNo         
   );         
            
ALTER TABLE SafetyInfo ADD CONSTRAINT PK_SAFETYINFO PRIMARY KEY (            
   safetyInfoNo         
   );         
            
ALTER TABLE HomeEtc ADD CONSTRAINT PK_HOMEETC PRIMARY KEY (            
   houseNo         
   );         
            
ALTER TABLE Heart ADD CONSTRAINT PK_HEART PRIMARY KEY (            
   heartNo         
   );         
            
ALTER TABLE HomeReservation ADD CONSTRAINT PK_HOMERESERVATION PRIMARY KEY (            
   reservationNo   ,      
   houseNo         
   );         
            
ALTER TABLE JobApplication ADD CONSTRAINT PK_JOBAPPLICATION PRIMARY KEY (            
   jobApplyNo         
   );         
            
ALTER TABLE Report ADD CONSTRAINT PK_REPORT PRIMARY KEY (            
   reportNo         
   );         
            
ALTER TABLE JobReview ADD CONSTRAINT PK_JOBREVIEW PRIMARY KEY (            
   reviewNo         
   );         
            
ALTER TABLE HomePhoto ADD CONSTRAINT PK_HOMEPHOTO PRIMARY KEY (            
   imgNo        , 
   houseNo         
   );         
            
ALTER TABLE CommunityPhoto ADD CONSTRAINT PK_COMMUNITYPHOTO PRIMARY KEY (            
   imgNo   ,      
   communityNo         
   );         
            
ALTER TABLE Country ADD CONSTRAINT PK_COUNTRY PRIMARY KEY (            
   countryNo         
   );         
            
ALTER TABLE ReportCategory ADD CONSTRAINT PK_REPORTCATEGORY PRIMARY KEY (            
   categoryNo         
   );         
            
ALTER TABLE CommunityCategory ADD CONSTRAINT PK_COMMUNITYCATEGORY PRIMARY KEY (            
   categoryNo         
   );         
            
ALTER TABLE Resume ADD CONSTRAINT PK_RESUME PRIMARY KEY (            
   jobApplyNo         
   );         
            
ALTER TABLE HomeEtc ADD CONSTRAINT FK_Home_TO_HomeEtc_1 FOREIGN KEY (            
   houseNo         
   )        
REFERENCES Home (            
   houseNo         
   );         
            
ALTER TABLE HomeReservation ADD CONSTRAINT FK_Home_TO_HomeReservation_1 FOREIGN KEY (            
   houseNo         
   )      
REFERENCES Home (            
   houseNo         
   );         
            
ALTER TABLE HomePhoto ADD CONSTRAINT FK_Home_TO_HomePhoto_1 FOREIGN KEY (            
   houseNo         
   )         
REFERENCES Home (            
   houseNo         
   );         
            
ALTER TABLE CommunityPhoto ADD CONSTRAINT FK_Community_TO_CommunityImg FOREIGN KEY (            
   communityNo         
   )        
REFERENCES Community (            
   communityNo         
   );         
            
ALTER TABLE Resume ADD CONSTRAINT FK_JobApplication_TO_Resume_1 FOREIGN KEY (            
   jobApplyNo         
   )        
REFERENCES JobApplication (            
   jobApplyNo         
);