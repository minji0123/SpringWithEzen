package refresh;
//[포워드] 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 리프레시!

// 웹 브라우저를 거쳐서 요청
@WebServlet("/JStarte2")
public class JStarter2 extends HttpServlet {
       

    public JStarter2() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.addHeader("Refresh", "5;url=JTarget2"); // 5 second later...

	}

}
