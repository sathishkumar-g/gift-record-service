package com.sugysri.birthday.giftrecordservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sugysri.birthday.giftrecordservice.models.UserDetails;

@Service
public class UserService {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${user.authenticate.url}")
	private String authUrl;

	public UserDetails getUserRecord(UserDetails userDetails) {
		/*
		 * userDetails = restTemplate.postForObject(
		 * "https://get-gift-record-service.herokuapp.com/user/authenticate",
		 * userDetails, UserDetails.class);
		 */

		userDetails = restTemplate.postForObject(authUrl, userDetails, UserDetails.class);
		return userDetails;
	}

}
