package team01.project01;

import java.util.Scanner;

public class Crud_MutidimensionalArray {

	public static void main(String[] args) {
		String[][] boards = new String[100][4]; //boards 2차원 배열변수의 1차원수에는 100의 크기를, 2차원수에는 4의 크기를 선언했습니다. 
		Scanner sc = new Scanner(System.in);
		boolean run = true; //while의 true
		int no = 0; //1차원수를 선택하기위한 변수 초기화
		String d = "="; //처음 영은이의 블로그 메인을 꾸미기 위해 '='로 초기화 
		String x="	  영은이의 블로그		";
		String title = null, contents = null, writer = null; //boards 배열의 2차원수의 변수를 위한 초기화	
		
		while (run) {
			
			for(int i=0; i<30; i++) {
				System.out.print(d);
			}
			System.out.println();
			System.out.println();
			System.out.println(x);
			System.out.println();
			for(int i=0; i<30; i++) {
				System.out.print(d);
			}
			System.out.println();
			System.out.println();
			
			System.out.println("목차");
			
			//현재까지 create된 블로그의 No와 Title
			for(int i=0; i<boards.length; i++) {
				if(boards[i][0]!=null) {
					System.out.println("No . " + boards[i][0] + "    Title : " + boards[i][1]);
				} 	
			}
			
			System.out.println("---------------------------------------------");
			System.out.println("| 1. 글쓰기 | 2. 자세히 보기 | 3. 수정 | 4. 삭제 |");
			System.out.println("| 5. 검색  | 6. 꾸미기 | 7. 프로그램 종료  |");
			System.out.println("---------------------------------------------");
			System.out.print("입력> ");
			String input = sc.nextLine();
			System.out.println();
			
			if (input.equals("글쓰기") || input.equals("1")) {
				first : while(true) {
					System.out.print("글 No. : ");
					no = Integer.parseInt(sc.nextLine());
					
					if(boards[no][0] == null) {
						boards[no][0] = String.valueOf(no); 
						//boards배열은 string이고 no는 int이기 때문에 int값을 넣어주기 위해 no를 string변수로 변환해 boards배열에 저장했다
						
						System.out.print("제목 : ");
						title = sc.nextLine();
						boards[no][1] = title;
						
						System.out.print("본문 내용 : ");
						contents = sc.nextLine();
						boards[no][2] = contents;
						
						System.out.print("글쓴이 : ");
						writer = sc.nextLine();
						boards[no][3] = writer;
						System.out.println();
						
						//추가 글을 쓰기위한 반복문
						while(true) {
							System.out.print("글을 더 쓰시겠습니까?(yes/no) ");
							String again = sc.nextLine();
							if (again.equals("yes")) {
								break;
							} else if (again.equals("no")) {
								break first;//first while 반복문을 빠져나가기 위해 사용
							} else {
								System.out.println("값을 잘못 입력하셨습니다. ");
								continue;
							}
						}
					} else {
						System.out.println("값이 저장되어 있습니다.");
					}					
				}		
				
			} else if(input.equals("자세히 보기") || input.equals("2")) {			
				System.out.print("어느 페이지를 보시겠습니까? ");
				int read = Integer.parseInt(sc.nextLine());
				System.out.println("제목 : " + boards[read][1]);
				System.out.println("본문 내용 : " + boards[read][2]);
				System.out.println("글쓴이 : " + boards[read][3]);
				System.out.println();
				
			} else if(input.equals("수정") || input.equals("3")) {
				System.out.print("어느 페이지를 수정하시겠습니까? ");
				int modi = Integer.parseInt(sc.nextLine());	
				String array[] = {"제목", "본문 내용", "글쓴이"};
				if(boards[modi][0]==null) {
					System.out.println("수정할 페이지가 없습니다.");
					continue;
				}else {
					for(int i=0; i<array.length; i++) {
						System.out.print("[" + array[i] +"]을 수정하시겠습니까?(yes/no/pass) ");
						String yesOrNoOrPass = sc.nextLine();				
						if(yesOrNoOrPass.equals("yes")) {						
							System.out.println("저장된(" + array[i] + ") : " + boards[modi][i+1]);
							System.out.print("변경할(" + array[i] + ") : ");
							String change = sc.nextLine();
							boards[modi][i+1] = change;
						} else if(yesOrNoOrPass.equals("pass")) {
							continue;
						} else if(yesOrNoOrPass.equals("no")) {
							break;
						}			
					}
				}
				
			} else if(input.equals("삭제") || input.equals("4")) {
				System.out.print("어느 페이지를 삭제하시겠습니까? ");
				int delete = Integer.parseInt(sc.nextLine());
				if(boards[delete][0]==null) {
					System.out.println("삭제할 페이지가 없습니다.");
					continue;
				}else {
					for(int i=0;i<4;i++) { //쓰레기값을 만들어주기위한 반복문
						boards[delete][i]=null;
					}
				}
				
			} else if(input.equals("검색") || input.equals("5")) {
				String[] array = new String[boards.length];
				System.out.print("찾으시는 제목의 키워드를 입력해주세요. ");
				String search=sc.nextLine();
				for(int i=0;i<boards.length;i++) {
					if(boards[i][1] != null) {
						int index = boards[i][1].indexOf(search); //문자열 검색 연산자
						if(index==-1) {
							continue;
						} else {
							array[i] = boards[i][0];
							System.out.println("No. " + array[i]);
						}												
					}	
				}	
				
			} else if(input.equals("꾸미기") || input.equals("6")) {
				System.out.print("블로그명을 꾸미고 있는 ["+d+"]을 무엇으로 변경하실건가요? ");
				d = sc.nextLine();		
				System.out.print("변경하실 블로그명을 입력해주세요. ");
				x = sc.nextLine();
				
			} else if(input.equals("프로그램 종료") || input.equals("7")) {				
				System.out.println("프로그램이 종료됩니다. ");
				break;
			}				
		}		
	}	
}