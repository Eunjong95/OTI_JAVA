package ch20.oracle.sec07;

import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardUpdateExample {

	public static void main(String[] args) {
		Connection conn = null;

		try {
			// JDBC Driver를 메모리로 로딩하고, DriverManager에 등록
			Class.forName("oracle.jdbc.OracleDriver");

			// DB와 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost/orcl", "java", "oracle");
			System.out.println("연결 성공");

			// DB 작업 -매개변수화된 SQL문 작성
			String sql = new StringBuilder()
					.append("Update boards set ") 
//					.append("btitle=?, ")
//					.append("bcontent=?, ")
					.append("bfilename=?, ")
					.append("bfiledata=? ") //콤마 붙이면 안됨
					.append("where bno=?")				
					.toString(); //StringBuilder를 String으로 바꿔주는 메소드			
			
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle"});

			/*pstmt.setString(1, "비가 내려요");
			pstmt.setString(2, "겨울비는 추워요");
			pstmt.setString(3, "photo2.jpg");
			pstmt.setBlob(4, new FileInputStream("src/ch20/oracle/sec07/photo2.jpg"));
			pstmt.setInt(5, 2);*/
			
			pstmt.setString(1, "photo2.jpg");
			pstmt.setBlob(2, new FileInputStream("src/ch20/oracle/sec07/photo2.jpg"));
			pstmt.setInt(3, 10); //boards 테이블에 있는 게시물 번호(bno) 지정
			
			//SQL문 실행
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 행 수: " + rows);
		
			//PreparedStatement 닫기
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
