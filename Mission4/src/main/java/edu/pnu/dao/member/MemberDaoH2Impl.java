package edu.pnu.dao.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberInterface {
	private Connection con = null;

	public MemberDaoH2Impl() {
		try {
			// JDBC 드라이버 로드
			Class.forName("org.h2.Driver");

			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/mvcboard", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// MAP => key와 value값을 지정하여 데이터를 저장함
	@Override
	public Map<String, Object> getMembers() {
		Statement st = null;
		ResultSet rs = null;
		String sqlString = "select * from member order by id asc";
		try {
			List<MemberVO> list = new ArrayList<>();
			st = con.createStatement();
			rs = st.executeQuery(sqlString);
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setNum(rs.getInt("num"));
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);
			}
			// log를 저장하기 위하여 쿼리문을 sql 이라는 이름의 key값으로
			// 결과값 출력을 위한 리스트를 data 라는 이름의 key값으로 저장함
			Map<String, Object> map = new HashMap<>();
			map.put("sql", sqlString);
			map.put("data", list);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public Map<String, Object> getMember(Integer num) {
		Statement st = null;
		ResultSet rs = null;
		try {
			String sqlString = String.format("select * from member where num = %d", num);
			st = con.createStatement();
			rs = st.executeQuery(sqlString);
			rs.next();
			MemberVO m = new MemberVO();
			m.setNum(rs.getInt("num"));
			m.setId(rs.getString("id"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setRegidate(rs.getDate("regidate"));
			Map<String, Object> map = new HashMap<>();
			map.put("sql", sqlString);
			map.put("data", m);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// Num값 삽입을 위하여 member 테이블 내의 num최대값을 확인하고 rs.getint(1)을 통하여 int값으로 반환 + 1을 리턴하여
	// 다음에 삽입될 num값을 최대수치 +1으로 설정함
	private int getNextNum() {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select max(num) from member");
			rs.next();
			return rs.getInt(1) + 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	@Override
	public Map<String, Object> addMember(MemberVO member) {
		// 상기 nextnum 메소드를 통하여 최대num값 + 1을 num이라는 변수에 저장
		int num = getNextNum();
		Statement st = null;
		try {
			String sqlString = String.format(
					"insert into member (num,id,name,pass,regidate) values (%d,,'%s','%s','%s','%s')", num,
					member.getId(), member.getName(), member.getPass(),
					new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
			st = con.createStatement();

			Map<String, Object> ret = new HashMap<>();
			if (st.executeUpdate(sqlString) == 1) {
				Map<String, Object> map = getMember(num);
				ret.put("sql", sqlString);
				ret.put("data", map.get("data"));
			} else {
				ret.put("sql", sqlString);
				ret.put("data", null);
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> updateMember(MemberVO member) {
		Statement st = null;
		try {
			String sqlString = String.format("update member set name='%s',pass='%s' where num = %d", member.getName(),
					member.getPass(), member.getNum());
			st = con.createStatement();
			Map<String, Object> ret = new HashMap<>();
			if (st.executeUpdate(sqlString) == 1) {
				Map<String, Object> map = getMember(member.getNum());
				ret.put("sql", sqlString);
				ret.put("data", map.get("data"));
			} else {
				ret.put("sql", sqlString);
				ret.put("data", null);
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> deleteMember(Integer id) {
		Statement st = null;
		try {
			String sqlString = String.format("delete from member where id=%d", id);
			st = con.createStatement();
			Map<String, Object> map = getMember(id);
			if (map.get("data") == null)
				return null;
			Map<String, Object> ret = new HashMap<>();
			if (st.executeUpdate(sqlString) == 1) {
				ret.put("sql", sqlString);
				ret.put("data", map.get("data"));
			} else {
				ret.put("sql", sqlString);
				ret.put("data", null);
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
