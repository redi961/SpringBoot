package edu.pnu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient {
	// 엔티티 매니저는 메소스당 하나씩, 여러개를 생성할경우 그 수만큼 만들어져있어야함
	public static void test(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			// Transaction == 명령어를 묶어서 처리 / 하나라도 오기입이 있을시 묶여있는 모든 명령어는 취소처리됨
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
			// commit -> transaction의 종료 후 SQL 저장소에 저장된 모든 기록을 DBMS로 전송
//			tx.commit();
			System.out.println("------------->Commit");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("--------------------->Rollback!!");
		} finally {
			em.close();
		}
	}

	public static void main(String[] args) {
		// Entity Manager 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			for (int i = 1; i <= 10; i++) {
				Board board = new Board();
				// 오타기입 후 Rollback 확인
//				board.setSeq(1L);
				board.setTitle("JPA제목" + i);
				board.setWriter("관리자" + i);
				board.setContent("JPA 내용" + i);
				board.setCreateDate(new Date());
				board.setCnt(0L);
				// 글 등록
				em.persist(board);
			}
			//tx.commit();
			System.out.println("------------->Commit");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("--------------------->Rollback!!");
		} finally {
			em.close();
		}
		System.out.println("Done");
		test(emf); // 오타 기입으로 인하여 상단 함수는 작동하지않고 Test 메소드만 동작함
		emf.close();
	}
}
