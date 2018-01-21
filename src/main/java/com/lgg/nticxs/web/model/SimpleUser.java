package com.lgg.nticxs.web.model;

public class SimpleUser {
	private String id;
	private String name;
	private String role;
	
	public SimpleUser(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.role = user.getRole();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
