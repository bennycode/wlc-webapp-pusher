package com.welovecoding.web.pusher.domain;

import com.welovecoding.web.pusher.Slugify;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String slug;

	private Date created;

	protected Date lastModified;

	private User creator;

	private User lastEditor;

	public BaseEntity() {
		this.created = new Date();
		this.lastModified = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.slug = Slugify.slugify(name);
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getLastEditor() {
		return lastEditor;
	}

	public void setLastEditor(User lastEditor) {
		this.lastEditor = lastEditor;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BaseEntity other = (BaseEntity) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return "BaseEntity{" + "id=" + id + ", name=" + name + ", slug=" + slug + ", created=" + created + ", lastModified=" + lastModified + ", creator=" + creator + ", lastEditor=" + lastEditor + '}';
	}

}
