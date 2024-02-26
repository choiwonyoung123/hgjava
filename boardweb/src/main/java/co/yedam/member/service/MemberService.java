package co.yedam.member.service;

import java.util.List;

import co.yedam.member.Member;


public interface MemberService {
	//FrontController.java와 연결
	Member loginCheck(Member member);
	boolean addMember(Member member);
	Member memberList(Member member);
	
}
