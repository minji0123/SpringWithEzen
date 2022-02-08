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


@WebServlet("/MemberInsert")
public class MemberInsert extends HttpServlet {
       

    public MemberInsert() {
    }


	public void init(ServletConfig config) throws ServletException {
	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// html 연동
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		MemberDAO memberDAO = new MemberDAO();
		
		String command = request.getParameter("command");
		if (command != null) {
			if (command.equals("insertMember")) { // insertMember = html.value
				// 변수 = html.name
				String mid = request.getParameter("mid");
				String mname = request.getParameter("mname");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				
				System.out.printf("memberlist %s %s %s %s \n", mid, mname, pwd, email);
				
				// db 연동
				if (mid != null && mid.isEmpty() != true) {
					MemberVO member = new MemberVO(mid, mname, pwd, email);
					
					memberDAO.insertMember(member);
				}
			}
			else if(command.equals("deleteMember")) {
				String mid = request.getParameter("mid");
				System.out.printf("[deleteMember] mid(%s)%n", mid);
				if(mid != null && mid.isEmpty() != true) {
					memberDAO.deleteMember(mid);
				}
			}
		}
		
		PrintWriter out = response.getWriter();
		htmlHeader(out);
		htmlMembers(out);
		htmlFooter(out);
		
		
		
	} // doProcess
	
	
	static void htmlHeader(PrintWriter out) {
		out.print("<html><body>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td>");
		out.print("<td>이름</td>");
		out.print("<td>비밀번호</td>");
		out.print("<td>이메일</td>");
		out.print("<td>등록일자</td>");
		out.print("<td>삭제</td>");
		out.print("</tr>");
	}
	
	static void htmlMembers(PrintWriter out) {
		
		MemberDAO memberDAO = new MemberDAO();
		List<MemberVO> members = memberDAO.getMembers();
		
		for(int cnt=0; cnt < members.size(); cnt++) {
			MemberVO member = members.get(cnt);
			out.print("<tr>");
			out.printf("<td>%s</td>", member.getMid());
			out.printf("<td>%s</td>", member.getMname());
			out.printf("<td>%s</td>", member.getPwd());
			out.printf("<td>%s</td>", member.getEmail());
			out.printf("<td>%s</td>", member.getRegdate());
			out.printf("<td> <a href='/JServlet04/MemberInsert?command=deleteMember&mid=%s'>삭제</a></td>", member.getMid());
			out.print("</tr>");
		}
	}
	
	static void htmlFooter(PrintWriter out) {
		out.print("</table>");
		out.print("<a href='/JServlet04/MemberInsert.html'>멤버등록</a>");
		out.print("</body></html>");
	}
	
	

	
}// end
