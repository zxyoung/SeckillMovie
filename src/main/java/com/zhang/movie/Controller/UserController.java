package com.zhang.movie.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhang.movie.Service.UserService;

@Controller
@RequestMapping("/person.do")
public class UserController {
	
	@Autowired
	@Qualifier("UserServiceImpl")
	UserService userService;
	
	@RequestMapping(params="method=login")
	public String login(HttpSession session){
		String email = (String) session.getAttribute("email");
		if(email == null){
			//��¼ʧ�����µ�¼
			return "index";
		}
		//�ɹ���������ҳ
		return "success";
	}
	
	
}
