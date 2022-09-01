package practice01.sec04;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] mont = sc.nextLine().split(""); //등고선 나누기
		int stairs = 0; //계단 변수
		int sum = 0; //소비한 칼로리의 합
		boolean sloop = true; //급경사를 위한 boolean
		int x = 1; //칼로리
		
		for(int i=0; i<mont.length; i++) {
			switch(mont[i]) {
			case "(" : 
				stairs++;
				sum += stairs*x; 
				break;
		
			case "#" : 
				if(sloop) { //true면 급경사를 만난 것
					x = 2; //칼로리 2배
					sloop = false; 
					} else { //sloop가 false면(급경사가 아니면)
					x = 1; //칼로리가 1배이고
					sloop = true; 
					} 				
				break;
				
			default :
				sum += stairs*x; //위치한 높이를 세는거라 sum부터 시작
				stairs--; //계단 내려오는 코드
				} 							
			} System.out.print(sum); //for문 바깥에 쓰기
			} 	
	}