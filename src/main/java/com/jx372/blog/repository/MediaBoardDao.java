package com.jx372.blog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.blog.vo.MediaBoardVo;

@Repository
public class MediaBoardDao {
	
	@Autowired
	private SqlSession sqlSession;

	public void insertContent(MediaBoardVo mediaBoardVo) {
		sqlSession.insert("mediaboard.insert",mediaBoardVo);
		
	}

	public int getTotalCount() {
		return sqlSession.selectOne("mediaboard.totalCount");
	}

	public List<MediaBoardVo> getList(String keyword, int page, int size) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put( "page", (page-1)*size );
		map.put( "size", size );
		
		return sqlSession.selectList( "mediaboard.getList", map );
	}

	public MediaBoardVo getContent(Long no) {
		MediaBoardVo mbVo = sqlSession.selectOne("mediaboard.getContentByNo",no);
		return mbVo;
	}

	public void getUpdateHit(Long no) {
		sqlSession.update("mediaboard.updateHit",no);
	}

	public void getDelete(MediaBoardVo mbvo) {
		sqlSession.delete("mediaboard.delete",mbvo);
	}
}
