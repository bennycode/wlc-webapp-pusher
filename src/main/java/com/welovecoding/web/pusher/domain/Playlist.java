package com.welovecoding.web.pusher.domain;

import java.util.ArrayList;
import java.util.List;

public class Playlist extends BaseEntity {

	private Provider provider;

	private Difficulty difficulty;

	private Category category;

	private Author author;

	private List<Video> videos;

	private String code;

	private LanguageCode languageCode;

	private String description;

	private boolean enabled;

	public Playlist() {
		this.enabled = true;
		this.videos = new ArrayList<>();
		this.provider = Provider.YOUTUBE;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videoList) {
		this.videos = videoList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LanguageCode getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public String toString() {
		return "Playlist{" + "provider=" + provider + ", difficulty=" + difficulty + ", category=" + category + ", author=" + author + ", videos=" + videos + ", code=" + code + ", languageCode=" + languageCode + ", description=" + description + ", enabled=" + enabled + '}' + super.toString();
	}

}
