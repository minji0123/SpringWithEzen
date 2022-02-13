<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="members.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");
	
	MemberDAO memberDAO = new MemberDAO();
	boolean membered = memberDAO.isMember(userid, userpw);
	MemberVO member = memberDAO.getMember(userid);
	
	String logineduid = "none";
	boolean logined = false;
	
	if(membered) {
		logineduid = (String)session.getAttribute("userid");
		if(logineduid != null) {
			session.removeAttribute("userid");
			logined = true;
		}
		session.setAttribute("userid", userid);
	}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 로그인</title>
</head>
<body>
	<h1>멤버 로그인</h1>
	<hr>
<%
if(membered) {
	if(logined != true) {
%>	
	<p><%=member.getMname()%>님 환영합니다.</p>
	<p>성공적으로 로그인이 되었습니다.</p>
	<a href="membersvc.jsp">멤버 서비스</a>
<%
	}
	else {
%>
	<p>이미 다른 아이디<%=logineduid%>로 로그인이 되었습니다.</p>
	<a href="membersvc.jsp">멤버 서비스</a>
<%		
	}
}
else {
%>	
	<p><%=userid%>는 잘못되었습니다.</p>
	<p>아이디나 패스워드를 다시 확인해 보세요.</p>
	<a href="memberlogin.html">다시 로그인 하세요.</a>
<%
}
%>
</body>
</html>