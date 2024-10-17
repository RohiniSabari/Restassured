package testdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Adduser {
	 @JsonProperty("accountno")
	private String accountno;
	 @JsonProperty("departmentno")
	private String departmentno;
	 @JsonProperty("salary")
	private String salary;
	 @JsonProperty("pincode")
	private String pincode;
	
	public Adduser(String accountno, String departmentno, String salary, String pincode) {
		
		this.accountno = accountno;
		this.departmentno = departmentno;
		this.salary = salary;
		this.pincode = pincode;
	}
	
	public String getAccountNo() {
		return accountno;
	}
	
	public String getDeptNo() {
		return departmentno;
	}
	
	public String getSalary() {
		return salary;
	}
	
	public String getPinCode() {
		return pincode;
	}
	
}


