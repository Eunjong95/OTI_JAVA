package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static void main(String[] args) {

		String originalFileName = "C:/Temp/test.jpg";
		String targetFileName = "C:/Temp/test2.jpg";
		
		//입출력 스트림 생성
		try (InputStream is = new FileInputStream(originalFileName);
				OutputStream os = new FileOutputStream(targetFileName)) {

			byte[] data = new byte[1024];
			while (true) {
				int num = is.read(data);
				if (num == -1)
					break;
				os.write(data, 0, num); //읽은 바이트 수만큼 출력
			}
//			is.transferTo(os); //19~25라인 대체 가능한 메소드
			os.flush(); //write() 썼으면 꼭 해줘야 함
			System.out.println("복사가 잘 되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
