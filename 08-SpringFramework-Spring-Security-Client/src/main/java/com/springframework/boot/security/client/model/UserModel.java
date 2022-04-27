package com.springframework.boot.security.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String matchingPassword;
}
