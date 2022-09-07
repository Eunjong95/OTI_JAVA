package ch06.sec13.exam02.package1;

public class A {
	//필드 선언
	//A a1 = new A();는 기본생성자 public A(){} 꼴이라 에러 안남
	A a1 = new A(true); 
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	//생성자 선언
	public A(boolean b) {}
	
	A(int b) {		
	}
	
	private A(String s) {		
	}

}
