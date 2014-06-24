package com.welovecoding.web.pusher.domain;

public abstract class UserCredentials {

	private Long id;

	private String token;

	private User user;

	private String credType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCredType() {
		return credType;
	}

	public void setCredType(String credType) {
		this.credType = credType;
	}

	@Override
	public String toString() {
		return "UserCredentials{" + "id=" + id + ", token=" + token + ", user=" + user + ", credType=" + credType + '}' + super.toString();
	}

}
