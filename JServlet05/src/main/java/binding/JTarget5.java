package binding;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JTarget5")
public class JTarget5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JTarget5() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String msgx = (String)request.getAttribute("msgx");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>dispatch_request.setAttribute</h1>");
		out.println("<p>jstarter5 -> jtarget5 </p>");
		out.println("<p>메세지: "+msgx+"</p>");
		out.println("</body></html>");
	}

}
