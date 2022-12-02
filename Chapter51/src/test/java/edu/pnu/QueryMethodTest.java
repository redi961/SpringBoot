package edu.pnu;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	Random random = new Random();
	// 실행시에는 @Test 어노테이션을 각각 붙여서 기동 할 것 없으면 Bean으로 안들어감 -> 실행안됨

	public void datePrepare() {
		for (int i = 1; i <= 200; i++) {
			Board board = new Board();
			board.setTitle("테스트 제목 " + i);
			board.setWriter("테스터");
			board.setContent("테스트 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(random.nextLong(100));
			boardRepo.save(board);
		}
	}

	public void testFindByTitle() {
		List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}

	public void testByContent() {
		List<Board> boardList = boardRepo.findByContentContaining("17");

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}

	// Conataining의 역활은 Like와 비슷함 => 해당 당언가 포함되는 항목을 탐색함
	public void testFindByTitleContainingOrContentContaining() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("15", "15");

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("--->" + board.toString());
		}
	}

	// 1번 실습
	public void testFindByTitleContaining() {
		List<Board> boardList = boardRepo.findByTitleContaining("1");

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("검색 결과 === >" + board.toString());
		}
	}

	// 2번 실습
	public void testFindAnd() {
		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50L);

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("검색 결과 ===> " + board.toString());
		}
	}

	// 3번 실습
	public void testBetweenSearch() {
		List<Board> boardList = boardRepo.findByCntBetweenOrderBySeqDesc(10L, 50L);
		// List<Board> boardList2 =
		// boardRepo.findByCntGreaterEqualThanAndCntLessThanEqualOrderBySeqDesc(10L,50L); // 위와 동일함

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("검색 결과 ===> " + board.toString());
		}
	}

	public void annoTest01() {
		//페이징 -> 페이지의 수 / 한번에 표시할 객체의 수
		Pageable paging = PageRequest.of(3, 5);
		List<Board> boardList = boardRepo.queryAnnotationTest01(paging);

		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("검색 결과 ===> " + board.toString());
		}
	}
	
	public void annoTest02() {
		List<Board> boardList = boardRepo.queryAnnotationTest02("테스트 제목 15");
		
		System.out.println("검색결과");
		for (Board board : boardList) {
			System.out.println("검색 결과 ====>" + board.toString());
		}
	}
	
	public void annoTest03() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest03("테스트 제목 4");
		System.out.println("검색결과");
		for (Object[] row : boardList) {
			System.out.println("검색 결과 ====>" + Arrays.toString(row));
		}
	}
	
	@Test
	public void annoTest04() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest04("테스트 제목 10");
		System.out.println("검색결과");
		for (Object[] row : boardList) {
			System.out.println("검색 결과 ====>" + Arrays.toString(row));
		}
	}
	
}
