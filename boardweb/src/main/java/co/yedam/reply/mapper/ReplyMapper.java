package co.yedam.reply.mapper;

import java.util.List;
import java.util.Map;

import co.yedam.common.Center;
import co.yedam.common.SearchVO;
import co.yedam.reply.Reply;

public interface ReplyMapper {
	//목록, 페이징처리
	List<Reply> selectList(SearchVO search);
	List<Reply> selectList2(int bno);
	//등록
	int insertReply(Reply reply);
	//삭제
	int deleteReply(int rno);
	//페이지계산 - 전체건수
	int selectCount(int bno);
	
	//센터 등록
	int insertCenter(Center[] array);
	//센터 삭제
	int deleteCenter(Center[] array);
	
	//차트
	List<Map<String, Object>> countPerSido();
	
}
