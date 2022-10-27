package eunjongService;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import eunjongDAO.ConnectionProvider;
import eunjongDAO.QnasDAO;
import eunjongDTO.QcreateDTO;
import eunjongDTO.QdeleteDTO;
import eunjongDTO.QnasDTO;
import eunjongDTO.QreadDTO;
import eunjongDTO.QupdateDTO;
import eunjongDTO.QviewcountDTO;

public class QnaService {
	// 값 확인해보기
	public static void main(String args[]) {
		// QCreat() 데이터 값 보내기
		QcreateDTO qcreateDTO = new QcreateDTO();
		qcreateDTO.setQna_category("결제");
		qcreateDTO.setUser_id("eunjong");
		qcreateDTO.setQna_title("배송");
		qcreateDTO.setQna_content("배송");

		QnaService qnaService = new QnaService();
		JSONObject jo = qnaService.QCreate(qcreateDTO);

		System.out.println(jo.getInt("data"));
		
		/*
		// 리스트/배열 형태 데이터 값 보내기
		ArrayList<adminBook> list = adminDAO.adminBookListByBookName(ConnectionProvider.getConnection(), "영어");
		adminService adminService = new adminService();
		JSONObject get = adminService.adminUserOrderList(ConnectionProvider.getConnection(), "taehee");
		System.out.println(get.toString());

		JSONObject jo = adminService.adminBookListBySales(ConnectionProvider.getConnection());
		JSONArray arr = jo.getJSONArray("data");
		for (int i = 0; i < arr.length(); i++) {
			System.out.println(arr.get(i).toString());
		}
		*/
	}

	// QNA 게시판 목록 조회
	public JSONObject QList() {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QList");
		JSONArray dataArr = new JSONArray(); // 여러 행이라 배열로 받기

		ArrayList<QnasDTO> list = QnasDAO.QList(ConnectionProvider.getConnection());
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
	public JSONObject QCreate(QcreateDTO qcreateDTO) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QCreate");

		int rows = QnasDAO.QCreate(qcreateDTO, ConnectionProvider.getConnection());
		sendObject.put("data", rows); // 수행 확인만 하면 되니까 rows로 받기
		return sendObject;
	}

	// QNA 게시판 게시글 수정
	public JSONObject QUpdate(QupdateDTO qupdateDTO) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QUpdate");

		int rows = QnasDAO.QUpdate(qupdateDTO, ConnectionProvider.getConnection());
		sendObject.put("data", rows);
		return sendObject;
	}

	// QNA 게시판 게시글 삭제
	public JSONObject QDelete(QdeleteDTO qdeleteDTO) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QUpdate");

		int rows = QnasDAO.QDelete(qdeleteDTO, ConnectionProvider.getConnection());
		sendObject.put("data", rows);
		return sendObject;
	}

	// QNA 게시판 글 조회
	public JSONObject QRead(QreadDTO qreadDTO) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QRead");

		QreadDTO qread = QnasDAO.QRead(qreadDTO, ConnectionProvider.getConnection());
		sendObject.put("data", qread); // 객체로 받기
		return sendObject;
	}

	// 게시글 수정/삭제/조회시 원글을 작성한 본인이 맞는지 확인
	public JSONObject QMatch(String user_id, int qna_no) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QMatch");

		boolean isMine = QnasDAO.QMatch(user_id, qna_no, ConnectionProvider.getConnection());
		sendObject.put("data", isMine); // 객체로 받기
		return sendObject;
	}

	// QNA 게시판 조회수 카운트
	public JSONObject QViewcount(QviewcountDTO qviewcountDTO) {
		QnasDAO qnasDAO = new QnasDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "QViewcount");

		int rows = QnasDAO.QViewcount(qviewcountDTO, ConnectionProvider.getConnection());
		sendObject.put("data", rows);
		return sendObject;
	}
}