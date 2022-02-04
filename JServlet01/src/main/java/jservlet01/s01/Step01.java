package jservlet01.s01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Step01 extends HttpServlet{
	
	private int count;
	
	@Override
	public void init() throws ServletException{
		System.out.println("Step01");
		System.out.println("1. init ");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		System.out.println("2. doGet  , count : " + this.count++);
	}
	
	@Override
	public void destroy() {
		System.out.println("3. destroy  " );
	}
}
