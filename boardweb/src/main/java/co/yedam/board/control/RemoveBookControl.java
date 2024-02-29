package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImpl;
import co.yedam.common.Control;

public class RemoveBookControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이터 인코딩
		resp.setContentType("text/json;charset=utf-8");

		String bcode = req.getParameter("bcode");
		
		BoardService svc = new BoardServiceImpl();
		try {			
			if(svc.removeBook(bcode)) {
				//{"retCode": "OK"}
				resp.getWriter().print("{\"retCode\": \"OK\"}");
			}
		}
		catch(Exception e) {
			//{"retCode": "NG"}
			e.printStackTrace();
			resp.getWriter().print("{\"retCode\": \"NG\"}");
		}
	}
}
