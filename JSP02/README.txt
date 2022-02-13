[JSP Scripting Element]

(개요)
1. 자바 코드를 JSP 페이지에서 사용
2. 동적으로 기능을 처리
   
(구성요소)
1. 선언문: 변수나 메서드를 선언
2. 스크립트릿(Scriptlet): 자바 코드를 작성
3. 표현식: 변수의 값을 출력   
   
(선언문)
1. 멤버 변수나 멤버 메서드를 선언
2. <%! 멤버변수 %>
2. <%! 멤버메서드 %>

(스크립트릿)
1. 자바 코드를 작성
2. <% ... %>

(표현식) 
1. 변수 또는 표현식의 값을 출력
2. <%= ... %>  

(requests)
1. 요청 객체를 통해서 페이지 이동시 자료 전달 방법 예제
2. RequestDispatcher Object
   RequestDispatcher dispatcher = request.getRequestDispatcher("request04.jsp");
   dispatcher.forward(request, response);

(sessions)
1. 세션 객체를 통해서 페이지에서 자료 공유
2. HttpSession session

(applications)
1. 애플리케이션 객체를 통해서 페이지에서 자료 공유
2. SevletContext application

(예외처리)
1. 페이지에서 예외가 발생했을 때 사용자에게 보여줄 페이지 지정
2. 처리 페이지의 디렉티브 태그에 errorPage="예외페이지"  
3. 예제: webapp/exceptions/calc.jsp 
	<%@ page language="java" contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" errorPage="calcexception.jsp" %>
4. 예외페이지의 디렉티브 태그에 isErrorPage="true" 
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8" isErrorPage="true" %>

(에러처리)
1. HTTP 에러가 발생했을 때 사용자에게 보여줄 페이지 지정
2. webapp/WEB-INF/web.xml에 에러 처리 페이지를 지정
3. web.xml
   <error-page>
   		<error-code>404</error-code>
   		<location>/errors/error404.jsp</location>
   </error-page>
