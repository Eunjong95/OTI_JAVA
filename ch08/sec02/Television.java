package ch08.sec02;

public class Television implements RemoteControl{

	@Override
	public void turnOn() { //public 빼면 컴파일 에러남 -> 접근제한을 더 강화할 수 없음(public->default)
		System.out.println("TV를 켭니다.");
		
	}
	
}
