package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.domain.Role;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepo;

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private PasswordEncoder encoder;
	
	// 멤버생성 / 게시글 생성 테스트 예문
	@Test
	public void testInset() {
		Member member1 = new Member();
		member1.setId("member");
		member1.setPassword(encoder.encode("member123"));
		member1.setName("둘리");
		member1.setRole(Role.ROLE_MEMBER);
		member1.setEnabled(true);
		memberRepo.save(member1);

		Member member2 = new Member();
		member2.setId("admin");
		member2.setPassword(encoder.encode("admin123"));
		member2.setName("도우너");
		member2.setRole(Role.ROLE_ADMIN);
		member2.setEnabled(true);
		memberRepo.save(member2);

		for (int i = 1; i <= 13; i++) {
			Board board = new Board();
			board.setMember(member1);
			board.setTitle(member1.getName() + "가 작성한 게시글" + i);
			board.setContent(member1.getName() + "가 작성한 게시글" + i + "입니다.");
			boardRepo.save(board);
		}

		for (int i = 1; i <= 13; i++) {
			Board board = new Board();
			board.setMember(member2);
			board.setTitle(member2.getName() + "가 작성한 게시글" + i);
			board.setContent(member2.getName() + "가 작성한 게시글" + i + "입니다.");
			boardRepo.save(board);
		}
	}


	public void testGetBoard() {
		// findbyId를 통하여 반환받은 객체는 optinal객체로써 wrapping 되어있다. 따라서 get()등을 통하여 값을 따올 필요가있다.
		// 특정 값을 반환 시키기위하여 get().뒤에 추가적인 get을 붙이는것도 가능하다
		Board board = boardRepo.findById(195L).get();
		System.out.println("[" + board.getSeq() + "번 게시글 정보 ]");
		System.out.println("제목 :: " + board.getTitle());
		System.out.println("내용 :: " + board.getContent());
		System.out.println("작성자 :: " + board.getMember().getName());
		System.out.println("등록일 :: " + board.getCreateDate());
		System.out.println("조회수 :: " + board.getCnt());
	}
	
	public void BoardRepositoryTest () {
		Member member = memberRepo.findById("member").get();
		
		System.out.println("[ " + member.getName() + "가 등록한 게시글 ]");
		for (Board board : member.getBoardList()) {
			System.out.println("----> " + board.toString());
		}
	}
	
}
