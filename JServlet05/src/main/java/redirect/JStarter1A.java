package redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 리다이랙트!
//포워드 
//웹 브라우저를 거쳐서 요청
@WebServlet("/JStarter1A")
public class JStarter1A extends HttpServlet {
       

    public JStarter1A() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.sendRedirect("JTarget1A?msg=hello!!");
		// 주소 이동
	}

}
