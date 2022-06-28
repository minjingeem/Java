package module;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class BookDataSet {
	
	// Book 정보를 저장할 컬랙션 선언.
	public static HashMap<Integer, BookVO> bookList = new HashMap<Integer, BookVO>();
	

	public BookDataSet() {
		
	}
	public static void dataset() {
		
		try {
		File f = new File("/Users/minjinkim/testfolder/books", "books.txt"); // File 객체 생성. (파일경로, 파일이름 지정)
		if(f.exists()) {
			FileInputStream fis = new FileInputStream(f); // 하드디스크에 있는 File f 로부터 byte 단위를 입력받는 객체 생성.
			ObjectInputStream ois = new ObjectInputStream(fis); // ???
			
			BookDataSet.bookList = (HashMap)ois.readObject();
			}
		}catch(Exception e) {
			e.printStackTrace(); // 예외발생 당시의 call stack에 있었던 method 정보와 에외 메세지를 화면에 출력한다.
			
		}
	}
}
