package basic06_io;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		
	}
	public void start() {
		
		//input,ouput
		//input(byte), reader(문자) 단위로 읽어 온다.
		try {
			//byte단위로 문자를 입력받는다.
			InputStream in = System.in;
			
			/*
			while(true) {
				int inData = in.read();
				if(inData==-1) break;
				System.out.println((char)inData);
			} */
				
			/* read(byte[] a) */
			byte data[] = new byte[10];
			int cnt = in.read(data);
			System.out.println("cnt-> "+cnt);
			System.out.println("text-> "+new String(data,0,cnt-2));
			
		}catch(IOException ie ) {
			System.out.println("Input error occur");
		}	
		
	}
	public static void main(String[] args) {
		new InputStreamTest().start();

	}

}
