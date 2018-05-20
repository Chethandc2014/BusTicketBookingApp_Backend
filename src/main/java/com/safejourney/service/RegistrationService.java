package com.safejourney.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.safejourney.dao.RegisterationDao;
import com.safejourney.dto.UserDto;
import com.safejourney.entity.User;
import com.safejourney.util.AppUtil;

@Service
public class RegistrationService {

	@Autowired
	private RegisterationDao registerationDao;

	public void register(UserDto userDto) {

		User user = convertToEntity(userDto);
		registerationDao.save(user);

	}

	private User convertToEntity(UserDto dto) {
		User user = new User();
		user.setUserId(dto.getEmailId());
		user.setFirstName(dto.getFirstName());
		user.setMiddleName(dto.getMiddleName());
		user.setLastName(dto.getLastName());
		user.setMobileNo(dto.getMobileNo());
		user.setEmailId(dto.getEmailId());
		return user;
	}

	public ObjectNode setPassword(UserDto userDto) {
		ObjectNode node = AppUtil.getObjectNodeInstance();
		// TODO Auto-generated method stub
		Optional<User> findById = registerationDao.findById(userDto.getEmailId());

		if (findById.isPresent()) {

			User user = findById.get();
			user.setPassword(userDto.getPassword());
			registerationDao.save(user);
		} else {
			node.put("message", "User Id does't exist. Please register before..");
		}
		
		return node;
	}

}
