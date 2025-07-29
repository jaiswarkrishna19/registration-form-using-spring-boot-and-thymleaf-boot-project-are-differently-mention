package in.sp.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.entities.User;
import in.sp.main.services.UserService;

@Controller
public class MyController {
	
	@Autowired
	private UserService userService;
	
     @GetMapping("/regPage")
	public String openRegPage(Model model)
	{
    	 model.addAttribute("user", new User());
		return "register";
	}
     
     @PostMapping("/regForm")
     public String submitRegForm(@ModelAttribute("user") User user,Model model) {
    	  boolean status = userService.registerUser(user);
    	  
    	  if(status) {
    		  model.addAttribute("successMsg", "User registered successfully");
    	  }
    	  else {
    		  model.addAttribute("errorMsg", "User not registered due to some error");
    	  }
		return "register";
    	 
     }
     @GetMapping("/loginPage")
     public String openLoginPage(Model model) {
    	 model.addAttribute("user", new User());
		return "login";
    	 
     }
     
     @PostMapping("/loginForm")
     public String submitLoginForm(@ModelAttribute("user") User user, Model model ) {
         System.out.println("User input email: " + user.getEmail());
         System.out.println("User input password: " + user.getPassword());

         User validUser = userService.loginUser(user.getEmail().trim(), user.getPassword().trim());

         if(validUser != null) {
             return "profile";
         } else {
             model.addAttribute("errorMsg", "email id and password didn't matched");
             return "login";
         }
     }

    	
    	 
     
}
