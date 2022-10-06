package ch19.sec03.exam01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket;

	public static void main(String[] args) {

		System.out.println("-------------------------------------------------");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter키를 입력하세요.");
		System.out.println("-------------------------------------------------");

		// TCP 서버 시작
		startServer();

		// 키보드 입력
		Scanner sc = new Scanner(System.in);
		while (true) {
			String key = sc.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}
		sc.close();

		// TCP 서버 종료
		stopServer();
	}

	public static void startServer() {
		// 작업 스레드 정의
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					// ServerSocket 생성 및 Port 바인딩
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");

					// 여러 클라이언트의 연결 요청을 수락하기 위해 무한 루프
					while (true) {
						System.out.println("\n[서버] 연결 요청을 기다림\n");
						// 연결 수락
						Socket socket = serverSocket.accept(); // 블로킹 상태 <- 클라이언트의 연결 요청이 들어오면 블로킹 해제
						// 연결된 클라이언트 정보 얻기
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						String clientIp = isa.getHostString();
						System.out.println("[서버]" + clientIp + "의 연결 요청을 수락함");
						// 연결 끊기
						socket.close();
						System.out.println("[서버]" + clientIp + "의 연결을 끊음");
					}
				} catch (IOException e) {
					System.out.println("[서버] " + e.getMessage());
				}
			}
		};
		// 스레드 시작
		thread.start();
	}

	public static void stopServer() {
		// ServerSocket을 닫고 Port 언바인딩
		try {
			serverSocket.close(); // close()때문에 50라인의 accept()가 갑자기 중지가 돼서 예외 발생함
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}