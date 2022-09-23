package ch14.sec06.exam01;

public class SynchronizedExample {

	public static void main(String[] args) {
		//공유객체
		Calculator calculator = new Calculator();
		
		//스레드1
		User1Thread user1Thread = new User1Thread();
		user1Thread.setCalculator(calculator);
		user1Thread.start();
		
		//스레드2
		User2Thread user2Thread = new User2Thread();
		user2Thread.setCalculator(calculator);
		user2Thread.start();

	}

}
