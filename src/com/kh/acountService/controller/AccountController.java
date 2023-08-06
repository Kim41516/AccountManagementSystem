package com.kh.acountService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.acountService.model.vo.Account;
import com.kh.acountService.model.vo.Member;
import com.kh.acountService.repository.AccountRepository;


public class AccountController {

	Scanner sc = new Scanner(System.in);
	AccountRepository ar = new AccountRepository();
	
	public void createAccount(Member member) {
		boolean isExit = false;
		String bank = null;
		String accountNo = null;
		do {
			System.out.println();
			System.out.println("======계좌 생성======");
			System.out.println("생성할 계좌 은행");
			System.out.println("1. 신한은행");
			System.out.println("2. 국민은행");
			System.out.println("3. 우리은행");
			System.out.println("4. 기업은행");
			System.out.println("5. 나가기");
			System.out.print(">>");
			String bankNum = sc.nextLine();
			switch(bankNum){
			case "1":
				bank = "신한은행";
				System.out.println("생성할 계좌 번호(11자리를 입력해주세요.)");
				System.out.print(">>");
				accountNo = sc.nextLine();
				
				if(accountNo.length()==11) {
					List<Account> accountList = ar.findByAccountNo(accountNo);
					if(accountList.isEmpty()) {
						isExit = true;
					}
				}	else {
					System.out.println("형식이 틀렸습니다. 다시 입력해주세요");
				}			
				break;
			case "2" :
				bank = "국민은행";
				System.out.println("생성할 계좌 번호(14자리를 입력해주세요.)");
				System.out.print(">>");
				accountNo = sc.nextLine();
				if(accountNo.length()==14) {
					List<Account> accountList = ar.findByAccountNo(accountNo);
					if(accountList.isEmpty()) {
						isExit = true;
					}
				}else {
					System.out.println("형식이 틀렸습니다. 다시 입력해주세요");
				}
				break;
			case "3" :
				bank = "우리은행";
				System.out.println("생성할 계좌 번호(13자리를 입력해주세요.)");
				System.out.print(">>");
				accountNo = sc.nextLine();
				if(accountNo.length()==13) {
					List<Account> accountList = ar.findByAccountNo(accountNo);
					if(accountList.isEmpty()) {
						isExit = true;
					}
				}else {
					System.out.println("형식이 틀렸습니다. 다시 입력해주세요");
				}		
				break;
			case "4" :
				bank = "기업은행";
				System.out.println("생성할 계좌 번호(14자리를 입력해주세요.)");
				System.out.print(">>");
				accountNo = sc.nextLine();
				if(accountNo.length()==14) {
					List<Account> accountList = ar.findByAccountNo(accountNo);
					if(accountList.isEmpty()) {
						isExit = true;
					}
				}else {
					System.out.println("형식이 틀렸습니다. 다시 입력해주세요");
				}		
				break;
			case "5":
				isExit = true;
				break;			
			default : 
				System.out.println("다시 입력해주세요");
			}
		
		}while(!isExit);
		
		int accountPwd = madePwd(); //비밀번호 생성 메서드

		ar.save(new Account(member,accountNo,accountPwd,0,bank));
		System.out.println("계좌생성 완료");
		
	}
	
	public void deposit(Member member) {
		List<Account> allAccount = ar.findAllAccount(member);
		int num=0;
		
		if(allAccount.isEmpty()) {
			System.out.println("계좌가 존재하지 않습니다.");
			System.out.println("계좌를 먼저 생성해 주세요.");
			return;
		}else {
			System.out.println("어떤 계좌에서 진행하실겁니까?");
			for(int i=1; i<=allAccount.size();i++){
				System.out.println("["+(i)+"] "+allAccount.get(i));
				num++;
			}
			int result = sc.nextInt();
			sc.nextLine();
			Account account = null;
		
			switch(result) {
			case 1 : 
				if(allAccount.get(num) != null) {
					 account = allAccount.get(num);
				}else {
					System.out.println("잘못입력하셨습니다.");
				}
				break;
			case 2 : 
				if(allAccount.get(num) != null) {
					 account = allAccount.get(num);
				}else {
					System.out.println("잘못입력하셨습니다.");
				}
				break;
			case 3 : 
				if(allAccount.get(num) != null) {
					 account = allAccount.get(num);
				}else {
					System.out.println("잘못입력하셨습니다.");
				}
				break;
			case 4 : 
				if(allAccount.get(num) != null) {
					 account = allAccount.get(num);
				}else {
					System.out.println("잘못입력하셨습니다.");
				}
				break;
			case 5 : 
				if(allAccount.get(num) != null) {
					 account = allAccount.get(num);
				}else {
					System.out.println("잘못입력하셨습니다.");
				}
				break;
				default:System.out.println("잘못입력하셨습니다.");
			}
			
			System.out.println("===================");
			System.out.println("계좌주 : "+ account.getMember().getLoginId());
			System.out.println("은행명 : "+ account.getBank());
			System.out.println("계좌번호 : "+ account.getAccountNo());
			System.out.println("잔고 : "+ account.getBalance());
			System.out.println("===================");
			System.out.println();
			System.out.println("얼마를 입금하시겠습니까?");
			System.out.print(">>");
			
			
			
		}
		
	}
	
	public void selectAllAccount(Member member) {
		System.out.println(ar.findAllAccount(member));
		
		
		
	}
	
	public int madePwd() {
	boolean isTrue =false;
	int result = 0;
	while(!isTrue) {
	System.out.println("비밀번호 설정(4자리 정수) : ");
	System.out.print(">>");
	String AccountPwd = sc.nextLine();
	
	if(AccountPwd.length()==4) {
		result = Integer.parseInt(AccountPwd);
		isTrue = true;
	}else {
		System.out.println("다시 입력해주세요.");
	}
		}
	
	return result;
	}
	
	

	
}
