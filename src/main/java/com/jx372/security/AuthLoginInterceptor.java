package com.jx372.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jx372.blog.service.UserService;
import com.jx372.blog.vo.UserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter{
	
	//컨테이너에서 관리하는 객체에 의해서 userService를 사용 가능 자동 주입해줌 근데 web application context로 가서 저장이됨
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {

			String email =request.getParameter("email");
			String password = request.getParameter("password");
			
			UserVo userVo = userService.getUser(email, password);
			System.out.println("=================");
			System.out.println(userVo);
			if(userVo==null){
				response.sendRedirect(request.getContextPath()+"/user/login?result=fail");
				return false;
			}
			
			//login성공 처리 session에 authUser를 넘겨버리고 redirect시킴 데이터를 굳이 메서드로 접근시킬필요 없다.
			HttpSession session  = request.getSession(true);
			session.setAttribute("authUser", userVo);
			response.sendRedirect(request.getContextPath()+"/main");
			return false;
	}

}
