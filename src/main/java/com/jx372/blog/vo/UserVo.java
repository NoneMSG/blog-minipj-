package com.jx372.blog.vo;

public class UserVo {
	
	private Long no;
	private String email;
	private String name;
	private String password;
	private String role;
	private String path;
	
	public final String getPath() {
		return path;
	}
	public final void setPath(String path) {
		this.path = path;
	}
	public final Long getNo() {
		return no;
	}
	public final void setNo(Long no) {
		this.no = no;
	}
	public final String getEmail() {
		return email;
	}
	public final void setEmail(String email) {
		this.email = email;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	public final String getRole() {
		return role;
	}
	public final void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", email=" + email + ", name=" + name + ", password=" + password + ", role=" + role
				+ ", path=" + path + "]";
	}
	
	
}
