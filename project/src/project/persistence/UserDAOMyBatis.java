package project.persistence;

import org.apache.ibatis.session.SqlSession;

import common.base.DAOMyBatisBase;
import common.domain.UserVO;

public class UserDAOMyBatis extends DAOMyBatisBase {

	private final String NS = "common.mapper.UserMapper";
	private SqlSession ses;
	
	/** 회원가입을 처리해 주는 insert */
	public int insertMember(UserVO vo) {
		try {
			ses = this.getSqlSessionFactory().openSession(true);
			int n = ses.insert(NS+".insertMember", vo);
			return n;
		} finally {
			close(ses);
		}
	}
	
	/** 로그인 체크 + 중복아이디 체크  */
	public UserVO checkById(String userid) {
			try {
				ses = this.getSqlSessionFactory().openSession();
				UserVO uvo = ses.selectOne(NS+".checkById", userid);
				System.out.println("dao=="+userid);
				return uvo;
			} finally {
				close(ses);
			}
		}

	public UserVO sellUser(int useridx) {
		try {
			ses=this.getSqlSessionFactory().openSession();
			UserVO vo=ses.selectOne(NS+".sellUser", useridx);
			return vo;
		}finally {
			close(ses);
		}
	}

}
