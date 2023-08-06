package com.kh.acountService.view;

import java.util.Scanner;

import com.kh.acountService.controller.LoginController;

public class LoginView {
	
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {	
		
		LoginController lc = new LoginController();
		MainView mv = new MainView();
		
		boolean isExit = false;	
		do{
			
			System.out.println("==============");
		
			System.out.println("1. Log-in");
			System.out.println("2. Sign-in");
			System.out.println("3. exit");
			
			System.out.println("==============");
			System.out.print(">>");
			String result = sc.nextLine();
			
		
			
			switch (result){
			case "1": 
				System.out.println(" - 이름 : ");
				String loginId = sc.nextLine();
				System.out.println(" - 비밀번호(4자리 정수) : ");
				int loginPwd = sc.nextInt();
				sc.nextLine();
				mv.mainView(lc.login(loginId, loginPwd));
				break;
				
			case "2":
				System.out.println();
				System.out.print("- 이름 : ");
				String signId = sc.nextLine();
				System.out.print("- 생성할 password(4자리 정수) : ");
				int signPwd = sc.nextInt();
				sc.nextLine();
				lc.sign(signId, signPwd);
				break;
				
			case "3": 
				System.out.println("시스템 종료");
				isExit = true;
				break;
			
			default:
				System.out.println("다시 입력해주세요.");
				break;
			}
		}while(!isExit);
		

}
	
	
	

}
