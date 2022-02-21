[EBooks]

1. 기본 JSP로 구현

---------------------------------------------------------------------------  
[15차] 통합구현 평가시험

<문제1> 다음과 같은 연계 모듈 환경을 구성하고 개발 하시오. (50점)
Oracle을 사용하여 다음과 같이 테이블을 구성하시오. (SQL DDL문 제시)
테이블명 : EBOOK (25점)
테이블정의서 (25점)
  번호 : EB_SERIAL, 숫자, PRIMARY KEY, AUTO INCREMENT, NOT NULL
  제목 : EB_TITLE,  문자열(50자리)
  저자 : EB_AUTHOR, 문자열(50자리)
  가격 : EB_PRICE,  숫자
  수량 : EB_QTY,    숫자
  
<문제2> 위 문제1을 활용하여 다음의 내용을 웹표현 기술을 활용하여 구현 하고 데이터 연계를 할 수 있는 모듈을 구현 하시오. 
		구현된 코드를 제시하고 처리 결과 화면을 캡처하여 첨부하시오.
  - 도서정보 목록 조회(10점)
  - 도서정보 목록 조회에서 등록, 수정, 삭제 메뉴를 표현하고 클릭하면 아래의 화면으로 이동한다.(10점)
  - 도서정보 등록 화면(10점)
  - 도서정보 수정 화면(10점)
  - 도서정보 삭제 화면(10점)  
  
---------------------------------------------------------------------------  
CREATE TABLE EBOOK
(
	EB_SERIAL	NUMBER(5) PRIMARY KEY,
	EB_TITLE	VARCHAR2(50),
	EB_AUTHOR	VARCHAR2(50),
	EB_PRICE	NUMBER(10),
	EB_QTY		NUMBER(10)
);

DROP SEQUENCE EBOOK_SEQUENCE;

CREATE SEQUENCE EBOOK_SEQUENCE
	INCREMENT BY 1	-- 증가값(기본값 1)
	START WITH 1	-- 시작값(시작값 1)
	MAXVALUE 99999	-- 최대값
	MINVALUE 1		-- 최소값
	CYCLE			-- 최대값에 도달했을 때 시작값에서 다시 시작할 것인지 유무
	CACHE 20;		-- 생성할 번호를 메모리에 미리 할당해 놓은 수를 지정할지 유무(기본값은 20)

-- 발행된 현재 번호 조회
SELECT EBOOK_SEQUENCE.currval FROM dual;

-- 다음 번호 발행
SELECT EBOOK_SEQUENCE.nextval FROM dual;


-- EBOOK에 자동 순번을 부여하여 자료 추가	
INSERT INTO EBOOK (EB_SERIAL, EB_TITLE)
    VALUES(EBOOK_SEQUENCE.nextval, '전자책');
    
-- EBOOK 조회    
SELECT * FROM EBOOK;    

-- EBOOK 순번키 조회
SELECT eb_serial FROM ebook WHERE eb_serial = 4;    

SELECT count(*) FROM ebook WHERE eb_serial = 1;
SELECT count(*) FROM ebook WHERE eb_serial = 4;

SELECT decode(count(*), 0, 'false', 'true') 
    FROM ebook
    WHERE eb_serial = 1;
	
SELECT decode(count(*), 0, 'false', 'true') AS booked
    FROM ebook
    WHERE eb_serial = 1;

---------------------------------------------------------------------------  
서비스 실행 : 	
http://localhost:8090/EBooks/ebooks/ebooksvc.jsp

