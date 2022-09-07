package ch06.sec13.exam02.package2;

import ch06.sec13.exam02.package1.A;

public class C {
	//필드 선언
	A a1 = new A(true); 
	//A a2 = new A(1); 는 default라서 다른 패키지에는 호출 안됨
	//A a3 = new A("문자열"); 는 private라서 호출 안됨


}
