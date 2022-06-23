package employees;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import module.EmpDataSet;
import module.EmpVO;

public class EmpStart {
	Scanner scan = new Scanner(System.in);
	public EmpStart() { // new EmpStart();는 이곳에서 실행된다.
		// 현재등록되어 있는 사원목록
		EmpDataSet.dataSet(); //초기 데이터 셋
		do {
			try {
				System.out.print(menu());
				int inMenu = Integer.parseInt(scan.nextLine());
				if(inMenu==5) {//종료
					empStop();
				}else if(inMenu == 1) { // 모든 사원목록 
					empListOutput();
					
				}else if(inMenu == 2) { // 사원등록
					empAdd();
				}else if(inMenu == 3) { // 사원수정  
					empEdit();
				}else if(inMenu == 4) { // 삭제 
					empDel();
				}else if(inMenu == 6) { // 이름으로 검색
					getNameSearch();
				}else {
					throw new Exception();
				}
			}catch (Exception e) {
				System.out.println("wrong menu input");
			}
		}while(true);
	} 
	// 사원 검색
	public void getNameSearch() {
		// 어떤사원을 검색할 것인지 이름을 입력받는다. 
		System.out.println("input Name for search -> ");
		String searchName = scan.nextLine();
		
		// vo
		Collection<EmpVO> list = EmpDataSet.empList.values();
		Iterator<EmpVO> ii = list.iterator();
		int cnt = 0;
		while(ii.hasNext()) {
			EmpVO v = ii.next();
			if(v.getEmpName().equals(searchName)) {
				System.out.println(v.toString());
				cnt++;
			}
		}
		System.out.println(cnt+"명이 검색되었습니다.");
	}
	// 사원 삭제
	public void empDel() {
		System.out.print("input ID number for delete -> ");
		int id = Integer.parseInt(scan.nextLine());
		EmpDataSet.empList.remove(id); //객체지워짐. 
		System.out.println(id+" information successfully deleted.");
		
	}
	// 사원수정
	public void empEdit() {
		// 어떤사원을 수정할것인지 입력받는다.
		System.out.print("input ID number for edit -> ");
		int editID = Integer.parseInt(scan.nextLine());
		
		System.out.print("edit list [1.department, 2.phone number] -> " );
		String editMenu = scan.nextLine();
		if(editMenu.equals("1")) { //부서수정  
			departmentEdit(editID);
		}else if(editMenu.equals("2")) { // 연락처수정
			telEdit(editID);
			
		}else {
			System.out.println("select wrong edit menu.");
		}
		
	}
	// 부서명 수정
	public void departmentEdit(int id) {
		EmpVO vo = EmpDataSet.empList.get(id);
		System.out.print("new department -> ");
		String editDepartmentName = scan.nextLine();
		vo.setDepartment(editDepartmentName); //부서명이 변경됨.
		System.out.println(vo.getId()+" department successfully updeated to " +vo.getDepartment());
	}
	// 연락처 수정  
	public void telEdit(int id) {
		EmpVO vo = EmpDataSet.empList.get(id);
		System.out.print("new phone number -> ");
		vo.setTel(scan.nextLine());
		System.out.println(vo.getId()+" phone number successfully updated to " + vo.getTel());
	}
	
	//사원목록 
	public void empListOutput() {
		titlePrint(); //제목출력
		// map의 모든 value(vo객체)를 구하여 목력을 출력한다.
		Collection<EmpVO> emp = EmpDataSet.empList.values();
		Iterator<EmpVO> i = emp.iterator();
		
		while(i.hasNext()) {
			EmpVO v = i.next();
			System.out.println(v.toString());
		}
		
		
	} 
	public void titlePrint() {
		System.out.println("ID\tName\tDepartment\tPhone");
	}
	//사원등록 
	public void empAdd() {
		EmpVO vo = new EmpVO(); // 입력받은 사원정보를 저장할 vo
		System.out.print("Employee ID -> ");
		vo.setId(Integer.parseInt(scan.nextLine()));
		System.out.print("Name -> ");
		vo.setEmpName(scan.nextLine());
		System.out.print("Department -> ");
		vo.setDepartment(scan.nextLine());
		System.out.print("Phone -> ");
		vo.setTel(scan.nextLine());
		
		// 컬렉션에 vo를 추가  (사원 한명을 추가한다는 의미)
		EmpDataSet.empList.put(vo.getId(), vo);
		System.out.println("사원이 등록되었습니다.");
	}
	// 종료 
	public void empStop() {
		try {
			// 사원정보가 있는 empList를 파일로 저장하고 종료.
			File f = new File("/Users/minjinkim/testfolder/", "employee.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(EmpDataSet.empList);
			
			oos.close();
			fos.close();
		
		}catch(Exception e) {
			System.out.println("employee file saving error!!" + e.getMessage());
			e.printStackTrace();
		}	
		System.exit(0);
	}
	public String menu() {
		return "Menu[1. Employee List, 2. Add, 3. Edit, 4. Delete, 5. End, 6. Search] -> ";
	}
	public static void main(String[] args) {
		new EmpStart();

	}

}
