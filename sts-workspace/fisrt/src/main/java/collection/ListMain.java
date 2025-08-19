package collection;

import java.util.ArrayList;

class Employee {
	int id;
	String name;
	double salary;
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "사번: " + id + " 이름: " + name + " 급여: " + salary;
	}
}



class EmployeeManager {
	// 회사원 리스트
	ArrayList<Employee> getEmployees() {
		
		// Employee 객체 5명 - 1개 타입(배열, java.util.List, Map, Set) 리턴
		
		// #1. 배열
		// Employee[] e = new Employee[5]; // 개수가 정해져있지 않기에 비추천
		
		// #2. ArrayList 
		// (동적으로 메모리 증감, 모든 클래스타입 저장 가능)
		// 최초 2개 생성
		ArrayList<Employee> empList = new ArrayList<>(2);
		
		empList.add(new Employee(100, "1사원", 60000.99));
		empList.add(new Employee(200, "2사원", 60000.99));
		empList.add(new Employee(300, "3사원", 60000.99));
		empList.add(new Employee(400, "4사원", 60000.99));
		empList.add(new Employee(500, "5사원", 60000.99));
		
		return empList;
	}
}

public class ListMain {

	public static void main(String[] args) {
		EmployeeManager manager = new EmployeeManager();
		ArrayList<Employee> empList = manager.getEmployees();
		
		for (Employee emp : empList) {
			System.out.println(emp);
		}
	}
}



//class A {
//	B b1 = new B(); // 의존. NON-IOC
//}
//
//class A2 { // 의존. IOC. 외부에서 객체를 전달받는다(== '매개변수'로 전달받는다)
//	B b1;
//	A2(B b1) {
//		this.b1 = b1;
//	}
//}
//
//class Main {
////	...
//	A2 a = new A2(new B());
//}