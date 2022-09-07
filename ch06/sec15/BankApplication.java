package ch06.sec15;

import java.util.Scanner;

public class BankApplication {
	static Account[] array = new Account [100];
	static Scanner sc = new Scanner(System.in);
	static int index = 0;
	
	public static void main(String[] args) {

		boolean run = true;
		while(run) {
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택> ");
			String input = sc.nextLine();
			
			if(input.equals("1")) {
				System.out.println("---------");
				System.out.println("계좌생성");
				System.out.println("---------");
				System.out.print("계좌번호: ");
				String account = sc.nextLine();
				System.out.print("계좌주: ");
				String name = sc.nextLine();
				System.out.print("초기입금액: ");
				int money = sc.nextInt();
				System.out.print("결과: 계좌가 생성되었습니다. ");
				System.out.println();
				
				Account ac = new Account(account, name, money);
				array[index] = ac;
				index++;
				
			} if(input.equals("2")) {
				System.out.println("---------");
				System.out.println("계좌목록");
				System.out.println("---------");
				for(int i=0; i<array.length; i++) {
					if(array[i] != null) {
						System.out.print(array[i].getAccount()+"\t");
						System.out.print(array[i].getName()+"\t");
						System.out.print(array[i].getMoney());
						System.out.println();
					}		
				}
				
			} if(input.equals("3")) {
				System.out.println("---------");
				System.out.println("예금");
				System.out.println("---------");
				System.out.print("계좌번호: ");
				String account = sc.nextLine();
				System.out.print("예금액: ");
				int money = sc.nextInt();
				for(int i=0; i<array.length; i++) {
					if(array[i] != null && array[i].getAccount().equals(account)) {
						array[i].money = array[i].getMoney() + money;
					}
				} System.out.println("결과: 예금이 성공되었습니다.");
				
			} if(input.equals("4")) {
				System.out.println("---------");
				System.out.println("출금");
				System.out.println("---------");
				System.out.print("계좌번호: ");
				String account = sc.nextLine();
				System.out.print("출금액: ");
				int money = sc.nextInt();
				for(int i=0; i<array.length; i++) {
					if(array[i] != null && array[i].getAccount().equals(account)) {
						array[i].money = array[i].getMoney() - money;
					}
				} System.out.println("결과: 출금이 성공되었습니다.");
				
			} if(input.equals("5")) {
				System.out.println("프로그램 종료");
				break;
			}		
		}				
	}	
}