package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chapter05.percistence.BoardRepository;

@SpringBootTest
class Chapter5ApplicationTests {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	void contextLoads() {
		
//		boardRepo.save(new Board(
//				10L,
//				"title",
//				"writer",
//				"content",
//				new Date(),
//				0L
//				));
		System.out.println("Avcd");
	}

}
