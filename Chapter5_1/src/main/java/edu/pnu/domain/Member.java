package edu.pnu.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {
	@Id	@Column(name = "MEMBER_ID")
	private String id;
	private String password;
	private String name;
	private String role;
	
	public Member() {
		
	}
	
	public Member(String id, String password, String name, String role) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.role = role;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	// maapedby는 자신이 이 연관관계의 주인이 아님을 표기하는 명령어, 즉 외래키를 가지지않은쪽을 표기하는 명령어이다
	// mappedby 에는 반대편에 자신이 매핑되어있는 필드명을 기록함 이 경우에는 Board에 member로 기록이 되어있기때문에 member가 됨
	// 연관 관계에 있는 Entity 들 모두 가져온다 → Eager 전략 // 연관 관계에 있는 Entity 가져오지 않고, getter 로 접근할 때 가져온다 → Lazy 전략
	// ManyToOne 의 기본 FetchType 은 EAGER // OneToMany의 경우 기본적으로 Lazy를 사용
	@OneToMany (mappedBy = "member", fetch = FetchType.EAGER)
	private List <Board> boardList = new ArrayList<Board>();
	
	public List<Board> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}




}
