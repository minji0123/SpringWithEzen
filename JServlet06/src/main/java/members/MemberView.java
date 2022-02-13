package members;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MemberView")
public class MemberView extends HttpServlet {

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("memberview doget!!");
		// 삭제 시 필요!
		
		doProcess(request, response);
	}

	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("memberview dopost!!");
		// 생성 시 필요!
		doProcess(request, response);
	}

	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
//		List<MemberVO> members = (List<MemberVO>) request.getAttribute("members");
		
		
		PrintWriter out = response.getWriter();
		htmlHeader(out);
		htmlMembers(out);
		htmlFooter(out);
	}// doProcess


	static void htmlHeader(PrintWriter out) {
		out.print("<html><body>");
		out.print("<h2>멤버 뷰</h2>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td>");
		out.print("<td>이름</td>");
		out.print("<td>비밀번호</td>");
		out.print("<td>이메일</td>");
		out.print("<td>등록일자</td>");
		out.print("<td>삭제</td>");
		out.print("<td>수정</td>");
		out.print("</tr>");
	}// htmlHeader
	
	
	
	static void htmlMembers(PrintWriter out) {
		MemberDAO memberDAO = new MemberDAO();
		List<MemberVO> members = memberDAO.getMembers();
		
		for(int cnt=0; cnt < members.size(); cnt++) {
			MemberVO member = members.get(cnt);
			out.print("<tr>");
			out.printf("<td><a href='/JServlet06/MemberDetail?&mid=%s'> %s </a></td>", member.getMid(),member.getMid());
			out.printf("<td>%s</td>", member.getMname());
			out.printf("<td>%s</td>", member.getPwd());
			out.printf("<td>%s</td>", member.getEmail());
			out.printf("<td>%s</td>", member.getRegdate());
			out.printf("<td><a href='/JServlet06/MemberInsert?command=deleteMember&mid=%s'>삭제</a></td>", member.getMid());
			// 삭제는 get 으로 요청이 되었다.
			out.printf("<td><a href='/JServlet06/MemberEdit?mid=%s'>수정</a></td>", member.getMid());
			out.print("</tr>");
		}
	} // htmlMembers
	
	
	
	static void htmlFooter(PrintWriter out) {
		out.print("</table>");
		out.print("<a href='/JServlet06/MemberInsert.html'>멤버등록</a>");
		out.print("</body></html>");
	}// htmlFooter

}
