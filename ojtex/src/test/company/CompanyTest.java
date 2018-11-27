package test.company;

import company.CompanyDAO;
import company.CompanyDTO;

public class CompanyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompanyDAO dao = new CompanyDAO();
		//create(dao);
		//read(dao);
		update(dao);
	}

	private static void update(CompanyDAO dao) {
		
		
	}

	private static void read(CompanyDAO dao) {
		String c_ID = "soldesk";
		p(dao.read(c_ID));
		
		
	}

	private static void p(CompanyDTO dto) {
		// TODO Auto-generated method stub
		p(dto.getC_ID());
		p(dto.getBoss());
		p(dto.getCnum());
		p(dto.getMname());
		p(dto.getMphone());
		p(dto.getAddress());
	}

	private static void create(CompanyDAO dao) {
		CompanyDTO dto = new CompanyDTO();
		  String c_ID     = "soldesk1" ;           
	      String cname    = "솔데스크";         
	      String passwd   = "1234";         
	      String cnum     = "123-56-78941";         
	      String boss     = "고지원";         
	      String address  = "서울특별시 종로구";         
	      String address2 = "관철동 코아빌딩 5층";         
	      String zipcode  = "123-123";         
	      String mname    = "오호식";         
	      String mphone   = "010-2323-4242";         
	      String memail   = "soldesk@dfads.com";    
	      
	      dto.setC_ID(c_ID);
	      dto.setAddress(address);
	      dto.setAddress2(address2);
	      dto.setBoss(boss);
	      dto.setCname(cname);
	      dto.setCnum(cnum);
	      dto.setMemail(memail);
	      dto.setMname(mname);
	      dto.setMphone(mphone);
	      dto.setPasswd(passwd);
	      dto.setZipcode(zipcode);
	      
	      if(dao.create(dto))
	      p("성공");
	      else
	      p("실패");
	            
		                  
	}

	private static void p(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
		
	}

}
