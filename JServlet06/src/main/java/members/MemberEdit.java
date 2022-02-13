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

@WebServlet("/MemberEdit")
public class MemberEdit extends HttpServlet {
       

    public MemberEdit() {
    }


	public void init(ServletConfig config) throws ServletException {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberEdit doGet");
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberEdit doPost");
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 수정!
		String mid = request.getParameter("mid");
		
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = memberDAO.getMember(mid);
		
		
		PrintWriter out = response.getWriter();
		htmlHeader(out);
		htmlMember(out,member); // 한명만 출력
		htmlFooter(out);
	}
	
	static void htmlHeader(PrintWriter out) {
		out.print("<html><body>");
		out.print("<h1>멤버 수정</h1>");
		out.print("<hr>");
		

	}
	
	static void htmlMember(PrintWriter out, MemberVO member) {  // 한명만 출력

		if(member==null) {
			return;
		}
		
		out.print("<form name='MemberEdit method='post' action='MemberInsert'>");
		
		out.print("<table border=1");
		out.printf("<tr><td>아이디</td><td><input type='text' name='mid' value='%s' readonly</td></tr>",member.getMid());
		out.printf("<tr><td>이름</td><td><input type='text' name='mname' value='%s' </td></tr>",member.getMname());
		out.printf("<tr><td>비밀번호</td><td><input type='password' name='pwd' value='%s' </td></tr>",member.getPwd());
		out.printf("<tr><td>이메일</td><td><input type='text' name='email' value='%s' </td></tr>",member.getEmail());
		out.print("<tr>");
		out.print("<td><input input type='submit' value='멤버수정'/></td>");
		out.print("<td><input input type='reset' value='다시입력'/></td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("<td><input input type='hidden' name='command' value='editMember'/></td>");
		out.print("</form>");
		

	}
	
	static void htmlFooter(PrintWriter out) {
		out.print("</body></html>");
	}
	
	

}
