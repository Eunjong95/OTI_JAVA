package ch06.sec15;

public class Account {
	String account;
	String name;
	int money;
	
	public Account(String account, String name, int money) {
		this.account = account;
		this.name = name;
		this.money = money;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	

}
