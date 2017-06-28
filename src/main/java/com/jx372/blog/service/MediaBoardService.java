package com.jx372.blog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jx372.blog.repository.MediaBoardDao;
import com.jx372.blog.vo.MediaBoardVo;


@Service
public class MediaBoardService {
	private static final int LIST_SIZE = 5; //리스팅되는 게시물의 수
	private static final int PAGE_SIZE = 5; //페이지 리스트의 페이지 수

	
	@Autowired
	private MediaBoardDao mediaBoardDao;
	
	public void getWrite(MediaBoardVo mediaBoardVo) {
		mediaBoardDao.insertContent(mediaBoardVo);
	}

	public Map<String, Object> getMessageList(int currentPage, String keyword){
		int totalCount = mediaBoardDao.getTotalCount(); 
		int pageCount = (int)Math.ceil( (double)totalCount / LIST_SIZE );
		int blockCount = (int)Math.ceil( (double)pageCount / PAGE_SIZE );
		int currentBlock = (int)Math.ceil( (double)currentPage / PAGE_SIZE );
		
		if( currentPage < 1 ) {
			currentPage = 1;
			currentBlock = 1;
		} else if( currentPage > pageCount ) {
			currentPage = pageCount;
			currentBlock = (int)Math.ceil( (double)currentPage / PAGE_SIZE );
		}
		int beginPage = currentBlock == 0 ? 1 : (currentBlock - 1)*PAGE_SIZE + 1;
		int prevPage = ( currentBlock > 1 ) ? ( currentBlock - 1 ) * PAGE_SIZE : 0;
		int nextPage = ( currentBlock < blockCount ) ? currentBlock * PAGE_SIZE + 1 : 0;
		int endPage = ( nextPage > 0 ) ? ( beginPage - 1 ) + LIST_SIZE : pageCount;
		
		List<MediaBoardVo> list = mediaBoardDao.getList(keyword ,currentPage, LIST_SIZE );
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put( "list", list );
		map.put( "totalCount", totalCount );
		map.put( "listSize", LIST_SIZE );
		map.put( "currentPage", currentPage );
		map.put( "beginPage", beginPage );
		map.put( "endPage", endPage );
		map.put( "prevPage", prevPage );
		map.put( "nextPage", nextPage );
		map.put("keyword", keyword);
		return map;
		
	}

	public MediaBoardVo getContentView(Long no) {
		return mediaBoardDao.getContent(no);
	}

	public void increaseHit(Long no) {
		mediaBoardDao.getUpdateHit(no);
	}

	public void getDelete(MediaBoardVo mbvo) {
		mediaBoardDao.getDelete(mbvo);
		
	}

}
