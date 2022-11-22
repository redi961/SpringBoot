package com.mission.domain;

import java.util.Date;

public class MemberVO  {

	private int id;
	private String pass;
	private String name;
	private Date regidate = new Date();
	
	public MemberVO () {}
	
	public MemberVO (int mid, String mpass, String mname, Date mregidate) {
		setId(mid);
		setPass(mpass);
		setName(mname);
		setRegidate(mregidate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}