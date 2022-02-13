package members;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberDetail")
public class MemberDetail extends HttpServlet {
       

    public MemberDetail() {
    }


	public void init(ServletConfig config) throws ServletException {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberDetail doGet");
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberDetail doPost");
		doProcess(request,response);
	}
	
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String mid = request.getParameter("mid");
		
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = memberDAO.getMember(mid);
		
		
		PrintWriter out = response.getWriter();
		htmlHeader(out);
		htmlMember(out,member);
		htmlFooter(out);
	}
	
	static void htmlHeader(PrintWriter out) {
		out.print("<html><body>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td>");
		out.print("<td>이름</td>");
		out.print("<td>비밀번호</td>");
		out.print("<td>이메일</td>");
		out.print("<td>등록일자</td>");
		out.print("</tr>");
		

	}
	
	static void htmlMember(PrintWriter out, MemberVO member) {

		if(member==null) {
			return;
		}
		
		out.print("<tr>");
		out.printf("<td>%s</td>", member.getMid());
		out.printf("<td>%s</td>", member.getMname());
		out.printf("<td>%s</td>", member.getPwd());
		out.printf("<td>%s</td>", member.getEmail());
		out.printf("<td>%s</td>", member.getRegdate());
		out.print("</tr>");
	
	}
	
	static void htmlFooter(PrintWriter out) {
		out.print("</table>");
		out.print("<a href='/JServlet06/MemberView'>목록으로</a>");
		out.print("</body></html>");
	}
	
	

}
