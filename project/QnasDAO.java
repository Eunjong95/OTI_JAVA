package eunjong_qnas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QnasDAO {
	static Connection conn = null;

	// QNA 게시판 목록 조회 (QList())
	public static void QList() {
		try {
			// JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결하기
			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa402.iptime.org:50031:orcl", "younghun", "oracle");
			System.out.println("연결 성공");

			// 글번호, 카테고리(문의유형), 아이디, 제목, 작성일, 조회수 띄우기
			String sql = "SELECT qna_no, qna_category, user_id, qna_title, qna_date, qna_view" + " FROM qnas q, users u"
					+ " WHERE q.user_id = u.user_id" + " ORDER BY qna_no DESC";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				QnasDTO qnas = new QnasDTO();
				qnas.setQna_no(rs.getInt("qna_no"));
				qnas.setQna_category(rs.getString("qna_category"));
				qnas.setUser_id(rs.getString("user_id"));
				qnas.setQna_title(rs.getString("qna_title"));
				qnas.setQna_date(rs.getDate("qna_date"));
				qnas.setQna_view(rs.getInt("qna_view"));
				System.out.printf("%-6s%-12s%-16s%-40s\n", qnas.getQna_no(), qnas.getQna_category(), qnas.getUser_id(),
						qnas.getQna_title(), qnas.getQna_date(), qnas.getQna_view());
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
	}

	// QNA 게시판 새 글 작성 (QCreate()-QcreateDTO)
	public static void QCreate(QcreateDTO qcreateDTO) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa402.iptime.org:50031:orcl", "younghun", "oracle");
			System.out.println("연결 성공");

			// 글번호, 카테고리(문의유형), 아이디, 제목, 작성일, 조회수 띄우기
			String sql = "INSERT INTO qnas(qna_no, qna_category, user_id, qna_title, qna_content, qna_date, qna_view)"
					+ " VALUES(seq_qna_no.nextval, ?, ?, ?, ?, sysdate, seq_qna_view.nextval)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, qcreateDTO.getUser_id());
			pstmt.setString(2, qcreateDTO.getQna_category());
			pstmt.setString(3, qcreateDTO.getQna_title());
			pstmt.setString(4, qcreateDTO.getQna_content());

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
		System.out.println("새글 등록 완료");
	}

	// QNA 게시판 게시글 수정(QUpdate()-QupdateDTO)
	public static int QUpdate(QupdateDTO qupdateDTO) {

		int rows = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa402.iptime.org:50031:orcl", "younghun", "oracle");

			// 카테고리, 제목, 내용 수정
			// 게시글을 수정하려는 사람이 해당 게시글을 작성한 작성자 본인인지 확인하기 위해 QmatchDAO 필요
			String sql = "UPDATE qnas SET qna_category = ?, qna_title = ?, qna_content = ?, qna_date = sysdate WHERE qna_no = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, qupdateDTO.getQna_category());
			pstmt.setString(2, qupdateDTO.getQna_title());
			pstmt.setString(3, qupdateDTO.getQna_content());
			pstmt.setInt(4, qupdateDTO.getQna_no());
			rows = pstmt.executeUpdate();

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
		System.out.println("글이 수정되었습니다.");
		// 수정 완료되면 1
		return rows;
	}

	// QNA 게시판 게시글 삭제(QDelete()-QdeleteDTO)
	public static void QDelete(QdeleteDTO qdeleteDTO) {
		// 게시글을 삭제하려는 사람이 해당 게시글을 작성한 작성자 본인인지 확인하기 위해 QmatchDAO 필요
		try {
			String sql = "DELETE FROM qnas WHERE qna_no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qdeleteDTO.getQna_no());
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
		System.out.println("글이 삭제되었습니다.");
	}

	// QNA 게시판 글 조회(QRead()-QreadDTO)
	public static void QRead(QreadDTO qreadDTO) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa402.iptime.org:50031:orcl", "younghun", "oracle");
			System.out.println("연결 성공");

			// 전체 게시글 중 글번호 입력해서 상세 내용 조회하기
			// 게시글을 조회하려는 사람이 해당 게시글을 작성한 작성자 본인인지 확인하기 위해 QmatchDAO 필요
			String sql = "SELECT * FROM qnas q, users u" + " WHERE q.user_id = u.user_id AND qna_no=?"
					+ " ORDER BY qna_no DESC";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qreadDTO.getQna_no());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				QnasDTO qnas = new QnasDTO();
				qnas.setQna_no(rs.getInt("qna_no"));
				qnas.setQna_category(rs.getString("qna_category"));
				qnas.setUser_id(rs.getString("user_id"));
				qnas.setQna_title(rs.getString("qna_title"));
				qnas.setQna_content(rs.getString("qna_content"));
				qnas.setQna_date(rs.getDate("qna_date"));
				qnas.setQna_view(rs.getInt("qna_view"));
				System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
				System.out.println("글 번호: " + qnas.getQna_no());
				System.out.println("문의 유형: " + qnas.getQna_category());
				System.out.println("제목: " + qnas.getQna_title());
				System.out.println("내용: " + qnas.getQna_content());
				System.out.println("작성일: " + qnas.getQna_date());
				System.out.println("조회수: " + qnas.getQna_view());
				System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
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
	}

	// QmatchDAO : 게시글 수정/삭제/조회시 원글을 작성한 본인이 맞는지 확인하는 메소드
	public static boolean Qmatch(String user_id, int qna_no) {
		Connection conn = null;
		boolean isMine = false;

		try {
			Class.forName("oracle.jdbc.OracleDriver");

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
