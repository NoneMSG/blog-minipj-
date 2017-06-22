package com.jx372.blog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.blog.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public void insertUser(UserVo userVo) {
		sqlSession.insert("user.insert", userVo);
	}

	public UserVo getPath() {
		return sqlSession.selectOne("user.getPath");
	}

	public UserVo getUserByIdPw(String email, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		UserVo userVo = sqlSession.selectOne("user.getByInIdPw", map);
		return userVo;
	}

	public UserVo getUserByInIdPwPath(String email, String password, String path) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("password", password);
		map.put("path", path);
		UserVo userVo = sqlSession.selectOne("user.getByInIdPwPath", map);
		return userVo;
	}

	public int modifyUserInfo(UserVo userVo) {
		return sqlSession.update("user.update", userVo);
	}

	public UserVo getUserByNo(Long no) {
		return sqlSession.selectOne("user.getByNo",no);
	}

}
