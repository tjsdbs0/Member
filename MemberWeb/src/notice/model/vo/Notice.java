package notice.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class Notice {
	private int noticeNo;
	private String subject;
	private String userId;
	private String contents;
	private Date regDate;
	private ArrayList<NoticeComment> comments = null;

	
	public Notice() {}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public ArrayList<NoticeComment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<NoticeComment> comments) {
		this.comments = comments;
	}
	
	
	
	

}
