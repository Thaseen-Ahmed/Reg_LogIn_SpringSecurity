package com.thaseen.service;

import com.thaseen.entity.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public void removeSessionMessage();

}
