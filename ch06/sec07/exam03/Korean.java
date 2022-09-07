package ch06.sec07.exam03;

public class Korean {
	//필드 선언
	String nation = "대한민국";
	String name;
	String ssn;
	//int age; 나이는 정수니까 int타입으로 생성
	
	
	//생성자 선언
	public Korean(String name, String ssn) {
		this.name = name;	//필드명과 매개변수명이 동일할 때 필드명 앞에 this를 붙여서 구분해줌
		this.ssn = ssn;
	}
}