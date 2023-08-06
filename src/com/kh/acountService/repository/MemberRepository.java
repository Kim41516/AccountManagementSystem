package com.kh.acountService.repository;

import java.util.ArrayList;
import java.util.List;

import com.kh.acountService.model.vo.Member;

public class MemberRepository {
	
	private static final ArrayList<Member>memberList = new ArrayList<>();
	
	public void save(Member member) {
		memberList.add(member);
	}
	
	
	public List<Member> findById(String id) {
		ArrayList<Member> findList = new ArrayList<Member>();
		
		for(Member findMember : memberList) {
			if(findMember.getLoginId().equals(id)) {
				findList.add(findMember);
			}
		}
		return findList;
	}
	
	
	public void findByAll(){
		for(Member findMember : memberList) {
			System.out.println(findMember);
		}
	}


	
}
