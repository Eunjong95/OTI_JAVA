package practice01.sec03;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int N=Integer.parseInt(sc.nextLine()); //사과의 개수
	    String[][] arr=new String[N][3]; //[사과의 개수][세로로 사과+원통1+원통2]
	    String count=sc.nextLine(); //점수
	    String[] cut=count.split(" "); //split()메소드로 점수 자르기
	    String three= sc.nextLine(); //원통1 줄
	    String four=sc.nextLine(); //원통2 줄
	      
	    int sum=0; //총 점수
	      
	    for(int i=0;i<N;i++) {
	    	arr[i][0]=cut[i]; //자른 점수 하나가 arr[i][0]에 대입
	    	
	    	char three1= three.charAt(i); //원통1 줄의 자리(=i)하나가 char three1에 들어감
	        arr[i][1]=String.valueOf(three1); //char는 기본타입이라 String타입으로 바꿔서 arr[i][1]에 대입
	        
	        char four1=four.charAt(i); //원통2 줄의 O/X하나가 char three1에 들어감
	        arr[i][2]=String.valueOf(four1);
	                  
	        if((arr[i][1].equals("O"))&&(arr[i][2].equals("O"))) { //arr[i][1] 그리고 arr[i][2]에 둘 다 O가 들어갔을때
	        	sum+=Integer.parseInt(arr[i][0]);  //arr[i][0]의 값이 int로 변환되어서 총합이 나옴
	        	}	         
	        }
	      System.out.println(sum); 
	      }	
}  