package members;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
			
			
			// 포워드 
			List<MemberVO> members = memberDAO.getMembers();
			request.setAttribute("members", members);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("MemberView");
			dispatcher.forward(request, response);
			// POST 로 전달 시 사용
		}
		// dispatcher 
		// get 에서 요청하면 get으로 요청
		// post 에서 요청하면 post 으로 요청
		// html 에서는 post 로 보냈고, servlet 에서는 get 으로 보냈기 때문에 각각 따로 처리됨

		
	} // doProcess end
	
	

	
	

	
}// end
