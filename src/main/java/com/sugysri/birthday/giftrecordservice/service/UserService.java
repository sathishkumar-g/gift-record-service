package com.sugysri.birthday.giftrecordservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sugysri.birthday.giftrecordservice.models.ServiceConstants;
import com.sugysri.birthday.giftrecordservice.models.UserDTO;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ServiceConstants serviceConstants;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	/*
	 * public UserDTO getUserRecord(UserDTO user) { return
	 * restTemplate.postForObject(serviceConstants.authUrl, user, UserDTO.class); }
	 */

	public UserDTO addUserRecord(UserDTO user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return restTemplate.postForObject(serviceConstants.registerUrl, user, UserDTO.class);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		UserDTO user = null;
		user = restTemplate.postForObject(serviceConstants.authUrl, userName, UserDTO.class);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());
	}

}
