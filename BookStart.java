package books;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import module.BookDataSet;
import module.BookVO;

public class BookStart {
	Scanner scan = new Scanner(System.in);
	public BookStart() { // new BookStart()는 이곳에서 실행된다.
		do {
			try {
				System.out.print(menu());
				int inMenu = Integer.parseInt(scan.nextLine()); //입력된 문자열을 파싱하여 정수값 반환해서 inMenu라는 변수에 입력.
				
			
				if(inMenu == 6) { // 저장 및 종료
					bookStop();
				}else if(inMenu == 1) { // 책 목록. 
					bookListOutput();
				}else if(inMenu == 2) { // 책 등록
					bookAdd();	
				}else if(inMenu == 3) { // 수정 
					bookEdit();
				}else if(inMenu == 4) { // 삭제
					bookDel();
				}else if(inMenu == 5) { // 검색
					bookSearch();
				}else {
					throw new Exception();
				}
			}catch(Exception e) {
				System.out.println("메뉴를 다시 입력하세요.");
			}
		}while(true);
	}
	// 도서 검색
	public void bookSearch() {
		System.out.println("검색할 도서명을 입력하세요 -> ");
		String bookName = scan.nextLine();
		
		Collection<BookVO> list = BookDataSet.bookList.values();
		Iterator<BookVO> rr = list.iterator();
		int cnt = 0;
		while(rr.hasNext()); {
			BookVO v = rr.next();
			if(v.getTitle().equals(bookName)) {
				System.out.println(v.toString());
				cnt++;
			}
		}
		System.out.println(cnt+"권이 검색되었습니다.");
	}
	
	// 도서 삭제
	public void bookDel() {
		System.out.print("삭제할 도서코드 입력 -> ");
		int code = Integer.parseInt(scan.nextLine());
		BookDataSet.bookList.remove(code);
		System.out.println(code+"번 도서가 삭제되었습니다.");
	}
	// 도서 수정 (저자명수정, 출판사명수정, 장르종류수정) 
	public void	bookEdit() {
		
		System.out.print("수정할 도서코드를 입력하세요. -> ");
		int editCode = Integer.parseInt(scan.nextLine());
		
		System.out.print(" 수정 목록[ 1.저자, 2.출판사, 3.장르 ] -> " );
		String editMenu = scan.nextLine();
		if(editMenu.equals("1")) {
			authorEdit(editCode);
		}else if(editMenu.equals("2")) {
			publishEdit(editCode);
		}else if(editMenu.equals("3")) {
			genreEdit(editCode);
		}else {
			System.out.println("메뉴를 다시 입력해 주세요.");
		}
	}
	// 도서수정- 저자명수정 
	public void authorEdit(int code) {
		BookVO vo = BookDataSet.bookList.get(code);
		System.out.print("새로운 저자명 -> ");
		String editAuthorName = scan.nextLine();
		vo.setAuthor(editAuthorName);
		System.out.println(vo.getCode()+"번 도서의 저자명이 변경되었습니다."+vo.getAuthor());
	}
	// 도서수정 - 출판사명 수
	public void publishEdit(int code) {
		BookVO vo = BookDataSet.bookList.get(code);
		System.out.print("새로운 출판사 -> ");
		String editPublishName = scan.nextLine();
		vo.setPublisher(editPublishName);
		System.out.println(vo.getCode()+"출판사가 변경되었습니다." +vo.getPublisher());
	}
	// 도서수정 - 장르 수정
	public void genreEdit(int code) {
		BookVO vo = BookDataSet.bookList.get(code);
		System.out.print("새로운 장르 -> ");
		String editGenreName = scan.nextLine();
		vo.setGenre(editGenreName);
		System.out.println(vo.getCode()+"장르가 변경되었습니다." +vo.getGenre());
	}
		
	// 책 등록 (목록에 추가) 
	public void bookAdd() {
		BookVO vo = new BookVO();
		System.out.print("도서코드 입력 -> ");
		vo.setCode(Integer.parseInt(scan.nextLine()));
		System.out.print("도서명 입력 -> ");
		vo.setTitle(scan.nextLine());
		System.out.print("저자 입력 -> ");
		vo.setAuthor(scan.nextLine());
		System.out.print("출판사 입력 -> ");
		vo.setPublisher(scan.nextLine());
		System.out.print("장르 입력 -> ");
		vo.setGenre(scan.nextLine());
		
		BookDataSet.bookList.put(vo.getCode(),vo);
		System.out.println("도서가 등록되었습니다!");
	}
	
	// 모든 책 목록
	public void bookListOutput() {
		titlePrint();
		Collection<BookVO> book = BookDataSet.bookList.values();
		Iterator<BookVO> r = book.iterator();
		
		while(r.hasNext()) {
			BookVO v = r.next();
			System.out.println(v.toString());
		}
	}
	public void titlePrint() {
		System.out.println("코드\t\t제목\t\t저자\t\t출판사\t\t장르");
	}
	
	// 저장 및 종료
	public void bookStop() {
		try {
			File f = new File("/Users/minjinkim/testfoler/books/", "books.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(BookDataSet.bookList);
			
			oos.close();
			fos.close();
			
		}catch(Exception e) {
			System.out.println("파일 저장 오류." + e.getMessage());
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	/////////////////////////////////////////////////////
	public String menu() {
		return "Menu [ 1.책목록, 2.책등록, 3.수정, 4.삭제, 5.검색, 6. 저장 및 종료 ] -> "; 
	}

	public static void main(String[] args) {
		new BookStart();

	}

}
