package practice01.sec02;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		int[] num = new int[3];
		Scanner sc = new Scanner(System.in);
		String eng = sc.nextLine(); //eng에 입력값을 저장
		String[] no = eng.split(",");
		int total = 1; //0곱하기 n은 0이니까
		
		for(int i=0; i<num.length; i++) {
			num[i] = Integer.parseInt(no[i]);		
			total *= num[i];			
			}
		System.out.println(total);
		
		String k = String.valueOf(total); //밑에서 길이를 정하기 위해 스트링변수로 변환
		int[] num2 = new int[k.length()];
		int[] num3 = new int[10];
		
		for(int i=0; i<k.length(); i++) {
			num2[i] = total%10;
			total/=10;
			if(total<0) {//0보다 작은 수가 들어가면 쓸 수가 없어져서
				break;
				} else {
				int j = num2[i];
				switch(j) {
				case 0: num3[0]+=1; break;	
				case 1: num3[1]+=1; break;
				case 2: num3[2]+=1; break;
				case 3: num3[3]+=1; break;
				case 4: num3[4]+=1; break;
				case 5: num3[5]+=1; break;
				case 6: num3[6]+=1; break;
				case 7: num3[7]+=1; break;
				case 8: num3[8]+=1; break;
				case 9: num3[9]+=1; break;
				}
				}
			}
		
		for(int i=0; i<10; i++) {
			System.out.println(num3[i]);		
			}
		}
}