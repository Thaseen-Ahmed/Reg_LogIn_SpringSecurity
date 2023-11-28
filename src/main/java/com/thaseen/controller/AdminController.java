package com.thaseen.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thaseen.entity.User;
import com.thaseen.repository.UserRepo;
import com.thaseen.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserRepo urepo;
	
	@Autowired
	private UserService userService;
	
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
		return "admin_profile";
	}
	
	  @GetMapping("/User-Details")
      public String home(Model model){
//          ModelAndView mv = new ModelAndView("User-Details");
//          List<User> userlist = userService.viewAll();
//          mv.addObject("userlist", userlist);
//          return mv;
		  model.addAttribute("ListUser",userService.viewAll());
			return "User-Details";
		}
//	
//	@GetMapping("/User-Details")
//	public String Users() {
//
//		return "User-Details";
//	}
}

