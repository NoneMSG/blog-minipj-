package com.jx372.blog.vo;

public class MediaBoardVo {
	private Long no;
	private String title;
	private String content;
	private String path;
	private String regDate;
	private Long userNo;
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
	public final Long getUserNo() {
		return userNo;
	}
	public final void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	@Override
	public String toString() {
		return "MediaBoardVo [no=" + no + ", title=" + title + ", content=" + content + ", path=" + path + ", regDate="
				+ regDate + ", userNo=" + userNo + "]";
	}
	
}
