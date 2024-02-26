package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImpl;
import co.yedam.common.Control;

public class RemoveBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//mapper > int deleteBoard
		//service > boolean removeBoard
		String bno = req.getParameter("bno");
		
		//Board board = new Board();
		//board.setBoardNo(Integer.parseInt(bno));
		
		BoardService svc = new BoardServiceImpl();
		if(svc.removeBoard(Integer.parseInt(bno))) {
			resp.sendRedirect("boardList.do");
		}
		else {
			req.setAttribute("message", "수정 중 에러 발생");
			String path = "board/error.tiles";
			req.getRequestDispatcher(path).forward(req, resp);
		}
	}

}
