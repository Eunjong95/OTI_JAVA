package eunjongService;

import org.json.JSONObject;

import eunjongDAO.ConnectionProvider;
import eunjongDAO.JoinDAO;
import eunjongDAO.LoginoutDAO;
import eunjongDTO.JusersDTO;

public class JoinLoginService {

	// 회원가입
	public JSONObject JoinUser(JusersDTO jusersDTO) {
		JoinDAO joinDAO = new JoinDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "JoinUser");

		int rows = JoinDAO.JoinUser(jusersDTO, ConnectionProvider.getConnection());
		sendObject.put("data", rows);
		return sendObject;
	}

	// 회원가입시 아이디 존재 여부에 대해 검사
	public JSONObject JUserid(String user_id) {
		JoinDAO joinDAO = new JoinDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "JUserid");

		boolean occupiedId = JoinDAO.JUserid(user_id, ConnectionProvider.getConnection());		
		sendObject.put("data", occupiedId); // boolean 객체로 받기
		return sendObject;
	}

	// 로그인
	public JSONObject Login(String user_id, String user_password) {
		LoginoutDAO loginDAO = new LoginoutDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "Login");

		JusersDTO jusers = LoginoutDAO.Login(user_id, user_password, ConnectionProvider.getConnection());
		sendObject.put("data", jusers);
		return sendObject;
	}
}
