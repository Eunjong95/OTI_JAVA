package ch09.sec02.exam01;

public class A {
	//Field
	int field;
	B field2;
	
	//Constructor
	A() {
		B b = new B(); //A클래스 안이기 때문에 A.안해도 됨
		b.methodB();
	}
	
	//Method
	void methodA() { //정적 메소드 안에는 객체와 관련된 것을 쓸 수 없음 static void 하고 싶으면 class B도 static 선언해주면 됨
		B b = new B(); 
		b.methodB();
	}
	
	//Nested Class	
	public class B {
		//Field
		//Constructor
		//Method
		public void methodB() { //public 생략 가능
			System.out.println("methodB() 실행");
		}
	}
}
