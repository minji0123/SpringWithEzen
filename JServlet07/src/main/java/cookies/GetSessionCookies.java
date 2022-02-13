package cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getsesscookies")
public class GetSessionCookies extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.printf("service() : /getcookies: METHOD(%s)\n", request.getMethod());
		
		response.setContentType("text/html;charset=UTF-8");
		
		String helloCookie = "none";
		
		Cookie[] cookies = request.getCookies();
		
		for(int cnt=0; cookies != null && cnt < cookies.length; cnt++) {
			String cookieName = cookies[cnt].getName();
			String cookieVal = cookies[cnt].getValue();
			System.out.printf("횟수: %d, 이름: %s, 값: %s\n", cnt, cookieName, URLDecoder.decode(cookieVal, "UTF-8"));
			if(cookieName.equals("helloSessCookie")) {
				helloCookie = URLDecoder.decode(cookieVal, "UTF-8");
				break;
			}
		}
		
		resHTML(response.getWriter(), helloCookie);
	}
	
	static void resHTML(PrintWriter out, String helloCookie) {
		out.print("<html><body>");
		out.print("<h1>Get 세션쿠키처리</h1>");
		out.print("<hr>");
		out.printf("<p>현재시간: %s</p>", new Date());
		out.printf("<p>쿠키값: %s</p>", helloCookie);
		out.print("</body><html>");
	}

}
