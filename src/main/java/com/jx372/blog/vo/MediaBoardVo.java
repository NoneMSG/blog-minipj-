package com.jx372.blog.vo;

public class MediaBoardVo {
	private Long no;
	private String title;
	private String content;
	private String path;
	private String regDate;
	private String author;
	private String fileType;
	private String category;
	private String userName;
	private String hit;
	private Long userNo;
	private String userRole;
	
	public final String getUserRole() {
		return userRole;
	}
	public final void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public final String getUserName() {
		return userName;
	}
	public final void setUserName(String userName) {
		this.userName = userName;
	}
	public final Long getNo() {
		return no;
	}
	public final void setNo(Long no) {
		this.no = no;
	}
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}
	public final String getPath() {
		return path;
	}
	public final void setPath(String path) {
		this.path = path;
	}
	public final String getRegDate() {
		return regDate;
	}
	public final void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public final String getAuthor() {
		return author;
	}
	public final void setAuthor(String author) {
		this.author = author;
	}
	
	public final String getFileType() {
		return fileType;
	}
	public final void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public final Long getUserNo() {
		return userNo;
	}
	public final void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public final String getHit() {
		return hit;
	}
	public final void setHit(String hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "MediaBoardVo [no=" + no + ", title=" + title + ", content=" + content + ", path=" + path + ", regDate="
				+ regDate + ", author=" + author + ", fileType=" + fileType + ", category=" + category + ", userName="
				+ userName + ", hit=" + hit + ", userNo=" + userNo + ", userRole=" + userRole + "]";
	}
	
	
}
