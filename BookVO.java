package module;

import java.io.Serializable;

public class BookVO implements Serializable {
	private int code;
	private String title;
	private String author;
	private String publisher;
	private String genre;
	
	

	public BookVO() {
		
	}
	public BookVO(int code, String title, String author, String publisher, String genre ) {
		this.code = code;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
	}
	/////////////////////
	@Override  
	public String toString() {
		return code+"\t\t"+title+"\t\t"+author+"\t\t"+publisher+"\t\t"+genre;
	}
	/////////////////////
	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getPublisher() {
		return publisher;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}

}
