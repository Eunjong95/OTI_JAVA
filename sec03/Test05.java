package practice01.sec03; 

import java.util.Scanner;

public class Test05 {

   public static void main(String[] args) {
      
      Scanner sc=new Scanner(System.in);
      int N=Integer.parseInt(sc.nextLine());//암기가능수
      int W=Integer.parseInt(sc.nextLine());//선생님 불어준 단어
      String c=sc.nextLine();
      String[] cut=c.split(" ");
      String[] arr=new String[W];//선생님이 불러준 단어 배열
      String[] arr1=new String[N];  //암기하는 단어 배열
      int sum=0;
      int result=0;      
      int cnt=0;//걸린시간 카운트
      int plus=1;
      int len=0;

      //선생님이 불러주는 단어
      for(int i=0;i<W;i++) { //쌤이 불러주는 단어보다 적으면 쌤이 불러준 단어에 스플릿 돼서 들어감
         arr[i]=cut[i];
      }
      
      //초기 배열 값
      for(int i=0;i<N;i++) { //암기가능수보다 적으면 불러준 단어가 암기가능배열에 들어감
         arr1[i]=arr[i];
         cnt+=3; //새로운 단어니까 3씩 +되면서
      }
      
      //hi hello bye hi what bye good smart creative create
      for(int i=0;i<arr.length-arr1.length;i++) { //만약 쌤이 불러준 단어에서 내가 암기한 단어 뺀 길이보다 적으면 반복
         if(i<(arr.length-arr1.length-1)) { //만약 쌤이 불러준 단어보다 내가 암기한게 적어 그러면 더 외워야지 그래서 아래 식 
            len=arr1.length+plus;  //내가 암기하는 단어 배열에 p를 더하면 그게 새로운 단어가 들어간 int배열 len
         }
         
         sum=0; //sum=length의 값을 더한 값 / 초기화 한 거
         for(int j=0;j<arr1.length;j++) {  //암기가능한 단어 배열수가 될때까지
            sum+=arr1[j].length();//arr1배열의 각 인덱스의 길이 더하기->그래야 평균을 구하지    
         }   
         result=sum/arr1.length;//길이평균
         for(int j=0;j<arr1.length;j++) { //암기하는 배열 길이까지
            if(arr1[j].equals(arr[len])) { //len은 선생님이 새로준 단어, len이랑 arr1[j]자리값이 같으면 
               arr1[0]=null;//처음값에 쓰레기 입력 (오래된 단어 객체 참조를 삭제)
               for(int k=0;k<N;k++) {  //변수k가 암기가능수가 되기 전까지
                  if(k<N-1) { //암기가능수보다 하나 적어야 새로 들어오니까
                     arr1[k]=arr1[k+1]; //새로 단어가 들어온게 arr1[k]값에 대입
                  }else{ //n-1보다 작지 않으면 
                     arr1[N-1]=arr[len];  //N-1인 이유는 k<N이라, 선생님이 새로준 단어가 암기가능배열에 들어감

                  }
               }
               plus++;  //선생님이 하나씩 계속 주는 단어
               cnt++;
               break;
            }else {   
               for(int k=0;k<arr1.length;k++) {  //기억가능한 길이까지
                  if(arr1[k].length()>result) { //길이 평균이 결과값보다 크면 다음 arr1[인덱스]로 넘어가
                     continue;
                  }else {
                     arr1[k]=arr[len]; //길이평균이 새로운 단어랑 같으면 대체돼
                     break;
                     }
                  }
               plus++;
               cnt+=3;
               break;
               }
            }
         
      }
      System.out.println(cnt);
   }
}
   
   