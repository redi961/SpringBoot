package edu.pnu.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Board {

	@Id @GeneratedValue
	private Long seq;
	private String title;
	
	//update문이 실행될시 해당 칼럼은 제외된다
	@Column(updatable = false)
	private String writer;
	private String content;
	
	//insert 문구가 실행될 때 해당 칼럼은 제외되며, updatable과 동시에 쓰일시 읽기 전용 칼럼이라고 판단해도 무관할것으로 보인다.
	//Default값을 설정하여 null 대신 기본값이 삽입되도록 구성되어있다.
	@Column(insertable=false, updatable = false, columnDefinition = "date default current_timestamp")
	private Date createDate;
	
	@Column(insertable=false, updatable = false, columnDefinition = "number default 0")
	private Long cnt;
	
	public Board() {
		
	}
	
	public Board(Long seq, String title, String writer, String content, Date createDate, Long cnt) {
		super();
		this.seq = seq;
		this.title = title;
		this.writer = writer;
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

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}

	
	
}
