package com.welovecoding.web.pusher.domain;

import java.util.List;

public class User extends BaseEntity {

	private String email;

	private List<UserCredentials> credentials;

	private boolean admin;

	public User() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<UserCredentials> getCredentials() {
		return credentials;
	}

	public void setCredentials(List<UserCredentials> credentials) {
		this.credentials = credentials;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User{" + "email=" + email + ", credentials=" + credentials + ", admin=" + admin + '}' + super.toString();
	}

}
