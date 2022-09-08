package ch07.sec03.exam02;

public class Phone {
	//필드 선언
	public String model;
	public String color;
	
	//생성자 선언
	public Phone() { //매개변수 추가하면 자식클래스 super()에 매개변수 추가해줘야함
		//this.model = model;
		//this.color = color;
		System.out.println("Phnoe() 생성자 실행");
	}

}
