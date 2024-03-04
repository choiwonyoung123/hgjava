package co.yedam.reply.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		String rno = req.getParameter("rno");
		
		ReplyService svc = new ReplyServiceImpl();
		Map<String, String> map = new HashMap<>();
		
		if(svc.removeReply(Integer.parseInt(rno))) {
			map.put("retCode", "OK");
			map.put("retMsg", "정상적으로 삭제");
		}
		else {
			map.put("retCode", "NG");
			map.put("retMsg", "삭제중 오류");
		}
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		resp.getWriter().print(json);
	}

}
