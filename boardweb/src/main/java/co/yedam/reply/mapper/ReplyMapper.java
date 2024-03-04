package co.yedam.reply.mapper;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.reply.Reply;

public interface ReplyMapper {
	//목록, 페이징처리
	List<Reply> selectList(SearchVO search);
	//등록
	int insertReply(Reply reply);
	//삭제
	int deleteReply(int rno);
	//페이지계산 - 전체건수
	int selectCount(int bno);
}
