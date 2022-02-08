package redirect;
//[포워드] 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 리다이랙트!

//웹 브라우저를 거쳐서 요청
@WebServlet("/JStarter1")
public class JStarter1 extends HttpServlet {
       

    public JStarter1() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.sendRedirect("JTarget1");
		// 주소 이동
	}

}
