package edu.pnu.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Board {

	@Id // primary key 
	@GeneratedValue
	private Long seq;
	private String title;
	private String content;
	
	//update문이 실행될시 해당 칼럼은 제외된다
	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate = new Date();
	
	@Column(updatable = false)
	private Long cnt = 0L;
	
	// N:1 연결 // 연관관계의 주인
	@ManyToOne
	@JoinColumn(name="MEMBER_ID", nullable=false, updatable=false)
	private Member member;

	public Board() {
		
	}

	public Board(Long seq, String title, String content, Date createDate, Long cnt) {
		super();
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.cnt = cnt;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setMember (Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
	
	public Member getMember() {
		return member;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", content=" + content + ", createDate=" + createDate
				+ ", cnt=" + cnt + "]";
	}
	
}
