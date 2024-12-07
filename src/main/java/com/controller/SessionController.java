package com.controller;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

	@Autowired // get new existing
	UserDao userDao;

	@GetMapping("/signup")
	public String signup() {

		return "Signup";// jsp
	}

	@GetMapping("/signup2")
	public String signup2() {
		return "Signup2";// jsp
	}

	@PostMapping("/saveuser")
	public String saveUser(UserBean userBean) {

		System.out.println(userBean.getFirstName());
		System.out.println(userBean.getEmail());
		System.out.println(userBean.getPassword());

		// db call insert
		userDao.saveUser(userBean);

		return "Login";
	}

	@PostMapping("saveuser2")
	public String saveUserWithProfile(UserBean userBean) {
		System.out.println(userBean.getEmail());// text
		System.out.println(userBean.getProfile().getOriginalFilename());

		// server -> profile pic -> profile ->
		// copy profile -> webapp -> images ->

		// profile bytes copy -> file paste

		try {
			File file = new File("C:\\sts\\24-spring-web-sat4-sun1-rev\\src\\main\\webapp\\images",
					userBean.getProfile().getOriginalFilename());//logical 
			FileUtils.writeByteArrayToFile(file, userBean.getProfile().getBytes());//logical,bytes
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Login";
	}

}
