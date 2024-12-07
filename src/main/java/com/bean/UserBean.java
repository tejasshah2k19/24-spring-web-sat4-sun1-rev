package com.bean;

import org.springframework.web.multipart.MultipartFile;

public class UserBean {

	private Integer userId;
	private String firstName;
	private String email;
	private String password;
	
	private MultipartFile  profile; 
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public MultipartFile getProfile() {
		return profile;
	}

	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}
	
	

}
