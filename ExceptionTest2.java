package basic04_exception;
// try catch를 사용한 예외처리 방법. 
import java.util.Scanner;

public class ExceptionTest2 {
	Scanner scan = new Scanner(System.in);
	public ExceptionTest2() {
		start();
	}
	public void start() {
		try {
			System.out.print("first number = ");
			int first = scan.nextInt(); //InputMismatchException
			System.out.print("second number = ");
			int second = scan.nextInt(); //InputMismatchException
			
			System.out.printf("first = %d, second = %d,", first, second);
			
			int result = first / second; // 컴퓨터는 어떤수를 0으로 나눌 수 없다.
			System.out.println(first+"/"+second+"="+result);
			
			int data[] = {7,9,2,4,8,5}; 
			for(int i=0; i<= data.length; i++) { 
				System.out.println("data["+i+"]= "+data[i]); //ArrayIndexOutOfBoundsException
			}
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("Wrog index for array.");
		}catch(Exception e) { //exception은 항상 catch문 마지막에 사용.  
			System.out.println("pelase input number again.");
		}finally {
			
		}
		
		
	}
	public static void main(String[] args) {
		new ExceptionTest2();

	}

}
