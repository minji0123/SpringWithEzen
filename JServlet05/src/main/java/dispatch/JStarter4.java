package dispatch;
//[포워드] 
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 디스패치!
// 웹 브라우저를 거치지 않고 포워딩
// 웹 브라우저의 주소창의 url 이 변경되지 않음
// 웹 브라우저에서 포워드가 진행되었는지 알 수 없다.
// 스프링에서 사용하는 포워딩 방법

// 4는 get 방식!
@WebServlet("/JStarte4")
public class JStarter4 extends HttpServlet {
       

    public JStarter4() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("JTarget4?msg=hi!!");
		dispatcher.forward(request, response);
	}

}
