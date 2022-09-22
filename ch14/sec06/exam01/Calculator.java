package ch14.sec06.exam01;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	//동기화 메소드 선언
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}

	// 동기화 블록 선언
	public void setMemory2(int memory) {
		// ... 여러 스레드가 실행할 수 있는 영역
		synchronized (this) { 
			//단 하나의 스레드만 실행 가능한 영역
			this.memory = memory;
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			System.out.println(Thread.currentThread().getName() + ": " + this.memory);
		}
		// ... 여러 스레드가 실행할 수 있는 영역
	}
}
