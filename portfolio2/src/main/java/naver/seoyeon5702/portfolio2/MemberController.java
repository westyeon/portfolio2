package naver.seoyeon5702.portfolio2;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import naver.seoyeon5702.portfolio2.domain.Member;
import naver.seoyeon5702.portfolio2.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="login")
	public Map<String, Object>login(HttpServletRequest request){
		memberService.login(request);
		Member member = (Member)request.getAttribute("result");
		Map<String, Object> map = new HashMap<String,Object>();
		//어떤 작업 수행의 결과가 null일 수 있는 경우는
		//다른 키를 하나 추가해서 null 여부를 판단 할 수 있도록 해줍니다.
		if(member == null) {
			map.put("login",false);
		}else {
			map.put("login", true);
			map.put("result", member);
		}
		
		return map;
	}
}
