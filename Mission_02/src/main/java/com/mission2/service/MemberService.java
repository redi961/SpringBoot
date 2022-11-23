package com.mission2.service;

import java.util.ArrayList;

import com.mission2.member.MemberDAO;
import com.mission2.member.MemberDTO;

public class MemberService {
	
	private MemberDAO dao;
	
	public MemberService() {
		dao = new MemberDAO();
	}

	public ArrayList<MemberDTO> listup() {
		return dao.listup();
	}
	
	public void addDB(String id, String pass, String name) {
		dao.sqladd(id, pass, name);
		System.out.println("==================");
		dao.sqlRun();
	}

	public void upDB(String id, String pass, String name) {
		dao.sqlUpdate(id, pass, name);
		System.out.println("==================");
		dao.sqlRun();
	}

	public void delDB(String id) {
		dao.sqlDel(id);
		System.out.println("==================");
		dao.sqlRun();
	}
	
}