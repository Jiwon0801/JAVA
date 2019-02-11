package edu.autocar.mybatisex;

import java.util.List;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import edu.autocar.mybatisex.dao.GoodsInfoDao;
import edu.autocar.mybatisex.dao.GoodsInfoDaoImpl;
import edu.autocar.mybatisex.database.ConnectionProvider;
import edu.autocar.mybatisex.domain.GoodsInfo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoodsInfoDaoTest {
		GoodsInfoDao dao = new GoodsInfoDaoImpl();
	
		@Test
		public void test1GetCountTest() throws Exception {
			int count = dao.getCount();
			assert count == 8 : "행의 개수가 다릅니다";
		}

		@Test
		public void test2GetPageTest() throws Exception {
			List<GoodsInfo> list = dao.getPage(1,2);
			assert list != null : "페이지네이션 목록 생성 실패";
			assert list.size() == 2 : "페이지네이션 항목 개수 틀림";
		}
		
		@Test
		public void test3SelectListTest() throws Exception {
			List<GoodsInfo> list = dao.selectList();
			assert list != null : "전체목록 생성 실패";
			assert list.size() == 8 : "전체목록 개수 틀림";
		}
		@Test
		public void test4SelectOneTest() throws Exception {
			GoodsInfo gi = dao.selectOne("10001");
			assert gi != null : "목록 한개 생성 실패";
		}
		
		@Test
		public void test5InsertTest() throws Exception {
			GoodsInfo gi = GoodsInfo.builder().code("10009")
											.name("가습기")
											.price(50000)
											.maker("LG").build();
			
			int result = dao.insert(gi);
			ConnectionProvider.getSqlSession().commit();
			assert result == 1 : "Insert 실패";
		}
		
		@Test
		public void test6UpdateTest() throws Exception {
			GoodsInfo gi = dao.selectOne("10009");
			gi.setPrice(20000);
			int result = dao.update(gi);
			ConnectionProvider.getSqlSession().commit();
			assert result == 1 : "Update 실패";
		}
		
		@Test
		public void test7DeleteTest() throws Exception {
			int result = dao.delete("10009");
			ConnectionProvider.getSqlSession().commit();
			assert result == 1 : "Delete 실패";
		}
//		@Before
//		public void before() {
//			System.out.println("Before 호출");
//		}
//		@BeforeClass
//		public static void beforeclass() {
//			System.out.println("Before class 호출");
//		}
//		
//		@After
//		public void after() {
//			System.out.println("After 호출");
//		}
		@AfterClass
		public static void close() {
			System.out.println("AfterClass 호출");
			ConnectionProvider.getSqlSession().close();
		}

}
