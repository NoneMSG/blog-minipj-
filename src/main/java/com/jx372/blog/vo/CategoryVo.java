package com.jx372.blog.vo;

public class CategoryVo {
	private Long no;
	private String name;
	private Long boardNo;
	private Long mediaBoardNo;
	public final Long getNo() {
		return no;
	}
	public final void setNo(Long no) {
		this.no = no;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final Long getBoardNo() {
		return boardNo;
	}
	public final void setBoardNo(Long boardNo) {
		this.boardNo = boardNo;
	}
	public final Long getMediaBoardNo() {
		return mediaBoardNo;
	}
	public final void setMediaBoardNo(Long mediaBoardNo) {
		this.mediaBoardNo = mediaBoardNo;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", boardNo=" + boardNo + ", mediaBoardNo=" + mediaBoardNo
				+ "]";
	}
	
	
}
