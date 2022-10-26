package eunjong_qnas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Set;

// QmatchDAO : 게시글 수정/삭제/조회시 원글을 작성한 본인이 맞는지 확인하는 메소드
public class QmatchDAO {

	public static boolean QMatch(String user_id, int qna_no) {
		System.out.println("jdbc 프로그램 시작");
		Connection conn = null;
		boolean isMine = false;

		try {
			// JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결하기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa402.iptime.org:50031:orcl", "younghun", "oracle");
			System.out.println("연결 성공");

			// user_id가 작성한 글 번호들 불러오기
			String sql = "SELECT qna_no FROM qnas WHERE user_id=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<Integer> qlist = new ArrayList<Integer>();
			
			while (rs.next()) {
				qlist.add(rs.getInt("qna_no"));
			}

			// 조작하려는 글 번호 = user가 작성한 글 번호 라면 true
			for (int a : qlist) {
				if (qna_no == a) {
					isMine = true;
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
		return isMine;
	}
}
