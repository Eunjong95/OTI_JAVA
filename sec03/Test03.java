package practice01.sec03;

import java.util.Scanner;

public class Test03 {

	 public static void main(String[] args) {
		      Scanner scanner = new Scanner(System.in);
		      String word = scanner.nextLine();
		      char[] password = new char[word.length()]; //length 문자열에서 문자의 개수

		      for (int i = 0; i < password.length; i++) {
		         password[i] = word.charAt(i); //word에 있는 i번째 char타입을 password[i]에 대입
		         if (password[i] > 'v') { //z뒤로 넘어가는 부분
		            password[i] -= 22;
		            } else {
		            password[i] += 4;
		            } System.out.print(password[i]);
		            }
		      }
	 }


// 문자열에서 특정 위치의 문자를 얻는 charAt()메소드 사용