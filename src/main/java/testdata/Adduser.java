package testdata;

public class Adduser {
	private String accountno;
	private String departmentno;
	private String salary;
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


