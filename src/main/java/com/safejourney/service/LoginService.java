package com.safejourney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.safejourney.dao.LoginDao;
import com.safejourney.entity.User;
import com.safejourney.util.AppUtil;

@Service
public class LoginService {

	@Autowired
	LoginDao baseDao;

	public ObjectNode login(String userId, String password) {

		ObjectNode node = AppUtil.getObjectNodeInstance();
		try {

			Optional<User> findById = baseDao.findById(userId);
			if (findById.isPresent()) {
				User user = (User) findById.get();
				if (user.getPassword().equals(password)) {
					node.put("isLoginSuccess", true);
				} else {
					throw new Exception("Password is incorrect..");
				}

			} else {
				throw new Exception("UserId is wrong...");
			}
		} catch (Exception e) {
			node.put("isLoginSuccess", false);
			node.put("message", e.getMessage());
		}

		return node;

	}

}
