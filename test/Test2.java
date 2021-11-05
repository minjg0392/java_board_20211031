package test;

public class Test2 {

	public static void main(String[] args) {
		
		 Dog d1 = new Dog(); // Dog ��ü�� Dog�μ� �ٷ��.
		 Cat c1 = new Cat(); // Cat ��ü�� Cat���μ� �ٷ��.

		 // Dog d1 = new Cat(); // Cat�� Dog�μ� �ٷ� ���� ����. ���� ���� �ٸ� Ÿ���̴�.

		 Animal a1 = new Animal(); // Animal ��ü�� Animal�μ� �ٷ��
		 Animal a2 = new Dog(); // Dog ��ü�� Animal�μ� �ٷ��. => Dog�� Animal�� ���������̱� ������ Animal�� ��� Ư���� ���´�. ������ Dog�� ����� �������� ���� Dog�� ��Ȯ�� Animal�μ� ������ �� �ִ�. ��, �̷��� �Ϸ��� �ڹٿ��� Dog�� Animal�� ������� ����� �˷���� �ϴµ� �ڹ� �������� extends��� �Ѵ�. �ڼ��� extends ������ �Ʒ� Ŭ���� �ʿ� �ִ�. 
		 // �̷ν� ��ü�� �ٶ󺸴� ������ �پ�������. Dog�� Dog�μ� �ٷ�����⵵ �ϰ� Animal�μ� �ٷ�����⵵ �Ѵ�.-> ������

		 a1.breathe(); // Animal�� ���� ����� breathe().
		 // ��� Animal�� ���� ���� ������ breathe() ��� ����� ���� ������ �� ����� �� �Ȱ����� �ʴ�. �̸� ǥ���ϱ� ���� �ڹ��� ��ӿ����� ������(�������̵�) ����� ����, breathe() ��� �����⸸ �����ް� ������ �ڽŸ��� ������� �������ؼ� ����� �� �ְ� ���ش�.

		 a2.breathe(); // a2�� ����� ��ü�� Dog��� ���� ���� ����. a2�� ����� ��ü�� Cat�̶�� ��η� ���� ���ٰ� ���
				
	}

}

class Animal {
	void breathe() {
		System.out.println("���� ����.");
	}
}

class Dog extends Animal {
	
	void breathe() {
		System.out.println("���� ���� ����.");// ������ - �������̵�
	}
	
	void bark() {
		System.out.println("�۸�");
	}
}

class Cat extends Animal {

	void breathe() {
		System.out.println("��η� ���� ����."); // ������ - �������̵�
	}
	
	void meow() {
		System.out.println("�߿�");
	}
}