package naver.seoyeon5702.portfolio2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naver.seoyeon5702.portfolio2.dao.DdmstoreDAO;
import naver.seoyeon5702.portfolio2.domain.Ddmstore;

@Service
public class DdmstoreServiceImpl implements DdmstoreService {
	@Autowired
	private DdmstoreDAO ddmstoreDao;
	
	@Override
	public void list(HttpServletRequest request) {
		//매개변수로 페이지 번호가 온다고 가정
		String pageno = request.getParameter("pageno");
		//페이지 당 데이터 개수
		int cnt = 2;
		//시작번호와 끝나는 번호 생성 
		int start = Integer.parseInt(pageno) * cnt - (cnt -1);
		
		//int end = start + cnt -1;
		int end = Integer.parseInt(pageno) * cnt - (cnt -1);
		
		//Dao 의 파라미터 만들기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		//Dao의 메소드를 실행하고 결과를 저장
		List<Ddmstore> list = ddmstoreDao.list(map);
		request.setAttribute("list", list);
	}

	@Override
	public void detail(HttpServletRequest request) {
		String store_number = request.getParameter("store_number");
		Ddmstore ddmstore = ddmstoreDao.detail(store_number);
		request.setAttribute("ddmstore", ddmstore);

	}


}
