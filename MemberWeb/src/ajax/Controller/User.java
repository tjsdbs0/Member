package ajax.Controller;

public class User {
	private int userNo;
	private String userName;
	private String userAddr;
	
	public User() {
		
	}
	
	public User(int userNo, String userName, String userAddr) {
		this.userNo = userNo;
		this.userName = userName;
		this.userAddr = userAddr;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	
}
