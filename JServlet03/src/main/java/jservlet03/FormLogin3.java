package jservlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormLogin3")
public class FormLogin3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGet");
		requestProcess(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doPost");
		requestProcess(request, response);
	}

	protected void requestProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("requestProcess");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userAd = request.getParameter("useraddress");
		
		if (userId.length() != 0 && userId != null && userPw.length() != 0 && userPw != null ) {
			sendResponseFormat(response.getWriter(),userId, userAd);
		} else {
			invalidLogin(response.getWriter());
		}
		
	}
	
	static void invalidLogin(PrintWriter out) {
		StringBuffer html = new StringBuffer();
		html.append("<html><body>");
		html.append("<h3>아이디 또는 비번이 잘못되었습니다.</h3>");
		html.append("<a href='http://localhost:8080/JServlet03/login3.html'>로그인 화면으로 이동</a>");
		html.append("</html></body>");
		out.print(html);
	}

	static void sendResponseFormat(PrintWriter out, String userId, String userAd) {
		String login = String.format("<h2>로그인성공</h2><hr/> <p>%s 님 환영합니다.</p>",userId);
		String info = String.format("<p>주소: %s</p>",userAd);
		String body = String.format("<body> %s <hr/> %s </body>", login, info);
		String html = String.format("<html>%s</html>",body);

		out.print(html);
	}
}
