package co.yedam;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.reply.Reply;
import co.yedam.reply.mapper.ReplyMapper;

public class MapperTest {
	public static void main(String[] args) {
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
		
		SearchVO search = new SearchVO();
		search.setBno(99);
		search.setRpage(1);
		//새로운 행 추가
		//Reply rep = new Reply();
		//rep.setBoardNo(99);
		//rep.setReply("99번 댓글입니다.");
		//rep.setReplyer("newbie");
		//mapper.insertReply(rep);
		//mapper.deleteReply(8);
		//List<Reply>
		//System.out.println(rep);
		mapper.selectList(search).forEach(reply -> System.out.println(reply.toString()));
	}
}
