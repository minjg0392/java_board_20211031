package java1016;

public class Test2 {

	public static void main(String[] args) {
	Person p1 = new Person(20, "홍길동", "서울");
	Person p2 = new Person(21, "홍길순", "대전");
	
	Math m1 = new Math();
	Math m2 = new Math();
	
	System.out.println(m1.PI);
	System.out.println(m2.PI);
	
	m1.PI= 3.15;
	
	System.out.println(m1.PI);
	System.out.println(m2.PI);
	
	System.out.println(p1.age);
	System.out.println(p1.name);
	System.out.println(p1.home);
		
	}

}

//수학

class Math {
	static double PI = 3.141592; //static은 보통 상수에 씀
}

// 객체는 

class Person {

	int age;
	String name;
	String home;

	// 메서드 -> 생성자
	// 객체(인스턴스)를 생성할 때마다 반드시 한번 실행되는 코드
	// 객체의 값을 초기 세팅 => 초기화
	Person(int age, String name, String home) {
		this.age = age;
		this.name = name;
		this.home = home;
	}

}

