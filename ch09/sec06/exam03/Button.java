package ch09.sec06.exam03;

public class Button {
	//Field
	private ClickListener clickListener; //외부에서 접근 못해서 여기에 대입을 못함
	//Constructor
	//Method
	public void setClickListener(ClickListener clickListener) { //setter은 외부에서 값을 받아서 저장
		this.clickListener = clickListener;		
	}
	public void click() {
		clickListener.onClick();
	}
	//Nested Class
	//Nested Interface
	public static interface ClickListener {
		public void onClick(); //추상메소드 작성		
	}
}
