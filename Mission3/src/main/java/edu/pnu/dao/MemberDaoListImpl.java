package edu.pnu.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImpl implements MemberInterface {
	private List<MemberVO> list;

	// 리스트를 통하여 더미데이터 생성후 MemberVO 형태의 리스트에 저장함
	public MemberDaoListImpl() {
		list = new ArrayList<>();
//		for (int i = 1 ; i < 21 ; i++) {
//			list.add(new MemberVO(i, "musthave" + i, "1234", "이름" + i, new Date()));
		try {
			// 텍스트 파일을 리딩하는 방식
			BufferedReader br = new BufferedReader(new FileReader("List.txt"));
			String str;

			// 한줄씩 str에 저장
			while ((str = br.readLine()) != null) {
				// Tokenizer를 통하여 "," 를 기준으로 문자열을 자름
				StringTokenizer st = new StringTokenizer(str, ",");
				// 에러체크 추후 조사할것 st.hasMoreTokens()
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				String s3 = st.nextToken();
				String s4 = st.nextToken();
				Date s5 = new Date();
				list.add(new MemberVO(Integer.parseInt(s1), s2, s3, s4, s5));
				// 에러체크 관련 코드가 없으므로 최하단에 공백이있을시 오류가 발생함 주의할것
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> getMembers() {
		return list;
	}

	@Override
	public MemberVO getMember(Integer num) {
		for (MemberVO m : list) {
			if (m.getNum() == num)
				return m;
		}
		return null;
	}

	private int getNextNum() {
		return list.size() + 1;
	}

	@Override
	public MemberVO addMember(MemberVO member) {
		member.setNum(getNextNum());
		member.setRegidate(new Date());
		return member;
	}

	@Override
	public MemberVO updateMember(MemberVO member) {
		for (MemberVO m : list) {
			if (m.getId() == member.getId()) {
				m.setName(member.getName());
				m.setPass(member.getPass());
				return m;
			}
		}
		return null;
	}

	@Override
	public int deleteMember(Integer num) {
		for (MemberVO m : list) {
			if (m.getNum() == num) {
				list.remove(m);
				return 1;
			}
		}
		return 0;
	}

}
