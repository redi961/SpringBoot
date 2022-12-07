package com.src.edu.persistence;

import org.springframework.data.repository.CrudRepository;

import com.src.edu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

	
}
