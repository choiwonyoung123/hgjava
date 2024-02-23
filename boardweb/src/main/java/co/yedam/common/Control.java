package co.yedam.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Control 인터페이스
public interface Control {
	//exec메소드
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
