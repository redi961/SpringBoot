package com.mission2.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mission2.JDBC.JDBConnect;

public class MemberDAO extends JDBConnect {
	static PreparedStatement psmt;
	JDBConnect jdbc;
	
	public MemberDAO() {
		jdbc = new JDBConnect("org.h2.Driver", "jdbc:h2:tcp://localhost/~/mvcboard", "sa", "");
	}
	public void sqlRun() {

		String query = "SELECT * FROM member";
		try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
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

	public void sqladd() {
		String query = "INSERT INTO member (id, pass, name)" + "Values (?, ?, ?)";
		try {
			PreparedStatement ps = jdbc.con.prepareCall(query);
			ps.setString(1, "musthave3");
			ps.setString(2, "1234");
			ps.setString(3, "머스트해브3");
			ps.executeUpdate();
			ps.close();
			System.out.println("==== 칼럼 추가완료 ====");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sqlUpdate() {
		String query = "UPDATE member set name = '머스트해브99' WHERE id = ? ";
		try {
			PreparedStatement ps = jdbc.con.prepareCall(query);
			ps.setString(1, "musthave2");
			ps.executeUpdate();
			ps.close();
			System.out.println("=== 수정이 성공적으로 진행되었습니다. ===");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void sqlDel() {
		String query = "DELETE FROM member where id = ?";
		try {
			PreparedStatement ps = jdbc.con.prepareCall(query);
			ps.setString(1, "musthave2");
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

}


