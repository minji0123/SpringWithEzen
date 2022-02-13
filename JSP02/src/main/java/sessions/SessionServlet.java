package sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionservlet")
public class SessionServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		/*
		 * 세션이 있으면 있는 세션을 쓰고 없으면 새로 생성
		 * 페이지에서 자료를 공유할 수 있다.
		 */
		HttpSession session = request.getSession();
		session.setAttribute("name", "아카데미");
		
		String name = (String)session.getAttribute("name");
		String tel = (String)session.getAttribute("tel");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1>세션 서블릿 페이지</h1>");
		out.print("<h3>세션에 'name' 속성에 값을 넣어서 전달</h1>");
		out.print("<hr>");
		out.printf("<p>이름: %s</p>", name);
		out.printf("<p>전화번호: %s</p>", tel);
		out.print("<a href='sessions/session02.jsp'>세션 페이지 2로 이동</a>");
		out.print("</body></html>");
	}

}
