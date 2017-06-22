package com.jx372.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jx372.blog.service.FileUploadService;
import com.jx372.blog.service.UserService;
import com.jx372.blog.vo.UserVo;
import com.jx372.security.AuthUser;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/join")
	public String join(){
		return "user/join";
	}
	
	//회원가입
	@RequestMapping(value="/join", method=RequestMethod.POST )
	public String join(@ModelAttribute UserVo userVo){
		userService.getJoin(userVo);
	
		return  "redirect:/user/joinsuccess"; //redirect
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "user/login";
	}
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(@AuthUser UserVo authUser, 
			Model model){
		UserVo userVo = userService.getUser(authUser.getNo());
		model.addAttribute("userVo",userVo);
	
		return "user/modify";
	}
	
	@RequestMapping( value="/modify", method=RequestMethod.POST )
	public String modify( 
			@AuthUser UserVo authUser, 
			@ModelAttribute UserVo userVo,
			@RequestParam( value="file1" ) MultipartFile file1){
		
		String path = fileUploadService.restore(file1);
		userVo.setPath(path);
		System.out.println(userVo.getPath());
		userVo.setNo( authUser.getNo() );
		userService.modifyUser( userVo );
		
		authUser.setPath(userVo.getPath()); 
			
		return "redirect:/main";
	}
	
}
