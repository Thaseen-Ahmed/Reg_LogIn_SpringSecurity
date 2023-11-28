package com.thaseen.service;


import java.util.List;

import com.thaseen.entity.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public void removeSessionMessage();
	
	public List<User> viewAll(); 
	
}
