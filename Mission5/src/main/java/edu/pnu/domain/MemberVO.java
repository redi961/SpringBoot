package edu.pnu.domain;

import java.util.Date;

public class MemberVO {
    private int num;
    private String id;
    private String pass;
    private String name;
    private Date regidate;

    public MemberVO() {
	}

	public MemberVO(int num, String id, String pass, String name, Date regidate) {
		this.num = num;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}

	public int getNum() {
		return num;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setNum(int num) {
		this.num = num;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + "]";
	}    
}
