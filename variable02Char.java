package basic01;

public class variable02Char {

	public static void main(String[] args) {
		// char : 2byte
		
		char a = 'A'; //always single quotes
		
		String grade = "";
		char b = ' '; // 빈칸 넣기, 한 칸 뛰어쓰기 가능
		
		a++;
		System.out.println(a);
	
		++a;
		System.out.println(a);
		//     char(1byte)   int(4byte)
		a = (char)(a     +      1);
		System.out.println(a);
		
		int bb = a + 1;//E
		System.out.println(bb);
	}

}
