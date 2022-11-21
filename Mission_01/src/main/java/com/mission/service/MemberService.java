package com.mission.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mission.domain.MemberVO;

public class MemberService {
	
	private List<MemberVO> list;
	public MemberService() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<MemberVO>();
		for (int i = 0; i < 10 ; i++) {
			list.add(new MemberVO(i, "1234", "이름"+i,new Date()));
		}
	}
	public List<MemberVO> getMembers() {
		return list;
	}
	
}
