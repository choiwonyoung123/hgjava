package co.yedam.reply.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.reply.Reply;

public interface ReplyService {
	//인터페이스
	List<Reply> replyList(SearchVO search);
	boolean addReply(Reply reply);
	boolean removeReply(int rno);
	//전체건수 - 페이지
	int totalCount(int bno);
}
