package com.springboot.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TestController {
	
	@GetMapping("/")
	public String wish() {
		return "<h1>Welcome to Spring Security</h1>"+
			   "<br><a href='/principal'>Click here for Principal Portal</a>"+
			   "<br><a href='/teacher'>Click here for Teacher Portal</a>";
	}
	
	@GetMapping("/principal")
	public String principal() {
		return "<h1>WELCOME TO Principal PORTAL</h1>"+
			   "<br><a href='/logout'>Click here to logout</a>";
	}
	
	@GetMapping("/teacher")
	public String teacher() {
		return "<h1>WELCOME TO Teacher PORTAL</h1>"+
			   "<br><a href='/logout'>Click here to logout</a>";
	}
}
