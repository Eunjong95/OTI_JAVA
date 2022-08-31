package practice01.sec03;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("시작수 : ");
		int first = Integer.parseInt(sc.nextLine());
		System.out.print("끝수 : ");
		int end = Integer.parseInt(sc.nextLine());
		int[] arr = new int[end]; //end의 크기값을 넣어줌
		int j = first;
		System.out.print("배수 :");
		int multiple = Integer.parseInt(sc.nextLine());
		int sum = 0;
		
		for(int i=0; i<end; i++) {
			arr[i] = j; //만약 i에 5가 들어가면 arr[i]에 5=j가 되고 j는 ++돼서 6이 됨 
		    j++;  //끝수까지 돌려주기 위해 필요한 식
		    if(arr[i]%multiple == 0) { //나머지가 0이면 배수
		    	sum += arr[i];         
		    	}
		    }
		/* 같은 식
		int j=0;
		for(int i=first;i<=end;i++) {
			arr[j]=i;
			j++;
		}*/
		System.out.println(sum);	      
		}
	}