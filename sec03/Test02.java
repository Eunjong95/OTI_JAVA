package practice01.sec03;

public class Test02 {

	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
				} System.out.println();
			} //끊어서 생각하기
		
		for(int i=5; i>0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
				} System.out.println(); 
			}
		}
}