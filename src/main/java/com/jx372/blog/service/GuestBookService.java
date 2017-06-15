package com.jx372.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx372.blog.repository.GuestBookDao;
import com.jx372.blog.vo.GuestBookVo;

@Service
public class GuestBookService {
	
	@Autowired
	private GuestBookDao guestBookDao;

	public List<GuestBookVo> getContentList() {
		return guestBookDao.getContentList();

	}

	public void getWriting(GuestBookVo guestBookVo) {
		guestBookDao.getWriting(guestBookVo);
	}

	public void getDeleting(GuestBookVo guestBookVo) {
		guestBookDao.getDeleting(guestBookVo);
	}

}
