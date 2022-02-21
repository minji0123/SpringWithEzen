package members;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TodoView")
public class TodoView extends HttpServlet {

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoView doget!!");
		// 삭제 시 필요!
		
		doProcess(request, response);
	}

	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoView dopost!!");
		// 생성 시 필요!
		doProcess(request, response);
	}

	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		PrintWriter out = response.getWriter();
		htmlHeader(out);
		htmlMembers(out);
		htmlFooter(out);
	}// doProcess


	static void htmlHeader(PrintWriter out) {
		out.print("<html><body>");
		out.print("<h2>ToDo List</h2>");
		out.print("<hr>");
		out.print("<div style='width:400px; border: 1px solid black; border-radius: 10px; padding:30px;' >");
		out.print("<table border=1 style='border-collapse: collapse;'>");
		out.print("<tr align='center'>");
		out.print("<td>번호</td>");
		out.print("<td>제목</td>");
		out.print("<td>내용</td>");
		out.print("<td>등록일자</td>");
		out.print("<td>삭제</td>");
		out.print("<td>수정</td>");
		out.print("</tr>");
	}// htmlHeader

	static void htmlMembers(PrintWriter out) {
		TodoDAO todoDAO = new TodoDAO();
		List<TodoVO> todos = todoDAO.getTodos();
		
		for(int cnt=0; cnt < todos.size(); cnt++) {
			TodoVO todo = todos.get(cnt);
			out.print("<tr>");
			out.printf("<td><a href='/EZENTest/TodoDetail?&tid=%s'> %s </a></td>", todo.getTid(),todo.getTid());
			out.printf("<td>%s</td>", todo.getTitle());
			out.printf("<td>%s</td>", todo.getContent());
			out.printf("<td>%s</td>", todo.getRegdate());
			out.printf("<td><a href='/EZENTest/TodoInsert?command=deleteTodo&tid=%s'>삭제</a></td>", todo.getTid());
			// 삭제는 get 으로 요청이 되었다.
			out.printf("<td><a href='/EZENTest/TodoEdit?tid=%s'>수정</a></td>", todo.getTid());
			out.print("</tr>");
		}
	} // htmlMembers

	static void htmlFooter(PrintWriter out) {
		out.print("</table>");
		out.print("</div>");
		out.print("<a href='/EZENTest/TodoInsert.html'>새 할일</a>");
		out.print("</body></html>");
	}// htmlFooter

}
