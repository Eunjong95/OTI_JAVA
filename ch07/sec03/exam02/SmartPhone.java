package ch07.sec03.exam02;

public class SmartPhone extends Phone {
	//생성자 선언
	public SmartPhone(String model, String color) {
		//super(); 명시적으로 작성해도 됨 생략하면 컴파일시 자동 추가
		this.model = model;
		this.color = color;
		System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
	}
}
