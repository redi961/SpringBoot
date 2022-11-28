package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.dao.MemberDaoListImpl;
import edu.pnu.dao.MemberInterface;
import edu.pnu.domain.MemberVO;

public class MemberService {

	private MemberInterface memberDao;
	
	public MemberService() {
		memberDao = new MemberDaoH2Impl();  /*H2 데이터 베이스와 연결후 Dao 기능 구현*/
		//memberDao = new MemberDaoListImpl();  /*리스트 형식 (파일리딩)을 통한 Dao 기능 구현*/
	}
	
	public List<MemberVO> getMembers() {
		return memberDao.getMembers();
	}

	public MemberVO getMember(Integer id) {
		return memberDao.getMember(id);
	}

	public MemberVO addMember(MemberVO member) {
		System.out.println("칼럼 추가 완료");
		return memberDao.addMember(member);
	}

	public MemberVO updateMember(MemberVO member) {
		System.out.println("칼럼 정보 변경 완료");
		return memberDao.updateMember(member);
	}

	public int deleteMember(Integer id) {
		System.out.println("칼럭 삭제 완료");
		return memberDao.deleteMember(id);
	}
}
