package ch12.sec03.exam01;

public class MemberExample {

	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		
		System.out.println(obj1 == obj2);
		System.out.println(obj1.equals(obj2)); //Member타입은 equals()없는데 어떻게 사용할 수 있는지: 자바의 모든 클래스는 기본적으로 Object를 상속하고 있다.

		Member obj3 = new Member("red");
		
		System.out.println(obj1 == obj3);
		System.out.println(obj1.equals(obj3));
	}

}
