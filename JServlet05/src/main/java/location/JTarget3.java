package location;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JTarget3")
public class JTarget3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JTarget3() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>location</h1>");
		out.println("<p>jstarter3 -> jtarget3 </p>");
		out.println("</body></html>");
	}

}
