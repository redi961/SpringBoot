package com.mission.domain;

import java.io.Serializable;
import java.util.Date;

public class MemberVO  {

	private int id;
	private String pass;
	private String name;
	private Date regidate = new Date();
	
	public  MemberVO (int mid, String mpass, String mname, Date mregidate) {
		
		mid = this.id;
		mpass = this.pass;
		mname = this.name;
		mregidate = this.regidate;
	}

}