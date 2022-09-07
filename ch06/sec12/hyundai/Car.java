package ch06.sec12.hyundai;

import ch06.sec12.hankook.SnowTire;
import ch06.sec12.kumho.AllSeasonTire;

//어떤 패키지의 클래스를 사용하는지 전체 이름을 사용해서 알려주면 import문은 필요 없다
//import ch06.sec12.hankook.Tire;
//import ch06.sec12.kumho.Tire;

public class Car {
	ch06.sec12.hankook.Tire tire1 = new ch06.sec12.hankook.Tire();
	ch06.sec12.kumho.Tire tire2 = new ch06.sec12.kumho.Tire();
	SnowTire tire3 = new SnowTire();
	AllSeasonTire tire4 = new AllSeasonTire();
}

