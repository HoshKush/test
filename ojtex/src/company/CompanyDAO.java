package company;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sqlmap.MyAppSqlConfig;
import www.utility.LogWriter;

public class CompanyDAO {
	private static SqlSessionFactory sqlMapper;
	private static SqlSession session;

	static{
		sqlMapper = MyAppSqlConfig.getSqlMapInstance();
		session = sqlMapper.openSession(true);
	}

	public boolean create(CompanyDTO dto) {
		boolean flag = false;
		try {
			int cnt = session.insert("company.create", dto);

		if(cnt > 0)
			flag = true;
		System.out.println("1개의 업체 정보가 추가되었습니다.");
		LogWriter.LogWrite("성공", "info", "session.insert('company.create', dto)",
				"쿼리가 데이터베이스로 전송되었습니다.", null);
		} catch(Exception e) {
			System.out.println("Exception : " + e);
			LogWriter.LogWrite("오류 발생", "fatal", "session.insert('company.create', dto)", "오류가 발생하였습니다.", e);
		} finally {
			
		}
		return flag;
	}

	public CompanyDTO read(String c_ID) {
		CompanyDTO dto = null;
		try {
			dto = session.selectOne("company.read", c_ID);
			
			System.out.println(c_ID + "의 정보를 불러옵니다.");
			LogWriter.LogWrite("성공", "info", "session.insert('company.read', c_ID)",
					"쿼리가 데이터베이스로 전송되었습니다.", null);
		} catch (Exception e) {
			System.out.println("Exception : "+e);
			LogWriter.LogWrite("오류 발생", "fatal", "session.selectOne('company.read', c_ID)", "오류가 발생하였습니다.", e);
		}
		
		return dto;
	}
	
	public boolean update(CompanyDTO dto) {
		boolean flag = false;
		try {
		int cnt = session.update("company.update", dto);
		
		if (cnt > 0)
			flag = true;
		System.out.println("업체 정보가 수정되었습니다.");
		LogWriter.LogWrite("성공", "info", "session.update('company.update', dto)",
				"쿼리가 데이터베이스로 전송되었습니다.", null);
		} catch(Exception e) {
			System.out.println("Exception : " + e);
			LogWriter.LogWrite("오류 발생", "fatal", "session.update('company.update', dto)", "오류가 발생하였습니다.", e);
		} finally {
			
		}
		return flag;
	}
	
	public boolean delete(String c_ID) {
		boolean flag = false;
		try {
		int cnt = session.delete("company.delete", c_ID);
		
		if (cnt > 0)
			flag = true;
		System.out.println("업체 정보가 삭제되었습니다.");
		LogWriter.LogWrite("성공", "info", "session.insert('company.delete', c_ID)",
				"쿼리가 데이터베이스로 전송되었습니다.", null);
		} catch(Exception e) {
			System.out.println("Exception : " + e);
			LogWriter.LogWrite("오류 발생", "fatal", "session.insert('company.delete', c_ID)", "오류가 발생하였습니다.", e);
		} finally {
			
		}
		return flag;
	}
	
}
