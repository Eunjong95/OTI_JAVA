package ch17.sec02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
//		for(int i=0; i<1000; i++) {
//			list.add("홍길동" + i);
//		}
		list.add("홍길동");
		list.add("동길동");
		list.add("서길동");
		list.add("남길동");
		list.add("북길동");

		Stream<String> stream = list.parallelStream();
		stream.forEach(name -> {
			Thread thread = Thread.currentThread();
			System.out.println(name + ": " + thread.getName());
		});
	}
}
