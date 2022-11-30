package edu.pnu.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//엔티티를 사용할 시 persistence.xml에 기록이 필요함 (해당 파일 7,8행 class항목 참조)
@Entity
public class Board {
	// Long = 8Byte(64bit) 정수형
	// Type이 Long인경우 대체로 Auto_increaseMent 타입을 사용한다 -> GeneratedValue (증가공식 (오라클이 아닌이상 Identity를 자주 사용함))
	// @Id = primary key
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	private String title;
	private String writer;
	private String content;
	private Date createDate;
	private Long cnt;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	
	// 소스항목 숏컷 alt+shift+s
	public Board(Long sqe, String title, String writer, String content, Date createDate, Long cnt) {
		super();
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.createDate = createDate;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Board [sqe=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public void setCreateDate(Date date) {
		this.createDate = date;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	
	
}
