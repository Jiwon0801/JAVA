package test;

import edu.autocar.dbtest.model.Employee;

public class EmployeeBulderTest {

	public static void main(String[] args) {
//		Employee e = new Employee.Builder()
//				.setLastName("Gildong")
//				.setFirstName("Hong")
//				.setEmail("hong@naver.com")
//				.setEmployeeId(10000)
//				.create();
//		
		Employee e = Employee.builder()
							 .employeeId(10000)
							 .lastName("Gildong")
							 .firstName("Hong")
							 .email("hong@naver.com")
							 .build();
		
		System.out.println(e);	
	}
}
