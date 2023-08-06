package com.kh.acountService.model.vo;

public class Account {
	
		
		private Member member;
		private String accountNo; // ���¹�ȣ
		private int accountPwd; // ��й�ȣ
		private int balance;// �ܰ�
		private String bank; //�����
		
		
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
			return "������ =" + member.getLoginId() + ", ���¹�ȣ = " + accountNo + ",  �ܰ� = " + balance +" �� " + ", ���� = " + bank + "]";
		}
		
		
		
		
		
	
}
