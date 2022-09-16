package ch11.sec06;

public class Account {
	//Field
	private long balance;
	private String owner;
	//Constructor
	public Account() {}
	
	//외부에서 읽을 수 있게 getter 생성
	public long getBalance()  {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) throws InsufficientException { //예외 발생 코드
		if(balance < money) {
			throw new InsufficientException("잔고 부족: " + (money-balance) + " 모자람"); //예외 발생 이유
		}
		balance -= money;
	} 
	

}
