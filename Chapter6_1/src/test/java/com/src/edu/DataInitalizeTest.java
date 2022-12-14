package com.src.edu;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.src.edu.domain.Board;
import com.src.edu.domain.Member;
import com.src.edu.persistence.BoardRepository;
import com.src.edu.persistence.MemberRepository;



@SpringBootTest
public class DataInitalizeTest {

	@Autowired
	private BoardRepository boardRepo;

	@Autowired
	private MemberRepository memberRepo;
	
	// 멤버생성 / 게시글 생성 테스트 예문
	@Test
	public void testManyToOneInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPassword("member111");
		member1.setName("둘리");
		member1.setRole("User");
		memberRepo.save(member1);

		Member member2 = new Member();
		member2.setId("member2");
		member2.setPassword("member222");
		member2.setName("도우너");
		member2.setRole("Admin");
		memberRepo.save(member2);

		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setWriter("둘리");
			board.setTitle("둘리가 등록한 게시글 " + i);
			board.setContent("둘리가 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setWriter("도우너");
			board.setTitle("도우너가 등록한 게시글 " + i);
			board.setContent("도우너가 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
	}
}
