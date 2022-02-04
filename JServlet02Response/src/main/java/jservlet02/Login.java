package jservlet02;
// get 방식으로 웹 <-> server
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("login init!");
	}

	public void destroy() {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login doGet");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		System.out.println("userId : " + userId);
		System.out.println("userPw : " + userPw);
		
		sendResponse(response.getWriter(), userId, userPw);
	}
	
	static void sendResponse(PrintWriter out, String userId, String userPw) {
		String html = "<html>";
		html += "<body>";
		html += "<p>로그인 성공</p>";
		html += "<hr />";
		
		html += "<p>아이디: "+userId + "</p>";
		html += "<p>비밀번호: "+userPw + "</p>";
		
		html += "</body>";
		html += "</html>";
		
		out.print(html);
	}
}
