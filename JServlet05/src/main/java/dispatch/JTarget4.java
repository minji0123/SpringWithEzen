package dispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JTarget4")
public class JTarget4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JTarget4() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String msg = request.getParameter("msg");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>dispatch</h1>");
		out.println("<p>jstarter4 -> jtarget4 </p>");
		out.println("<p>메세지: "+msg+"</p>");
		out.println("</body></html>");
	}

}
