package com.neu.vo;
/**
 * 用户Bean
 * @author wangs
 *
 */
public class UserVO {
	private String cId;
	
	private String cUsername;
	
	private String cPwd;

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	

	public String getcPwd() {
		return cPwd;
	}

	public void setcPwd(String cPwd) {
		this.cPwd = cPwd;
	}

	public String getcUsername() {
		return cUsername;
	}

	public void setcUsername(String cUsername) {
		this.cUsername = cUsername;
	}

	@Override
	public String toString() {
		return "UserVO [cId=" + cId + ", cUsername=" + cUsername + ", cPwd=" + cPwd + "]";
	}

	
}
