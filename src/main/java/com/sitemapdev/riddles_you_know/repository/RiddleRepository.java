package com.sitemapdev.riddles_you_know.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sitemapdev.riddles_you_know.entity.Riddle;

@Repository
public interface RiddleRepository extends JpaRepository<Riddle, Long> {


}