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
			System.out.println(member.getLoginId()+"님의 현재 남은 총 잔고 : ");
			System.out.println();
			System.out.println("=====menu=====");
			System.out.println("1. 계좌 개설");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 전체 계좌 조회");
			System.out.println("5. 입/출금 내역");
			System.out.println("6. 계좌번호 찾기");
			System.out.println("7. 계좌 제거");
			System.out.println("7. 종료");
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
				System.out.println("로그아웃");
				isExit = true;
				break;
			}
			
		}while(!isExit);
		
	}	
}
