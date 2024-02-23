//서블릿 클래스
package co.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.BoardDAO;

/**
 * Servlet implementation class MethodServlet
 */
@WebServlet(
		name = "methodServlet", 
		urlPatterns = { 
				"/methodServlet", 
				"/method"
		})
public class MethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MethodServlet() {
        super();
    }

    // 서블릿 생명주기 : init > service > destroy
    // service VS doGet/doPost
    // get방식 > 주소표시(url직접입력, a링크)
    // post방식 > form태그 > method="post"
    
    
    // Get방식으로 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//등록기능
		//제목 - 내용 - 작성자
		//실제 변경되는 파라미터
		String title = request.getParameter("title"); //요청정보의 값 중에서 title에 저장된 값 읽음
		String content = request.getParameter("content"); //요청정보의 값 중에서 content에 저장된 값 읽음
		String writer = request.getParameter("writer"); //요청정보의 값 중에서 writer에 저장된 값 읽음
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		BoardDAO dao = new BoardDAO();
		if(dao.insertBoard(board)) {
			//출력
			response.getWriter().print("OK");
		}
		else {
			//출력
			response.getWriter().print("NG");
		}
	}
	// Post방식으로 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩 정의
		request.setCharacterEncoding("utf-8");
		//실제 변경되는 파라미터
		String bno = request.getParameter("bno"); //요청정보의 값 중에서 title에 저장된 값 읽음
		String title = request.getParameter("title"); //요청정보의 값 중에서 title에 저장된 값 읽음
		String content = request.getParameter("content"); //요청정보의 값 중에서 content에 저장된 값 읽음
		String writer = request.getParameter("writer"); //요청정보의 값 중에서 writer에 저장된 값 읽음
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		board.setBoardNo(Integer.parseInt(bno));
		
		BoardDAO dao = new BoardDAO();
		if(dao.updateBoard(board)) {
			//출력
			response.getWriter().print("OK");
		}
		else {
			//출력
			response.getWriter().print("NG");
		}
	}
}
