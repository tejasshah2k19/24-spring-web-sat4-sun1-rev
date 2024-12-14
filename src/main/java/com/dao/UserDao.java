package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {
	// IoC
	@Autowired // spring -> get -> JdbcTemplate instance -> new | existing
	JdbcTemplate jdbc;

	// query {select}
	// update {insert,delete,update}
	// queryForObject {select}

	public void saveUser(UserBean userBean) {
		jdbc.update("insert into users (firstName,email,password,profilePath) values (?,?,?,?)", userBean.getFirstName(),
				userBean.getEmail(), userBean.getPassword(),userBean.getProfilePath());
	}

	public List<UserBean> getAllUsers() {

		List<UserBean> users = jdbc.query("select * from users", new BeanPropertyRowMapper<>(UserBean.class));
		return users;
	}

	public void deleteUser(Integer userId) {
		jdbc.update("delete from users where userId = ? ", userId);
	}

	public UserBean getUserByUserId(Integer userId) {
		UserBean user = jdbc.queryForObject("select * from users where userId=  ?  ",
				new BeanPropertyRowMapper<>(UserBean.class), new Object[] { userId });
		return user;
	}

	public void updateUser(UserBean user) {
		jdbc.update("update users set firstName = ? , email = ? where userId = ? ", user.getFirstName(),
				user.getEmail(), user.getUserId());
	}

}

//when JdbcTemplate init -> allocate -> 
//early | late 

//web.xml -> spring -> filter 
//DispatcherServlet 
//no xml 
