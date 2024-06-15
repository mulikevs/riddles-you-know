package com.sitemapdev.riddles_you_know.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sitemapdev.riddles_you_know.entity.Riddle;
import com.sitemapdev.riddles_you_know.service.GameService;
import com.sitemapdev.riddles_you_know.util.ProjectUtility;

@Controller
public class GameController {
	
	@Autowired
    private GameService riddleService;
	private char[] allCharactersOfAnswer;
	
	
	@GetMapping("/riddles-you-know")
	public String showGameHomePage(Model model){
		
		
		
		 Optional<Riddle> riddle = riddleService.getRandomRiddle();
	        if (riddle.isPresent()) {
	  
	            String question = riddle.get().getQuestion();
	            String answer = riddle.get().getAnswer();
	            

	            
	            allCharactersOfAnswer = new char[answer.length()];
	            
	            model.addAttribute("question", question);
	            model.addAttribute("answer", answer);
	            
	            return "/riddles-you-know";
	        } else {
	        	model.addAttribute("question", "Leo Hakuna Maswali");
	        	return "/riddles-you-know";
	        }
		
		
	}
	
	public String toString() {
		
		String ret = "";
		
		for(char c: allCharactersOfAnswer) {
			if(c == '\u0000') {
				ret = ret + "_";
			}
			ret = ret + " ";
		}
		return ret;
	}

}
