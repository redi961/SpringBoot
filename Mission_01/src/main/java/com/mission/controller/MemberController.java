package com.mission.controller;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.coyote.http11.upgrade.UpgradeApplicationBufferHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mission.domain.MemberVO;

@RestController
public class MemberController {
	
	private List<MemberVO> list;
	public MemberController() {
		list = new ArrayList<MemberVO>();
		for (int i = 0; i <10 ; i++) {
			list.add(new MemberVO(i, "1234", "이름"+i,new Date()));
		}
	}

	@GetMapping("/Member")	
	public List<MemberVO> getMembers() {
		return list;
	}
	
	
	@GetMapping("/Member/{id}")
	public MemberVO getMember(@PathVariable int id) {
		// 위에서 작성한 list를 VO객체 m에 넣고 for 반복문 실행함
		for (MemberVO m:list) {
			// getID를 통하여 얻은 값이 ParhVariable을 통하여 찾는값과 일치한경우 VO객체 리턴
			// 만약 문자열을 비교하는 경우 equals() 형식으로 들어갔어야 됨
			if (m.getId() == id) {
				return m;
			}
		}
		// for를 빠져나온경우 탐색하는값이 없다는 뜻이므로 null을 리턴시킴
		return null;
	} 
	
	@PostMapping("/Member") 
	public MemberVO addMember(MemberVO add) {
		MemberVO member = new MemberVO();
		// put 기능을 통하여 설정한값을 member 객체에 저장
		member.setId(add.getId());
		member.setName(add.getName());
		member.setPass(add.getPass());
		member.setRegidate(add.getRegidate());
		
		// 저장된 member 객체 내의 값을 list에 추가
		list.add(member);
		
		// 작업을 진행한 member값을 리턴시킴
		return member;
	}
	
	@PutMapping("/Member") 
	public MemberVO updateMember (MemberVO up) {
		MemberVO member = new MemberVO();
		member.setId(up.getId());
		member.setName(up.getName());
		member.setPass(up.getPass());
		member.setRegidate(up.getRegidate());
		
		list.set(member.getId(), up);
		return up;
	}
	
	@DeleteMapping("/Member/{id}")
	public MemberVO removeMember(@PathVariable int id) {
		for (MemberVO m:list) {
			if (m.getId() == id) {
				list.remove(m);
				return m;
			}
		}return null;
	}
}