package com.mission.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mission.domain.MemberVO;

@RestController
public class MemberController {
	
	private List<MemberVO> list;
	public MemberController() {
		list = new ArrayList<MemberVO>();
		for (int i = 0; i <10 ; i++) {
			list.add(new MemberVO(1, "1234", "이름"+i,new Date()));
		}
	}

	@GetMapping("/getMember")	
	public List<MemberVO> getMembers() {
		return list;
	}
	
}
		


		
		
