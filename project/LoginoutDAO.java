package eunjongDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eunjongDTO.JusersDTO;

// 로그인 로그아웃 DAO - 로그아웃은 클라이언트에서 null 만들면 돼서 DAO 필요 없음
public class LoginoutDAO {
	// 로그인 메소드 (Login())
	public static JusersDTO Login(String user_id, String user_password, Connection conn) {
		JusersDTO jusers = new JusersDTO();
		try {
			// 가입된 회원인지 검사 (id,password)
			String sql = "SELECT * FROM users WHERE user_id=? AND user_password=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_password);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// 행이 출력되면 가입된 회원
				jusers.setUser_id(rs.getString("user_id"));
				jusers.setUser_password(rs.getString("user_password"));
				jusers.setUser_name(rs.getString("user_name"));
				jusers.setUser_email(rs.getString("user_eamil"));
				jusers.setUser_birth(rs.getDate("user_birth"));
				jusers.setUser_gender(rs.getString("user_gender").charAt(0));
				jusers.setUser_tel(rs.getString("user_tel"));
				jusers.setUser_address(rs.getString("user_address"));
				jusers.setUser_money(rs.getInt("user_money"));
				jusers.setUser_point(rs.getInt("user_point"));
				jusers.setUser_date(rs.getDate("user_date"));
				jusers.setUser_delete(rs.getString("user_delete").charAt(0));
				jusers.setUser_dreq_date(rs.getDate("user_dreq_date"));
			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return jusers;
	}
}