package eunjongService;

import java.sql.Connection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import eunjongDAO.QnasDAO;
import eunjongDTO.QcreateDTO;
import eunjongDTO.QdeleteDTO;
import eunjongDTO.QnasDTO;
import eunjongDTO.QreadDTO;
import eunjongDTO.QupdateDTO;
import eunjongDTO.QviewcountDTO;

public class QnaService {
/*
	public static void main(String args[]) {

		// 값 검증해보기
		// QMatch() 검증 - boolean 타입
		QnaService qnaService = new QnaService();
		JSONObject jo = qnaService.QMatch("eunjong", 100, ConnectionProvider.getConnection());
		System.out.println(jo.getBoolean("data"));

		// QCreate() 데이터 값 보내고 검증 - 값 입력해야하는 타입
		QcreateDTO qcreateDTO = new QcreateDTO();
		qcreateDTO.setQna_category("결제");
		qcreateDTO.setUser_id("eunjong");
		qcreateDTO.setQna_title("배송");
		qcreateDTO.setQna_content("배송");

		QnaService qnaService = new QnaService();
		JSONObject jo = qnaService.QCreate(qcreateDTO);
		System.out.println(jo.getInt("data"));

		// QList() 검증 - 다중 행 타입
		QnaService qnaService = new QnaService();
		JSONObject jo = qnaService.QList(ConnectionProvider.getConnection());
		JSONArray arr = jo.getJSONArray("data");
		for (int i = 0; i < arr.length(); i++) {
			System.out.println(arr.get(i).toString());
		}

		// QRead() 검증 - 객체 타입
		QnaService qnaService = new QnaService();
		QreadDTO qread = new QreadDTO();
		qread.setQna_no(5);

		JSONObject jo = qnaService.QRead(qread, ConnectionProvider.getConnection());
		System.out.println(jo.get("data").toString());
	}
*/
	// QNA 게시판 목록 조회
	public JSONObject QList(Connection conn) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QList");
		JSONArray dataArr = new JSONArray(); // 여러 행이라 배열로 받기

		ArrayList<QnasDTO> list = qnasDAO.QList(conn);
		for (QnasDTO qboard : list) {
			JSONObject jo = new JSONObject();
			jo.put("qnaNo", qboard.getQna_no());
			jo.put("qnaCategory", qboard.getQna_category());
			jo.put("userId", qboard.getUser_id());
			jo.put("qnaTitle", qboard.getQna_title());
			jo.put("qnaDate", qboard.getQna_date());
			jo.put("qnaView", qboard.getQna_view());
			dataArr.put(jo);
		}
		sendObject.put("data", dataArr);
		return sendObject;
	}

	// QNA 게시판 새 글 작성
	public JSONObject QCreate(QcreateDTO qcreateDTO, Connection conn) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QCreate");

		int rows = qnasDAO.QCreate(qcreateDTO, conn);
		sendObject.put("data", rows); // 수행 확인만 하면 되니까 rows로 받기
		return sendObject;
	}

	// QNA 게시판 게시글 수정
	public JSONObject QUpdate(QupdateDTO qupdateDTO, Connection conn) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QUpdate");

		int rows = qnasDAO.QUpdate(qupdateDTO, conn);
		sendObject.put("data", rows);
		return sendObject;
	}

	// QNA 게시판 게시글 삭제
	public JSONObject QDelete(QdeleteDTO qdeleteDTO, Connection conn) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QUpdate");

		int rows = qnasDAO.QDelete(qdeleteDTO, conn);
		sendObject.put("data", rows);
		return sendObject;
	}

	// QNA 게시판 글 조회
	public JSONObject QRead(QreadDTO qreadDTO, Connection conn) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QRead");

		QreadDTO qread = qnasDAO.QRead(qreadDTO, conn);
		sendObject.put("data", qread); // 객체로 받기
		return sendObject;
	}

	// 게시글 수정/삭제/조회시 원글을 작성한 본인이 맞는지 확인
	public JSONObject QMatch(String user_id, int qna_no, Connection conn) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QMatch");

		boolean isMine = qnasDAO.QMatch(user_id, qna_no, conn);
		sendObject.put("data", isMine); // 객체로 받기
		return sendObject;
	}

	// QNA 게시판 조회수 카운트
	public JSONObject QViewcount(QviewcountDTO qviewcountDTO, Connection conn) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QViewcount");

		int rows = qnasDAO.QViewcount(qviewcountDTO, conn);
		sendObject.put("data", rows);
		return sendObject;
	}
}