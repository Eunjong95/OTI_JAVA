package ch20.oracle.sec09.exam01;

import lombok.Data;

//DTO 클래스
@Data
public class User {
	private String userId;
	private String userName;
	private String userPassword;
	private int userAge;
	private String userEmail;
}
