package co.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	public static Connection conn;
	//함수 > Connection 타입의 getConn 함수
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			//데이터베이스 URL, 아이디, 비밀번호 입력 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.22:1521:xe", "yedam", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
