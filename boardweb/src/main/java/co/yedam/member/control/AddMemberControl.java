package co.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.member.Member;
import co.yedam.member.service.MemberService;
import co.yedam.member.service.MemberServiceImpl;

public class AddMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//multipart 매개값 >> 요청정보, 파일저장경로, 업로드파일최대크기, 인코딩방식, 리네임정책(같은파일이름)
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;
		String enc = "utf-8";
		MultipartRequest multi = new MultipartRequest(req, savePath, maxSize, enc, new DefaultFileRenamePolicy());
		
		String id = multi.getParameter("id");
		String pw = multi.getParameter("pw");
		String name = multi.getParameter("name");
		//중복이름 때문에 같은 파라미터가 아닌 이미지 값 가져옴 / 변경된 파일이름 가져옴
		String img = multi.getFilesystemName("image");
		
		// mapper: insertMember
		// service: addMember
		// 게시글목록 이동 - 에러페이지 이동
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setImg(img);
		
		MemberService svc = new MemberServiceImpl();
		if(svc.addMember(member)) {
			resp.sendRedirect("boardList.do");
		}
		else {
			req.setAttribute("message", "회원등록 중 에러 발생");
			String path = "WEB-INF/view/error.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		}
	}
}
