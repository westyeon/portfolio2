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
	
	
	//searchtype과 keyword를 이용해서 데이터 개수 찾아오는 메소드
	public int count (Map<String, Object> map) {
		return sqlSession.selectOne("ddmstore.count", map);
	}
	
	//searchtype과 keyword 와 start 와 end를 데이터 목록을 찾아오는 메소드
	public List<Ddmstore> list (Map<String, Object> map){
		return sqlSession.selectList("ddmstore.list", map);
	}
	
	//store_number에 해당하는 데이터 1개를 메소드
	public Ddmstore detail(String store_number) {
		return sqlSession.selectOne("ddmstore.detail", store_number);
	}
	
	//가장 큰 store_number를 찾아오는 메소드
		public String maxnumber() {
			return sqlSession.selectOne("ddmstore.maxnumber");
		}
	
	//데이터를 삽입하는 메소드
	public int insert(Ddmstore ddmstore) {
		return sqlSession.insert("ddmstore.insert", ddmstore);
	}
	//데이터를 삽입하는메소
	/*
	//데이터 번호를 받아서 번호에 해당하는 데이터를 가져오는 메소드
	public List<Ddmstore> list(Map map){
		return sqlSession.selectList("ddmstore.list",map);
	}
	//store_number 를 받아서 1개의데이터 가져오는 메소드
	public Ddmstore detail (String store_number){
		return sqlSession.selectOne("ddmstore.detail",store_number);
	}*/

}
