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
			System.out.println("======���� ����======");
			System.out.println("������ ���� ����");
			System.out.println("1. ��������");
			System.out.println("2. ��������");
			System.out.println("3. �츮����");
			System.out.println("4. �������");
			System.out.println("5. ������");
			System.out.print(">>");
			String bankNum = sc.nextLine();
			switch(bankNum){
			case "1":
				bank = "��������";
				System.out.println("������ ���� ��ȣ(11�ڸ��� �Է����ּ���.)");
				System.out.print(">>");
				accountNo = sc.nextLine();
				
				if(accountNo.length()==11) {
					List<Account> accountList = ar.findByAccountNo(accountNo);
					if(accountList.isEmpty()) {
						isExit = true;
					}
				}	else {
					System.out.println("������ Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���");
				}			
				break;
			case "2" :
				bank = "��������";
				System.out.println("������ ���� ��ȣ(14�ڸ��� �Է����ּ���.)");
				System.out.print(">>");
				accountNo = sc.nextLine();
				if(accountNo.length()==14) {
					List<Account> accountList = ar.findByAccountNo(accountNo);
					if(accountList.isEmpty()) {
						isExit = true;
					}
				}else {
					System.out.println("������ Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���");
				}
				break;
			case "3" :
				bank = "�츮����";
				System.out.println("������ ���� ��ȣ(13�ڸ��� �Է����ּ���.)");
				System.out.print(">>");
				accountNo = sc.nextLine();
				if(accountNo.length()==13) {
					List<Account> accountList = ar.findByAccountNo(accountNo);
					if(accountList.isEmpty()) {
						isExit = true;
					}
				}else {
					System.out.println("������ Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���");
				}		
				break;
			case "4" :
				bank = "�������";
				System.out.println("������ ���� ��ȣ(14�ڸ��� �Է����ּ���.)");
				System.out.print(">>");
				accountNo = sc.nextLine();
				if(accountNo.length()==14) {
					List<Account> accountList = ar.findByAccountNo(accountNo);
					if(accountList.isEmpty()) {
						isExit = true;
					}
				}else {
					System.out.println("������ Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���");
				}		
				break;
			case "5":
				isExit = true;
				break;			
			default : 
				System.out.println("�ٽ� �Է����ּ���");
			}
		
		}while(!isExit);
		
		int accountPwd = madePwd(); //��й�ȣ ���� �޼���

		ar.save(new Account(member,accountNo,accountPwd,0,bank));
		System.out.println("���»��� �Ϸ�");
		
	}
	
	public void deposit(Member member) {
		List<Account> allAccount = ar.findAllAccount(member);
		int num=0;
		
		if(allAccount.isEmpty()) {
			System.out.println("���°� �������� �ʽ��ϴ�.");
			System.out.println("���¸� ���� ������ �ּ���.");
			return;
		}else {
			System.out.println("� ���¿��� �����Ͻǰ̴ϱ�?");
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
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
				}
				break;
			case 2 : 
				if(allAccount.get(num) != null) {
					 account = allAccount.get(num);
				}else {
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
				}
				break;
			case 3 : 
				if(allAccount.get(num) != null) {
					 account = allAccount.get(num);
				}else {
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
				}
				break;
			case 4 : 
				if(allAccount.get(num) != null) {
					 account = allAccount.get(num);
				}else {
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
				}
				break;
			case 5 : 
				if(allAccount.get(num) != null) {
					 account = allAccount.get(num);
				}else {
					System.out.println("�߸��Է��ϼ̽��ϴ�.");
				}
				break;
				default:System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
			
			System.out.println("===================");
			System.out.println("������ : "+ account.getMember().getLoginId());
			System.out.println("����� : "+ account.getBank());
			System.out.println("���¹�ȣ : "+ account.getAccountNo());
			System.out.println("�ܰ� : "+ account.getBalance());
			System.out.println("===================");
			System.out.println();
			System.out.println("�󸶸� �Ա��Ͻðڽ��ϱ�?");
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
	System.out.println("��й�ȣ ����(4�ڸ� ����) : ");
	System.out.print(">>");
	String AccountPwd = sc.nextLine();
	
	if(AccountPwd.length()==4) {
		result = Integer.parseInt(AccountPwd);
		isTrue = true;
	}else {
		System.out.println("�ٽ� �Է����ּ���.");
	}
		}
	
	return result;
	}
	
	

	
}
