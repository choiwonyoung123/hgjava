package co.yedam.board.mapper;

import java.util.List;

import co.yedam.board.Board;
import co.yedam.board.Book;
import co.yedam.common.SearchVO;

public interface BoardMapper {
	List<Board> boardList(SearchVO search);
	int getTotalCnt(SearchVO search);
	//상세화면데이터
	Board selectBoard(int bno);
	//조회수증가
	int updateCount(int bno);
	//글내용수정
	int updateBoard(Board board);
	//
	boolean modifyBoard(Board board);
	//
	boolean removeBoard(int bno);
	//
	boolean addBoard(Board board);
	
	//도서목록
	List<Book> bookList();
	//도서등록
	int insertBook(Book book);
	int deleteBook(String bcode);
	
}
