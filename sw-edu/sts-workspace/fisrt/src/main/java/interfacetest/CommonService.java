package interfacetest;
class A{
	// 변수
	String name = "sds";
	
	// 메소드 - 이름 선언, 내용 구현
	// test 메소드가 실행되면 'sds잠실'로 바뀐다
	void test() {
		name = "sds잠실";
	}
}


// 서로 다른 여러 개 클래스들 공통적 기능 구현해야 한다 (닫혀있다. 제약)
// 공통 구현 구체적 방법 다르다 (개방)
// 공통 기능 명세서
interface Shape {
	void area();
	
//	void area() {
//		// 도형의 종류에 따라, 가로 * 세로, 밑변 * 높이 / 2
//		// => 도형 모양이 다양해서 구체적 구현 어렵다
//		
//		// 모든 도형은 면적을 구하는 메소드 제공해야 한다
//		
//	};
}

//class Rectangle implements Shape {
//	// 자동 포함(Shape에 있는 것 다 가져온다)
//	void area() {
//		// 가로 * 세로
//	};
//}



// 제약이 있음
public interface CommonService {
	// 상수(불변)
	String name = "sds";
			
	// final: 상수 선언(더 이상 수정 불가능)
	// interface에서는 final을 선언하지 않아도 선언한 것과 동일하다
//	final String name = "sds";
	
	// 메소드 - 이름 선언 , (내용 구현 X)
	// commonService를 상속받은 클래스가 반드시 구현해야 하는 메소드
	abstract public String getServiceName();
	String printServiceName(String name);
	
	// abstract이라는 키워드를 붙여야 하지만, 생략해도 동일 의미
//	void test();
//	abstract void test();
	
	// wrong case 1
//	void test() {}
	
	// wrong case 2
	// Abstract methods do not specify a body
//	void test() {
//		name = "sds잠실";
//	}
}

class MemberService implements CommonService {

	@Override
	public String getServiceName() {
		return "MemberService";
	}

	@Override
	public String printServiceName(String name) {
		// TODO Auto-generated method stub
		return "[MEMBERSERVICE] 회원 서비스 " + name;
	}
}


class BoardService implements CommonService {

	@Override
	public String getServiceName() {
		return "BoardService";
	}

	@Override
	public String printServiceName(String name) {
		// TODO Auto-generated method stub
		return "[BOARDSERVICE] 게시판 서비스 " + name;
	}
	
}

class ReservationService implements CommonService {

	@Override
	public String getServiceName() {
		return "ReservationService";
	}

	@Override
	public String printServiceName(String name) {
		// TODO Auto-generated method stub
		return "[RESERVARIONSERVICE] 게스트하우스 예약 서비스 " + name;
	}
}

class TheOtherService implements CommonService {

	@Override
	public String getServiceName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String printServiceName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

