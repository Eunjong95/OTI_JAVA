package practice01.sec02;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		int[] num = new int[7]; //입력받을 메인 배열
		Scanner input = new Scanner(System.in);
		String n = input.nextLine(); //input으로 저장한 값을 String n 에 넣어주고
		String[] j = n.split(","); //split()로 변수 n의 문자열 분리해서 배열에 넣었다
		int sum = 0;
		int min = 0;
		
		//입력값을 넣는 for문
		for(int k=0; k<num.length; k++) {
			num[k]= Integer.parseInt(j[k]); //쉼표로 나눠진 문자배열을 num[k]에 대입
			}
		
		for(int i=0; i<num.length; i++) {
			if((num[i]%2) == 0) {
				num[i] = 0; //배열의 짝수값에 0을 넣어줌으로써 홀수와 구분
				}
			sum += num[i]; //총 합
			}		
		
		if(sum == 0) {
			System.out.println("-1"); //홀수가 없다는 뜻
			} else {
			sum = 0; //위의 sum은 구분하기 위한 것이고 이건 총합을 보여주기 위한 것
			for(int i=0; i<num.length; i++) {
				if((num[i]%2) != 0) {
					sum += num[i];
					if(min>num[i]) {
						min=num[i]; 
						} else if(min==0) { //만약 최소값이 0이면 비교를 하기 위해 num[i]를 최소값에 대입
						min=num[i];
						} 	
					}
				}
			System.out.println("총 합 : " + sum);
			System.out.println("최소값 : " + min);
			}
		}
}