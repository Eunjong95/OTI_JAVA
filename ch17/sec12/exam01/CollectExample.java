package ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {

	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<>();
		totalList.add(new Student("홍길동", "남", 92));
		totalList.add(new Student("김수영", "여", 87));
		totalList.add(new Student("감자바", "남", 95));
		totalList.add(new Student("오해영", "여", 93));

		List<Student> femaleList = totalList.stream()
				.filter(s -> s.getSex().equals("여"))
				.toList(); //.collect(Collectors.toList());랑 같음

		femaleList.stream()
		.forEach(s -> System.out.println(s.getName()));

		System.out.println();

		//학생 이름을 키, Student 점수를 값으로 갖는 Map 생성
		Map<String, Integer> map = totalList.stream()
				.collect(
						Collectors.toMap(
								s -> s.getName(), //Student 객체에서 키가 될 부분 리턴
								s -> s.getScore() //Student 객체에서 값이 될 부분 리턴
						)
				);

		System.out.println(map);
	}
}