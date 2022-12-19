package edu.pnu.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>, 
QuerydslPredicateExecutor<Board> {

	// 검색기능 수행을 위한 동적 쿼리문 기본안 작성
	@Query("SELECT b FROM Board b")
	Page<Board> getBoardList(Pageable pageable);
}

