package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class BoardDAO {
	Connection conn;
	ResultSet rs;
	PreparedStatement psmt;
	
	//등록기능
	public boolean insertBoard(Board board) {
		conn = DAO.getConn();
		String sql = "insert into tbl_board (board_no, title, content, writer) " 
		             + "values (board_seq.nextval, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//삭제기능
	public boolean deleteBoard(int bno) {
		conn = DAO.getConn();
		String sql = "delete from tbl_board " 
		             + "where board_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bno);
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//수정기능
	public boolean updateBoard(Board board) {
		conn = DAO.getConn();
		String sql = "update tbl_board " 
				     + "set writer = ?, content = ?, title = ? "
				     + "where board_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getWriter());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getTitle());
			psmt.setInt(4, board.getBoardNo());
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//목록기능
	public List<Board> boardList(){
		conn = DAO.getConn();
		List<Board> list = new ArrayList<>();
		
		String sql = "select * from tbl_board order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setCreateDate(rs.getDate("create_date"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
