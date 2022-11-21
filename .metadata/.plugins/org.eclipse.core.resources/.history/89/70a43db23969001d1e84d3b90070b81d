package com.mission.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mission.domain.*;

public class MemberService {
	
	private List<MemberVO> list;
	private Map<Integer, MemberVO> memberMap;
	public MemberService() {
		// TODO Auto-generated constructor stub
		
		list = new ArrayList<MemberVO>();
		for (int i = 0; i <10 ; i++) {
			list.add(new MemberVO(1, "1234", "이름"+i,new Date()));
		}
	}
	public List<MemberVO> getMembers() {
		return list;
	}
	
}
