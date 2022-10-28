package book;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

import eunjongDTO.JusersDTO;
import eunjongDTO.QcreateDTO;
import eunjongDTO.QdeleteDTO;
import eunjongDTO.QreadDTO;
import eunjongDTO.QupdateDTO;
import eunjongDTO.QviewcountDTO;
import eunjongService.JoinLoginService;
import eunjongService.QnaService;

public class SocketClient {
	BookServer bookServer;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	// 연결된 고객ip
	String clientIp;

	// 은종 - qna, 회원가입, 로그인 소켓
	public SocketClient(BookServer bookServer, Socket socket) {
		try {
			this.bookServer = bookServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			this.clientIp = socketAddress.getHostName();
			receive();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// 클라이언트 요청({"command": "", "data" = {}}
	public void receive() {
		bookServer.threadPool.execute(() -> {
			try {
				while (true) {
					String receiveJson = dis.readUTF();
					JSONObject jsonObject = new JSONObject(receiveJson);

					String command = jsonObject.getString("command");
					JSONObject data = jsonObject.getJSONObject("data");

					switch (command) {
					// Qna 게시판
					case "QList":
						send(new QnaService().QList(ConnectionProvider.getConnection()).toString());
						break;

					case "QCreate":
						QcreateDTO qcreateDTO = new QcreateDTO();
						qcreateDTO.setQna_category(data.getString("qnaCategory"));
						qcreateDTO.setUser_id(data.getString("userId"));
						qcreateDTO.setQna_title(data.getString("qnaTitle"));
						qcreateDTO.setQna_content(data.getString("qnaContent"));

						send(new QnaService().QCreate(qcreateDTO, ConnectionProvider.getConnection()).toString());
						break;

					case "QUpdate":
						QupdateDTO qupdateDTO = new QupdateDTO();
						qupdateDTO.setQna_category(data.getString("qnaCategory"));
						qupdateDTO.setQna_title(data.getString("qna_Title"));
						qupdateDTO.setQna_content(data.getString("qnaContent"));
						qupdateDTO.setQna_no(data.getInt("qnaNo"));

						send(new QnaService().QUpdate(qupdateDTO, ConnectionProvider.getConnection()).toString());
						break;

					case "QDelete":
						QdeleteDTO qdeleteDTO = new QdeleteDTO();
						qdeleteDTO.setQna_no(data.getInt("qnaNo"));

						send(new QnaService().QDelete(qdeleteDTO, ConnectionProvider.getConnection()).toString());

					case "QRead":
						QreadDTO qreadDTO = new QreadDTO();
						qreadDTO.setQna_no(data.getInt("qnaNo"));

						send(new QnaService().QRead(qreadDTO, ConnectionProvider.getConnection()).toString());

						// 본인 글인지 체크
					case "QMatch":
						send(new QnaService().QMatch(data.getString("userId"), data.getInt("qnaNo"),
								ConnectionProvider.getConnection()).toString());

					case "QViewcount":
						QviewcountDTO qviewcountDTO = new QviewcountDTO();
						qviewcountDTO.setQna_no(data.getInt("qnaNo"));

						send(new QnaService().QViewcount(qviewcountDTO, ConnectionProvider.getConnection()).toString());

						// 회원가입(Join)
					case "JoinUser":
						JusersDTO jusersDTO = new JusersDTO();
						jusersDTO.setUser_id(data.getString("userId"));
						jusersDTO.setUser_password(data.getString("userPassword"));
						jusersDTO.setUser_name(data.getString("userName"));
						jusersDTO.setUser_email(data.getString("userEmail"));
						jusersDTO.setUser_birth(data.getString("userBirth"));
						jusersDTO.setUser_gender(data.getString("userGender").charAt(0));
						jusersDTO.setUser_tel(data.getString("userTel"));
						jusersDTO.setUser_address(data.getString("userAddress"));

						send(new JoinLoginService().JoinUser(jusersDTO, ConnectionProvider.getConnection()).toString());

						// 회원가입시 아이디 존재 여부 체크
					case "JUserid":
						send(new JoinLoginService()
								.JUserid(data.getString("userId"), ConnectionProvider.getConnection()).toString());

						// 로그인(Login)
					case "Login":
						send(new JoinLoginService().Login(data.getString("userId"), data.getString("userPassword"),
								ConnectionProvider.getConnection()).toString());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
		}
	}

	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
		}
	}
}