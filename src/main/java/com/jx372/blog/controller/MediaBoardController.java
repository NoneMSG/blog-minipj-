package com.jx372.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jx372.blog.service.FileUploadService;
import com.jx372.blog.service.MediaBoardService;
import com.jx372.blog.vo.MediaBoardVo;
import com.jx372.blog.vo.UserVo;
import com.jx372.security.Auth;
import com.jx372.security.AuthUser;

@Controller
@RequestMapping("/mediaboard")
public class MediaBoardController {
	
	@Autowired
	private MediaBoardService mediaboardService;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("")
	public String list(
			@RequestParam(value="p", required=true, defaultValue="1")Integer page,
			@RequestParam(value="kwd", required=true, defaultValue="")String kwd,
			Model model
			){
		Map<String, Object> map = mediaboardService.getMessageList( page, kwd );
		model.addAttribute( "map", map );
		return "mediaboard/list";
	}
	
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(@AuthUser UserVo authUser){
		
		return "/mediaboard/write";
	}
	
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(
			@AuthUser UserVo authUser,
			@ModelAttribute MediaBoardVo mediaBoardvo,
			@RequestParam(value="file") MultipartFile file){

		String filePath="noFile";
		String extName ="noType";
		if(file.getSize()!=0 && file.getSize()>0){
			filePath = fileUploadService.restore(file);
			extName = filePath.substring( filePath.lastIndexOf( '.' ), filePath.length());
		}

		mediaBoardvo.setUserNo(authUser.getNo());
		mediaBoardvo.setPath(filePath);
		mediaBoardvo.setFileType(extName);

		mediaboardService.getWrite(mediaBoardvo);
		return "redirect:/mediaboard";
	}
	
	@RequestMapping("/view{no}")
	public String contentView(
			@PathVariable("no")Long no,
			Model model
			){
		MediaBoardVo mbvo = (MediaBoardVo)mediaboardService.getContentView(no);
		mediaboardService.increaseHit(no);
		model.addAttribute("mbvo",mbvo);
		return "/mediaboard/view";
	}
	
	
	@RequestMapping("/delete/{no}")
	public String delete(
			@PathVariable("no") Long no,
			@AuthUser UserVo authUser
			){
		MediaBoardVo mbvo = new MediaBoardVo();
		mbvo.setNo(no);
		mbvo.setUserNo(authUser.getNo());
		//System.out.println(mbvo);
		mediaboardService.getDelete(mbvo);
		return "redirect:/mediaboard";
	}
	
}
