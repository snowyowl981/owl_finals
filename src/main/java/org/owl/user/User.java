package org.owl.user;

public class User {
	String userId;
	String name;
	String email;
	String password;
	
	public User() {
	}

	/**
	 * email, password, name 으로 초기화하는 컨스트럭터
	 * 
	 * @param email    이메일
	 * @param password 비밀번호
	 * @param name     이름
	 */
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + "]\n";
	}
	
}
