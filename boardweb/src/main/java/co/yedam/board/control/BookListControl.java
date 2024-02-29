package co.yedam.board.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Book;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImpl;
import co.yedam.common.Control;

public class BookListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//jsp >> 페이지 반환
		//ajax >> json값 반환
		resp.setContentType("text/json;charset=utf-8");
		// [{키:값, 키:값}, {키:값, 키:값}] 형태
		BoardService svc = new BoardServiceImpl();
		List<Book> list = svc.bookList();
		String json = "[";
		for(int i = 0; i < list.size(); i++) {
			//한객체에 대한 데이터
			json += "{\"bookCode\":\""+list.get(i).getBookCode()+"\"" 
				    + ", " 
		            +"\"bookName\":\""+list.get(i).getBookName()+"\""
		            + ", " 
				    +"\"author\":\""+list.get(i).getAuthor()+"\""
				    + ", " 
				    +"\"press\":\""+list.get(i).getPress()+"\""
				    + ", " 
				    +"\"price\":\""+list.get(i).getPrice()+"\"}";
				            
			//한객체 끝에 콤마 넣기
			if(i != list.size() - 1) {	    
				json += ",";
			}
		}
		json += "]";
		resp.getWriter().print(json);
	}

}
