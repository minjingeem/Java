package basic02.api;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		
		String name = "John Lee";
		String name2 = "John Lee";
		
		// 객체를 만들경우, call by reference로 처리. 
		String addr = new String("Oakland Calif ");
		String addr2 = new String("OAKLAND CALIF ");
		
		// == : Same?
		if(name == name2) {
			System.out.println("name and name2 are same");
		}else {
			System.out.println("name and name2 are not same");
		}
		if(addr == addr2) { // call by reference로 처리 되기 때문에 주소끼리 비교. 주소가 다름으로 둘은 다르다.
			System.out.println("addr and addr2 are same");
		}else {
			System.out.println("addr and addr2 are not same");
		}
		String addr3 = addr2;
		if(addr2 == addr3) {
			System.out.println("addr2 and addr3 are same");
		}else {
			System.out.println("addr2 and addr3 are not same");
		}
		//equals()	: 객체내의 값을 비교해준다. ( 대소문자 구별)
		boolean boo = addr.equals(addr2); //addr2.equals(addr)
		if(boo) {
			System.out.println("addr and addr2 are same");
		}else {
			System.out.println("addr and addr2 are not same");
		}
		// equalsIgnoreCase() : 값을 비교해준다. (대소문자를 구별하지 않는다.
		if(addr.equalsIgnoreCase(addr2)) {
			System.out.println("same( 대소문자구별안함 )");
		}else {
			System.out.println("different( 대소문자구별안함 )");
		}
		
		String str = "A";
		str = str + "B";
		String str2 = str + 100;
		
		System.out.println("chartAt() -> " + addr.charAt(4)); //index위치의 문자를 반환한다.
		addr = addr.concat(name);
		System.out.println("concat() -> " + addr.concat(name)); //문자연결 
		
		String txt = "Hello!";
		byte txtCode[] = txt.getBytes();
		System.out.println(Arrays.toString(txtCode));
		
		int idx = addr.indexOf("a");
		System.out.println("index = "+idx);
		System.out.println("lastIndexOf = " + addr.lastIndexOf("a"));
		System.out.println("indexOf = " + addr.indexOf("a", 2));
		System.out.println("length = " + addr.length());
		System.out.println("repeat = " + addr.repeat(3));
		System.out.println("*".repeat(50));
		
		addr = addr.replaceAll("Oakland", "SanFrancisco");
		System.out.println("replaceAll = " + addr);
		
		String tel = "415-361-1326";
		String telSplit[] = tel.split("-");
		System.out.println(Arrays.toString(telSplit));
		
		// 01234567890123456789012345
		// SanFrancisco CalifJohn Lee
		// substring : 문자열에서 일부의 문자열을 얻을때 
		String sub1 = addr.substring(18, 22); //시작위치 18, 끝위치 21
		System.out.println("substring(int, int) = " +sub1);
		String sub2 = addr.substring(18); // 18부터 끝까지 구한
		System.out.println("substing(int) = " + sub2);
		
		System.out.println("lower = " + addr.toLowerCase());
		System.out.println("upper = " + addr.toUpperCase());
		
		//  "2500"                2500
		//  "5.3"
		String x = String.valueOf(2500);
		System.out.println(x);
		
		char c[] = {'J', 'O', 'H', 'N'}; //"JOHN"
		System.out.println(c);
		System.out.println(String.valueOf(c));
	
		int d[] = {23,45,67,88};
		System.out.println(d);
		
		String data = "			Test			Programing		";
		System.out.println("data = " + data.trim()+"?"); // 양쪽 끝의 공백문자를 지운
		
	}

}
