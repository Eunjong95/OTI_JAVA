package eunjong_join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//회원가입시 아이디 존재 여부에 대해 검사하는 DAO
public class JoccupiedIdDAO {

	public static boolean Juserid(String user_id) {
		Connection conn = null;
		boolean occupiedId = false;

		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa402.iptime.org:50031:orcl", "younghun", "oracle");
			System.out.println("연결 성공");

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