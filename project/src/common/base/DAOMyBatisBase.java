package common.base;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DAOMyBatisBase {

	/** 사용자 정의 메소드: SqlSessionFactory 객체를 반환하는 메소드 */
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "common/config/mybatis-config.xml"; 
		// 설계도 역할을 하는 파일 (mybatis 환경설정 파일)
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); // 건축가
			SqlSessionFactory factory = builder.build(is); // 공장 짓기
			return factory;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	} //-------------------------------------
	
	public void close(SqlSession ses) {
		if(ses != null) ses.close();
	} //-------------------------------------
}
