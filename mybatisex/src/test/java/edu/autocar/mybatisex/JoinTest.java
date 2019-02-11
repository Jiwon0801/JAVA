package edu.autocar.mybatisex;

import edu.autocar.base.sec.SHA256Util;
import edu.autocar.base.util.Input;
import edu.autocar.mybatisex.dao.MemberDao;
import edu.autocar.mybatisex.dao.MemberDaoImpl;
import edu.autocar.mybatisex.database.ConnectionProvider;
import edu.autocar.mybatisex.domain.Member;

public class JoinTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberDao dao = new MemberDaoImpl();
		
		
		try	{
			Member m = getMember(dao);
			int result = dao.insert(m);
			
			if (result == 1) {
				ConnectionProvider.getSqlSession().commit();
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
		}catch(	Exception e){
				e.printStackTrace();
		}

	}

	
	public static Member getMember(MemberDao dao) throws Exception {
		String userId = getUserId(dao);
		String password = Input.getString("비밀번호: ");
		String salt = SHA256Util.generateSalt();
		password = SHA256Util.getEncrypt(password, salt);
		String name = Input.getString("이름: ");
		String email = Input.getString("email: ");
		String phone = Input.getString("전화번호: ");
		String address = Input.getString("주소: ");

		return Member.builder().userId(userId).password(password).salt(salt).name(name).email(email).phone(phone)
				.address(address).build();
	}

	public static String getUserId(MemberDao dao) throws Exception {
		String userId;
		while(true) {
			userId = Input.getString("사용자 ID : ");
			Member m = dao.selectOne(userId);

			if(m==null){
				return userId;
			}
			System.out.println("이미 사용 중인 ID 입니다.");
		}
	}
	
	

	
}
