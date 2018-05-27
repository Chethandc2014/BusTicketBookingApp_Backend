package com.safejourney.rest.registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.safejourney.dto.UserDto;
import com.safejourney.entity.City;
import com.safejourney.entity.Country;
import com.safejourney.entity.State;
import com.safejourney.service.RegistrationService;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/api")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(path = "/register", method = RequestMethod.POST, consumes = { "application/JSON" })
	public ObjectNode register(@RequestBody UserDto userDto) {

		registrationService.register(userDto);
		System.out.println(userDto.toString());
		return null;
	}

	@RequestMapping(path = "/set-password", method = RequestMethod.POST, consumes = { "application/JSON" })
	public ObjectNode setPassword(@RequestBody UserDto userDto) {

		ObjectNode response = registrationService.setPassword(userDto);
		return response;
	}

	@RequestMapping(path = "/country", method = RequestMethod.GET, consumes = { "application/JSON" })
	public List<Country> getCountryList() {

		return registrationService.getCountryList();
	}

	@RequestMapping(path = "/country/{country_code}/state", method = RequestMethod.GET, consumes = { "application/JSON" })
	public List<State> getStateList(@PathVariable(name = "country_code") String countryCode) {

		return registrationService.getStateList(countryCode);
	}

	@RequestMapping(path = "/country/{country_code}/state/{state_code}", method = RequestMethod.GET, consumes = {
			"application/JSON" })
	public List<City> getCityList(@PathVariable(name = "state_code") String stateCode) {

		return registrationService.getCityList(stateCode);
	}

}
