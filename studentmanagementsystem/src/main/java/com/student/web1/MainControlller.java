package com.student.web1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControlller {

	@GetMapping("login")
	public String login() {
		return "login.html";
	}
	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
}
