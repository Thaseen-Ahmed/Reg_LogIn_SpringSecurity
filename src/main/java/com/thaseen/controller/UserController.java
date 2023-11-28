package com.thaseen.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thaseen.entity.User;
import com.thaseen.repository.UserRepo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepo urepo;
	
	@ModelAttribute
	public void commonUser(Principal p,Model mo) 
	{
		if(p!=null) {
		String email= p.getName();
		User user = urepo.findByEmail(email);
		mo.addAttribute("user",user);
		}
		
	}

	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
}
