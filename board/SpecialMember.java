package board;

public class SpecialMember extends Member {
	
	int point;
	
	public SpecialMember(String loginId, String loginPw, String nickname, int point) {
		super();
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.nickname = nickname;
		this.point = point;
	}
	
	public void welcome() {
		System.out.println("�ȳ��ϼ��� ���ȸ�� " + this.nickname + "�� ȸ������ ����Ʈ�� " + this.point + "�Դϴ�");
	}

}
