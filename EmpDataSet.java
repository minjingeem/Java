package module;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class EmpDataSet {
	// 사원정보를 저장할 컬렉션을 선언
	public static HashMap<Integer, EmpVO> empList = new HashMap<Integer, EmpVO>(); // <____> 제너릭
	public EmpDataSet() {
		
	}
	public static void dataSet() {
		// 파일에 있는 Object를 구하여 HashMap에 세팅.
		try {
			File f = new File("/Users/minjinkim/testfolder/", "employee.txt");
			if(f.exists()) { // 파일이 있을 경
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				EmpDataSet.empList = (HashMap)ois.readObject(); //초기회원목록 
			}	
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
