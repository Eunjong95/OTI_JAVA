package ch08.sec02;

public class RemoteControlExample {

	public static void main(String[] args) {
		// 타입 변수 선언
		RemoteControl rc;
		//RemoteControl이라는 인터페이스를 통해서 Television 객체를 사용하겠다는 의미
		rc = new Television();		
		rc.turnOn();
		
		// rc 추상 메소드 재정의 -> 다형성
		rc = new Audio();
		rc.turnOn();
	}

}
