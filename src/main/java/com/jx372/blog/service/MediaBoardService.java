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
		int totalCount = mediaBoardDao.getTotalCount(); //총 게시글의 수
		int pageCount = (int)Math.ceil( (double)totalCount / LIST_SIZE ); //총 페이지 수
		int blockCount = (int)Math.ceil( (double)pageCount / PAGE_SIZE ); //5개씩의 페이지 묶음이 몇개나 존재하는지
		int currentBlock = (int)Math.ceil( (double)currentPage / PAGE_SIZE ); // 5개씩 페이지의 묶음에서 현재 몇번째에 위치한지
		
		if( currentPage < 1 ) { //현재 페이지가 0이하일 때 현재 페이지 1로 고정
			currentPage = 1;
			currentBlock = 1; //현재 블록도 1 
		} else if( currentPage > pageCount ) { //현재 페이지가 총 페이지수 보다 높다면
			currentPage = pageCount; 			//현재 페이지는 총 페이지와 같고
			currentBlock = (int)Math.ceil( (double)currentPage / PAGE_SIZE ); //현재 블록은 현재페이지에서 페이지사이즈 5를 나눈곳이된다.
		}
		System.out.println(pageCount+":::"+blockCount+":::"+currentBlock);
		
		int beginPage = currentBlock == 0 ? 1 : (currentBlock - 1)*PAGE_SIZE + 1; //화면에 보여줄 시작페이지 결정 
		int prevPage = ( currentBlock > 1 ) ? ( currentBlock - 1 ) * PAGE_SIZE : 0; //이전 페이지 결정
		int nextPage = ( currentBlock < blockCount ) ? currentBlock * PAGE_SIZE + 1 : 0; //다음 페이지 결정
		int endPage = ( nextPage > 0 ) ? ( beginPage - 1 ) + LIST_SIZE : pageCount; //끝 페이지 결정(게시글이 존재하는 페이지 끝)
		
		List<MediaBoardVo> list = mediaBoardDao.getList(keyword ,currentPage, LIST_SIZE );
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(beginPage+"::::"+prevPage+":::::"+nextPage+":::::"+endPage);
		
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
