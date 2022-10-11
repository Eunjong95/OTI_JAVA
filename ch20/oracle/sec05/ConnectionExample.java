package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

	public static void main(String[] args) {
		/*
		 * Connection conn = null; try { // JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
		 * Class.forName("oracle.jdbc.OracleDriver");
		 * 
		 * // DB와 연결 conn =
		 * DriverManager.getConnection("jdbc:oracle:thin:@localhost/orcl", "java",
		 * "oracle"); System.out.println("연결 성공");
		 * 
		 * // DB 작업 // ~
		 * 
		 * } catch (ClassNotFoundException e) { e.printStackTrace(); } catch
		 * (SQLException e) { e.printStackTrace(); } finally {
		 * 
		 * if (conn != null) {
		 * 
		 * // DB 연결 끊기 -> 위의 try블록에 넣을 경우 예외가 발생하면 close() 건너뛰게 됨 따라서 예외 이후에 finally로
		 * 리소스 닫아주는 것이 안전하다. try { conn.close(); } catch (SQLException e) { }
		 * System.out.println("연결 끊김"); } }
		 */

		
		// 자동 리소스 닫기 사용
		try {
			// JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
			Class.forName("oracle.jdbc.OracleDriver");

			try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost/orcl", "java", "oracle");) {
				System.out.println("연결 성공");

				// DB 작업
				// ~

			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("연결 끊김");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
