package basic02.api;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random();
		// Math.random()	: 0.0000000000000 ~ 0.9999999999999
		// 100 random numbers between 1~100 
		//double ran[] = new double[100];
		int ran[] = new int[100];
		
		// 난수*100 +1 -> 1~100
		// 	        (정수화)(난수*(큰수-작은수+1)) + 작은수 
		// 72~87    ((정수화)Math.random*(87-72+1)) + 72
		for(int i=0; i<ran.length; i++) {
			//ran[i] = (int)(Math.random()*100)+1;
			ran[i] = (int)(Math.random()*(87-72+1))+72;
		}
 		
		System.out.println(Arrays.toString(ran));
		// Random 클래스 
		int data[] = new int[100];
		for(int i=0; i<data.length; i++) {
			// data[i] = random.nextInt(); //정수형중에서 int 범위내의 값을 무작위로 구해준다. 
			// data[i] = random.nextInt(10);
			// 26~39
			data[i] = random.nextInt(39-26+1)+26;
		}
		System.out.println(Arrays.toString(data));
		
		for(int i =1; i<=100; i++) {
			System.out.print(random.nextBoolean()+"\t");
		}
		
	}

}
