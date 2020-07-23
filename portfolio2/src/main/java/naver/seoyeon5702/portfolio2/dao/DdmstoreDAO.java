package naver.seoyeon5702.portfolio2.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naver.seoyeon5702.portfolio2.domain.Ddmstore;

@Repository
public class DdmstoreDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//데이터 번호를 받아서 번호에 해당하는 데이터를 가져오는 메소드
	public List<Ddmstore> list(Map map){
		return sqlSession.selectList("ddmstore.list",map);
	}
	//store_number 를 받아서 1개의데이터 가져오는 메소드
	public Ddmstore detail (String store_number){
		return sqlSession.selectOne("ddmstore.detail",store_number);
	}

}
