package com.thaseen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.thaseen.entity.User;
import com.thaseen.repository.UserRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// getting and returning obj from User
	 User user =userrepo.findByEmail(username);
		
	 if(user==null) 
	 {
		  throw new UsernameNotFoundException("User not found");
		  
	 }
	 else {
		 return new CustomUser(user);
	 }
		
	}
	
	

}
