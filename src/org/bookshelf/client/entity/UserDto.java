package org.bookshelf.client.entity;

public class UserDto {
	private Integer id;
	private String name;
	private String description;
	private String position;
	private String email;
	private Integer role;
	private String password;
	
	public UserDto() {
	}
	
	public UserDto(Integer id, String name, String description, String position, String email, Integer role, String password) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.position = position;
		this.email = email;
		this.role = role;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
