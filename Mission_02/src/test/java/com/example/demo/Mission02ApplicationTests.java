package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mission02ApplicationTests {

	@Autowired
//	MemberInterface dao;
	
	@Test
	void test01() {
//		MemberInterface dao = new MemberDaoH2Impl();
//		MemberDTO m = dao.getMember(1);
		System.out.println("Test01");
	}

	@Test
	void test02() {
		System.out.println("Test02");
	}

	@Test
	void test03() {
		System.out.println("Test03");
	}

}
