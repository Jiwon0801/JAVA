package edu.autocar.dbtest.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;

//	public static class Builder {
//		
//		public static Builder builder() {
//			return new Builder();
//		}
//	}
	
//	public static class Builder {
//		private int employeeId;
//		private String firstName;
//		private String lastName;
//		private String email;
//		private String phoneNumber;
//		private Date hireDate;
//		private String jobId;
//		private double salary;
//		private double commissionPct;
//		private int managerId;
//		private int departmentId;
//
//		public Builder setEmployeeId(int employeeId) {
//			this.employeeId = employeeId;
//			return this;
//		}
//
//		public Builder setFirstName(String firstName) {
//			this.firstName = firstName;
//			return this;
//		}
//
//		public Builder setLastName(String lastName) {
//			this.lastName = lastName;
//			return this;
//		}
//
//		public Builder setEmail(String email) {
//			this.email = email;
//			return this;
//		}
//
//		public Builder setPhoneNumber(String phoneNumber) {
//			this.phoneNumber = phoneNumber;
//			return this;
//		}
//
//		public Builder setHireDate(Date hireDate) {
//			this.hireDate = hireDate;
//			return this;
//		}
//
//		public Builder setJobId(String jobId) {
//			this.jobId = jobId;
//			return this;
//		}
//
//		public Builder setSalary(double salary) {
//			this.salary = salary;
//			return this;
//		}
//
//		public Builder setCommissionPct(double commissionPct) {
//			this.commissionPct = commissionPct;
//			return this;
//		}
//
//		public Builder setManagerId(int managerId) {
//			this.managerId = managerId;
//			return this;
//		}
//
//		public Builder setDepartmentId(int departmentId) {
//			this.departmentId = departmentId;
//			return this;
//		}
//
//		public Employee create() {
//			return new Employee(employeeId, firstName, lastName, email, phoneNumber, hireDate, jobId, salary,
//					commissionPct, managerId, departmentId);
//		}
//
//	}
}
