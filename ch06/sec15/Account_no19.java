package ch06.sec15;

public class Account_no19 {
	private int balance;
	
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	
	public int getBalnce() {
		return balance;
	}
	
	public void setBalance(int balance) {
		if(balance<MIN_BALANCE || balance>MAX_BALANCE) { //실행문에서 생성자가 Account생성해줬기 때문에 Account.안써도 된다
			return;
		} else { //return있으면 안 써도 된다
			this.balance = balance;
		}
	}

}
