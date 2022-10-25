package eunjong_join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JoinDAO {
	static Connection conn = null;

	// 회원가입(JoinUser()-JuserDTO)
	public static void JoinUser(JusersDTO jusersDTO) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa402.iptime.org:50031:orcl", "younghun", "oracle");
			System.out.println("연결 성공");

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

			pstmt.executeUpdate();
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
		System.out.println("회원 가입 완료");
	}

	// JoccupiedIdDAO :회원가입시 아이디 존재 여부에 대해 검사하는 메소드
	public static boolean Juserid(String user_id) {
		Connection conn = null;
		boolean occupiedId = false;

		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa402.iptime.org:50031:orcl", "younghun", "oracle");
			System.out.println("연결 성공");

			// users 테이블에 이미 있는 아이디인지 검사
			String sql = "SELECT user_id From users WHERE user_id=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();

			ArrayList<String> jlist = new ArrayList<String>();
			while (rs.next()) {
				jlist.add(rs.getString("user_id"));
			}

			// 이미 있는 user_id면 true -> occupiedId
			for (String a : jlist) {
				if (user_id.equals(a)) {
					occupiedId = true;
					break;
				}
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