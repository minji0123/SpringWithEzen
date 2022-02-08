package members;

import java.sql.Date;

// Value Object
public class MemberVO {
	private String mid;
	private String mname;
	private String pwd;
	private String email;
	private Date regdate;
	
	MemberVO(){}
	
	// insert 용 생성자 (regdate 필요없음)
	public MemberVO(String mid, String mname, String pwd, String email) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.pwd = pwd;
		this.email = email;
	}
	

	public MemberVO(String mid, String mname, String pwd, String email, Date regdate) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.pwd = pwd;
		this.email = email;
		this.regdate = regdate;
	}
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}
