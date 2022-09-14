package ch08.sec06;

public class RemoteControlExample {

	public static void main(String[] args) {

		RemoteControl rc;

		rc = new Television();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();

		// 인터페이스에 정의된 setMute 실행
		rc.setMute(true);
		rc.setMute(false);
		System.out.println("현재 볼륨: " + rc.getVolume());

		rc = new Audio();
		rc.setVolume(7);
		rc.setMute(true);
		rc.setMute(false);
		System.out.println("현재 볼륨: " + rc.getVolume());

		RemoteControl.changeBattery();
	}

}
