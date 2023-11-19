package dd_user;

public class DD_User {
	private String UserID;
	private String UserPassword;
	private String UserEmail;
	private String UserNickname;
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String UserID) {
		this.UserID = UserID;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String UserPassword) {
		this.UserPassword = UserPassword;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String UserEmail) {
		this.UserEmail = UserEmail;
	}
	public String getUserNickname() {
		return UserNickname;
	}
	public void setUserNickname(String UserNickname) {
		this.UserNickname = UserNickname;
	}
}
