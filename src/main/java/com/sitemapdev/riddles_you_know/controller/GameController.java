package com.sitemapdev.riddles_you_know.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
	
	
	@GetMapping("/riddles-you-know")
	public String showGameHomePage(){
		
		return "Home Page";
	}

}
