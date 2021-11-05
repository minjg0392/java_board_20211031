package java1016;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Article> articles = new ArrayList<>();
	static int articleNo = 1;

	public static void main(String[] args) {
		//makeTestData();
		while (true) {
			System.out.print("명령어를 입력해주세요 : ");
			String command = sc.nextLine();

			if (command.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (command.equals("help")) {
				printHelp();

			} else if (command.equals("add")) {
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
	
	// 함수 -> 기능
	// 코드 재활용
	// 코드의 구조화 -> 집중
	// 코드가 깔끔 -> 가독성이 올라간다.
	// ===========================================================
	// 검색 키워드로 검색하기
	public static void search() {
		System.out.println("검색 키워드 입력 : ");
		String keyword = sc.nextLine();

		ArrayList<Article> searchedList = new ArrayList<>();
		// 번호로 찾기
		for (int i = 0; i < articles.size(); i++) {			
			Article a = articles.get(i);
			if (a.title.contains(keyword)) {
				searchedList.add(a);
			}
		}

		list(searchedList);
	}

	// ===========================================================
	// 번호로 게시물 인덱스 찾는 함수
	public static int getIndexByAritlceNo(int no) {

		int index = -1; // 0이 아닌 이유 : 값이 없을 경우 없다는 것을 표현하기 위함. 0은 인덱스로서 의미를 가지니까

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
	// 게시물을 삭제하는 함수
	public static void delete() {
		System.out.println("삭제할 게시물 선택 : ");
		int no = Integer.parseInt(sc.nextLine());
		int index = getIndexByAritlceNo(no);

		if (index != -1) {
			articles.remove(index);			
		} else {
			System.out.println("없는 게시물입니다.");
		}
	}

	// ===========================================================
	// 게시물을 수정해주는 함수
	public static void update() {
		System.out.println("수정할 게시물 선택 : ");
		int no = Integer.parseInt(sc.nextLine());

		int index = getIndexByAritlceNo(no);

		if (index != -1) {
			System.out.print("새제목 : ");
			String title = sc.nextLine();
			System.out.print("새내용 : ");
			String body = sc.nextLine();
			
			Article a = articles.get(index);
			a.title = title;
			a.body = body;
			
			articles.set(index, a);
			

		} else {
			System.out.println("없는 게시물입니다.");
		}

	}

	// ===========================================================
	// 게시물 목록을 보여주는 함수
	public static void list(ArrayList<Article> articleList) {

		for (int i = 0; i < articleList.size(); i++) {
			Article a = articleList.get(i);
			System.out.println("번호 : " + a.no);
			System.out.println("제목 : " + a.title);
			System.out.println("작성자 : " + "익명");
			System.out.println("작성일 : " + a.regDate);
			System.out.println("조회수 : " + 0);
			System.out.println("===============");
		}

	}

	// ===========================================================
	// 게시물 추가하는 함수
	public static void add() {
		Article a = new Article();

		System.out.print("제목을 입력해주세요 : ");
		String title = sc.nextLine();
		System.out.print("내을 입력해주세요 : ");
		String body = sc.nextLine();
		

		// 현재 시간 구해서 등록.
		// 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
		String regDate = getCurrentData();
				
		a.no = articleNo;
		a.title = title;
		a.body = body;
		a.regDate = regDate;
		
		articles.add(a);
		
		System.out.println("게시물이 등록되었습니다.");
		articleNo++;
	}

	// ===========================================================
	// 도움말 출력 함수
	public static void printHelp() {
		System.out.println("========================");
		System.out.println("help : 도움말");
		System.out.println("add : 데이터 추가");
		System.out.println("read : 데이터 조회");
		System.out.println("update : 데이터 수정");
		System.out.println("delete : 데이터 삭제");
		System.out.println("exit : 프로그램 종료");
		System.out.println("========================");
	}

//	public static void makeTestData() {
//		setTestData("안녕하세요", "반갑습니다");
//		setTestData("하이~", "냉무");
//		setTestData("가입인사드립니다.", "잘부탁드립니다.");
//	}
//
//	public static void setTestData(String title, String body) {
//		numbers.add(articleNo);
//		titles.add(title);
//		bodies.add(body);
//		
//		String regDate = getCurrentData();
//		regDates.add(regDate);
//		System.out.println("게시물이 등록되었습니다.");
//		articleNo++;
//	}
	
	public static String getCurrentData() {
		LocalDate now = LocalDate.now();

		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		// 포맷 적용
		String formatedNow = now.format(formatter);
		
		return formatedNow;
		
	}

}

//객체를 만든는 설계도
class Article {
	int no;
	String title;
	String body;
	String regDate;
}
