package ch06.sec15;

public class MemberService {
	
	boolean login(String id, String password) {
		//String은 == 연산자 못 씀 equals쓰기
		if(id.equals("hong") && password.equals("12345")) {
			System.out.println("로그인 되었습니다");
			return true;
		} else {
		return false; //return false 빼먹지 말기
		}
	}
	
	void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}
}
