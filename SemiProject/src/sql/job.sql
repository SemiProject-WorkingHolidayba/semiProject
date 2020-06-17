---------------------------------------------------------------------------------------------------------------------
-- JOBSEARCH 게시물 리스트
---------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE VIEW JSLIST 
AS 
SELECT ROWNUM RNUM, JOBNO, JOB, PERIOD, LOGOIMG, RECRUITMENT, GENDER, AGE, ADDRESS, PAY, DUEDATE, WORKTIME, WORKDAY, TITLE, CONTENT, JOBREPORT, WRITEDATE, COUNTRY, USERID, CHANGENAME, FILEPATH, CONAME
FROM (SELECT JOBNO, JOB, PERIOD, LOGOIMG, RECRUITMENT, J.GENDER, AGE, ADDRESS, PAY, DUEDATE, WORKTIME, WORKDAY, TITLE, CONTENT, JOBREPORT, WRITEDATE, COUNTRY, USERID, CHANGENAME, FILEPATH, CONAME
      FROM JOBSEARCH J
      JOIN MEMBER M ON(J.USERNO = M.USERNO)
      JOIN COUNTRY C ON(J.COUNTRYNO = C.COUNTRYNO)
      ORDER BY JOBNO DESC);

      
drop view jslist;
      
-----------------------------------------------------------------------------------------------------------------------
-- JOBSEARCH JOBNO SEQUENCE
-----------------------------------------------------------------------------------------------------------------------
CREATE SEQUENCE SEQ_JOBNO
start with 2;

-----------------------------------------------------------------------------------------------------------------------
-- JOBSEARCH 페이징 쿼리
-----------------------------------------------------------------------------------------------------------------------
SELECT *
FROM (SELECT ROWNUM RNUM1, J.* FROM JSLIST J)
WHERE RNUM1 BETWEEN 1 AND 10;

-----------------------------------------------------------------------------------------------------------------------
-- JOBSEARCH에 LOGOIMG > CHANGENAME추가
-----------------------------------------------------------------------------------------------------------------------
ALTER TABLE JOBSEARCH ADD(CHANGENAME VARCHAR2(255));
COMMIT;

-----------------------------------------------------------------------------------------------------------------------
-- JOBSEARCH에 LOGOIMG > FILEPATH추가
-----------------------------------------------------------------------------------------------------------------------
ALTER TABLE JOBSEARCH ADD(FILEPATH VARCHAR2(1000));
COMMIT;

-----------------------------------------------------------------------------------------------------------------------
-- JOBSEARCH에 CONAME(회사명)추가
-----------------------------------------------------------------------------------------------------------------------
ALTER TABLE JOBSEARCH ADD(CONAME VARCHAR2(200));
COMMIT;

-----------------------------------------------------------------------------------------------------------------------
-- JOBAPPLICATION에 구직신청시간(JOBAPPLYDATE 추가)
-----------------------------------------------------------------------------------------------------------------------
ALTER TABLE JOBAPPLICATION ADD(JOBAPPLYDATE DATE);