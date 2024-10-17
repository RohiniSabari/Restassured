package testdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class deleteuser {
	 @JsonProperty("userid")
		private String userid;
	 @JsonProperty("id")
		private String id;
	 public deleteuser(String userid,String id) {
		 this.userid=userid;
			this.id=id;
	 }
	 public String getUserid() {
			return userid;
		}
		
		public String getId() {
			return id;
		}
		
}
	 
