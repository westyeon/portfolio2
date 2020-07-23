package naver.seoyeon5702.portfolio2.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.seoyeon5702.portfolio2.domain.Member;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//로그인 처리를 위한 메소드
	public Member login(Member member) {
		return sqlSession.selectOne("member.login", member);
	}

	
}
