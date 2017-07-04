package com.jx372.blog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.blog.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestBookVo> getContentList() {
		List<GuestBookVo> list = sqlSession.selectList("guestbook.getListAll");
		//System.out.println(list);
		return list;
	}

	public void getWriting(GuestBookVo guestBookVo) {
		sqlSession.insert("guestbook.writing",guestBookVo);
	}

	public void getDeleting(GuestBookVo guestBookVo) {
		sqlSession.delete("guestbook.deleting",guestBookVo);
		
	}
	public void getDeleteByAdmin(Long no) {
		sqlSession.delete("guestbook.deleteByAdmin",no);
	}

}
