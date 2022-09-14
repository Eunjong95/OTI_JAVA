package ch09.sec03.exam01;

public class A {
	//Nested Class
	static class B {
		void methodB() {
			System.out.println("methodB() 실행");
		}
	}
	
	//Field
	B field1 = new B();
	static B field2 = new B(); //static class B에서 static 떼면 A객체 없이는 B를 쓸 수 없기 때문에 에러

	//Constructor
	A() { 
		B field1 = new B();
	}
	
	//Method
	void method1() {
		B field1 = new B();
	}
	
	static void method2() { //static class B에서 static 떼면 A객체 없이는 B를 쓸 수 없기 때문에 에러
		B field2 = new B(); 
	}
}
