package edu.pnu.persistence;

import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.Board;

//JPA에서 구현 후 메모리로 직접올림 따라서 별도의 어노테이션을 필요로 하지 않음

public interface BoardRepository extends CrudRepository <Board, Long>	{

}
