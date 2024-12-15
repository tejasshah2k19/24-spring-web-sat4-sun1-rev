package com.controller;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;
import com.service.MailerService;
import com.service.OtpGeneratorService;

@Controller
public class SessionController {

	@Autowired // get new existing
	UserDao userDao;

	@Autowired
	PasswordEncoder passwordEncoder;// spring -> class -> object -> inject

	@Autowired
	OtpGeneratorService otpGeneratorService;
	
	@Autowired
	MailerService mailerService;
	
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

	@PostMapping("/authentication")
	public String authenticate(UserBean userBean, Model model) {

		UserBean dbUser = userDao.getUserByEmail(userBean.getEmail());
		if (dbUser == null) {
			model.addAttribute("error", "Invalid Credentials");
			return "Login";
		} else {
			boolean status = passwordEncoder.matches(userBean.getPassword(), dbUser.getPassword());
			if (status == true) {
				return "Home";
				// login success
			} else {
				model.addAttribute("error", "Invalid Credentials");
				return "Login";

			}
		}
	}

	@GetMapping(value = { "/", "login" })
	public String login() {
		return "Login";
	}

	@GetMapping("forgetpassword")
	public String forgetPassword() {
		return "ForgetPassword";
	}

	@PostMapping("forgetpassword")
	public String sendOtp(@RequestParam String email,Model model) {
		System.out.println("email => " + email);

		// check db -> email present?
		UserBean user = userDao.getUserByEmail(email);//null 
		// true -> user 
		// false -> null 
		if(user == null) {
			//invalid email 
			model.addAttribute("email",email);
			model.addAttribute("error","Email is not registered with us.");
			return "ForgetPassword";
		}else {
			//otp generate 
			String otp = otpGeneratorService.generateOtp(6);
			//user->db->otp set
			userDao.updateOtp(email,otp);
			//mail send -- gmail 
			mailerService.sendMailForOtp(email, otp);
			
			return "ChangePassword";
		}
		
		
	}

}
