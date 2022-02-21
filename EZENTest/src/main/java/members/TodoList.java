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

@WebServlet("/TodoList")
public class TodoList extends HttpServlet {
       

    public TodoList() {
    }


	public void init(ServletConfig config) throws ServletException {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		htmlHeader(out);
		htmlMembers(out);
		htmlFooter(out);
	}
	
	static void htmlHeader(PrintWriter out) {
		out.print("<html><body>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td>");
		out.print("<td>이름</td>");
		out.print("<td>비밀번호</td>");
		out.print("<td>이메일</td>");
		out.print("<td>등록일지</td>");
		out.print("</tr>");
	}
	
	static void htmlMembers(PrintWriter out) {
		TodoDAO todoDAO = new TodoDAO();
		List<TodoVO> todos = todoDAO.getTodos();
		
		for(int cnt=0; cnt < todos.size(); cnt++) {
			TodoVO todo = todos.get(cnt);
			out.print("<tr>");
			out.printf("<td>%s</td>", todo.getTid());
			out.printf("<td>%s</td>", todo.getTitle());
			out.printf("<td>%s</td>", todo.getContent());
			out.printf("<td>%s</td>", todo.getRegdate());
			out.print("</tr>");
		}
	}
	
	static void htmlFooter(PrintWriter out) {
		out.print("</table>");
		out.print("</body></html>");
	}
	
	

}
