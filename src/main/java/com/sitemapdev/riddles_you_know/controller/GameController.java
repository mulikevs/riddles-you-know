package com.sitemapdev.riddles_you_know.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sitemapdev.riddles_you_know.entity.Riddle;
import com.sitemapdev.riddles_you_know.service.GameService;

@Controller
public class GameController {
    
    @Autowired
    private GameService riddleService;
    private char[] allCharactersOfAnswer;
    private String currentAnswer;
    private int maxRetries = 5;
    private int retries = 0;
    private boolean guessedCorrectly = false;

    @GetMapping("/riddles-you-know")
    public String showGameHomePage(Model model) {
        Optional<Riddle> riddle = riddleService.getRandomRiddle();
        if (riddle.isPresent()) {
            String question = riddle.get().getQuestion();
            String answer = riddle.get().getAnswer();
            model.addAttribute("question", question);
            
            if (allCharactersOfAnswer == null || currentAnswer == null || !currentAnswer.equals(answer)) {
                allCharactersOfAnswer = new char[answer.length()];
                currentAnswer = answer;
                retries = 0;
                guessedCorrectly = false;
            }
            
            model.addAttribute("answer", toMyString());
            model.addAttribute("retries", retries);
            model.addAttribute("maxRetries", maxRetries);
            model.addAttribute("guessedCorrectly", guessedCorrectly);
            return "riddles-you-know"; // Assuming the view name is 'riddles-you-know'
        } else {
            model.addAttribute("question", "Leo Hakuna Maswali");
            return "riddles-you-know"; // Assuming the view name is 'riddles-you-know'
        }
    }

    @PostMapping("/guess")
    @ResponseBody
    public String handleGuess(@RequestParam("guessedChar") char guessedChar) {
        if (currentAnswer != null) {
            boolean correctGuess = addGuess(Character.toLowerCase(guessedChar), currentAnswer.toLowerCase());
            if (!correctGuess) {
                retries++;
            }
            if (retries >= maxRetries) {
                return "You've reached the maximum number of retries!";
            }
            if (isAnswerComplete()) {
                guessedCorrectly = true;
                return "Congratulations! You've guessed the correct answer: " + currentAnswer;
            }
            return toMyString();
        }
        return "";
    }

    private boolean addGuess(char guessedChar, String answer) {
        boolean correctGuess = false;
        for (int i = 0; i < answer.length(); i++) {
            if (guessedChar == answer.charAt(i)) {
                allCharactersOfAnswer[i] = currentAnswer.charAt(i); // Preserve the original case
                correctGuess = true;
            }
        }
        return correctGuess;
    }

    private boolean isAnswerComplete() {
        for (char c : allCharactersOfAnswer) {
            if (c == '\u0000') {
                return false;
            }
        }
        return true;
    }

    private String toMyString() {
        StringBuilder ret = new StringBuilder();
        for (char c : allCharactersOfAnswer) {
            if (c == '\u0000') {
                ret.append("_ ");
            } else {
                ret.append(c).append(" ");
            }
        }
        return ret.toString().trim();
    }
}
