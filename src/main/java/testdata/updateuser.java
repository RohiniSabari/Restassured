package testdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class updateuser {
	 @JsonProperty("accountno")
	private String accountno;
	 @JsonProperty("departmentno")
	private String departmentno;
	 @JsonProperty("salary")
	private String salary;
	 @JsonProperty("pincode")
	private String pincode;
	 
	 @JsonProperty("userid")
		private String userid;
	 @JsonProperty("id")
		private String id;
	public updateuser(String accountno, String departmentno, String salary, String pincode,String userid,String id) {
		
		this.accountno = accountno;
		this.departmentno = departmentno;
		this.salary = salary;
		this.pincode = pincode;
		this.userid=userid;
		this.id=id;
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
	public String getUserid() {
		return userid;
	}
	
	public String getId() {
		return id;
	}
	
	
}


