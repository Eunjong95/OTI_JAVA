package ch18.sec06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExample {
	public static void main(String[] args) throws Exception {
		write("문자 변환 스트림을 사용합니다.");
		String data = read();
		System.out.println(data);
	}

	public static void write(String str) throws IOException {
		OutputStream os = new FileOutputStream("C:/Temp/test.txt");
		Writer writer = new OutputStreamWriter(os, "UTF-8");
		writer.write(str);
		writer.flush();
		writer.close();
	}

	public static String read() throws IOException {
//		InputStream is = new FileInputStream("C:/Temp/test.txt");
//		Reader reader = new InputStreamReader(is, "UTF-8");
//		char[] data = new char[20]; // 바이트수 아니고 문자수임
//		int num = reader.read(data);
//		reader.close();
//		String str = new String(data, 0, num); // 실제로 읽은 문자수 리턴
//		return str;

		InputStream is = new FileInputStream("C:/Temp/test.txt");
		Reader reader = new InputStreamReader(is, "UTF-8");  //BufferedReader로 받으려면 Reader로 받아줘야해서 InputStreamReader 사용함
		BufferedReader br = new BufferedReader(reader);
		String str = br.readLine();
		return str;
	}
}

//try {
//OutputStream os = new FileOutputStream("C:/Temp/test.txt");
//
//String str = "문자 변환 스트림을 사용합니다.";
//
//byte[] data = str.getBytes("UTF-8"); // UTF-8 문자셋을 써서 인코딩 하겠다.
//
//os.write(data);
//os.flush();
//os.close();
//
//InputStream is = new FileInputStream("C:/Temp/test.txt");
//
//byte[] data = new byte[100];
//int num = is.read(data);
//String str2 = new String(data, "UTF-8");
//System.out.println(str2);
//
//} catch (IOException e) {
//e.printStackTrace();
//}
//
//try {
//write("문자 변환 스트림을 사용합니다.");
//String str2 = read();
//System.out.println(str2);
//} catch (IOException e) {
//e.printStackTrace();
//}
