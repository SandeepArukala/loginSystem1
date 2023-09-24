package com.student.web1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.Service.UserService;
import com.student.web.dto.UserRegistrationDTO;

@Controller
@RequestMapping("/registration")
public class UserRegistationController {

	
	private UserService userService;

	public UserRegistationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegistrationDTO userRegistrationDTO() {
		return new UserRegistrationDTO();
	}
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO registrationDTO) {
		userService.save(registrationDTO);
		return  "redirect:/registration?success";
	}
	}
