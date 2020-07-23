package naver.seoyeon5702.portfolio2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import naver.seoyeon5702.portfolio2.domain.Ddmstore;
import naver.seoyeon5702.portfolio2.service.DdmstoreService;

@RestController
public class DdmstoreDataController {
	@Autowired
	private DdmstoreService ddmstoreService;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public Map<String, Object> list(
			HttpServletRequest request){
		//서비스의 메소드를 실행
		ddmstoreService.list(request);
		Map<String, Object>map = 
				new HashMap<String, Object>();
		//데이터를 가져와서 map에 출력
		List<Ddmstore> list = (List<Ddmstore>)request.getAttribute("list");
		map.put("list", list);
		return map;
	}
	@RequestMapping(value="detail", method=RequestMethod.GET)public Map<String, Object> 
		detail(HttpServletRequest request){
		ddmstoreService.detail(request);
		Ddmstore ddmstore = (Ddmstore)request.getAttribute("ddmstore");
		Map<String, Object> map = 
				new HashMap<String, Object>();
		map.put("ddmstore", ddmstore);
		return map;
		
	}
	

}
