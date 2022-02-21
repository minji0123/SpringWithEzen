package com.members;

public class MemberServiceImpl implements MemberService{
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		System.out.println("[MemberServiceImpl] setMemberDAO()");
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void getMembers() {
		memberDAO.memberList();
	}
}
