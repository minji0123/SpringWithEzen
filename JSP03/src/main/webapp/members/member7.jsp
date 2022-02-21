<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="members.*, java.util.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!--빈 생성-->
<jsp:useBean id="member" class="members.TodoVO" scope="page"/>

<!--빈에 값 주입-->
<jsp:setProperty name="member" property="*"/>

<%
TodoDAO dao = new TodoDAO();
	dao.insertMember(member);
	
	List<TodoVO> members = dao.getMembers();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>맴버 등록 및 조회</title>
</head>
<body>
	<h1>멤버 등록 및 조회</h1>
	<hr>
	<table>
		<tr bgcolor="88aacc">
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>등록일자</td>
		</tr>
		<tr>
		<!--빈에서 값 참조-->
			<td><jsp:getProperty name="member" property="mid"/></td>
			<td><jsp:getProperty name="member" property="mname"/></td>
			<td><jsp:getProperty name="member" property="pwd"/></td>
			<td><jsp:getProperty name="member" property="email"/></td>
			<td><jsp:getProperty name="member" property="regdate"/></td>
		</tr>
	</table>
	
<h1>멤버 확인</h1>
	<hr>
	<table>
		<tr bgcolor="88aacc">
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>등록일자</td>
		</tr>
<%
for (int row = 0; row < members.size(); row++){
		TodoVO mem = (TodoVO)members.get(row);
%>

		<tr>
			<td><%=mem.getMid() %></td>
			<td><%=mem.getMname() %></td>
			<td><%=mem.getPwd() %></td>
			<td><%=mem.getEmail() %></td>
			<td><%=mem.getRegdate() %></td>
		</tr>
<%
	}
%>
			
</table>
</body>
</html>