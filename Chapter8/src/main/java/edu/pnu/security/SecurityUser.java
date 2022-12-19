package edu.pnu.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import edu.pnu.domain.Member;

public class SecurityUser extends User {
	private static final long serialVersionUID = 1L;
	private Member member;

	public SecurityUser(Member member) {
		// noop를 사용시 시큐리티 내에서 텍스트를 그대로 인식하도록 만듬 (암호화x 인 경우 사용함)
		
		super(member.getId(), member.getPassword(), 
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		this.member = member;
	}

	public Member getMember() {
		return member;
	}
}
