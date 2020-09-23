package project.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import common.base.DAOMyBatisBase;
import common.domain.CsVO;

public class CSDAOMybatis extends DAOMyBatisBase {

	private final String NS="common.mapper.CsMapper";
	private SqlSession ses;
	
	public int insertCS(CsVO cs) {
		try {
			ses=this.getSqlSessionFactory().openSession(true);
			int n=ses.insert(NS+".insertCS",cs);
			return n;
		} finally {
			close(ses);
		}
		
	}
	public List<CsVO> csList() {
		try {
			ses=this.getSqlSessionFactory().openSession(true);
			List<CsVO> csList=ses.selectList(NS+".csList");
			return csList;
		} finally {
			close(ses);
		}
		
	}
	public int getTotalCount() {
		try {
			ses=this.getSqlSessionFactory().openSession();
			int pagelist=ses.selectOne(NS+".getTotalCount");
			return pagelist;
		} finally {
			close(ses);
		}
		
	}
	public List<CsVO> pageCs(Map<String,String> list) {
		try {
			ses=this.getSqlSessionFactory().openSession();
			List<CsVO> pageList=ses.selectList(NS+".pageCs",list);
			return pageList;
		} finally {
			close(ses);
		}
		
	}
	
	public CsVO getcs(int cs_idx) {
	try {
		ses=this.getSqlSessionFactory().openSession();
		CsVO csList=ses.selectOne(NS+".getcs", cs_idx);
		return csList;
	} finally {
		close(ses);
	}
	
	}
	public int editCS(Map<String, String> map) {
		try {
			ses=this.getSqlSessionFactory().openSession(true);
			int n=ses.update(NS+".editCS",map);
			return n;
		} finally {
			close(ses);
		}
	
	}
	public int deleteCS(int cs_idx_int) {
		try {
			ses=this.getSqlSessionFactory().openSession(true);
			int n=ses.update(NS+".deleteCS",cs_idx_int);
			return n;
		} finally {
			close(ses);
		}
	}

	 
}
