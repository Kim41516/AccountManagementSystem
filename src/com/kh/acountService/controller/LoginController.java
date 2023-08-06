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
				System.out.println("���� ����� ȸ���� �����ϴ�. ���� ȸ������ ���ּ���.");
			}				
			for(Member findMember : findMembers) {
				if(loginId.equals(findMember.getLoginId())  && loginPwd == findMember.getLoginPwd()) {
					System.out.println("�α��� ����!");
					System.out.println(findMember.getLoginId() + "�� �ݰ����ϴ�.");
					fm = findMember;
				}else if(loginId.equals(findMember.getLoginId()) && loginPwd != findMember.getLoginPwd()) {
					System.out.println("��й�ȣ�� �����ʽ��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					
				}
			}
			return fm;
		}
		
	
	
	
	public void sign(String signId, int signPwd) {		
		
		if(DuplicateId(signId) == false) {//ȸ�� �ߺ� Ȯ��
			memberRepository.save(new Member(signId, signPwd));
			System.out.println("���� ����!");
			memberRepository.findByAll();
		}else {
			System.out.println("�̹� �����ϴ� ȸ���Դϴ�.");
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
