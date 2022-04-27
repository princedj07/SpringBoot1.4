package com.springframework.boot.security.client.listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.springframework.boot.security.client.entity.User;
import com.springframework.boot.security.client.event.RegistrationCompleteEvent;
import com.springframework.boot.security.client.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>{

	@Autowired
	private UserService userService;
	
	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {

		// Create Verification Token
		User user = event.getUser();
		String token = UUID.randomUUID().toString();
		userService.saveVerificationTokenForUser(token, user);

		// Sent mail to user
		String url = event.getApplicationURL() + "/verifyRegistartion?token=" + token;
		
		log.info("Click the link to verify your account {} ", url);
	}

}
