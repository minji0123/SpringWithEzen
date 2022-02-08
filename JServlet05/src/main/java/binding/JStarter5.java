package binding;
//[포워드] 
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 디스패치_바인딩!

// 5는 post 방식!
@WebServlet("/JStarte5")
public class JStarter5 extends HttpServlet {
       

    public JStarter5() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		request.setAttribute("msgx", "환영합니당");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("JTarget5");
		dispatcher.forward(request, response);
	}

}
