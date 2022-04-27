package com.springframework.boot.security.client.service;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springframework.boot.security.client.entity.PasswordResetToken;
import com.springframework.boot.security.client.entity.User;
import com.springframework.boot.security.client.entity.VerificationToken;
import com.springframework.boot.security.client.model.UserModel;
import com.springframework.boot.security.client.repository.PasswordRestTokenRepository;
import com.springframework.boot.security.client.repository.UserRepository;
import com.springframework.boot.security.client.repository.VerificationTokenRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Autowired
	private PasswordRestTokenRepository passwordRestTokenRepository; 
	
	@Override
	public User registerUser(UserModel userModel) {

		User user = new User();
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setEmail(userModel.getEmail());
		user.setRole("USER");
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));

		userRepository.save(user);

		return user;
	}

	@Override
	public void saveVerificationTokenForUser(String token, User user) {

		VerificationToken verificationToken = new VerificationToken(user, token);

		verificationTokenRepository.save(verificationToken);
	}

	@Override
	public String validateVerificationToken(String token) {

		VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
		
		if(verificationToken == null) {
			return "invalid";
		}
		
		User user = verificationToken.getUser();
		Calendar calendar = Calendar.getInstance();
		
		if((verificationToken.getExpirationTime().getTime() -  calendar.getTime().getTime()) <=0 ) {
			verificationTokenRepository.delete(verificationToken);
			return "expired";
		}
		
		user.setEnabled(true);
		userRepository.save(user);

		return "valid";
		
	}

	@Override
	public VerificationToken generateNewVerificationToken(String oldToken) {

		VerificationToken verificationToken = verificationTokenRepository.findByToken(oldToken);
		verificationToken.setToken(UUID.randomUUID().toString());
		verificationTokenRepository.save(verificationToken);
		
		return verificationToken;
		
	}

	@Override
	public User findUserByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	@Override
	public void createPasswordTokenForUser(User user, String token) {
		
		PasswordResetToken passwordResetToken = new PasswordResetToken(user, token);
		passwordRestTokenRepository.save(passwordResetToken);
	}

	@Override
	public String validatePasswordResetToken(String token) {

		PasswordResetToken passwordResetToken = passwordRestTokenRepository.findByToken(token);
		
		if(passwordResetToken == null) {
			return "invalid";
		}
		
//		User user = passwordResetToken.getUser();
		passwordResetToken.getUser();
		Calendar calendar = Calendar.getInstance();
		
		if((passwordResetToken.getExpirationTime().getTime() -  calendar.getTime().getTime()) <=0 ) {
			passwordRestTokenRepository.delete(passwordResetToken);
			return "expired";
		}

		return "valid";
	}

	@Override
	public Optional<User> getUserByPasswordResetToken(String token) {

		return Optional.ofNullable(passwordRestTokenRepository.findByToken(token).getUser());
	}

	@Override
	public void changepassword(User user, String newPassword) {

		user.setPassword(passwordEncoder.encode(newPassword));
		userRepository.save(user);
		
	}

	@Override
	public boolean checkIfOldPasswordValid(User user, String oldPassword) {

		return passwordEncoder.matches(oldPassword, user.getPassword());
	}

}
