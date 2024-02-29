package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.control.AddBoard;
import co.yedam.board.control.AddBookControl;
import co.yedam.board.control.AddForm;
import co.yedam.board.control.BoardControl;
import co.yedam.board.control.BoardListControl;
import co.yedam.board.control.BookListControl;
import co.yedam.board.control.ModifyBoard;
import co.yedam.board.control.RemoveBoard;
import co.yedam.board.control.RemoveBookControl;
import co.yedam.board.control.RemoveForm;
import co.yedam.board.control.UpdateForm;
import co.yedam.member.control.AddMemberControl;
import co.yedam.member.control.AddMemberForm;
import co.yedam.member.control.LoginControl;
import co.yedam.member.control.LoginForm;
import co.yedam.member.control.LogoutControl;
import co.yedam.member.control.MemberListForm;

// init > service > destroy

public class FrontController extends HttpServlet{
	
	//Map타입으로 url과 실행할 클래스
	Map<String, Control> controls;
	public FrontController(){
		controls = new HashMap();
	}
	
	
	//init = 처음 한번
	@Override
	public void init(ServletConfig config) throws ServletException {
		//System.out.println("init실행");
		//controls.put("/a.do", new Acontrol());
		//controls.put("/b.do", new Bcontrol());
		//controls.put("/resume.do", new ResumeForm());
		//userlist 파일 연결
		controls.put("/userList.do", new UserListControl());
		
		//게시글관련
		controls.put("/main1.do", new MainControl());
		controls.put("/boardList.do", new BoardListControl());
		controls.put("/board.do", new BoardControl());
		controls.put("/updateForm.do", new UpdateForm()); //수정화면이동
		controls.put("/modifyBoard.do", new ModifyBoard()); //수정처리
		controls.put("/removeForm.do", new RemoveForm()); //삭제화면이동
		controls.put("/removeBoard.do", new RemoveBoard()); //삭제처리
		controls.put("/addForm.do", new AddForm());
		controls.put("/addBoard.do", new AddBoard());
		
		//회원관련
		controls.put("/LoginForm.do", new LoginForm());
		controls.put("/login.do", new LoginControl());
		controls.put("/Logout.do", new LogoutControl());
		
		//회원등록
		controls.put("/addMember.do", new AddMemberControl());
		controls.put("/addMemberForm.do", new AddMemberForm());
		
		controls.put("/memberList.do", new MemberListForm());
		
		controls.put("/productList.do", new ProductListControl());
		controls.put("/cartList.do", new CartListControl());
		
		
		//ajax연습
		controls.put("/bookList.do", new BookListControl());
		controls.put("/addBook.do", new AddBookControl());
		controls.put("/removeBook.do", new RemoveBookControl());
	}
	
	//service = 실행 마다
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service실행");
		String uri = req.getRequestURI(); //현재페이지의 url
		System.out.println("uri:" + uri);
		String context = req.getContextPath(); //어플리케이션
		System.out.println("context:" + context);
		//어떤 페이지 요청
		String path = uri.substring(context.length());
		System.out.println("path:" + path);
		
		Control control = controls.get(path); //path > (맵)키에 대한 값
		control.exec(req, resp); //요청 url에 따른 실행컨트롤 호출
	}
	//destroy
}
