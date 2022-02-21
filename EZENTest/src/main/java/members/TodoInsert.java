package members;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TodoInsert")
public class TodoInsert extends HttpServlet {
       

    public TodoInsert() {
    }

	public void init(ServletConfig config) throws ServletException {
	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// html 연동
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		TodoDAO todoDAO = new TodoDAO();
		String command = request.getParameter("command");
		
		if (command != null) {
			
			
			if (command.equals("insertTodo")) { // insertTodo = html.value
				// 변수 = html.name
				String tid = request.getParameter("tid");
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				System.out.printf("todolist %s %s %s \n", tid, title, content);
				
				// db 연동
				if (tid != null && tid.isEmpty() != true) {
					TodoVO todo = new TodoVO(tid, title, content);
					
					todoDAO.insertTodo(todo);
				}
			}// insertTodo
			
			
			else if(command.equals("deleteTodo")) {// deleteTodo = view.value
				String tid = request.getParameter("tid");
				System.out.printf("[deleteTodo] tid(%s)%n", tid);
				
				if(tid != null && tid.isEmpty() != true) {
					todoDAO.deleteTodo(tid);
				}
			}// deleteTodo
			
			
			if (command.equals("editTodo")) { // editTodo = Edit.value
				// 변수 = html.name
				String tid = request.getParameter("tid");
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				System.out.printf("todolist %s %s %s \n", tid, title, content);
				
				// db 연동
				if (tid != null && tid.isEmpty() != true) {
					TodoVO todo = new TodoVO(tid, title, content);
					todoDAO.updateTodo(todo);
				}
			}// editMember
			
			
			
		}// if end

			
		response.sendRedirect("TodoView");
			
	}// doProcess end

}//end
	

