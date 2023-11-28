package com.thaseen.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.thaseen.entity.User;
import com.thaseen.repository.UserRepo;
import com.thaseen.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserService userv;
	
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
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/signin")
	public String login() {
		return "login";
	}
	
//	@GetMapping("/user/profile")
//	public String profile(Principal p,Model m) {
//		String email = p.getName();
//		User user = urepo.findByEmail(email);
//		m.addAttribute("user",user);
//	
//		return "profile";
//	}
//	
//	@GetMapping("/user/home")
//	public String home() {
//		return "home";
//	}
	
	//getting the values and saving it 
	@PostMapping("/createUser")
	public String saveUser(@ModelAttribute User user,HttpSession session) {
		
//		System.out.println(user);
		
		User u = userv.saveUser(user);
		
		if(u!=null) {
//			System.out.println("Save Success");
			session.setAttribute("msg", "User Registered Successfully");
			
		}
		else {
			session.setAttribute("msg", "Something Wrong on Server");
//			System.out.println("Error in server ");
		}
		
		return "redirect:/register";
	}
	
	
}
