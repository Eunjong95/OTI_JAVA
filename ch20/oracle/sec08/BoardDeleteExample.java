package ch20.oracle.sec08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDeleteExample {

	public static void main(String[] args) {

		Connection conn = null;

		try {
			// JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
			Class.forName("oracle.jdbc.OracleDriver");

			// DB와 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost/orcl", "java", "oracle");
			System.out.println("연결 성공");

			// DB 작업 - 매개변수화된 sql문 작성
			String sql = "delete from boards where bwriter =? ";

			// preparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "summer");

			// sql문 실행
			int rows = pstmt.executeUpdate();
			System.out.println("삭제된 행 수: " + rows);

			// PreparedStatement 닫기
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				// DB 연결 끊기
				try {
					conn.close();
				} catch (SQLException e) {
				}
				System.out.println("연결 끊김");
			}
		}
	}
}
