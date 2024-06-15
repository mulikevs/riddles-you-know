package com.sitemapdev.riddles_you_know.entity;

import jakarta.persistence.*;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Riddle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String question;

	@Column(nullable = false)
	private String answer;

}
