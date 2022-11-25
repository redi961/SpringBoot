package com.mission2.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

import com.mission2.JDBC.JDBConnect;

public class MemberDAO extends JDBConnect {
	static PreparedStatement psmt;
	static JDBConnect jdbc;
	private ArrayList<MemberDTO> list;

	public MemberDAO() {
		jdbc = new JDBConnect("org.h2.Driver", "jdbc:h2:tcp://localhost/~/mvcboard", "sa", "");
	}

	public void sqlRun() {
		String query = "SELECT * FROM member";
		try {
			Statement stmt = jdbc.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.println("\t" + rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public MemberDTO getMember(String id) {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = jdbc.con.createStatement();
			rs = st.executeQuery(String.format("SELECT * FROM member where id = '%s'", id));
			rs.next();
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPass(rs.getString("pass"));
			dto.setName(rs.getString("name"));
			dto.setRegidate(rs.getString("regidate"));
			return dto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MemberDTO memadd2(MemberDTO dto) {
		PreparedStatement ps = null;
		try {
			ps = jdbc.con.prepareStatement("INSERT INTO member (id, pass, name)" + "values (?, ?, ?)");
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPass());
			ps.setString(3, dto.getName());
			if (ps.executeUpdate() == 1)
				return getMember(dto.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MemberDTO sqlUpdate2(MemberDTO dto) {
		String query = "UPDATE member set id = ?, pass =  ?, name = ?" + "WHERE id = ?";
		try {
			PreparedStatement ps = jdbc.con.prepareCall(query);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPass());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getId());
			if (ps.executeUpdate() == 1)
				return getMember(dto.getId());
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MemberDTO sqlDel2(String id) {
		try {			
			String query = "DELETE FROM member where id = ?";
			
			MemberDTO dt = new MemberDTO();
			dt = getMember(id);			
				PreparedStatement ps = jdbc.con.prepareCall(query);				
				ps.setString(1, id);
				if (ps.executeUpdate() == 1)
					return dt;
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	
	public void sqlSel() {
		String query = "SELECT * FROM member where name = 머스트해브2";
		try {
			psmt = jdbc.con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery(query);
			while (rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.println("\t" + rs.getString(3));
				System.out.println("\t" + rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MemberDTO> listup() {
		String query = "SELECT * FROM member";
		try {
			list = new ArrayList<>();
			Statement stmt = jdbc.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getString("regidate"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// 상수 변수 선언간의 실수가 잦음 주의할것

}
