package edu.autocar.mybatisex;

import java.util.ArrayList;
import java.util.List;

import edu.autocar.mybatisex.dao.MemberDao;
import edu.autocar.mybatisex.dao.MemberDaoImpl;
import edu.autocar.mybatisex.database.ConnectionProvider;
import edu.autocar.mybatisex.domain.Member;

public class MemberDaoTest {

	public static void main(String[] args) {

		// getCountTest();
		// getPageTest();
//		selectListTest();
//		selectOneTest();
//		insertTest();
//		updateTest();
		deleteTest();
		ConnectionProvider.getSqlSession().close();
	}

	public static void getCountTest() {
		MemberDao dao = new MemberDaoImpl();

		try {
			int count = dao.getCount();
			System.out.println("전체 행의 수 " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getPageTest() {
		MemberDao dao = new MemberDaoImpl();
		List<Member> list = new ArrayList<>();
		try {
			list = dao.getPage(1, 3);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Member m : list) {
			System.out.println(m);
		}
	}

	public static void selectListTest() {
		MemberDao dao = new MemberDaoImpl();
		List<Member> list = new ArrayList<>();
		try {
			list = dao.selectList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Member m : list) {
			System.out.println(m);
		}
	}

	public static void selectOneTest() {
		MemberDao dao = new MemberDaoImpl();
		Member m = new Member();
		try {
			m = dao.selectOne("hong");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(m);
	}

	public static void insertTest() {
		MemberDao dao = new MemberDaoImpl();

		Member m = Member.builder().userId("hong").password("1234").name("홍길동").phone("010-1111-1111")
				.email("hong@naver.com").address("").build();

		try {
			int result = dao.insert(m);
			assert result == 1 : "insert 실패";

			ConnectionProvider.getSqlSession().commit();
			System.out.println("insert 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void updateTest() {
		MemberDao dao = new MemberDaoImpl();

		try {
			Member m = dao.selectOne("hong");
			m.setAddress("서울시 강남구");
			int result = dao.update(m);
			assert result == 1 : "update 실패";

			ConnectionProvider.getSqlSession().commit();
			System.out.println("update 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleteTest() {
		MemberDao dao = new MemberDaoImpl();
		
		try {
			int result = dao.delete("hong");
			assert result == 1 : "delete 실패";

			ConnectionProvider.getSqlSession().commit();
			System.out.println("delete 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
