package co.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.member.Member;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.MemberServiceImpl;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//아이디값 파라미터로 가져와서 변수 저장
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		MemberService svc = new MemberServiceImpl();
		member = svc.loginCheck(member);
		//로그인 성공
		if(member != null) {
			//사용자별로 다른 세션 값
			HttpSession session = req.getSession();
			session.setAttribute("logid", id);
			session.setAttribute("logName", member.getName());
			resp.sendRedirect("boardList.do");
		}
		//로그인 실패
		else {
			req.setAttribute("message", "아이디와 비밀번호를 확인하세요");
			String path = "WEB-INF/view/member/loginForm.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		}
	}
}
