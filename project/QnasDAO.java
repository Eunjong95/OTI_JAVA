package eunjongDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eunjongDTO.QcreateDTO;
import eunjongDTO.QdeleteDTO;
import eunjongDTO.QnasDTO;
import eunjongDTO.QreadDTO;
import eunjongDTO.QupdateDTO;
import eunjong_qnas.QviewcountDTO;

public class QnasDAO {
	// QNA 게시판 목록 조회 (QList())
	public static ArrayList<QnasDTO> QList(Connection conn) {
		ArrayList<QnasDTO> list = new ArrayList<>();
		try {
			// 글번호, 카테고리(문의유형), 아이디, 제목, 작성일, 조회수 띄우기
			String sql = "SELECT qna_no, qna_category, q.user_id, qna_title, qna_date, qna_view"
					+ " FROM qnas q, users u" + " WHERE q.user_id = u.user_id" + " ORDER BY qna_no DESC";

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
				list.add(qnas);
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
		return list;
	}

	// QNA 게시판 새 글 작성 (QCreate()-QcreateDTO)
	public static int QCreate(QcreateDTO qcreateDTO, Connection conn) {
		int rows = 0;
		try {
			// 글번호, 카테고리(문의유형), 아이디, 제목, 작성일, 조회수 입력
			String sql = "INSERT INTO qnas(qna_no, qna_category, user_id, qna_title, qna_content, qna_date, qna_view)"
					+ " VALUES(seq_qna_no.nextval, ?, ?, ?, ?, sysdate, 0)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, qcreateDTO.getQna_category());
			pstmt.setString(2, qcreateDTO.getUser_id());
			pstmt.setString(3, qcreateDTO.getQna_title());
			pstmt.setString(4, qcreateDTO.getQna_content());

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
		// 생성 완료되면 1
		return rows;
	}

	// QNA 게시판 게시글 수정(QUpdate()-QupdateDTO)
	public static int QUpdate(QupdateDTO qupdateDTO, Connection conn) {
		int rows = 0;
		try {
			// 카테고리, 제목, 내용 수정
			// 게시글을 수정하려는 사람이 해당 게시글을 작성한 작성자 본인인지 확인하기 위해 QmatchDAO 필요
			String sql = "UPDATE qnas SET qna_category = ?, qna_title = ?, qna_content = ?, qna_date = sysdate WHERE qna_no = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, qupdateDTO.getQna_category());
			pstmt.setString(2, qupdateDTO.getQna_title());
			pstmt.setString(3, qupdateDTO.getQna_content());
			pstmt.setInt(4, qupdateDTO.getQna_no());

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
		// 수정 완료되면 1
		return rows;
	}

	// QNA 게시판 게시글 삭제(QDelete()-QdeleteDTO)
	public static int QDelete(QdeleteDTO qdeleteDTO, Connection conn) {
		int rows = 0;
		// 게시글을 삭제하려는 사람이 해당 게시글을 작성한 작성자 본인인지 확인하기 위해 QmatchDAO 필요
		try {
			String sql = "DELETE FROM qnas WHERE qna_no=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qdeleteDTO.getQna_no());

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
		// 삭제 완료되면 1
		return rows;
	}

	// QNA 게시판 글 조회(QRead()-QreadDTO)
	public static QreadDTO QRead(QreadDTO qreadDTO, Connection conn) {
		QreadDTO qread = new QreadDTO();
		try {
			// 전체 게시글 중 글번호 입력해서 상세 내용 조회하기
			// 게시글을 조회하려는 사람이 해당 게시글을 작성한 작성자 본인인지 확인하기 위해 QmatchDAO 필요
			String sql = "SELECT * FROM qnas q, (SELECT user_id FROM users u)u WHERE q.user_id = u.user_id AND qna_no=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qreadDTO.getQna_no());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				qread.setQna_no(rs.getInt("qna_no"));
				qread.setQna_category(rs.getString("qna_category"));
				qread.setUser_id(rs.getString("user_id"));
				qread.setQna_title(rs.getString("qna_title"));
				qread.setQna_content(rs.getString("qna_content"));
				qread.setQna_date(rs.getDate("qna_date"));
				qread.setQna_view(rs.getInt("qna_view"));
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
		return qread;
	}

	// QmatchDAO : 게시글 수정/삭제/조회시 원글을 작성한 본인이 맞는지 확인하는 메소드
	public static boolean QMatch(String user_id, int qna_no, Connection conn) {
		boolean isMine = false;
		try {
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

	// QNA 게시판 조회수 카운트 (QViewcount()-QviewcountDTO)
	public static int QViewcount(QviewcountDTO qviewcountDTO, Connection conn) {
		int rows = 0;
		try {
			// 조회수 +1
			String sql = "UPDATE qnas SET qna_view = qna_view + 1 WHERE qna_no= ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qviewcountDTO.getQna_no());

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
		// 업데이트 되면 1
		return rows;
	}
}