package com.welovecoding.web.pusher.domain;

import java.util.ArrayList;
import java.util.List;

public class Category extends BaseEntity {

	private String color;

	private List<Playlist> playlists;

	public Category() {
		this.playlists = new ArrayList<>();
		this.color = "#000000";
	}

	public Category(String color) {
		this();
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	@Override
	public String toString() {
		return "Category{" + "color=" + color + ", playlists=" + playlists + '}' + super.toString();
	}

}
