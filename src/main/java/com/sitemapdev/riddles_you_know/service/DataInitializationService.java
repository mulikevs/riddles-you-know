package com.sitemapdev.riddles_you_know.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sitemapdev.riddles_you_know.entity.Riddle;
import com.sitemapdev.riddles_you_know.repository.RiddleRepository;

import jakarta.annotation.PostConstruct;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializationService {

    @Autowired
    private RiddleRepository riddleRepository;

    @PostConstruct
    public void initData() {
        List<Riddle> riddles = Arrays.asList(
            new Riddle(null, "What has to be broken before you can use it?", "An egg"),
            new Riddle(null, "What month of the year has 28 days?", "All of them"),
            new Riddle(null, "What is full of holes but still holds water?", "A sponge"),
            new Riddle(null, "What can you break, even if you never pick it up or touch it?", "A promise"),
            new Riddle(null, "What goes up but never comes down?", "Your age"),
            new Riddle(null, "What gets wet while drying?", "A towel"),
            new Riddle(null, "What can you keep after giving to someone?", "A promise"),
            new Riddle(null, "I shave every day, but my beard stays the same. What am I?", "A barber"),
            new Riddle(null, "I have branches, but no fruit, trunk, or leaves. What am I?", "A bank"),
            // new Riddle(null, "What can't talk but will reply when spoken to?", "An echo"),
            new Riddle(null, "The more of this there is, the less you see. What is it?", "Darkness"),
            // new Riddle(null, "What has many keys but can't open a single lock?", "A piano"),
            new Riddle(null, "What is black when it's clean and white when it's dirty?", "A blackboard"),
            new Riddle(null, "What gets bigger when more is taken away?", "A hole"),
            new Riddle(null, "What invention lets you look right through a wall?", "A window"),
            // new Riddle(null, "What can't be put in a saucepan?", "Its lid"),
            new Riddle(null, "What has one eye but can't see?", "A needle"),
            new Riddle(null, "What has many needles but doesn't sew?", "A Christmas tree"),
            // new Riddle(null, "What has hands but can't clap?", "A clock"),
            new Riddle(null, "What can you catch but not throw?", "A cold"),
            new Riddle(null, "What kind of band never plays music?", "A rubber band"),
            new Riddle(null, "What has a thumb and four fingers but is not a hand?", "A glove"),
            new Riddle(null, "What has a head and a tail but no body?", "A coin"),
            new Riddle(null, "What has words but never speaks?", "A book"),
            new Riddle(null, "Where does one wall meet the other wall?", "On the corner"),
            new Riddle(null, "What building has the most stories?", "The library"),
            new Riddle(null, "What runs all around a backyard yet never moves?", "A fence"),
            new Riddle(null, "What can travel all around the world without leaving its corner?", "A stamp"),
            new Riddle(null, "What kind of coat is best put on wet?", "A coat of paint"),
            new Riddle(null, "What is the end of everything?", "The letter \"g\"")
        );
        
        riddleRepository.saveAll(riddles);
    }
}
