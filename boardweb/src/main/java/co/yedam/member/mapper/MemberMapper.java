package co.yedam.member.mapper;

import java.util.List;

import co.yedam.member.Member;

public interface MemberMapper {
	//MemberMapper.xml과 연결
	Member selectMember(Member member);
	boolean insertMember(Member member);
	Member memberList(Member member);
}
