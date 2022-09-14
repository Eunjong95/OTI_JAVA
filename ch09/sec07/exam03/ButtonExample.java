package ch09.sec07.exam03;

public class ButtonExample {

	public static void main(String[] args) {
		//Button 객체 생성
		Button btnOk = new Button();
		Button btnCancel = new Button();
		
		//Button 객체에 Click Event 처리 객체 설정
		btnOk.setClickListener(new Button.ClickListener() {			
			@Override
			public void onClick() {
				System.out.println("OK 버튼을 클릭했습니다");				
			}
		}); 
		
		btnCancel.setClickListener(new Button.ClickListener() {			
			@Override
			public void onClick() {
				System.out.println("Cancel 버튼을 클릭했습니다");				
			}		
		});
		
		//Button이 클릭 되었을 때
		btnOk.click();
		btnCancel.click();		
	}
}
