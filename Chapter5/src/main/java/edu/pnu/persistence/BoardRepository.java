package edu.pnu.persistence;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import edu.pnu.domain.Board;

//JPA에서 구현 후 메모리로 직접올림 따라서 별도의 어노테이션을 필요로 하지 않음

public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findByTitle(String searchKeywords);
	//해당 키워드가 포함된 항목에 대한 조회 (Like)
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);	
	List<Board> findByTitleContaining(String searchKeyword);
	List<Board> findByTitleContainingAndCntGreaterThan(String title, long count);	
	List<Board> findByCntBetweenOrderBySeqDesc(long start, long end);
	List<Board> findByCntGreaterThanEqualAndCntLessThanEqualOrderBySeqDesc(long cnt, long cnt2);
	
	
	//페이징은 입력시 JPA에서 자동으로 분류해줌
	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
	//페이징의 임포트는 domain이 끝에 붙어있는것으로 할것
	List<Board> queryAnnotationTest01(Pageable paging);
	
	//?1은 반환받은 첫번째 파라미터값을 뜻함 이경우에는 searchKeyword에서 반환된 String값
	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest02(String searchKeyword);
	
	// Param 어노테이션을 통하여 쿼리문상의 :searchKeyword와 매개변수를 매치시켜줌
	// Object 배열 형식 사용시 엔티티를 통째로 가져오는것이 아닌 변수값들이 하나하나 배열에 저장하는 방식으로 리턴이 가능하다
	@Query("SELECT b.seq, b.title, b.writer, b.createDate FROM Board b "
		+ "WHERE b.title like %:searchKeyword% "
		+ "ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest03(@Param("searchKeyword") String searchKeyword);

	// 속성값 및 띄어쓰기 정확하게 입력할것
	// 첫째줄 마지막은 띄어쓰기 주의해야함
	@Query(value = "select seq, title, writer, create_date "
				+	"from Board where title like '%'||?1||'%'"
				+	"order by Seq desc", nativeQuery = true)
	List<Object[]> queryAnnotationTest04(String searchKeyword);
}
