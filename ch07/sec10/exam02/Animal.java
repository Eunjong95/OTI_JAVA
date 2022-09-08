package ch07.sec10.exam02;

public abstract class Animal {
	// 메소드 선언
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}

	// 추상메소드 선언
	public abstract void sound();
}