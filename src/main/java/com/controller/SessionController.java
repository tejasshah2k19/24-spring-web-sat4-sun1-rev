package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;
	
	@GetMapping("/signup")
	public String signup() {
		
		return "Signup";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(UserBean userBean) {
		
		System.out.println(userBean.getFirstName());
		System.out.println(userBean.getEmail());
		System.out.println(userBean.getPassword());
		
		//db call insert 
		userDao.saveUser(userBean);
		
		return "Login";
	}
}
