package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImpl;
import co.yedam.common.Control;

public class AddBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		//파라미터 한번에 보내기
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		//boolean modifyBoard등록
		BoardService svc = new BoardServiceImpl();
		if(svc.addBoard(board)) {
			resp.sendRedirect("boardList.do");
		}
		else {
			req.setAttribute("message", "수정 중 에러 발생");
			String path = "board/error.tiles";
			req.getRequestDispatcher(path).forward(req, resp);
		}
	}
}
