package com.jx372.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mediaboard")
public class MediaBoardController {
	
	@RequestMapping("")
	public String list(){
		
		return "/mediaboard/list";
	}
}
