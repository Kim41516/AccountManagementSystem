package com.kh.acountService.model.vo;

public class Account {
	
		
		private Member member;
		private String accountNo; // 계좌번호
		private int accountPwd; // 비밀번호
		private int balance;// 잔고
		private String bank; //은행명
		
		
		public Account() {}
		
		public Account(Member member, String accountNo, int accountPwd, int balance, String bank) {
			this.member = member;
			this.accountNo = accountNo;
			this.accountPwd = accountPwd;
			this.balance = balance;
			this.bank = bank;
		}


		public String getId() {
			return member.getLoginId();
		}
		
		public String getBank() {
			return bank;
		}

		public void setBank(String bank) {
			this.bank = bank;
		}

		public String getAccountNo() {
			return accountNo;
		}

		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}

		public int getAccountPwd() {
			return accountPwd;
		}

		public void setAccountPwd(int password) {
			this.accountPwd = password;
		}

		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}
		
	
		public boolean isBalance() {
			return balance==0?true:false; 
		}

		public Member getMember() {
			return member;
		}

		public void setMember(Member member) {
			this.member = member;
		}

		@Override
		public String toString() {
			return "계좌주 =" + member.getLoginId() + ", 계좌번호 = " + accountNo + ",  잔고 = " + balance +" 원 " + ", 은행 = " + bank + "]";
		}
		
		
		
		
		
	
}
