package com.springframework.boot.security.client.event;

import org.springframework.context.ApplicationEvent;

import com.springframework.boot.security.client.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	
	private User user;
	private String applicationURL;

	public RegistrationCompleteEvent(User user, String applicationURL) {
		super(user);
		this.user = user;
		this.applicationURL = applicationURL;
	}

}
