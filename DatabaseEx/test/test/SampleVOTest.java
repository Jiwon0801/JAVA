package test;

public class SampleVOTest {

	public static void main(String[] args) {
		SampleVO vo = new SampleVO("test1", "test2", "test4", "test4");
		SampleVO vo2 = new SampleVO("test1", "test2", "test3", "test5");
		
//		vo.setVal1("필드1");
//		vo.setVal2("필드2");
//		vo.setVal3("필드3");
//		
		
		System.out.println(vo);
		System.out.println(vo.hashCode());
		System.out.println(vo.equals(vo2));
		System.out.println(vo2.hashCode());
		

	}

}
