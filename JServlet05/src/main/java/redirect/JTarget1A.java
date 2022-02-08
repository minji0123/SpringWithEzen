package redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JTarget1A")
public class JTarget1A extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JTarget1A() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		
		PrintWriter out = response.getWriter();
		String msg= request.getParameter("msg");
		
		out.println("<html><body>");
		out.println("<h1>sendRedirect(\'JTarget1A\')</h1>");
		out.println("<p>jstarter1A 에서 보내온 메세지... </p>");
		out.println("<p>메세지: "+msg+"</p>");
		out.println("</body></html>");
		// 한글이 깨지넹... 
	}

}
