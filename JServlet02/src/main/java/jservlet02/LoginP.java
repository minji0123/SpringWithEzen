package jservlet02;
//post 방식으로 웹 <-> server
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginP")
public class LoginP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginP() {
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("loginPost init!");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginPost doPost");
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		System.out.println("userId : " + userId);
		System.out.println("userPw : " + userPw);
	}

}
