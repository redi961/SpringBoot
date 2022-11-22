package com.mission2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.mission2.member.MemberDTO;
import com.mission2.service.MemberService;

@RestController
public class MemberController {
	private List<MemberDTO> list;
	private MemberDTO dto;
	private MemberService mem;
	
	
	public MemberController() throws Exception {
		mem.getStatus();
	}
}
