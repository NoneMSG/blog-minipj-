package com.jx372.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jx372.blog.service.UserService;
import com.jx372.blog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/join")
	public String join(){
		return "user/join";
	}
	
	//회원가입
	@RequestMapping(value="/join", method=RequestMethod.POST )
	public String join(@ModelAttribute UserVo userVo){
		userService.getJoin(userVo);
	
		return  "/user/joinsuccess"; //redirect
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "user/login";
	}
	@RequestMapping("/redirect")
	public String redirect(){
		return "redirect:/user/joinsuccess";
	}
	
}
