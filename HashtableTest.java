package basic05_collection;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashtableTest {

	public HashtableTest() {
		
	}
	public void start() {
		// Map: key와 value를 이용하여 객체를 사용한다.
		//		key 중복되면 안된다.
		
		Hashtable<String, MemberVO> ht = new Hashtable<String, MemberVO>();
		ht.put("1", new MemberVO(1000, "John Lee", "CEO","650-777-7777"));
		ht.put("A", new MemberVO(1000, "John Lee 2", "CEO","650-776-7777"));
		ht.put("Johny", new MemberVO(1000, "John Lee 3", "CEO","650-775-7777"));
		ht.put("B", new MemberVO(1000, "John Lee 4", "CEO","650-774-7777"));
		ht.put("420", new MemberVO(1000, "John Lee 5", "CEO","650-773-7777"));
		
		// 키를 이용하여 객체 얻어오기
		MemberVO vo1 = ht.get("420");
		System.out.println(vo1.toString());
		System.out.println("************************************");
		
		// key 목록 구하기
		Set<String> keyList= ht.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			String key = ii.next();
			MemberVO vo2 = ht.get(key);
			System.out.println(vo2.toString());
		}
		System.out.println("------------------------------------");
		
		// value 목록 구하기
		Collection<MemberVO> value = ht.values();
		Iterator<MemberVO> iii = value.iterator();
		while(iii.hasNext()) {
			System.out.println(iii.next().toString());
		}
	}

	public static void main(String[] args) {
		new HashtableTest().start();
	}

}
