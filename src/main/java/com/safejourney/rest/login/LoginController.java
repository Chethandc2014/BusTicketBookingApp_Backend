package com.safejourney.rest.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.safejourney.service.LoginService;

@CrossOrigin(origins="*")
@RestController()
@RequestMapping("/api")
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public ObjectNode login(@RequestParam String userId, @RequestParam String password) {

		return loginService.login(userId, password);

	}

}
