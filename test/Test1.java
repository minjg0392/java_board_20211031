package test;

public class Test1 {

	public static void main(String[] args) {
//		Member m1 = new Member("hong123", "h1234", "ȫ�浿");
//		SpecialMember m2 = new SpecialMember("lee123", "l1234", "�̼���", 100);
		GeneralMember m1 = new GeneralMember();
		m1.loginId = "hong123";
		m1.loginPw = "h1234";
		m1.nickname = "ȫ�浿";
		
		SpecialMember m2 = new SpecialMember();
		m2.loginId = "lee123";
		m2.loginPw = "l1234";
		m2.nickname = "�̼���";
		m2.point = 1000;
		
		Member loginedMember = m2;
		
		// == : �Ϲ����� �� ��
		// equals() : ���ڿ�(��ü) ��
		// instanceof : ��ü Ÿ�� ��
		loginedMember.welcome();

	}

}

class Member {
	String loginId;
	String loginPw;
	String nickname;
	
	public void welcome() {
		System.out.println("aaaa");
	}
}

class GeneralMember extends Member {
	
	public void welcome() {
		System.out.println("�ȳ��ϼ��� �Ϲ�ȸ�� " + this.nickname + "��");
	}
}

class SpecialMember extends Member {
	
	int point;	
	
	public void welcome() {
		System.out.println("�ȳ��ϼ��� ���ȸ�� " + this.nickname + "�� ȸ������ ����Ʈ�� " + this.point + "�Դϴ�");
	}
	
}

