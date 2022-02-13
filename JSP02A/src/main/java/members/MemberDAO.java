/*
 * MemberDAO: Data Access Object
 */
package members;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import soldb.OracleConnector;

public class MemberDAO {

	public boolean isMember(String id, String pw) {
		String sql = "SELECT mid, pwd FROM member WHERE mid=?";
		
		boolean membered = false;
		
		try {
			Connection conn = OracleConnector.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				String mid = rs.getString("mid");
				String pwd = rs.getString("pwd");
				if(mid.equals(id) && pwd.equals(pw)) {
					membered = true;
				}
			}

			rs.close();
			stmt.close();
			OracleConnector.closeConnection();
		}
		catch(SQLException e) {
			System.out.println("[isMember] SQLException : " + e.toString());
		}
		
		return membered;
	}

	
	public void updateMember(MemberVO memberVO) {
		String sql = "UPDATE member SET mname=?, pwd=?, email=? WHERE mid=?";
		
		try {
			Connection conn = OracleConnector.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, memberVO.getMname());
			stmt.setString(2, memberVO.getPwd());
			stmt.setString(3, memberVO.getEmail());
			stmt.setString(4, memberVO.getMid());
			
			int success = stmt.executeUpdate();
			if(success > 0) {
				System.out.printf("[updateMember] 수정완료: 수정된 데이터 갯수(%d)\n", success);
			}
			else {
				System.out.printf("[updateMember] 수정실패: 수정된 데이터 갯수(%d)\n", success);
			}
			stmt.close();
			OracleConnector.closeConnection();
		}
		catch(SQLException e) {
			System.out.println("[updateMember] SQLException : " + e.toString());
		}
	}

	
	public MemberVO getMember(String id) {
		String sql = "SELECT * FROM member WHERE mid=?";
		
		MemberVO member = new MemberVO();
		
		try {
			Connection conn = OracleConnector.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				String mid   = rs.getString("mid");
				String mname = rs.getString("mname");
				String pwd   = rs.getString("pwd");
				String email = rs.getString("email");
				Date regdate = rs.getDate("regdate");
				
				member.setMid(mid);
				member.setMname(mname);
				member.setPwd(pwd);
				member.setEmail(email);
				member.setRegdate(regdate);
			}

			rs.close();
			stmt.close();
			OracleConnector.closeConnection();
		}
		catch(SQLException e) {
			System.out.println("[getMember] SQLException : " + e.toString());
		}
		
		return member;
	}
	
	public void insertMember(MemberVO memberVO) {
		String sql = "INSERT INTO member (mid, mname, pwd, email) VALUES (?, ?, ?, ?)";
		
		try {
			Connection conn = OracleConnector.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, memberVO.getMid());
			stmt.setString(2, memberVO.getMname());
			stmt.setString(3, memberVO.getPwd());
			stmt.setString(4, memberVO.getEmail());
			
			stmt.executeUpdate();

			stmt.close();
			OracleConnector.closeConnection();
		}
		catch(SQLException e) {
			System.out.println("[insertMember] SQLException : " + e.toString());
		}
	}
	
	public void deleteMember(String mid) {
		String sql = "DELETE FROM member WHERE mid = ?";
		
		try {
			Connection conn = OracleConnector.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, mid);
			stmt.executeUpdate();
			stmt.close();
			
			OracleConnector.closeConnection();
		}
		catch(SQLException e) {
			System.out.println("[deleteMember] SQLException : " + e.toString());
		}
	}

	
	
	public List<MemberVO> getMembers() {
		List<MemberVO> listMembers = new ArrayList<MemberVO>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM member ORDER BY mid";
			
			conn = OracleConnector.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String mid = rs.getString("mid");
				String mname = rs.getString("mname");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				Date regdate = rs.getDate("regdate");
				
				MemberVO member = new MemberVO();
				member.setMid(mid);
				member.setMname(mname);
				member.setPwd(pwd);
				member.setEmail(email);
				member.setRegdate(regdate);
				
				listMembers.add(member);
			}
		}
		catch(SQLException e) {
			System.out.println("[getMembers] SQLException : " + e.toString());
		}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(stmt != null) {
					stmt.close();
				}
			}
			catch(Exception e) {
				System.out.println("[getMembers] finally SQLException : " + e.toString());
			}
			
			OracleConnector.closeConnection();
		}
		
		return listMembers;
	}
}
