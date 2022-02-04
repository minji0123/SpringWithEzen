package jservlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormLogin")
public class FormLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userAd = request.getParameter("useraddress");
		
		sendResponseFormat(response.getWriter(),userId, userAd);
	}

	static void sendResponseFormat(PrintWriter out, String userId, String userAd) {
		String login = String.format("<h2>로그인성공</h2><hr/> <p>%s 님 환영합니다.</p>",userId);
		String info = String.format("<p>주소: %s</p>",userAd);
		String body = String.format("<body> %s <hr/> %s </body>", login, info);
		String html = String.format("<html>%s</html>",body);

		
		out.print(html);
	}
}
