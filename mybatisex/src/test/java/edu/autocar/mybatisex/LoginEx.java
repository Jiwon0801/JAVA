package edu.autocar.mybatisex;

import edu.autocar.base.sec.SHA256Util;
import edu.autocar.base.util.Input;
import edu.autocar.mybatisex.dao.MemberDao;
import edu.autocar.mybatisex.dao.MemberDaoImpl;
import edu.autocar.mybatisex.domain.Member;

public class LoginEx {

	public static void main(String[] args) {
		MemberDao dao = new MemberDaoImpl();

		String id = Input.getString("ID : ");
		String password;
		String encrypPassword;
		String salt;
		try {
			Member m = dao.selectOne(id);
			assert m != null : "ID가 존재하지 않습니다.";
			salt = m.getSalt();

			for (int i = 0; i < 3; i++) {
				password = Input.getString("Password : ");
				encrypPassword = SHA256Util.getEncrypt(password, salt);

				if (encrypPassword.equals(m.getPassword())) {
					System.out.println("로그인 완료");
					printf(m);
					System.exit(0);
				} else {
					System.err.println("비밀번호가 일치하지 않습니다.");
				}
			}
			System.err.println("비밀번호가 3회 불일치하여 프로그램을 종료합니다.");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void printf(Member m) {
		System.out.println("----------회원 정보-------------");
		System.out.printf("%-10s : %s\n", "Id", m.getUserId());
		System.out.printf("%-10s : %s\n", "Name", m.getName());
		System.out.printf("%-10s : %s\n", "Email", m.getEmail());
		System.out.printf("%-10s : %s\n", "Phone", m.getPhone());
		System.out.println("-----------------------------");
	}

}
