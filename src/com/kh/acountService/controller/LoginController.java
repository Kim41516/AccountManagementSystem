package com.kh.acountService.controller;


import java.util.List;

import com.kh.acountService.model.vo.Member;
import com.kh.acountService.repository.MemberRepository;

public class LoginController {

	MemberRepository memberRepository = new MemberRepository();
	
	public Member login(String loginId, int loginPwd) {
		
	
			List<Member> findMembers = memberRepository.findById(loginId);
			Member fm = null;
			if(findMembers.isEmpty()) {
				System.out.println("현재 저장된 회원이 없습니다. 먼저 회원가입 해주세요.");
			}				
			for(Member findMember : findMembers) {
				if(loginId.equals(findMember.getLoginId())  && loginPwd == findMember.getLoginPwd()) {
					System.out.println("로그인 성공!");
					System.out.println(findMember.getLoginId() + "님 반갑습니다.");
					fm = findMember;
				}else if(loginId.equals(findMember.getLoginId()) && loginPwd != findMember.getLoginPwd()) {
					System.out.println("비밀번호가 맞지않습니다.");
					System.out.println("다시 입력해주세요.");
					
				}
			}
			return fm;
		}
		
	
	
	
	public void sign(String signId, int signPwd) {		
		
		if(DuplicateId(signId) == false) {//회원 중복 확인
			memberRepository.save(new Member(signId, signPwd));
			System.out.println("생성 성공!");
			memberRepository.findByAll();
		}else {
			System.out.println("이미 존재하는 회원입니다.");
		}
		
		
	}
	
	public boolean DuplicateId(String signId) {
		boolean memberDup = false;
		List<Member> findMembers = memberRepository.findById(signId);
		if(!findMembers.isEmpty()) {
			memberDup = true;
		}
		return memberDup;
	}
}
