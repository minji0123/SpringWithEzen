package jservlet02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginP")
public class LoginP extends HttpServlet {

	private static final long serialVersionUID = 1L;
       

    public LoginP() {
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("loginPost init!");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginPost doPost");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		System.out.println("userId : " + userId);
		System.out.println("userPw : " + userPw);
		
		sendResponseFormat(response.getWriter(), userId, userPw);
	}

	static void sendResponseFormat(PrintWriter out, String userId, String userPw) {
		String html = String.format("<html><body><h2>로그인성공!</h2><hr />"
				+ "<p>아이디: %s</p><p>비밀번호: %s</p></body></html>",userId,userPw);
		out.print(html);
	}
}
