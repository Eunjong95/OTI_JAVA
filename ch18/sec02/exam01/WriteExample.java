package ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) {
//		OutputStream os = null; //os.close()를 써주기 위해 여기서 선언
//		try {
//			os = new FileOutputStream("C:/Temp/test1.db");
//
//			byte a = 10;
//
//			os.write(a);
//
//			os.flush();
//			
//			System.out.println("저장 성공");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				os.close(); //close에서 에러나면 특별히 예외처리 해줄 내용 없음
//			} catch (IOException e) { 
//			}
//		}

		// FileOutputStream이 Autocloseable을 구현하고 있어서 이렇게 코드 작성해도 스트림 닫기 가능
		try {
			OutputStream os = new FileOutputStream("C:/Temp/test1.db");

			byte a = 10;
			byte b = 20;
			byte c = 30;

			os.write(a);
			os.write(b);
			os.write(c);
			
			//내부 버퍼에 잔류하는 바이트를 출력하고 버퍼를 비움
			os.flush();

			System.out.println("저장 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
