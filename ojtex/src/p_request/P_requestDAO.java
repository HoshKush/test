package p_request;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import p_request.P_requestDTO;
import sqlmap.MyAppSqlConfig;

public class P_requestDAO {
	private static SqlSessionFactory sqlMapper;
	private static SqlSession session;

	static{
		sqlMapper = MyAppSqlConfig.getSqlMapInstance();
		session = sqlMapper.openSession(true);
	}
	
	public boolean create(P_requestDTO dto) {
		boolean flag = false;
		int cnt = session.insert("p_request.create", dto);
		
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public P_requestDTO read(int pr_num) {
		return session.selectOne("p_request.read", pr_num);
	}
	
	public boolean update(P_requestDTO dto) {
		boolean flag = false;
		int cnt = session.update("p_request.update", dto);
		
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public boolean delete(int pr_num) {
		boolean flag = false;
		int cnt = session.insert("p_request.delete", pr_num);
		
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
}
