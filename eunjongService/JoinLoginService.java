package eunjongService;

import java.sql.Connection;

import org.json.JSONObject;

import eunjongDAO.JoinDAO;
import eunjongDAO.LoginoutDAO;
import eunjongDTO.JusersDTO;

public class JoinLoginService {
	/*
	public static void main(String args[]) {
		// 값 검증해보기
		// JoinUser() 데이터 값 보내고 검증
		JusersDTO jusersDTO = new JusersDTO();
		jusersDTO.setUser_id("ej");
		jusersDTO.setUser_password("142313");
		jusersDTO.setUser_name("은종");
		jusersDTO.setUser_email("abc@def.com");
		jusersDTO.setUser_birth("00/01/01");
		jusersDTO.setUser_gender('F');
		jusersDTO.setUser_tel("010-3434-7777");
		jusersDTO.setUser_address("제주");

		JoinLoginService jls = new JoinLoginService();
		JSONObject jo = jls.JoinUser(jusersDTO, ConnectionProvider.getConnection());
		System.out.println(jo.getInt("data"));

		// JUserid() 검증
		JoinLoginService jls = new JoinLoginService();
		JSONObject jo = jls.JUserid("eunjong", ConnectionProvider.getConnection());
		System.out.println(jo.getBoolean("data"));

		// Login() 검증
		JoinLoginService jls = new JoinLoginService();
		JSONObject jo = jls.Login("eunjong", "cejjec", ConnectionProvider.getConnection());
		System.out.println(jo.get("data").toString());
	}
*/
	// 회원가입
	public JSONObject JoinUser(JusersDTO jusersDTO, Connection conn) {
		JoinDAO joinDAO = new JoinDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "JoinUser");

		int rows = joinDAO.JoinUser(jusersDTO, conn);
		sendObject.put("data", rows);
		return sendObject;
	}

	// 회원가입시 아이디 존재 여부에 대해 검사
	public JSONObject JUserid(String user_id, Connection conn) {
		JoinDAO joinDAO = new JoinDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "JUserid");

		boolean occupiedId = joinDAO.JUserid(user_id, conn);
		sendObject.put("data", occupiedId); // boolean 객체로 받기
		return sendObject;
	}

	// 로그인
	public JSONObject Login(String user_id, String user_password, Connection conn) {
		LoginoutDAO loginDAO = new LoginoutDAO();
		JSONObject sendObject = new JSONObject();
		sendObject.put("command", "Login");

		JusersDTO jusers = loginDAO.Login(user_id, user_password, conn);
		sendObject.put("data", jusers);
		return sendObject;
	}
}
