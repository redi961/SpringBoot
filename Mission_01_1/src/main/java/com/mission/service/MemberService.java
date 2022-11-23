package com.mission.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mission.domain.MemberVO;

public class MemberService {
	
	private List<MemberVO> list;
	
	public MemberService() {
		list = new ArrayList<>();
		for (int i = 1; i <= 2 ; i++) {
			list.add(new MemberVO(i, "1234", "이름"+i,new Date()));
		}
	}
	public List<MemberVO> getMembers() {
		return list;
	}
	public MemberVO getMember(int id) {
		for (MemberVO m : list) {
			if (m.getId() == id)
				return m;
		}
		return null;
	}
	public MemberVO addMember(MemberVO m) {

		m.setId(list.size() + 1);
		m.setRegidate(new Date());

		list.add(m);
		
		return m;
	}
	public MemberVO updateMember(MemberVO up) {
		for (MemberVO m : list) {
			if (m.getId() == up.getId()) {
				m.setName(up.getName());
				m.setPass(up.getPass());
				return m;
			}
		}
		return null;
	}
	public MemberVO removeMember(int id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				list.remove(m);
				return m;
			}
		}
		return null;
	}
}
