package basic05_collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		
	}
	public void start() {
		// Set : 입력순서를 유지하지 않는다. 
		//	     객체의 중복을 허용하지 않는다.
		
		
		int[] data = {56,56,26,98,67,4,6,1,1,8,420,42,420};
		
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int n: data) {
			hs.add(n);
		}
		// HashSet의 객체 얻어오기.
		Iterator<Integer>i = hs.iterator();
		while(i.hasNext()) { // 있으면 True, 없으면 False
			int d = i.next();
			System.out.println(d);
		}
	}
	public static void main(String[] args) {
		new HashSetTest().start();

	}

}
