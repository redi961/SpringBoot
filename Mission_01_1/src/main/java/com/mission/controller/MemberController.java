package com.mission.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mission.domain.MemberVO;
import com.mission.service.MemberService;

@RestController
public class MemberController {
	
	private MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
	}

	@GetMapping("/Member")	
	public List<MemberVO> getMembers() {
		return memberService.getMembers();
	}
	
	@GetMapping("/Member/{id}")
	public MemberVO getMember(@PathVariable int id) {
		return memberService.getMember(id);
	} 
	
	@PostMapping("/Member") 
	public MemberVO addMember(MemberVO add) {
		return memberService.addMember(add);
	}
	
	@PutMapping("/Member") 
	public MemberVO updateMember (MemberVO up) {
		return memberService.updateMember(up);
	}
	
	@DeleteMapping("/Member/{id}")
	public MemberVO removeMember(@PathVariable int id) {
		return memberService.removeMember(id);
	}
}