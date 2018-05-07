package com.safejourney.rest.registration;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.safejourney.dto.UserDto;

@RestController
public class RegistrationController {
	
	
	
	
	public ObjectNode register(@RequestBody UserDto userDto){
		
	
		System.out.println(userDto.toString());
		return null;
	}

}
