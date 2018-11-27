package u_review;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import u_review.U_reviewDTO;
import sqlmap.MyAppSqlConfig;

public class U_reviewDAO {
	private static SqlSessionFactory sqlMapper;
	private static SqlSession session;

	static{
		sqlMapper = MyAppSqlConfig.getSqlMapInstance();
		session = sqlMapper.openSession(true);
	}
	
	public boolean create(U_reviewDTO dto) {
		boolean flag = false;
		int cnt = session.insert("u_review.create", dto);
		
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public U_reviewDTO read(int ur_num) {
		return session.selectOne("u_review.read", ur_num);
	}
	
	public boolean update(U_reviewDTO dto) {
		boolean flag = false;
		int cnt = session.update("u_review.update", dto);
		
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public boolean delete(int ur_num) {
		boolean flag = false;
		int cnt = session.insert("u_review.delete", ur_num);
		
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
}
