package ch17.sec03;

import java.util.ArrayList;
import java.util.List;

public class StreamPipeLineExample {

	public static void main(String[] args) {
		
		//수정 불가한 리스트
//		List<Student> list = List.of(
//				new Student("홍길동", 10), 
//				new Student("김길동", 20), 
//				new Student("차길동", 30)
//				);
//		
		List<Student> list = new ArrayList<>();
				list.add(new Student("홍길동", 10)); 
				list.add(new Student("김길동", 20)); 
				list.add(new Student("차길동", 30)); 
			
		double avg = list.stream() 
				.mapToInt(student -> student.getScore())
				.average()
				.getAsDouble();
		System.out.println("평균 점수: " + avg);

		//학생 이름만 출력
		list.stream()
		.map(student -> student.getName())
		.forEach(name -> System.out.println(name));
	}

}
