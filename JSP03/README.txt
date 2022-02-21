액션 태그

[나온이유]
html 이랑 java 코드가 섞여 있으니까 넘모 안깔끔하당
그래서 나온게 액션 태그이다.

[종류]
1. 인클루드 액션 태그
    - jsp 포함
    - <jsp:include>
    
2. 포워드 액션 태그
    - request dispatcher 포워드했었던거를 태그로 표현
    - <jsp:forward>
    
3. 유즈빈 액션 태그
    - 자바의 new 연산자를 대신하는 태그
    - 인자가 없는 생성자를 가져야 함 (디폴트 생성자)
    - <jsp:useBean>
    
4. Set 프로퍼티 액션 태그
    - 자바의 setter
    - 첫 글자는 소문자로
	- <jsp:setProperty>
	- 유즈빈의 id 와 set 의 name 은 같아야 한다.

5. Get 프로퍼티 액션 태그
	- 자바의 getter
	- 첫 글자는 소문자로
	- <jsp:getProperty>



login, loginForm 은 기존 방법
login2, loginForm2 는 포워드 액션 태그
login3, loginForm3 는 포워드 액션 태그+메세지 전달

member, memberForm 는 기존 방법
member2, memberForm2 는 유즈빈 액션 태그
member3, memberForm3 는 Set 프로퍼티 액션 태그
member4, memberForm4 는 Set 프로퍼티 액션 태그 + param
member5, memberForm5 는 Set 프로퍼티 액션 태그 + param 생략
member6, memberForm6 는 Set 프로퍼티 액션 태그 + *
member7, memberForm7 는 Get 프로퍼티 액션 태그
    