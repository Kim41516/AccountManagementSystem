package com.kh.acountService.model.vo;

public class Member {
	
	private String loginId;
	private int loginPwd;
	
	public Member(){}
	
	public Member(String loginId, int loginPwd) {
		this.loginId = loginId;
		this.loginPwd = loginPwd;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public int getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(int loginPwd) {
		this.loginPwd = loginPwd;
	}

	@Override
	public String toString() {
		return "Member [loginId=" + loginId + ", loginPwd=" + loginPwd + "]";
	}



	
	
	
	

}
