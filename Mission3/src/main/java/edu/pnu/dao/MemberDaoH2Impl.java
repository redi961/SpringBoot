package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberInterface {
	private Connection con = null;
	
	public MemberDaoH2Impl() {
        try {
            // JDBC 드라이버 로드
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/mvcboard", "sa", "");
        }
        catch (Exception e) {            
            e.printStackTrace();
        }
	}
	@Override
	public List<MemberVO> getMembers() {
		Statement st = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from member order by id asc");
			// 지정 쿼리내에서 칼럼값이 있는한 이를 VO형식의 리스트안에 저장하여 리턴시킴
			while(rs.next() ) {
				MemberVO m = new MemberVO();
				m.setNum(rs.getInt("num"));
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public MemberVO getMember(Integer num) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("select * from member where num = ?");
			st.setInt(1, num);
			rs = st.executeQuery();
			rs.next();
			MemberVO m = new MemberVO();
			m.setNum(rs.getInt("num"));
			m.setId(rs.getString("id"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setRegidate(rs.getDate("regidate"));
			return m;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// rs.getInt(1) = rs의 첫번째 결과값을 int형태로 저장
	//테이블 내의 num값의 max값을 구하여 + 1을 더하여 int형태로 리턴시킴
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
				rs.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;		
	}
	
	@Override
	public MemberVO addMember(MemberVO member) {
		int num = getNextNum();
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("insert into member (num, id, name, pass) values (?, ?, ?, ?)");
			// getNextNum을 통하여 num은 자동적으로 최대값이 입력됨, 별도의 밸류값 입력이 필요하지않음
			st.setInt(1, num);
			st.setString(2, member.getId());
			st.setString(3, member.getName());
			st.setString(4, member.getPass());
			st.executeUpdate();
			return getMember(num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public MemberVO updateMember(MemberVO member) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("update member set name=?,pass=? where num=?");
			st.setString(1, member.getName());
			st.setString(2, member.getPass());
			st.setInt(3, member.getNum());
			st.executeUpdate();
			return getMember(member.getNum());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int deleteMember(Integer num) {
		PreparedStatement st = null;
		try {
			st = con.prepareStatement("delete from member where num=?");
			st.setInt(1, num);
			return st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

}
