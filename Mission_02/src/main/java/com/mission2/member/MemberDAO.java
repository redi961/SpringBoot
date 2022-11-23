package com.mission2.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mission2.JDBC.JDBConnect;

public class MemberDAO extends JDBConnect {
	static PreparedStatement psmt;
	static JDBConnect jdbc;
	private ArrayList<MemberDTO> list = new ArrayList<>();
	
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
			jdbc.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sqladd(String id, String pass, String name) {
		String query = "INSERT INTO member (id, pass, name)" + "Values (?, ?, ?)";
		try {
			PreparedStatement ps = jdbc.con.prepareCall(query);
			ps.setString(1, id);
			ps.setString(2, pass);
			ps.setString(3, name);
			ps.executeUpdate();
			ps.close();
			System.out.println("==== 칼럼 추가완료 ====");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sqlUpdate(String id, String pass, String name) {
		String query = "UPDATE member set name = ?, ?, ? WHERE id = ? ";
		try {
			PreparedStatement ps = jdbc.con.prepareCall(query);
			ps.setString(1, id);
			ps.setString(2, pass);
			ps.setString(3, name);
			ps.setString(4, id);
			ps.executeUpdate();
			ps.close();
			System.out.println("=== 수정이 성공적으로 진행되었습니다. ===");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sqlDel(String id) {
		String query = "DELETE FROM member where id = ?";
		try {
			PreparedStatement ps = jdbc.con.prepareCall(query);
			ps.setString(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
			Statement stmt = jdbc.con.createStatement();
			ResultSet rs =  stmt.executeQuery(query);
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setRegidate(rs.getString("regidate"));
				list.add(dto);	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}


