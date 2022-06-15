package basic04_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {
	public ExceptionTest1() {
		
	}
	public void start() {
		Scanner scan = new Scanner(System.in);
		
		try { //예외가발생가능한 코드 + 예외발생가능성이 없는 코드 
			System.out.print("first number = ");
			int first = scan.nextInt(); //InputMismatchException
			System.out.print("second number = ");
			int second = scan.nextInt();
			
			System.out.printf("first = %d, second = %d,", first, second);
			
			int result = first / second; // 컴퓨터는 어떤수를 0으로 나눌 수 없다.
			System.out.println(first+"/"+second+"="+result);
			
			int data[] = {7,9,2,4,8,5}; // 0,1,2,3,4,5
			for(int i=0; i<= data.length; i++) { //  i 는 0,1,2,3,4,5,6이 만들어짐. 부등호를 지우면 에러가 생기지 않는다. 지우고 확인보기! 
				System.out.println("data["+i+"]= "+data[i]);
			}
		}catch(InputMismatchException ime) { //예외발생시 처리하는 부분
			System.out.println("please input integer.");
			// ime(내가 명시한)변수에 발생한 예외 객체가 담겨있다.
			System.out.println(ime.getMessage());
			ime.printStackTrace(); // 예외처리 확인용 
		}catch(ArithmeticException ae) {
			System.out.println("when input 0 as a second variable");
			System.out.println(ae.getMessage());
			ae.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException aibe) {
			System.out.println("Array Index is wrong.");
			System.out.println(aibe.getMessage());
		}finally { //예외가 발생하든 안하든 무조건 실행됨 
			System.out.println("finally always run.....");
		}
		
		System.out.println("End...");
	}
	public static void main(String[] args) {
		new ExceptionTest1().start();

	}

}
/*
	try{
		예외가 발생할 가능성이 있는 코드
	
	}catch(예외종류){
		예외가 발생했을때 처리하는 곳
	}
	-->








*/