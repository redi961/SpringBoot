package com.mission2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService mem;
	
	public MemberController () {
		mem = new MemberService();	
	}
	
	@GetMapping("/member")
	public List<MemberDTO> memlist() {
		return mem.listup();
	}
	
	@PostMapping("/member")
	public MemberDTO memAdd2(MemberDTO dto) {
		mem.addDB(dto.getId(), dto.getPass(), dto.getName()); 
		return dto;
	}
		
	@PutMapping("/member")
	public MemberDTO memUp(MemberDTO dto) {
		mem.upDB(dto.getId(), dto.getPass(), dto.getName());
		return dto;
	}
	
//	@DeleteMapping("/member/{id}") 
//	public MemberDTO memDel (@PathVariable String id) {
//		MemberDTO dto = new MemberDTO(id);
//		mem.delDB(dto.getId());
//		return dto;
//	}
		
	@DeleteMapping("/member/{id}") 
	public MemberDTO memDel2 (@PathVariable String id) {
		return mem.delDB2(id);
	}

	
}
