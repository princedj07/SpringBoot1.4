package com.springframework.boot.security.client.service;

import java.util.Optional;

import com.springframework.boot.security.client.entity.User;
import com.springframework.boot.security.client.entity.VerificationToken;
import com.springframework.boot.security.client.model.UserModel;

public interface UserService {

	User registerUser(UserModel userModel);

	void saveVerificationTokenForUser(String token, User user);

	String validateVerificationToken(String token);

	VerificationToken generateNewVerificationToken(String oldToken);

	User findUserByEmail(String email);

	void createPasswordTokenForUser(User user, String token);

	String validatePasswordResetToken(String token);

	Optional<User> getUserByPasswordResetToken(String token);

	void changepassword(User user, String newPassword);

	boolean checkIfOldPasswordValid(User user, String oldPassword);

}
