package co.yedam.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.session.SqlSession;

import co.yedam.board.Board;
import co.yedam.board.Book;
import co.yedam.board.mapper.BoardMapper;
import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;

//업무로직 담고 있는 프로세스
//데이터처리 > mapper에 구현
public class BoardServiceImpl implements BoardService{
	//mainexe
	SqlSession session = DataSource.getInstance().openSession(true);
	//마이바티스
	BoardMapper mapper = session.getMapper(BoardMapper.class);
	
	@Override
	public List<Board> boardList(SearchVO search) {
		//System.out.println(search);
		return mapper.boardList(search);
	}
	
	@Override
	public int boardTotalCnt(SearchVO search) {
		return mapper.getTotalCnt(search);
	}
	@Override
	public Board getBoard(int bno) {
		mapper.updateCount(bno);
		return mapper.selectBoard(bno);
	}

	@Override
	public boolean modifyBoard(Board board){
		if(mapper.modifyBoard(board)) {
			return true;	
		}
		return false;
	}
	public boolean removeBoard(int bno) {
		if(mapper.removeBoard(bno)) {
			return true;
		}
		return false;
	}
	@Override
	public boolean addBoard(Board board) {
		if(mapper.addBoard(board)) {
			return true;
		}
		return  false;
	}
	@Override
	public boolean addBook(Book book) {
		return mapper.insertBook(book) == 1;
	}

	@Override
	public List<Book> bookList() {
		// TODO Auto-generated method stub
		return mapper.bookList();
	}

	@Override
	public boolean removeBook(String bcode) {
		return mapper.deleteBook(bcode) == 1;
	}
}
