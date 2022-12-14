package com.src.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.src.edu.domain.Member;
import com.src.edu.service.MemberService;

//Model 객체 member로 등록되어있는 데이터를 자동으로 등록함
@SessionAttributes("member")
@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public void loginView() {
	}
	
	@PostMapping("/login")
	public String login (Member member, Model model) {
		Member findMember = memberService.getMember(member);
		if (findMember != null
				&& findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", findMember);
			return "forward:getBoardList";
		} else {
			return "redirect:login";
		}
	}
}
