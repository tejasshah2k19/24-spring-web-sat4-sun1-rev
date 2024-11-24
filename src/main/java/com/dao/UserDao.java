package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbc;

	// query {select}
	// update {insert,delete,update}
	// queryForObject {select}

	public void saveUser(UserBean userBean) {
		jdbc.update("insert into users (firstName,email,password) values (?,?,?)", userBean.getFirstName(),
				userBean.getEmail(), userBean.getPassword());
	}

}
