package naver.seoyeon5702.portfolio2.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naver.seoyeon5702.portfolio2.dao.MemberDAO;
import naver.seoyeon5702.portfolio2.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDao;

	@Override
	public void login(HttpServletRequest request) {
		// 파라미터 읽기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		//DAO의 매개변수 만들기
				Member member = new Member();
				member.setId(id);
				member.setPw(pw);
				
				//DAO의 메소드를 호출
				Member result = memberDao.login(member);
				
				//result가 null이면 로그인 실패 그렇지 않으면 로그인 성공 
				request.setAttribute("result", result);

	}

}
