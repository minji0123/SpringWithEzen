package members;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TodoDetail")
public class TodoDetail extends HttpServlet {
       

    public TodoDetail() {
    }


	public void init(ServletConfig config) throws ServletException {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoDetail doGet");
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoDetail doPost");
		doProcess(request,response);
	}
	
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String tid = request.getParameter("tid");
		
		TodoDAO todoDAO = new TodoDAO();
		TodoVO todo = todoDAO.getTodo(tid);
		
		
		PrintWriter out = response.getWriter();
		htmlHeader(out);
		htmlMember(out,todo);
		htmlFooter(out);
	}
	
	static void htmlHeader(PrintWriter out) {
		out.print("<html><body>");
		out.print("<h1>Detail</h1>");
		out.print("<hr>");
	}
	
	static void htmlMember(PrintWriter out, TodoVO todo) {

		if(todo==null) {
			return;
		}
		out.print("<div style='width:200px; border: 1px solid black; border-radius: 10px; padding:30px;' >");
		out.printf("<p>번호: %s </p>",todo.getTid());
		out.printf("<p>제목: %s </p>",todo.getTitle());
		out.printf("<p>내용: %s </p>",todo.getContent());
		out.printf("<p>작성시간: %s </p>",todo.getRegdate());
	}
	
	static void htmlFooter(PrintWriter out) {
		out.print("<a href='/EZENTest/TodoView'>목록으로</a>");
		out.print("</div>");
		out.print("</body></html>");
	}
	
	

}
