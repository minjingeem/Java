package basic01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		//로또 번호 생성
		do { 
			System.out.print("Game Number => ");
			int cnt = scan.nextInt();
			
			for(int i=1; i<=cnt; i++) { //1,2,3,4,5,,,,,,,cnt
				int lotto[] = new int[7]; //로또번호+보너스 
				
				for(int j=0; j<lotto.length; j++) {// 0,1,2,3,4,5,6
					lotto[j] = random.nextInt(45) + 1;//번호생성
					
					//현재 번호 이전에 만들어진 번호와 현재생성번호와 같은 값이 있는지 중복검사
					//
					for(int c=0; c<j; c++) {
						if(lotto[j] == lotto[c]) {
							j--; //1->0
							break;
						}
					}
					
				}
				//게임 정렬(보너스는 정렬제외)
				Arrays.sort(lotto, 0, 6); //index과 0~6이전번호까지만 정렬된다.
				//System.out.println(Arrays.toString(lotto));	
				System.out.println(i+" Game = "+Arrays.toString(Arrays.copyOfRange(lotto,0,6))+", bonus = "+lotto[6]);
				
			}
			System.out.print("Continue(1.yes 2.no)?");
			int qna = scan.nextInt();
			
			if(qna!=1)break; //1외의 값이 들어오면 프로그램 종료.
			
	}while(true);

}
}
