package ch09.sec03.exam01;

public class AExample {

	public static void main(String[] args) {
		A.B b = new A.B(); //B가 static으로 선언되어있을 경우 이렇게 표현
		b.methodB();
	}
}
