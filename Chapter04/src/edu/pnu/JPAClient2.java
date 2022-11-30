package edu.pnu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;


public class JPAClient2 {
	public static void main(String[] args) {
		// Entity Manager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			// 0L => Long형 Data의 0
			tx.begin();
			for (int i = 1; i <= 10; i++) {
				Board board = new Board();
				board.setTitle("JPA제목" + i);
				board.setWriter("관리자" + i);
				board.setContent("JPA 내용" + i);
				board.setCreateDate(new Date());
				board.setCnt(0L);
				// 글 등록
				em.persist(board);
			}
			Board board = em.find(Board.class, 1L);
			board.setTitle("검색한 게시글의 제목 수정");
			
			//Transaction commit
			tx.commit();
			System.out.println("------------->Commit");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("--------------------->Rollback!!");
		} finally {
			em.close();
		}
		System.out.println("Done");
		emf.close();
	}
}
