//서블릿 실행 http:localhost:8080/boardweb/welcome.do
//프로젝트의 환경파일 web.xml에 등록
//서블릿 컨테이너: 서블릿의 생명주기 (init > service > destroy) 관리
//init() > 최초 요청 때 한번 실행
//service() > 요청 있을 때마다 실행
//destroy() > 서비스 종료



package co.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.BoardDAO;

public class WelcomeServlet extends HttpServlet{
	//생성자
	public WelcomeServlet() {
		System.out.println("WelcomeServlet 실행");
	}
	
	
	//메소드
	@Override
	//최초 한번
	public void init(ServletConfig req) throws ServletException { 
		System.out.println("init 실행");
	}
	@Override
	//실행될 때마다
	//서비스를 위한 코드 작성
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//웹브라우저에 전송되는 타입 정의
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("service 실행");
		
		String html = "<h3>여기는 servlet</h3>";
		html += "<a href='index.html'>인덱스로 이동</a>";
		BoardDAO dao = new BoardDAO();
		//arraylist 리턴값 가져오기
		List<Board> list = dao.boardList();
		html += "<table border='1'><thead><th>글번호</th><th>제목</th><th>작성자</th></thead>";
		html += "<tbody>";
		for(Board board : list) {
			html += "<tr><td>"+board.getBoardNo()+"</td>"
					+"<td>"+board.getTitle()+"</td>"
					+"<td>"+board.getWriter()+"</td></tr>";
		}
		html += "</tbody></table>";
		
		//클라이언트 쪽으로 출력 스트림
		PrintWriter out = resp.getWriter();
		out.print(html);
	}
	@Override
	//server > 우클릭 > stop
	public void destroy() { 
		System.out.println("destory 실행");
	}
}
