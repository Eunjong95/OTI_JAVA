package ch18.sec10;

import java.io.Serializable;

public class Member implements Serializable {	
	private static final long serialVersionUID = 6237230879659378976L;
	private String id;
	private String name;	

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return id + ": " + name;
	}
}
