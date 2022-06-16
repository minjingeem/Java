package Practice;

import java.util.Scanner;

public class ForPractice { 

	public static void main(String[] args) {
		
		// 구구단 연습 
		for(int i=2; i<=9; i++) {
			System.out.print("["+i+"단]\t");
		}
		System.out.println();
		
		for(int i =1; i<=9; i++) {
			
			for(int j=2; j<=9; j++) {
				System.out.print(j+"*"+i+"="+j*i+"\t");		
			}
			System.out.println();
		}
		////////////////////////////////////////////////////////////
		System.out.println("-----------------end-------------------");
		
		
		// 팩토리얼 연습
		// 숫자 입력받기 
		Scanner scan = new Scanner(System.in);
		
		System.out.println("input number = ");
		int num = scan.nextInt();
		int sum = 1;
		
		for(int i =1; i<=num; i++) {
			sum = sum*i;
		}
		System.out.println(num+"! = "+sum);
		
		////////////////////////////////////////////////////////////
		System.out.println("-----------------end-------------------");
		
		// for문을 이용한 1~100 사이의 홀수와 짝수의 합
		
		int even = 0;
		int odd = 0;
		
		for(int i =1; i<=100; i++) {
			if(i%2 == 0) {
				even = even+i;
			}else {
				odd = odd+i;
			}
		}
		System.out.println("even number = " +even);
		System.out.println("odd number = " +odd);
		System.out.println("total sum = "+(even+odd));
		
	}

}

