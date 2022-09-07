package ch06.sec08.exam01;

public class Calculator {
	//리턴값이 없는 메소드 선언
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	//리턴값이 없는 메소드 선언
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	//호출 시 두 정수 값을 전달받고,
	//호출한 곳으로 결과값 int를 리턴하는 메소드 선언
	int plus(int x, int y) {
		int result = x + y;
		return result; //리턴값 지정;
	}
	
	//호출 시 두 정수 값을 전달받고,
	//호출한 곳으로 결과값 double을 리턴하는 메소드 선언
	double divide(int x, int y) {
		double result = (double)x / (double)y;
		return result; //리턴값 지정;
	}
		
	//두 수를 제공받아서 제곱근의 수를 리턴값으로 하는 메소드 선언
	long power(int x, int y) {
		long result = 1;
		for(int i=1; i<=y; i++) {
			result = result*x;
			}
		return result;
		}
				
	//한 수를 제공받고 팩토리얼n의 값을 리턴하는 메소드를 선언
	long factorial(int n) {
		long result = 1;
		for(int i=1; i<=n; i++) {
			result = (result*i); 
			}
		return result;
		}
	
	//키보드에서 입력받으니까 메소드의 매개변수는 없음
	//두 수를 입력받고 첫번째%두번째로 계산된 실수 값을 출력
	void divide2(double a, double b) {
		double result = a % b;
		System.out.println(result);
		}
	
	//시작값과 뽑을 경우의 수를 매개값으로 입력받고 
	//임의의 수를 뽑아서 리턴하는 메소드를 선언
	//(시작값과 뽑을 경우의 수는 정수)
	//(임의의 수는 뽑을 경우의 수에 포함됨)
	int randomNum(int x, int y) {
		int result = (int)(Math.random()*y) + x;
		return result;
		}
}