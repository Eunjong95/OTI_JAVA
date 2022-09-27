package ch16.sec03;

public class LambdaExample {

	public static void main(String[] args) {

		Person person = new Person();

		// 매개변수에 n, j 넣어도 됨. 개수가 중요한거지 이름이 중요한게 아니다.
		person.action1((name, job) -> {
			System.out.print(name + "이 ");
			System.out.println(job + "을 합니다.");
		});
		
		//실행문 하나일 경우 중괄호 생략 가능
		person.action1((name, job) -> System.out.println(name + "이 " + job + "을 안합니다."));

		//매개변수가 한 개일 경우
		person.action2(content -> {
			System.out.print("\"" + content + "\"");
			System.out.println("라고 말합니다.");
		});
	}
}
