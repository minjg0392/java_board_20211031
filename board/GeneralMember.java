package board;

public class GeneralMember  extends Member {

	public GeneralMember(String loginId, String loginPw, String nickname) {
		super();
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.nickname = nickname;
		
	}
	
	public void welcome() {
		System.out.println("�ȳ��ϼ��� �Ϲ�ȸ�� " + this.nickname + "��");
	}

}
