package test;

public class Test1 {

	public static void main(String[] args) {
//		Member m1 = new Member("hong123", "h1234", "홍길동");
//		SpecialMember m2 = new SpecialMember("lee123", "l1234", "이순신", 100);
		GeneralMember m1 = new GeneralMember();
		m1.loginId = "hong123";
		m1.loginPw = "h1234";
		m1.nickname = "홍길동";
		
		SpecialMember m2 = new SpecialMember();
		m2.loginId = "lee123";
		m2.loginPw = "l1234";
		m2.nickname = "이순신";
		m2.point = 1000;
		
		Member loginedMember = m2;
		
		// == : 일반적인 값 비교
		// equals() : 문자열(객체) 비교
		// instanceof : 객체 타입 비교
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
		System.out.println("안녕하세요 일반회원 " + this.nickname + "님");
	}
}

class SpecialMember extends Member {
	
	int point;	
	
	public void welcome() {
		System.out.println("안녕하세요 우수회원 " + this.nickname + "님 회원님의 포인트는 " + this.point + "입니다");
	}
	
}

