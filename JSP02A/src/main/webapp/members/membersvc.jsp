<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="members.*"
    pageEncoding="UTF-8"%>
<%
	String uid = (String)session.getAttribute("userid");
	if(uid == null) {
		response.sendRedirect("memberlogin.html");
		return;
	}

	request.setCharacterEncoding("UTF-8");
	String svcid = request.getParameter("svcid");
	
	if(svcid == null) {
		response.sendRedirect("memberview.jsp");
		return;
	}
	
	if(svcid.equals("memberreg")) {	// 멤버가입
		String mid = (String)request.getParameter("mid");
		String mname = (String)request.getParameter("mname");
		String pwd = (String)request.getParameter("pwd");
		String email = (String)request.getParameter("email");
		System.out.printf("[membersvc] memberreg: (%s)(%s)(%s)(%s)%n", mid, mname, pwd, email);
		
		if(mid != null && mid.isEmpty() != true) {
			MemberDAO dao = new MemberDAO();
			MemberVO memberVO = new MemberVO(mid, mname, pwd, email);
			dao.insertMember(memberVO);
		}
	}
	else if(svcid.equals("memberupdate")) { // 멤버수정
		String mid = (String)request.getParameter("mid");
		String mname = (String)request.getParameter("mname");
		String pwd = (String)request.getParameter("pwd");
		String email = (String)request.getParameter("email");
		System.out.printf("[membersvc] memberedit: (%s)(%s)(%s)(%s)%n", mid, mname, pwd, email);
		
		if(mid != null && mid.isEmpty() != true) {
			MemberDAO dao = new MemberDAO();
			MemberVO memberVO = new MemberVO(mid, mname, pwd, email);
			dao.updateMember(memberVO);
		}
	}
	else if(svcid.equals("memberedit")) { // 멤버수정
		String mid = (String)request.getParameter("mid");
		System.out.printf("[membersvc] memberedit: mid(%s)%n", mid);
		
		if(mid != null && mid.isEmpty() != true) {
			request.setAttribute("mid", mid);
			RequestDispatcher dispatcher = request.getRequestDispatcher("memberedit.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}
	else if(svcid.equals("memberdel")) { // 멤버삭제
		String mid = (String)request.getParameter("mid");
		System.out.printf("[membersvc] memberdel: mid(%s)%n", mid);
		
		if(mid != null && mid.isEmpty() != true) {
			MemberDAO dao = new MemberDAO();
			dao.deleteMember(mid);
		}
	}
	else if(svcid.equals("memberdetail")) { // 멤버상세보기
		String mid = (String)request.getParameter("mid");
		System.out.printf("[membersvc] memberdetail: mid(%s)%n", mid);
		
		if(mid != null && mid.isEmpty() != true) {
			MemberDAO dao = new MemberDAO();
			MemberVO member = dao.getMember(mid);
			request.setAttribute("member", member);
			RequestDispatcher dispatcher = request.getRequestDispatcher("memberdetail.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}
	
	response.sendRedirect("memberview.jsp");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멥버 서비스</title>
</head>
<body>
	<h1>멤버 서비스</h1>
	<h3>멤버에게 제공하는 서비스 홈 페이지</h3>
	<hr>
	<p>서비스 종류: <%=svcid%></p>
</body>
</html>