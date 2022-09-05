package ch06.sec08.exam01;

import java.util.Scanner;

public class CalculatorExample {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//Calculator 객체 생성
		Calculator myCalc = new Calculator();
		
		//리턴값이 없는 powerOn()메소드 호출
		myCalc.powerOn();
		
		//plus() 메소드를 호출 시 5와 6을 매개값으로 제공하고
		//결과를 리턴받아 result1의 변수에 대입
		int result1 = myCalc.plus(5,6);
		System.out.println("result1: " + result1);
		
		int x = 10;
		int y = 4;
		
		//divide() 메소드 호출 시 변수 x와 y의 값을 매개값으로 제공하고
		//결과를 리턴받아 result2의 변수에 대입
		double result2 = myCalc.divide(x, y);
		System.out.println("result2: " + result2);
		
		//리턴값이 없는 powerOff()메소드 호출
		myCalc.powerOff();
		
		//크기가 클 수 있으니 long타입 사용, 변수 x와 y의 값을 매개값으로 제공하고
		//결과를 리턴받아 result3의 변수에 대입
		long result3 = myCalc.power(2,3);
		System.out.println("result3: " + result3);
		
		//크기가 클 수 있으니 long타입 사용, 변수 n의 값을 매개값으로 제공하고
		//결과를 리턴받아 result4의 변수에 대입
		long result4 = myCalc.factorial(5);
		System.out.println("result4: " + result4);
		
		//키보드에서 입력 받으니까 리턴값 없음
		double a = Double.parseDouble(sc.nextLine());
		double b = Double.parseDouble(sc.nextLine());
		myCalc.divide2(a,b);
		
		//랜덤 주사위 케이스
		int result6 = myCalc.randomNum(2,10);
		System.out.println("result6: " + result6);
	}
}