package jservlet02;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/School2")
public class School2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		Enumeration<String> school2 = request.getParameterNames();
		
		while(school2.hasMoreElements()) {
		
			String name = (String)school2.nextElement();
			String[] values = request.getParameterValues(name);
			
			System.out.println("요청목록");
			
			for (String value : values) {
				System.out.println("유형: "+name+ " 목록: " + value);
				
			}
		}
	}
}
