package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:/Temp/test2.db");

			byte[] data = new byte[100];

			while (true) { 
				int num = is.read(data); //한번에 100바이트까지 읽을 수 있고 읽은 바이트는 data에 저장
				if (num == -1)
					break;

				for (int i = 0; i < num; i++) {
					System.out.println(data[i]); //실제 읽은 바이트만 출력
				}
			}

			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
