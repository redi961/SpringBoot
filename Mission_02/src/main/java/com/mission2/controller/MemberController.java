package com.mission2.controller;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mission2.member.MemberDTO;
import com.mission2.service.MemberService;

@RestController
public class MemberController {
	private MemberService mem;
	
	public MemberController () {
		mem = new MemberService();	
	}
	
	@GetMapping("/member")
	public List<MemberDTO> memlist() {
		return mem.listup();
	}
	
	@PostMapping("/member")
	public MemberService memAdd(MemberDTO dto) {
		mem.addDB(dto.getId(), dto.getPass(), dto.getName());
		return null;
	}
	
	@PutMapping("/member")
	public MemberService memUp(MemberDTO dto) {
		mem.upDB(dto.getId(), dto.getPass(), dto.getName());
		return null;
	}
	
	@DeleteMapping("/member/{id}") 
	public MemberService memDel(@PathVariable String id) {
		mem.delDB(id);
		return null;
	}
		
	
	
}
