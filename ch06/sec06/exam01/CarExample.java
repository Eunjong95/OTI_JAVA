package ch06.sec06.exam01;

public class CarExample {

	public static void main(String[] args) {
		//Car 객체 생성
		Car myCar = new Car();
		//타입 (번지 내)변수명 = Car클래스에서 가져온 객체의 번지 리턴
		
		//Car 객체의 필드값 읽기
		//myCar 객체가 가지고 있는 model이라는 필드
		System.out.println("모델명: " + myCar.model);
		System.out.println("시동 여부: " + myCar.start);
		System.out.println("현재속도: " + myCar.speed);

	}

}
