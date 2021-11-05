package java1016;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ex1 {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> articles = new ArrayList<>();
	static int articleNo = 1;

	public static void main(String[] args) {
		//makeTestData();
		
		
		while (true) {
			System.out.print("���ɾ �Է����ּ��� : ");
			String command = sc.nextLine();

			if (command.equals("exit")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else if (command.equals("help")) {
				printHelp();
				
			} else if (command.equals("add")) {
				add();

			} else if (command.equals("read")) {
				add();

			} else if (command.equals("list")) {
				list(articles);
				
			} else if (command.equals("update")) {
				update();
					
			} else if (command.equals("delete")) {
				delete();
				
			} else if (command.equals("search")) {
				search();
			}
		}

	}
	
	// �Լ� -> ���
			// �ڵ� ��Ȱ��
			// �ڵ��� ����ȭ -> ����
			// �ڵ尡 ��� -> �������� �ö󰣴�.
			//===========================================================
			// �˻� Ű����� �˻��ϱ�
		public static void search() {
			System.out.println("�˻� Ű���� �Է� : ");
			String keyword = sc.nextLine();

				
			ArrayList<Article> searchedList = new ArrayList<>();
			//��ȣ�� ã��
			for(int i = 0; i < articles.size(); i++) {
				
				Article a = articles.get(i);
				
				if(a.title.contains(keyword))) {
					searchedList.add(a);
				}
			}
			
			list(searchedList);
			
		}
		//===========================================================
		// ��ȣ�� �Խù� �ε��� ã�� �Լ�
		public static int getIndexByAritlceNo(int no) {
			int index = -1; // 0�� �ƴ� ���� : ���� ���� ��� ���ٴ� ���� ǥ���ϱ� ����. 0�� �ε����μ� �ǹ̸� �����ϱ�
			
			for(int i = 0; i < articles.size(); i++) {
				Article a = articlces.get(i);
				
				if(no == a.no) {
					index = i;
					break;
				}
			}
				return index;
		}
		//===========================================================
		// �Խù��� �����ϴ� �Լ�
		public static void delete() {
			System.out.println("������ �Խù� ���� : ");
			int no = Integer.parseInt(sc.nextLine());
			int index = getIndexByAritlceNo(no);
			
			if(index != -1) {
				articles.remove(index);
			} else {
				System.out.println("���� �Խù��Դϴ�.");
			}
		}
		//===========================================================
		// �Խù��� �������ִ� �Լ�
		public static void update() {
			System.out.println("������ �Խù� ���� : ");
			int no = Integer.parseInt(sc.nextLine());
				
			int index = getIndexByAritlceNo(no);
				
			if(index != -1) {
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
		//===========================================================
		// �Խù� ����� �����ִ� �Լ�
		public static void list(ArrayList<Integer> numberList) {
			for(int i = 0; i < numberList.size(); i++) {
				Article a = articleList.get(i);
				System.out.println("��ȣ : " + a.no);
				System.out.println("���� : " + a.title);
				System.out.println("�ۼ��� : " + "�͸�");
				System.out.println("�ۼ��� : " + a.regDates);
				System.out.println("��ȸ�� : " + 0);
				System.out.println("===============");
			}

		}
		//===========================================================
		// �Խù� �߰��ϴ� �Լ�
		public static void add() {
			Article a = new Article();
			System.out.print("������ �Է����ּ��� : ");
			String title = sc.nextLine();
			System.out.print("������ �Է����ּ��� : ");
			String body = sc.nextLine();
			System.out.print("�ۼ��� : ");
			String name = sc.nextLine();
			
			String regDate = getCurrentData();
			
			a.no = articleNo;
			a.title = title;
			a.body = body;
			a.regDate = regDate;
			
			articles.add(a);
			
			System.out.println("�Խù��� ��ϵǾ����ϴ�.");
			articleNo++;
		}
			
		public static void read() {
			
		}
			
		//===========================================================
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
			
		public static void makeTestData() {
			setTestData("�ȳ�", "�ݰ����ϴ�");
			setTestData("����", "�޹�");
			setTestData("����", "�ݰ����ϴ�");
		}
			
		public static void  setTestData(String title, String body) {
			
			Article a = new Article();
			
			a.no = articleNo;
			a.title = title;
			a.body = body;
			String regDate = getCurrentData();
			a.regDates;
			System.out.println("�Խù��� ��ϵǾ����ϴ�.");
			articleNo++;
		}
			
		public static String getCurrentData() {
			LocalDate now = LocalDate.now();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			// ���� ����
			String formatedNow = now.format(formatter);
			
			return formatedNow;
		}
	
}

class Article {
	int no;
	String title;
	String body;
	String regDate;
	int hit;
}