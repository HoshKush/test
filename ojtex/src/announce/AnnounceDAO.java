package announce;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sqlmap.MyAppSqlConfig;

public class AnnounceDAO {
	private static SqlSessionFactory sqlMapper;
	private static SqlSession session;

	static{
		sqlMapper = MyAppSqlConfig.getSqlMapInstance();
		session = sqlMapper.openSession(true);
	}
	
	public boolean create(AnnounceDTO dto) {
		boolean flag = false;
		int cnt = session.insert("announce.create", dto);
		
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public AnnounceDTO read(int an_num) {
		return session.selectOne("announce.read", an_num);
	}
	
	public boolean update(AnnounceDTO dto) {
		boolean flag = false;
		int cnt = session.update("announce.update", dto);
		
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public boolean delete(int an_num) {
		boolean flag = false;
		int cnt = session.insert("announce.delete", an_num);
		
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
}
