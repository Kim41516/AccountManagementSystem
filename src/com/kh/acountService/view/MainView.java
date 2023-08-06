package com.kh.acountService.view;

import java.util.Scanner;

import com.kh.acountService.controller.AccountController;
import com.kh.acountService.model.vo.Member;

public class MainView {
	
	Scanner sc = new Scanner(System.in);
	
	public void mainView(Member member) {
		boolean isExit = false;
		AccountController ac = new AccountController();
		
		do {
			System.out.println("==============");
			System.out.println(member.getLoginId()+"���� ���� ���� �� �ܰ� : ");
			System.out.println();
			System.out.println("=====menu=====");
			System.out.println("1. ���� ����");
			System.out.println("2. �Ա�");
			System.out.println("3. ���");
			System.out.println("4. ��ü ���� ��ȸ");
			System.out.println("5. ��/��� ����");
			System.out.println("6. ���¹�ȣ ã��");
			System.out.println("7. ���� ����");
			System.out.println("7. ����");
			System.out.println("==============");
			System.out.print(">>");
			
			String result = sc.nextLine();
			
			switch(result){
			case "1":
				ac.createAccount(member);
				break;
			case "2":
				ac.deposit(member);
				break;
			case "3":
//				withdraw();
				break;
			case "4":
				ac.selectAllAccount(member);
				break;
			case "5":
//				breakdown();
				break;
			case "6":
//				findPwd();
				break;
			case "7":
//				deleteAccount();
				break;
			case "8":
				System.out.println("�α׾ƿ�");
				isExit = true;
				break;
			}
			
		}while(!isExit);
		
	}	
}
