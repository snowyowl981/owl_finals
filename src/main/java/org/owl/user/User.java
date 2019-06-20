package org.owl.user;

public class User {
	String userId; // 아이디
	String email; // 이메일
	String password; // 비밀번호
	String name; // 이름
	
	public User() {
	}
	
	public User(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}

	/**
	 * @return the userId
	 */
	public String getuserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setuserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + 
	email + ", password=" + password + "]\n";
}
	
}
