package project.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import common.base.DAOMyBatisBase;
import common.domain.PostVO;

public class PostDAOMyBatis extends DAOMyBatisBase {
	
	private final String NS = "common.mapper.PostMapper";
	private SqlSession ses;
	
	/** 검색어로 주소 검색 */
	public List<PostVO> selectPostByRoadName(String roadName) {
		try {
			ses = this.getSqlSessionFactory().openSession();
			List<PostVO> plist = ses.selectList(NS + ".selectPostByRoadName", roadName);
			return plist;
		} finally {
			close(ses);		
		}
	}

	/** 검색된 주소 총 갯수 */
	public int getTotalPost(String roadName) {
		try {
			ses = this.getSqlSessionFactory().openSession();
			int tplist = ses.selectOne(NS + ".getTotalPost", roadName);
			return tplist;
		} finally {
			close(ses);
		}
	}

	/** 검색된 주소 리스트 (페이징처리 start end 값) */
	public List<PostVO> ListPostByRoadName(Map<String, String> paging) {
		try {
			ses = this.getSqlSessionFactory().openSession();
			List<PostVO> lplist = ses.selectList(NS + ".ListPostByRoadName", paging);
			System.out.println("dao의 로드네임= "+paging.get("roadName"));
			return lplist;
		} finally {
			close(ses);
		}
	}

}
