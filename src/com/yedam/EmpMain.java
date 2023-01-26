package com.yedam;


import java.util.List;
import java.util.Scanner;



public class EmpMain {
	static EmpDAO dao = new EmpDAO();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		while (true) {
			System.out.println("1-목록조회 2-단건조회 3-입력 4-급여수정 5-삭제  9-종료");
			int menu = sc.nextInt();

			if (menu == 5) { // 사원번호, 급여 입력. updateEmp(int id,int sal)
			 delete();
			}

			else if (menu == 4) { // 사원번호, 급여 입력. updateEmp(int id,int sal)
				modify();
			}

			else if (menu == 3) {
				Add();

			} else if (menu == 2) {
				// 단건조회
				search();
			} else if (menu == 1) {
				// 목록조회
//					List<Map<String, Object>> result = dao.emplist();// 반환유형.
//				
//				for (Map)<String, Object> map : result) {
//					System.out.println("사원번호: " + map.get("emp_id")+
//					"이름: "+map.get("first_name")+"-"+map.get("last_name"));
//				}
				list();
//				
			} else if (menu == 9) {
				// 종료.
				break;
			}

			// end of while()

//
		}
		System.out.println("end");

	}
	//삭제
	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("id>>");
		int id = sc.nextInt();
		sc.nextLine();

		if (dao.deleteEmp(id) > 0) {
			System.out.println("sucess");
		} else {
			System.out.println("fucking error");
		}
	}
	private static void modify() {
		// TODO Auto-generated method stub
		System.out.println("id>>");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("급여>");
		int sal = sc.nextInt();
		if (dao.updateEmp(id, sal) > 0) {
			System.out.println("sucess");
		} else {
			System.out.println("fucking error");
		}
	}
	//추가
	private static void Add() {
		// TODO Auto-generated method stub
		// 입력처리. :=> 사번, last_name,email,입사일짜,work
		System.out.println("사번입력>> ");
		int eid = sc.nextInt();
		sc.nextLine();
		System.out.println("이름>>>");
		String name = sc.nextLine();
		System.out.println("이메일>>>");
		String email = sc.nextLine();
		System.out.println("입사일자>>>");
		String date = sc.nextLine();
		System.out.println("직무>>>");
		String job = sc.nextLine();

		EmpVO emp = new EmpVO();
		emp.setEmployeedId(eid);
		emp.setLastname(name);
		emp.setEmail(email);
		emp.setHireDate(date);
		emp.setJobId(job);

		if (dao.addEmp(emp) > 0) {
			System.out.println("sucess");

		} else {
			System.out.println("fucking error");
		}
	}
	//검색
	private static void search() {
		// TODO Auto-generated method stub
		System.out.println("조회사원번호 입력>>");
		int id = sc.nextInt();
		// 사용자 입력값을 받아서 처리

		// 사용자 입력값을 받아서 처리.

		EmpVO emp = dao.getEmp(id);
		System.out.println("result: " + emp);
		if (emp == null) {
			System.out.println("조회된 정보 없습니다");
			
		} // 반환유형:EmpVO
	}
	
	//조회
	public static void list() { // static메소드 or 인스턴스메소드.
//		List<Map<String, Object>> result = dao.empList(); // 반환유형.
//		for (Map<String, Object> map : result) {
//			System.out.println("사원번호: " + map.get("emp_id") //
//					+ ", 이름: " + map.get("first_name") + "-" + map.get("last_name")//
//					+ ", 급여: " + map.get("salary")//
//			);
//		}

		List<EmpVO> list = dao.empVoList();
		for (EmpVO emp : list) {
			System.out.println(emp.toString());
		}
	}
}
// 단건조회.search()

// 입력.add()

// 수정 .modify();

// 삭제 . delete();