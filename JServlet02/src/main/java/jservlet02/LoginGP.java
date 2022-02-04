package jservlet02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginGP")
public class LoginGP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginGP() {
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("loginGP init!");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginGP doGet");
		
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("search");
		System.out.println("search : " + search);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginGP doPost");
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		System.out.println("userId : " + userId);
		System.out.println("userPw : " + userPw);
	}

}
