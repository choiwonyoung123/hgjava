package co.yedam.member.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.member.Member;
import co.yedam.member.mapper.MemberMapper;

public class MemberServiceImpl implements MemberService{
	
	//세션
	SqlSession session = DataSource.getInstance().openSession(true);
	//마이바티스
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	
	@Override
	public Member loginCheck(Member member) {
		return mapper.selectMember(member);
	}


	@Override
	public boolean addMember(Member member) {
		if(mapper.insertMember(member)) {
			return true;
		}
		return false;
	}


	@Override
	public Member memberList(Member member) {
		return mapper.memberList(member);
	}

}
