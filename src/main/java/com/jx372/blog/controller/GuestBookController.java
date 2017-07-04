package com.jx372.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jx372.blog.vo.GuestBookVo;
import com.jx372.blog.vo.UserVo;
import com.jx372.security.AuthUser;
import com.jx372.blog.service.GuestBookService;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {

	@Autowired
	private GuestBookService guestbookService;
	
	@RequestMapping("")
	public String list(Model model){
		List<GuestBookVo> list = guestbookService.getContentList();
		//System.out.println(list);
		model.addAttribute("gbList", list);
		return "guestbook/list";
	}
	
	@RequestMapping("/write")
	public String writing(@ModelAttribute GuestBookVo guestBookVo){
		//System.out.println(guestBookVo);
		guestbookService.getWriting(guestBookVo);
		return "redirect:/guestbook";
	}
	
	@RequestMapping("/delete/{no}")
	public String deleting(@PathVariable("no") Long no,Model model){
		model.addAttribute("no",no);
		return "/guestbook/delete";
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleting(@ModelAttribute GuestBookVo guestBookVo){
		guestbookService.getDeleting(guestBookVo);
		return "redirect:/guestbook";
	}
	
	@RequestMapping("/deletebyadmin/{no}")
	public String deleteByAdmin(@AuthUser UserVo authUser,@PathVariable("no") Long no){
		guestbookService.getAdminDelete(authUser.getRole(), no);
		
		return "redirect:/guestbook";
	}
	
}
