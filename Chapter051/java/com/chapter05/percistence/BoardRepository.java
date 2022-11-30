package com.chapter05.percistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chapter05.domain.Board;
public interface BoardRepository extends JpaRepository<Board, Long> {

}
