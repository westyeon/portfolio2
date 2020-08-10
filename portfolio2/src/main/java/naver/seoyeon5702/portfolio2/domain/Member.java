package naver.seoyeon5702.portfolio2.domain;

public class Member {
	private String email;
	private String pw;
	private String nickname;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Member [email=" + email + ", pw=" + pw + ", nickname=" + nickname + "]";
	}
	
	
	
}
