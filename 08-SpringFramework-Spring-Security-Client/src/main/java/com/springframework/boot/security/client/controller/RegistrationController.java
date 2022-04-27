package com.springframework.boot.security.client.controller;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.boot.security.client.entity.User;
import com.springframework.boot.security.client.entity.VerificationToken;
import com.springframework.boot.security.client.event.RegistrationCompleteEvent;
import com.springframework.boot.security.client.model.PasswordModel;
import com.springframework.boot.security.client.model.UserModel;
import com.springframework.boot.security.client.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest httpServletRequest) {
		
		User user = userService.registerUser(userModel);
		eventPublisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(httpServletRequest)));
		
		return "SUCCESS";
	}
	
	@GetMapping("/verifyRegistartion")
	public String verifyRegistartion(@RequestParam("token") String token) {
		
		String result = userService.validateVerificationToken(token);
		
		if(result.equalsIgnoreCase("valid")) {
			return "User Verified Successfully.";
		}
		
		return "Bad User";
	}

	@GetMapping("/resendVerifyToken")
	public String resendVerificationToken(@RequestParam("token") String oldToken, HttpServletRequest servletRequest) {
		
		VerificationToken verificationToken = userService.generateNewVerificationToken(oldToken);
		
		User user = verificationToken.getUser();
		resendVerificationToken(user, applicationUrl(servletRequest), verificationToken);
		
		return "Verification Link Sent.";
		
	}
	
	@PostMapping("/resetPassword")
	public String resetPassword(@RequestBody PasswordModel passwordModel, HttpServletRequest servletRequest) {

		User user = userService.findUserByEmail(passwordModel.getEmail());
		String url = "";
		
		if(Objects.nonNull(user)) {
			String token = UUID.randomUUID().toString();
			userService.createPasswordTokenForUser(user, token);
			url = passwordResetTokenMial(user, applicationUrl(servletRequest), token);
		}
		return url;
		
	}
	
	@PostMapping("/savePassword")
	public String savePassword(@RequestParam("token") String token, @RequestBody PasswordModel passwordModel) {

		String result = userService.validatePasswordResetToken(token);
		
		if(!result.equalsIgnoreCase("valid")) {
			return "Invalid Token";
		}
		
		Optional<User> user = userService.getUserByPasswordResetToken(token);
		
		if(user.isPresent()) {
			userService.changepassword(user.get(), passwordModel.getNewPassword());
			return "Password Reset Successfully.";
		}else {
			return "Invalid Token";
		}
		
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestBody PasswordModel passwordModel) {
		User user = userService.findUserByEmail(passwordModel.getEmail());
		if(!userService.checkIfOldPasswordValid(user, passwordModel.getOldPassword())) {
			return "Invalid Old Password";
		}
		
		// Save New Password
		userService.changepassword(user, passwordModel.getNewPassword());
		return "Password Changed Successfully.";
	}
	
	private String passwordResetTokenMial(User user, String applicationUrl, String token) {

		String url = applicationUrl + "/savePassword?token=" + token;

		log.info("Click the link to Reset your Password : {}", url);
		return url;
	}

	private void resendVerificationToken(User user, String applicationUrl, VerificationToken verificationToken) {

		String url = applicationUrl + "/verifyRegistartion?token=" + verificationToken.getToken();
		
		log.info("Click the link to verify your account : {}", url);
		
	}

	private String applicationUrl(HttpServletRequest httpServletRequest) {

		return "http://" + httpServletRequest.getServerName() +
				":" + httpServletRequest.getServerPort() + httpServletRequest.getContextPath();
	}
}
