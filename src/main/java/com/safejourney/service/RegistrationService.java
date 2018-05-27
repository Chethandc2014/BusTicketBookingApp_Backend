package com.safejourney.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.safejourney.dao.RegisterationDao;
import com.safejourney.dto.UserDto;
import com.safejourney.entity.City;
import com.safejourney.entity.Country;
import com.safejourney.entity.State;
import com.safejourney.entity.User;
import com.safejourney.util.AppUtil;

@Service
public class RegistrationService {

	@Autowired
	private RegisterationDao registerationDao;

	@Autowired
	private EntityManager entityManager;

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

	public List<Country> getCountryList() {

		List<Country> countryList = entityManager.createNamedQuery("getAllCountries").getResultList();
		return countryList;
	}

	public List<State> getStateList(String countryCode) {
		List<State> stateList = entityManager.createNamedQuery("findStateByCountryId")
				.setParameter("countryId", countryCode).getResultList();
		return stateList;
	}

	public List<City> getCityList(String stateCode) {

		List<City> cityList = entityManager.createNamedQuery("findCityByStateId").setParameter("stateId", stateCode)
				.getResultList();

		return cityList;
	}

}
