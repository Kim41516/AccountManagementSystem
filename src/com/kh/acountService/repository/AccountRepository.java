package com.kh.acountService.repository;


import java.util.ArrayList;
import java.util.List;

import com.kh.acountService.model.vo.Account;
import com.kh.acountService.model.vo.Member;

public class AccountRepository {

	private static final ArrayList<Account> accountList = new ArrayList<>(5);
	
	public void save(Account account) {
		accountList.add(account);
	}
	
	public List<Account> findByAccountNo(String AccountNo){
		ArrayList<Account> findList = new ArrayList<>();
		
		for(Account findAccount : accountList) {
			if(findAccount.getAccountNo().equals(AccountNo)) {
				findList.add(findAccount);
			}
		}
		return findList;
	}
	
	public List<Account> findAllAccount(Member member){
		ArrayList<Account> findList = new ArrayList<>();
		for(Account findAccount : accountList) {
			if(findAccount.getMember()==member) {
				findList.add(findAccount);
			}
		}
		return findList;
	}
	
	

}
