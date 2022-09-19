package ch12.sec05;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ByteToStringExample {

	public static void main(String[] args) {

		String data = "a자바";

		try {
			//인코딩(encoding): String -> byte[]
			byte[] arr1 = data.getBytes("EUC-KR");
			System.out.println(arr1.length);
			System.out.println(Arrays.toString(arr1));
			
			//디코딩(decoding): byte[] -> String
			String data2 = new String(arr1, "EUC-KR");
			System.out.println(data2);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
