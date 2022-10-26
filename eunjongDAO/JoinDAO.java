package eunjongDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import eunjongDTO.JusersDTO;

public class JoinDAO {
	// 회원가입(JoinUser()-JuserDTO)
	public static int JoinUser(JusersDTO jusersDTO, Connection conn) {
		int rows = 0;
		try {
			// users 컬럼값 입력
			String sql = "INSERT INTO users(user_id, user_password, user_name, user_email, user_birth, user_gender, user_tel, user_address, user_money, user_point, user_date, user_delete)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, 0, 0, sysdate, 'N')";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, jusersDTO.getUser_id());
			pstmt.setString(2, jusersDTO.getUser_password());
			pstmt.setString(3, jusersDTO.getUser_name());
			pstmt.setString(4, jusersDTO.getUser_email());
			pstmt.setDate(5, jusersDTO.getUser_birth());
			pstmt.setString(6, jusersDTO.getUser_gender() + "");
			pstmt.setString(7, jusersDTO.getUser_tel());
			pstmt.setString(8, jusersDTO.getUser_address());

			rows = pstmt.executeUpdate();
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
		return rows;
	}

	// JoccupiedIdDAO :회원가입시 아이디 존재 여부에 대해 검사하는 메소드
	public static boolean JUserid(String user_id, Connection conn) {
		boolean occupiedId = false;
		try {
			// users 테이블에 이미 있는 아이디인지 검사
			String sql = "SELECT user_id From users WHERE user_id=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				occupiedId = true; // 행이 출력되면 이미 있는 아이디
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
		return occupiedId;
	}
}