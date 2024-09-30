package testdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeserializableExample{
	private String accountno;
	private String departmentno;
	private String salary;
	private String pincode;
	private String userid;
	private String id;
	
	public DeserializableExample(
		 @JsonProperty("accountno") String accountno,
	        @JsonProperty("departmentno") String departmentno,
	        @JsonProperty("salary") String salary,
	        @JsonProperty("pincode") String pincode,
	        @JsonProperty("userid") String userid,
	        @JsonProperty("id") String id) {
		this.accountno = accountno;
		this.departmentno = departmentno;
		this.salary = salary;
		this.pincode = pincode;
		this.userid = userid;
		this.id = id;
	}
	
	
	public String getAccountno() {
		return accountno;
	}
	
	public String getDepartmentno() {
		return departmentno;
	}

	public String getSalary() {
		return salary;
	}

	public String getPincode() {
		return pincode;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public String getId() {
		return id;
	}
	
}


