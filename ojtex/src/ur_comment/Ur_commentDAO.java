package ur_comment;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ur_comment.Ur_commentDTO;
import sqlmap.MyAppSqlConfig;

public class Ur_commentDAO {
	private static SqlSessionFactory sqlMapper;
	private static SqlSession session;

	static{
		sqlMapper = MyAppSqlConfig.getSqlMapInstance();
		session = sqlMapper.openSession(true);
	}
	
	public boolean create(Ur_commentDTO dto) {
		boolean flag = false;
		int cnt = session.insert("ur_comment.create", dto);
		
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public Ur_commentDTO read(int urc_num) {
		return session.selectOne("ur_comment.read", urc_num);
	}
	
	public boolean update(Ur_commentDTO dto) {
		boolean flag = false;
		int cnt = session.update("ur_comment.update", dto);
		
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
	
	public boolean delete(int urc_num) {
		boolean flag = false;
		int cnt = session.insert("ur_comment.delete", urc_num);
		
		if(cnt>0) {
			flag = true;
		}
		
		return flag;
	}
}
