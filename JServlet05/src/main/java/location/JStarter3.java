package location;
//[포워드] 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 로케이션!

// 웹 브라우저를 거쳐서 요청
// location 은 script 를 이용해서 페이지 이동 (클라이언트가 바꿈..)
@WebServlet("/JStarte3")
public class JStarter3 extends HttpServlet {
       

    public JStarter3() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<script type='text/javascript'>");
		out.print("location.href='JTarget3';");
		out.print("</script>");

	}

}
