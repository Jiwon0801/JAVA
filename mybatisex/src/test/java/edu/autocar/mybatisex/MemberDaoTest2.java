package edu.autocar.mybatisex;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.autocar.mybatisex.dao.MemberDao;
import edu.autocar.mybatisex.dao.MemberDaoImpl;
import edu.autocar.mybatisex.database.ConnectionProvider;
import edu.autocar.mybatisex.domain.Member;

public class MemberDaoTest2 {
	MemberDao dao = new MemberDaoImpl();

	public MemberDaoTest2() {
		System.out.println("생성자 호출");
	}

	@Test
	public void getCountTest() throws Exception {
		int count = dao.getCount();
		assert count == 107 : "행의 개수가 다릅니다";
	}

	@Test
	public void getPageTest() throws Exception {
		List<Member> list = dao.getPage(1, 10);
		assert list != null : "페이지네이션 목록 생성 실패";
		assert list.size() == 10 : "페이지네이션 항목 개수 틀림";
	}
	
	@Before
	public void before() {
		System.out.println("Before 호출");
	}
	@BeforeClass
	public static void beforeclass() {
		System.out.println("Before class 호출");
	}
	
	@After
	public void after() {
		System.out.println("After 호출");
	}
	@AfterClass
	public static void close() {
		System.out.println("AfterClass 호출");
		ConnectionProvider.getSqlSession().close();
	}

}
