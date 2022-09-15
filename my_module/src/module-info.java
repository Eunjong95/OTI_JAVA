module my_module {//my_module Buildpath-configure에서 모듈 a,b 추가해줘야함
	requires transitive my_module_a;
	requires transitive my_module_b;
}