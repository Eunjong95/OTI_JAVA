package ch03.sec05;

import java.util.Scanner;

public class InfinityAndNaNCheckExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("x: ");
		int x = Integer.parseInt(scanner.nextLine());
		
		System.out.print("y: ");
		double y = Double.parseDouble(scanner.nextLine());
		
		double z = x / y;
		//double  z = x % y;
		
		if(Double.isInfinite(z) || Double.isNaN(z) ) {
			System.out.println("값 산출 불가");
		} else {
			System.out.println("z: " + z);
		    System.out.println("z + 2: " + (z+2));	
		}
		
		//int result = 5 / 0;	//실행 에러
		double result = 5 / 0.0;	//정상 실행
	}
}