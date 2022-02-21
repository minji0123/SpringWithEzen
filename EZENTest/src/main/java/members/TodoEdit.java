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

@WebServlet("/TodoEdit")
public class TodoEdit extends HttpServlet {
       

    public TodoEdit() {
    }


	public void init(ServletConfig config) throws ServletException {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoEdit doGet");
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoEdit doPost");
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 수정!
		String tid = request.getParameter("tid");
		
		TodoDAO todoDAO = new TodoDAO();
		TodoVO todo = todoDAO.getTodo(tid);
		
		
		PrintWriter out = response.getWriter();
		htmlHeader(out);
		htmlMember(out,todo); // 한명만 출력
		htmlFooter(out);
	}
	
	
	
	static void htmlHeader(PrintWriter out) {
		out.print("<html><body>");
		out.print("<h1>할 일 수정</h1>");
		out.print("<hr>");
	}
	
	static void htmlMember(PrintWriter out, TodoVO todo) {  // 한명만 출력

		if(todo==null) {
			return;
		}
		
		out.print("<form name='TodoEdit' method='post' action='TodoInsert'>");
		out.print("<div style='width:200px; border: 1px solid black; border-radius: 10px; padding:30px;' >");
		out.printf("<p>번호: %s </p>",todo.getTid());
		out.printf("<p>제목</p><input type='text' name='title' value='%s' />",todo.getTitle());
		out.printf("<p>내용</p><input type='text' name='content' value='%s' />",todo.getContent());
		

		out.print("<div style='margin-bottom:10px;'></div>");
		out.print("<input type='submit' value='수정완료'/>");
		out.print("<input type='reset' value='다시입력'/>");
		out.print("</div>");
		out.printf("<input type='hidden' name='tid' value='%s'/>",todo.getTid());
		out.print("<input type='hidden' name='command' value='editTodo'/>");
		out.print("</form>");

	}
	
	static void htmlFooter(PrintWriter out) {
		out.print("</body></html>");
	}
	
	

}
