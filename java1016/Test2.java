package java1016;

public class Test2 {

	public static void main(String[] args) {
	Person p1 = new Person(20, "ȫ�浿", "����");
	Person p2 = new Person(21, "ȫ���", "����");
	
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

//����

class Math {
	static double PI = 3.141592; //static�� ���� ����� ��
}

// ��ü�� 

class Person {

	int age;
	String name;
	String home;

	// �޼��� -> ������
	// ��ü(�ν��Ͻ�)�� ������ ������ �ݵ�� �ѹ� ����Ǵ� �ڵ�
	// ��ü�� ���� �ʱ� ���� => �ʱ�ȭ
	Person(int age, String name, String home) {
		this.age = age;
		this.name = name;
		this.home = home;
	}

}

