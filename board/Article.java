package board;

public class Article {
	
	//객체를 만든는 설계도
	int no;
	String title;
	String writer;
	String body;
	String regDate;
		
	Article(int no, String title, String body, String regDate, String writer) {
			this.no = no;
			this.title = title;
			this.writer= writer;
			this.body = body;
			this.regDate = regDate;
			
	}
}
