package co.yedam.reply.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.common.SearchVO;
import co.yedam.reply.Reply;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.service.ReplyServiceImpl;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		//데이터타입
		resp.setContentType("text/json;charset=utf-8");
		
		SearchVO search = new SearchVO();
		search.setBno(Integer.parseInt(bno));
		search.setRpage(Integer.parseInt(page));
		
		ReplyService svc = new ReplyServiceImpl();
		List<Reply> list = svc.replyList(search);
		
		//list값 >> json문자열로 반환
		Gson gson = new GsonBuilder().create();
		//객체 >> json문자열
		String json = gson.toJson(list);
		//출력
		resp.getWriter().print(json);
	}

}
