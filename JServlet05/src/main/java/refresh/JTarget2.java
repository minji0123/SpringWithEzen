package refresh;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JTarget2")
public class JTarget2 extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Refresh</h1>");
		out.println("<p>jstarter2 -> jtarget2 </p>");
		out.println("</body></html>");
	}

}
