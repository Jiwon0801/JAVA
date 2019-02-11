package edu.autocar.mybatisex;

import java.util.List;

import edu.autocar.base.sec.SHA256Util;
import edu.autocar.mybatisex.dao.MemberDao;
import edu.autocar.mybatisex.dao.MemberDaoImpl;
import edu.autocar.mybatisex.database.ConnectionProvider;
import edu.autocar.mybatisex.domain.Member;

public class UpdatePasswordEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDaoImpl();
		
		try {
			
			List<Member> list = dao.selectList();
			
			for (Member m : list) {
				
				//salt 발급
				String salt = SHA256Util.generateSalt();
				m.setSalt(salt);
				//기존 비밀번호 암호화
				String encPassword = SHA256Util.getEncrypt(m.getPassword(), salt);
				m.setPassword(encPassword);
				
				//salt 비번 변경
				dao.updatePassword(m);
			}
			
			ConnectionProvider.getSqlSession().commit();
			System.out.println("비밀번호 수정 완료");
			
		} catch (Exception e) {
			ConnectionProvider.getSqlSession().rollback();
			e.printStackTrace();
		}

	}

}
