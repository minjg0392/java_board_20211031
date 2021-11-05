package board;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import board.GeneralMember;
import board.Member;
import board.SpecialMember;

public class Apptest {
	
	private static final String title = null;
		// ���� ����
		Scanner sc = new Scanner(System.in);
		ArrayList<Article> articles = new ArrayList<>();
		ArrayList<Member> members = new ArrayList<>();
		int articleNo = 1;
		Member loginedUser = null; // �α����� ����
		
		// �޼��� ����
		public void run() {
			makeTestData();

			while (true) {
				if(loginedUser == null) {
					System.out.print("��ɾ �Է����ּ��� : ");				
				} else {
					System.out.print("��ɾ �Է����ּ��� [" + loginedUser.getNickname() + "(" + loginedUser.getLoginId() + ")]: ");				
				}
				String command = sc.nextLine();

				if (command.equals("exit")) {
					System.out.println("���α׷��� �����մϴ�.");
					break;
				} else if (command.equals("help")) {
					printHelp();

				} else if (command.equals("add")) {
					
					if(loginCheck()) {
						add();					
					} 

				} else if (command.equals("list")) {
					list(articles);

				} else if (command.equals("update")) {
					update();

				} else if (command.equals("delete")) {
					delete();

				} else if (command.equals("search")) {
					search();

				} else if (command.equals("read")) {
					
					if(loginCheck()) {
						read();
					}
					
				} else if(command.equals("signup")) {
					signup();
					
				} else if(command.equals("login")) {
					login();
					
				} else if(command.equals("logout")) {
					logout();
					
				}
			}
		}

		private void logout() {
			
			loginedUser = null;
			System.out.println("�α׾ƿ� �Ǽ̽��ϴ�.");
			
		}

		private void login() {
			boolean isSuccessLogin = false;
			
			System.out.print("���̵� : ");
			String loginId = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String loginPw = sc.nextLine();
			
			for(int i = 0; i < members.size(); i++) {
				Member m = members.get(i);
				if(m.getLoginId().equals(loginId)) {
					if(m.getLoginPw().equals(loginPw)) {
						loginedUser = m;
						m.welcome();
						isSuccessLogin = true;
					} 
				} 
			}
			
			if(!isSuccessLogin) {
				System.out.println("�߸��� ȸ������ Ʋ��");
			}
			
		}

		
		
		private void signup() {
			
			System.out.println("1. ���ȸ��, 2. �Ϲ�ȸ��");
			int memberFlag = Integer.parseInt(sc.nextLine());
			
			System.out.print("���̵� �Է����ּ��� : ");
			String loginId = sc.nextLine();
			System.out.print("��й�ȣ�� �Է����ּ��� : ");
			String loginPw = sc.nextLine();
			System.out.print("�г����� �Է����ּ��� : ");
			String nickname = sc.nextLine();
			
			Member m = null;
			
			if(memberFlag == 1) {
				 m = new SpecialMember(loginId, loginPw, nickname, 0);			
			} else {
				 m = new GeneralMember(loginId, loginPw, nickname);
			}
			
			members.add(m);
			System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
		}

		public void read() {
			System.out.println("�󼼺����� �Խù� ���� : ");
			int no = Integer.parseInt(sc.nextLine());
			int index = getIndexByAritlceNo(no);
			
			if(index != -1) {
				Article a = articles.get(index);
				
				System.out.println("==== " + a.no +"�� �Խù� ====");
				System.out.println("��ȣ : " + a.no);
				System.out.println("���� : " + a.title);
				System.out.println("-------------------");
				System.out.println("���� : " + a.body);
				System.out.println("-------------------");
				System.out.println("�ۼ��� : �͸�");
				System.out.println("��ϳ�¥: " + a.regDate);
				System.out.println("===================");		
				
				// �󼼺��� ���
				readProcess();						
				
			} else {
				System.out.println("���� �Խù��Դϴ�.");
			}

		}

		private void readProcess() {
			
			while(true) {
				System.out.print("�󼼺��� ����� �������ּ���(1. ��� ���, 2. ���ƿ�, 3. ����, 4. ����, 5. �������) : ");
				int rcmd = Integer.parseInt(sc.nextLine());
				
				if(rcmd == 1) {
					System.out.println("[��� ��� ��� ����]");
				} else if(rcmd == 2) {
					System.out.println("[���ƿ�]");
				} else if(rcmd == 3) {
					System.out.println("[����]");
				} else if(rcmd == 4) {
					System.out.println("[����]");
				} else if(rcmd == 5) {
					break;
				}
			}
			
		}

		// �Լ� -> ���
		// �ڵ� ��Ȱ��
		// �ڵ��� ����ȭ -> ����
		// �ڵ尡 ��� -> �������� �ö󰣴�.
		// ===========================================================
		// �˻� Ű����� �˻��ϱ�
		public void search() {
			System.out.println("�˻� Ű���� �Է� : ");
			String keyword = sc.nextLine();

			ArrayList<Article> searchedList = new ArrayList<>();
			// ��ȣ�� ã��
			for (int i = 0; i < articles.size(); i++) {
				Article a = articles.get(i);
				if (a.title.contains(keyword)) {
					searchedList.add(a);
				}
			}

			list(searchedList);
		}

		// ===========================================================
		// ��ȣ�� �Խù� �ε��� ã�� �Լ�
		public int getIndexByAritlceNo(int no) {

			int index = -1; // 0�� �ƴ� ���� : ���� ���� ��� ���ٴ� ���� ǥ���ϱ� ����. 0�� �ε����μ� �ǹ̸� �����ϱ�

			for (int i = 0; i < articles.size(); i++) {

				Article a = articles.get(i);

				if (no == a.no) {
					index = i;
					break;
				}
			}

			return index;
		}

		// ===========================================================
		// �Խù��� �����ϴ� �Լ�
		public void delete() {
			System.out.println("������ �Խù� ���� : ");
			int no = Integer.parseInt(sc.nextLine());
			int index = getIndexByAritlceNo(no);

			if (index != -1) {
				articles.remove(index);
			} else {
				System.out.println("���� �Խù��Դϴ�.");
			}
		}

		// ===========================================================
		// �Խù��� �������ִ� �Լ�
		public void update() {
			System.out.println("������ �Խù� ���� : ");
			int no = Integer.parseInt(sc.nextLine());

			int index = getIndexByAritlceNo(no);

			if (index != -1) {
				System.out.print("������ : ");
				String title = sc.nextLine();
				System.out.print("������ : ");
				String body = sc.nextLine();

				Article a = articles.get(index);
				a.title = title;
				a.body = body;

				articles.set(index, a);

			} else {
				System.out.println("���� �Խù��Դϴ�.");
			}
		}

		// ===========================================================
		// �Խù� ����� �����ִ� �Լ�
		public void list(ArrayList<Article> articleList) {

			for (int i = 0; i < articleList.size(); i++) {
				Article a = articleList.get(i);
				System.out.println("��ȣ : " + a.no);
				System.out.println("���� : " + a.title);
				System.out.println("�ۼ��� : " + a.writer);
				System.out.println("�ۼ��� : " + a.regDate);
				System.out.println("��ȸ�� : " + 0);
				System.out.println("===============");
			}

		}

		// ===========================================================
		// �Խù� �߰��ϴ� �Լ�
		public void add() {

			System.out.print("������ �Է����ּ��� : ");
			String title = sc.nextLine();
			System.out.print("������ �Է����ּ��� : ");
			String body = sc.nextLine();

			// ���� �ð� ���ؼ� ���.
			// ���� ��¥ ���ϱ� (�ý��� �ð�, �ý��� Ÿ����)
			String regDate = getCurrentData();
			Article a = new Article(articleNo, title, loginedUser.getNickname(), body, regDate);
			articles.add(a);

			System.out.println("�Խù��� ��ϵǾ����ϴ�.");
			articleNo++;
		}

		// ===========================================================
		// ���� ��� �Լ�
		public static void printHelp() {
			System.out.println("========================");
			System.out.println("help : ����");
			System.out.println("add : ������ �߰�");
			System.out.println("read : ������ ��ȸ");
			System.out.println("update : ������ ����");
			System.out.println("delete : ������ ����");
			System.out.println("exit : ���α׷� ����");
			System.out.println("========================");
		}

		public void makeTestData() {
			setTestData("�ȳ��ϼ���", "�ݰ����ϴ�");
			setTestData("����~", "�ù�");
			setTestData("�����λ�帳�ϴ�.", "�ߺ�Ź�帳�ϴ�.");
		}
		
		public void setMemberTestData(String loginId, String loginPw, String nick) {

			String regDate = getCurrentData();
			Article a = new Article(articleNo, title, "ȫ�浿", loginPw, regDate);

			articles.add(a);
			System.out.println("�Խù��� ��ϵǾ����ϴ�.");
			articleNo++;
		}

		public void setTestData(String title, String body) {

			String regDate = getCurrentData();
			Article a = new Article(articleNo, title, "ȫ�浿", body, regDate);

			articles.add(a);
			System.out.println("�Խù��� ��ϵǾ����ϴ�.");
			articleNo++;
		}

		public String getCurrentData() {
			LocalDate now = LocalDate.now();

			// ���� ����
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
			// ���� ����
			String formatedNow = now.format(formatter);

			return formatedNow;

		}
		
		public boolean loginCheck() {
			
			if(loginedUser != null) {
				return true;
			} else {
				System.out.println("�α����� �ʿ��� ����Դϴ�.");
				return false;
			}		
		}
		

}
