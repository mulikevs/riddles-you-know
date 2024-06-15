package com.sitemapdev.riddles_you_know.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitemapdev.riddles_you_know.entity.Riddle;
import com.sitemapdev.riddles_you_know.repository.RiddleRepository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class GameService {
	
	private String[] randomWords = {"gsggsgs",""};
	
	private char[] allCharactersOfAnswer;
	
		@Autowired
	    private RiddleRepository riddleRepository;

	    public List<Riddle> getAllRiddles() {
	        return riddleRepository.findAll();
	    }

	    public Optional<Riddle> getRiddleById(Long id) {
	        return riddleRepository.findById(id);
	    }
	    
	    public Riddle saveRiddle(Riddle riddle) {
	        return riddleRepository.save(riddle);
	    }
	    
	    public long getRiddleCount() {
	        return riddleRepository.count();
	    }

	    public Optional<Riddle> getRandomRiddle() {
	        long count = getRiddleCount();
	        if (count == 0) {
	            return Optional.empty(); // No riddles in the database
	        }
	        Random random = new Random();
	        int randomIndex = random.nextInt((int) count);
	        List<Riddle> riddles = riddleRepository.findAll();
	        Riddle selectedRiddle = riddles.get(randomIndex);
	     // Log the question and answer of the selected riddle
	        
	       // log.info("Request  ");
	       // log.info("Randomly selected riddle: Question - {}, Answer - {}", selectedRiddle.getQuestion(), selectedRiddle.getAnswer());
	        
	        return Optional.of(selectedRiddle);
	    }

}
