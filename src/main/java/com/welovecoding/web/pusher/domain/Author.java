package com.welovecoding.web.pusher.domain;

public class Author extends BaseEntity {

	private String description;
	private String website;
	private String channelUrl;

	public Author() {
		this.description = "";
		this.website = "";
		this.channelUrl = "";
	}

	public Author(String name) {
		this();
		this.setName(name);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getChannelUrl() {
		return channelUrl;
	}

	public void setChannelUrl(String channelUrl) {
		this.channelUrl = channelUrl;
	}

	@Override
	public String toString() {
		return "Author{" + "description=" + description + ", website=" + website + ", channelUrl=" + channelUrl + '}' + super.toString();
	}

}
