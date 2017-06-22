package com.jx372.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx372.blog.repository.UserDao;
import com.jx372.blog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	
	public void getJoin(UserVo userVo) {
		userDao.insertUser(userVo);
	}
	public UserVo getUser(Long no){
		return userDao.getUserByNo(no);
	}
	public UserVo getUser(String email, String password){
		return userDao.getUserByIdPw(email,password);
	}
	
	public UserVo getUser(String email, String password, String path){
		return userDao.getUserByInIdPwPath(email,password,path);
	}
	
	public boolean modifyUser(UserVo userVo){
		return userDao.modifyUserInfo(userVo)==1;
	}
	
}
