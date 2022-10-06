package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {
	// 필드
	ChatServer chatServer;
	Socket socket; // 연결 끊을 때 필요
	String chatName;
	String clientIp;
	DataInputStream dis;
	DataOutputStream dos;

	// 생성자
	public SocketClient(ChatServer chatServer, Socket socket) {

		try {
			this.chatServer = chatServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			this.clientIp = isa.getHostName();
			receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 메소드: JSON에 받기
	public void receive() {
		chatServer.threadPool.execute(() -> {
			try {
				while (true) {
					// {"command": "incoming", "data" : "chatName"}
					// {"command": "message", "data" : "xxx" }
					String receiveJson = dis.readUTF(); // 예외 발생: 클라이언트가 종료해버림

					JSONObject jsonObject = new JSONObject(receiveJson);
					String command = jsonObject.getString("command");

					switch (command) {
					case "incoming":
						this.chatName = jsonObject.getString("data"); // this는 SocketClient
						chatServer.sendToAll(this, "들어오셨습니다.");
						chatServer.addSocketClient(this);
						break;
					case "message":
						String message = jsonObject.getString("data");
						chatServer.sendToAll(this, message);
						break;
					}
				}
			} catch (IOException e) {
				chatServer.sendToAll(this, "나가셨습니다.");
				chatServer.removeSocketClient(this);
			}
		});
	}

	// 메소드: JSON 보내기
	public void send(String json) { // ChatServer의 sendToAll() 메소드에서 호출됨
		try {
			dos.writeUTF(json); // 예외 발생
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 메소드: 연결 종료
	public void close() {
		try {
			socket.close(); // 예외 발생, ChatServer의 stop()메소드에서 호출됨
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
