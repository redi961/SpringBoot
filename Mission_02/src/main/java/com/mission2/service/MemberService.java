package com.mission2.service;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.mission2.member.MemberDAO;
import com.mission2.member.MemberDTO;

public class MemberService {

	private List<MemberDTO> list;
	MemberDAO dao;
	MemberDTO dto;

	public List<MemberDTO> getStatus() throws Exception {

		String query = "SELECT * FROM member";
		try {
			Statement stmt = dao.con.createStatement();;
			ResultSet rs =   
					tmt.executeQuery(query);
			
			while (dao.rs.next()) {
				dto.setId(dao.rs.getString("id"));
				dto.setPass(dao.rs.getString("pass"));
				dto.setName(dao.rs.getString("name"));
				dto.setRegidate(dao.rs.getString("regidate"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static void main(String[] args) throws Exception {
		MemberService mem = new MemberService();
		mem.getStatus();
	}
}