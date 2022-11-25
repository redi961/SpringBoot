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
		MemberDTO dto = new MemberDTO(id, pass, name);
		dao.memadd2(dto);
		System.out.println("======= 칼럼 추가완료 =======");
		dao.sqlRun();
	}

	public void upDB(String id, String pass, String name) {
		MemberDTO dto = new MemberDTO(id, pass, name);
		dao.sqlUpdate2(dto);
		System.out.println("=== 수정이 성공적으로 진행되었습니다. ===");
		dao.sqlRun();
	}

	public MemberDTO delDB2(String id) {
		return dao.sqlDel2(id);
	}

}