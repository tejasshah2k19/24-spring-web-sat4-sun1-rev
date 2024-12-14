package com.controller;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

	@Autowired // get new existing
	UserDao userDao;

	@Autowired
	PasswordEncoder passwordEncoder;//spring -> class -> object -> inject 

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

		// get file type ->
		String fileType = userBean.getProfile().getContentType();

		if (!fileType.startsWith("image")) {
			return "Signup2";
		}

		try {
			File file = new File("C:\\sts\\24-spring-web-sat4-sun1-rev\\src\\main\\webapp\\images",
					userBean.getProfile().getOriginalFilename());// logical
			FileUtils.writeByteArrayToFile(file, userBean.getProfile().getBytes());// logical,bytes

			userBean.setProfilePath("images/" + userBean.getProfile().getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}

		String encPassword = passwordEncoder.encode(userBean.getPassword());
		System.out.println(encPassword);
		System.out.println(encPassword.length());

		userBean.setPassword(encPassword);

		userDao.saveUser(userBean);

		return "Login";
	}

}
