package com.prueba.cleancode.controller;

import com.prueba.cleancode.model.User;

public class UserController {
	
	public User infoUser(User user) {
		return user;
	}
	
	public User Edit(String name, double balance, User user) {
		user.setBalance(balance);
		user.setNombre(name);
		return user;
	}

	
}