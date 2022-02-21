<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="members.*, java.util.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="memb" class="w" scope="page"/>
<!-- param 생략하는 경우: bean 속성과 getParameter 의 모든게 같을 때-->
<jsp:setProperty name="member" property="*"/>

<%
p

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
			
<%
			p

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