package co.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;

public class LogoutControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//세션객체
		HttpSession session = req.getSession();
		//세션초기화
		session.invalidate();
		
		//로그인화면으로 이동
		String path = "WEB-INF/view/member/loginForm.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
