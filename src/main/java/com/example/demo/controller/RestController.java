package com.example.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {

	@GetMapping("/")
	public String get(Model model) {
		model.addAttribute("date", new Date());
		model.addAttribute("src","/icons/banana1.jpg");
		return "Hello";
	}
	
	@GetMapping("/images")
	public String getImage(Model model) {
		model.addAttribute("date", new Date());
		model.addAttribute("src","/icons/banana1.jpg");
		return "HelloImage";
	}
	
	@GetMapping("/welcome")
	public String getWelcomePage(Model model) {
		model.addAttribute("date", new Date());
		return "welcome";
	}
}
