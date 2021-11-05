package test;

public class Test2 {

	public static void main(String[] args) {
		
		 Dog d1 = new Dog(); // Dog 객체를 Dog로서 다룬다.
		 Cat c1 = new Cat(); // Cat 객체를 Cat으로서 다룬다.

		 // Dog d1 = new Cat(); // Cat을 Dog로서 다룰 수는 없다. 둘은 서로 다른 타입이다.

		 Animal a1 = new Animal(); // Animal 객체를 Animal로서 다룬다
		 Animal a2 = new Dog(); // Dog 객체를 Animal로서 다룬다. => Dog는 Animal의 하위개념이기 때문에 Animal의 모든 특성을 갖는다. 때문에 Dog의 기능을 가려놓고 보면 Dog는 정확히 Animal로서 동작할 수 있다. 단, 이렇게 하려면 자바에게 Dog가 Animal의 하위라는 사실을 알려줘야 하는데 자바 문법으로 extends라고 한다. 자세한 extends 문법은 아래 클래스 쪽에 있다. 
		 // 이로써 객체를 바라보는 관점이 다양해졌다. Dog는 Dog로서 다루어지기도 하고 Animal로서 다루어지기도 한다.-> 다형성

		 a1.breathe(); // Animal의 공통 기능인 breathe().
		 // 모든 Animal은 숨을 쉬기 때문에 breathe() 라는 기능을 갖고 있지만 그 기능이 다 똑같지는 않다. 이를 표현하기 위해 자바의 상속에서는 재정의(오버라이딩) 기능을 제공, breathe() 라는 껍데기만 물려받고 내용은 자신만의 방식으로 재정의해서 사용할 수 있게 해준다.

		 a2.breathe(); // a2에 연결된 객체가 Dog라면 헥헥 숨을 쉰다. a2에 연결된 객체가 Cat이라면 고로롱 숨을 쉰다가 출력
				
	}

}

class Animal {
	void breathe() {
		System.out.println("숨을 쉬다.");
	}
}

class Dog extends Animal {
	
	void breathe() {
		System.out.println("헥헥 숨을 쉬다.");// 재정의 - 오버라이딩
	}
	
	void bark() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal {

	void breathe() {
		System.out.println("고로롱 숨을 쉬다."); // 재정의 - 오버라이딩
	}
	
	void meow() {
		System.out.println("야옹");
	}
}