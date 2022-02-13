/*
 * [세션]
 *  request.getSession()
 *    - default : 기존에 세션이 존재하면 그 세션을 반환하고 없으면 새로운 세션을 생성해서 반환
 *  request.getSession(boolean create)
 *    - true : 기존에 세션이 존재하면 그 세션을 반환하고 없으면 새로운 세션을 생성해서 반환
 *    - false : 기존에 세션이 존재하면 그 세션을 반환하고 없으면 null을 반환
 *    
 *  세션 유효 시간 : 기본 30분  
 */
package sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionlogin")
public class SessionLogin extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.printf("SessionLogin: /sessionlogin: (%s)\n", request.getMethod());
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession sessLogin = request.getSession();
		sessLogin.setMaxInactiveInterval(60); // 유효시간 60초
		
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		System.out.printf("[SessionLogin], userid: %s, password: %s\n", userid, userpw);
		
		int login = -1;
		
		if(sessLogin.isNew()) {
			if(userid != null && userid.isEmpty() != true) {
				sessLogin.setAttribute("userid", userid);
				login = 1;
			}
		}
		else {
			String uid = (String)sessLogin.getAttribute("userid");
			if(uid != null && uid.equals(userid)) {
				login = 0;
			}
		}
		
		reshtml(response.getWriter(), login, userid, sessLogin);
		
		if(login < 0) {
			String uid = (String)sessLogin.getAttribute("userid");
			if(uid != null) {
				System.out.printf("[SessionLogin] 로그인된유저(%s), 새로운유저(%s)\n", uid, userid);
				return;
			}

			System.out.printf("[SessionLogin] 세션삭제: userid(%s), password(%s)\n", userid, userpw);
			sessLogin.invalidate(); // 세션 삭제
		}
	}
	
	static void reshtml(PrintWriter out, int login, String userid, HttpSession sess) {
		out.print("<html><body>");
		out.print("<h1>세션으로 로그인 처리</h1>");
		out.print("<hr>");
		
		if(sess != null) {
			out.printf("<p>세션 아이디: %s</p>", sess.getId());
			out.printf("<p>세션 유효시간: %d초</p>", sess.getMaxInactiveInterval());
			out.printf("<p>세션 생성시간: %s</p>", new Date(sess.getCreationTime()));
			out.printf("<p>세션 최근접속: %s</p>", new Date(sess.getLastAccessedTime()));
			out.printf("<p>세션 다시접속: %b</p>", sess.isNew());
			out.print("<hr>");
		}
		
		if(login == 1) { //  로그인 성공
			out.print("<p>로그인 성공</p>");
			out.printf("<p> %s 님 환영합니다.</p>", userid);
		}
		else if(login == 0)  { // 이미 로그인
			out.print("<p>이미 로그인이 되어 있습니다.</p>");
			out.printf("<p> %s 님 환영합니다.</p>", userid);
		}
		else {
			out.print("<p>세션이 끝났습니다.</p>");
			out.print("<a href='sessionlogin.html'>다시 로그인</a>");
		}
		
		out.print("</body></html>");
	}

}
