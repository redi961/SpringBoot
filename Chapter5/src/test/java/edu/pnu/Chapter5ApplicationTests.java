package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
class Chapter5ApplicationTests {

	@Autowired
	private BoardRepository boardRepo;
	
//	@Test
//	void contextLoads() {
//		boardRepo.save(new Board(
//				10L,
//				"title",
//				"writer",
//				"content",
//				new Date(),
//				0L
//				));
//	}
	
//	@Test
//	public void testInsertBoard() {
//		Board board = new Board();
//		board.setTitle("첫 번째 게시글");
//		board.setWirter("테스터");
//		board.setContent("잘 등록 되나요?");
//		board.setCreateDate(new Date());
//		board.setCnt(0L);
//		
//		boardRepo.save(board);
//	}
	
//	@Test
//	public void testgetBoard() {
//		// .get을 사용함으로써 Optional객체 내의 Board객체를 받아냄
//		Board board = boardRepo.findById(1L).get();
//		System.out.println(board.toString());
//	}
	
//	@Test
//	public void testUpdateBoard() {
//		System.out.println("=== 1번 게시글 조회 ===");
//		Board board = boardRepo.findById(2L).get();
//		
//		String oldtitle = board.getTitle();
//		
//		System.out.println("=== 1번 게시글 수정 ===");
//		board.setTitle("제목을 수정하였습니다.");
//		String newtitle = board.getTitle();
//		boardRepo.save(board);
//		
//		System.out.println(oldtitle + " ->" + newtitle);
//	}
	
	@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(1L);
	}
}
