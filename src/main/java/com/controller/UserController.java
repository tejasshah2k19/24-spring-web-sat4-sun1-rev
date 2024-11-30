package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	// get all users
	// db -> users read -> jsp -> print
	@GetMapping("/listusers")
	public String listUsers(Model model) {

		// db -> users ->read -> send -> jsp ->

		List<UserBean> users = userDao.getAllUsers();
		// how to send data to jsp
		// request.setAttribute("users",users);
		// Model -> spring.ui

		model.addAttribute("users", users);

		return "ListUser";
	}

	@GetMapping("deleteuser")
	public String deleteUser(@RequestParam("userId") Integer userId) {
		userDao.deleteUser(userId);

		return "redirect:/listusers";// call url - instead of jsp
	}

	@GetMapping("edituser")
	public String editUser(@RequestParam("userId") Integer userId,Model model) {
		// read data from db
		UserBean user = userDao.getUserByUserId(userId);

		// jsp send
		model.addAttribute("user",user);
		return "EditUser";
	}
	
	@PostMapping("updateuser")
	public String updateUser(UserBean user) {//firstName email userId
		
		//db update 
		
		//update users set firstName = ? , email = ? where userId = ? 
		userDao.updateUser(user);
		return "redirect:/listusers";
	}

}
