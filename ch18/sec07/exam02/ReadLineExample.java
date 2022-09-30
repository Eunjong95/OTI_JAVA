package ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadLineExample {

	public static void main(String[] args) throws Exception {
		//FileReader에 BufferedReader 보조 스트림 연결
		BufferedReader br = new BufferedReader(new FileReader("src/ch18/sec07/exam02/ReadLineExample.java"));

		//lineNo 초기값 설정
		int lineNo = 1;
		while (true) {
			String str = br.readLine(); //행 한 줄씩 읽음
			if (str == null) //readline()은 -1 대신 null 사용
				break;
			System.out.println(lineNo + "\t" + str);
			lineNo++;
		}
		//br 닫으면 연결된 FileReader도 닫힘
		br.close();
	}	
}
