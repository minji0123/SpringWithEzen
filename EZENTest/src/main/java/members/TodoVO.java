package members;

import java.sql.Date;

// Value Object
public class TodoVO {
	private String tid;
	private String title;
	private String content;
	private Date regdate;
	
	TodoVO(){}
	
	// insert 용 생성자 (regdate 필요없음)
	public TodoVO(String tid, String title, String content) {
		super();
		this.tid = tid;
		this.title = title;
		this.content = content;
	}
	

	public TodoVO(String tid, String title, String content, Date regdate) {
		super();
		this.tid = tid;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
	
	
	
}
