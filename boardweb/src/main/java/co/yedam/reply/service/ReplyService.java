package co.yedam.reply.service;

import java.util.List;
import java.util.Map;

import co.yedam.common.Center;
import co.yedam.common.SearchVO;
import co.yedam.reply.Reply;

public interface ReplyService {
	//인터페이스
	List<Reply> replyList(SearchVO search);
	List<Reply> replyList2(int bno);
	
	boolean addReply(Reply reply);
	boolean removeReply(int rno);
	//전체건수 - 페이지
	int totalCount(int bno);
	
	int addCenter(Center[] array);
	
	//시도정보
	List<Map<String, Object>> getCntSido();
}
